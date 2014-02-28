package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model.{StatementObjectType, StatementReference}
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef
import com.arcusys.learn.util.JsonSerializer
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalServiceUtil

trait LFTincanLrsStatementRefStorageImpl extends KeyedEntityStorage[StatementReference] {
  def mapper(entity: LFTincanLrsStatementRef): StatementReference = {
    StatementReference(
      JsonSerializer.deserializeUUID(entity.getUuid),
      StatementObjectType.StatementReference.toString,
      Option(entity.getId.toInt)
    )
  }

  def renew() = {
    LFTincanLrsStatementRefLocalServiceUtil.removeAll()
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[StatementReference] = {
    Option(LFTincanLrsStatementRefLocalServiceUtil.getLFTincanLrsStatementRef(id)).map(mapper)
  }

  def createAndGetID(entity: StatementReference, parameters: (String, Any)*): Int = {
    val lfEntity = LFTincanLrsStatementRefLocalServiceUtil.createLFTincanLrsStatementRef()
    lfEntity.setUuid(JsonSerializer.serializeUUID(entity.id))
    LFTincanLrsStatementRefLocalServiceUtil.addLFTincanLrsStatementRef(lfEntity).getId.toInt
  }

  def getOne(parameters: (String, Any)*): Option[StatementReference] = null

  def getAll(parameters: (String, Any)*): Seq[StatementReference] = null

  def create(parameters: (String, Any)*): Unit = ()

  def create(entity: StatementReference, parameters: (String, Any)*): Unit = ()

  def delete(parameters: (String, Any)*): Unit = ()

  def modify(parameters: (String, Any)*): Unit = ()

  def modify(entity: StatementReference, parameters: (String, Any)*): Unit = ()

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = ()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[StatementReference] = null

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[StatementReference] = null

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = ()

  def createAndGetID(parameters: (String, Any)*): Int = 0
}
