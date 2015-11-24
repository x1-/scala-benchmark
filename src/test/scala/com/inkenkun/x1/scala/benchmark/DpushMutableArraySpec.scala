package com.inkenkun.x1.scala.benchmark

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import org.scalatest._

class DpushMutableArraySpec extends FlatSpec with Matchers {

  import arrayImplicits._

  val t = new DpushMutableArray

  "type ListBuffer pushSeq(0)" should "empty" in {
    t.appendCollection[ListBuffer]( 0 ) shouldBe empty
  }

  "type ListBuffer pushSeq(5)" should "have size 5" in {
    t.appendCollection[ListBuffer]( 5 ) should have size 5
  }
  it should "have ListBuffer(1, 2, 3, 4, 5)" in {
    t.appendCollection[ListBuffer]( 5 ) should contain theSameElementsInOrderAs ListBuffer( 1, 2, 3, 4, 5 )
  }

  "type ListBuffer unshiftSeq(5)" should "have size 5" in {
    t.insertCollection[ListBuffer]( 5 ) should have size 5
  }
  it should "have ListBuffer(5, 4, 3, 2, 1)" in {
    t.insertCollection[ListBuffer]( 5 ) should contain theSameElementsInOrderAs ListBuffer( 5, 4, 3, 2, 1 )
  }
  /////////////////////////////////////////////////////////////////////////////

  "type ArrayBuffer pushSeq(0)" should "empty" in {
    t.appendCollection[ArrayBuffer]( 0 ) shouldBe empty
  }

  "type ArrayBuffer pushSeq(5)" should "have size 5" in {
    t.appendCollection[ArrayBuffer]( 5 ) should have size 5
  }
  it should "have ArrayBuffer(1, 2, 3, 4, 5)" in {
    t.appendCollection[ArrayBuffer]( 5 ) should contain theSameElementsInOrderAs ArrayBuffer( 1, 2, 3, 4, 5 )
  }

  "type ArrayBuffer unshiftSeq(5)" should "have size 5" in {
    t.insertCollection[ArrayBuffer]( 5 ) should have size 5
  }
  it should "have ArrayBuffer(5, 4, 3, 2, 1)" in {
    t.insertCollection[ArrayBuffer]( 5 ) should contain theSameElementsInOrderAs ArrayBuffer( 5, 4, 3, 2, 1 )
  }

}
