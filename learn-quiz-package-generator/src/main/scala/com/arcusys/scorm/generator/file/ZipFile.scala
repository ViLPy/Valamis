package com.arcusys.scorm.generator.file

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import java.nio.channels.FileChannel.MapMode._

class ZipFile(filename: String) {
  private val zipFile = new ZipOutputStream(new FileOutputStream(filename))

  def addEntry(entryFilename: String, entryData: String) = {
    // Add ZIP entry to output stream.
    zipFile.putNextEntry(new ZipEntry(entryFilename))

    // Transfer bytes from the data to the ZIP file
    zipFile.write(entryData.getBytes("UTF-8"))
    // Complete the entry
    zipFile.closeEntry()
  }

  def addFile(sourceFilename: String, destinationFilename: String) = {
    zipFile.putNextEntry(new ZipEntry(destinationFilename))

    // Transfer bytes from the file to the ZIP file
    val file = new File(sourceFilename)
    if (file.exists) {
      val in = new FileInputStream(file)
      val bytes = new Array[Byte](file.length.toInt)
      in.read(bytes)
      in.close()

      zipFile.write(bytes)
    }
    // Complete the entry
    zipFile.closeEntry()
  }

  def close = {
    zipFile.close()
  }
}
