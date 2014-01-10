package com.arcusys.learn.tincan.lrs

package statement {

  import java.util.{Date, UUID}

  import com.arcusys.learn.tincan.storage.StatementStorage
  import com.arcusys.learn.tincan.model.{StatementResult, Actor, Statement}

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
      for (s <- list if !isStored(s.id)) yield saveToStorage(s)
    }

    private def saveToStorage(entity: Statement) : UUID = {
      // The time at which a Statement is stored by the LRS.
      statementStorage.create(entity.copy(stored = Some(new Date())))
    }

    def getStatement(id : UUID): Option[Statement] = {
      require(id != null, "Incorrect arguments were passed in the 'StatementLRS.getStatement' method")
      statementStorage.getByUUID(id)
    }

    // TODO: implement the relative IRL that may be used to fetch more results
    def getStatements(filter: StatementFilter = defaultFilter): StatementResult = filter match {
      case StatementFilter(Some(_), Some(_), _, _, _, _, _, _, _, _, _, _, _, _)  =>
        throw StatementLRSException("Both statement id and voided statement id were passed!")

      case f @ StatementFilter(Some(_), None, _, _, _, _, _, _, _, _, _, _, _, _)
        if f.agent.isDefined || f.verb.isDefined || f.activity.isDefined ||
          f.registration.isDefined || f.since.isDefined || f.until.isDefined =>
        throw StatementLRSException("Incompatible parameters were specified with statement id")

      case f @ StatementFilter(None, Some(_), _, _, _, _, _, _, _, _, _, _, _, _)
        if f.agent.isDefined || f.verb.isDefined || f.activity.isDefined ||
          f.registration.isDefined || f.since.isDefined || f.until.isDefined =>
        throw StatementLRSException("Incompatible parameters were specified with voided statement id")

      case f: StatementFilter =>
        val parameters = extractParameters(f)
        StatementResult(statementStorage.get(parameters: _*), "")
    }

    private def extractParameters(filter: StatementFilter): Seq[(String, Any)] = {
      val defaults = Map(
        "related_activities" -> filter.relatedActivities,
        "related_agents" -> filter.relatedAgents,
        "limit" -> filter.limit,
        "format" -> filter.format,
        "attachments" -> filter.attachments,
        "ascending" -> filter.ascending)
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

  case class StatementFilter(
    statementId: Option[String],
    voidedStatementId: Option[String],
    agent: Option[Actor],
    verb: Option[String],
    activity: Option[String],
    registration: Option[UUID],
    since: Option[Date],
    until: Option[Date],
    relatedActivities: Boolean = false,
    relatedAgents: Boolean = false,
    limit: Int = 0,
    format: String = "exact", // one of ["ids", "exact", or "canonical"]
    attachments: Boolean = false,
    ascending: Boolean = false)

  case class StatementLRSArgumentException(message: String) extends Exception(message)
  case class StatementLRSException(message: String) extends Exception(message)
  case class StatementLRSAlreadyExistsException(message: String) extends Exception(message)
}
