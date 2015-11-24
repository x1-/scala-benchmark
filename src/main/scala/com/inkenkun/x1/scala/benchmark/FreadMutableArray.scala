package com.inkenkun.x1.scala.benchmark

import scala.collection.{ mutable => mu }
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.Random
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State( Scope.Benchmark )
class FreadMutableArray {

  val   n1k = 10 * 10 * 10
  val  n10k = 10 * 10 * 10 * 10
  val n100k = 10 * 10 * 10 * 10 * 10

  val arrayBuf1k    = ArrayBuffer( 1 to   n1k toSeq: _* )
  val arrayBuf10k   = ArrayBuffer( 1 to  n10k toSeq: _* )
  val arrayBuf100k  = ArrayBuffer( 1 to n100k toSeq: _* )

  val listBuf1k     = ListBuffer( 1 to   n1k toSeq: _* )
  val listBuf10k    = ListBuffer( 1 to  n10k toSeq: _* )
  val listBuf100k   = ListBuffer( 1 to n100k toSeq: _* )


  @Benchmark
  def randomRead$ArrayBuffer$1k:   IndexedSeq[Any] = randomRead( arrayBuf1k )

  @Benchmark
  def randomRead$ArrayBuffer$10k:  IndexedSeq[Any] = randomRead( arrayBuf10k )

  @Benchmark
  def randomRead$ArrayBuffer$100k: IndexedSeq[Any] = randomRead( arrayBuf100k )

  @Benchmark
  def randomRead$ListBuffer$1k:    IndexedSeq[Any] = randomRead( listBuf1k )

  @Benchmark
  def randomRead$ListBuffer$10k:   IndexedSeq[Any] = randomRead( listBuf10k )

  @Benchmark
  def randomRead$ListBuffer$100k:  IndexedSeq[Any] = randomRead( listBuf100k )


  private[benchmark] def randomRead[M[_] <: mu.Buffer[_]]( data: M[Int] ): IndexedSeq[Any] = {
    val n = data.size
    Random.setSeed( 666 )

    for ( _ <- 1 to n )
      yield
        data( Random.nextInt( n ) )
  }
}
