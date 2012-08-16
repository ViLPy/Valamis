package com.arcusys.learn.scorm.manifest.model

/**
 * A SCORM resource able to be displayed to the user
 * @param id            Identifier of the resource. Unique within the containing manifest
 * @param href          URL of the launching point of the resource. May be a fully qualified external resource URL or
 *                      point to a resource file within package. In the latter case it's
 *                      relative to package base, resources common base and resource base. May not start with '/'.
 *                      May contain parameters if they're needed.
 *                      May be None for asset resources, in this case the resource is not launchable and acts as a potential dependency for other resources
 * @param base          Base URL for files within this resource relative to package base and resources common base
 * @param files         Collection of package-local files needed by the resource. All such files must be listed here
 * @param dependencyIds IDs of resources this resource depends on
 * @param metadata      Optional metadata for this resource
 */
sealed abstract class Resource
(
  val id: String,
  val href: Option[String],
  val base: Option[String],
  val files: Seq[ResourceFile],
  val dependencyIds: Seq[String],
  val metadata: Option[Metadata]
  ) {
  base foreach {
    value => require(!value.startsWith("/") && value.endsWith("/"), "If resource base is defined, it should not start with a '/' and should end with a '/'")
  }
  href foreach {
    value => require(!value.startsWith("/"), "Resource URL should not start with a '/'")
  }
}

/**
 * SCO (Shareable Content Object) - a SCORM resource which is able to communicate with the Run-Time Environment
 * @param id            Identifier of the resource. Unique within the containing manifest
 * @param href          URL of the launching point of the resource. May be a fully qualified external resource URL or
 *                      point to a resource file within package. In the latter case it's
 *                      relative to package base, resources common base and resource base. May not start with '/'
 *                      May contain parameters if they're needed.
 * @param base          Base URL for files within this resource relative to package base and resources common base
 * @param files         Collection of package-local files needed by the resource. All such files must be listed here
 * @param dependencyIds IDs of resources this resource depends on
 * @param metadata      Optional metadata for this resource
 */
class ScoResource
(
  id: String,
  href: String,
  base: Option[String],
  files: Seq[ResourceFile],
  dependencyIds: Seq[String],
  metadata: Option[Metadata] = None
  ) extends Resource(id, Some(href), base, files, dependencyIds, metadata)

/**
 * Asset - a SCORM resource which does not communicate with the Run-Time Environment
 * @param id            Identifier of the resource. Unique within the containing manifest
 * @param href          URL of the launching point of the resource. May be a fully qualified external resource URL or
 *                      point to a resource file within package. In the latter case it's
 *                      relative to package base, resources common base and resource base. May not start with '/'.
 *                      May contain parameters if they're needed.
 *                      May be None, in this case the resource is not launchable and acts as a potential dependency for other resources
 * @param base          Base URL for files within this resource relative to package base and resources common base
 * @param files         Collection of package-local files needed by the resource. All such files must be listed here
 * @param dependencyIds IDs of resources this resource depends on
 * @param metadata      Optional metadata for this resource
 */
class AssetResource
(
  id: String,
  href: Option[String],
  base: Option[String],
  files: Seq[ResourceFile],
  dependencyIds: Seq[String],
  metadata: Option[Metadata] = None
  ) extends Resource(id, href, base, files, dependencyIds, metadata)