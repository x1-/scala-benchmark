package com.inkenkun.x1.scala.benchmark

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import org.scalatest._

class FreadMutableArraySpec extends FlatSpec with Matchers {

  val t = new FreadMutableArray
  val data5 = 1 to 5 toSeq
  val ab5 = ArrayBuffer( data5:_* )

  "type ArrayBuffer randomRead( ArrayBuffer.empty[Int] )" should "empty" in {
    t.randomRead( ArrayBuffer.empty[Int] ) shouldBe empty
  }
  s"type ArrayBuffer randomRead( $ab5 )" should "have size 5" in {
    t.randomRead( ab5 ) should have size 5
  }
  s"type ArrayBuffer randomRead( $ab5 )" should "ArrayBuffer(1, 5, 3, 4, 1)" in {
    t.randomRead( ab5 ) should contain theSameElementsInOrderAs ArrayBuffer( 1, 5, 3, 4, 1 )
  }

  /////////////////////////////////////////////////////////////////////////////

  val lb5 = ListBuffer( data5:_* )

  "type ListBuffer randomRead( ListBuffer.empty[Int] )" should "empty" in {
    t.randomRead( ListBuffer.empty[Int] ) shouldBe empty
  }
  s"type ListBuffer randomRead( $lb5 )" should "have size 5" in {
    t.randomRead( lb5 ) should have size 5
  }
  s"type ListBuffer randomRead( $lb5 )" should "ListBuffer(1, 5, 3, 4, 1)" in {
    t.randomRead( lb5 ) should contain theSameElementsInOrderAs ListBuffer( 1, 5, 3, 4, 1 )
  }
}
