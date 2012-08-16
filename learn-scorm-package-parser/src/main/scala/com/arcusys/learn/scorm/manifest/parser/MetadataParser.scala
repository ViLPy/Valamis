package com.arcusys.learn.scorm.manifest.parser

import com.arcusys.learn.scorm.manifest.model._
import scala.xml.Elem
import XMLImplicits._

class MetadataParser(val metadataElement: Elem) {
  def parse: Metadata = {
    val locations = metadataElement children ("adlcp", "location") map (_.text.trim)
    val inline = for {
      childElement <- metadataElement.child
      if childElement.isInstanceOf[Elem]
      name = childElement.asInstanceOf[Elem].label
      if (name != "schema" && name != "schemaversion" && name != "location")
    } yield childElement.asInstanceOf[Elem].toString
    new Metadata(locations, inline)
  }
}