package com.arcusys.valamis.file.model

import java.io.File

case class FileRecord(filename: String, content: Option[Array[Byte]]) {
  def getFileName = new File(filename).getName
}