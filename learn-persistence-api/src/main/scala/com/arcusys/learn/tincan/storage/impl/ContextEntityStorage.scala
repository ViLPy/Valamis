package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.ContextStorage
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model.Context

trait ContextEntityStorage extends ContextStorage with KeyedEntityStorage[Context] {
  def createAndGetID(entity: Context) = {
    createAndGetID(entity, Nil:_*)
  }

  def getByID(id: Int) = {
    getByID(id, Nil:_*)
  }

  def delete(id: Int) = {
    delete("id"->id)
  }
}
