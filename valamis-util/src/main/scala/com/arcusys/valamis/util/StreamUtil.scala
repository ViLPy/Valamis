package com.arcusys.valamis.util

import java.io._

object StreamUtil {
  def toByteArray(inputStream: InputStream): Array[Byte] = {
    val outputStream = new ByteArrayOutputStream
    //  val contentSource = scala.io.Source.fromInputStream(inputStream)(scala.io.Codec.ISO8859)
    //  val content = contentSource.map(_.toByte).toArray
    //  contentSource.close()
    try {
      writeToOutputStream(inputStream, outputStream)
      outputStream.toByteArray
    } finally {
      outputStream.close()
    }
  }

  //TODO test with big file, rewrite
  def writeToOutputStream(inputStream: InputStream, outputStream: OutputStream) {
    val buffer = new Array[Byte](8192)
    def copy() {
      val read = inputStream.read(buffer)
      if (read >= 0) {
        outputStream.write(buffer, 0, read)
        copy()
      }
    }
    try {
      copy()
    }
    catch {
      case _: Throwable =>
    }
  }

  def writeToFile(inputStream: InputStream, file: File) {
    val outputStream = new FileOutputStream(file)
    //val outputStream = new BufferedOutputStream(new FileOutputStream(new File(targetDirectory, filename)))
    try {
      writeToOutputStream(inputStream, outputStream)
    } finally {
      outputStream.close()
    }
  }
}
