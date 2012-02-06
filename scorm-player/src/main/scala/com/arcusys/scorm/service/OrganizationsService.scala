package com.arcusys.scorm.service

import org.scalatra.ScalatraServlet
import scala.xml._
import com.arcusys.scala.scalatra.json.JsonSupport
import com.arcusys.scorm.model._
import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.service._

class OrganizationsService extends ScalatraServlet with JsonSupport
{
  before() { contentType = "text/html" }
  
  get("/package/:packageID") {
    val packageID = params.getOrElse("packageID", halt(405, "ID is not specified")).toInt
    json(buildOutputJSON(getOrganizationsStorage.getByPackageID(packageID)))
  }

  private def buildOutputJSON(sequence: IndexedSeq[Organization]) =
  {
    sequence.map(organization => Map("id"->organization.id,
                                     "title"->organization.title))
  }
}