package com.arcusys.learn.oauth

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.achievements.BaseWebService
import org.apache.oltu.oauth2.as.issuer.{MD5Generator, OAuthIssuerImpl}
import org.apache.oltu.oauth2.as.response.OAuthASResponse
import javax.servlet.http.HttpServletResponse
import com.arcusys.learn.ioc.Configuration
import org.apache.oltu.oauth2.as.request.{ OAuthAuthzRequest}
import org.apache.oltu.oauth2.common.OAuth
import org.apache.oltu.oauth2.common.exception.OAuthProblemException
import org.apache.oltu.oauth2.common.message.OAuthResponse
import org.apache.oltu.oauth2.common.error.OAuthError

//
// Created by iliya.tryapitsin on 10.02.14.
//
class InitializeController(configuration: BindingModule) extends BaseWebService(configuration) with SignatureValidator {
  def this() = this(Configuration)

  before(){
    val oauthRequest = new OAuthAuthzRequest(request)
    if(!verifyRequest(oauthRequest))
      halt(HttpServletResponse.SC_BAD_REQUEST)
  }

  get("/") {
    handleRequest()
  }

  post("/") {
    handleRequest()
  }

  private def handleRequest(): String = {
    try {
      val oauthRequest = new OAuthAuthzRequest(request)
      val oauthIssuerImpl: OAuthIssuerImpl = new OAuthIssuerImpl(new MD5Generator())
      val clientId = oauthRequest.getParam(OAuth.OAUTH_CLIENT_ID).toLong
      val fetchToken = oauthIssuerImpl.authorizationCode()
      val responseBuilder = OAuthASResponse.authorizationResponse(request, HttpServletResponse.SC_FOUND)

      if (!clientApiStoreManager.isExistClient(clientId)) {
        val resp = OAuthResponse
          .errorResponse(HttpServletResponse.SC_BAD_REQUEST)
          .setError(OAuthError.TokenResponse.INVALID_CLIENT)
          .setErrorDescription("client_id not found")
          .buildJSONMessage()

        response.setStatus(resp.getResponseStatus())
        resp.getBody()
      }

      responseBuilder.setCode(fetchToken)
      clientApiStoreManager.setFetchToken(clientId, fetchToken)

      val resp = responseBuilder.buildJSONMessage()
      response.setStatus(resp.getResponseStatus())
      resp.getBody()

    } catch {
      case e: OAuthProblemException => {
        val res = OAuthResponse
          .errorResponse(HttpServletResponse.SC_BAD_REQUEST)
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
