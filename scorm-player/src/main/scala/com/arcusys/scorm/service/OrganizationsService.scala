package com.arcusys.scorm.service

import javax.ws.rs._
import javax.ws.rs.core._
import scala.xml._
import com.arcusys.scorm.model._
import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.service.JSON._

class OrganizationsService(val packageID: Int)
{
  @GET
  def getAll = toJSON(buildOutputJSON(getOrganizationsStorage.getByPackageID(packageID)))

  @Path("{organizationID}/Activities")
  def getActivitiesService(@PathParam("organizationID") id:String) = new ActivitiesService(packageID, id)

  private def buildOutputXML(sequence: IndexedSeq[Organization]) =
  {
    <organizations>
      {
        for(organization<-sequence) yield
          <organization id={organization.identifier} title={organization.title}/>
      }
    </organizations>
  }
  
  private def buildOutputJSON(sequence: IndexedSeq[Organization]) =
  {
    (for(organization<-sequence) yield
      (Map("id"->organization.identifier,
           "title"->organization.title))
    )
  }
}