package com.arcusys.scorm.service

import org.scalatra.ScalatraServlet
import scala.xml._
import com.arcusys.scorm.model._
import com.arcusys.scorm.service.StorageFactory._

class ResourcesService extends ScalatraServlet
{
  get("/package/:packageID") {
    val packageID = params.getOrElse("packageID", halt(405, "Package is not specified")).toInt
    buildOutput(getResourcesStorage.getByPackageID(packageID)).toString
  }

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