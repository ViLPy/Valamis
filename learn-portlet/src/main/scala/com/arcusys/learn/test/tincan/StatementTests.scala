package com.arcusys.learn.test.tincan

import com.arcusys.learn.tincan.lrs.statement._
import java.util.{Calendar, Date, UUID}
import java.net.URI
import java.io.PrintWriter
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.lrs.statement.StatementFilter
import scala.Some
import com.arcusys.learn.tincan.lrs.statement.StatementLRSException
import com.arcusys.learn.tincan.lrs.statement.StatementLRSAlreadyExistsException
import com.arcusys.learn.tincan.model.Activity
import com.arcusys.learn.tincan.model.Statement
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.model.Verb
import com.arcusys.learn.tincan.lrs.statement.StatementLRSArgumentException

class StatementTests(writer: PrintWriter, statementLRS: StatementLRS) {

  statementLRS.statementStorage.renew()

  val calendar = Calendar.getInstance()
  calendar.setTime(new Date)
  calendar.add(Calendar.MINUTE, -5)
  val startTime = calendar.getTime()
  calendar.setTime(new Date)
  calendar.add(Calendar.YEAR, 1)
  val future = calendar.getTime()
  calendar.setTime(new Date)
  calendar.add(Calendar.YEAR, -1)
  val past = calendar.getTime()

  val statement = Statement(
    UUID.fromString("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
    Agent("Agent", Some("agent1"), None, None, None, None),
    Verb("verbId", Map.empty[String, String]),
    new Agent("Agent", Some("agent1"), None, None, None, None),
    None,
    None,
    Some(new Date()),
    Some(future),
    None,
    None,
    Seq()
  )

  val statement1 = Statement(
    UUID.fromString("fdf01fb5-25c0-4c15-b481-74ba0fbc1111"),
    Agent("Agent", Some("agent_test1"), Some("mailto:test@test.com"), None, None, None),
    Verb("verbId_test1", Map.empty[String, String]),
    new Activity("Activity", "activityId", None, None, None, None, None, Set(""), Seq(), Seq(), Seq(), Seq(), Seq(), Seq()),
    None,
    None,
    Some(future),
    Some(future),
    None,
    None,
    Seq()
  )

  val statementWithSubStatement = Statement(
    UUID.fromString("fdf01fb5-25c0-4c15-b481-74ba0fbc3123"),
    Agent("Agent", Some("agent1"), None, None, None, None),
    Verb("verbId_test1", Map.empty[String, String]),
    new SubStatement(
      Agent("Agent", Some("agent_sub"), None, None, None, None),
      Verb("verbId_test1", Map.empty[String, String]),
      new Activity("Activity", "activitySubId", None, None, None, None, None, Set(""), Seq(), Seq(), Seq(), Seq(), Seq(), Seq()),
      "SubStatement", None),
    None,
    Some(new Context(Some(UUID.fromString("fdf01666-25c0-4c15-b481-74ba0fbc3123")),
      Some(Agent("Agent", Some("agent_instructor"), None, None, None, None)),
      Some(new Group("Group", Some("Team1"),
        Some(Seq(Agent("Agent", Some("agent_team"), None, None, None, None))),
        None, None, None, None)),
      new ContextActivities(Set(), Set(), Set(), Set(), None), None, None, None, None, Seq())),
    Some(future),
    Some(future),
    None,
    None,
    Seq()
  )

  val statement2 = statement.copy(
    id = UUID.fromString("40d10a63-2c37-4071-9595-793af98e89b0"),
    actor = Agent("Agent", Some("agent2"), None, None, None, None),
    verb = Verb("verbId2", Map.empty[String, String]),
    timestamp = Some(past),
    stored = Some(past)
  )

  var statements = List(statement, statement)

  statementLRS.statementStorage.create(statement)

  statementLRS.statementStorage.create(statement2)

  // The 'addStatement' method

  def testCreateAndRead() {
    val uuid = UUID.randomUUID()
    val result = statementLRS.addStatement(statement.copy(id = uuid))
    val stored = statementLRS.getStatement(uuid)
    if (!result.equals(uuid)) throw new Exception()
    if (stored.isEmpty) throw new Exception()
    if (!stored.head.verb.id.toString.equals(URI.create("verbId").toString)) throw new Exception()

    writer.write("add a statement and return 'StatementAdded' if the statement with given id doesn't exist yet: success <br>")
  }

  def testCreateAlreadyExist() {
    try {
      statementLRS.addStatement(statement)
      throw new Exception()
    }
    catch {
      case exception: StatementLRSAlreadyExistsException => {
        writer.write("throw 'StatementLRSAlreadyExistsException' if the given statement equals to the existing one with the same id: success <br>")
      }
    }

    try {
      val uuid = UUID.fromString("40d10a63-2c37-4071-9595-793af98e89b0")
      statementLRS.addStatement(statement.copy(id = uuid))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSAlreadyExistsException => {
        writer.write("throw 'StatementLRSAlreadyExistsException' if the given statement differs from the existing one with the same id: success <br>")
      }
    }
  }

  def testCreateWithNullStatement() {
    try {
      statementLRS.addStatement(null)
      throw new Exception()
    }
    catch {
      case exception: StatementLRSArgumentException => {
        writer.write("throw 'StatementLRSArgumentException' if given statement is null: success <br>")
      }
    }
  }

  // The 'addStatements' method

  def testCreateStatements() {
    reset()
    val s1: Statement = statement1
    val s2: Statement = statement2.copy(id = UUID.randomUUID())
    val result = statementLRS.addStatements(Seq(s1, s2))
    if (result.size != 2) throw new Exception()
    if (statementLRS.getStatement(s1.id).isEmpty) throw new Exception()
    if (statementLRS.getStatement(s2.id).isEmpty) throw new Exception()

    writer.write("add new statements and return generated UUID for every stored statement from given list: success <br>")
  }

  def testCreateNotExistedStatements() {
    reset()
    val s1: Statement = statement.copy(id = UUID.randomUUID())
    val s2: Statement = statement.copy(id = UUID.randomUUID())
    val s3: Statement = statement
    val result = statementLRS.addStatements(Seq(s1, s2, s3))
    if (result.size != 2) throw new Exception()
    val stats = statementLRS.getStatements(StatementFilter(Some(s3.id.toString), None, None, None, None, None, None, None)).statements
    if (stats.size != 1) throw new Exception()
    if (statementLRS.getStatement(s1.id).isEmpty) throw new Exception()
    if (statementLRS.getStatement(s2.id).isEmpty) throw new Exception()

    writer.write("add only those statements which doesn't exist yet: success <br>")
  }

  def testCreateUniqueStatements() {
    reset()
    val s1: Statement = statement.copy(id = UUID.randomUUID())
    val s2: Statement = statement
    val s3: Statement = statement.copy(
      id = UUID.fromString("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
      verb = Verb("1234", Map.empty[String, String])
    )
    val result = statementLRS.addStatements(Seq(s1, s2, s3))
    if (result.size != 1) throw new Exception()
    if (statementLRS.getStatement(s1.id).isEmpty) throw new Exception()

    writer.write("not a statement which id is matched with existing one and the rest is different: success <br>")
  }

  def testCreateWithNullList() {
    try {
      reset()
      statementLRS.addStatements(null)
      throw new Exception()
    }
    catch {
      case exception: StatementLRSArgumentException => {
        writer.write("throw 'StatementLRSArgumentException' if list of given statements is null: success <br>")
      }
    }
  }

  // The 'getStatement' method

  def testGetExistStatement() {
    val result = statementLRS.getStatement(UUID.fromString("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"))
    if (result.isEmpty) throw new Exception()
    if (!result.get.verb.id.toString.equals(URI.create("verbId").toString)) throw new Exception()

    writer.write("return a statement by given id if exists: success <br>")
  }

  def testGetNotExist() {
    val result = statementLRS.getStatement(UUID.randomUUID())
    if (!result.isEmpty) throw new Exception()

    writer.write("return nothing if statement doesn't exist for specified id: success <br>")
  }

  def testGetWithNullId() {
    try {
      statementLRS.getStatement(null)
      throw new Exception()
    }
    catch {
      case exception: StatementLRSArgumentException => {
        writer.write("throw 'StatementLRSArgumentException' if given id is null: success <br>")
      }
    }
  }

  // The 'getStatements' method

  def testGetAll() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, None)).statements
    if (result.size != 8) throw new Exception()

    writer.write("get all statements: success <br>")
  }

  def testGetLimitCount() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, None, None, None, Some(3))).statements
    if (result.size != 3) throw new Exception()

    val result1 = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, None, None, None, Some(1))).statements
    if (result1.size != 1) throw new Exception()

    val result2 = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, None, None, None, Some(0))).statements
    if (result2.size != 8) throw new Exception()

    writer.write("get limit count statements: success <br>")
  }

  def testGetSortByAscending() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, None, None, None, None, None, None, Some(true))).statements
    if (result.size != 8) throw new Exception()
    if (result.head.stored.get != past) throw new Exception()


    val result1 = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, None, None, None, None, None, None, Some(false))).statements
    if (result1.size != 8) throw new Exception()
    if (result.head.stored.get != future) throw new Exception()

    writer.write("get limit with sort by ascending: success <br>")
  }

  def testGetById() {
    val result = statementLRS.getStatements(StatementFilter(Some(statement.id.toString), None, None, None, None, None, None, None)).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()

    writer.write("get only one statement by Id: success <br>")
  }

  def testGetOneByVerbId() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, Some("verbId_test1"), None, None, None, None)).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()

    writer.write("get one statement by verb id: success <br>")
  }

  def testGetSeveralByVerbId() {
    val result1 = statementLRS.getStatements(StatementFilter(None, None, None, Some("verbId2"), None, None, None, None)).statements
    if (result1.size != 2) throw new Exception()

    val result2 = statementLRS.getStatements(StatementFilter(None, None, None, Some("verbId"), None, None, None, None)).statements
    if (result2.size != 5) throw new Exception()

    writer.write("get several statement by verb id: success <br>")
  }

  def testGetByActivity() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, None, Some("activityId"), None, None, None)).statements
    if (result.size != 1) throw new Exception()

    val result1 = statementLRS.getStatements(StatementFilter(None, None, None, None, Some(""), None, None, None)).statements
    if (result1.size != 0) throw new Exception()

    writer.write("get exist and not exist statement by activity id: success <br>")
  }

  def testGetByAgent() {
    var result = statementLRS.getStatements(StatementFilter(None, None, Some(statement1.actor), None, None, None, None, None)).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()

    result = statementLRS.getStatements(StatementFilter(None, None,
      Some(Agent("Agent",None,Some("mailto:test@test.com"),None,None,None)),
      None, None, None, None, None)).statements
      if (result.size != 1) throw new Exception()
      if (!result.head.id.equals(statement1.id)) throw new Exception()

    result = statementLRS.getStatements(StatementFilter(None, None,
      Some(Agent("Agent",None,Some("mailto:test1@test.com"),None,None,None)),
      None, None, None, None, None)).statements
    if (result.size != 0) throw new Exception()


    writer.write("get one statement by agent id: success <br>")
  }

  def testGetBySinceDate() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, Some(new Date), None)).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()
    val result1 = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, Some(startTime), None)).statements
    if (result1.size != 6) throw new Exception()

    writer.write("get statements by date since they were created: success <br>")
  }

  def testGetByUntilDate() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, Some(new Date))).statements
    if (result.size != 7) throw new Exception()

    val result1 = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, Some(startTime))).statements
    if (result1.size != 2) throw new Exception()
    if (!(result1(0).id == statement2.id || result1(1).id == statement2.id)) throw new Exception()

    writer.write("get statements by date until they were created: success <br>")
  }

  def testGetByDateBoundary() {
    //  until: stored at or before the specified timestamp
    val result = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, Some(past))).statements
    if (result.size != 2) throw new Exception()

    // since: since the specified timestamp (exclusive)
    val result1 = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, Some(future), None)).statements
    if (result1.size != 0) throw new Exception()

    writer.write("get statements by boundary dates: success <br>")
  }

  // complex filters

  val statement2obj = statement2.copy(id = UUID.randomUUID(), obj = statement1.obj)

  def testGetByActivityAndAgent() {
    statementLRS.addStatement(statement2obj)

    val result = statementLRS.getStatements(StatementFilter(None, None, Some(statement1.actor), None, Some("activityId"), None, None, None)).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()

    val result1 = statementLRS.getStatements(StatementFilter(None, None, Some(statement.actor), None, Some("activityId"), None, None, None)).statements
    if (result1.size != 0) throw new Exception()

    writer.write("get statements by activity and agent: success <br>")
  }

  def testGetByActivityAndVerb() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, Some("verbId_test1"), Some("activityId"), None, None, None)).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()

    val result1 = statementLRS.getStatements(StatementFilter(None, None, None, Some("verbId"), Some("activityId"), None, None, None)).statements
    if (result1.size != 0) throw new Exception()

    writer.write("get statements by activity and verb: success <br>")
  }

  def testGetByActivityAndSinceDate() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, None, Some("activityId"), None, Some(new Date), None)).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()

    writer.write("get statements by activity and date since they were created: success <br>")
  }

  def testGetByActivityAndUntilDate() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, None, Some("activityId"), None, None, Some(new Date))).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement2obj.id)) throw new Exception()

    writer.write("get statements by activity and date until they were created: success <br>")
  }

  val statement1past = statement1.copy(id = UUID.randomUUID(), verb = Verb("verbId_test2", Map.empty[String, String]), timestamp = Some(past))
  val statement2verb1 = statement2.copy(id = UUID.randomUUID(), verb = Verb("verbId_test1", Map.empty[String, String]), obj = statement1.obj)

  def testGetByAgentAndVerb() {
    statementLRS.addStatement(statement2verb1)
    statementLRS.addStatement(statement1past)

    val result = statementLRS.getStatements(StatementFilter(None, None, Some(statement1.actor), Some("verbId_test1"), None, None, None, None)).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()

    writer.write("get statements by agent and verb: success <br>")
  }

  def testGetByAgentAndSinceDate() {
    val result = statementLRS.getStatements(StatementFilter(None, None, Some(statement1.actor), None, None, None, Some(startTime), None)).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()

    writer.write("get statements by agent and date since they were created: success <br>")
  }

  def testGetByAgentAndUntilDate() {
    val result = statementLRS.getStatements(StatementFilter(None, None, Some(statement1.actor), None, None, None, None, Some(new Date()))).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1past.id)) throw new Exception()

    writer.write("get statements by agent and date until they were created: success <br>")
  }

  def testGetByVerbAndSinceDate() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, Some("verbId_test1"), None, None, Some(new Date()), None)).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()

    writer.write("get statements by verb and date since they were created: success <br>")
  }

  def testGetByVerbAndUntilDate() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, Some("verbId_test1"), None, None, None, Some(new Date()))).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement2verb1.id)) throw new Exception()

    writer.write("get statements by verb and date until they were created: success <br>")
  }

  def testGetBySeveralParameters() {
    val result = statementLRS.getStatements(StatementFilter(None, None, Some(statement1.actor), Some("verbId_test1"), Some("activityId"), None, Some(past), Some(future))).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.equals(statement1.id)) throw new Exception()

    writer.write("get statements by several parameters: success <br>")
  }

  // not allowed filters

  def testGetWithStatementAndVoidedId() {
    try {
      statementLRS.getStatements(StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        Some("fdf01fb5-25c0-4c75-b482-74ba0fbc3584"),
        None, None, None, None, None, None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if both statementId and voidedStatementId are specified: success <br>")
      }
    }
  }

  def testGetWithStatementIdAndAgent() {
    try {
      statementLRS.getStatements(StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        Some(Agent("Agent", None, None, None, None, None)),
        None, None, None, None, None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified statement id and agent: success <br>")
      }
    }
  }

  def testGetWithStatementIdAndVerbId() {
    try {
      statementLRS.getStatements(StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        None,
        Some("verbId1"),
        None, None, None, None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified statement id and verb id: success <br>")
      }
    }
  }

  def testGetWithStatementIdAndActivityId() {
    try {
      statementLRS.getStatements(StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        None, None,
        Some("activityId1"),
        None, None, None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified statement id and activity id: success <br>")
      }
    }
  }

  def testGetWithStatementIdAndRegistrationId() {
    try {
      statementLRS.getStatements(StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        None, None, None,
        Some(UUID.randomUUID()),
        None, None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified statement id and registration id: success <br>")
      }
    }
  }

  def testGetWithStatementIdAndDateSince() {
    try {
      statementLRS.getStatements(StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        None, None, None, None,
        Some(new Date()),
        None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified statement id and date since it is created: success <br>")
      }
    }
  }

  def testGetWithStatementIdAndDateUntil() {
    try {
      statementLRS.getStatements(StatementFilter(
        Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"), None,
        None, None, None, None, None,
        Some(new Date())))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified statement id and date until it is created: success <br>")
      }
    }
  }

  def testGetWithVoidedIdAndAgent() {
    try {
      statementLRS.getStatements(StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        Some(Agent("Agent", None, None, None, None, None)),
        None, None, None, None, None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified voided id and agent: success <br>")
      }
    }
  }

  def testGetWithVoidedIdAndVerbId() {
    try {
      statementLRS.getStatements(StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        None,
        Some("verbId1"),
        None, None, None, None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified voided id and verb id: success <br>")
      }
    }
  }

  def testGetWithVoidedIdAndActivityId() {
    try {
      statementLRS.getStatements(StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        None, None,
        Some("activityId1"),
        None, None, None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified voided id and activity id: success <br>")
      }
    }
  }

  def testGetWithVoidedIdAndRegistrationId() {
    try {
      statementLRS.getStatements(StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        None, None, None,
        Some(UUID.randomUUID()),
        None, None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified voided id and registration id: success <br>")
      }
    }
  }

  def testGetWithVoidedIdAndDateSince() {
    try {
      statementLRS.getStatements(StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        None, None, None, None,
        Some(new Date()),
        None))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified voided id and date since it is created: success <br>")
      }
    }
  }

  def testGetWithVoidedIdAndDateUntil() {
    try {
      statementLRS.getStatements(StatementFilter(
        None, Some("fdf01fb5-25c0-4c15-b481-74ba0fbc3584"),
        None, None, None, None, None,
        Some(new Date())))
      throw new Exception()
    }
    catch {
      case exception: StatementLRSException => {
        writer.write("throw 'StatementLRSException' if specified voided id and date until it is created: success <br>")
      }
    }
  }


  def addStatementWithSubStatement() {
    statementLRS.addStatement(statementWithSubStatement)
  }

  def testGetWithRelativeActivity() {
    var result = statementLRS.getStatements(StatementFilter(
      None, None,
      None, None, Some("activitySubId"), None, None,
      None, Some(false))).statements
    if (result.size != 0) throw new Exception()

    result = statementLRS.getStatements(StatementFilter(
      None, None,
      None, None, Some("activitySubId"), None, None,
      None, Some(true))).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.toString.equalsIgnoreCase(statementWithSubStatement.id.toString))
      throw new Exception()

    writer.write("filter by relative_activity -- success")
  }

  def testGetWithRelativeAgent() {
    var result = statementLRS.getStatements(StatementFilter(
      None, None,
      Some(Agent("Agent", Some("agent_sub"), None, None, None, None)), None, None, None, None,
      None, None, Some(false))).statements
    if (result.size != 0) throw new Exception()

    result = statementLRS.getStatements(StatementFilter(
      None, None,
      Some(Agent("Agent", Some("agent_sub"), None, None, None, None)), None, None, None, None,
      None, None, Some(true))).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.toString.equalsIgnoreCase(statementWithSubStatement.id.toString))
      throw new Exception()

    result = statementLRS.getStatements(StatementFilter(
      None, None,
      Some(Agent("Agent", Some("agent_instructor"), None, None, None, None)), None, None, None, None,
      None, None, Some(true))).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.toString.equalsIgnoreCase(statementWithSubStatement.id.toString))
      throw new Exception()

    result = statementLRS.getStatements(StatementFilter(
      None, None,
      Some(Agent("Agent", Some("agent_team"), None, None, None, None)), None, None, None, None,
      None, None, Some(true))).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.toString.equalsIgnoreCase(statementWithSubStatement.id.toString))
      throw new Exception()

    writer.write("filter by relative_agent -- success")

  }

  def testGetWithRegistration() {
    var result = statementLRS.getStatements(StatementFilter(
      None, None,
      None, None, None, Some(UUID.fromString("fdf01666-25c0-4c15-b481-74ba0fbc3123")))).statements
    if (result.size != 1) throw new Exception()
    if (!result.head.id.toString.equalsIgnoreCase(statementWithSubStatement.id.toString))
      throw new Exception()

    writer.write("filter by registration -- success")

  }

  // renew base
  def testRenewBase() {
    val result = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, None)).statements
    if (result.size == 0) throw new Exception()
    statementLRS.statementStorage.renew()
    val result1 = statementLRS.getStatements(StatementFilter(None, None, None, None, None, None, None, None)).statements
    if (result1.size != 0) throw new Exception()

    writer.write("renew statement base: success <br>")
  }

  private def reset() {
    statements = List(
      statement,
      statement.copy(
        id = UUID.fromString("40d10a63-2c37-4071-9595-793af98e89b0"),
        verb = Verb("verbId2", Map.empty[String, String]))
    )
  }

}
