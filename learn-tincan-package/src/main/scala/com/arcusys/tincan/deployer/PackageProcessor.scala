package com.arcusys.tincan.deployer

import java.io._
import java.util.zip.{ ZipEntry, ZipFile }
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.scorm.manifest.storage.{ PackageScopeRuleStorage, ResourcesStorage }
import com.arcusys.learn.tincan.manifest.storage.{ TincanManifestActivityStorage, TincanPackageStorage }
import com.arcusys.learn.tincan.storage.TincanActivityStorage
import com.arcusys.scorm.util.{ FileProcessing, FileSystemUtil }
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import scala.xml.XML
import com.arcusys.tincan.manifest.parser.ActivitiesParser
import com.arcusys.learn.tincan.manifest.model.TincanManifest
import com.arcusys.learn.scorm.manifest.model.ScopeType

object PackageProcessor {
  def manifestFileName = "tincan.xml"

  def isValidPackage(packageTmpUUID: String) = {
    val packageZipName = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + packageTmpUUID + ".zip")
    FileProcessing.zipContains(manifestFileName, packageZipName)
  }
}

class PackageProcessor(implicit val bindingModule: BindingModule) extends Injectable {
  val tincanPackageRepository = inject[TincanPackageStorage]
  val tincanManifestActivityStorage = inject[TincanManifestActivityStorage]
  val resourceRepository = inject[ResourcesStorage]
  val fileStorage = inject[FileStorage]
  val packageScopeRuleRepository = inject[PackageScopeRuleStorage]

  def processPackageAndGetID(packageTitle: String, packageSummary: String, packageTmpUUID: String, courseID: Option[Int]) = {
    val packageZipName = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + packageTmpUUID + ".zip")
    val packageTempDirectory = FileSystemUtil.getRealPath(FileSystemUtil.getTmpDir + "/" + packageTmpUUID + "/")
    FileProcessing.unzipFile(PackageProcessor.manifestFileName, packageTempDirectory, packageZipName)

    val root = XML.loadFile(new File(packageTempDirectory + PackageProcessor.manifestFileName))
    val activities = new ActivitiesParser(root, packageTitle, packageSummary).parse

    if (activities.find(_.launch.isDefined).isEmpty) throw new RuntimeException("launch not found")

    val manifest = TincanManifest(-1, packageTitle, Some(packageSummary), courseID, None, isDefault = false)

    val packageID = tincanPackageRepository.createAndGetID(manifest, courseID)

    packageScopeRuleRepository.create(packageID, ScopeType.Instance, None, visibility = true, isDefault = false)
    packageScopeRuleRepository.create(packageID, ScopeType.Site, courseID.map(_.toString), visibility = true, isDefault = false)

    activities.map(_.copy(packageId = packageID)).foreach(tincanManifestActivityStorage.createAndGetID)

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
          //val contentSource = scala.io.Source.fromInputStream(zipFile.getInputStream(entry))(scala.io.Codec.ISO8859)
          //val content = contentSource.map(_.toByte).toArray
          // contentSource.close()
          val content = streamToByteArray(zipFile.getInputStream(entry))
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

  private def streamToByteArray(input: InputStream) = {
    val buffer = new Array[Byte](2048)
    val baos = new ByteArrayOutputStream

    def copy() {
      val read = input.read(buffer)
      if (read >= 0) {
        baos.write(buffer, 0, read)
        copy()
      }
    }
    copy()

    input.close()
    baos.toByteArray
  }
}
