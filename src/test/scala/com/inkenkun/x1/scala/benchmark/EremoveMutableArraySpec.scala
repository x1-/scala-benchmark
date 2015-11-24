package com.inkenkun.x1.scala.benchmark

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import org.scalatest._

class EremoveMutableArraySpec extends FlatSpec with Matchers {

  import arrayImplicits._

  val t = new EremoveMutableArray
  val data5 = ( 1 to 5 ).toSeq

  s"type ArrayBuffer removeHeadSeq( $data5 )" should "empty" in {
    t.removeHeadCollection( ArrayBuffer( data5:_* ) ) shouldBe empty
  }
  s"type ArrayBuffer removeHeadSeq( $data5, Some(2) )" should "List(3, 4, 5)" in {
    t.removeHeadCollection( ArrayBuffer( data5:_* ), Some( 2 ) ) should contain theSameElementsInOrderAs ArrayBuffer( 3, 4, 5 )
  }

  s"type ArrayBuffer removeTailSeq( $data5 )" should "empty" in {
    t.removeTailCollection( ArrayBuffer( data5:_* ) ) shouldBe empty
  }
  s"type ArrayBuffer removeTailSeq( $data5, Some(2) )" should "List(1, 2, 3)" in {
    t.removeTailCollection( ArrayBuffer( data5:_* ), Some( 2 ) ) should contain theSameElementsInOrderAs ArrayBuffer( 1, 2, 3 )
  }

  /////////////////////////////////////////////////////////////////////////////

  s"type ListBuffer removeHeadSeq( $data5 )" should "empty" in {
    t.removeHeadCollection( ListBuffer( data5:_* ) ) shouldBe empty
  }
  s"type ListBuffer removeHeadSeq( $data5, Some(2) )" should "List(3, 4, 5)" in {
    t.removeHeadCollection( ListBuffer( data5:_* ), Some( 2 ) ) should contain theSameElementsInOrderAs ListBuffer( 3, 4, 5 )
  }

  s"type ListBuffer removeTailSeq( $data5 )" should "empty" in {
    t.removeTailCollection( ListBuffer( data5:_* ) ) shouldBe empty
  }
  s"type ListBuffer removeTailSeq( $data5, Some(2) )" should "List(1, 2, 3)" in {
    t.removeTailCollection( ListBuffer( data5:_* ), Some( 2 ) ) should contain theSameElementsInOrderAs ListBuffer( 1, 2, 3 )
  }
}
