package com.arcusys.scorm.util

object FileSystemUtil {
  private val sourceLocation = getClass.getProtectionDomain.getCodeSource.getLocation.getPath
  // extract path to SCORM packages data directory
  private lazy val outputRealDir = sourceLocation.substring(0, sourceLocation.lastIndexOf("/WEB-INF"))
  //lazy val outputAbstractDir = sourceLocation.substring(sourceLocation.lastIndexOf("/scorm-player"), sourceLocation.lastIndexOf("/WEB-INF")) + "/SCORMData/"
  private lazy val outputWebDir = {
    // parse context path
    val realDir = sourceLocation.substring(0, sourceLocation.lastIndexOf("/WEB-INF"))
    realDir.substring(realDir.lastIndexOf("/"))
  }
  
  def getZipPackageDir = {
    outputRealDir + "/SCORMData/" + "zipPackages/"
  }
  
  def getZipPackageWebDir = {
    outputWebDir + "/SCORMData/" + "zipPackages/"
  }
  
  def getRealPath(filename: String) = {
    outputRealDir + filename
  }
  
  def buildResourceRealPath(packageID: Int, resourceHref: String, manifestBase: String = "", resourceBase: String = ""):String =
  {
    outputRealDir + "data/" + 
    packageID.toString + "/" + 
    (if (!manifestBase.isEmpty) {manifestBase + "/"} else "") + 
    (if (!resourceBase.isEmpty) {resourceBase + "/"} else "") + 
    resourceHref
  }

  //TODO: doesn't consider external links
  def contextRelativeResourceURL(packageID: Int, manifestRelativeResourceUrl: String):String =
    "SCORMData/data/" + packageID.toString + "/" + manifestRelativeResourceUrl
}