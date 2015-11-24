package com.inkenkun.x1.scala.benchmark

import scala.util.matching.Regex
import org.scalatest._

class GregexpSpec extends FlatSpec with Matchers {

  val t = new Gregexp

  "textRepeator" should "when ( abc, 0 ) return empty" in {
    t.textRepeator( "abc", 0 ) shouldBe empty
  }
  it should "when ( a_, 5 ) return a_a_a_a_a_" in {
    t.textRepeator( "a_", 5 ) shouldBe "a_a_a_a_a_"
  }

  "findAllIn" should """when ( '\w+\w', 'abc012 345def' ) return abc012""" in {
    val re   = """\w+\w""".r
    val data = "abc012 345def"

    t.findAllIn( re, data ) shouldBe Some( "abc012" )
  }
  "findAllIn" should """when ( '\w+(?=/)', 'abc012/345def' ) return abc012""" in {
    val re   = """\w+(?=/)""".r
    val data = "abc012/345def"

    t.findAllIn( re, data ) shouldBe Some( "abc012" )
  }
  "findAllIn" should """when ( '(?<=\w+)/\w+', 'abc012/345def' ) return /345def""" in {
    val re   = """(?<=\w+)/\w+""".r
    val data = "abc012/345def"

    t.findAllIn( re, data ) shouldBe Some( "/345def" )
  }
  "findFirstInForward" should """when ( '\w+\w', 'abc012 345def' ) return abc012""" in {
    val re   = """\w+\w""".r
    val data = "abc012 345def"

    t.findFirstInForward( re, data ) shouldBe Some( "abc012" )
  }
  "findFirstInBackward" should """when ( '\w+\w', 'abc012/345def' ) return abc012""" in {
    val re   = """\w+\w""".r
    val data = "abc012/345def"

    t.findFirstInBackward( re, data ) shouldBe Some( "/345def" )
  }
  "findPrefixOfForward" should """when ( '\w+\w', 'abc012 345def' ) return abc012""" in {
    val re   = """\w+\w""".r
    val data = "abc012 345def"

    t.findPrefixOfForward( re, data ) shouldBe Some( "abc012" )
  }
  "findPrefixOfBackward" should """when ( '\w+\w', 'abc012/345def' ) return abc012""" in {
    val re   = """\w+\w""".r
    val data = "abc012/345def"

    t.findPrefixOfBackward( re, data ) shouldBe Some( "/345def" )
  }
}
