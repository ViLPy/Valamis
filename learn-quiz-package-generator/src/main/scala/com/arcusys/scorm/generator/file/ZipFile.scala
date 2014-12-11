package com.arcusys.scorm.generator.file

import java.io.{ File, FileInputStream, FileOutputStream, InputStream }
import java.util.zip.{ ZipInputStream, ZipEntry, ZipOutputStream }

class ZipFile(filename: String) {
  private val zipFile = new ZipOutputStream(new FileOutputStream(filename))
  private var filelist = new scala.collection.mutable.HashSet[String]

  def addEntry(entryFilename: String, entryData: String) = {
    // Add ZIP entry to output stream.
    zipFile.putNextEntry(new ZipEntry(entryFilename))

    // Transfer bytes from the data to the ZIP file
    zipFile.write(entryData.getBytes("UTF-8"))

    filelist += entryFilename
    // Complete the entry
    zipFile.closeEntry()
  }

  def addFile(sourceFilename: String, destinationFilename: String) {
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

    filelist += destinationFilename
    // Complete the entry
    zipFile.closeEntry()
  }

  def addFile(sourceStream: InputStream, destinationFilename: String) {
    zipFile.putNextEntry(new ZipEntry(destinationFilename))

    // Transfer bytes from the file to the ZIP file

    try {
      var b = sourceStream.read
      while (b >= 0) {
        zipFile.write(b)
        b = sourceStream.read
      }
      sourceStream.close()
    } catch {
      case _ =>
    }

    filelist += destinationFilename
    // Complete the entry
    zipFile.closeEntry()
  }

  def addFile(destinationFilename: String, data: Array[Byte]) {
    zipFile.putNextEntry(new ZipEntry(destinationFilename))
    zipFile.write(data)

    filelist += destinationFilename
    zipFile.closeEntry()
  }

  def addFilesFromZip(stream: InputStream) {
    val input = new ZipInputStream(stream)
    var ze = input.getNextEntry
    val buff = new Array[Byte](1024)
    while (ze != null) {
      //TODO put to filename list
      // get file name
      var l = input.read(buff)
      // write buffer to file
      zipFile.putNextEntry(new ZipEntry("data/" + ze.getName))
      while (l > 0) {
        zipFile.write(buff, 0, l)
        l = input.read(buff)
      }
      zipFile.closeEntry()
      ze = input.getNextEntry
    }
    input.close()
  }

  def contains(filename: String): Boolean = {
    filelist.contains(filename)
  }

  def close() {
    zipFile.finish()
    zipFile.flush()
    zipFile.close()
  }
}
