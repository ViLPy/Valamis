package com.arcusys.scorm.storage

import com.arcusys.scorm.model._

trait ResourcesStorage
{
  def getAll: IndexedSeq[Resource]
  def getByPackageID(packageID: Int): IndexedSeq[Resource]
  def getByID(id: Int): Option[Resource]
  def getByID(packageID: Int, resourceID: String): Option[Resource]
  def create(packageID: Int, entity: Resource): (Int,Resource)
  def delete(id: Int): Unit
  def renew: Unit
}
