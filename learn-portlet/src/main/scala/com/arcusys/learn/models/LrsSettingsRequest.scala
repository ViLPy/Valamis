package com.arcusys.learn.models

import javax.servlet.http.HttpServletRequest
import com.arcusys.learn.tincan.model.lrsClient.AuthorizationType.AuthorizationType
import com.arcusys.learn.tincan.model.lrsClient.AuthorizationTypeConverters._
import org.apache.oltu.oauth2.common.OAuth
import com.arcusys.learn.service.util.Parameter

/**
 * Created by Iliya Tryapitsin on 24.02.14.
 */
object LrsSettingsRequest {
  val IS_EXTERNAL_LRS = "isExternalLrs"
  val END_POINT = "endpoint"
  val AUTH_TYPE = "authType"
  val COMMON_CREDENTIALS = "commonCredentials"
  val COMMON_CREDENTIALS_LOGIN = "loginName"
  val COMMON_CREDENTIALS_PASSWORD = "password"
}

class LrsSettingsRequest(request: HttpServletRequest) {
  implicit val r: HttpServletRequest = request

  def isExternalLrs: Boolean = Parameter(LrsSettingsRequest.IS_EXTERNAL_LRS).booleanRequired

  def endPoint: String = {
    if(isExternalLrs) {
      val e = Parameter(LrsSettingsRequest.END_POINT)
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
    if(isExternalLrs) {
      return Parameter(LrsSettingsRequest.AUTH_TYPE).required
    } else {
      throw new IllegalStateException("'isExternalLrs' should be true")
    }
  }

  def login: String = {
    if(isExternalLrs && isCommonCredentials) {
      return Parameter(LrsSettingsRequest.COMMON_CREDENTIALS_LOGIN).required
    } else {
      throw new IllegalStateException("isExternalLrs should be true and 'commonCredentials' should be true")
    }
  }

  def password: String = {
    if(isExternalLrs && isCommonCredentials) {
      return Parameter(LrsSettingsRequest.COMMON_CREDENTIALS_PASSWORD).required
    } else {
      throw new IllegalStateException("'isExternalLrs' should be true and 'commonCredentials' should be true")
    }
  }

  def clientId: String = {
    if(isExternalLrs && !isCommonCredentials) {
      return Parameter(OAuth.OAUTH_CLIENT_ID).required
    } else {
      throw new IllegalStateException("isExternalLrs should be true and 'commonCredentials' should be false")
    }
  }

  def clientSecret: String = {
    if(isExternalLrs && !isCommonCredentials) {
      return Parameter(OAuth.OAUTH_CLIENT_SECRET).required
    } else {
      throw new IllegalStateException("'isExternalLrs' should be true and 'commonCredentials' should be false")
    }
  }

  def isCommonCredentials: Boolean = {
    if(isExternalLrs) {
      return  Parameter(LrsSettingsRequest.COMMON_CREDENTIALS)
        .option
        .exists(x => (x == "on" || x == "1" || x == "true"))
    } else {
      throw new IllegalStateException("'isExternalLrs' should be true")
    }
  }
}
