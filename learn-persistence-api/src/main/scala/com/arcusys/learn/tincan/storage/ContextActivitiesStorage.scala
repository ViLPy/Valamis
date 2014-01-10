package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.ContextActivities

trait ContextActivitiesStorage {
  def createAndGetID(entity: ContextActivities): Int
  def getByID(id: Int): Option[ContextActivities]
  def delete(id: Int): Unit
  def renew()
}
