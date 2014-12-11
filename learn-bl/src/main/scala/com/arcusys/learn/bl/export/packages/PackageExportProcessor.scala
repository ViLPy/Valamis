package com.arcusys.learn.bl.export.packages

import com.arcusys.learn.bl.export.ExportProcessor
import com.arcusys.learn.bl.services.FileServiceContract
import com.arcusys.learn.filestorage.storage.impl.FileRecordEntityStorage
import com.arcusys.learn.filestorage.storage.impl.liferay.{ FileStorageImpl, LFFileRecordStorageImpl }
import com.arcusys.learn.scorm.manifest.model.BaseManifest
import com.arcusys.scorm.generator.file.ZipFile
import com.arcusys.scorm.util.{ FileProcessing, FileSystemUtil }
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }

class PackageExportProcessor(implicit configuration: BindingModule) extends ExportProcessor[BaseManifest] with Injectable {

  override implicit def bindingModule: BindingModule = configuration

  private lazy val fileService = inject[FileServiceContract]
  private lazy val fileStorage = new FileStorageImpl //inject[FileStorage]

  override protected def exportItemsImpl(zip: ZipFile, items: Seq[BaseManifest]): Seq[Any] = {
    items.map(p => {
      var logoName = p.getLogo
      if (logoName != null && !logoName.isEmpty) {
        zip.addFile(p.getId + "_" + p.getLogo, fileService.getFileContent("package_logo_" + p.getId, p.getLogo))
        logoName = p.getId + "_" + p.getLogo
      }
      val packageFile = s"package_${p.getId}.zip"
      zip.addFile(composePackage(p.getId), packageFile)
      toExportModel(p, logoName, packageFile)
    })
  }

  def composePackage(packageId: Int) = {
    val zipName = FileProcessing.getTempFileName(s"package_${packageId}", ".zip")
    val zipPath = FileSystemUtil.getRealPath(s"/${zipName}")
    val zip = new ZipFile(zipPath)
    fileStorage.getFiles(s"data/${packageId}/").map(f => {
      if (!f.filename.endsWith("/"))
        zip.addFile(f.filename.replace(s"data/${packageId}/", ""), f.content.getOrElse(null))
    })
    zip.close()
    zipPath
  }

  def toExportModel(manifest: BaseManifest, logo: String, packageFile: String): PackageExportModel = {
    PackageExportModel(manifest.getType.toString,
      manifest.getTitle,
      manifest.getSummary,
      manifest.getVisibility,
      manifest.getDefault,
      manifest.getPassingLimit,
      manifest.getRerunInterval,
      manifest.getRerunIntervalType.toString,
      logo,
      packageFile)
  }
}
