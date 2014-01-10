package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement
import com.arcusys.learn.tincan.storage.{StatementRefStorage, TincanActivityStorage, ActorStorage}
import com.arcusys.learn.util.JsonSerializer
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalServiceUtil

trait LFTincanLrsSubStatementStorageImpl extends KeyedEntityStorage[SubStatement] {
  def actorStorage: LFActorStorageImpl
  def tincanActivityStorage: TincanActivityStorage
  def tincanStatementRefStorage: StatementRefStorage

  private def createStatementObjectAndGetID(obj: StatementObject): Int = {
    obj match {
      case act:Activity => tincanActivityStorage.createAndGetID(act)
      case agent:Agent => actorStorage.createAndGetID(agent)
      case group:Group => actorStorage.createAndGetID(group)
      case subs:SubStatement => createAndGetID(subs)
      case ref:StatementReference => tincanStatementRefStorage.createAndGetID(ref)
      case _ => throw new IllegalArgumentException("Unknown type of object " + obj + " with type " + obj.objectType)
    }
  }

  def mapper(entity: LFTincanLrsSubStatement): SubStatement = {
    val statementObj: Option[StatementObject] = StatementObjectType.withName(entity.getObjType) match {
      case StatementObjectType.Activity => tincanActivityStorage.getById(entity.getObjID)
      case StatementObjectType.Agent => actorStorage.getByID(entity.getObjID).map(_.asInstanceOf[Agent])
      case StatementObjectType.Group => actorStorage.getByID(entity.getObjID).map(_.asInstanceOf[Group])
      case StatementObjectType.SubStatement => getOne("id" -> entity.getObjID)
      case StatementObjectType.StatementReference => tincanStatementRefStorage.getByID(entity.getObjID)
      case _ => None
    }

    SubStatement(
      actorStorage.getByID(entity.getActorID).getOrElse(throw new IllegalArgumentException()),
      Verb(entity.getVerbID, JsonSerializer.deserializeLanguageMap(entity.getVerbDisplay)),
      statementObj.getOrElse(throw new IllegalArgumentException()),
      entity.getObjType,
      Option(entity.getId.toInt)
    )
  }

  def renew() = {
    LFTincanLrsSubStatementLocalServiceUtil.removeAll()
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[SubStatement] = {
    Option(LFTincanLrsSubStatementLocalServiceUtil.getLFTincanLrsSubStatement(id)).map(mapper)
  }

  def createAndGetID(entity: SubStatement, parameters: (String, Any)*): Int = {
    val lfEntity = LFTincanLrsSubStatementLocalServiceUtil.createLFTincanLrsSubStatement()

    lfEntity.setActorID(actorStorage.createAndGetID(entity.actor))
    lfEntity.setVerbID(entity.verb.id)
    lfEntity.setVerbDisplay(JsonSerializer.serializeLanguageMap(entity.verb.display))
    lfEntity.setObjType(entity.obj.objectType)

    lfEntity.setObjID(createStatementObjectAndGetID(entity.obj))

    LFTincanLrsSubStatementLocalServiceUtil.addLFTincanLrsSubStatement(lfEntity).getId.toInt
  }

  def getOne(parameters: (String, Any)*): Option[SubStatement] = null

  def getAll(parameters: (String, Any)*): Seq[SubStatement] = null

  def create(parameters: (String, Any)*): Unit = ()

  def create(entity: SubStatement, parameters: (String, Any)*): Unit = ()

  def delete(parameters: (String, Any)*): Unit = ()

  def modify(parameters: (String, Any)*): Unit = ()

  def modify(entity: SubStatement, parameters: (String, Any)*): Unit = ()

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = ()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[SubStatement] = null

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[SubStatement] = null

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = ()

  def createAndGetID(parameters: (String, Any)*): Int = 0
}
