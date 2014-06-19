package com.arcusys.learn.scorm.manifest.serializer

import scala.xml._

object NodeImplicits {
  private def createNode(name: String, value: String) = Elem(null, name, Null, TopScope, false, Text(value))

  private def createNodes(data: Map[String, String]) = for ((n, v) <- data) yield createNode(n, v)

  implicit def pimp(node: Node) = new {
    def <<(node: (String, String)) =
      node match {
        case Elem(prefix, label, attribs, scope, _, child @ _*) =>
          Elem(prefix, label, attribs, scope, false, child ++ createNode(node._1, node._2): _*)
        case _ => sys.error("Can only add children to elements!")
      }

    def <<(data: Map[String, String]) =
      node match {
        case Elem(prefix, label, attribs, scope, child @ _*) =>
          Elem(prefix, label, attribs, scope, false, child ++ createNodes(data): _*)
        case _ => sys.error("Can only add children to elements!")
      }
  }
}
