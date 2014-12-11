package com.arcusys.learn.scorm.manifest.model

import com.arcusys.learn.scorm.manifest.model.PackageType._
import com.arcusys.learn.scorm.manifest.model.PeriodType.PeriodType
import com.arcusys.learn.util.TreeNode

import scala.collection.mutable

/**
 * SCORM Manifest together with all its content
 * @param manifest              The manifest itself
 * @param organizations         All content organizations together with their activities
 * @param resources             All resources
 * @param sequencingCollection  Shared sequencing collection
 */
class ManifestDocument(
    val manifest: Manifest,
    val organizations: Seq[TreeNode[Activity]],
    val resources: Seq[Resource],
    val sequencingCollection: Seq[Sequencing]) {
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

  val resourceMap = resources.map(r => r.id -> r).toMap

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
 * @param metadata              Manifest metadata, if any
 */
case class Manifest(
    id: Int,
    version: Option[String],
    base: Option[String],
    scormVersion: String,
    defaultOrganizationID: Option[String],
    resourcesBase: Option[String],
    title: String,
    summary: Option[String] = None,
    metadata: Option[Metadata] = None,
    assetRefID: Option[Long] = None,
    courseID: Option[Int],

    visibility: Option[Boolean] = None,
    logo: Option[String] = None,
    isDefault: Boolean,
    passingLimit: Int = 0,
    rerunInterval: Int = 0,
    rerunIntervalType: PeriodType = PeriodType.UNLIMITED) extends BaseManifest {
  base foreach {
    value => require(!value.startsWith("/") && value.endsWith("/"), "If common base is defined, it should not start with a '/' and should end with a '/'")
  }
  resourcesBase foreach {
    value => require(!value.startsWith("/") && value.endsWith("/"), "If resources base is defined, it should not start with a '/' and should end with a '/'")
  }

  def getType: PackageType = PackageType.SCORM
  def getId: Int = id
  def getTitle: String = title
  def getSummary: Option[String] = summary
  def getVisibility: Option[Boolean] = visibility
  def getDefault: Boolean = isDefault
  def getPassingLimit: Int = passingLimit
  def getRerunInterval: Int = rerunInterval
  def getRerunIntervalType: PeriodType = rerunIntervalType

  def getLogo: String = logo.getOrElse("")
}