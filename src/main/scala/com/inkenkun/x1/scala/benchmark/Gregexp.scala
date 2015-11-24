package com.inkenkun.x1.scala.benchmark

import scala.util.matching.Regex
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State( Scope.Benchmark )
class Gregexp {

  val   n1k = 10 * 10 * 10
  val  n10k = 10 * 10 * 10 * 10
  val n100k = 10 * 10 * 10 * 10 * 10

  val alpha  = "AbcdefghijKlmnopqrst" // 20 alpha
  val number = "0123456789"
  val data = textRepeator( alpha, 50 ) + "/" + textRepeator( number, 2 )  // 1021 length

  val vr1   = """\w+""" + textRepeator( """\w""", 1 ) r
  val vr10  = """\w+""" + textRepeator( """\w""", 10 ) r
  val vr100 = """\w+""" + textRepeator( """\w""", 100 ) r

  @Benchmark
  def findAllIn$chars$1$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( vr1, data )
    }

  @Benchmark
  def findAllIn$chars$10$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( vr10, data )
    }

  @Benchmark
  def findAllIn$chars$100$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( vr100, data )
    }

  @Benchmark
  def findFirstIn$chars$1$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInForward( vr1, data )
    }

  @Benchmark
  def findFirstIn$chars$10$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInForward( vr10, data )
    }

  @Benchmark
  def findFirstIn$chars$100$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInForward( vr100, data )
    }

  @Benchmark
  def findPrefixOf$chars$1$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfForward( vr1, data )
    }

  @Benchmark
  def findPrefixOf$chars$10$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfForward( vr10, data )
    }

  @Benchmark
  def findPrefixOf$chars$100$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfForward( vr100, data )
    }

  val lb1   = """(?<=\w)/.+""" r
  val lb10  = """(?<=\w{1,10})/.+""" r
  val lb100 = """(?<=\w{1,100})/.+""" r
  val lbInf = """(?<=\w+)/.+""" r

  @Benchmark
  def findAllIn$behind$1$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( lb1, data )
    }

  @Benchmark
  def findAllIn$behind$10$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( lb10, data )
    }

  @Benchmark
  def findAllIn$behind$100$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( lb100, data )
    }

  @Benchmark
  def findAllIn$behind$inf$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( lbInf, data )
    }

  @Benchmark
  def findFirstIn$behind$1$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInBackward( lb1, data )
    }

  @Benchmark
  def findFirstIn$behind$10$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInBackward( lb100, data )
    }

  @Benchmark
  def findFirstIn$behind$100$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInBackward( lb100, data )
    }

  @Benchmark
  def findFirstIn$behind$inf$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInBackward( lbInf, data )
    }

  @Benchmark
  def findPrefixOf$behind$1$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfBackward( lb1, data )
    }

  @Benchmark
  def findPrefixOf$behind$10$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfBackward( lb100, data )
    }

  @Benchmark
  def findPrefixOf$behind$100$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfBackward( lb100, data )
    }

  @Benchmark
  def findPrefixOf$behind$inf$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfBackward( lbInf, data )
    }

  val fb1   = """\w(?:/)""" r
  val fb10  = """\w{1,10}/""" r
  val fb100 = """\w{1,100}/""" r
  val fbInf = """\w+/""" r

  @Benchmark
  def findAllIn$quant$1$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( fb1, data )
    }

  @Benchmark
  def findAllIn$quant$10$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( fb10, data )
    }

  @Benchmark
  def findAllIn$quant$100$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( fb100, data )
    }

  @Benchmark
  def findAllIn$quant$inf$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findAllIn( fbInf, data )
    }

  @Benchmark
  def findFirstIn$quant$1$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInBackward( fb1, data )
    }

  @Benchmark
  def findFirstIn$quant$10$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInBackward( fb10, data )
    }

  @Benchmark
  def findFirstIn$quant$100$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInBackward( fb100, data )
    }

  @Benchmark
  def findFirstIn$quant$inf$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findFirstInBackward( fbInf, data )
    }

  @Benchmark
  def findPrefixOf$quant$1$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfBackward( fb1, data )
    }

  @Benchmark
  def findPrefixOf$quant$10$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfBackward( fb10, data )
    }

  @Benchmark
  def findPrefixOf$quant$100$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfBackward( fb100, data )
    }

  @Benchmark
  def findPrefixOf$quant$inf$1k(): Unit =
    for ( _ <- 1 to n1k ) {
      findPrefixOfBackward( fbInf, data )
    }


  private[benchmark] def findAllIn( re: Regex, data: String ): Option[String] = {
    val ms = re findAllIn data
    if ( ms.isEmpty ) None
    else Some( ms.next )
  }

  private[benchmark] def findFirstInForward( re: Regex, data: String ): Option[String] =
    re findFirstIn data

  private[benchmark] def findFirstInBackward( re: Regex, data: String ): Option[String] =
    re findFirstMatchIn data map( _.after.toString )

  private[benchmark] def findPrefixOfForward( re: Regex, data: String ): Option[String] =
    re findPrefixOf data

  private[benchmark] def findPrefixOfBackward( re: Regex, data: String ): Option[String] =
    re findPrefixMatchOf data map( _.after.toString )


  private[benchmark] def textRepeator( text: String, num: Int ): String =
    Seq.fill( num )( text ).mkString

}
