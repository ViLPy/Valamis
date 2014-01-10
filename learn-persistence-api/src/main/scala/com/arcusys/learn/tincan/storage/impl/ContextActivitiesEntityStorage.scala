package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.ContextActivitiesStorage
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model.ContextActivities

trait ContextActivitiesEntityStorage extends ContextActivitiesStorage with KeyedEntityStorage[ContextActivities] {
  def createAndGetID(entity: ContextActivities) = {
    createAndGetID(entity, Nil:_*)
  }

  def getByID(id: Int) = {
    getByID(id, Nil:_*)
  }

  def delete(id: Int) = {
    delete("id"->id)
  }
}
