package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.models.request.AdminActionType.AdminActionType
import com.arcusys.valamis.lrsEndpoint.model.AuthorizationType
import org.scalatra.ScalatraBase
import AuthorizationType.AuthorizationType

object AdminRequest extends BaseRequest {
  val IssuerName = "issuerName"
  val IssuerOrganisation = "issuerOrganization"
  val IssuerURL = "issuerUrl"
  val IssuerEmail = "issuerEmail"
  val SendMessages = "sendMessages"
  val IsExternalLRS = "isExternalLrs"
  val Endpoint = "endpoint"
  val AuthType = "authType"
  val CommonCredentials = "commonCredentials"
  val CommonCredentialsLogin = "loginName"
  val CommonCredentialsPassword = "password"
  val OauthClientId = "client_id"
  val OauthClientSecret = "client_secret"
  val GoogleClientId = "googleClientId"
  val GoogleAppId = "googleAppId"
  val GoogleApiKey = "googleApiKey"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) {
    implicit val _scalatra = scalatra

    def issuerName = Parameter(AdminRequest.IssuerName).required
    def issuerOrganization = Parameter(AdminRequest.IssuerOrganisation).required
    def issuerUrl = Parameter(AdminRequest.IssuerURL).required
    def issuerEmail = Parameter(AdminRequest.IssuerEmail).required
    def sendMessages = Parameter(AdminRequest.SendMessages).required
    def googleClientId = Parameter(AdminRequest.GoogleClientId).required
    def googleAppId = Parameter(AdminRequest.GoogleAppId).required
    def googleApiKey = Parameter(AdminRequest.GoogleApiKey).required
    def actionType: AdminActionType = AdminActionType.withName(Parameter(AdminRequest.Action).required.toUpperCase)
    def isExternalLrs: Boolean = Parameter(AdminRequest.IsExternalLRS).booleanRequired
    def courseId = Parameter(CourseId).intRequired

    def endPoint: String = {
      if (isExternalLrs) {
        val e = Parameter(AdminRequest.Endpoint)
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
        AuthorizationType.withName(Parameter(AdminRequest.AuthType).required.toUpperCase)
      } else {
        throw new IllegalStateException("'isExternalLrs' should be true")
      }
    }

    def login: String = {
      if (isExternalLrs && isCommonCredentials) {
        Parameter(AdminRequest.CommonCredentialsLogin).required
      } else {
        throw new IllegalStateException("isExternalLrs should be true and 'commonCredentials' should be true")
      }
    }

    def password: String = {
      if (isExternalLrs && isCommonCredentials) {
        Parameter(AdminRequest.CommonCredentialsPassword).required
      } else {
        throw new IllegalStateException("'isExternalLrs' should be true and 'commonCredentials' should be true")
      }
    }

    def clientId: String = {
      if (isExternalLrs && !isCommonCredentials) {
        Parameter(OauthClientId).required
      } else {
        throw new IllegalStateException("isExternalLrs should be true and 'commonCredentials' should be false")
      }
    }

    def clientSecret: String = {
      if (isExternalLrs && !isCommonCredentials) {
        Parameter(OauthClientSecret).required
      } else {
        throw new IllegalStateException("'isExternalLrs' should be true and 'commonCredentials' should be false")
      }
    }

    def isCommonCredentials: Boolean = {
      if (isExternalLrs) {
        Parameter(AdminRequest.CommonCredentials)
          .option
          .exists(x => x == "on" || x == "1" || x == "true")
      } else throw new IllegalStateException("'isExternalLrs' should be true")
    }
  }
}

