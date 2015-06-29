package com.arcusys.valamis.social.model

import com.arcusys.valamis.model.{Order, SortBy}

case class CommentSortBy(sortBy: CommentSortByCriteria.Value, order: Order.Value) extends SortBy(sortBy, order)

object CommentSortByCriteria extends Enumeration{
  val CreationDate = Value
}