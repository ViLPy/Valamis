package com.arcusys.valamis.lesson.scorm.service.parser

import com.arcusys.valamis.lesson.scorm.model.manifest.ResourceFile
import com.arcusys.valamis.util.XMLImplicits
import com.arcusys.valamis.util.XMLImplicits._

import scala.xml.Elem

class ResourceFileParser(val fileElement: Elem) {
  def parse: ResourceFile =
    new ResourceFile(
      fileElement attr "href" required string,
      fileElement childElem "metadata" optional parseMetadata _
    )
}