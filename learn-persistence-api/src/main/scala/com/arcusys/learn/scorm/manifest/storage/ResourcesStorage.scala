package com.arcusys.learn.scorm.manifest.storage

import com.arcusys.learn.scorm.manifest.model.Resource

trait ResourcesStorage {
  def getAll: Seq[Resource]
  def getByPackageID(packageID: Int): Seq[Resource]
  def getByID(packageID: Int, resourceID: String): Option[Resource]
  def createForPackageAndGetID(packageID: Int, entity: Resource): Int
  def delete(packageID: Int)
  def renew()
}
