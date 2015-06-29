package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.utils.SessionKey
import com.arcusys.valamis.lrs.model.{EndpointInfo, OAuthParams}
import net.oauth.OAuth
import org.scalatra.ScalatraBase

trait OAuthModel {
  implicit val scalatra: ScalatraBase

  def oauthToken = Parameter(OAuth.OAUTH_TOKEN).option
  def oauthVerifier = Parameter(OAuth.OAUTH_VERIFIER).option
  def currentUri = scalatra.requestPath(scalatra.request)

  def getOAuthParams: OAuthParams = OAuthParams(Option(currentUri), oauthToken, oauthVerifier)

  def lrsAuth = scalatra.request.getSession.getAttribute(SessionKey.LrsEndpointInfo) match {
    case e: EndpointInfo => e.auth
    case _ => ""
  }
}

object OAuthRequest {
  def apply(scalatra: ScalatraBase) = new Model(scalatra)
  class Model(val scalatra: ScalatraBase) extends OAuthModel {
  }
}
