package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.model.Activity
import com.arcusys.learn.tincan.storage.TincanActivityStorage
import com.arcusys.learn.storage.impl.{KeyedEntityStorage, EntityStorageExt, EntityStorage}


trait TincanActivityEntityStorage extends TincanActivityStorage with KeyedEntityStorage[Activity] {
  def createAndGetID(entity: Activity) = {
    createAndGetID(entity, Nil:_*)
  }

  def getById(id: Int): Option[Activity] = {
    getOne("id"->id)
  }

  def getById(id: String): Option[Activity] = {
    getOne("id"->id)
  }

  def delete(id: Int): Unit = {
    delete("id" -> id)
  }
}
