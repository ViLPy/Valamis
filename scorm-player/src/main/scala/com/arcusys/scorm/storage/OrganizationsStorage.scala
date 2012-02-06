package com.arcusys.scorm.storage

import com.arcusys.scorm.model._

trait OrganizationsStorage
{
  def getAll: IndexedSeq[Organization]
  def getByPackageID(packageID: Int): IndexedSeq[Organization]
  def getByID(id: Int): Option[Organization]
  def create(packageID: Int, entity: Organization): Organization
  def delete(id: Int): Unit
  def renew: Unit
}
