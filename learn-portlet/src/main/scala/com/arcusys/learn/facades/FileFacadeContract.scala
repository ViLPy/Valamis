package com.arcusys.learn.facades

import java.io.InputStream
import com.arcusys.learn.models.FileResponse

/**
 * Created by Iliya Tryapitsin on 13.03.14.
 */
trait FileFacadeContract {
  def attachImageToPackage(packageId: Int, imageId: Int)

  def saveFile(folder: String, name: String, content: Array[Byte]): FileResponse

  def savePackage(title: String,
    summary: String,
    courseId: Option[Int],
    userId: Long,
    groupId: Long,
    stream: InputStream): FileResponse

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
}
