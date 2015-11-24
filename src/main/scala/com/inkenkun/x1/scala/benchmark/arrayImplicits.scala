package com.inkenkun.x1.scala.benchmark

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object arrayImplicits {

  abstract class Monoid[M[_] <: Seq[_], X] {
    def empty: M[X]
    def append(rs: M[X], a: X ): M[X]
    def insert(rs: M[X], a: X ): M[X]
    def removeHead( rs: M[X] ): M[X]
    def removeTail( rs: M[X] ): M[X]
    def take( rs: M[X] ): M[X]
  }

  implicit object ListMonoid extends Monoid[({type F[X] = List[X]})#F, Int] {
    def empty: List[Int] = List.empty[Int]
    def append(rs: List[Int], a: Int ): List[Int] = rs :+ a
    def insert(rs: List[Int], a: Int ): List[Int] = a :: rs
    def removeHead( rs: List[Int] ): List[Int] = rs.tail
    def removeTail( rs: List[Int] ): List[Int] = rs.dropRight(1)
    def take( rs: List[Int] ): List[Int] = rs.take( rs.size - 1 )
  }
  implicit object VectorMonoid extends Monoid[({type F[X] = Vector[X]})#F, Int] {
    def empty: Vector[Int] = Vector.empty[Int]
    def append(rs: Vector[Int], a: Int ): Vector[Int] = rs :+ a
    def insert(rs: Vector[Int], a: Int ): Vector[Int] = a +: rs
    def removeHead( rs: Vector[Int] ): Vector[Int] = rs.tail
    def removeTail( rs: Vector[Int] ): Vector[Int] = rs.dropRight(1)
    def take( rs: Vector[Int] ): Vector[Int] = rs.take( rs.size - 1 )
  }
  implicit object StreamMonoid extends Monoid[({type F[X] = Stream[X]})#F, Int] {
    def empty: Stream[Int] = Stream.empty[Int]
    def append(rs: Stream[Int], a: Int ): Stream[Int] = rs :+ a
    def insert(rs: Stream[Int], a: Int ): Stream[Int] = a +: rs
    def removeHead( rs: Stream[Int] ): Stream[Int] = rs.tail
    def removeTail( rs: Stream[Int] ): Stream[Int] = rs.dropRight(1)
    def take( rs: Stream[Int] ): Stream[Int] = rs.take( rs.size - 1 )
  }
  implicit object ListBufferMonoid extends Monoid[({type F[X] = ListBuffer[X]})#F, Int] {
    def empty: ListBuffer[Int] = ListBuffer.empty[Int]
    def append(rs: ListBuffer[Int], a: Int ): ListBuffer[Int] = rs += a
    def insert(rs: ListBuffer[Int], a: Int ): ListBuffer[Int] = a +=: rs
    def removeHead( rs: ListBuffer[Int] ): ListBuffer[Int] = rs.drop(0)
    def removeTail( rs: ListBuffer[Int] ): ListBuffer[Int] = rs.dropRight(1)
    def take( rs: ListBuffer[Int] ): ListBuffer[Int] = rs.take( rs.size - 1 )
  }
  implicit object ArrayBufferMonoid extends Monoid[({type F[X] = ArrayBuffer[X]})#F, Int] {
    def empty: ArrayBuffer[Int] = ArrayBuffer.empty[Int]
    def append(rs: ArrayBuffer[Int], a: Int ): ArrayBuffer[Int] = rs += a
    def insert(rs: ArrayBuffer[Int], a: Int ): ArrayBuffer[Int] = a +=: rs
    def removeHead( rs: ArrayBuffer[Int] ): ArrayBuffer[Int] = rs.tail
    def removeTail( rs: ArrayBuffer[Int] ): ArrayBuffer[Int] = rs.dropRight(1)
    def take( rs: ArrayBuffer[Int] ): ArrayBuffer[Int] = rs.take( rs.size - 1 )
  }
}
