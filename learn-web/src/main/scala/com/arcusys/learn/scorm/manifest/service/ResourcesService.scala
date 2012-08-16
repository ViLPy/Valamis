package com.arcusys.learn.scorm.manifest.service

import org.scalatra.ScalatraServlet
import scala.xml._
import com.arcusys.learn.scorm.manifest.model._

class ResourcesService extends ScalatraServlet
{
  /*get("/package/:packageID") {
    val packageID = parameter("packageID").intRequired
    buildOutput(resourceStorage.getByPackageID(packageID)).toString
  }

  private def buildOutput(sequence: Seq[Resource]) =
  {
    //TODO: what if no base and href
    <resources>
      {for(resource<-sequence) yield
        <resource id={resource.scormIdentifier} base={resource.base.getOrElse("")} href={resource.href.getOrElse("")}>
            <resourceType>{resource.resourceType}</resourceType>
            <resourceFiles>{for (file<-resource.files) yield (<file href={file.href}/>)}</resourceFiles>
            <dependencies>{for (id<-resource.dependencyIds) yield (<dependencyID id={id}/>)}</dependencies>
        </resource>
      }
    </resources>
  }*/
}