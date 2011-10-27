package com.arcusys.scorm.service

import java.io._
import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.model.parsers.ManifestParser
import com.arcusys.scorm.model._
import org.scalatra.ScalatraServlet
import org.scalatra.fileupload.FileUploadSupport
import scala.io.Source._
import scala.xml.XML
import com.arcusys.scorm.service.util.PathBuilder._
import com.arcusys.scorm.service.util.FileProcessing

class UploadService extends ScalatraServlet with FileUploadSupport
{
  post("/package") {
    contentType = "text/plain"
    val title = params.getOrElse("title", "New package")
    val summary = params.getOrElse("summary", "")
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val packageTmpUUID = getTempUUID
    val newFilename = outputRealDir + "zipPackages/" + packageTmpUUID + ".zip"
    
    val outFile = new File(newFilename)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)
    
    processPackage(title, summary, packageTmpUUID)
    
    "{success:true}"
  }
    
  private def getTempUUID =
  {
    val tmpFile = File.createTempFile("SCORMZip_", ".tmp")
    val packageTmpUUID = tmpFile.getName
    tmpFile.delete
    
    packageTmpUUID
  }
  
  private def processPackage(packageTitle:String, packageSummary: String, packageTmpUUID:String) =
  {
    val newFileName = outputRealDir + "zipPackages/" + packageTmpUUID + ".zip"
    FileProcessing.unzip(outputRealDir + "data/" + packageTmpUUID + "/", newFileName)
    (new File(newFileName)).delete // delete zip-file
    
    val root = XML.loadFile(new File(outputRealDir + "data/" + packageTmpUUID + "/imsmanifest.xml"))
    val manifest = new ManifestParser(root).parse
    val pack = getPackageStorage.create(new Manifest(manifest.identifier,
                                                     None, // version
                                                     manifest.base,
                                                     manifest.metadata,
                                                     manifest.defaultOrganizationIdentifier,
                                                     manifest.resourcesBase,
                                                     packageTitle,
                                                     Some(packageSummary)))

    //if (pack._1 != packageTmpUUID) throw new Exception("Error creating new package from manifest. ID issue")
    val packageUUID = pack._1
    val oldOutDir = new File(outputRealDir + "data/" + packageTmpUUID + "/")
    oldOutDir.renameTo(new File(outputRealDir + "data/" + packageUUID + "/"))
    
    for (organization<-manifest.organizations) {
      val createdOrganization = getOrganizationsStorage.create(packageUUID, organization._2)
      for (activity<-organization._2.activities) {
        activity match {
          case l: LeafActivity => getActivitiesStorage.create(packageUUID, createdOrganization._2.identifier, activity, None)
          case c: ContainerActivity => parseContainerActivity(createdOrganization._2.identifier, c, None)
        }
      }
    }

    for (resource<-manifest.resources)
      getResourcesStorage.create(packageUUID, resource._2)
    
    def parseContainerActivity(organizationID: String, container: ContainerActivity, parentID: Option[Int]): Activity =
    {
      val createdContainer = getActivitiesStorage.create(packageUUID, organizationID, container, parentID)
      for (childActivity<-container.childActivities)
      {
        childActivity match {
          case l: LeafActivity => getActivitiesStorage.create(packageUUID, organizationID, childActivity, Some(createdContainer._1))
          case c: ContainerActivity => parseContainerActivity(organizationID, c, Some(createdContainer._1))
        }
      }
      createdContainer._2
    }
  }
}
