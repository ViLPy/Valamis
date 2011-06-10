package com.arcusys.scorm.service

import javax.ws.rs._
import javax.ws.rs.core._
import scala.xml._
import com.arcusys.scorm.model._
import com.arcusys.scorm.service.StorageFactory._
import com.sun.jersey.api.NotFoundException
import com.arcusys.scorm.service.JSON._
import com.arcusys.scorm.service.PathBuilder._

class ActivitiesService(val packageID: Int, val organizationID: String)
{
  @GET
  def getAll = toJSON(buildOutputJSON(getActivitiesStorage.getAllByParam(packageID, organizationID))) //throw new Exception(">-- " + getActivitiesStorage.getAllByParam(packageID, organizationID).toString)//

  @GET
  @Path("{id}")
  def getByID(@PathParam("id") id:String) = 
    try { toJSON(buildOutputJSON(getActivitiesStorage.getByID(packageID, organizationID, id).get))}
  catch { case _=> new NotFoundException }
  
  @GET
  @Path("{id}/GetResource")
  def getResource(@PathParam("id") id: Int) = 
  {
    val activity = getActivitiesStorage.getByID(id).get
    if (!activity.isInstanceOf[LeafActivity]) throw new NotFoundException
    val resource = getResourcesStorage.getByID(packageID, activity.asInstanceOf[LeafActivity].resourceIdentifier)
    buildURL(packageID, 
             resource.get.href.getOrElse("") + activity.asInstanceOf[LeafActivity].resourceParameters.getOrElse(""),
             getPackageStorage.getByID(packageID).get.base.getOrElse(""),
             resource.get.base.getOrElse(""))//TODO: what if no url
  }
  
  /*------------------
   *  XML support
   *------------------*/
   private def buildOutputXML(activity: Activity): Elem =
   {
      def writeContainerField:Elem =
      {
        val asContainer = activity.asInstanceOf[ContainerActivity]
        buildOutputXML(asContainer.childActivities.toIndexedSeq)
      }

      def writeLeafField:Elem =
      {
        val asLeaf = activity.asInstanceOf[LeafActivity]
        <leafData>
          <resourceID>{asLeaf.resourceIdentifier}</resourceID>
          <resourceParam>{asLeaf.resourceParameters}</resourceParam>
        </leafData>
      }

      <activity id={activity.identifier} title = {activity.title} visible={activity.visible.toString}>
        { if (activity.isInstanceOf[ContainerActivity]) writeContainerField
         else if (activity.isInstanceOf[LeafActivity]) writeLeafField }
      </activity>
    }

   private def buildOutputXML(sequence: IndexedSeq[Activity]): Elem =
   {
      <activities>{for(activity<-sequence) yield buildOutputXML(activity)}</activities>
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
      (for(activity<-sequence) yield buildOutputJSON(activity))
    }
 
   }