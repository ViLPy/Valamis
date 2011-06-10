package com.arcusys.scorm.storage

import com.arcusys.scorm.model._

trait ActivitiesStorage
{
  def getAll: IndexedSeq[Activity]
  def getAllByParam(packageID: Int, organizationID: String): IndexedSeq[Activity]
  def getByID(packageID: Int, organizationID: String, activityID: String): Option[Activity]
  def create(packageID: Int, organizationID: String, entity: Activity, parentID: Option[Int] = None): (Int,Activity)
  def delete(id: Int): Unit
  def renew: Unit
}
