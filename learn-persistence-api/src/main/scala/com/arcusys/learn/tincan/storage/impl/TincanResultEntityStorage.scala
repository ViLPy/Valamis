package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.TincanResultStorage
import com.arcusys.learn.tincan.model.Result
import com.arcusys.learn.storage.impl.KeyedEntityStorage

trait TincanResultEntityStorage extends TincanResultStorage with KeyedEntityStorage[Result] {
  def createAndGetID(entity: Result) = {
    createAndGetID(entity, Nil: _*)
  }

  def getByID(id: Int) = {
    getByID(id, Nil: _*)
  }

  def delete(id: Int) = {
    delete("id" -> id)
  }

  def modify(entity: Result) = {
    modify(entity, Nil: _*)
  }
}
