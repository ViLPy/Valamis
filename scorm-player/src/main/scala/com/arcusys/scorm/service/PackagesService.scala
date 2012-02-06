package com.arcusys.scorm.service

import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scala.scalatra.json.JsonSupport
import com.arcusys.scorm.model._
import org.scalatra.ScalatraServlet
import scala.xml._

class PackagesService extends ScalatraServlet with JsonSupport
{
  before() { contentType = "text/html" }
  
  get("/") {
    json(buildJSONResponse("title","asc",getPackageStorage.getOnlyVisible))
  }
  
  get("/Sorted") {
    val paramSidx = params.getOrElse("sidx","")
    val paramSord = params.getOrElse("sord","asc")
    json(buildJSONResponse(paramSidx, paramSord, getPackageStorage.getAll))
  }

  post("/UpdateVisibility") {
    // maybe need separated SQL script to avoid updating all the fields
    val id = params.getOrElse("id", -1).toString
    val visibility = params.getOrElse("visibility" , false).toString.toBoolean
    val updateAll = params.getOrElse("all", false).toString.toBoolean

    def updatePackage(pkg: Manifest) = {
      val updatedManifest = new Manifest(pkg.id,
                                         None,
                                         pkg.base,
                                         pkg.metadata,
                                         pkg.defaultOrganizationIdentifier,
                                         pkg.resourcesBase,
                                         pkg.title,
                                         pkg.summary,
                                         visibility)
      getPackageStorage.modify(pkg.id.toInt, updatedManifest)
    }
    
    if (updateAll) {
      getPackageStorage.getAll.foreach(pkg=> {
          updatePackage(pkg)
        })
    } else {
      val pkg = getPackageStorage.getByID(id.toInt).getOrElse(halt(404, "can't find package with id " + id))
      updatePackage(pkg)
    }
  }
  
  post("/UpdateTitle") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val title = params.getOrElse("title", "")
    val summary = params.getOrElse("summary", "")
    val visibility = params.getOrElse("visibility" , false).toString.toBoolean
    val operation = params.getOrElse("oper", "")
    
    if (operation == "del") {
      getPackageStorage.delete(id)
    } else {
      val currentManifest = getPackageStorage.getByID(id).get
      val updatedManifest = new Manifest(id.toString,
                                         None,
                                         currentManifest.base,
                                         currentManifest.metadata,
                                         currentManifest.defaultOrganizationIdentifier,
                                         currentManifest.resourcesBase,
                                         title,
                                         Some(summary),
                                         visibility)
      getPackageStorage.modify(id, updatedManifest)
    
      json(Map("message"->"", "id"->id))
    }
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
          (if (sord.equals("asc")) e1.id.toLowerCase < e2.id.toLowerCase
           else e1.id.toLowerCase > e2.id.toLowerCase ))
    }
    // create data structure for jqGrid
    Map("total"->1,
        "page"->0,
        "records"->newSeq.size,
        "rows" ->newSeq.map(pack=>Map("id"->pack.id,
                                      "cell"->List(pack.id, pack.title, pack.summary.getOrElse(""), pack.visibility))))
  }

}
