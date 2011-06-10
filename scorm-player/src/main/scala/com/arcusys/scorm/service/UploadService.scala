package com.arcusys.scorm.service

import com.sun.jersey.multipart._
import java.io._
import java.util.zip._
import javax.ws.rs._
import javax.ws.rs.core._
import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.model.parsers.ManifestParser
import com.arcusys.scorm.model._
import scala.xml.XML
import scala.io.Source._
import com.arcusys.scorm.service.PathBuilder._

@Path("/Upload")
class UploadService
{
  @POST
  @Path("Package")
  @Consumes(Array("multipart/form-data")) // Opera & IE
  def uploadMultipart(@QueryParam("title") title:String, 
                      @QueryParam("summary") summary:String, 
                      multiPart: MultiPart) = 
  {
    val bodyPartIndices = extractBodyPartHeaderIndices(multiPart)
    
    val packageTmpUUID = getTempUUID
   
    val newFilename = outputRealDir + "zipPackages/" + packageTmpUUID + ".zip"
    val stream = multiPart.getBodyParts.get(bodyPartIndices("qqfile")).getEntity.asInstanceOf[BodyPartEntity].getInputStream
    val outFile = new File(newFilename)
    val outStream = new FileOutputStream(outFile)
    copyInputStream(stream, outStream)
    
    processPackage(title, summary, packageTmpUUID)
    
    Response.ok("{success:true}",MediaType.TEXT_HTML).build
  }
  
  @POST
  @Path("Package")
  @Consumes(Array("application/octet-stream")) // Firefox & Chrome
  def uploadStream(@QueryParam("title") title:String, 
                   @QueryParam("summary") summary:String, 
                   bytes: Array[Byte]) =
  {
    val packageTmpUUID = getTempUUID
   
    val newFilename = outputRealDir + "zipPackages/" + packageTmpUUID + ".zip"
    val outFile = new File(newFilename)
    val outStream = new FileOutputStream(outFile)
    outStream.write(bytes)
    outStream.close
    
    processPackage(title, summary, packageTmpUUID)
    
    Response.ok("{success:true}",MediaType.TEXT_HTML).build
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
    unzip(outputRealDir + "data/" + packageTmpUUID + "/", newFileName)
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
  
  private def extractBodyPartHeaderIndices(multiPart:MultiPart) =
  {
    // extract raw "Content-Disposition" headers which contains form field names
    // get only the first element of a collection, because it would contains be only one element if POST request is valid
    val rawHeaders = multiPart.getBodyParts.toArray.map(_.asInstanceOf[BodyPart].getHeaders.get("Content-Disposition").get(0))
    // extract form field names from headers (get only the first element of a collection, see previous comment)
    val nameFields = rawHeaders.map(_.split(";").filter(_.trim.startsWith("name=")).head)
    // map field names into a Map[String,Int](field name -> number of a muiltiPart)
    // this map will be used further for getting index of a bodypart, because form contains multiple fields
    Map(
      (for (i<-0 until nameFields.size)
        yield (nameFields(i).substring(nameFields(i).indexOf("=") + 1).replaceAll("\"", "") -> i) // extract key and value from string
      ):_*)
  }
  
  private def unzip(directory: String, filename: String) =
  {
    try {
      (new File(directory)).mkdir
      val zipFile = new ZipFile(filename)
      val entries = zipFile.entries

      while(entries.hasMoreElements) {
        val entry = entries.nextElement.asInstanceOf[ZipEntry]
        if(entry.isDirectory()) {
          (new File(directory + entry.getName())).mkdir
        } else {
          // if zip-file doesn't contains directory structure
          val rootDirectories = extractRootDirectories(entry.getName())
          for (i <- 1 to rootDirectories.size ) {
            val currentDir = new File(directory + rootDirectories.splitAt(i)._1.mkString("/"))
            if (!currentDir.exists) currentDir.mkdir
          }
          copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(directory + entry.getName())))
        }
      }
      zipFile.close
    } catch {
      case _=> //throw new Exception("Can't unzip")
    }
  }

  private def extractRootDirectories(filename:String) = filename.split("/").dropRight(1) // split path to directory list and drop filename from list
  
  private def copyInputStream(in:InputStream, out: OutputStream) =
  {
    try {
      var b = in.read
      while (b >= 0) {
        out.write(b)
        b = in.read
      }
      in.close
      out.close
    } catch {
      case _ =>
    }
  }
}
