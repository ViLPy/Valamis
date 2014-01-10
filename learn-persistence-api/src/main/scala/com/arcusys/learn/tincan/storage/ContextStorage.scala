package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.Context

trait ContextStorage {
  def createAndGetID(entity: Context): Int
  def getByID(id: Int): Option[Context]
  def delete(id: Int): Unit
  def renew()
}
