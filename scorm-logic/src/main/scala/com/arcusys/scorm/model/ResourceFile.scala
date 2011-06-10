package com.arcusys.scorm.model

case class ResourceFile(
  /**
   * Resource file URL relative to package base, resources common base and resource base
   */
  href: String,
  /**
   * Metadata describing the resource file
   */
  metadata: Option[Metadata])