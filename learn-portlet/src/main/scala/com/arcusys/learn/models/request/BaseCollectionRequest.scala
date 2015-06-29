package com.arcusys.learn.models

import com.arcusys.learn.service.util.Parameter
import org.scalatra.{ ScalatraBase }

object BaseCollectionRequest extends BaseCollectionRequest

trait BaseCollectionRequest {
  final val Page = "page"
  final val Count = "count"
  final val SortBy = "sortBy"
  final val SortAscDirection = "sortAscDirection"
}

abstract class BaseCollectionRequestModel(scalatra: ScalatraBase) {
  implicit val _scalatra = scalatra

  def page = Parameter(BaseCollectionRequest.Page).intRequired
  def count = Parameter(BaseCollectionRequest.Count).intRequired
  def skip = (page - 1) * count
  def isSortDirectionAsc = Parameter(BaseCollectionRequest.SortAscDirection).booleanOption match {
    case Some(value) => value
    case None        => true
  }
}

abstract class BaseSortableCollectionRequestModel[T](scalatra: ScalatraBase, toEnum: String => T) extends BaseCollectionRequestModel(scalatra) {
  def sortBy: T = {
    toEnum(Parameter(BaseCollectionRequest.SortBy).required)
  }
}