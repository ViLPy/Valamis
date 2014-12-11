package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.models.request.AdminActionType.AdminActionType
import org.apache.oltu.oauth2.common.OAuth
import com.arcusys.learn.tincan.model.lrsClient.{ AuthorizationType }
import org.scalatra.ScalatraBase
import com.arcusys.learn.tincan.model.lrsClient.AuthorizationType.AuthorizationType

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object AdminRequest {
  val ISSUER_NAME = "issuerName"
  val ISSUER_ORGANIZATION = "issuerOrganization"
  val ISSUER_URL = "issuerUrl"
  val SEND_MESSAGES = "sendMessages"
  val ACTION = "action"
  val IS_EXTERNAL_LRS = "isExternalLrs"
  val END_POINT = "endpoint"
  val AUTH_TYPE = "authType"
  val COMMON_CREDENTIALS = "commonCredentials"
  val COMMON_CREDENTIALS_LOGIN = "loginName"
  val COMMON_CREDENTIALS_PASSWORD = "password"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) {
    implicit val _scalatra = scalatra

    def issuerName = Parameter(AdminRequest.ISSUER_NAME).required
    def issuerOrganization = Parameter(AdminRequest.ISSUER_ORGANIZATION).required
    def issuerUrl = Parameter(AdminRequest.ISSUER_URL).required
    def sendMessages = Parameter(AdminRequest.SEND_MESSAGES).required
    def actionType: AdminActionType = AdminActionType.withName(Parameter(AdminRequest.ACTION).required.toUpperCase)
    def isExternalLrs: Boolean = Parameter(AdminRequest.IS_EXTERNAL_LRS).booleanRequired

    def endPoint: String = {
      if (isExternalLrs) {
        val e = Parameter(AdminRequest.END_POINT)
          .required
          .trim

        if (e.endsWith("/"))
          e
        else
          e + "/"
      } else {
        throw new IllegalStateException("'isExternalLrs' should be true")
      }
    }

    def authType: AuthorizationType = {
      if (isExternalLrs) {
        return AuthorizationType.withName(Parameter(AdminRequest.AUTH_TYPE).required.toUpperCase)
      } else {
        throw new IllegalStateException("'isExternalLrs' should be true")
      }
    }

    def login: String = {
      if (isExternalLrs && isCommonCredentials) {
        return Parameter(AdminRequest.COMMON_CREDENTIALS_LOGIN).required
      } else {
        throw new IllegalStateException("isExternalLrs should be true and 'commonCredentials' should be true")
      }
    }

    def password: String = {
      if (isExternalLrs && isCommonCredentials) {
        return Parameter(AdminRequest.COMMON_CREDENTIALS_PASSWORD).required
      } else {
        throw new IllegalStateException("'isExternalLrs' should be true and 'commonCredentials' should be true")
      }
    }

    def clientId: String = {
      if (isExternalLrs && !isCommonCredentials) {
        return Parameter(OAuth.OAUTH_CLIENT_ID).required
      } else {
        throw new IllegalStateException("isExternalLrs should be true and 'commonCredentials' should be false")
      }
    }

    def clientSecret: String = {
      if (isExternalLrs && !isCommonCredentials) {
        return Parameter(OAuth.OAUTH_CLIENT_SECRET).required
      } else {
        throw new IllegalStateException("'isExternalLrs' should be true and 'commonCredentials' should be false")
      }
    }

    def isCommonCredentials: Boolean = {
      if (isExternalLrs) {
        return Parameter(AdminRequest.COMMON_CREDENTIALS)
          .option
          .exists(x => (x == "on" || x == "1" || x == "true"))
      } else {
        throw new IllegalStateException("'isExternalLrs' should be true")
      }
    }
  }
}

