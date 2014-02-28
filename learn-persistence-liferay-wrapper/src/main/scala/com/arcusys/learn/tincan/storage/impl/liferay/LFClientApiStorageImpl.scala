package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.{KeyedEntityStorage}
import com.arcusys.learn.persistence.liferay.service.{LFTincanClientApiStorageLocalServiceUtil}
import com.arcusys.learn.persistence.liferay.model.{LFTincanClientApiStorage}
import com.arcusys.learn.tincan.model.LrsScopeConverters._
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException
import com.arcusys.learn.tincan.model.lrsServer.ClientApi

//
// Created by iliya.tryapitsin on 17.02.14.
//
trait LFClientApiStorageImpl extends KeyedEntityStorage[ClientApi] {
  def mapper(entity: LFTincanClientApiStorage): ClientApi = {
    val tmp =  entity.getIssuedAt()
    val issuedAt = if(tmp == null) "" else tmp.toString
    return ClientApi(
      entity.getId(),
      entity.getSecret(),
      entity.getName(),
      entity.getDescription(),
      entity.getUrl(),
      entity.getRedirectUrl(),
      entity.getIconUrl(),
      entity.getCode(),
      entity.getToken(),
      issuedAt,
      entity.getExpiredIn(),
      entity.getScope())
  }


  def getByID(id: Int, parameters: (String, Any)*): Option[ClientApi] = {
    try{
      val storage = LFTincanClientApiStorageLocalServiceUtil.getLFTincanClientApiStorage(id)
      val clientApi = mapper(storage)

      return Option(clientApi)
    } catch {
      case _  => return None
    }
  }

  override def getByID(id: Long, parameters: (String, Any)*): Option[ClientApi] = {
    try{
      val storage = LFTincanClientApiStorageLocalServiceUtil.getLFTincanClientApiStorage(id)
      val clientApi = mapper(storage)

      return Option(clientApi)
    } catch {
      case _  => return None
    }
  }

  def createAndGetID(entity: ClientApi, parameters: (String, Any)*): Int = throw new UnsupportedOperationException

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException

  def getOne(parameters: (String, Any)*): Option[ClientApi] = parameters match {
    case Seq(("token", token: String)) => {
      try {
        val storage = LFTincanClientApiStorageLocalServiceUtil.findByToken(token)
        return Option(mapper(storage))
      } catch {
        case e:NoSuchLFTincanLrsDocumentException => return None
      }
    }
    case _ => return None
  }

  def getAll(parameters: (String, Any)*): Seq[ClientApi] = {
    LFTincanClientApiStorageLocalServiceUtil
      .getLFTincanClientApiStorages(-1, -1)
      .asScala
      .map(mapper)
  }

  def create(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def create(entity: ClientApi, parameters: (String, Any)*) = {
    val storage = LFTincanClientApiStorageLocalServiceUtil.createLFTincanClientApiStorage(entity.id)
    storage.setName(entity.name)
    storage.setSecret(entity.secret)
    storage.setScope(entity.scope.toString)

    LFTincanClientApiStorageLocalServiceUtil.addLFTincanClientApiStorage(storage)
  }

  def delete(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(entity: ClientApi, parameters: (String, Any)*) = {
    val storage = LFTincanClientApiStorageLocalServiceUtil.getLFTincanClientApiStorage(entity.id)
    storage.setName(entity.name)
    storage.setDescription(entity.description)
    storage.setCode(entity.code)
    storage.setSecret(entity.secret)
    storage.setUrl(entity.url)
    storage.setRedirectUrl(entity.redirectUrl)
    storage.setScope(entity.scope.toString)
    storage.setIconUrl(entity.iconUrl)
    storage.setToken(entity.token)

    LFTincanClientApiStorageLocalServiceUtil.updateLFTincanClientApiStorage(storage)
  }

  def execute(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[ClientApi] = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[ClientApi] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException
}
