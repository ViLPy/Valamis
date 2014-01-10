package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.ActorStorage
import com.arcusys.learn.tincan.model.Actor
import com.arcusys.learn.storage.impl.{KeyedEntityStorageExt, EntityStorage}

trait ActorEntityStorage extends ActorStorage with EntityStorage[Actor] with KeyedEntityStorageExt[Actor] {

  def create(entity: Actor) {
    createAndGetID(entity)
  }

//  def get(actorID: Int): Option[Actor] = {
//    getOne("id"->actorID)
//  }
//
//  def modify(entity: Actor) = {
//    modify(entity, Nil:_*)
//  }
//
//  def delete(actorID: String) = {
//    delete("id" -> actorID)
//  }
}
