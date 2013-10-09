package com.arcusys.tincan.deployer

import java.io._
import java.util.zip.{ZipEntry, ZipFile}
import com.arcusys.scorm.util.{FileProcessing, FileSystemUtil}
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.storage.StorageFactoryContract
import scala.xml.XML
import com.arcusys.tincan.manifest.parser.ActivitiesParser
import com.arcusys.learn.tincan.manifest.model.Manifest

object PackageProcessor {
  def manifestFileName = "tincan.xml"

  def  isValidPackage(packageTmpUUID: String) = {
    val packageZipName = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + packageTmpUUID + ".zip")
    FileProcessing.zipContains(manifestFileName, packageZipName)
  }
}

class PackageProcessor(implicit val bindingModule: BindingModule) extends Injectable {
  val storageFactory = inject[StorageFactoryContract]
  val packageStorage = storageFactory.tincanPackageStorage
  val activityStorage = storageFactory.tincanActivityStorage
  val resourceStorage = storageFactory.resourceStorage
  val fileStorage = storageFactory.fileStorage

  def processPackageAndGetID(packageTitle: String, packageSummary: String, packageTmpUUID: String, courseID: Option[Int]) = {
    val packageZipName = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + packageTmpUUID + ".zip")
    val packageTempDirectory = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + "/" + packageTmpUUID + "/")
    FileProcessing.unzipFile( PackageProcessor.manifestFileName, packageTempDirectory, packageZipName)

    val root = XML.loadFile(new File(packageTempDirectory + PackageProcessor.manifestFileName))
    val activities = new ActivitiesParser(root, packageTitle, packageSummary).parse

    if (activities.find(_.launch.isDefined).isEmpty) throw new RuntimeException("launch not found")

    val manifest = Manifest(-1, packageTitle, Some(packageSummary), courseID, None, isDefault = false )

    val packageID = packageStorage.createAndGetID(manifest, courseID)

//    storageFactory.packageScopeRuleStorage.create(tincanPackage.id, ScopeType.Instance, None, visibility = true, isDefault = false)
//    storageFactory.packageScopeRuleStorage.create(tincanPackage.id, ScopeType.Site, courseID.map(_.toString), visibility = true, isDefault = false)

    activities.map(_.copy(packageId = packageID)).foreach(activityStorage.createAndGetID)

//    for (resource <- doc.resources) resourceStorage.createForPackageAndGetID(packageID, resource)

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
        val entry = entries.nextElement
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
