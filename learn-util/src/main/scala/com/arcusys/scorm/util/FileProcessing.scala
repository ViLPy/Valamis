package com.arcusys.scorm.util

import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipFile

object FileProcessing {

  def unzipFile(filename: String, directory: String, zipFilename: String) {
    try {
      (new File(directory)).mkdir
      val zipFile = new ZipFile(zipFilename)
      val entries = zipFile.entries

      while (entries.hasMoreElements) {
        val entry = entries.nextElement.asInstanceOf[ZipEntry]
        if (entry.getName == filename) {
          copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(directory + entry.getName)))
        }
      }
      zipFile.close()
    } catch {
      case _ => //throw new Exception("Can't unzip")
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
      case _ => //throw new Exception("Can't unzip")
    }
  }

  def extractRootDirectories(filename: String) = filename.split("/").dropRight(1) // split path to directory list and drop filename from list

  def copyInputStream(in: InputStream, out: OutputStream) {
    try {
      var b = in.read
      while (b >= 0) {
        out.write(b)
        b = in.read
      }
      in.close()
      out.close()
    } catch {
      case _ =>
    }
  }

  def getTempFileName(fileInitialName: String = "SCORMZip", extension: String = ".tmp") = {
    val tmpFile = File.createTempFile(fileInitialName + "_", extension)
    val packageTmpUUID = tmpFile.getName
    tmpFile.delete

    packageTmpUUID
  }
}
