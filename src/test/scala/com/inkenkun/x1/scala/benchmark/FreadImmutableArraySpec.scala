package com.inkenkun.x1.scala.benchmark

import org.scalatest._

class FreadImmutableArraySpec extends FlatSpec with Matchers {

  val t = new FreadImmutableArray
  val data5 = 1 to 5
  val list5 = data5.toList

  "type List randomRead( List.empty[Int] )" should "empty" in {
    t.randomRead( List.empty[Int] ) shouldBe empty
  }
  s"type List randomRead( $list5 )" should "have size 5" in {
    t.randomRead( list5 ) should have size 5
  }
  s"type List randomRead( $list5 )" should "List(1, 5, 3, 4, 1)" in {
    t.randomRead( list5 ) should contain theSameElementsInOrderAs List( 1, 5, 3, 4, 1 )
  }

  /////////////////////////////////////////////////////////////////////////////

  val vec5 = data5.toVector

  "type Vector randomRead( Vector.empty[Int] )" should "empty" in {
    t.randomRead( Vector.empty[Int] ) shouldBe empty
  }
  s"type Vector randomRead( $vec5 )" should "have size 5" in {
    t.randomRead( vec5 ) should have size 5
  }
  s"type Vector randomRead( $vec5 )" should "Vector(1, 5, 3, 4, 1)" in {
    t.randomRead( vec5 ) should contain theSameElementsInOrderAs Vector( 1, 5, 3, 4, 1 )
  }

  /////////////////////////////////////////////////////////////////////////////

  val st5 = data5.toStream

  "type Stream randomRead( Stream.empty[Int] )" should "empty" in {
    t.randomRead( Stream.empty[Int] ) shouldBe empty
  }
  s"type Stream randomRead( $st5 )" should "have size 5" in {
    t.randomRead( st5 ) should have size 5
  }
  s"type Stream randomRead( $st5 )" should "Stream(1, 5, 3, 4, 1)" in {
    t.randomRead( st5 ) should contain theSameElementsInOrderAs Stream( 1, 5, 3, 4, 1 )
  }

  /////////////////////////////////////////////////////////////////////////////

  val array5 = data5.toArray

  "type Array randomReadArray( Array.empty[Int] )" should "empty" in {
    t.randomReadArray( Array.empty[Int] ) shouldBe empty
  }
  s"type Array randomReadArray( $array5 )" should "have size 5" in {
    t.randomReadArray( array5 ) should have size 5
  }
  s"type Array randomRead( $array5 )" should "Array(1, 5, 3, 4, 1)" in {
    t.randomReadArray( array5 ) should contain theSameElementsInOrderAs Array( 1, 5, 3, 4, 1 )
  }
}
