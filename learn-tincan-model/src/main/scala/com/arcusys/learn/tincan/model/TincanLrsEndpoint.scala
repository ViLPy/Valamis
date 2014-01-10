package com.arcusys.learn.tincan.model


case class LrsEndpointSettings(
  endpoint: String,
  auth: LrsAuthorization
                              )

trait LrsAuthorization

case object UserBasicAuthorization extends LrsAuthorization

case class CommonBasicAuthorization(
  username: String,
  password: String) extends LrsAuthorization

case class OAuthAuthorization (
  consumerKey: String,
  consumerSecret:String) extends LrsAuthorization