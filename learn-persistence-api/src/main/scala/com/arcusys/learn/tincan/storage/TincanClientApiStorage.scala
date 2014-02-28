package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.lrsServer.ClientApi

/**
 * Created by Iliya on 17.02.14.
 */
trait TincanClientApiStorage {
  def create(clientApi: ClientApi)

  def getById(clientId: Long): Option[ClientApi]

  //def renew()

  def getByToken(token: String): Option[ClientApi]

  def getAll(): Seq[ClientApi]

  def modify(entity: ClientApi)
}
