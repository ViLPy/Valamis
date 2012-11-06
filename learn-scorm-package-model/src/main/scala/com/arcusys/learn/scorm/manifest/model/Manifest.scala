package com.arcusys.learn.scorm.manifest.model

import collection.mutable
import com.arcusys.learn.util.TreeNode

/**
 * SCORM Manifest together with all its content
 * @param manifest              The manifest itself
 * @param organizations         All content organizations together with their activities
 * @param resources             All resources
 * @param sequencingCollection  Shared sequencing collection
 */
class ManifestDocument
(
  val manifest: Manifest,
  val organizations: Seq[TreeNode[Activity]],
  val resources: Seq[Resource],
  val sequencingCollection: Seq[Sequencing]
  ) {
  /** Map of all activities by ID */
  val allActivities: Map[String, Activity] = {
    val activitiesBuilder = mutable.Map[String, Activity]()
    def parse(node: TreeNode[Activity]) {
      if (activitiesBuilder.contains(node.item.id)) throw new IllegalArgumentException("Activity IDs in manifest not unique")
      activitiesBuilder(node.item.id) = node.item
      node.children foreach parse
    }
    organizations foreach parse
    activitiesBuilder.toMap
  }

  val resourceMap = resources.map(r=>r.id->r).toMap

  resources.foreach(resource =>
    resource.dependencyIds.foreach(dependencyIdentifier =>
      if (!resourceMap.contains(dependencyIdentifier)) throw new IllegalArgumentException("Resource contains dependency referencing a non-existing resource: " + dependencyIdentifier)
    )
  )
}

/**
 * A SCORM manifest
 * @param id                    Internal database ID of SCORM manifest
 * @param version               Version of manifest, if specified
 * @param base                  Common base for all files the manifest references
 * @param defaultOrganizationID ID of default organization. Should be specified if at least one organization is present
 * @param resourcesBase         Common base for resource files, relative to common base
 * @param title                 Package title in the LMS
 * @param summary               Package description in the LMS
 * @param visibility            True if package should be available for selection in the LMS
 * @param metadata              Manifest metadata, if any
 */
class Manifest
(
  val id: Int,
  val version: Option[String],
  val base: Option[String],
  val scormVersion: String,
  val defaultOrganizationID: Option[String],
  val resourcesBase: Option[String],
  val title: String,
  val summary: Option[String] = None,
  val visibility: Boolean = true,
  val metadata: Option[Metadata] = None,
  val assetRefID: Option[Long] = None
  )
{
  base foreach {
    value => require(!value.startsWith("/") && value.endsWith("/"), "If common base is defined, it should not start with a '/' and should end with a '/'")
  }
  resourcesBase foreach {
    value => require(!value.startsWith("/") && value.endsWith("/"), "If resources base is defined, it should not start with a '/' and should end with a '/'")
  }
}