package com.arcusys.valamis.lrs.service

import java.util.UUID
import javax.servlet.http.HttpServletRequest
import javax.xml.bind.DatatypeConverter

import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.valamis.lrs.api._
import com.arcusys.valamis.lrs.api.valamis._
import com.arcusys.valamis.lrs.model._
import com.arcusys.valamis.lrs.tincan.AuthorizationScope
import com.arcusys.valamis.lrsEndpoint.model._
import com.arcusys.valamis.lrsEndpoint.storage.{LrsEndpointStorage, LrsTokenStorage}
import com.arcusys.valamis.util.serialization.JsonHelper
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import org.joda.time.DateTime
import com.liferay.portal.util.PortalUtil

class LrsClientManagerImpl(implicit val bindingModule: BindingModule) extends LrsClientManager with Injectable {

  private lazy val lrsEndpointRepository = inject[LrsEndpointStorage]
  private lazy val lrsTokenStorage = inject[LrsTokenStorage]
  private lazy val lrsTokenService = inject[LrsOAuthService]

  def statementApi[T](action: (StatementApi => T), auth: String): T = {
    val api = new StatementApi()(getLrsSettingsForLrsApi(auth))
    try { action(api) }
    finally { api.close() }
  }

  def verbApi[T](action: VerbApi => T, auth: String): T = {
    val api = new VerbApi()(getLrsSettingsForLrsApi(auth))
    try { action(api) }
    finally { api.close() }
  }

  def activityProfileApi[T](action: (ActivityProfileApi => T), auth: String): T = {
    val api = new ActivityProfileApi()(getLrsSettingsForLrsApi(auth))
    try { action(api) }
    finally { api.close() }
  }

  private def getLrsSettingsForLrsApi(auth: String, version: String = ProxyLrsInfo.Version) = {
    val proxyUrl = PortalUtilHelper.getLocalHostUrl + ProxyLrsInfo.FullPrefix

    LrsSettings(proxyUrl, version, new LrsAuthDefaultSettings(auth))
  }

  def getLrsSettings = {
    val settings = lrsEndpointRepository.get.getOrElse {
      throw new NoSuchElementException("Tincan Endpoint Settings")
    }

    if (settings.endpoint == null || settings.endpoint.isEmpty)
      throw new NoSuchElementException("Tincan Endpoint URL")

    settings
  }

  def requestProxyLrsEndpointInfo(params: OAuthParams,
                                  scope: AuthorizationScope.ValueSet,
                                  hostUrl: String): EndpointInfo = {
    val settings = getLrsSettings

    val auth = settings.auth match {
      case BasicAuthorization(username, password) =>
        BasicAuthInfo(DatatypeConverter.printBase64Binary((username + ":" + password).toCharArray.map(_.toByte)))
      case OAuthAuthorization(key, secret) =>
        getOAuthInfo(settings.endpoint, key, secret, scope, params)
      case InternalAuthorization(key, secret) =>
        getOAuthInfo(hostUrl + settings.endpoint, key, secret, scope, params)
    }

    createProxyEndpointInfo(auth, hostUrl)
  }


  def getLrsEndpointInfo(scope: AuthorizationScope.ValueSet, request: Option[HttpServletRequest]): EndpointInfo = {
    val settings = getLrsSettings
    val auth = settings.auth match {
      case BasicAuthorization(username, password) =>
        BasicAuthInfo(DatatypeConverter.printBase64Binary((username + ":" + password).toCharArray.map(_.toByte)))
      case OAuthAuthorization(_, _) | InternalAuthorization(_, _) =>
        OAuthAuthInfo("", "", "")
      case _ =>
        throw new IncorrectLrsSettingsException("It needs internal LRS or Basic authorization for this operation")
    }

    val host = request match {
      case Some(r) =>  PortalUtil.getPortalURL(r)
      case _ => PortalUtilHelper.getLocalHostUrl
    }

    createProxyEndpointInfo(auth, host)
  }

  private def createProxyEndpointInfo(auth: AuthInfo, hostUrl: String): EndpointInfo = {
    val token = DatatypeConverter.printBase64Binary((":" + UUID.randomUUID.toString).toCharArray.map(_.toByte))
    val authInfo = JsonHelper.toJson(auth)
    val authType = auth match {
      case _: BasicAuthInfo => AuthConstants.Basic
      case _: OAuthAuthInfo => AuthConstants.OAuth
    }


    lrsTokenStorage.set(new LrsToken(token, authInfo, authType, DateTime.now))
    EndpointInfo(hostUrl + ProxyLrsInfo.FullPrefix, AuthConstants.Basic + " " + token)
  }

  def getToken(token: String): AuthInfo = {
    lrsTokenStorage.get(token)
      .map(info => info.authType match {
        case AuthConstants.Basic => JsonHelper.fromJson[BasicAuthInfo](info.authInfo)
        case AuthConstants.OAuth => JsonHelper.fromJson[OAuthAuthInfo](info.authInfo)
      })
      .getOrElse(throw new NoSuchElementException("Temporary token"))
  }

  def deleteToken(token: String): Unit = {
    lrsTokenStorage.delete(token)
  }

  private def getOAuthInfo(endpoint: String, consumerKey: String, consumerSecret: String, scope: AuthorizationScope.ValueSet, params: OAuthParams): OAuthAuthInfo = {
    if (params.oauthToken.isDefined) {
      lrsTokenService.getAccessToken(endpoint, consumerKey, consumerSecret, scope, params)
    }
    else {
      lrsTokenService.authorize(endpoint, consumerKey, consumerSecret, scope, params.currentUrl)
      throw new UnsupportedOperationException
    }
  }
}
