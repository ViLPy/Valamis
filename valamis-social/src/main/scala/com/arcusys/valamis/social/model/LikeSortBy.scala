package com.arcusys.valamis.social.model

import com.arcusys.valamis.model.{Order, SortBy}

case class LikeSortBy(sortBy: LikeSortByCriteria.Value, order: Order.Value) extends SortBy(sortBy, order)

object LikeSortByCriteria extends Enumeration{
  val CreationDate = Value
}
