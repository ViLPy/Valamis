package com.arcusys.learn.facades

import java.io.InputStream

import com.arcusys.learn.models.{ PPTXResponse, FileResponse }

/**
 * Created by Iliya Tryapitsin on 13.03.14.
 */
trait FileFacadeContract {
  def attachImageToPackage(packageId: Int, imageId: Int)

  def saveFile(folder: String, name: String, content: Array[Byte]): FileResponse

  def uploadRevealJS(content: Array[Byte], quizID: Int, categoryID: Option[String], title: String): FileResponse
  def uploadPDF(content: Array[Byte], quizID: Int, categoryID: Option[String], title: String): FileResponse
  def uploadPPTX(content: Array[Byte], quizID: Int, categoryID: Option[String], title: String): PPTXResponse

  def savePackage(title: String,
    summary: String,
    courseId: Option[Int],
    userId: Long,
    groupId: Long,
    stream: InputStream): FileResponse

  def savePresentation(requestFileName: String,
    requestFileContent: Array[Byte],
    packageTitle: String,
    packageDescription: String,
    courseID: Option[Int],
    userId: Long,
    groupID: Long): FileResponse
  def getFileContent(folder: String, name: String): Array[Byte]

  def remove(id: Int)

  def updatePackage(id: Int, title: Option[String], summary: Option[String])

  def copyToFolder(sourceFolder: String,
    name: String,
    destFolder: String)

  def getPackages(skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[FileResponse]

  def getScormPackages(skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[FileResponse]

  def getScormPackage(scormPackageId: Int): FileResponse

  def getTincanPackage(tincanPackageId: Int): FileResponse

  def getTincanPackages(skip: Int,
    take: Int,
    filter: String,
    sortAZ: Boolean): Seq[FileResponse]

  def packageCount(skip: Int,
    take: Int,
    filter: String): Int

  def scormPackageCount(skip: Int,
    take: Int,
    filter: String): Int

  def tincanPackageCount(skip: Int,
    take: Int,
    filter: String): Int

  def importLessons(
    courseId: Int,
    stream: InputStream): FileResponse

  def importQuestions(
    courseId: Int,
    stream: InputStream): FileResponse

  def importCertificates(
    companyId: Int,
    stream: InputStream): FileResponse

  def importPackages(
    courseId: Int,
    stream: InputStream): FileResponse
}
