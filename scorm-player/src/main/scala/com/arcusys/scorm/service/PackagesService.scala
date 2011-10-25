package com.arcusys.scorm.service

import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.util.JSON._
import com.arcusys.scorm.model._
import org.scalatra.ScalatraServlet
import scala.xml._

class PackagesService extends ScalatraServlet
{
  before() { contentType = "text/html" }
  
  get("/") {
    toJSON(buildJSONResponse("id","asc",getPackageStorage.getAll))
  }
  
  get("/Sorted") {
    val paramSidx = params.getOrElse("sidx","")
    val paramSord = params.getOrElse("sord","asc")
    toJSON(buildJSONResponse(paramSidx, paramSord, getPackageStorage.getAll))
  }

  post("/UpdateTitle") {
    val id = params.getOrElse("id", halt(405, "ID is not specified"))
    val title = params.getOrElse("title", "")
    val summary = params.getOrElse("summary", "")
    
    val currentManifest = getPackageStorage.getByID(id.toInt).get
    val updatedManifest = new Manifest(id,
                                       None,
                                       currentManifest.base,
                                       currentManifest.metadata,
                                       currentManifest.defaultOrganizationIdentifier,
                                       currentManifest.resourcesBase,
                                       title,
                                       Some(summary))
    getPackageStorage.modify(id.toInt, updatedManifest)
    
    toJSON(Map("message"->"", "id"->id))
  }

  private def buildJSONResponse(sidx:String, sord:String, sequence:IndexedSeq[Manifest]) =
  {
    // sorting
    val newSeq = sidx match {
      case "title" => sequence.sortWith((e1,e2) => 
          (if (sord.equals("asc")) e1.title.toLowerCase < e2.title.toLowerCase
           else e1.title.toLowerCase > e2.title.toLowerCase ))
        // or by id
      case _ => sequence.sortWith((e1,e2) => 
          (if (sord.equals("asc")) e1.identifier.toLowerCase < e2.identifier.toLowerCase
           else e1.identifier.toLowerCase > e2.identifier.toLowerCase ))
    }
    // create data structure for jqGrid
    Map("total"->1,
        "page"->0,
        "records"->newSeq.size,
        "rows" ->newSeq.map(pack=>Map("id"->pack.identifier,
                                      "cell"->List(pack.identifier, pack.title, pack.summary.getOrElse("")))))
  }

}
