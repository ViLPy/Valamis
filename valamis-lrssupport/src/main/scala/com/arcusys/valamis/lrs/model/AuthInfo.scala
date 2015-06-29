package com.arcusys.valamis.lrs.model

trait AuthInfo


case class BasicAuthInfo(auth: String) extends AuthInfo

case class OAuthAuthInfo(token: String, verifier: String, tokenSecret: String) extends AuthInfo
