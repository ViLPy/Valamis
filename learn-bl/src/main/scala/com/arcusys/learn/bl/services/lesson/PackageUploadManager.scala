package com.arcusys.learn.bl.services.lesson

import java.io.{ File, FileOutputStream, InputStream }

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.bl.liferay.service.asset.AssetHelper
import com.arcusys.learn.scorm.manifest.storage.ScormPackagesStorage
import com.arcusys.scorm.util.{ FileProcessing, FileSystemUtil }
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }

class PackageUploadManager(configuration: BindingModule) extends Injectable {

  implicit val bindingModule = configuration

  private val packageRepository = inject[ScormPackagesStorage]
  def this() = this(DomainConfiguration)
  val PACKAGE_FILE_EXTENSION = "zip"

  def uploadPackage(title: String, summary: String, courseId: Option[Int], userId: Long, groupId: Long, stream: InputStream) = {

    val packageTmpUUID = FileProcessing.getTempFileName()
    val newFilename = FileSystemUtil.getRealPath("%s%s.%s".format(
      FileSystemUtil.getTmpDir,
      packageTmpUUID,
      PACKAGE_FILE_EXTENSION))

    val outFile = new File(newFilename)
    val outStream = new FileOutputStream(outFile)
    FileProcessing.copyInputStream(stream, outStream)

    val (packageId, packageType) = uploadPackageAndGetId(
      title,
      summary,
      packageTmpUUID,
      courseId,
      userId,
      groupId)

    (packageId, packageType, packageTmpUUID)
  }

  def uploadPackageAndGetId(packageTitle: String, packageSummary: String, packageTmpUUId: String, courseId: Option[Int], userId: Long, groupId: Long) = {
    if (com.arcusys.scorm.deployer.PackageProcessor.isValidPackage(packageTmpUUId)) {
      val packageId = uploadScormPackage(packageTitle, packageSummary, packageTmpUUId, courseId, userId, groupId)
      (packageId, "scorm")
    } else if (com.arcusys.tincan.deployer.PackageProcessor.isValidPackage(packageTmpUUId)) {
      val packageId = uploadTincanPackage(packageTitle, packageSummary, packageTmpUUId, courseId)
      (packageId, "tincan")
    } else {
      throw new RuntimeException("unsupport package")
    }
  }

  def uploadTincanPackage(packageTitle: String, packageSummary: String, packageTmpUUId: String, courseId: Option[Int]): Int = {
    val uploader = new com.arcusys.tincan.deployer.PackageProcessor()
    val packageId = uploader.processPackageAndGetID(packageTitle, packageSummary, packageTmpUUId, courseId)
    packageId
  }

  def uploadScormPackage(packageTitle: String, packageSummary: String, packageTmpUUId: String, courseId: Option[Int], userId: Long, groupId: Long) = {
    val uploader = new com.arcusys.scorm.deployer.PackageProcessor()
    val packageId = uploader.processPackageAndGetID(packageTitle, packageSummary, packageTmpUUId, courseId)
    if (groupId != -1)
      new AssetHelper().addPackage(userId, groupId, packageRepository.getByID(packageId)
        .getOrElse(throw new Exception("Can't find newly created package")))
    packageId
  }
}
