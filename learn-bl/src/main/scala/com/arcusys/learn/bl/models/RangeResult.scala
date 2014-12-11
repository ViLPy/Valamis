package com.arcusys.learn.bl.models

/**
 * User: Yulia.Glushonkova
 * Date: 13.10.2014
 */
case class RangeResult[T](
  total: Int,
  items: Seq[T])
