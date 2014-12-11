package com.arcusys.learn.bl.export

import java.io.File

import com.arcusys.learn.util.JsonSupport
import com.arcusys.scorm.util.FileProcessing

trait ImportProcessor[T] extends JsonSupport {
  protected def importItemsImpl(jsonRaw: String, scopeID: Int, tempDirectory: String)

  def importItems(tempFilePath: String, scopeID: Int): Unit = {
    val exportZipName = tempFilePath
    val exportTempDirectory = exportZipName.replace(".zip", "/")
    FileProcessing.unzip(exportTempDirectory, exportZipName)
    val source = scala.io.Source.fromFile(exportTempDirectory + "/export.json")
    val raw = source.mkString
    source.close()

    importItemsImpl(raw, scopeID, exportTempDirectory)

    FileProcessing.deleteFile(new File(exportZipName))
    FileProcessing.deleteFile(new File(exportTempDirectory))
  }
}

