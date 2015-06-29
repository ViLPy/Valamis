package com.arcusys.learn.tincan.lrsEndpoint

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil
import com.arcusys.valamis.lrsEndpoint.model.{BasicAuthorization, InternalAuthorization, LrsEndpointSettings, OAuthAuthorization}
import com.arcusys.valamis.lrsEndpoint.storage.LrsEndpointStorage

import scala.collection.JavaConverters._

/**
 * Created by mminin on 15.10.14.
 */
class LrsEndpointRepositoryImpl extends LrsEndpointStorage {

  object AuthType {
    val INTERNAL = "Internal"
    val BASIC = "Basic"
    val BASIC_USER = "BasicUser"
    val BASIC_COMMON = "BasicCommon"
    val OAUTH = "OAuth"
  }

  override def renew(): Unit = {
    LFTincanLrsEndpointLocalServiceUtil.removeAll()
  }

  override def get: Option[LrsEndpointSettings] = {
    val list = LFTincanLrsEndpointLocalServiceUtil.getLFTincanLrsEndpoints(-1, -1).asScala
    def customSettings = list.filterNot(_.getAuthType == AuthType.INTERNAL).headOption
    def defaultSettings = list.find(_.getAuthType == AuthType.INTERNAL)

    extract(customSettings.getOrElse(defaultSettings.orNull))
  }

  override def getDefault: Option[LrsEndpointSettings] = {
    val list = LFTincanLrsEndpointLocalServiceUtil.getLFTincanLrsEndpoints(-1, -1).asScala
    def defaultSettings = list.find(_.getAuthType == AuthType.INTERNAL)

    extract(defaultSettings.orNull)
  }

  override def set(lrs: Option[LrsEndpointSettings]): Unit = {
    if (!lrs.isDefined || !lrs.get.auth.isInstanceOf[InternalAuthorization])
      LFTincanLrsEndpointLocalServiceUtil.getLFTincanLrsEndpoints(-1, -1).asScala
        .filterNot(_.getAuthType == AuthType.INTERNAL)
        .foreach(s => LFTincanLrsEndpointLocalServiceUtil.deleteLFTincanLrsEndpoint(s.getId))
    if (lrs.isDefined) lrs match {
      case Some(LrsEndpointSettings(endpoint, OAuthAuthorization(key, secret))) =>
        LFTincanLrsEndpointLocalServiceUtil.setEndpoint(endpoint, AuthType.OAUTH, key, secret)
      case Some(LrsEndpointSettings(endpoint, BasicAuthorization(key, secret))) =>
        LFTincanLrsEndpointLocalServiceUtil.setEndpoint(endpoint, AuthType.BASIC, key, secret)
      case Some(LrsEndpointSettings(endpoint, InternalAuthorization(key, secret))) =>
        LFTincanLrsEndpointLocalServiceUtil.getLFTincanLrsEndpoints(-1, -1).asScala
          .filter(_.getAuthType == AuthType.INTERNAL)
          .foreach({ s => LFTincanLrsEndpointLocalServiceUtil.deleteLFTincanLrsEndpoint(s.getId) })
        LFTincanLrsEndpointLocalServiceUtil.setEndpoint(endpoint, AuthType.INTERNAL, key, secret)
      case _ =>
    }

  }

  private def extract(entity: LFTincanLrsEndpoint): Option[LrsEndpointSettings] = {
    if (entity == null) None
    else {
      val endpoint = if (entity.getEndpoint == null) "" else entity.getEndpoint
      entity.getAuthType match {
        case AuthType.INTERNAL => Some(LrsEndpointSettings(endpoint, InternalAuthorization(entity.getKey, entity.getSecret)))
        case AuthType.BASIC_COMMON
             | AuthType.BASIC_USER
             | AuthType.BASIC => Some(LrsEndpointSettings(endpoint, BasicAuthorization(entity.getKey, entity.getSecret)))
        case AuthType.OAUTH => Some(LrsEndpointSettings(endpoint, OAuthAuthorization(entity.getKey, entity.getSecret)))
        case _ => throw new UnsupportedOperationException("unsupported auth type : " + entity.getAuthType)
      }
    }
  }

}
