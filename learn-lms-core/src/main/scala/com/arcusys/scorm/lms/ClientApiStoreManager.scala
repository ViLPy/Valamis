package com.arcusys.scorm.lms

import com.arcusys.learn.tincan.model.{ LrsScope }
import LrsScope._
import com.arcusys.learn.tincan.storage.TincanClientApiStorage
import scala.util.Random
import java.util.UUID
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.kernel.dao.orm.ObjectNotFoundException
import com.arcusys.learn.tincan.model.lrsServer.{ ClientApiModel, ClientApi }

//
// Created by iliya.tryapitsin on 13.02.14.
//
class ClientApiStoreManager(implicit val bindingModule: BindingModule) extends ClientApiStoreManagerContract with Injectable {
  private val tincanClientApiStorage = inject[TincanClientApiStorage]

  val expiredIn: Long = 3600

  def registration(clientName: String,
    clientDescription: Option[String],
    clientUrl: Option[String],
    clientRedirectUrl: Option[String],
    scope: LrsScope,
    clientIcon: Option[String]): ClientApiModel = {

    val tmpid = Random.nextLong()
    val id = if (tmpid > 0) tmpid else tmpid * -1
    val secret = UUID.randomUUID.toString
    val description = clientDescription match {
      case Some(value) => value
      case None        => ""
    }
    val url = clientUrl match {
      case Some(value) => value
      case None        => ""
    }
    val redirectUrl = clientRedirectUrl match {
      case Some(value) => value
      case None        => ""
    }
    val icon = clientIcon match {
      case Some(value) => value
      case None        => ""
    }

    val clientApi = ClientApi(id, secret, clientName, description, url, redirectUrl, icon, "", "", "", expiredIn, scope)
    val clientApiModel = ClientApiModel(id.toString, secret, clientName, "", expiredIn, scope)
    tincanClientApiStorage.create(clientApi)

    return clientApiModel
  }

  def setFetchToken(clientId: Long, fetchToken: String) = {
    val clientApi = tincanClientApiStorage.getById(clientId)
    val c = clientApi match {
      case Some(value) => value
      case None        => throw new ObjectNotFoundException()
    }

    tincanClientApiStorage.modify(c.copy(code = fetchToken, token = ""))
  }

  def setAccessToken(clientId: Long, accessToken: String, /*not used*/ refreshToken: String) = {
    val clientApi = tincanClientApiStorage.getById(clientId)
    val c = clientApi match {
      case Some(value) => value
      case None        => throw new ObjectNotFoundException()
    }

    tincanClientApiStorage.modify(c.copy(token = accessToken, code = ""))
  }

  def validate(token: String): Boolean = {
    try {
      getClientByToken(token)
      true
    } catch {
      case _: Throwable => false
    }
  }

  def getClientById(clientId: Long): ClientApiModel = {
    val clientApi = tincanClientApiStorage.getById(clientId)
    return clientApi match {
      case Some(value) => ClientApiModel(value.id.toString, value.secret, value.name, value.issuedAt, value.expiredIn, value.scope)
      case None        => throw new ObjectNotFoundException()
    }
  }

  def getClientByToken(token: String): ClientApiModel = {
    val clientApi = tincanClientApiStorage.getByToken(token)
    return clientApi match {
      case Some(value) => ClientApiModel(value.id.toString, value.secret, value.name, value.issuedAt, value.expiredIn, value.scope)
      case None        => throw new ObjectNotFoundException()
    }
  }

  def checkClientFetchCode(clientId: Long, code: String): Boolean = {
    val clientApi = tincanClientApiStorage.getById(clientId)
    return clientApi match {
      case Some(value) => return value.code == code
      case None        => return false
    }
  }

  def isExistClient(clientId: Long): Boolean = {
    val clientApi = tincanClientApiStorage.getById(clientId)
    return clientApi match {
      case Some(value) => return true
      case None        => return false
    }
  }

  def getAll(): Seq[ClientApiModel] = {
    return tincanClientApiStorage
      .getAll()
      .map(value => ClientApiModel(value.id.toString, value.secret, value.name, value.issuedAt, value.expiredIn, value.scope))
      .toSeq
  }
}
