package com.arcusys.valamis.model

case class RangeResult[T](
  total: Int,
  items: Seq[T])

case class SkipTake(skip: Int, take: Int)

object Order extends Enumeration {
  def apply(from: Boolean) = if(from) Asc else Desc
  val Asc, Desc = Value
}

abstract class SortBy[T](sortBy: T, order: Order.Value)