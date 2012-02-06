package com.arcusys.scorm.storage.impl.orbroker

import org.orbroker.Token
import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._
import org.orbroker.RowExtractor
import org.orbroker.Row
import org.orbroker.conv._
import scala.collection.mutable.MutableList

object IntExtractor extends RowExtractor[Int]
{
  def extract(row: Row) = row.integer("id").get
}

trait GenericEntityStorageImpl[E]
{
  def tablePath: String
  def extractor: RowExtractor[E]
  def idParam: String
  val defParams: MutableList[(String, Any)] = new MutableList()

  def getAll: IndexedSeq[E] = {
    broker.readOnly() { session => session.selectAll(Token(Symbol(tablePath), extractor), defParams:_*) }
  }

  def getByID(id: Int): Option[E] =
  {
    broker.readOnly() { session => session.selectOne(Token(Symbol(tablePath), extractor), (defParams :+ (idParam->id)):_*) }
  }

  // will return database ID as first param and entity as second
  // added for SCORM id, where database id isn't equal to id in SCORM package
  def create(entity: E): E = {
    val id = broker.transactional() { session =>
      val id = session.executeForKey(Token(Symbol(tablePath + "_insert"), IntExtractor), (defParams :+ ("e"->entity)):_*)
      session.commit
      id.get
    }
    defParams.clear
    getByID(id).getOrElse(throw new Exception("Some problems in entity creation"))
  }

  def delete(id: Int) = {
    broker.transactional() { session =>
      val count = session.execute(Token(Symbol(tablePath + "_delete")), (defParams :+ (idParam->id)):_*)
      if (count == 1) session.commit else {
        session.rollback
        throw new Exception()
      }
    }
  }

  def renew() =
  {
    broker.transactional() {session=>
      session.execute(Token(Symbol(tablePath + "_renew")))
      session.commit
    }
  }

  // will return database ID as first param and entity as second
  // added for SCORM id, where database id isn't equal to id in SCORM package
  def modify(entity: E): E =
  {
    val id = broker.transactional() { session =>
      val id = session.executeForKey(Token(Symbol(tablePath + "_update"), IntExtractor), (defParams :+ ("e"->entity)):_*)
      session.commit
      id.getOrElse(throw new Exception("Can't get id for entity " + entity.toString))
    }
    defParams.clear
    getByID(id).getOrElse(throw new Exception("Some "))
  }
}