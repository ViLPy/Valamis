package com.arcusys.scorm.util

import java.io.File
import javax.activation.MimetypesFileTypeMap

object FileSystemUtil {
  private val sourceLocation = getClass.getProtectionDomain.getCodeSource.getLocation.getPath
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