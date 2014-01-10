package com.arcusys.learn.tincan.api

import com.arcusys.learn.tincan.lrs.statement.{StatementLRSException, StatementLRSAlreadyExistsException, StatementFilter, StatementLRS}
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.util.UUID
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import org.joda.time.DateTime
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.escalatesoft.subcut.inject.BindingModule

class StatementService(configuration: BindingModule) extends ServletBase(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  val statementLRS = new StatementLRS() {
    val statementStorage = storageFactory.tincanLrsStatementStorage
  }

  after() {
    response.addHeader("X-Experience-API-Version", "1.0.1")
    response.addHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.addHeader("Expires", "-1")
  }

  before() {
    //    if ("1.0.1" != request.getHeader("X-Experience-API-Version"))
    //      println("X-Experience-API-Version is not 1.0.1. - " + request.getHeader("X-Experience-API-Version"))
  }

  put("/") {
    val statement = deserializeStatement(request.body)

    try {
      statementLRS.addStatement(statement.copy(id = UUID.fromString(parameter("statementId").required)))
      halt(204, reason = "No Content")
    }
    catch {
      case exception: StatementLRSAlreadyExistsException => {
        halt(409, reason = "Conflict")
      }
    }
  }

  get("/") {


    val statementFilter = StatementFilter(
      parameter("statementId").option,
      parameter("voidedStatementId").option,
      parameter("agent").option.map(deserializeActor),
      parameter("verb").option,
      parameter("activity").option,
      parameter("registration").option.map(UUID.fromString),
      parameter("since").option.map(new DateTime(_).toDate),
      parameter("until").option.map(new DateTime(_).toDate),
      parameter("relatedActivities").booleanOption(false.toString).getOrElse(false),
      parameter("relatedAgents").booleanOption(false.toString).getOrElse(false),
      parameter("limit").intOption(0).getOrElse(0),
      parameter("format").option.getOrElse("exact"),
      parameter("attachments").booleanOption(false.toString).getOrElse(false),
      parameter("ascending").booleanOption(false.toString).getOrElse(false)
    )

    try {
      halt(200, serializeStatementResult(statementLRS.getStatements(statementFilter)), reason = "OK")
    }
    catch {
      case exception: StatementLRSException => {
        halt(400, exception.message)
      }
    }
  }

  post("/") {
    val statements = deserializeStatements(request.body)
    statementLRS.addStatements(statements)

    halt(200, reason = "OK")
  }
}
