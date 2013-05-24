package com.arcusys.scorm.util

import java.io.File
import javax.activation.MimetypesFileTypeMap
import java.net.URL

object FileSystemUtil {
  // TODO: do we really need temp dir inside web-app? can't we just use ${java.io.tmp} ?
  private val sourceLocationUrl = getClass.getClassLoader.getResource(getClass.getName.replaceAll("\\.", "/") + ".class")
  private val sourceLocation: String = {
    // for example: jar:file:/opt/liferay-portal-6.1.1-ce-ga2/tomcat-7.0.27/temp/2-learn-web/WEB-INF/lib/learn-util-1.4-SNAPSHOT.jar!/com/arcusys/scorm/util/FileSystemUtil$.class
    if ("jar" == sourceLocationUrl.getProtocol) new URL(sourceLocationUrl.getFile).getFile.split("!")(0)
    else sourceLocationUrl.getFile
  }
  // extract path to SCORM packages data directory
  private lazy val outputRealDir = try {
    sourceLocation.substring(0, sourceLocation.lastIndexOf("/WEB-INF"))
  } catch {
    case _ => sourceLocation
  }

  def getTmpDir = "/SCORMData/tmp/"

  def getRealTmpDir = {
    outputRealDir + getTmpDir
  }

  def getRealPath(filename: String) = {
    outputRealDir + filename
  }

  def contextRelativeResourceURL(packageID: Int, manifestRelativeResourceUrl: String): String =
    "SCORMData/data/" + packageID.toString + "/" + manifestRelativeResourceUrl

  def getMimeType(fileUrl: String) = {
    val file = new File(fileUrl)
    new MimetypesFileTypeMap().getContentType(file)
  }
}