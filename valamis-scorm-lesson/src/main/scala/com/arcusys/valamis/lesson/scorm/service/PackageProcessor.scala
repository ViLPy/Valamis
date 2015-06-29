package com.arcusys.valamis.lesson.scorm.service

import java.io._
import java.util.zip.ZipFile

import com.arcusys.valamis.file.storage.FileStorage
import com.arcusys.valamis.lesson.scorm.model.manifest.Activity
import com.arcusys.valamis.lesson.scorm.service.parser.ManifestParser
import com.arcusys.valamis.lesson.scorm.storage.{ ActivityStorage, ResourcesStorage, ScormPackagesStorage }
import com.arcusys.valamis.lesson.storage.PackageScopeRuleStorage
import com.arcusys.valamis.model.ScopeType
import com.arcusys.valamis.util.{ FileSystemUtil, StreamUtil, TreeNode, ZipUtil }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

import scala.xml.XML

object PackageProcessor {
  def isValidPackage(packageFile: File) = {
    ZipUtil.zipContains("imsmanifest.xml", packageFile)
  }
}

class PackageProcessor(implicit val bindingModule: BindingModule) extends Injectable {
  val scormRepository = inject[ScormPackagesStorage]
  val resourceRepository = inject[ResourcesStorage]
  val activityRepository = inject[ActivityStorage]
  val fileStorage = inject[FileStorage]
  val packageScopeRuleRepository = inject[PackageScopeRuleStorage]

  def processPackageAndGetId(packageTitle: String, packageSummary: String, packageFile: File, courseId: Option[Int], logo: Option[String] = None): Long = {

    val tempDirectory = FileSystemUtil.getTempDirectory("scormupload")
    ZipUtil.unzipFile("imsmanifest.xml", tempDirectory, packageFile)

    val root = XML.loadFile(new File(tempDirectory, "imsmanifest.xml"))
    val doc = new ManifestParser(root, packageTitle, packageSummary).parse
    val packageId = scormRepository.createAndGetID(doc.manifest.copy(logo = logo), courseId)
    packageScopeRuleRepository.create(packageId, ScopeType.Instance, None, true, false)
    packageScopeRuleRepository.create(packageId, ScopeType.Site, courseId.map(_.toString), true, false)

    for (organizationNode <- doc.organizations) {
      activityRepository.create(packageId, organizationNode.item)
      createActivities(organizationNode.children)
    }

    for (resource <- doc.resources) resourceRepository.createForPackageAndGetID(packageId, resource)

    def createActivities(activities: Seq[TreeNode[Activity]]) {
      for (node <- activities) {
        activityRepository.create(packageId, node.item)
        createActivities(node.children)
      }
    }

    val fileStorageDirectory = "data/" + packageId + "/"
    unzipToFileStorage(fileStorageDirectory, packageFile)
    FileSystemUtil.deleteFile(packageFile)
    FileSystemUtil.deleteFile(tempDirectory)

    packageId
  }

  private def unzipToFileStorage(directory: String, zipFile: File) {
    val zip = new ZipFile(zipFile)
    val entries = zip.entries

    while (entries.hasMoreElements) {
      val entry = entries.nextElement
      if (entry.isDirectory) {
        fileStorage.store(directory + entry.getName)
      } else {
        val stream = zip.getInputStream(entry)
        val content = StreamUtil.toByteArray(stream)
        stream.close()
        fileStorage.store(directory + entry.getName, content)
      }
    }
    zip.close()
  }
}
