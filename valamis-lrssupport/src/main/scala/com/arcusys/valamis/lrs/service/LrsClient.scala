package com.arcusys.valamis.lrs.service

import com.arcusys.valamis.lrs.model.{AuthConstants, OAuthAuthInfo, OAuthParams}
import com.arcusys.valamis.lrs.tincan.AuthorizationScope
import com.arcusys.valamis.lrsEndpoint.model.LrsToken
import com.arcusys.valamis.lrsEndpoint.storage.LrsTokenStorage
import com.arcusys.valamis.utils.serialization.JsonHelper
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import net.oauth._
import net.oauth.client.OAuthClient
import net.oauth.client.httpclient4.HttpClient4
import net.oauth.http.HttpMessage
import org.apache.http.client.RedirectException
import org.joda.time.DateTime

class LrsClient(consumer: OAuthConsumer)(implicit val bindingModule: BindingModule) extends Injectable {
  private val defaultClient = new OAuthClient(new HttpClient4)
  private val accessor = new OAuthAccessor(consumer)
  private var oauthClient = defaultClient

  private lazy val lrsTokenStorage = inject[LrsTokenStorage]
  private val ScopeParameter = "scope"


  def getOAuthClient: OAuthClient = {
    oauthClient
  }

  def setOAuthClient(client: OAuthClient): Unit = {
    oauthClient = client
  }


  def authorize(redirectUrl: Option[String], scope: AuthorizationScope.ValueSet): OAuthAuthInfo = {
    try {
      val callback = redirectUrl.map(url => OAuth.newList(OAuth.OAUTH_CALLBACK, url, ScopeParameter, scope.toStringParameter)).orNull
      val response = getOAuthClient.getRequestTokenResponse(accessor, null, callback)
      var authorizationURL = OAuth.addParameters(accessor.consumer.serviceProvider.userAuthorizationURL, OAuth.OAUTH_TOKEN, accessor.requestToken)
      if (response.getParameter(OAuth.OAUTH_CALLBACK_CONFIRMED) == null) {
        authorizationURL = OAuth.addParameters(authorizationURL, callback)
      }
      val info = OAuthAuthInfo(accessor.requestToken, "", accessor.tokenSecret)
      lrsTokenStorage.set(LrsToken(info.token,
        JsonHelper.toJson(info),
        AuthConstants.OAuth,
        DateTime.now)
      )

      throw new RedirectException(authorizationURL)
    }
    catch {
      case p: OAuthProblemException =>
        handleException(p)
    }
  }

  def getAccessToken(params: OAuthParams): OAuthAuthInfo = {
    try {
      accessor.requestToken = params.oauthToken.orNull
      val lrsToken = lrsTokenStorage.get(accessor.requestToken).getOrElse(throw new NoSuchElementException("Lrs_token"))
      accessor.tokenSecret = JsonHelper.fromJson[OAuthAuthInfo](lrsToken.authInfo).tokenSecret
      lrsTokenStorage.delete(accessor.requestToken)

      val msg = oauthClient.getAccessToken(accessor, "GET", params.oauthVerifier.map(v => OAuth.newList(OAuth.OAUTH_VERIFIER, v)).orNull)
      OAuthAuthInfo(msg.getToken, params.oauthVerifier.getOrElse(""), msg.getParameter(OAuth.OAUTH_TOKEN_SECRET))
    }
    catch {
      case p: OAuthProblemException =>
        handleException(p)
    }
  }

  private def handleException(p: OAuthProblemException): Nothing = {
    val msg: StringBuilder = new StringBuilder
    val problem: String = p.getProblem
    if (problem != null) {
      msg.append(problem)
    }
    val response: AnyRef = p.getParameters.get(HttpMessage.RESPONSE)
    if (response != null) {
      val eol: String = System.getProperty("line.separator", "\n")
      msg.append(eol).append(response)
    }
    throw new OAuthException(msg.toString(), p)
  }
}
