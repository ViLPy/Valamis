package com.arcusys.learn.tincan.lrs

package statement {

  import java.util.{ Date, UUID }

  import com.arcusys.learn.tincan.model.{ Actor, Statement, StatementResult }
  import com.arcusys.learn.tincan.storage.StatementStorage

  trait StatementLRS {
    private val defaultFilter = StatementFilter(None, None, None, None, None, None, None, None)

    val statementStorage: StatementStorage

    def addStatement(entity: Statement): UUID = {
      require(entity != null, "Incorrect arguments were passed in the 'StatementLRS.addStatement' method")

      val stored = statementStorage.getByUUID(entity.id)
      stored match {
        case None =>
          saveToStorage(entity)
        case Some(s) =>
          throw StatementLRSAlreadyExistsException("Given statement already exists")
      }
    }

    def addStatements(list: Seq[Statement]): Seq[UUID] = {
      require(list != null, "Incorrect arguments were passed in the 'StatementLRS.addStatements' method")
      if (list.size == 1)
        Seq(addStatement(list.head))
      else
        for (s <- list if !isStored(s.id)) yield saveToStorage(s)
    }

    private def saveToStorage(entity: Statement): UUID = {
      require(entity.actor.objectType != null)
      require(entity.actor.getMbox.isDefined || entity.actor.getMbox_sha1sum.isDefined || entity.actor.getOpenid.isDefined || entity.actor.getAccount.isDefined)

      statementStorage.create(entity.copy(
        id = (if (entity.id != null) entity.id else UUID.randomUUID()), //UUID assigned by LRS if not set by the Activity Provider.
        stored = Some(new Date()), // The time at which a Statement is stored by the LRS.
        timestamp = if (entity.timestamp.isDefined) entity.timestamp else Some(new Date()) //If not provided, LRS should set this to the value of "stored" time.
      ))
      //TODO Add Authority - Agent who is asserting this Statement is true. Verified by the LRS based on authentication, and set by LRS if left blank.
    }

    def getStatement(id: UUID): Option[Statement] = {
      require(id != null, "Incorrect arguments were passed in the 'StatementLRS.getStatement' method")
      statementStorage.getByUUID(id)
    }

    // TODO: implement the relative IRL that may be used to fetch more results
    def getStatements(filter: StatementFilter = defaultFilter): StatementResult = filter match {
      case StatementFilter(Some(_), Some(_), _, _, _, _, _, _, _, _, _, _, _, _) =>
        throw StatementLRSException("Both statement id and voided statement id were passed!")

      case f @ StatementFilter(Some(_), None, _, _, _, _, _, _, _, _, _, _, _, _) if f.agent.isDefined || f.verb.isDefined || f.activity.isDefined ||
        f.registration.isDefined || f.since.isDefined || f.until.isDefined ||
        f.relatedActivities.isDefined || f.relatedAgents.isDefined || f.limit.isDefined ||
        f.ascending.isDefined =>
        throw StatementLRSException("Incompatible parameters were specified with statement id")

      case f @ StatementFilter(None, Some(_), _, _, _, _, _, _, _, _, _, _, _, _) if f.agent.isDefined || f.verb.isDefined || f.activity.isDefined ||
        f.registration.isDefined || f.since.isDefined || f.until.isDefined ||
        f.relatedActivities.isDefined || f.relatedAgents.isDefined || f.limit.isDefined ||
        f.ascending.isDefined =>
        throw StatementLRSException("Incompatible parameters were specified with voided statement id")

      case f: StatementFilter =>
        val parameters = extractParameters(f)
        StatementResult(statementStorage.get(parameters: _*), "")
    }

    private def extractParameters(filter: StatementFilter): Seq[(String, Any)] = {

      val defaults = Map(
        "related_activities" -> filter.relatedActivities.getOrElse(false),
        "related_agents" -> filter.relatedAgents.getOrElse(false),
        "limit" -> filter.limit.getOrElse(0),
        "format" -> filter.format.getOrElse(FormatType.exact),
        "attachments" -> filter.attachments.getOrElse(false),
        "ascending" -> filter.ascending.getOrElse(false))
      var parameters = defaults

      if (filter.statementId.isDefined)
        parameters += ("statementId" -> filter.statementId.get)
      if (filter.voidedStatementId.isDefined)
        parameters += "voidedStatementId" -> filter.voidedStatementId.get
      if (filter.agent.isDefined)
        parameters += "agent" -> filter.agent.get
      if (filter.verb.isDefined)
        parameters += "verb" -> filter.verb.get
      if (filter.activity.isDefined)
        parameters += "activity" -> filter.activity.get
      if (filter.registration.isDefined)
        parameters += "registration" -> filter.registration.get
      if (filter.since.isDefined)
        parameters += "since" -> filter.since.get
      if (filter.until.isDefined)
        parameters += "until" -> filter.until.get

      parameters.toSeq
    }

    private def require(predicate: Boolean, message: String = "") = {
      if (!predicate) throw StatementLRSArgumentException(message)
    }

    private def isStored(statementId: UUID) = statementStorage.getByUUID(statementId).isDefined
  }

  object FormatType extends Enumeration {
    val exact = Value("exact")
    val ids = Value("ids")
    val canonical = Value("canonical")
  }

  case class StatementFilter(
    statementId: Option[String] = None,
    voidedStatementId: Option[String] = None,
    agent: Option[Actor] = None,
    verb: Option[String] = None,
    activity: Option[String] = None,
    registration: Option[UUID] = None,
    since: Option[Date] = None,
    until: Option[Date] = None,
    relatedActivities: Option[Boolean] = None,
    relatedAgents: Option[Boolean] = None,
    limit: Option[Int] = None,
    format: Option[FormatType.Value] = None, // one of ["ids", "exact", or "canonical"]
    attachments: Option[Boolean] = None,
    ascending: Option[Boolean] = None)

  case class StatementLRSArgumentException(message: String) extends Exception(message)
  case class StatementLRSException(message: String) extends Exception(message)
  case class StatementLRSAlreadyExistsException(message: String) extends Exception(message)
}
