package com.arcusys.scorm.model

import scala.collection.mutable.Map

class Manifest(
  /**
   * Manifest identifier
   */
  val id: String,
  /**
   * Version of the manifest. Used to disrtinguish between manifests with the same identifier
   */
  val version: Option[String],
  val base: Option[String],
  val metadata: ManifestMetadata,
  val defaultOrganizationIdentifier: Option[String],
  val resourcesBase: Option[String],
  val title: String,
  val summary: Option[String] = None,
  val visibility: Boolean = true)
{
  val organizations = Map[String, Organization]()
  val allActivities = Map[String, Activity]();
  val resources = Map[String, Resource]();
  val sequencingCollection = Map[String, Sequencing]();

  def getFullResourceUrl(resource: Resource): String = {
    assert(resource != null)
    assert(resource.href != null)
    base.getOrElse("") + resourcesBase.getOrElse("") + resource.base.getOrElse("") + resource.href.getOrElse("")
  }

  def getFullActivityUrl(activity: LeafActivity): String = {
    assert(activity != null)
    val resource = resources(activity.resourceIdentifier);
    val resourceUrl = getFullResourceUrl(resource);
    var parameters = activity.resourceParameters.getOrElse("")
    while (parameters.startsWith("?") || parameters.startsWith("&")) parameters = parameters.substring(1)
    if (parameters.startsWith("#")) {
      if (resourceUrl.contains("#")) resourceUrl else resourceUrl + parameters
    } else {
      if (resourceUrl.contains("?")) resourceUrl + "&" + parameters else resourceUrl + "?" + parameters
    }
  }

  def getFullActivityUrl(activityIdentifier: String): String = {
    val activity = allActivities(activityIdentifier)
    if (!(activity.isInstanceOf[LeafActivity])) throw new IllegalArgumentException("activityIdentifier should reference a leaf activity")
    getFullActivityUrl(activity.asInstanceOf[LeafActivity])
  }

  def getFullResourceUrl(resourceIdentifier: String): String = {
    val resource = resources(resourceIdentifier)
    if (resource == null) throw new IllegalArgumentException("Resource with given identifier not found")
    if (resource.href == null) throw new IllegalArgumentException("Resource with given identifier does not have a location URL specified")
    getFullResourceUrl(resource)
  }

  def getFullFileUrl(resource: Resource, resourceFile: ResourceFile): String = {
    assert(resource != null)
    assert(resourceFile != null)
    assert(resourceFile.href != null)    
    base.getOrElse("") + resourcesBase.getOrElse("") + resource.base.getOrElse("") + resourceFile.href
  }

  def getFullFileUrl(resourceIdentifier: String, resourceFile: ResourceFile): String = {
    val resource = resources(resourceIdentifier)
    if (resource == null) throw new IllegalArgumentException("Resource with given identifier not found")    
    if (resourceFile == null) throw new IllegalArgumentException("Resource file cannot be null")
    getFullFileUrl(resource, resourceFile)
  }
}