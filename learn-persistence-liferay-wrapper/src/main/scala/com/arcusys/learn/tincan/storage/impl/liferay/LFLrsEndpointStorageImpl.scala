package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint
import com.arcusys.learn.tincan.model.lrsClient.{UserBasicAuthorization, OAuthAuthorization, LrsEndpointSettings, CommonBasicAuthorization}

trait LFLrsEndpointStorageImpl extends EntityStorage[LrsEndpointSettings] {

  def renew() { LFTincanLrsEndpointLocalServiceUtil.removeAll()}

  def getOne(parameters: (String, Any)*): Option[LrsEndpointSettings] = {
    extract(LFTincanLrsEndpointLocalServiceUtil.getEndpoint)
  }

  def modify(entity: LrsEndpointSettings, parameters: (String, Any)*) = {
    entity match {
      case LrsEndpointSettings(endpoint, OAuthAuthorization(key, secret)) => LFTincanLrsEndpointLocalServiceUtil.setEndpoint(endpoint, "OAuth", key, secret)
      case LrsEndpointSettings(endpoint, UserBasicAuthorization) => LFTincanLrsEndpointLocalServiceUtil.setEndpoint(endpoint, "BasicUser", null, null)
      case LrsEndpointSettings(endpoint, CommonBasicAuthorization(key, secret)) => LFTincanLrsEndpointLocalServiceUtil.setEndpoint(endpoint, "BasicCommon", key, secret)
      case _ =>
    }
  }

  def delete(parameters: (String, Any)*) {
    LFTincanLrsEndpointLocalServiceUtil.removeAll()
  }

  private def extract(entity: LFTincanLrsEndpoint): Option[LrsEndpointSettings] = {
    if (entity == null) None
    else {
      val endpoint = if (entity.getEndpoint == null) "" else entity.getEndpoint
      entity.getAuthType match {
        case "BasicCommon" => Some(LrsEndpointSettings(endpoint, CommonBasicAuthorization(entity.getKey, entity.getSecret)))
        case "BasicUser" => Some(LrsEndpointSettings(endpoint, UserBasicAuthorization))
        case "OAuth" => Some(LrsEndpointSettings(endpoint, OAuthAuthorization(entity.getKey, entity.getSecret)))
        case _ => throw new UnsupportedOperationException("unsupported auth type : " + entity.getAuthType)
      }
    }
  }

  def getAll(parameters: (String, Any)*): Seq[LrsEndpointSettings] = throw new UnsupportedOperationException()

  def create(parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def create(entity: LrsEndpointSettings, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[LrsEndpointSettings] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[LrsEndpointSettings] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException()
}
