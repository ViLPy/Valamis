package com.arcusys.scorm.storage

import com.arcusys.scorm.model._

trait ActivitiesStorage
{
  def getAll: IndexedSeq[Activity]
  def getAllByParam(packageID: Int, organizationID: Int): IndexedSeq[Activity]
  def getByID(packageID: Int, organizationID: Int, activityID: Int): Option[Activity]
  def create(packageID: Int, organizationID: Int, entity: Activity, parentID: Option[Int] = None): Activity
  def delete(id: Int): Unit
  def renew: Unit
}
