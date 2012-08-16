package com.arcusys.scorm.deployer

import java.io._
import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import com.arcusys.learn.scorm.manifest.parser.ManifestParser
import com.arcusys.learn.scorm.manifest.model._
import scala.xml.XML
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.scorm.util.FileProcessing
import com.arcusys.learn.util.TreeNode

object PackageProcessor {
  val packageStorage = StorageFactory.packageStorage
  val resourceStorage = StorageFactory.resourceStorage
  val activityStorage = StorageFactory.activityStorage
  
  def processPackageAndGetID(packageTitle: String, packageSummary: String, packageTmpUUID: String) = {
    val packageZipName = FileSystemUtil.getRealPath("/SCORMData/zipPackages/" + packageTmpUUID + ".zip")
    val packageTempDirectory = FileSystemUtil.getRealPath("/SCORMData/data/" + packageTmpUUID + "/")
    FileProcessing.unzip(packageTempDirectory, packageZipName)
    (new File(packageZipName)).delete // delete zip-file

    val root = XML.loadFile(new File(packageTempDirectory + "imsmanifest.xml"))
    val doc = new ManifestParser(root, packageTitle, packageSummary).parse
    val packageID = packageStorage.createAndGetID(doc.manifest)
    val packageDirectory = FileSystemUtil.getRealPath("/SCORMData/data/" + packageID + "/")
    new File(packageTempDirectory).renameTo(new File(packageDirectory))

    for (organizationNode <- doc.organizations) {
      activityStorage.create(packageID, organizationNode.item)
      createActivities(organizationNode.children)
    }

    for (resource <- doc.resources) resourceStorage.createForPackageAndGetID(packageID, resource)
    
    def createActivities(activities: Seq[TreeNode[Activity]]) {
      for (node <- activities) {
        activityStorage.create(packageID, node.item)
        createActivities(node.children)
      }
    }
    
    packageID
  }
}
