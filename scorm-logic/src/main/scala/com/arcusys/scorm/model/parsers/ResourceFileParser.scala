package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import XMLImplicits._
import scala.xml.Elem

class ResourceFileParser(val fileElement: Elem) {
  def parse = 
    ResourceFile(
      fileElement %! "href",
      (fileElement \? "metadata").map(e=>new MetadataParser(e.asInstanceOf[Elem]).parse))  
}