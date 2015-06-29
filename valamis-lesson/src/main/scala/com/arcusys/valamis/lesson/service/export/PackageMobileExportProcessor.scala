package com.arcusys.valamis.lesson.service.export

import com.arcusys.valamis.file.model.FileRecord
import com.arcusys.valamis.lesson.model.BaseManifest
import com.arcusys.valamis.util.ZipBuilder
import com.escalatesoft.subcut.inject.BindingModule

//TODO remove it with resource from lesson module
class PackageMobileExportProcessor(implicit bindingModule: BindingModule) extends PackageExportProcessor {

  private lazy val filename = "requesthandler.js"
  //  private lazy

  override protected def exportItemsImpl(zip: ZipBuilder, items: Seq[BaseManifest]): Seq[PackageExportModel] = {

    val requestHandler = Thread.currentThread.getContextClassLoader.getResource(filename)

    zip.addFile(requestHandler.getPath, filename)

    items.map(p => {
      val packageId = p.id

      val logoName = p.logo.filter(!_.isEmpty).map(logo => {
        zip.addFile(p.id + "_" + logo, fileService.getFileContent(s"package_logo_${p.id}", logo))
        p.id + "_" + logo
      }).getOrElse("")

      val packageFile = s"package_${packageId}.zip"

      fileStorage.getFiles(s"data/${packageId}/").foreach(f => {
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
}
