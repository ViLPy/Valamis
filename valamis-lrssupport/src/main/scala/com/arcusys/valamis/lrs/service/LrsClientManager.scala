package com.arcusys.valamis.lrs.service

import javax.servlet.http.HttpServletRequest

import com.arcusys.valamis.lrs.api.valamis.VerbApi
import com.arcusys.valamis.lrs.api.{ActivityProfileApi, StatementApi}
import com.arcusys.valamis.lrs.model.{AuthInfo, EndpointInfo, OAuthParams}
import com.arcusys.valamis.lrs.tincan.AuthorizationScope
import com.arcusys.valamis.lrsEndpoint.model.LrsEndpointSettings

trait LrsClientManager {

  def statementApi[T](action: (StatementApi => T), auth: String): T

  def verbApi[T](action: VerbApi => T, auth: String): T

  def activityProfileApi[T](action: (ActivityProfileApi => T), auth: String): T

  def getToken(token: String): AuthInfo

  def getLrsSettings: LrsEndpointSettings

  /* Request proxy lrs settings with real authorization */
  def requestProxyLrsEndpointInfo(params: OAuthParams,
                                  scope: AuthorizationScope.ValueSet,
                                  hostUrl: String ): EndpointInfo

  def getLrsEndpointInfo(scope: AuthorizationScope.ValueSet, request: Option[HttpServletRequest] = None): EndpointInfo

  def deleteToken(token: String): Unit
}
