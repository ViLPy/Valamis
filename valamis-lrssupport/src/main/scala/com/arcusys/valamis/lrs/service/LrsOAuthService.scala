package com.arcusys.valamis.lrs.service

import com.arcusys.valamis.lrs.model.{OAuthAuthInfo, OAuthParams}
import com.arcusys.valamis.lrs.tincan.AuthorizationScope

trait LrsOAuthService {

  def authorize(endpoint: String,
    clientId: String,
    clientSecret: String,
    scope: AuthorizationScope.ValueSet,
    redirectUrl: Option[String]): OAuthAuthInfo

  def getAccessToken(endpoint: String,
    clientId: String,
    clientSecret: String,
    scope: AuthorizationScope.ValueSet,
    params: OAuthParams): OAuthAuthInfo
}
