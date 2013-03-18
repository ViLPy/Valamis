package com.arcusys.learn.storage.impl.orbroker

import org.orbroker.Token
import BrokerFactory._
import org.orbroker.{RowExtractor, Row}
import org.postgresql.ds.PGPoolingDataSource
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource

object IntExtractor extends RowExtractor[Int] {
  def extract(row: Row) = row.integer("id").get
}

object MySQLExtractor extends RowExtractor[Int] {
  def extract(row: Row) = row.integer("generated_key").get
}

abstract class GenericEntityStorageImpl[E](val tablePath: String) {
  private def getDBType = broker.dataSource match {
    case postgres: PGPoolingDataSource => "postgres"
    case postgres: MysqlDataSource => "mysql"
    case _ => "h2"
  }

  def prepareParameters(parameters: Seq[(String, Any)]) = (for {
    (key, value) <- parameters
    if (value != None)
  } yield key -> (value match {
      case Some(v) => v
      case _ => value
    })):+ ("dbType"->getDBType)

  def extract(row: Row): E

  val extractor = new RowExtractor[E] {
    def extract(row: Row) = GenericEntityStorageImpl.this.extract(row)
  }

  def getAll: Seq[E] = getAll()

  def getAll(parameters: (String, Any)*): Seq[E] = broker.readOnly() {
    session => session.selectAll(Token(Symbol(tablePath), extractor), prepareParameters(parameters): _*)
  }

  def getAll(action: String, parameters: (String, Any)*): Seq[E] = broker.readOnly() {
    session => session.selectAll(Token(Symbol(tablePath + action), extractor), prepareParameters(parameters): _*)
  }

  def getAll[TEntity](action: String, extractor: RowExtractor[TEntity], parameters: (String, Any)*): Seq[TEntity] = broker.readOnly() {
    session => session.selectAll(Token(Symbol(tablePath + action), extractor), prepareParameters(parameters): _*)
  }

  protected def getOne(parameters: (String, Any)*): Option[E] = broker.readOnly() {
    session => session.selectOne(Token(Symbol(tablePath), extractor), prepareParameters(parameters): _*)
  }
  protected def getOne(action: String, parameters: (String, Any)*): Option[E] = broker.readOnly() {
    session => session.selectOne(Token(Symbol(tablePath + action), extractor), prepareParameters(parameters): _*)
  }

  def create(entity: E) {
    create(entity, Nil: _*)
  }

  protected def create(entity: E, parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + "_insert")), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
        session.commit()
    }
  }

  protected def create(parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + "_insert")), (prepareParameters(parameters)): _*)
        session.commit()
    }
  }

  def execute(action: String, parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + action)), prepareParameters(parameters): _*)
        session.commit()
    }
  }

  def renew() {
    val dbType = broker.dataSource match {
      case postgres: PGPoolingDataSource => "postgres"
      case postgres: MysqlDataSource => "mysql"
      case _ => "h2"
    }
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + "_renew")), "dbType" -> dbType)
        session.commit()
    }
  }

  def modify(entity: E) {
    modify(entity, Nil: _*)
  }

  protected def modify(entity: E, parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + "_update")), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
        session.commit()
    }
  }
  protected def modify(action: String, entity: E, parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + action)), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
        session.commit()
    }
  }

  protected def modify(parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + "_update")), prepareParameters(parameters): _*)
        session.commit()
    }
  }

  def modify(action: String, parameters: (String, Any)*){
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + action)), prepareParameters(parameters): _*)
        session.commit()
    }
  }

  protected def delete(parameters: (String, Any)*) {
    execute("_delete", parameters: _*)
  }
}

abstract class KeyedEntityStorageImpl[E](tablePath: String, val idParam: String) extends GenericEntityStorageImpl[E](tablePath) {
  def getByID(id: Int): Option[E] = getByID(id, Nil: _*)

  protected def getByID(id: Int, parameters: (String, Any)*): Option[E] = broker.readOnly() {
    session => session.selectOne(Token(Symbol(tablePath), extractor), (prepareParameters(parameters) :+ (idParam -> id)): _*)
  }

  def createAndGetID(entity: E): Int = createAndGetID(entity, Nil: _*)

  protected def createAndGetID(entity: E, parameters: (String, Any)*): Int =
    broker.transactional() {
      session =>
        val id = broker.dataSource match {
          case postgres: PGPoolingDataSource=> session.executeForKey(Token(Symbol(tablePath + "_insert"), IntExtractor), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
          case mysql: MysqlDataSource => session.executeForKey(Token(Symbol(tablePath + "_insert"), MySQLExtractor), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
          case _ => session.executeForKey(Token[Int](Symbol(tablePath + "_insert")), (prepareParameters(parameters) :+ ("e" -> entity)): _*)
        }
        session.commit()
        id.get
    }

  protected def createAndGetID(parameters: (String, Any)*): Int =
    broker.transactional() {
      session =>
        val id = broker.dataSource match {
          case postgres: PGPoolingDataSource=> session.executeForKey(Token(Symbol(tablePath + "_insert"), IntExtractor), (prepareParameters(parameters)): _*)
          case mysql: MysqlDataSource => session.executeForKey(Token(Symbol(tablePath + "_insert"), MySQLExtractor), (prepareParameters(parameters)): _*)
          case _ => session.executeForKey(Token[Int](Symbol(tablePath + "_insert")), (prepareParameters(parameters)): _*)
        }
        session.commit()
        id.get
    }

  def delete(id: Int) {
    delete(idParam -> id)
  }
}