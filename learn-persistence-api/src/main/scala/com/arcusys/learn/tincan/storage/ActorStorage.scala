package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.{Account, Person, Agent, Actor}

trait ActorStorage {
  def getByID(actorID: Int): Option[Actor]
  def create(entity: Actor)
  def createAndGetID(entity: Actor): Int
  def getByIFI(objectType:String, mbox: Option[String], mbox_sha1sum: Option[String], openid: Option[String], account: Option[Account]): Option[Actor]
  //def modify(entity: Actor)
  //def delete(actorID: String)
  def renew()

  def getPerson(agent: Agent): Person
}
