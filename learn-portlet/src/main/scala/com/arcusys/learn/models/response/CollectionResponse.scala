package com.arcusys.learn.models.response

/**
 * Created by iliya.tryapitsin on 14.01.14.
 */
case class CollectionResponse[T](
  page: Int,
  records: Iterable[T],
  total: Int)
