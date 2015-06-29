package com.arcusys.valamis.lesson.generator.tincan.file

import java.io.{ File, InputStream }
import com.arcusys.valamis.lesson.generator.tincan.TinCanPackageGenerator
import com.arcusys.valamis.util.{ FileSystemUtil, ZipBuilder }

import scala.xml.Elem

trait TinCanRevealJSPackageGeneratorContract {
  /** Returns path to zip file */
  def composePackage(filesToAdd: Seq[(String, InputStream)], manifest: Elem): File
  /** Returns path to zip file */
  def composePackage(filesToAdd: Seq[(String, InputStream)], rootActivityId: String, title: String, description: String): File
}

object TinCanRevealJSPackageGenerator extends TinCanPackageGenerator with TinCanRevealJSPackageGeneratorContract {
  override def composePackage(filesToAdd: Seq[(String, InputStream)], manifest: Elem): File = {

    val zipFile = FileSystemUtil.getTempFile("Package", "zip")

    val zip = new ZipBuilder(zipFile)
    zip.addEntry("tincan.xml", manifest.toString())
    (commonResourceURLs ++ commonRevealResourceURLs).foreach(filename => zip.addFile(getResourceInputStream("common/" + filename), "data/" + filename))
    filesToAdd.foreach { case (fileName, is) => zip.addFile(is, "data/" + fileName) }
    zip.close()
    zipFile
  }

  override def composePackage(filesToAdd: Seq[(String, InputStream)], rootActivityId: String, title: String, description: String) = {
    composePackage(filesToAdd, getDefaultManifest(rootActivityId, title, description))
  }
}