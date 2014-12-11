package com.arcusys.learn.models.request.tincan

import com.arcusys.learn.models.request.BaseRequest
import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase

/**
 * Created by ematyukhin on 08/10/14.
 */
object StatementRequest {
  val STATEMENTID = "statementId"
  val VOIDEDSTATEMENTID = "voidedStatementId"
  val AGENT = "agent"
  val VERB = "verb"
  val ACTIVITY = "activity"
  val REGISTRATION = "registration"
  val SINCE = "since"
  val UNTIL = "until"
  val RELATED_ACTIVITIES = "related_activities"
  val RELATED_AGENTS = "related_agents"
  val LIMIT = "limit"
  val ATTACHMENTS = "attachments"
  val ASCENDING = "ascending"
  val FORMAT = "format"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseRequest {
    implicit val httpRequest = scalatra.request
    implicit val _scalatra = scalatra

    def statementIdRequired = Parameter(STATEMENTID).required
    def statementId = Parameter(STATEMENTID).option
    def voidedStatementId = Parameter(VOIDEDSTATEMENTID).option
    def agent = Parameter(AGENT).option
    def verb = Parameter(VERB).option
    def activity = Parameter(ACTIVITY).option
    def registration = Parameter(REGISTRATION).option
    def since = Parameter(SINCE).dateOption("")
    def until = Parameter(UNTIL).dateOption("")
    def related_activities = Parameter(RELATED_ACTIVITIES).booleanOption("")
    def related_agents = Parameter(RELATED_AGENTS).booleanOption("")
    def limit = Parameter(LIMIT).intOption(-1)
    def attachments = Parameter(ATTACHMENTS).booleanOption("")
    def ascending = Parameter(ASCENDING).booleanOption("")
    def format = Parameter(FORMAT).option

  }
}
