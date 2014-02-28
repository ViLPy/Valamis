package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.TincanClientApiStorage
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model.lrsServer.ClientApi

/**
 * Created by Iliya on 17.02.14.
 */
trait TincanClientApiEntityStorage extends TincanClientApiStorage with KeyedEntityStorage[ClientApi] {
  def create(clientApi: ClientApi) {
    create(entity = clientApi, parameters = Nil: _*)
  }

  def getById(clientId: Long): Option[ClientApi] = {
    /*getAll()
      .find(x => x.id == clientId)*/
    return getByID(clientId, parameters = Nil: _*)
  }

  def getByToken(token: String): Option[ClientApi] = {
    return getOne("token" -> token)
  }

  def getAll(): Seq[ClientApi] = {
    return getAll(parameters = Nil: _*)
  }

  def modify(entity: ClientApi) = {
    modify(entity, parameters = Nil: _*)
  }
}
