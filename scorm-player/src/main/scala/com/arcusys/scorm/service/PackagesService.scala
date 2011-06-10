package com.arcusys.scorm.service

import javax.ws.rs._
import javax.ws.rs.core._
import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.service.JSON._
import com.arcusys.scorm.model._
import scala.xml._

@Path("/Packages")
class PackagesService
{
  @GET
  def getAllByDefault() = 
    toJSON(buildJSONResponse("id","asc",getPackageStorage.getAll))
  
  @GET
  @Path("/Sorted")
  def getAll(@QueryParam("sidx") sidx:String,
             @QueryParam("sord") sord:String = "asc") = 
               toJSON(buildJSONResponse(sidx, sord, getPackageStorage.getAll))

  @Path("{id}/Organizations")
  def getOrganizationsService(@PathParam("id") id:Int) = new OrganizationsService(id)

  @Path("{id}/Resources")
  def getResourcesService(@PathParam("id") id:Int) = new ResourcesService(id)

  @POST
  @Path("/UpdateTitle")
  def updatePackagesTitle(values: String) =
  {
    val properties = Map(
      values.split("&").map{ // split input string into an array
        property => // map it into a key-value array
        property.substring(0, property.indexOf("=")) -> property.substring(property.indexOf("=") + 1) // extract key and value from string
      }:_*) // cast into a Map[String, String]
    
    val id = properties("id")
    val currentManifest = getPackageStorage.getByID(id.toInt).get
    val updatedManifest = new Manifest(id,
                                       None,
                                       currentManifest.base,
                                       currentManifest.metadata,
                                       currentManifest.defaultOrganizationIdentifier,
                                       currentManifest.resourcesBase,
                                       properties("title"),
                                       Some(properties("summary")))
    getPackageStorage.modify(id.toInt, updatedManifest)
    Response.ok("{\"message\":\"\",\"id\":"+id+"}").build
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
      
    Map("total"->1,
        "page"->0,
        "records"->newSeq.size,
        "rows" ->newSeq.map(pack=>Map("id"->pack.identifier,
                                      "cell"->List(pack.identifier, pack.title, pack.summary.getOrElse("")))))
  }

  /* @GET
   @Path("{id}/Activities")
   def getAllActivitiesFromGivenPackage(@PathParam("id") id:String) = {} */
}
