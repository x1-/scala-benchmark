package com.inkenkun.x1.scala.benchmark

import org.scalatest._

class DpushImmutableArraySpec extends FlatSpec with Matchers {

  import arrayImplicits._

  val pu = new DpushImmutableArray

  "type List pushSeq(0)" should "empty" in {
    pu.appendCollection[List]( 0 ) shouldBe empty
  }

  "type List pushSeq(5)" should "have size 5" in {
    pu.appendCollection[List]( 5 ) should have size 5
  }
  it should "have List(1, 2, 3, 4, 5)" in {
    pu.appendCollection[List]( 5 ) should contain theSameElementsInOrderAs List( 1, 2, 3, 4, 5 )
  }

  "type List unshiftSeq(5)" should "have size 5" in {
    pu.insertCollection[List]( 5 ) should have size 5
  }
  it should "have List(5, 4, 3, 2, 1)" in {
    pu.insertCollection[List]( 5 ) should contain theSameElementsInOrderAs List( 5, 4, 3, 2, 1 )
  }

  "type List reallocation(List(1, 2, 3, 4, 5), 5)" should "have size 5" in {
    pu.reallocation[List]( List( 1, 2, 3, 4, 5 ), 5 ) should have size 5
  }
  it should "have List(1, 2, 3, 4, 5)" in {
    pu.reallocation[List]( List( 1, 2, 3, 4, 5 ), 5 ) should contain theSameElementsInOrderAs List( 1, 2, 3, 4, 5 )
  }
  /////////////////////////////////////////////////////////////////////////////

  "type Vector pushSeq(0)" should "empty" in {
    pu.appendCollection[Vector]( 0 ) shouldBe empty
  }

  "type Vector pushSeq(5)" should "have size 5" in {
    pu.appendCollection[Vector]( 5 ) should have size 5
  }
  it should "have Vector(1, 2, 3, 4, 5)" in {
    pu.appendCollection[Vector]( 5 ) should contain theSameElementsInOrderAs Vector( 1, 2, 3, 4, 5 )
  }

  "type Vector unshiftSeq(5)" should "have size 5" in {
    pu.insertCollection[Vector]( 5 ) should have size 5
  }
  it should "have Vector(5, 4, 3, 2, 1)" in {
    pu.insertCollection[Vector]( 5 ) should contain theSameElementsInOrderAs Vector( 5, 4, 3, 2, 1 )
  }
  /////////////////////////////////////////////////////////////////////////////

  "type Stream pushSeq(0)" should "empty" in {
    pu.appendCollection[Stream]( 0 ) shouldBe empty
  }

  "type Stream pushSeq(5)" should "have size 5" in {
    pu.appendCollection[Stream]( 5 ) should have size 5
  }
  it should "have Stream(1, 2, 3, 4, 5)" in {
    pu.appendCollection[Stream]( 5 ) should contain theSameElementsInOrderAs Stream( 1, 2, 3, 4, 5 )
  }
  "type Stream unshiftSeq(5)" should "have size 5" in {
    pu.insertCollection[Stream]( 5 ) should have size 5
  }
  it should "have Stream(5, 4, 3, 2, 1)" in {
    pu.insertCollection[Stream]( 5 ) should contain theSameElementsInOrderAs Stream( 5, 4, 3, 2, 1 )
  }
}
