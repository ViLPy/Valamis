package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import XMLImplicits._
import scala.xml.Elem

class ResourceParser(val resourceElement: Elem, val schemaVersion: String, val adlcpNs: String) {
  def parse = {
    val identifier = resourceElement %! "identifier"
    val resourceType = resourceElement %! "type"
    val href = resourceElement %? "href"
    val xmlNs = "http://www.w3.org/XML/1998/namespace"
    val base = resourceElement %? (xmlNs, "base")
    ParserUtil.checkBaseAttributeValue(base)
    val scormType = resourceElement %! (adlcpNs, if (schemaVersion.startsWith("1")) "scormtype" else "scormType")    
    val resource = new Resource(
      identifier,
      resourceType,
      href,
      base,
      if (scormType.equals("sco")) ResourceScormType.Sco else ResourceScormType.Asset,
      (resourceElement \? "metadata").map(e=>new MetadataParser(e.asInstanceOf[Elem]).parse))
    (resourceElement \ "file").foreach(fileElement => resource.files += new ResourceFileParser(fileElement.asInstanceOf[Elem]).parse)
    (resourceElement \ "dependency").foreach(resource.dependencyIdentifiers += _.asInstanceOf[Elem] %! "identifierref")
    resource
  }
}