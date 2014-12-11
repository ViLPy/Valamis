package com.arcusys.learn.bl.export

import java.io.FileInputStream

import com.arcusys.learn.util.JsonSupport
import com.arcusys.scorm.generator.file.ZipFile
import com.arcusys.scorm.util.{ FileProcessing, FileSystemUtil }

trait ExportProcessor[T] extends JsonSupport {
  protected def exportItemsImpl(zip: ZipFile, items: Seq[T]): Seq[Any] = items

  def exportItems(items: Seq[T]): FileInputStream = {
    val zipName = FileProcessing.getTempFileName("Export", ".zip")
    val zipPath = FileSystemUtil.getRealPath(s"/${zipName}")
    val zip = new ZipFile(zipPath)
    val exportResponse = exportItemsImpl(zip, items)
    zip.addEntry("export.json", json(exportResponse).get)
    zip.close()

    new FileInputStream(zipPath)
  }
}
