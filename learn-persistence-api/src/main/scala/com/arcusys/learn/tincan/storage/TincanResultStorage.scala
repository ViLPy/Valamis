package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.Result

trait TincanResultStorage {
  def createAndGetID(entity: Result): Int
  def getByID(id: Int): Option[Result]
  def modify(entity: Result)
  def delete(id: Int)
  def renew()
}
