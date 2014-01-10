package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.StatementStorage
import java.util.UUID
import com.arcusys.learn.tincan.model.{Activity, Statement}
import com.arcusys.learn.storage.impl.{EntityStorageExt, EntityStorage}

trait StatementEntityStorage extends StatementStorage with EntityStorage[Statement] {
  def getByUUID(id: UUID): Option[Statement] = {
    getOne("uuid" -> id)
  }

  def get(parameters: (String, Any)*): Seq[Statement] = {
    getAll(parameters:_*)
  }

  def create(entity: Statement) = {
    create(entity, Nil:_*)
    entity.id
  }
}

/*object StatementEntityStorage extends StatementStorage {
  @volatile
  private[this] var statements = List[Statement]()
  private[this] val  lock = new AnyRef

  def all = statements

  def create(entity: Statement): UUID = lock.synchronized {
    statements = entity :: all
    entity.id
  }

  def getByUUID(id: UUID): Option[Statement] = all.find(_.id == id)

  def get(parameters: (String, Any)*): Seq[Statement] = {
    var result = all

    for( activityId <- parameters.find(_._1 == "activity"))
      result = result.filter(_.obj.isInstanceOf[Activity]).filter(_.obj.asInstanceOf[Activity].id == activityId)

    for( agent <- parameters.find(_._1 == "agent"))
      result = result.filter(_.actor == agent)

    for( verb <- parameters.find(_._1 == "verb"))
      result = result.filter(_.verb.id == verb)

    result
  }

  def renew(): Unit = {
    statements = List[Statement]()
  }
}*/
