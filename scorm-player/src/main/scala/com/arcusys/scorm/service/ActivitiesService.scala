package com.arcusys.scorm.service

import org.scalatra.ScalatraServlet
import com.arcusys.scorm.model._
import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.util.JSON._
import com.arcusys.scorm.service.util.PathBuilder._

class ActivitiesService extends ScalatraServlet
{
  before() { contentType = "text/html" }
  
  get("/package/:packageID/organization/:organizationID") {
    val packageID = params.getOrElse("packageID", halt(405, "Package is not specified")).toInt
    val organizationID = params.getOrElse("organizationID", halt(405, "Organization is not specified"))
    toJSON(buildOutputJSON(getActivitiesStorage.getAllByParam(packageID, organizationID)))
  }

  get("/package/:packageID/organization/:organizationID/activity/:id") {
    val packageID = params.getOrElse("packageID", halt(405, "Package is not specified")).toInt
    val organizationID = params.getOrElse("organizationID", halt(405, "Organization is not specified"))
    val id = params.getOrElse("id", halt(405, "ID is not specified"))
    try { toJSON(buildOutputJSON(getActivitiesStorage.getByID(packageID, organizationID, id).get))}
    catch { case _=> halt(404) }
  }
  
  get("/package/:packageID/organization/:organizationID/activity/:id/GetResource") {
    val packageID = params.getOrElse("packageID", halt(405, "Package is not specified")).toInt
    val organizationID = params.getOrElse("organizationID", halt(405, "Organization is not specified"))
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    contentType = "text/plain"
    
    val activity = getActivitiesStorage.getByID(id).get
    if (!activity.isInstanceOf[LeafActivity]) halt()
    val resource = getResourcesStorage.getByID(packageID, activity.asInstanceOf[LeafActivity].resourceIdentifier)
    buildURL(packageID, 
             resource.get.href.getOrElse("") + activity.asInstanceOf[LeafActivity].resourceParameters.getOrElse(""),
             getPackageStorage.getByID(packageID).get.base.getOrElse(""),
             resource.get.base.getOrElse(""))//TODO: what if no url
  }
  
  /*------------------
   *  JSON support
   *------------------*/

  private def buildOutputJSON(activity: Activity): Map[String ,Any] =
  {
    def writeContainerField =
    {
      val asContainer = activity.asInstanceOf[ContainerActivity]
      (for(activity<-asContainer.childActivities) yield buildOutputJSON(activity))
    }

    def writeLeafField =
    {
      val asLeaf = activity.asInstanceOf[LeafActivity]
      Map(
        "resourceID"->asLeaf.resourceIdentifier,
        "resourceParam"->asLeaf.resourceParameters.getOrElse("")
      )
    }

    Map(
      "id"->activity.identifier,
      "title"->activity.title,
      "visible"->activity.visible,
      "childActivities" -> (if (activity.isInstanceOf[ContainerActivity]) writeContainerField else Seq()),
      "leafData" -> (if (activity.isInstanceOf[LeafActivity]) writeLeafField else Map())
    )
  }

  private def buildOutputJSON(sequence: IndexedSeq[Activity]): IndexedSeq[Map[String,Any]] =
  {
    sequence.map(activity => buildOutputJSON(activity))
  }
 
}