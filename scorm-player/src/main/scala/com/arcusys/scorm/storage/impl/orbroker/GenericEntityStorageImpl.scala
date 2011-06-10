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

  def create(entity: E): (Int, E) = {
    val id = broker.transactional() { session =>
      val id = session.executeForKey(Token(Symbol(tablePath + "_insert"), IntExtractor), (defParams :+ ("e"->entity)):_*)
      session.commit
      id.get
    }
    defParams.clear
    (id -> getByID(id).getOrElse(throw new Exception()))
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

  def modify(entity: E): (Int, E) =
  {
    val id = broker.transactional() { session =>
      val id = session.executeForKey(Token(Symbol(tablePath + "_update"), IntExtractor), (defParams :+ ("e"->entity)):_*)
      session.commit
      id.get
    }
    defParams.clear
    (id -> getByID(id).getOrElse(throw new Exception()))
  }
}