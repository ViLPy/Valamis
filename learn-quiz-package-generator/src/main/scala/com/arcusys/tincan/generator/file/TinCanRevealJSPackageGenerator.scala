package com.arcusys.tincan.generator.file

import java.io.InputStream
import com.arcusys.generator.TinCanPackageGenerator
import com.arcusys.scorm.generator.file.ZipFile
import com.arcusys.scorm.util.{ FileSystemUtil, FileProcessing }

trait TinCanRevealJSPackageGenerator extends TinCanPackageGenerator {
  def composePackage(inputStreams: Seq[(String, InputStream)]) = {
    val zipName = FileProcessing.getTempFileName("Package", ".zip")
    val zip = new ZipFile(FileSystemUtil.getRealTmpDir + zipName)
    zip.addEntry("tincan.xml", generateManifest.toString())
    (commonResourceURLs ++ commonRevealResourceURLs).foreach(filename => zip.addFile(getResourceInputStream("common/" + filename), "data/" + filename))
    inputStreams.foreach { case (fileName, is) => zip.addFile(is, "data/" + fileName) }
    zip.close()
    FileSystemUtil.getRealTmpDir + zipName
  }
}