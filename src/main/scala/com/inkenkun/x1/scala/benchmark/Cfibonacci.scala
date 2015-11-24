package com.inkenkun.x1.scala.benchmark

import scala.collection.mutable.ArrayBuffer
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State( Scope.Benchmark )
class Cfibonacci {

  val   n1k = 10 * 10 * 10
  val  n10k = 10 * 10 * 10 * 10
  val n100k = 10 * 10 * 10 * 10 * 10

  @Benchmark
  def stream$1k   = streamFibonacci().take( n1k )

  @Benchmark
  def stream$10k  = streamFibonacci().take( n10k )

  @Benchmark
  def stream$100k = streamFibonacci().take( n100k )

  @Benchmark
  def streamReal$1k   = streamFibonacci().take( n1k ) toList

  @Benchmark
  def streamReal$10k  = streamFibonacci().take( n10k ) toList

  @Benchmark
  def streamReal$100k = streamFibonacci().take( n100k ) toList

  @Benchmark
  def arrayBuffer$1k   = arrayBufferFibonacci( n1k )

  @Benchmark
  def arrayBuffer$10k  = arrayBufferFibonacci( n10k )

  @Benchmark
  def arrayBuffer$100k = arrayBufferFibonacci( n100k )

  @Benchmark
  def array$1k   = arrayFibonacci( n1k )

  @Benchmark
  def array$10k  = arrayFibonacci( n10k )

  @Benchmark
  def array$100k = arrayFibonacci( n100k )

  /**
   * using Stream and lazy evaluation.
   */
  private[benchmark] def streamFibonacci(h: Int = 1, n: Int = 1 ): Stream[Int] =
    h #:: streamFibonacci( n, h + n )

  /**
   * using ArrayBuffer and Dynamic Planning.
   * @param n array size.
   * @return
   */
  private[benchmark] def arrayBufferFibonacci(n: Int = 1 ): ArrayBuffer[Int] = if ( n == 0 ) {
    ArrayBuffer.empty[Int]
  } else {
    val b = ArrayBuffer( 1 )

    for ( i <- 0 until n - 1 ) {
      val n1  = if ( i == 0 ) 0 else b( i - 1 )
      val n2  = b( i )
      b +=  n1 + n2
    }
    b
  }

  /**
    * using Array and Dynamic Planning.
    * @param n array size.
    * @return
    */
  private[benchmark] def arrayFibonacci(n: Int = 1 ): Array[Int] = if ( n == 0 ) {
    Array.empty[Int]
  } else {
    val b = new Array[Int](n)
    b(0) = 1

    for ( i <- 0 until n - 1 ) {
      val n1  = if ( i == 0 ) 0 else b( i - 1 )
      val n2  = b( i )
      b( i + 1 ) =  n1 + n2
    }
    b
  }
}
