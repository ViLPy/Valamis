package com.arcusys.learn.bl.export.packages

import com.arcusys.learn.bl.export.ExportProcessor
import com.arcusys.learn.bl.services.FileServiceContract
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.filestorage.storage.impl.liferay.FileStorageImpl
import com.arcusys.learn.scorm.manifest.model.BaseManifest
import com.arcusys.learn.scorm.tracking.model.FileRecord
import com.arcusys.scorm.generator.file.ZipFile
import com.arcusys.scorm.util.{ FileProcessing, FileSystemUtil }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class PackageMobileExportProcessor(implicit configuration: BindingModule) extends ExportProcessor[BaseManifest] with Injectable {

  override implicit def bindingModule: BindingModule = configuration

  private lazy val fileService = inject[FileServiceContract]
  private lazy val fileStorage = inject[FileStorage]
  private lazy val filename = "requesthandler.js"
  //  private lazy

  override protected def exportItemsImpl(zip: ZipFile, items: Seq[BaseManifest]): Seq[Any] = {

    val requestHandler = Thread.currentThread.getContextClassLoader.getResource(filename)

    zip.addFile(requestHandler.getPath, filename)

    items.map(p => {
      var logoName = p.getLogo
      val packageId = p.getId
      if (logoName != null && !logoName.isEmpty) {
        zip.addFile(p.getId + "_" + p.getLogo, fileService.getFileContent("package_logo_" + p.getId, p.getLogo))
        logoName = p.getId + "_" + p.getLogo
      }
      val packageFile = s"package_${packageId}.zip"

      fileStorage.getFiles(s"data/${packageId}/").map(f => {
        if (!f.filename.endsWith("/")) {
          val content = if (f.filename.endsWith(".html") || f.filename.endsWith(".htm")) {
            addScriptLink(f)
          } else f.content.orNull

          zip.addFile(f.filename.replace(s"data/${packageId}/", ""), content)
        }
      })

      toExportModel(p, logoName, packageFile)
    })
  }

  def addScriptLink(file: FileRecord): Array[Byte] = {

    def getDirectory(level: Int): String = {
      if (level <= 0) ""
      else getDirectory(level - 1) + "../"
    }

    val level = file.filename.count(_ == '/') - 2

    val directory = getDirectory(level)

    val script = "<script type=\"text/javascript\" src=\"" + directory + filename + "\"></script>"
    if (file.content.isEmpty) null
    else {
      //TODO get charset from file?
      val strContetn = new String(file.content.get, "UTF-8") //content.get.mkString
      val headEnd = strContetn.lastIndexOf("<head>")
      strContetn.replace("<head>", "<head>\n" + script).getBytes
    }
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
