package com.arcusys.scorm.service

import java.util.Properties
import javax.ws.rs._
import javax.ws.rs.core._
import scala.xml._
import com.arcusys.scorm.model._
import com.arcusys.scorm.service.StorageFactory._

object PathBuilder
{
  // get real path to .class file
  val sourceLocation = getClass.getProtectionDomain.getCodeSource.getLocation.getPath
  // extract path to SCORM packages data directory
  lazy val outputRealDir = sourceLocation.substring(0, sourceLocation.lastIndexOf("/WEB-INF")) + "/SCORMData/"
  lazy val outputWebDir = {
    val properties = new Properties
    val resourceStream = Thread.currentThread.getContextClassLoader.getResourceAsStream("resources.properties")
    properties.load(resourceStream)
    properties.getProperty("outputWebDir","")
  }


  def buildRealPath(packageID: Int, resourceHref: String, manifestBase: String = "", resourceBase: String = ""):String =
  {
    (outputRealDir + "data/" + 
     packageID.toString + "/" + 
     (if (!manifestBase.isEmpty) {manifestBase + "/"} else "") + 
     (if (!resourceBase.isEmpty) {resourceBase + "/"} else "") + 
     resourceHref)
  }
  
  def buildURL(packageID: Int, resourceHref: String, manifestBase: String, resourceBase: String):String =
  {
    (outputWebDir + "data/" + 
     packageID.toString + "/" + 
     (if (!manifestBase.isEmpty) {manifestBase + "/"} else "") + 
     (if (!resourceBase.isEmpty) {resourceBase + "/"} else "") + 
     resourceHref)
  }
}

class ResourcesService(val packageID: Int)
{
  @GET
  def getAll = buildOutput(getResourcesStorage.getByPackageID(packageID)).toString

  private def buildOutput(sequence: IndexedSeq[Resource]) =
  {
    //TODO: what if no base and href
    <resources>
      {for(resource<-sequence) yield
        <resource id={resource.identifier} base={resource.base.getOrElse("")} href={resource.href.getOrElse("")}>
            <resourceType>{resource.resourceType}</resourceType>
            <resourceFiles>{for (file<-resource.files) yield (<file href={file.href}/>)}</resourceFiles>
            <dependencies>{for (id<-resource.dependencyIdentifiers) yield (<dependencyID id={id}/>)}</dependencies>
        </resource>
      }
    </resources>
  }
}