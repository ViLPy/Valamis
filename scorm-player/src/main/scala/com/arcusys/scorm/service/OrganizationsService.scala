package com.arcusys.scorm.service

import org.scalatra.ScalatraServlet
import scala.xml._
import com.arcusys.scorm.model._
import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.service._
import com.arcusys.scorm.util.JSON._

class OrganizationsService extends ScalatraServlet
{
  before() { contentType = "text/html" }
  
  get("/package/:packageID") {
    val packageID = params.getOrElse("packageID", halt(405, "ID is not specified")).toInt
    toJSON(buildOutputJSON(getOrganizationsStorage.getByPackageID(packageID)))
  }

  private def buildOutputJSON(sequence: IndexedSeq[Organization]) =
  {
    sequence.map(organization => Map("id"->organization.identifier,
                                     "title"->organization.title))
  }
}