package com.arcusys.scorm.model

import scala.collection.mutable.Buffer

class Resource(
  val identifier: String,
  val resourceType: String,
  val href: Option[String],
  /**
   * Base URL for files within this resource relative to package base and resources common base
   */
  val base: Option[String],
  val scormType: ResourceScormType.Value,
  /**
   * Metadata describing the resource
   */
  val metadata: Option[Metadata]
) {
  val files = Buffer[ResourceFile]()
  val dependencyIdentifiers = Buffer[String]()
}