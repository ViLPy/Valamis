package com.arcusys.scorm.model
import scala.collection.mutable.Buffer

class Metadata {
  val externalMetadataLocations = Buffer[String]()
  val inlineMetadata = Buffer[String]()
}