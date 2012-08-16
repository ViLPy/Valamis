package com.arcusys.learn.scorm.manifest.parser

import com.arcusys.learn.scorm.manifest.model._
import XMLImplicits._
import scala.xml.Elem

class ResourceFileParser(val fileElement: Elem) {
  def parse: ResourceFile =
    new ResourceFile(
      fileElement attr "href" required string,
      fileElement childElem "metadata" optional parseMetadata _
    )
}