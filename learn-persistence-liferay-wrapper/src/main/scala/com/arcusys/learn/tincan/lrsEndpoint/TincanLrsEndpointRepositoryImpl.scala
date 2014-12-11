package com.arcusys.learn.tincan.lrsEndpoint

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil
import com.arcusys.learn.tincan.model.lrsClient.{ OAuthAuthorization, UserBasicAuthorization, CommonBasicAuthorization, LrsEndpointSettings }

/**
 * Created by mminin on 15.10.14.
 */
class TincanLrsEndpointRepositoryImpl extends TincanLrsEndpointStorage {
  override def renew(): Unit = {
    LFTincanLrsEndpointLocalServiceUtil.removeAll()
  }

  override def get: Option[LrsEndpointSettings] = {
    extract(LFTincanLrsEndpointLocalServiceUtil.getEndpoint)
  }

  override def set(lrs: Option[LrsEndpointSettings]): Unit = {
    if (!lrs.isDefined) {
      LFTincanLrsEndpointLocalServiceUtil.removeAll()
    } else {
      lrs match {
        case Some(LrsEndpointSettings(endpoint, OAuthAuthorization(key, secret))) =>
          LFTincanLrsEndpointLocalServiceUtil.setEndpoint(endpoint, "OAuth", key, secret)
        case Some(LrsEndpointSettings(endpoint, UserBasicAuthorization)) =>
          LFTincanLrsEndpointLocalServiceUtil.setEndpoint(endpoint, "BasicUser", null, null)
        case Some(LrsEndpointSettings(endpoint, CommonBasicAuthorization(key, secret))) =>
          LFTincanLrsEndpointLocalServiceUtil.setEndpoint(endpoint, "BasicCommon", key, secret)
        case _ =>
      }
    }
  }

  private def extract(entity: LFTincanLrsEndpoint): Option[LrsEndpointSettings] = {
    if (entity == null) None
    else {
      val endpoint = if (entity.getEndpoint == null) "" else entity.getEndpoint
      entity.getAuthType match {
        case "BasicCommon" => Some(LrsEndpointSettings(endpoint, CommonBasicAuthorization(entity.getKey, entity.getSecret)))
        case "BasicUser"   => Some(LrsEndpointSettings(endpoint, UserBasicAuthorization))
        case "OAuth"       => Some(LrsEndpointSettings(endpoint, OAuthAuthorization(entity.getKey, entity.getSecret)))
        case _             => throw new UnsupportedOperationException("unsupported auth type : " + entity.getAuthType)
      }
    }
  }

}
