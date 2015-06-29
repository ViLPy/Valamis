package com.arcusys.valamis.lrs.util

import java.net.URI

import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.model.StatementFilter
import com.arcusys.valamis.lrs.tincan.Statement
import org.joda.time.DateTime

object StatementApiHelpers {
  implicit def apiWithFilter(statementApi: StatementApi) = new {

    def getAll(): Seq[Statement] = {
      getByFilter(new StatementFilter)
    }

    def getByFilter(filter: StatementFilter): Seq[Statement] = {
      statementApi.getByParams(
        agent = filter.agent,
        verb = filter.verb.map(URI.create),
        activity = filter.activity.map(URI.create),
        registration = filter.registration,
        since = filter.since.map(new DateTime(_)),
        until = filter.until.map(new DateTime(_)),
        relatedActivities = filter.relatedActivities.getOrElse(false),
        relatedAgents = filter.relatedAgents.getOrElse(false),
        limit = filter.limit,
        format = filter.format.map(_.toString),
        attachments = filter.attachments.getOrElse(false),
        ascending = filter.ascending.getOrElse(false),
        offset = filter.offset
      ).get.statements
    }
  }
}