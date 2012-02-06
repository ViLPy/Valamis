package com.arcusys.scorm.service

import java.io._
import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.model.parsers.ManifestParser
import com.arcusys.scala.json.Json._
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
    val title = params.getOrElse("title", "New package")
    val summary = params.getOrElse("summary", "")
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val packageTmpUUID = getTempUUID
    val newFilename = outputRealDir + "zipPackages/" + packageTmpUUID + ".zip"
    
    val outFile = new File(newFilename)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)
    
    processPackage(title, summary, packageTmpUUID)
    
    toJson(("success"->true))
  }
  
  post("/get-images") {
    contentType = "text/plain"
    val subdir = params.getOrElse("subdir","")
    val subdirPath = if(!subdir.equals("")) subdir+"/" else ""
    val imagePath = servletContext.getContextPath + "/SCORMData/images/"+ subdirPath
    val path = outputRealDir + "images/" + subdirPath
    val listFiles = new File(path).listFiles.toSeq
    val sortedFiles = listFiles.sortBy(_.isFile)
    
    toJson(sortedFiles.map
         (file=>{
          val fileName = file.getName
          if(!file.isDirectory){
            Map( "subdir"->subdirPath, "thumb"->(imagePath+fileName),"image"->(imagePath+fileName),"name"->fileName,"isDirectory"->false)
          }
          else{
            Map("subdir"->subdirPath,"name"->fileName,"isDirectory"->true)
          }
        }))
  }  
  
  post("/upload-image") {
    contentType = "text/plain"
    val directory = params.getOrElse("currentDirectory","")
    val currentDirectory = if(!directory.equals("")) directory+"/" else ""
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val fullName = fileParams.get("file").head.getName // IE returns absolute path, e.g. C:/users/anonymouse/Docs/pict.jpg Need to trim it
    val name = new File(fullName).getName
    val path = outputRealDir + "images/"+currentDirectory + name
    val outFile = new File(path)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)
    val imageName = servletContext.getContextPath + "/SCORMData/images/"+ currentDirectory+name
    contentType = "text/html"
    "<img src=\""+imageName+"\"/>"
  }
  
  post("/upload-file") {
    contentType = "text/plain"
    val stream = fileParams.get("file").head.getInputStream // take only the first
    val name=fileParams.get("file").head.getName
    
    val splittedFileName = name.lastIndexOf('.') match {
      case -1 => (name,"")
      case x:Int => (name.substring(0,x),name.substring(x).toLowerCase)
    }
    
    val generatedName=getFileUUID(splittedFileName._1,splittedFileName._2)
    val path = outputRealDir + "files/"+ generatedName
    val outFile = new File(path)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)
    val fileName = servletContext.getContextPath + "/SCORMData/files/"+generatedName
    contentType = "text/html"
    "<a href=\""+fileName+"\" rel=\""+name+"\" class=\"redactor_file_link redactor_file_ico_other\">"+name+"</a>"
  }
  
  post("/create-folder"){
    contentType = "text/plain"
    val folderName = params.getOrElse("folderName","")
    val folder = params.getOrElse("folderPath","")
    val folderPath = if(!folder.equals("")) folder+"/" else folder
    val path = outputRealDir + "images/"+folderPath+folderName
    val result = new File(path).mkdir
    result
  }
    
  private def getTempUUID =
  {
    val tmpFile = File.createTempFile("SCORMZip_", ".tmp")
    val packageTmpUUID = tmpFile.getName
    tmpFile.delete
    
    packageTmpUUID
  }
  
  private def getFileUUID(fileInitialName:String,extension:String) =
  {
    val tmpFile = File.createTempFile(fileInitialName+"_", extension)
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
    val pack = getPackageStorage.create(new Manifest(manifest.id,
                                                     None, // version
                                                     manifest.base,
                                                     manifest.metadata,
                                                     manifest.defaultOrganizationIdentifier,
                                                     manifest.resourcesBase,
                                                     packageTitle,
                                                     Some(packageSummary)))

    //if (pack._1 != packageTmpUUID) throw new Exception("Error creating new package from manifest. ID issue")
    val packageUUID = pack.id.toInt
    val oldOutDir = new File(outputRealDir + "data/" + packageTmpUUID + "/")
    oldOutDir.renameTo(new File(outputRealDir + "data/" + packageUUID + "/"))
    
    for (organization<-manifest.organizations) {
      val createdOrganization = getOrganizationsStorage.create(packageUUID, organization._2)
      for (activity<-organization._2.activities) {
        activity match {
          case l: LeafActivity => getActivitiesStorage.create(packageUUID, createdOrganization.id.toInt, activity, None)
          case c: ContainerActivity => parseContainerActivity(createdOrganization.id.toInt, c, None)
        }
      }
    }

    for (resource<-manifest.resources)
      getResourcesStorage.create(packageUUID, resource._2)
    
    def parseContainerActivity(organizationID: Int, container: ContainerActivity, parentID: Option[Int]): Activity =
    {
      val createdContainer = getActivitiesStorage.create(packageUUID, organizationID, container, parentID)
      for (childActivity<-container.childActivities)
      {
        childActivity match {
          case l: LeafActivity => getActivitiesStorage.create(packageUUID, organizationID, childActivity, Some(createdContainer.id.toInt))
          case c: ContainerActivity => parseContainerActivity(organizationID, c, Some(createdContainer.id.toInt))
        }
      }
      createdContainer
    }
  }
}
