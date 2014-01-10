package com.arcusys.learn.tincan.lrs.utils

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods._

object JsonCombiner {

  def combine(target: Array[Byte], toBeMerged: Array[Byte]): Array[Byte] =
    combine(new String(target), new String(toBeMerged)).map(_.toByte).toArray

  def combine(target: String, toBeMerged: String): String = {
    implicit val format = DefaultFormats
    val parsedA = parse(target)
    val parsedB = parse(toBeMerged)
    compact(parsedA.removeField(jField => parsedB.findField(_._1 == jField._1).isDefined) merge parse(toBeMerged))
  }
}