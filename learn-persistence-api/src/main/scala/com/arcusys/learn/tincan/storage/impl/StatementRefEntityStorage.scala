package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.StatementRefStorage
import com.arcusys.learn.tincan.model.StatementReference
import com.arcusys.learn.storage.impl.KeyedEntityStorage

trait StatementRefEntityStorage extends StatementRefStorage with KeyedEntityStorage[StatementReference] {
  def createAndGetID(entity: StatementReference) = {
    createAndGetID(entity, Nil:_*)
  }

  def getByID(id: Int) = {
    getByID(id, Nil:_*)
  }

  def delete(id: Int) = {
    delete("id"->id)
  }
}
