package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.SubStatementStorage
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model.SubStatement

trait SubStatementEntityStorage extends SubStatementStorage with KeyedEntityStorage[SubStatement] {
  def createAndGetID(entity: SubStatement) = {
    createAndGetID(entity, Nil:_*)
  }

  def getByID(id: Int) = {
    getByID(id, Nil:_*)
  }

  def delete(id: Int) = {
    delete("id"->id)
  }
}
