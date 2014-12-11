package com.arcusys.learn.controllers.oauth

import org.apache.oltu.oauth2.rs.request._
import org.apache.oltu.oauth2.common.message.types.ParameterStyle
import javax.servlet.http.{ HttpServletResponse }
import org.apache.oltu.oauth2.common.exception.OAuthProblemException
import com.arcusys.learn.tincan.model.LrsScope
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.tincan.model.lrsServer.ClientApiModel
import org.apache.oltu.oauth2.common.message.OAuthResponse
import org.apache.oltu.oauth2.common.error.OAuthError
import org.apache.oltu.oauth2.common.OAuth
import org.apache.oltu.oauth2.common.utils.OAuthUtils
import com.arcusys.learn.controllers.api.BaseApiController

//
// Created by iliya.tryapitsin on 12.02.14.
//
class BaseLrsClientApiApiController(config: BindingModule) extends BaseApiController(config) with SignatureValidator {
  private var _app: ClientApiModel = null
  implicit val _controller = this
  val app = _app

  def isLocalClient: Boolean = {
    // TODO implement determining of local client
    // temporary solution by session user id
    getUserId != -1
  }

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
    // TODO Basic Auth?

    if (!request.getMethod.equalsIgnoreCase("options")) {
      scentry.authenticate(LIFERAY_STRATEGY_NAME)

      if (isLocalClient) { // local client gets exlusive privileges
        _app = ClientApiModel(null, null, null, null, 0, LrsScope.All)
      } else {
        // OAuth 2.0 with Bearer + token in the headers
        try {
          val oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.HEADER)
          val accessToken = oauthRequest.getAccessToken()

          if (!clientApiStoreManager.validate(accessToken))
            invalidAccessTokenHandler()

          if (!verifyRequest(new TincanOAuthRequest(request)))
            halt(HttpServletResponse.SC_BAD_REQUEST)

          _app = clientApiStoreManager.getClientByToken(accessToken)
        } catch {
          case e: OAuthProblemException => authProblemHandler(e)
        }
      }
    }
  }

  def OkJson(body: Any = Unit) = {
    response.setHeader("Content-Type", "application/json; charset=UTF-8")
    halt(HttpServletResponse.SC_OK, body, reason = "Ok")
  }

  def Ok(body: Any = Unit) = {
    halt(HttpServletResponse.SC_OK, body, reason = "Ok")
  }

  def NoContent() = {
    halt(HttpServletResponse.SC_NO_CONTENT, "", reason = "No Content")
  }

  private def authProblemHandler(e: OAuthProblemException) {
    val errorCode = e.getError()

    if (OAuthUtils.isEmpty(errorCode)) {
      val builder = new OAuthResponse.OAuthErrorResponseBuilder(HttpServletResponse.SC_UNAUTHORIZED)
      val oauthResponse: OAuthResponse = builder
        .setRealm(ServerContent.RESOURCE_SERVER_NAME)
        .buildHeaderMessage();

      val header = oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE)
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
      response.setHeader(OAuth.HeaderType.WWW_AUTHENTICATE, header)
      halt(HttpServletResponse.SC_UNAUTHORIZED, oauthResponse.getBody)
    } else {
      val builder = new OAuthResponse.OAuthErrorResponseBuilder(HttpServletResponse.SC_BAD_REQUEST)
      val oauthResponse: OAuthResponse = builder
        .setRealm(ServerContent.RESOURCE_SERVER_NAME)
        .setError(e.getError())
        .setErrorDescription(e.getDescription())
        .setErrorUri(e.getUri())
        .buildHeaderMessage()

      val header = oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE)
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
      response.setHeader(OAuth.HeaderType.WWW_AUTHENTICATE, header)
      halt(HttpServletResponse.SC_UNAUTHORIZED, oauthResponse.getBody)
    }
  }

  protected def invalidAccessTokenHandler() {
    val builder = new OAuthResponse.OAuthErrorResponseBuilder(HttpServletResponse.SC_UNAUTHORIZED)
    val oauthResponse: OAuthResponse = builder
      .setRealm(ServerContent.RESOURCE_SERVER_NAME)
      .setError(OAuthError.ResourceResponse.INVALID_TOKEN)
      .buildHeaderMessage()

    val header = oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE)
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
    response.setHeader(OAuth.HeaderType.WWW_AUTHENTICATE, header)
    halt(HttpServletResponse.SC_UNAUTHORIZED, oauthResponse.getBody)
  }
}
