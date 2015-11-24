package com.inkenkun.x1.scala.benchmark

import scala.util.Random
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State( Scope.Benchmark )
class FreadImmutableArray {

  val   n1k = 10 * 10 * 10
  val  n10k = 10 * 10 * 10 * 10
  val n100k = 10 * 10 * 10 * 10 * 10

  val list1k     = List( 1 to   n1k : _* )
  val list10k    = List( 1 to  n10k : _* )
  val list100k   = List( 1 to n100k : _* )

  val vector1k   = Vector( 1 to   n1k : _* )
  val vector10k  = Vector( 1 to  n10k : _* )
  val vector100k = Vector( 1 to n100k : _* )

  val stream1k   = Stream( 1 to   n1k : _* )
  val stream10k  = Stream( 1 to  n10k : _* )
  val stream100k = Stream( 1 to n100k : _* )

  val array1k    = Array( 1 to   n1k : _* )
  val array10k   = Array( 1 to  n10k : _* )
  val array100k  = Array( 1 to n100k : _* )

  @Benchmark
  def randomRead$List$1k:     IndexedSeq[Any] = randomRead( list1k )

  @Benchmark
  def randomRead$List$10k:    IndexedSeq[Any] = randomRead( list10k )

  @Benchmark
  def randomRead$List$100k:   IndexedSeq[Any] = randomRead( list100k )

  @Benchmark
  def randomRead$Vector$1k:   IndexedSeq[Any] = randomRead( vector1k )

  @Benchmark
  def randomRead$Vector$10k:  IndexedSeq[Any] = randomRead( vector10k )

  @Benchmark
  def randomRead$Vector$100k: IndexedSeq[Any] = randomRead( vector100k )

  @Benchmark
  def randomRead$Stream$1k:   IndexedSeq[Any] = randomRead( stream1k )

  @Benchmark
  def randomRead$Stream$10k:  IndexedSeq[Any] = randomRead( stream10k )

  @Benchmark
  def randomRead$Stream$100k: IndexedSeq[Any] = randomRead( stream100k )

  @Benchmark
  def randomRead$Array$1k:    IndexedSeq[Any] = randomReadArray( array1k )

  @Benchmark
  def randomRead$Array$10k:   IndexedSeq[Any] = randomReadArray( array10k )

  @Benchmark
  def randomRead$Array$100k:  IndexedSeq[Any] = randomReadArray( array100k )


  private[benchmark] def randomRead[M[_] <: Seq[_]]( data: M[Int] ): IndexedSeq[Any] = {
    val n = data.size
    Random.setSeed( 666 )

    ( 1 to n ) map { _ => data( Random.nextInt( n ) ) }

  }

  private[benchmark] def randomReadArray( data: Array[Int] ): IndexedSeq[Any] = {
    val n = data.size
    Random.setSeed( 666 )

    ( 1 to n ) map { _ => data( Random.nextInt( n ) ) }
  }

}
