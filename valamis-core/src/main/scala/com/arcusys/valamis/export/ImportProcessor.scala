package com.arcusys.valamis.export

import java.io.File

import com.arcusys.valamis.util.JsonSupport
import com.arcusys.valamis.util.{ FileSystemUtil, ZipUtil }

trait ImportProcessor[T] {
  protected def importItems(items: List[T], courseId: Long, tempDirectory: File, userId: Long)

  def importItems(file: File, scopeId: Int, userId: Long = -1)(implicit ev: Manifest[List[T]]): Unit = {
    val tempDirectory = FileSystemUtil.getTempDirectory("Import")
    ZipUtil.unzip(tempDirectory, file)

    val exportJson = FileSystemUtil.getTextFileContent(new File(tempDirectory.getPath, "export.json"))
    val items = JsonSupport.parseJson[List[T]](exportJson).get

    importItems(items, scopeId, tempDirectory, userId)

    FileSystemUtil.deleteFile(file)
    FileSystemUtil.deleteFile(tempDirectory)
  }
}

