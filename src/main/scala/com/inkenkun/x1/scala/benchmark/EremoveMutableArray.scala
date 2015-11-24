package com.inkenkun.x1.scala.benchmark

import scala.collection.{ mutable => mu }
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State( Scope.Benchmark )
class EremoveMutableArray {
  
  val   n1k = 10 * 10 * 10
  val  n10k = 10 * 10 * 10 * 10
  val n100k = 10 * 10 * 10 * 10 * 10

  val arrayBuf1k    = ArrayBuffer( 1 to   n1k : _* )
  val arrayBuf10k   = ArrayBuffer( 1 to  n10k : _* )
  val arrayBuf100k  = ArrayBuffer( 1 to n100k : _* )

  val listBuf1k     = ListBuffer( 1 to   n1k : _* )
  val listBuf10k    = ListBuffer( 1 to  n10k : _* )
  val listBuf100k   = ListBuffer( 1 to n100k : _* )

  @Benchmark
  def removeHead$ArrayBuffer$1k:     ArrayBuffer[Int] = removeHeadCollection[ArrayBuffer]( arrayBuf1k )

  @Benchmark
  def removeHead$ArrayBuffer$10k:    ArrayBuffer[Int] = removeHeadCollection[ArrayBuffer]( arrayBuf10k )

  @Benchmark
  def removeHead$ArrayBuffer$100k:   ArrayBuffer[Int] = removeHeadCollection[ArrayBuffer]( arrayBuf100k )

  @Benchmark
  def removeTail$ArrayBuffer$1k:     ArrayBuffer[Int] = removeTailCollection[ArrayBuffer]( arrayBuf1k )

  @Benchmark
  def removeTail$ArrayBuffer$10k:    ArrayBuffer[Int] = removeTailCollection[ArrayBuffer]( arrayBuf10k )

  @Benchmark
  def removeTail$ArrayBuffer$100k:   ArrayBuffer[Int] = removeTailCollection[ArrayBuffer]( arrayBuf100k )

  @Benchmark
  def removeHead$ListBuffer$1k:      ListBuffer[Int]  = removeHeadCollection[ListBuffer]( listBuf1k )

  @Benchmark
  def removeHead$ListBuffer$10k:     ListBuffer[Int]  = removeHeadCollection[ListBuffer]( listBuf10k )

  @Benchmark
  def removeHead$ListBuffer$100k:    ListBuffer[Int]  = removeHeadCollection[ListBuffer]( listBuf100k )

  @Benchmark
  def removeTail$ListBuffer$1k:      ListBuffer[Int]  = removeTailCollection[ListBuffer]( listBuf1k )

  @Benchmark
  def removeTail$ListBuffer$10k:     ListBuffer[Int]  = removeTailCollection[ListBuffer]( listBuf10k )

  @Benchmark
  def removeTail$ListBuffer$100k:    ListBuffer[Int]  = removeTailCollection[ListBuffer]( listBuf100k )

  private[benchmark] def removeHeadCollection[M[_] <: mu.Buffer[_]](data: M[Int], num: Option[Int] = None ): M[Int] = {
    val xs = data
    val n = num.getOrElse( xs.size )

    for ( _ <- 1 to n ) {
      xs.remove( 0 )
    }
    xs
  }

  private[benchmark] def removeTailCollection[M[_] <: mu.Buffer[_]](data: M[Int], num: Option[Int] = None ): M[Int] = {
    val xs = data
    val start = xs.size - 1
    val end   = xs.size - num.getOrElse( xs.size )

    for ( i <- start to end by -1 ) {
      xs.remove( i )
    }
    xs
  }
}
