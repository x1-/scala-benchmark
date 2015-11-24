package com.inkenkun.x1.scala.benchmark

import org.scalatest._

class EremoveImmutableArraySpec extends FlatSpec with Matchers {

  import arrayImplicits._

  val t = new EremoveImmutableArray
  val data5 = 1 to 5
  val list5 = data5.toList

  s"type List removeHeadSeq( $list5 )" should "empty" in {
    t.removeHeadCollection( list5 ) shouldBe empty
  }
  s"type List removeHeadSeq( $list5, Some(2) )" should "List(3, 4, 5)" in {
    t.removeHeadCollection( list5, Some( 2 ) ) should contain theSameElementsInOrderAs List( 3, 4, 5 )
  }

  s"type List removeTailSeq( $list5 )" should "empty" in {
    t.removeTailCollection( list5 ) shouldBe empty
  }
  s"type List removeTailSeq( $list5, Some(2) )" should "List(1, 2, 3)" in {
    t.removeTailCollection( list5, Some( 2 ) ) should contain theSameElementsInOrderAs List( 1, 2, 3 )
  }

  s"type List take( $list5 )" should "empty" in {
    t.takeCollection( list5 ) shouldBe empty
  }
  s"type List take( $list5, Some(2) )" should "List(1, 2, 3)" in {
    t.takeCollection( list5, Some( 2 ) ) should contain theSameElementsInOrderAs List( 1, 2, 3 )
  }

  /////////////////////////////////////////////////////////////////////////////

  val vec5 = data5.toVector

  s"type Vector removeHeadSeq( $vec5 )" should "empty" in {
    t.removeHeadCollection( vec5 ) shouldBe empty
  }
  s"type Vector removeHeadSeq( $vec5, Some(2) )" should "Vector(3, 4, 5)" in {
    t.removeHeadCollection( vec5, Some( 2 ) ) should contain theSameElementsInOrderAs Vector( 3, 4, 5 )
  }

  s"type Vector removeTailSeq( $vec5 )" should "empty" in {
    t.removeTailCollection( vec5 ) shouldBe empty
  }
  s"type Vector removeTailSeq( $vec5, Some(2) )" should "Vector(1, 2, 3)" in {
    t.removeTailCollection( vec5, Some( 2 ) ) should contain theSameElementsInOrderAs Vector( 1, 2, 3 )
  }

  s"type Vector take( $vec5 )" should "empty" in {
    t.takeCollection( vec5 ) shouldBe empty
  }
  s"type Vector take( $vec5, Some(2) )" should "Vector(1, 2, 3)" in {
    t.takeCollection( vec5, Some( 2 ) ) should contain theSameElementsInOrderAs Vector( 1, 2, 3 )
  }

  /////////////////////////////////////////////////////////////////////////////

  val st5 = data5.toStream

  s"type Stream removeHeadSeq( $st5 )" should "empty" in {
    t.removeHeadCollection( st5 ) shouldBe empty
  }
  s"type Stream removeHeadSeq( $st5, Some(2) )" should "Stream(3, 4, 5)" in {
    t.removeHeadCollection( st5, Some( 2 ) ) should contain theSameElementsInOrderAs Stream( 3, 4, 5 )
  }

  s"type Stream removeTailSeq( $st5 )" should "empty" in {
    t.removeTailCollection( st5 ) shouldBe empty
  }
  s"type Stream removeTailSeq( $st5, Some(2) )" should "Stream(1, 2, 3)" in {
    t.removeTailCollection( st5, Some( 2 ) ) should contain theSameElementsInOrderAs Stream( 1, 2, 3 )
  }

  s"type Stream take( $st5 )" should "empty" in {
    t.takeCollection( st5 ) shouldBe empty
  }
  s"type Stream take( $st5, Some(2) )" should "Stream(1, 2, 3)" in {
    t.takeCollection( st5, Some( 2 ) ) should contain theSameElementsInOrderAs Stream( 1, 2, 3 )
  }
}
