package com.arcusys.valamis.util

import java.io.{File, FileInputStream, FileOutputStream, InputStream}
import java.security.SecureRandom
import javax.activation.MimetypesFileTypeMap

object FileSystemUtil {

  private val valamisTempDirectory = new File(System.getProperty("java.io.tmpdir"), "valamis")
  valamisTempDirectory.mkdirs()

  private val random = new SecureRandom

  private def getRandomName: String = {
    val n = random.nextLong
    if (n == Long.MinValue) "0"
    else Math.abs(n).toString
  }

  def getTempDirectory(prefix: String) = {
    val newDir = new File(valamisTempDirectory, prefix + getRandomName)
    newDir.mkdirs
    newDir
  }

  def getTempFile(prefix: String, extension: String = "tmp"): File = {
    File.createTempFile(prefix + "_", "." + extension, valamisTempDirectory)
  }

  def deleteFile(file: File) {
    if (file.isDirectory)
      file.listFiles.foreach {
        f => deleteFile(f)
      }
    file.delete
  }

  def streamToTempFile(inputStream: InputStream, prefix: String, extension: String): File = {
    val newFile = FileSystemUtil.getTempFile(prefix, extension)

    val outputStream = new FileOutputStream(newFile)
    try {
      StreamUtil.writeToOutputStream(inputStream, outputStream)
    } finally {
      outputStream.close()
    }
    newFile
  }

  def arrayToTempFile(array: Array[Byte], prefix: String, extension: String): File = {
    val newFile = FileSystemUtil.getTempFile(prefix, extension)

    val outputStream = new FileOutputStream(newFile)
    try {
      outputStream.write(array)
      outputStream.flush()
    } finally {
      outputStream.close()
    }
    newFile
  }

  def getTextFileContent(file: File): String = {
    val source = scala.io.Source.fromFile(file)
    try {
      source.mkString
    } finally {
      source.close()
    }
  }

  def getFileContent(file: File): Array[Byte] = {
    //    val contentSource = scala.io.Source.fromFile(file)(scala.io.Codec.ISO8859)
    //    try {
    //      contentSource.map(_.toByte).toArray
    //    } finally {
    //      contentSource.close()
    //    }
    val inputStream = new FileInputStream(file)
    try {
      StreamUtil.toByteArray(inputStream)
    } finally {
      inputStream.close()
    }
  }

  def getMimeType(fileUrl: String) = {
    val file = new File(fileUrl)
    new MimetypesFileTypeMap().getContentType(file)
  }
}