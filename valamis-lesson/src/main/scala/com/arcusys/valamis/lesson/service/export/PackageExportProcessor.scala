package com.arcusys.valamis.lesson.service.export

import java.io.File

import com.arcusys.valamis.export.ExportProcessor
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.file.storage.FileStorage
import com.arcusys.valamis.lesson.model.BaseManifest
import com.arcusys.valamis.util.{ FileSystemUtil, ZipBuilder }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class PackageExportProcessor(implicit val bindingModule: BindingModule) extends ExportProcessor[BaseManifest, PackageExportModel] with Injectable {

  protected lazy val fileService = inject[FileService]
  protected lazy val fileStorage = inject[FileStorage]

  override protected def exportItemsImpl(zip: ZipBuilder, items: Seq[BaseManifest]): Seq[PackageExportModel] = {
    items.map(p => {
      val logoName = p.logo.filter(!_.isEmpty).map(logo => {
        zip.addFile(p.id + "_" + logo, fileService.getFileContent(s"package_logo_${p.id}", logo))
        p.id + "_" + logo
      }).getOrElse("")
      val packageFile = s"package_${p.id}.zip"

      val packageZipFile = composePackage(p.id)
      zip.addFile(packageZipFile, packageFile)
      packageZipFile.delete()

      toExportModel(p, logoName, packageFile)
    })
  }

  private def composePackage(packageId: Long): File = {
    val zipFile = FileSystemUtil.getTempFile(s"package_${packageId}", "zip")
    val zip = new ZipBuilder(zipFile)
    fileStorage.getFiles(s"data/${packageId}/").foreach(f => {
      if (!f.filename.endsWith("/"))
        zip.addFile(f.filename.replace(s"data/${packageId}/", ""), f.content.getOrElse(null))
    })
    zip.close()
    zipFile
  }

  def toExportModel(manifest: BaseManifest, logo: String, packageFile: String): PackageExportModel = {
    PackageExportModel(manifest.getType.toString,
      manifest.title,
      manifest.summary,
      manifest.visibility,
      manifest.isDefault,
      manifest.passingLimit,
      manifest.rerunInterval,
      manifest.rerunIntervalType.toString,
      logo,
      packageFile,
      manifest.beginDate,
      manifest.endDate
    )
  }
}
