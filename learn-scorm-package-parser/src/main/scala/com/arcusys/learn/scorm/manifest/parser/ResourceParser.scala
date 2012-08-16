package com.arcusys.learn.scorm.manifest.parser

import com.arcusys.learn.scorm.manifest.model._
import XMLImplicits._
import scala.xml.Elem

class ResourceParser(val resourceElement: Elem, val schemaVersion: String, val adlcpNs: String) {
  def parse: Resource = {
    val identifier = resourceElement attr "identifier" required string
    //TODO: check resourceElement \@ "type" required string for being 'webcontent' ? Issue a warning?
    val href = resourceElement attr "href" optional string
    val xmlNs = "http://www.w3.org/XML/1998/namespace"
    val base = resourceElement attr(xmlNs, "base") optional string
    val scormType = resourceElement attr(adlcpNs,if (schemaVersion.startsWith("1")) "scormtype" else "scormType") required string
    val files = resourceElement children "file" map parseResourceFile
    val dependencies = (resourceElement children "dependency").map(_ attr "identifierref" required string)
    val metadata = resourceElement childElem "metadata" optional parseMetadata _
    //TODO: check for invalid SCORM type and absent href
    if (scormType == "sco") new ScoResource(identifier, href.get, base, files, dependencies, metadata)
    else new AssetResource(identifier, href, base, files, dependencies, metadata)
  }
}