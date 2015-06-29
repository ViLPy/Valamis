package com.arcusys.valamis.lrs.model

import java.util.{ Date, UUID }

import com.arcusys.valamis.lrs.tincan.Actor

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
  ascending: Option[Boolean] = None,
  offset: Option[Int] = None)
