package com.arcusys.valamis.export

import java.io.FileInputStream

import com.arcusys.valamis.util.JsonSupport
import com.arcusys.valamis.util.{ FileSystemUtil,ZipBuilder }

trait ExportProcessor[T, R] {
  protected def exportItemsImpl(zip: ZipBuilder, items: Seq[T]): Seq[R]

  def exportItems(items: Seq[T]): FileInputStream = {
    val zipFile = FileSystemUtil.getTempFile("Export", "zip")
    val zip = new ZipBuilder(zipFile)
    val exportResponse = exportItemsImpl(zip, items)
    zip.addEntry("export.json", JsonSupport.json(exportResponse).get)
    zip.close()

    new FileInputStream(zipFile)
  }
}
