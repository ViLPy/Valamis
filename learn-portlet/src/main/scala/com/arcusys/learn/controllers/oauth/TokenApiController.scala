package com.arcusys.learn.controllers.oauth

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import org.apache.oltu.oauth2.as.request.OAuthUnauthenticatedTokenRequest
import org.apache.oltu.oauth2.as.issuer.{ MD5Generator, OAuthIssuerImpl }
import org.apache.oltu.oauth2.common.message.OAuthResponse
import javax.servlet.http.HttpServletResponse
import org.apache.oltu.oauth2.common.error.OAuthError
import org.apache.oltu.oauth2.as.response.OAuthASResponse
import org.apache.oltu.oauth2.common.exception.OAuthProblemException
import com.arcusys.learn.controllers.api.BaseApiController

//
// Created by iliya.tryapitsin on 14.02.14.
//
class TokenApiController(configuration: BindingModule) extends BaseApiController(configuration) with SignatureValidator {
  def this() = this(Configuration)

  before() {
    val oauthRequest = new OAuthUnauthenticatedTokenRequest(request)
    if (!verifyRequest(oauthRequest))
      halt(HttpServletResponse.SC_BAD_REQUEST)
  }

  post("/") {
    try {
      val oauthRequest = new OAuthUnauthenticatedTokenRequest(request)
      val oauthIssuerImpl: OAuthIssuerImpl = new OAuthIssuerImpl(new MD5Generator())
      val clientId = oauthRequest.getClientId().toLong
      val fetchToken = oauthRequest.getCode()

      if (!clientApiStoreManager.checkClientFetchCode(clientId, fetchToken)) {
        val res = OAuthResponse
          .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
          .setError(OAuthError.ResourceResponse.INVALID_TOKEN)
          .buildJSONMessage()

        response.setStatus(res.getResponseStatus())
        res.getBody()

      } else {
        val accessToken = oauthIssuerImpl.accessToken()
        val refreshToken = oauthIssuerImpl.refreshToken()
        val resp = OAuthASResponse
          .tokenResponse(HttpServletResponse.SC_FOUND)
          .setAccessToken(accessToken)
          .setExpiresIn(ServerContent.EXPIRES_IN)
          .setRefreshToken(refreshToken)
          .buildJSONMessage()

        clientApiStoreManager.setAccessToken(clientId, accessToken, refreshToken)

        response.setStatus(resp.getResponseStatus())
        resp.getBody()
      }

    } catch {
      case e: OAuthProblemException => {
        val res = OAuthResponse
          .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
          .setError(e.getError())
          .setErrorDescription(e.getDescription())
          .setErrorUri(e.getUri())
          .buildJSONMessage()

        response.setStatus(res.getResponseStatus())
        res.getBody()
      }
    }
  }
}
