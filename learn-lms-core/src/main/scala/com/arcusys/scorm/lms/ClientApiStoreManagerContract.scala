package com.arcusys.scorm.lms

import com.arcusys.learn.tincan.model.LrsScope
import LrsScope.LrsScope
import com.arcusys.learn.tincan.model.lrsServer.ClientApiModel

//
// Created by iliya.tryapitsin on 12.02.14.
//
trait ClientApiStoreManagerContract {
  def registration(
    clientName: String,
    clientDescription: Option[String],
    clientUrl: Option[String],
    redirectUrl: Option[String],
    scope: LrsScope,
    clientIcon: Option[String]): ClientApiModel

  def setFetchToken(clientId: Long, fetchToken: String)

  def setAccessToken(clientId: Long, accessToken: String, refreshToken: String)

  def validate(token: String): Boolean

  def getClientById(clientId: Long): ClientApiModel

  def getClientByToken(accessToken: String): ClientApiModel

  def checkClientFetchCode(clientId: Long, fetchCode: String): Boolean

  def isExistClient(clientId: Long): Boolean

  def getAll(): Seq[ClientApiModel]
}
