package com.arcusys.learn.bl.services.tincan

import java.util.{ Date, UUID }

import com.arcusys.learn.tincan.lrs.statement.FormatType
import com.arcusys.learn.tincan.model.{ Actor, Statement, StatementResult }

trait StatementServiceContract {
  def saveStatement(statement: Statement, id: Option[UUID], companyID: Long): UUID

  def getStatements(statementId: Option[String],
    voidedStatementId: Option[String],
    agent: Option[Actor],
    verb: Option[String],
    activity: Option[String],
    registration: Option[UUID],
    since: Option[Date],
    until: Option[Date],
    related_activities: Option[Boolean],
    related_agents: Option[Boolean],
    limit: Option[Int],
    format: Option[FormatType.Value],
    attachments: Option[Boolean],
    ascending: Option[Boolean]): StatementResult

  def saveStatements(statements: Seq[Statement]): Seq[UUID]

  def saveAttachment(hashOfContent: String, content: Array[Byte]): Unit

  def getAttachment(hashOfContent: String): Option[String]
}
