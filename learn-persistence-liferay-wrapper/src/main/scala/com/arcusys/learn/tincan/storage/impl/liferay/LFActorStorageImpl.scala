package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.tincan.model._
import com.arcusys.learn.storage.impl.{ KeyedEntityStorage, EntityStorage }
import com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFTincanActor
import com.arcusys.util.JsonSerializer
import JsonSerializer._
import scala.collection.JavaConverters._
import com.arcusys.learn.tincan.storage.impl.liferay.mapper.ActorMapper

trait LFActorStorageImpl extends EntityStorage[Actor] with KeyedEntityStorage[Actor] {

  def renew() = {
    LFTincanActorLocalServiceUtil.removeAll()
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[Actor] =
    Option(LFTincanActorLocalServiceUtil.getLFTincanActor(id)).map(ActorMapper.map)

  def getOne(parameters: (String, Any)*): Option[Actor] = parameters match {
    case Seq(("id", actorID: Int)) => getByID(actorID)
    case Seq(("objectType", objectType: String),
      ("mbox", mbox: Option[String]),
      ("mbox_sha1sum", mbox_sha1sum: Option[String]),
      ("openid", openid: Option[String]),
      ("account", account: Option[Account])) => {
      val accountJson = if (account.isDefined) serializeAccount(account.get) else null
      LFTincanActorLocalServiceUtil.findAgent(objectType, mbox.getOrElse(null), mbox_sha1sum.getOrElse(null), openid.getOrElse(null), accountJson)
        .asScala
        .map(ActorMapper.map)
        .headOption
    }

  }

  def getAll(parameters: (String, Any)*): Seq[Actor] = parameters match {
    case Seq(("memberOf", memberOf: String)) => {
      Nil
    }
  }

  def create(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def setFields(lfEntity: LFTincanActor, entity: Actor, parameters: (String, Any)*) = {
    entity match {
      case agent: Agent => {
        lfEntity.setObjectType(agent.objectType)
        agent.name.foreach(lfEntity.setName)
        agent.mbox.foreach(lfEntity.setMbox)
        agent.mbox_sha1sum.foreach(lfEntity.setMbox_sha1sum)
        agent.openid.foreach(lfEntity.setOpenid)
        agent.account.foreach(account => lfEntity.setAccount(serializeAccount(account)))
        parameters match {
          case Seq(("parentID", parentID: String)) => {
            lfEntity.setMemberOf(parentID)
          }
          case _ => { /*do nothing*/ }
        }
      }
      case group: Group => {
        lfEntity.setObjectType(group.objectType)
        group.name.foreach(lfEntity.setName)
        group.mbox.foreach(lfEntity.setMbox)
        group.mbox_sha1sum.foreach(lfEntity.setMbox_sha1sum)
        group.openid.foreach(lfEntity.setOpenid)
        group.account.foreach(account => lfEntity.setAccount(serializeAccount(account)))
      }
      case person: Person => {
        lfEntity.setObjectType(person.objectType)
        lfEntity.setName(serializeStringSeq(person.names))
        lfEntity.setMbox(serializeStringSeq(person.mboxes))
        lfEntity.setMbox_sha1sum(serializeStringSeq(person.mbox_sha1sumes))
        lfEntity.setOpenid(serializeStringSeq(person.openids))
        lfEntity.setAccount(serializeAccounts(person.accounts))
      }
      case _ => throw new UnsupportedOperationException("Unknown type!")
    }
  }

  def createAndGetID(entity: Actor, parameters: (String, Any)*): Int = {
    val lfEntity = LFTincanActorLocalServiceUtil.createLFTincanActor()
    setFields(lfEntity, entity, parameters: _*)
    LFTincanActorLocalServiceUtil.addLFTincanActor(lfEntity).getId.toInt
  }

  def delete(parameters: (String, Any)*): Unit = parameters match {
    case Seq(("id", id: Int)) => {
      Option(LFTincanActorLocalServiceUtil.getLFTincanActor(id)).foreach(LFTincanActorLocalServiceUtil.deleteLFTincanActor)
    }
  }

  def modify(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(entity: Actor, parameters: (String, Any)*): Unit = { throw new UnsupportedOperationException() }

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[Actor] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Actor] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException()

  def create(entity: Actor, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()
}
