package com.arcusys.scorm.util

import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipFile

object FileProcessing {

  def zipContains(filename: String, zipFilename: String): Boolean = {
    try {
      val zipFile = new ZipFile(zipFilename)
      val entries = zipFile.entries

      while (entries.hasMoreElements) {
        val entry = entries.nextElement
        if (entry.getName.endsWith(filename)) {
          return true
        }
      }
      zipFile.close()
      false
    } catch {
      case e: Exception => throw new Exception(e.toString)
    }
  }

  def unzipFile(filename: String, directory: String, zipFilename: String) {
    try {
      (new File(directory)).mkdir
      val zipFile = new ZipFile(zipFilename)
      val entries = zipFile.entries

      while (entries.hasMoreElements) {
        val entry = entries.nextElement.asInstanceOf[ZipEntry]
        if (entry.getName.endsWith(filename)) {
          copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(directory + filename)))
        }
      }
      zipFile.close()
    } catch {
      case e: Exception => throw new Exception(e.toString)
    }
  }

  def unzip(directory: String, filename: String) {
    try {
      (new File(directory)).mkdir
      val zipFile = new ZipFile(filename)
      val entries = zipFile.entries

      while (entries.hasMoreElements) {
        val entry = entries.nextElement.asInstanceOf[ZipEntry]
        if (entry.isDirectory) {
          (new File(directory + entry.getName)).mkdir
        } else {
          // if zip-file doesn't contains directory structure
          val rootDirectories = extractRootDirectories(entry.getName())
          for (i <- 1 to rootDirectories.size) {
            val currentDir = new File(directory + rootDirectories.splitAt(i)._1.mkString("/"))
            if (!currentDir.exists) currentDir.mkdir
          }
          copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(directory + entry.getName)))
        }
      }
      zipFile.close()
    } catch {
      case _: Throwable => //throw new Exception("Can't unzip")
    }
  }

  def extractRootDirectories(filename: String) = filename.split("/").dropRight(1) // split path to directory list and drop filename from list

  def copyInputStream(input: InputStream, out: OutputStream) {
    try {
      val buffer = new Array[Byte](8192)
      def copy() {
        val read = input.read(buffer)
        if (read >= 0) {
          out.write(buffer, 0, read)
          copy()
        }
      }
      copy()

      input.close()
      out.close()
    } catch {
      case _: Throwable =>
    }
  }

  def getTempFileName(fileInitialName: String = "SCORMZip", extension: String = ".tmp") = {
    val tmpFile = File.createTempFile(fileInitialName + "_", extension)
    val packageTmpUUID = tmpFile.getName
    tmpFile.delete

    packageTmpUUID
  }

  def deleteFile(file: File) {
    if (file.isDirectory)
      file.listFiles.foreach {
        f => deleteFile(f)
      }
    file.delete
  }
}
