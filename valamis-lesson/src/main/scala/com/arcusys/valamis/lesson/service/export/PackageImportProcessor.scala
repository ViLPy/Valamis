package com.arcusys.valamis.lesson.service.export

import java.io.File

import com.arcusys.valamis.export.ImportProcessor
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.lesson.service.{ PackageUploadManager, ValamisPackageService }
import com.arcusys.valamis.lesson.storage.LessonLimitStorage
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.util.FileSystemUtil
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class PackageImportProcessor(implicit val bindingModule: BindingModule) extends ImportProcessor[PackageExportModel] with Injectable {

  private lazy val fileService = inject[FileService]
  private lazy val packageUploader = inject[PackageUploadManager]
  private lazy val packageService = inject[ValamisPackageService]
  private lazy val lessonLimitStorage = inject[LessonLimitStorage]

  override protected def importItems(packages: List[PackageExportModel], courseId: Long, tempDirectory: File, userId: Long): Unit = {
    packages.foreach(p => {
      // new logo name for package logo file
      val newLogo = if (p.logo.nonEmpty) p.logo.substring(Math.max(p.logo.indexOf("_") + 1, 0)) else ""

      val (packageId, packageType) = packageUploader.uploadPackage(p.title, p.summary.getOrElse(""), courseId, userId, new File(tempDirectory, p.packageFile))

      lessonLimitStorage.setLimit(packageId, packageType, p.passingLimit, p.rerunInterval, PeriodTypes.parse(p.rerunIntervalType))
      if (p.logo.nonEmpty) {
        try {
          val content = FileSystemUtil.getFileContent(new File(tempDirectory, p.logo))
          fileService.setFileContent("package_logo_" + packageId, newLogo, content)
          packageService.updatePackageLogo(packageId, packageType, Option(newLogo))
        } catch {
          case _: Throwable => // if logo saving failed, no logo in package
        }
      }
    })
  }
}
