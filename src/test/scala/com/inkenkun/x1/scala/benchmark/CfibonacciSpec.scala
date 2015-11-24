package com.inkenkun.x1.scala.benchmark

import scala.collection.immutable.Stream
import scala.collection.mutable.ArrayBuffer
import org.scalatest._


class CfibonacciSpec extends FlatSpec with Matchers {

  val fibo = new Cfibonacci

  "streamFibonacci().take(0)" should "empty" in {
    fibo.streamFibonacci().take(0) shouldBe empty
  }

  "streamFibonacci().take(1)" should "have size 1" in {
    fibo.streamFibonacci().take(1) should have size 1
  }
  it should "have Stream(1)" in {
    fibo.streamFibonacci().take(1) should contain theSameElementsInOrderAs Stream(1)
  }

  "streamFibonacci(6)" should "have size 6" in {
    fibo.streamFibonacci().take(6) should have size 6
  }
  it should "have Stream(1, 1, 2, 3, 5, 8)" in {
    fibo.streamFibonacci().take(6) should contain theSameElementsInOrderAs Stream(1, 1, 2, 3, 5, 8)
  }

  /////////////////////////////////////////////////////////////////////////////

  "arrayBufferFibonacci(0)" should "empty" in {
    fibo.arrayBufferFibonacci(0) shouldBe empty
  }

  "arrayBufferFibonacci(1)" should "have size 1" in {
    fibo.arrayBufferFibonacci(1) should have size 1
  }
  it should "have Stream(1)" in {
    fibo.arrayBufferFibonacci(1) should contain theSameElementsInOrderAs ArrayBuffer(1)
  }

  "arrayBufferFibonacci(6)" should "have size 6" in {
    fibo.arrayBufferFibonacci(6) should have size 6
  }
  it should "have Stream(1, 1, 2, 3, 5, 8)" in {
    fibo.arrayBufferFibonacci(6) should contain theSameElementsInOrderAs ArrayBuffer(1, 1, 2, 3, 5, 8)
  }

  /////////////////////////////////////////////////////////////////////////////

  "arrayFibonacci(0)" should "empty" in {
    fibo.arrayFibonacci(0) shouldBe empty
  }

  "arrayFibonacci(1)" should "have size 1" in {
    fibo.arrayFibonacci(1) should have size 1
  }
  it should "have Stream(1)" in {
    fibo.arrayFibonacci(1) should contain theSameElementsInOrderAs Array(1)
  }

  "arrayFibonacci(6)" should "have size 6" in {
    fibo.arrayFibonacci(6) should have size 6
  }
  it should "have Stream(1, 1, 2, 3, 5, 8)" in {
    fibo.arrayFibonacci(6) should contain theSameElementsInOrderAs Array(1, 1, 2, 3, 5, 8)
  }
}
