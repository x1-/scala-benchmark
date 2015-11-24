package com.inkenkun.x1.scala.benchmark

import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State( Scope.Benchmark )
class DpushImmutableArray {

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

  import arrayImplicits._
  ListMonoid
  VectorMonoid
  StreamMonoid

  @Benchmark
  def append$List$1k:     List[Int] = appendCollection[List]( n1k )

  @Benchmark
  def append$List$10k:    List[Int] = appendCollection[List]( n10k )

  @Benchmark
  def append$List$100k:   List[Int] = appendCollection[List]( n100k )

  @Benchmark
  def insert$List$1k:     List[Int] = insertCollection[List]( n1k )

  @Benchmark
  def insert$List$10k:    List[Int] = insertCollection[List]( n10k )

  @Benchmark
  def insert$List$100k:   List[Int] = insertCollection[List]( n100k )

  @Benchmark
  def reallocation$List$1k:   List[Int] = reallocation[List]( list100k, n1k )

  @Benchmark
  def reallocation$List$10k:  List[Int] = reallocation[List]( list100k, n10k )

  @Benchmark
  def reallocation$List$100k: List[Int] = reallocation[List]( list100k, n100k )

  @Benchmark
  def append$Vector$1k:   Vector[Int] = appendCollection[Vector]( n1k )

  @Benchmark
  def append$Vector$10k:  Vector[Int] = appendCollection[Vector]( n10k )

  @Benchmark
  def append$Vector$100k: Vector[Int] = appendCollection[Vector]( n100k )

  @Benchmark
  def insert$Vector$1k:   Vector[Int] = insertCollection[Vector]( n1k )

  @Benchmark
  def insert$Vector$10k:  Vector[Int] = insertCollection[Vector]( n10k )

  @Benchmark
  def insert$Vector$100k: Vector[Int] = insertCollection[Vector]( n100k )

  @Benchmark
  def reallocation$Vector$1k:   Vector[Int] = reallocation[Vector]( vector100k, n1k )

  @Benchmark
  def reallocation$Vector$10k:  Vector[Int] = reallocation[Vector]( vector100k, n10k )

  @Benchmark
  def reallocation$Vector$100k: Vector[Int] = reallocation[Vector]( vector100k, n100k )

  @Benchmark
  def append$Stream$1k:   Stream[Int] = appendCollection[Stream]( n1k )

  @Benchmark
  def append$Stream$10k:  Stream[Int] = appendCollection[Stream]( n10k )

  @Benchmark
  def append$Stream$100k: Stream[Int] = appendCollection[Stream]( n100k )

  @Benchmark
  def insert$Stream$1k:   Stream[Int] = insertCollection[Stream]( n1k )

  @Benchmark
  def insert$Stream$10k:  Stream[Int] = insertCollection[Stream]( n10k )

  @Benchmark
  def insert$Stream$100k: Stream[Int] = insertCollection[Stream]( n100k )

  @Benchmark
  def reallocation$Stream$1k:   Stream[Int] = reallocation[Stream]( stream100k, n1k )

  @Benchmark
  def reallocation$Stream$10k:  Stream[Int] = reallocation[Stream]( stream100k, n10k )

  @Benchmark
  def reallocation$Stream$100k: Stream[Int] = reallocation[Stream]( stream100k, n100k )

  @Benchmark
  def init$List$100k:   List[Int]   = ( for { i <- 1 to n100k } yield i ).toList
  @Benchmark
  def init$Vector$100k: Vector[Int] = ( for { i <- 1 to n100k } yield i ).toVector
  @Benchmark
  def init$Stream$100k: Stream[Int] = ( for { i <- 1 to n100k } yield i ).toStream

  private[benchmark] def appendCollection[M[_] <: Seq[_]](n: Int )(implicit m: Monoid[M, Int] ): M[Int] = {
    var xs = m.empty
    for ( i <- 1 to n ) {
      xs = m.append( xs, i )
    }
    xs
  }

  private[benchmark] def insertCollection[M[_] <: Seq[_]](n: Int )(implicit m: Monoid[M, Int] ): M[Int] = {
    var xs = m.empty
    for ( i <- 1 to n ) {
      xs = m.insert( xs, i )
    }
    xs
  }

  private[benchmark] def reallocation[M[_] <: Seq[_]]( origin: M[Int], n: Int )( implicit m: Monoid[M, Int] ): M[Int] = {
    var xs = m.empty
    for ( i <- 1 to n ) {
      xs = origin
    }
    xs
  }
}
