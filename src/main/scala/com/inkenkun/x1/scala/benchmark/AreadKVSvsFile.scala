package com.inkenkun.x1.scala.benchmark

import java.io.RandomAccessFile
import java.nio.channels.FileChannel.MapMode
import java.nio.MappedByteBuffer

import scala.concurrent.ExecutionContext.Implicits.{global => ec}

import com.redis._
import shade.memcached._
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State( Scope.Benchmark )
class AreadKVSvsFile {

  val keyword = "SUIKA"

  val memkeys    = 0 to 60862
  val rediskeys1 = 0 to 60862
  val rediskeys2 = 100000 to 100003

  @Benchmark
  def memcache$34k: Int = searchFromKVS( keyword, memkeys, { s: String => MemcachedReader.get( s ) } )

  @Benchmark
  def redis$34k: Int = searchFromKVS( keyword, rediskeys1, { s: String => RedisReader.get( s ) } )

  @Benchmark
  def redis$500m: Int = searchFromKVS( keyword, rediskeys2, { s: String => RedisReader.get( s ) } )

  @Benchmark
  def file$2g: Int = searchFromFile( "/data/json.txt", keyword )

  private[benchmark] def searchFromKVS( search: String, keys: Range, f: ( String => Option[String] ) ): Int = {
    keys.foldLeft( 0 ) { ( acc, n ) =>
      val count = f( n toString ) map { s =>
        searchWord( s, search )
      } getOrElse 0
      acc + count
    }
  }

  private[benchmark] def searchFromFile( path: String, search: String ): Int =
    useReader( path ) { reader =>
      var sum = 0
      while ( reader.hasNext ) {
        val sliceCount = searchWord( new String( reader.getNext ), search )
        sum += sliceCount
      }
      sum
    }

  private[benchmark] def searchWord( text: String, search: String, sum: Int = 0 ): Int = {
    var sum = 0
    var pos = 0
    do {
      pos = text.indexOf( search, pos )
      if ( pos >= 0 ) {
        sum += 1
        pos += 1
      }
    } while ( pos >= 0 )
    sum
  }

  private[benchmark] def useReader[T]( path: String )( f: ( MemoryMappedFileReader => T ) ): T = {
    val reader = MemoryMappedFileReader( path )
    val r = f( reader )
    reader.close()
    r
  }

  case class MemoryMappedFileReader( path: String ) {
    val chunkSize = 1024 * 10  // 10k
    val channel = new RandomAccessFile( path, "r" ).getChannel
    val size = channel.size

    val mapped: MappedByteBuffer = channel.map(
      MapMode.READ_ONLY,
      0,
      math.min( channel.size, java.lang.Integer.MAX_VALUE )
    )
    val buffer = mapped.order( java.nio.ByteOrder.nativeOrder )

    def close(): Unit = channel.close()

    def hasNext: Boolean = buffer.hasRemaining

    def getNext: Array[Byte] = {
      val b = new Array[Byte]( chunkSize min buffer.remaining )
      buffer.get( b )
      b
    }
  }
  object MemcachedReader {
    val memcached = Memcached( Configuration( "127.0.0.1:11211" ), ec )

    def get( key: String ): Option[String] =
      memcached.awaitGet[String]( key )
  }
  object RedisReader {
    val redis = new RedisClient( "127.0.0.1", 6379 )

    def get( key: String ): Option[String] =
      redis.get[String]( key )
  }
}
