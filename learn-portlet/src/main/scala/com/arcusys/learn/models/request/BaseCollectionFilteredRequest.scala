package com.arcusys.learn.models.request

import com.arcusys.learn.models.{ BaseSortableCollectionRequestModel, BaseCollectionRequest, BaseCollectionRequestModel }
import com.arcusys.learn.service.util.Parameter
import org.scalatra.{ ScalatraBase }

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */
object BaseCollectionFilteredRequest extends BaseCollectionFilteredRequest

trait BaseCollectionFilteredRequest extends BaseCollectionRequest {
  final val Filter = "filter"
}

abstract class BaseSortableCollectionFilteredRequestModel[T](scalatra: ScalatraBase, toEnum: String => T) extends BaseSortableCollectionRequestModel(scalatra, toEnum) {
  def filter = Parameter(BaseCollectionFilteredRequest.Filter).withDefault("")
}

abstract class BaseCollectionFilteredRequestModel(scalatra: ScalatraBase) extends BaseCollectionRequestModel(scalatra) {
  def filter = Parameter(BaseCollectionFilteredRequest.Filter).withDefault("")
}