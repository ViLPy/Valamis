package com.arcusys.learn.tincan.lrs

import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith

import java.util.{ Date, UUID }
import java.net.URI

import com.arcusys.learn.tincan.storage.StatementStorage
import com.arcusys.learn.tincan.model.{ Verb, Agent, Statement }
import com.arcusys.learn.tincan.lrs.statement.{ StatementLRSAlreadyExistsException, StatementLRSException, StatementLRSArgumentException }

@RunWith(classOf[JUnitRunner])
class StatementLRSSpec extends Specification {
  sequential
  private val storage = InMemoryStatementStorage

  private val service = new statement.StatementLRS {
    val statementStorage = InMemoryStatementStorage
  }

  "The 'addStatement' method" should {

    "add a statement and return 'StatementAdded' if the statement with given id doesn't exist yet" in {
      val uuid = UUID.randomUUID()
      val result = service.addStatement(storage.statement.copy(id = uuid))
      val stored = storage.all.find(_.id == uuid)
      result mustEqual uuid
      stored must beSome
      stored.get.verb.id.toString mustEqual URI.create("verbId").toString
    }

    "throw 'StatementLRSAlreadyExistsException' if the given statement equals to the existing one with the same id" in {
      service.addStatement(storage.statement) must throwA[StatementLRSAlreadyExistsException]

    }

    "throw 'StatementLRSAlreadyExistsException' if the given statement differs from the existing one with the same id" in {
      val uuid = UUID.fromString("40d10a63-2c37-4071-9595-793af98e89b0")
      service.addStatement(storage.statement.copy(id = uuid)) must throwA[StatementLRSAlreadyExistsException]
    }

    "throw 'StatementLRSArgumentException' if given statement is null" in {
      service.addStatement(null) must throwA[StatementLRSArgumentException]
    }

  }

  "The 'addStatements' method" should {

    "add new statements and return generated UUID for every stored statement from given list" in {
      InMemoryStatementStorage.reset()
      val s1: Statement = storage.statement.copy(id = UUID.randomUUID())
      val s2: Statement = storage.statement.copy(id = UUID.randomUUID())
      val result = service.addStatements(Seq(s1, s2))
      result must have size 2
      storage.all.find(_.id == s1.id) must beSome
      storage.all.find(_.id == s2.id) must beSome
    }

    "add only those statements which doesn't exist yet" in {
      InMemoryStatementStorage.reset()
      val s1: Statement = storage.statement.copy(id = UUID.randomUUID())
      val s2: Statement = storage.statement.copy(id = UUID.randomUUID())
      val s3: Statement = storage.statement
      val result = service.addStatements(Seq(s1, s2, s3))
      result must have size 2
      storage.all.filter(_.id == s3.id) must have size 1
      storage.all.find(_.id == s1.id) must beSome
      storage.all.find(_.id == s2.id) must beSome
    }

    "not a statement which id is matched with existing one and the rest is different" in {
      InMemoryStatementStorage.reset()
      val s1: Statement = storage.statement.copy(id = UUID.randomUUID())
      val s2: Statement = storage.statement
      val s3: Statement = storage.statement.copy(
        id = UUID.fromString("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        verb = Verb("1234", Map.empty[String, String])
      )
      val result = service.addStatements(Seq(s1, s2, s3))
      result should have size 1
      storage.all.find(_.id == s1.id) must beSome
    }

    "throw 'StatementLRSArgumentException' if list of given statements is null" in {
      InMemoryStatementStorage.reset()
      service.addStatements(null) must throwA[StatementLRSArgumentException]
    }

  }

  "The 'getStatement' method" should {

    "return a statement by given id if exists" in {
      val result = service.getStatement(UUID.fromString("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"))
      result must beSome
      result.get.verb.id.toString mustEqual "verbId"
    }

    "return nothing if statement doesn't exist for specified id" in {
      val result = service.getStatement(UUID.randomUUID())
      result must beNone
    }

    "throw 'StatementLRSArgumentException' if given id is null" in {
      service.getStatement(null) must throwA[StatementLRSArgumentException]
    }

  }

  "The 'getStatements' method" should {

    "throw 'StatementLRSException' if both statementId and voidedStatementId are specified" in {
      val filter = statement.StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        Some("fdf01fb5-25c0-4c75-b482-74ba0fbc3584"),
        None, None, None, None, None, None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified statementId and agent" in {
      val filter = statement.StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        Some(Agent("Agent", None, None, None, None, None)),
        None, None, None, None, None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified statement id and verb id" in {
      val filter = statement.StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        None,
        Some("verbId1"),
        None, None, None, None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified statement id and activity id" in {
      val filter = statement.StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        None, None,
        Some("activityId1"),
        None, None, None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified statement id and registration id" in {
      val filter = statement.StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        None, None, None,
        Some(UUID.randomUUID()),
        None, None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified statement id and date since it is created" in {
      val filter = statement.StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        None, None, None, None,
        Some(new Date()),
        None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified statement id and date until it is created" in {
      val filter = statement.StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        None, None, None, None, None,
        Some(new Date()))
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified voidedId and agent" in {
      val filter = statement.StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        Some(Agent("Agent", None, None, None, None, None)),
        None, None, None, None, None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified voided id and verb id" in {
      val filter = statement.StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        None,
        Some("verbId1"),
        None, None, None, None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified voided id and activity id" in {
      val filter = statement.StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        None, None,
        Some("activityId1"),
        None, None, None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified voided id and registration id" in {
      val filter = statement.StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        None, None, None,
        Some(UUID.randomUUID()),
        None, None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified voided id and date since it is created" in {
      val filter = statement.StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        None, None, None, None,
        Some(new Date()),
        None)
      service.getStatements(filter) must throwA[StatementLRSException]
    }

    "throw 'StatementLRSException' if specified voided id and date until it is created" in {
      val filter = statement.StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        None, None, None, None, None,
        Some(new Date()))
      service.getStatements(filter) must throwA[StatementLRSException]
    }

  }

}

object InMemoryStatementStorage extends StatementStorage {
  val statement = Statement(
    UUID.fromString("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
    Agent("Agent", Some("agent1"), None, None, None, None),
    Verb("verbId", Map.empty[String, String]),
    null,
    None,
    None,
    None,
    None,
    None,
    None,
    Seq()
  )

  @volatile
  private[this] var statements = List(
    statement,
    statement.copy(
      id = UUID.fromString("40d10a63-2c37-4071-9595-793af98e89b0"),
      verb = Verb("verbId2", Map.empty[String, String]))
  )
  private[this] val lock = new AnyRef

  def all = statements

  def create(entity: Statement): UUID = lock.synchronized {
    statements = entity :: all
    entity.id
  }

  def getByUUID(id: UUID): Option[Statement] = all.find(_.id == id)

  def reset() {
    statements = List(
      statement,
      statement.copy(
        id = UUID.fromString("40d10a63-2c37-4071-9595-793af98e89b0"),
        verb = Verb("verbId2", Map.empty[String, String]))
    )
  }

  def get(parameters: (String, Any)*): Seq[Statement] = null

  def renew(): Unit = reset()
}