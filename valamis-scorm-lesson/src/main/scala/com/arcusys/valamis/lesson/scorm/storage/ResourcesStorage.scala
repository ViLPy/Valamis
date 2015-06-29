package com.arcusys.valamis.lesson.scorm.storage

import com.arcusys.valamis.lesson.scorm.model.manifest.Resource

trait ResourcesStorage {
  def getAll: Seq[Resource]
  def getByPackageID(packageId: Long): Seq[Resource]
  def getByID(packageId: Long, resourceID: String): Option[Resource]
  def createForPackageAndGetID(packageId: Long, entity: Resource): Int
  def delete(packageId: Long)
  def renew()
}
