package com.arcusys.learn.bl.export.packages

import java.io.FileInputStream

import com.arcusys.learn.bl.export.ImportProcessor
import com.arcusys.learn.bl.services.lesson.PackageUploadManager
import com.arcusys.learn.bl.services.FileServiceContract
import com.arcusys.learn.scorm.manifest.model.{ PeriodType, BaseManifest }
import com.arcusys.learn.scorm.manifest.storage.ScormPackagesStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class PackageImportProcessor(implicit configuration: BindingModule) extends ImportProcessor[BaseManifest] with Injectable {

  override implicit def bindingModule: BindingModule = configuration

  private lazy val fileService = inject[FileServiceContract]
  private lazy val packageUploader = inject[PackageUploadManager]
  private lazy val packageRepository = inject[ScormPackagesStorage]

  override protected def importItemsImpl(JsonRaw: String, courseID: Int, exportTempDirectory: String): Unit = {
    val packages = parseJson[List[PackageExportModel]](JsonRaw).get
    packages.foreach(p => {
      // new logo name for package logo file
      val newLogo = if (p.logo.nonEmpty) p.logo.substring(Math.max(p.logo.indexOf("_"), 0)) else ""

      val (packageId, packageType, packageTmpUUID) = packageUploader.uploadPackage(p.title, p.summary.getOrElse(""), Option(courseID), -1, -1, new FileInputStream(exportTempDirectory + p.packageFile))
      packageRepository.setLimits(packageId, p.passingLimit, p.rerunInterval, PeriodType.parse(p.rerunIntervalType))
      if (p.logo.nonEmpty) {
        try {
          val contentSource = scala.io.Source.fromInputStream(new FileInputStream(exportTempDirectory + p.logo))(scala.io.Codec.ISO8859)
          val content = contentSource.map(_.toByte).toArray
          contentSource.close()
          fileService.setFileContent("package_logo_" + packageId, newLogo, content)
          packageRepository.setLogo(packageId, Option(newLogo))
        } catch {
          case _ => {
            // if logo saving failed, no logo in package
          }
        }
      }
    })
  }
}
