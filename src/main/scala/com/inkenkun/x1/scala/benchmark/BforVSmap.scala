package com.inkenkun.x1.scala.benchmark

import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State( Scope.Benchmark )
class BforVSmap {

  val   n1k = 10 * 10 * 10
  val  n10k = 10 * 10 * 10 * 10
  val n100k = 10 * 10 * 10 * 10 * 10

  lazy val data = Some( Some ( "suika" ) )

  @Benchmark
  def for$1k()   = loop1k( forComprehension )

  @Benchmark
  def for$10k()  = loop10k( forComprehension )

  @Benchmark
  def for$100k() = loop100k( forComprehension )

  @Benchmark
  def map$1k()   = loop1k( flatMapAndMap )

  @Benchmark
  def map$10k()  = loop10k( flatMapAndMap )

  @Benchmark
  def map$100k() = loop100k( flatMapAndMap )

  def loop1k( f: Unit )   = 1 to n1k   foreach ( i => f )
  def loop10k( f: Unit )  = 1 to n10k  foreach ( i => f )
  def loop100k( f: Unit ) = 1 to n100k foreach ( i => f )

  /**
   * using for comprehension.
   * @return
   */
  private[benchmark] def forComprehension: Option[String] =
    for {
      a <- data
      b <- a
    } yield {
      b
    }

  /**
   * using flatMap and map
   * @return
   */
  private[benchmark] def flatMapAndMap: Option[String] = data.flatMap( a => a.map( b => b ) )

}
