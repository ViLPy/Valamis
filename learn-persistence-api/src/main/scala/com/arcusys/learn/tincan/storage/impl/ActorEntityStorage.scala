package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.storage.impl.{ EntityStorage, KeyedEntityStorageExt }
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.storage.ActorStorage

trait ActorEntityStorage extends ActorStorage with EntityStorage[Actor] with KeyedEntityStorageExt[Actor] {

  def create(entity: Actor) {
    createAndGetID(entity)
  }

  def getPerson(agent: Agent): Person = {
    val person = new Person(Seq(), Seq(), Seq(), Seq(), Seq())
    val agents = getAll("agent" -> agent)
    agents.foreach((a: Actor) => if (a.isInstanceOf[Agent]) person.AddAgent(a.asInstanceOf[Agent]))
    person
  }

  override def createAndGetID(entity: Actor): Int = {
    entity match {
      case agent: Agent => {
        val a = getByIFI("Agent", agent.mbox, agent.mbox_sha1sum, agent.openid, agent.account)
        if (a.isDefined && a.get.getStoredId.isDefined)
          a.get.getStoredId.get
        else
          createAndGetID(agent, Nil: _*)
      }
      case group: Group => {
        if (!group.isAnonymous) {
          val a = getByIFI("Group", group.mbox, group.mbox_sha1sum, group.openid, group.account)
          if (a.isDefined && a.get.getStoredId.isDefined)
            a.get.getStoredId.get
          else
            createAndGetID(group, Nil: _*)
        } else
          createAndGetID(group, Nil: _*)
      }
    }
  }

  // get by Inverse Functional Identifier
  def getByIFI(objectType: String, mbox: Option[String], mbox_sha1sum: Option[String], openid: Option[String], account: Option[Account]): Option[Actor] = {
    require(objectType != null && mbox.isDefined || mbox_sha1sum.isDefined || openid.isDefined || account.isDefined)
    getOne("objectType" -> objectType,
      "mbox" -> mbox,
      "mbox_sha1sum" -> mbox_sha1sum,
      "openid" -> openid,
      "account" -> account)
  }

  //  override def getByID(actorID: Int): Option[Actor] = {
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
