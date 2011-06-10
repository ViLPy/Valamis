package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import scala.xml.Elem
import XMLImplicits._

class MetadataParser(val metadataElement: Elem) {
  def parse = {
    val locationElements = metadataElement \ ("adlcp","location")
    val allChildElements = metadataElement.child
    val metadata = new Metadata()
    //TODO: Bring all collections into constructors, start with these ones    
    locationElements.foreach(locationElement => {
        metadata.externalMetadataLocations += locationElement.text
      })
    for (childElement <- allChildElements if childElement.isInstanceOf[Elem]) {
      val name = childElement.asInstanceOf[Elem].label
      if (!(name.equals("schema") || name.equals("schemaversion") || name.equals("location"))) {
        metadata.inlineMetadata += childElement.asInstanceOf[Elem].toString
      }
    }
    metadata
  }

  def parseForManifest = {
    val schemaElement = metadataElement \! "schema"
    val schemaVersionElement = metadataElement \! "schemaversion"
    val manifestMetadata = new ManifestMetadata(schemaElement.text, schemaVersionElement.text)
    val metadata = parse
    manifestMetadata.externalMetadataLocations ++= metadata.externalMetadataLocations
    manifestMetadata.inlineMetadata ++= metadata.inlineMetadata
    manifestMetadata
  }
}