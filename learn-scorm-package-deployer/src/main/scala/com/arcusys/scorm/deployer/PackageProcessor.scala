package com.arcusys.scorm.deployer

import java.io._
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.scorm.manifest.parser.ManifestParser
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage._
import scala.xml.XML
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.scorm.util.FileProcessing
import com.arcusys.learn.util.TreeNode
import java.util.zip.{ ZipEntry, ZipFile }
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }

object PackageProcessor {
  def isValidPackage(packageTmpUUID: String) = {
    val packageZipName = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + packageTmpUUID + ".zip")
    FileProcessing.zipContains("imsmanifest.xml", packageZipName)
  }
}

class PackageProcessor(implicit val bindingModule: BindingModule) extends Injectable {
  val packageRepository = inject[ScormPackagesStorage]
  val resourceRepository = inject[ResourcesStorage]
  val activityRepository = inject[ActivityStorage]
  val fileStorage = inject[FileStorage]
  val packageScopeRuleRepository = inject[PackageScopeRuleStorage]

  def processPackageAndGetID(packageTitle: String,
    packageSummary: String,
    packageTmpUUID: String,
    courseID: Option[Int],
    logo: Option[String] = None) = {
    val packageZipName = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + packageTmpUUID + ".zip")
    val packageTempDirectory = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + "/" + packageTmpUUID + "/")
    FileProcessing.unzipFile("imsmanifest.xml", packageTempDirectory, packageZipName)

    val root = XML.loadFile(new File(packageTempDirectory + "imsmanifest.xml"))
    val doc = new ManifestParser(root, packageTitle, packageSummary).parse
    val packageID = packageRepository.createAndGetID(doc.manifest.copy(logo = logo), courseID)
    packageScopeRuleRepository.create(packageID, ScopeType.Instance, None, true, false)
    packageScopeRuleRepository.create(packageID, ScopeType.Site, courseID.map(_.toString), true, false)

    for (organizationNode <- doc.organizations) {
      activityRepository.create(packageID, organizationNode.item)
      createActivities(organizationNode.children)
    }

    for (resource <- doc.resources) resourceRepository.createForPackageAndGetID(packageID, resource)

    def createActivities(activities: Seq[TreeNode[Activity]]) {
      for (node <- activities) {
        activityRepository.create(packageID, node.item)
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
