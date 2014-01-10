package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.StatementReference

trait StatementRefStorage {
  def createAndGetID(entity: StatementReference): Int
  def getByID(id: Int): Option[StatementReference]
  def delete(id: Int): Unit
  def renew()
}
