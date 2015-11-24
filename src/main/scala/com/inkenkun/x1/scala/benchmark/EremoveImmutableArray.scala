package com.inkenkun.x1.scala.benchmark

import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State( Scope.Benchmark )
class EremoveImmutableArray {
  
  val   n10 = 10
  val  n100 = 10 * 10
  val   n1k = 10 * 10 * 10
  val  n10k = 10 * 10 * 10 * 10
  val n100k = 10 * 10 * 10 * 10 * 10

  val list10     = List( 1 to   n10 : _* )
  val list100    = List( 1 to  n100 : _* )
  val list1k     = List( 1 to   n1k : _* )
  val list10k    = List( 1 to  n10k : _* )
  val list100k   = List( 1 to n100k : _* )

  val vector1k   = Vector( 1 to   n1k : _* )
  val vector10k  = Vector( 1 to  n10k : _* )
  val vector100k = Vector( 1 to n100k : _* )

  val stream1k   = Stream( 1 to   n1k : _* )
  val stream10k  = Stream( 1 to  n10k : _* )
  val stream100k = Stream( 1 to n100k : _* )

  import arrayImplicits._
  ListMonoid
  VectorMonoid
  StreamMonoid

  @Benchmark
  def removeHead$List$1k:     List[Int] = removeHeadCollection[List]( list1k )

  @Benchmark
  def removeHead$List$10k:    List[Int] = removeHeadCollection[List]( list10k )

  @Benchmark
  def removeHead$List$100k:   List[Int] = removeHeadCollection[List]( list100k )

  @Benchmark
  def removeTail$List$10:     List[Int] = removeTailCollection[List]( list10 )

  @Benchmark
  def removeTail$List$100:    List[Int] = removeTailCollection[List]( list100 )

  @Benchmark
  def removeTail$List$1k:     List[Int] = removeTailCollection[List]( list1k )

  @Benchmark
  def removeTail$List$10k:    List[Int] = removeTailCollection[List]( list10k )

  @Benchmark
  def removeTail$List$100k:   List[Int] = removeTailCollection[List]( list100k )

  @Benchmark
  def take$List$1k:           List[Int] = takeCollection[List]( list1k )

  @Benchmark
  def take$List$10k:          List[Int] = takeCollection[List]( list10k )

  @Benchmark
  def take$List$100k:         List[Int] = takeCollection[List]( list100k )

  @Benchmark
  def removeHead$Vector$1k:   Vector[Int] = removeHeadCollection[Vector]( vector1k )

  @Benchmark
  def removeHead$Vector$10k:  Vector[Int] = removeHeadCollection[Vector]( vector10k )

  @Benchmark
  def removeHead$Vector$100k: Vector[Int] = removeHeadCollection[Vector]( vector100k )

  @Benchmark
  def removeTail$Vector$1k:   Vector[Int] = removeTailCollection[Vector]( vector1k )

  @Benchmark
  def removeTail$Vector$10k:  Vector[Int] = removeTailCollection[Vector]( vector10k )

  @Benchmark
  def removeTail$Vector$100k: Vector[Int] = removeTailCollection[Vector]( vector100k )

  @Benchmark
  def take$Vector$1k:         Vector[Int] = takeCollection[Vector]( vector1k )

  @Benchmark
  def take$Vector$10k:        Vector[Int] = takeCollection[Vector]( vector10k )

  @Benchmark
  def take$Vector$100k:       Vector[Int] = takeCollection[Vector]( vector100k )

  @Benchmark
  def removeHead$Stream$1k:   Stream[Int] = removeHeadCollection[Stream]( stream1k )

  @Benchmark
  def removeHead$Stream$10k:  Stream[Int] = removeHeadCollection[Stream]( stream10k )

  @Benchmark
  def removeHead$Stream$100k: Stream[Int] = removeHeadCollection[Stream]( stream100k )

  @Benchmark
  def removeTail$Stream$1k:   Stream[Int] = removeTailCollection[Stream]( stream1k )

  @Benchmark
  def removeTail$Stream$10k:  Stream[Int] = removeTailCollection[Stream]( stream10k )

  @Benchmark
  def removeTail$Stream$100k: Stream[Int] = removeTailCollection[Stream]( stream100k )

  @Benchmark
  def take$Stream$1k:         Stream[Int] = takeCollection[Stream]( stream1k )

  @Benchmark
  def take$Stream$10k:        Stream[Int] = takeCollection[Stream]( stream10k )

  @Benchmark
  def take$Stream$100k:       Stream[Int] = takeCollection[Stream]( stream100k )

  private[benchmark] def removeHeadCollection[M[_] <: Seq[_]](data: M[Int], num: Option[Int] = None )(implicit m: Monoid[M, Int] ): M[Int] = {
    var xs = data
    val n = num.getOrElse( xs.size )

    for ( i <- 1 to n ) {
      xs = m.removeHead( xs )
    }
    xs
  }

  private[benchmark] def removeTailCollection[M[_] <: Seq[_]](data: M[Int], num: Option[Int] = None )(implicit m: Monoid[M, Int] ): M[Int] = {
    var xs = data
    val n = num.getOrElse( xs.size )

    for ( i <- 1 to n ) {
      xs = m.removeTail( xs )
    }
    xs
  }

  private[benchmark] def takeCollection[M[_] <: Seq[_]](data: M[Int], num: Option[Int] = None )(implicit m: Monoid[M, Int] ): M[Int] = {
    var xs = data
    val n = num.getOrElse( xs.size )

    for ( i <- 1 to n ) {
      xs = m.take( xs )
    }
    xs
  }
}
