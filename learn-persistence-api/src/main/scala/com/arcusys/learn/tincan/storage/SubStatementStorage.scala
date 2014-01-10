package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.SubStatement

trait SubStatementStorage {
  def createAndGetID(entity: SubStatement): Int
  def getByID(id: Int): Option[SubStatement]
  def delete(id: Int): Unit
  def renew()
}
