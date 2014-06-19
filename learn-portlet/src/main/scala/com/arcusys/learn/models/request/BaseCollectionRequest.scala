package com.arcusys.learn.models

import com.arcusys.learn.service.util.Parameter
import org.scalatra.{ ScalatraBase }

object BaseCollectionRequest extends BaseCollectionRequest

trait BaseCollectionRequest {
  val PAGE = "page"
  val COUNT = "count"
  val SORT_BY = "sortBy"
  val SORT_ASC_DIRECTION = "sortAscDirection"
}

abstract class BaseCollectionRequestModel(scalatra: ScalatraBase) {
  implicit val _scalatra = scalatra

  def page = Parameter(BaseCollectionRequest.PAGE).intRequired
  def count = Parameter(BaseCollectionRequest.COUNT).intRequired
  def skip = (page - 1) * count
  def isSortDirectionAsc = Parameter(BaseCollectionRequest.SORT_ASC_DIRECTION).booleanOption match {
    case Some(value) => value
    case None        => true
  }
}

abstract class BaseSortableCollectionRequestModel[T](scalatra: ScalatraBase, toEnum: String => T) extends BaseCollectionRequestModel(scalatra) {
  def sortBy: T = {
    toEnum(Parameter(BaseCollectionRequest.SORT_BY).required)
  }
}