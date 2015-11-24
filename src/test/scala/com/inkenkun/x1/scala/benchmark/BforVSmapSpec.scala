package com.inkenkun.x1.scala.benchmark

import org.scalatest._

class BforVSmapSpec extends FlatSpec with Matchers {

  val vs = new BforVSmap

  "forComprehension" should "return Some(suika)." in {
    vs.forComprehension shouldBe Some( "suika" )
  }
  "flatMapAndMap" should "return Some(suika)." in {
    vs.flatMapAndMap shouldBe Some( "suika" )
  }
}
