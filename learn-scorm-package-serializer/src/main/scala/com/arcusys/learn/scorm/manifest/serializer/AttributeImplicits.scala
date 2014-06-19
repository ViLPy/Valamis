package com.arcusys.learn.scorm.manifest.serializer

import scala.xml._

object AttributeImplicits {
  implicit def pimp(elem: Elem) = new {

    private def getAttribute(key: String, value: Option[_]) =
      key.split(":") match {
        case Array(namespace, tagname) => Attribute(namespace, tagname, Text(value.get.toString), Null)
        case _                         => Attribute(None, key, Text(value.get.toString), Null)
      }

    def %(attr: Map[String, Option[_]]) = {
      val filteredAttr = attr.filter(p => p._2.isDefined)
      val seq = for ((key, value) <- filteredAttr) yield getAttribute(key, value)
      (elem /: seq)(_ % _)
    }

    def %(attr: (String, Option[_])) =
      if (attr._2 == None) elem else elem % getAttribute(attr._1, attr._2)
  }
}