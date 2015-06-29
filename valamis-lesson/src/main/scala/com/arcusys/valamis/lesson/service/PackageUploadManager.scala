package com.arcusys.valamis.lesson.service

import java.io.File

import com.arcusys.learn.liferay.services.{SocialActivityLocalServiceHelper, GroupLocalServiceHelper}
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.lesson.model.{LessonType, PackageActivityType}
import com.arcusys.valamis.lesson.scorm.model.ScormPackage
import com.arcusys.valamis.lesson.{scorm, tincan}
import com.arcusys.valamis.lesson.tincan.model.TincanPackage
import com.arcusys.valamis.lesson.tincan.service
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}

class PackageUploadManager(implicit val bindingModule: BindingModule) extends Injectable {
  private val packageService = inject[ValamisPackageService]
  private lazy val fileService = inject[FileService]

  def uploadPackage(title: String, summary: String, courseId: Long, userId: Long, packageFile: File): (Long, LessonType.LessonType) = {

    if (scorm.service.PackageProcessor.isValidPackage(packageFile)) {
      val packageId = uploadScormPackage(title, summary, packageFile, courseId, userId)

      (packageId, LessonType.Scorm)
    } else if (service.PackageProcessor.isValidPackage(packageFile)) {
      val packageId = uploadTincanPackage(title, summary, packageFile, courseId, userId)

      (packageId, LessonType.Tincan)
    } else {
      throw new RuntimeException("unsupport package")
    }
  }

  def uploadPackage(title: String,
                    summary: String,
                    logoOpt: Option[(String, String)],
                    courseId: Long,
                    userId: Long,
                    packageFile: File): (Long, LessonType.LessonType) = {
    val (packageId, packageType) = uploadPackage(title, summary, courseId, userId, packageFile)

    for ((sourceDirectory, fileName) <- logoOpt) {
      fileService.copyFile(sourceDirectory, fileName, s"package_logo_$packageId", fileName, deleteFolder = false)
      packageService.updatePackageLogo(packageId, packageType, Some(fileName))
    }

    (packageId, packageType)
  }

  def uploadTincanPackage(title: String, summary: String, packageFile: File, courseId: Long, userId: Long): Long = {
    val uploader = new tincan.service.PackageProcessor()
    val packageId = uploader.processPackageAndGetId(title, summary, packageFile, Some(courseId.toInt))

    new AssetHelper().addTincanPackageAssetEntry(userId, courseId, packageId, title, Option(summary))
    SocialActivityLocalServiceHelper.addWithSet(
      GroupLocalServiceHelper.getGroup(courseId).getCompanyId,
      userId,
      classOf[TincanPackage].getName,
      courseId = Some(courseId),
      `type` = Some(PackageActivityType.Published.id),
      classPK = Some(packageId))

    packageId
  }

  def uploadScormPackage(title: String, summary: String, packageFile: File, courseId: Long, userId: Long): Long = {
    val uploader = new scorm.service.PackageProcessor()
    val packageId = uploader.processPackageAndGetId(title, summary, packageFile, Some(courseId.toInt))

    new AssetHelper().addScormPackageAssetEntry(userId, courseId, packageId, title, Option(summary))
    SocialActivityLocalServiceHelper.addWithSet(
      GroupLocalServiceHelper.getGroup(courseId).getCompanyId,
      userId,
      classOf[ScormPackage].getName,
      courseId = Some(courseId),
      `type` = Some(PackageActivityType.Published.id),
      classPK = Some(packageId))

    packageId
  }
}
