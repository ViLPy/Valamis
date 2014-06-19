package com.arcusys.learn.tincan.api

import com.arcusys.learn.tincan.lrs.statement._
import com.arcusys.learn.ioc.Configuration
import java.util.UUID
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import org.joda.time.DateTime
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.escalatesoft.subcut.inject.BindingModule
import org.joda.time.format.ISODateTimeFormat
import com.arcusys.learn.tincan.lrs.statement.StatementFilter
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer.JSONDeserializerException
import com.arcusys.learn.tincan.lrs.statement.StatementLRSException
import com.arcusys.learn.tincan.lrs.statement.StatementLRSAlreadyExistsException
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer.JSONSerializerException
import com.arcusys.learn.tincan.api.serializer.SerializeFormat
import com.arcusys.learn.controllers.oauth.BaseLrsClientApiApiController

class StatementService(configuration: BindingModule) extends BaseLrsClientApiApiController(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  val statementLRS = new StatementLRS() {
    val statementStorage = storageFactory.tincanLrsStatementStorage
  }

  after() {
    response.addHeader("X-Experience-API-Consistent-Through", new DateTime().toString(ISODateTimeFormat.dateTime()))
    response.addHeader("X-Experience-API-Version", "1.0.1")
    response.addHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.addHeader("Expires", "-1")
    response.addHeader("Access-Control-Allow-Origin", "*")
  }

  options() {
    response.setHeader("Access-Control-Allow-Methods", "HEAD,GET,POST,PUT,DELETE")
    response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length,Authorization,If-Match,If-None-Match,X-Experience-API-Version,X-Experience-API-Consistent-Through")
    response.setHeader("Access-Control-Expose-Headers", "ETag,Last-Modified,Cache-Control,Content-Type,Content-Length,WWW-Authenticate,X-Experience-API-Version,X-Experience-API-Consistent-Through")
  }

  // before() {
  //    if ("1.0.1" != request.getHeader("X-Experience-API-Version"))
  //      println("X-Experience-API-Version is not 1.0.1. - " + request.getHeader("X-Experience-API-Version"))
  //}

  // gets statement object from body in JSON and adds it in storage with id
  def setStatement(id: Option[String], idReturn: Boolean) = {
    try {
      val statement = deserializeStatement(request.body)
      val statementCopy = if (id.isDefined)
        statement.copy(id = try { UUID.fromString(id.get) }
        catch { case _ => halt(400, "Invalid statementId, it must be UUID") })
      else statement
      val uuid = statementLRS.addStatement(statementCopy)
      if (idReturn)
        halt(200, serializeIds(Seq(uuid.toString)), reason = "OK")
      else
        halt(204, reason = "No Content")
    } catch {
      case e: JSONDeserializerException => halt(400, e.message, reason = "Bad Request")
      case e: JSONSerializerException   => halt(400, e.message, reason = "Bad Request")
      case exception: StatementLRSAlreadyExistsException => {
        halt(409, reason = "Conflict")
      }
      case exception: Exception => {
        exception.printStackTrace()
        halt(400, exception.getMessage)
      }
    }
  }

  put("/") {
    //TODO implement scope permissions. use app.scope
    setStatement(Some(parameter("statementId").required), false)
  }

  get("/") {

    val statementFilter = StatementFilter(
      parameter("statementId").option,
      parameter("voidedStatementId").option,
      try {
        parameter("agent").option.map(deserializeActor)
      } catch {
        case e: JSONDeserializerException => halt(400, "Object with name 'actor' could not be created from the provided JSON.")
      },
      parameter("verb").option,
      parameter("activity").option,
      try {
        parameter("registration").option.map(UUID.fromString)
      } catch {
        case _ => halt(400, "Invalid 'registration' parameter, it must be UUID")
      },
      parameter("since").dateOption(""),
      parameter("until").dateOption(""),
      parameter("related_activities").booleanOption(""),
      parameter("related_agents").booleanOption(""),
      parameter("limit").intOption(-1),
      parameter("format").option.map(s => try {
        FormatType.withName(s)
      } catch {
        case e: Exception => halt(400, "Parameter 'format' is not valid. Valid formats are: ids, exact, canonical")
      }),
      parameter("attachments").booleanOption(""),
      parameter("ascending").booleanOption("")
    )

    if (statementFilter.limit.isDefined && statementFilter.limit.get < 0)
      halt(400, "Parameter 'limit' must have nonnegative integer value")

    try {
      //if(statementFilter.attachments)
      // TODO return multipart content with attachments

      val result = statementLRS.getStatements(statementFilter)
      if (statementFilter.statementId.isDefined || statementFilter.voidedStatementId.isDefined) {
        if (result.statements.headOption.isDefined) {
          val rawStatement =
            if (statementFilter.format.isDefined) {
              val lang = request.getHeader("Accept-Language")
              serializeStatement(result.statements.head, SerializeFormat(statementFilter.format.get.toString, lang))
            } else
              serializeStatement(result.statements.head)

          halt(200, rawStatement, reason = "OK")
        } else {
          if (statementFilter.statementId.isDefined)
            halt(404, "Statement with id = '" + statementFilter.statementId.get.toString
              + "' is not found", reason = "Not Found")
          else if (statementFilter.voidedStatementId.isDefined)
            halt(404, "Voided statement with id = '" + statementFilter.voidedStatementId.get.toString
              + "' is not found", reason = "Not Found")
        }
      } else {
        val rawStatement =
          if (statementFilter.format.isDefined) {
            val lang = request.getHeader("Accept-Language")
            serializeStatementResult(result, SerializeFormat(statementFilter.format.get.toString, lang))
          } else
            serializeStatementResult(result)

        halt(200, rawStatement, reason = "OK")

      }
    } catch {
      case e: JSONSerializerException => halt(404, "", reason = "Cannot serialize statement object")
      case exception: StatementLRSException => {
        halt(400, exception.message)
      }

      case exception: Exception => {
        exception.printStackTrace()
        halt(400, exception.getMessage)
      }

    }
  }

  post("/") {
    // Content-Type: multipart/mixed => POST statements with attachment
    //    if(request != null && request.getContentType.contains("multipart/mixed"))
    //    {
    //      val boundaryRegex = new scala.util.matching.Regex("""\S*;\s?boundary=(.*);?""", "boundary")
    //      def getBoundary(text: String): Option[String] = for (m <- boundaryRegex findFirstMatchIn text) yield m group "boundary"
    //
    //      val boundary = getBoundary(request.getContentType)
    //      if(!boundary.isDefined)
    //        halt(400,"No boundary in Content-Type", reason = "Bad Request")
    //      val contents = request.body.split("--"+boundary.get)
    //
    //      halt(200)
    //    }

    // standart POST application/json
    try {
      // TODO add support multipart content with attachments
      val statements = deserializeStatements(request.body)
      halt(200, serializeIds(statementLRS.addStatements(statements).map(id => id.toString)), reason = "OK")
    } catch {
      case e: JSONDeserializerException => {
        // if deserialization of list failed, try to add single statement
        setStatement(None, true)
      }
      case _: JSONSerializerException => halt(400, "Service cannot serialize response list of statements uuids", reason = "Bad Request")
      case exception: StatementLRSAlreadyExistsException => {
        halt(409, reason = "Conflict")
      }
      case exception: Exception => {
        exception.printStackTrace()
        halt(400, exception.getMessage)
      }
    }

  }
}
