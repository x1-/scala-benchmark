package com.inkenkun.x1.scala.benchmark

import scala.collection.{ mutable => mu }
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State( Scope.Benchmark )
class DpushMutableArray {
  
  val   n1k = 10 * 10 * 10
  val  n10k = 10 * 10 * 10 * 10
  val n100k = 10 * 10 * 10 * 10 * 10

  import arrayImplicits._
  ArrayBufferMonoid
  ListBuffer

  @Benchmark
  def append$ArrayBuffer$1k:   ArrayBuffer[Int] = appendCollection[ArrayBuffer]( n1k )

  @Benchmark
  def append$ArrayBuffer$10k:  ArrayBuffer[Int] = appendCollection[ArrayBuffer]( n10k )

  @Benchmark
  def append$ArrayBuffer$100k: ArrayBuffer[Int] = appendCollection[ArrayBuffer]( n100k )

  @Benchmark
  def insert$ArrayBuffer$1k:   ArrayBuffer[Int] = insertCollection[ArrayBuffer]( n1k )

  @Benchmark
  def insert$ArrayBuffer$10k:  ArrayBuffer[Int] = insertCollection[ArrayBuffer]( n10k )

  @Benchmark
  def insert$ArrayBuffer$100k: ArrayBuffer[Int] = insertCollection[ArrayBuffer]( n100k )

  @Benchmark
  def append$ListBuffer$1k:    ListBuffer[Int] = appendCollection[ListBuffer]( n1k )

  @Benchmark
  def append$ListBuffer$10k:   ListBuffer[Int] = appendCollection[ListBuffer]( n10k )

  @Benchmark
  def append$ListBuffer$100k:  ListBuffer[Int] = appendCollection[ListBuffer]( n100k )

  @Benchmark
  def insert$ListBuffer$1k:    ListBuffer[Int] = insertCollection[ListBuffer]( n1k )

  @Benchmark
  def insert$ListBuffer$10k:   ListBuffer[Int] = insertCollection[ListBuffer]( n10k )

  @Benchmark
  def insert$ListBuffer$100k:  ListBuffer[Int] = insertCollection[ListBuffer]( n100k )


  private[benchmark] def appendCollection[M[_] <: mu.Buffer[_]](n: Int )(implicit m: Monoid[M, Int] ): M[Int] = {
    val xs = m.empty
    for ( i <- 1 to n ) {
      m.append( xs, i )
    }
    xs
  }

  private[benchmark] def insertCollection[M[_] <: mu.Buffer[_]](n: Int )(implicit m: Monoid[M, Int] ): M[Int] = {
    val xs = m.empty
    for ( i <- 1 to n ) {
      m.insert( xs, i )
    }
    xs
  }
}
