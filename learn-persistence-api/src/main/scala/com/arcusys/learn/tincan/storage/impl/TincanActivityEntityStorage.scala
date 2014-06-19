package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model.Activity
import com.arcusys.learn.tincan.storage.TincanActivityStorage

trait TincanActivityEntityStorage extends TincanActivityStorage with KeyedEntityStorage[Activity] {
  def createAndGetID(entity: Activity) = {
    val a = getById(entity.id)
    if (a.isDefined && a.get.storedId.isDefined)
      a.get.storedId.get
    else
      createAndGetID(entity, Nil: _*)
  }

  def getById(id: Int): Option[Activity] = {
    getOne("id" -> id)
  }

  def getById(id: String): Option[Activity] = {
    getOne("id" -> id)
  }

  def delete(id: Int): Unit = {
    delete("id" -> id)
  }

  def getByName(name: String): Seq[Activity] = {
    getAll("filterName" -> name)
  }
}
