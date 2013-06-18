package com.arcusys.learn.storage.impl.orbroker

import org.orbroker.Token
import BrokerFactory.{broker, dbType}
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorage, EntityStorage}

object IntExtractor extends RowExtractor[Int] {
  def extract(row: Row) = row.integer("id").get
}

object MySQLExtractor extends RowExtractor[Int] {
  def extract(row: Row) = row.integer("generated_key").get
}

abstract class GenericEntityStorageImpl[E](val table: String) extends GenericEntityStorageBaseImpl[E](table) with EntityStorageExt[E]{
}

abstract class GenericEntityStorageBaseImpl[E](val tablePath: String) extends EntityStorage[E] {
    def prepareParameters(parameters: Seq[(String, Any)]) = (for {
  (key, value) <- parameters
    if (value != None)
  } yield key -> (value match {
      case Some(v) => v
      case _ => value
    })):+ ("dbType"->dbType)

  def extract(row: Row): E

  val extractor = new RowExtractor[E] {
    def extract(row: Row) = doExtract(row)
  }

  private def doExtract(row: Row) = extract(row)

  def getAll(parameters: (String, Any)*): Seq[E] = broker.readOnly() {
    session => session.selectAll(Token(Symbol(tablePath), extractor), prepareParameters(parameters): _*)
  }

  override def getAll(action: String, parameters: (String, Any)*): Seq[E] = broker.readOnly() {
    session => session.selectAll(Token(Symbol(tablePath + action), extractor), prepareParameters(parameters): _*)
  }

  def getAll[TEntity](action: String, extractor: RowExtractor[TEntity], parameters: (String, Any)*): Seq[TEntity] = broker.readOnly() {
    session => session.selectAll(Token(Symbol(tablePath + action), extractor), prepareParameters(parameters): _*)
  }

  def getOne(parameters: (String, Any)*): Option[E] = broker.readOnly() {
    session => session.selectOne(Token(Symbol(tablePath), extractor), prepareParameters(parameters): _*)
  }

  def getOne(action: String, parameters: (String, Any)*): Option[E] = broker.readOnly() {
    session => session.selectOne(Token(Symbol(tablePath + action), extractor), prepareParameters(parameters): _*)
  }

  def create(entity: E, parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + "_insert")), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
        session.commit()
    }
  }

  def create(parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + "_insert")), (prepareParameters(parameters)): _*)
        session.commit()
    }
  }

  override def execute(action: String, parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + action)), prepareParameters(parameters): _*)
        session.commit()
    }
  }

  protected def doRenew() {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + "_renew")), "dbType" -> dbType)
        session.commit()
    }
  }

  def modify(entity: E, parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + "_update")), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
        session.commit()
    }
  }

  def modify(action: String, entity: E, parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + action)), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
        session.commit()
    }
  }

  def modify(parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + "_update")), prepareParameters(parameters): _*)
        session.commit()
    }
  }

  def modify(action: String, parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + action)), prepareParameters(parameters): _*)
        session.commit()
    }
  }

  def delete(parameters: (String, Any)*) {
    execute("_delete", parameters: _*)
  }
}

abstract class KeyedEntityStorageImpl[E](tablePath: String, val idParam: String) extends KeyedEntityStorageBaseImpl[E](tablePath, idParam) with EntityStorageExt[E]{

  def getByID(id: Int): Option[E] = getByID(id, Nil: _*)

  def createAndGetID(entity: E): Int = createAndGetID(entity, Seq(): _*)

  def delete(id: Int) {
    delete(idParamName -> id)
  }
}

abstract class KeyedEntityStorageBaseImpl[E](tablePath: String, val idParamName: String) extends GenericEntityStorageBaseImpl[E](tablePath) with KeyedEntityStorage[E]  {


  def getByID(id: Int, parameters: (String, Any)*): Option[E] = broker.readOnly() {
    session => session.selectOne(Token(Symbol(tablePath), extractor), (prepareParameters(parameters) :+ (idParamName -> id)): _*)
  }


  def createAndGetID(entity: E, parameters: (String, Any)*): Int =
    broker.transactional() {
      session =>
        val id = dbType match {
          case "postgres" => session.executeForKey(Token(Symbol(tablePath + "_insert"), IntExtractor), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
          case "mysql" => session.executeForKey(Token(Symbol(tablePath + "_insert"), MySQLExtractor), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
          case _ => session.executeForKey(Token[Int](Symbol(tablePath + "_insert")), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
        }
        session.commit()
        id.get
    }

  def createAndGetID(parameters: (String, Any)*): Int =
    broker.transactional() {
      session =>
        val id = dbType match {
          case "postgres" => session.executeForKey(Token(Symbol(tablePath + "_insert"), IntExtractor), (prepareParameters(parameters)): _*)
          case "mysql" => session.executeForKey(Token(Symbol(tablePath + "_insert"), MySQLExtractor), (prepareParameters(parameters)): _*)
          case _ => session.executeForKey(Token[Int](Symbol(tablePath + "_insert")), (prepareParameters(parameters)): _*)
        }
        session.commit()
        id.get
    }
}