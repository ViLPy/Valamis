package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.Actor

trait ActorStorage {
  //def get(actorID: Int): Option[Actor]
  def create(entity: Actor)
  //def createAndGetID(entity: Actor): Int
  //def modify(entity: Actor)
  //def delete(actorID: String)
  def renew()
}
