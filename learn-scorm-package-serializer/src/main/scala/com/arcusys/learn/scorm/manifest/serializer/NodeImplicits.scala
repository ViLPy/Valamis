package com.arcusys.learn.scorm.manifest.serializer

import scala.xml._

object NodeImplicits {
  private def createNode(name: String, value: String) = Elem(null, name, Null, TopScope, Text(value))

  private def createNodes(data: Map[String, String]) = for ((n, v) <- data) yield createNode(n, v)

  implicit def pimp(node: Node) = new {
    def <<(node: (String, String)) =
      node match {
        case Elem(prefix, label, attribs, scope, child@_*) =>
          Elem(prefix, label, attribs, scope, child ++ createNode(node._1, node._2): _*)
        case _ => error("Can only add children to elements!")
      }

    def <<(data: Map[String, String]) =
      node match {
        case Elem(prefix, label, attribs, scope, child@_*) =>
          Elem(prefix, label, attribs, scope, child ++ createNodes(data): _*)
        case _ => error("Can only add children to elements!")
      }
  }
}
