package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.Activity


trait TincanActivityStorage {
  def createAndGetID(activity: Activity): Int
  def getById(id: Int): Option[Activity]
  def getById(id: String): Option[Activity]
  def delete(id: Int): Unit
  def renew()
}
