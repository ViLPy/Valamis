package com.arcusys.valamis.lesson.scorm.service.parser

import com.arcusys.valamis.lesson.scorm.model.manifest.Metadata
import com.arcusys.valamis.util.XMLImplicits
import com.arcusys.valamis.util.XMLImplicits._

import scala.xml.Elem

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