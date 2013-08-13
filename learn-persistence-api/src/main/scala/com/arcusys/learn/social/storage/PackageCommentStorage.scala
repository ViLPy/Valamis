package com.arcusys.learn.social.storage

import com.arcusys.learn.social.model.PackageComment

trait PackageCommentStorage {
  def getByPackageID(packageID: Int): Seq[PackageComment]
  def createAndGetID(entity: PackageComment): Int
  def delete(id: Int)
  def renew()
}
