package com.arcusys.scorm.deployer

import java.io._
import com.arcusys.learn.scorm.manifest.parser.ManifestParser
import com.arcusys.learn.scorm.manifest.model._
import scala.xml.XML
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.scorm.util.FileProcessing
import com.arcusys.learn.util.TreeNode
import java.util.zip.{ZipEntry, ZipFile}
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.storage.StorageFactoryContract

class PackageProcessor(implicit val bindingModule: BindingModule) extends Injectable {
  val storageFactory = inject[StorageFactoryContract]
  val packageStorage = storageFactory.packageStorage
  val resourceStorage = storageFactory.resourceStorage
  val activityStorage = storageFactory.activityStorage
  val fileStorage = storageFactory.fileStorage

  def processPackageAndGetID(packageTitle: String, packageSummary: String, packageTmpUUID: String, courseID: Option[Int]) = {
    val packageZipName = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + packageTmpUUID + ".zip")
    val packageTempDirectory = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + "/" + packageTmpUUID + "/")
    FileProcessing.unzipFile("imsmanifest.xml", packageTempDirectory, packageZipName)

    val root = XML.loadFile(new File(packageTempDirectory + "imsmanifest.xml"))
    val doc = new ManifestParser(root, packageTitle, packageSummary).parse
    val packageID = packageStorage.createAndGetID(doc.manifest, courseID)
    storageFactory.packageScopeRuleStorage.create(packageID, ScopeType.Instance, None, true);
    storageFactory.packageScopeRuleStorage.create(packageID, ScopeType.Site, courseID.map(_.toString), true);


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

    val packageDirectory = "data/" + packageID + "/"
    unzip(packageDirectory, packageZipName)
    deleteFile(new File(packageZipName))
    deleteFile(new File(packageTempDirectory))

    packageID
  }

  private def unzip(directory: String, filename: String) {
    try {
      val zipFile = new ZipFile(filename)
      val entries = zipFile.entries

      while (entries.hasMoreElements) {
        val entry = entries.nextElement.asInstanceOf[ZipEntry]
        if (entry.isDirectory) {
          fileStorage.store(directory + entry.getName)
        } else {
          val contentSource = scala.io.Source.fromInputStream(zipFile.getInputStream(entry))(scala.io.Codec.ISO8859)
          val content = contentSource.map(_.toByte).toArray
          contentSource.close()
          fileStorage.store(directory + entry.getName, content)
        }
      }
      zipFile.close()
    } catch {
      case e => throw e
    }
  }

  private def deleteFile(file: File) {
    if (file.isDirectory)
      file.listFiles.foreach {
        f => deleteFile(f)
      }
    file.delete
  }
}
