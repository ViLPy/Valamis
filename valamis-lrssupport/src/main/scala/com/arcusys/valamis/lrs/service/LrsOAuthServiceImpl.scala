package com.arcusys.valamis.lrs.service

import java.net.ConnectException

import com.arcusys.valamis.lrs.model.{OAuthAuthInfo, OAuthParams}
import com.arcusys.valamis.lrs.tincan.AuthorizationScope
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import com.liferay.portal.kernel.log.LogFactoryUtil
import net.oauth.{OAuthConsumer, OAuthServiceProvider}


class LrsOAuthServiceImpl(implicit val bindingModule: BindingModule) extends LrsOAuthService with Injectable {
  val logger = LogFactoryUtil.getLog(getClass)

  override def authorize(endpoint: String,
                         clientId: String,
                         clientSecret: String,
                         scope: AuthorizationScope.ValueSet,
                         redirectUrl: Option[String]): OAuthAuthInfo = {
    val provider = getServiceProvider(endpoint)
    val consumer = new OAuthConsumer(null, clientId, clientSecret, provider)
    val client = new LrsClient(consumer)

    try {
      client.authorize(redirectUrl, scope)
    }
    catch {
      case e: ConnectException =>
        logger.error(s"${e.getMessage} endpoint: $endpoint")
        throw new Exception(s"${e.getMessage} endpoint: $endpoint", e)
    }
  }

  override def getAccessToken(endpoint: String,
                              clientId: String,
                              clientSecret: String,
                              scope: AuthorizationScope.ValueSet,
                              params: OAuthParams): OAuthAuthInfo = {
    val provider = getServiceProvider(endpoint)
    val consumer = new OAuthConsumer(null, clientId, clientSecret, provider)
    val client = new LrsClient(consumer)
    client.getAccessToken(params)
  }

  private def getServiceProvider(endpoint: String) = {
    val url = endpoint.stripSuffix("/")
    new OAuthServiceProvider(s"$url/OAuth/initiate", s"$url/OAuth/authorize", s"$url/OAuth/token")
  }

}
