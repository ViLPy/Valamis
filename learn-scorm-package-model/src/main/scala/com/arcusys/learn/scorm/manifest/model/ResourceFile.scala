package com.arcusys.learn.scorm.manifest.model

/**
 * A reference to an individual file in the resource
 * @param href      Resource file URL relative to package base, resources common base and resource base
 * @param metadata  Optional metadata for this resource file
 */
class ResourceFile(val href: String, val metadata: Option[Metadata] = None) {
  require(!href.startsWith("/"), "Resource file URL should not start with a '/'")
  require(!href.contains("?"), "Resource file URL should not have parameters specified")
  require(!href.contains("//"), "Resource file URL should not be global")
}