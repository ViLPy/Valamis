package com.arcusys.valamis.lesson.tincan.service

import java.io._
import java.util.zip.ZipFile

import com.arcusys.valamis.file.storage.FileStorage
import com.arcusys.valamis.lesson.storage.PackageScopeRuleStorage
import com.arcusys.valamis.lesson.tincan.service.parser.ActivitiesParser
import com.arcusys.valamis.lesson.tincan.storage.{ TincanManifestActivityStorage, TincanPackageStorage }
import com.arcusys.valamis.model.ScopeType
import com.arcusys.valamis.util.{ FileSystemUtil, StreamUtil, ZipUtil }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

import scala.xml.XML

object PackageProcessor {
  def manifestFileName = "tincan.xml"

  def isValidPackage(packageFile: File) = {
    ZipUtil.zipContains(manifestFileName, packageFile)
  }
}

class PackageProcessor(implicit val bindingModule: BindingModule) extends Injectable {
  val tincanPackageRepository = inject[TincanPackageStorage]
  val tincanManifestActivityStorage = inject[TincanManifestActivityStorage]
  val fileStorage = inject[FileStorage]
  val packageScopeRuleRepository = inject[PackageScopeRuleStorage]

  def processPackageAndGetId(packageTitle: String, packageSummary: String, packageFile: File, courseId: Option[Int]): Long = {

    val tempDirectory = FileSystemUtil.getTempDirectory("tincanupload")
    ZipUtil.unzipFile(PackageProcessor.manifestFileName, tempDirectory, packageFile)

    val root = XML.loadFile(new File(tempDirectory, PackageProcessor.manifestFileName))
    val activities = new ActivitiesParser(root, packageTitle, packageSummary).parse

    if (activities.find(_.launch.isDefined).isEmpty) throw new RuntimeException("launch not found")

    val packageId = tincanPackageRepository.createAndGetID(packageTitle, packageSummary, courseId)

    packageScopeRuleRepository.create(packageId, ScopeType.Instance, None, visibility = true, isDefault = false)
    packageScopeRuleRepository.create(packageId, ScopeType.Site, courseId.map(_.toString), visibility = true, isDefault = false)

    activities.map(_.copy(packageId = packageId)).foreach(tincanManifestActivityStorage.createAndGetId)

    //    for (resource <- doc.resources) resourceStorage.createForPackageAndGetID(packageID, resource)

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
