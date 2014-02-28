package com.arcusys.learn.tincan.api

import com.arcusys.learn.tincan.lrs.state.{StateLRSNotExistsException, StateLRS, StateLRSDocumentAlreadyExistsException}
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import java.util.UUID
import org.joda.time.DateTime
import com.arcusys.learn.tincan.model.{OtherContent, JSONContent, Document, State}
import scala.Predef._
import scala.Some
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.oauth.BaseLrsClientApiController

class StateService(configuration: BindingModule) extends BaseLrsClientApiController(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  val stateLRS = new StateLRS() {
    val stateStorage = storageFactory.tincanLrsStateStorage
  }

  def isJsonContent = request.getContentType.startsWith( """application/json""")

  def getAgent = try {
    deserializeAgent(parameter("agent").required)
  }
  catch {
    case exception: JSONDeserializerException => {
      halt(400, "Required parameter 'agent' has not valid JSON data")
    }
  }

  after() {
    response.addHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.addHeader("Expires", "-1")
    response.addHeader("Access-Control-Allow-Origin", "*")
  }

  options() {
    response.setHeader("Access-Control-Allow-Methods", "HEAD,GET,POST,PUT,DELETE")
    response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length,Authorization,If-Match,If-None-Match,X-Experience-API-Version,X-Experience-API-Consistent-Through")
    response.setHeader("Access-Control-Expose-Headers", "ETag,Last-Modified,Cache-Control,Content-Type,Content-Length,WWW-Authenticate,X-Experience-API-Version,X-Experience-API-Consistent-Through")
  }

  post("/") {
    val activityId = parameter("activityId").required
    val agent = getAgent
    val stateId = parameter("stateId").required
    val registration = try {
      parameter("registration").option.map(UUID.fromString)
    }
    catch {
      case exception: Exception => halt(400, exception.getMessage)
    }

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)

    try {
      stateLRS.modifyStateDocument(State(activityId, stateId, agent, registration, document))
      halt(204, reason = "No Content")
    }
    catch {
      case exception: StateLRSNotExistsException => {
        stateLRS.addStateDocument(State(activityId, stateId, agent, registration, document))
        halt(204, reason = "No Content")
      }
      case exception: Exception => {
        exception.printStackTrace()
        halt(400, reason = "Bad Request")
      }
    }
  }

  put("/") {
    val activityId = parameter("activityId").required
    val agent = getAgent
    val stateId = parameter("stateId").required
    val registration = try {
      parameter("registration").option.map(UUID.fromString)
    }
    catch {
      case exception: Exception => halt(400, exception.getMessage)
    }

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)

    val state = State(activityId, stateId, agent, registration, document)
    try {
      stateLRS.addStateDocument(state)
    }
    catch {
      case exception: StateLRSDocumentAlreadyExistsException => {
        stateLRS.deleteStateDocument(activityId, stateId, agent, registration)
        stateLRS.addStateDocument(state)
      }
    }

    halt(204, reason = "No Content")
  }

  delete("/") {
    val activityId = parameter("activityId").required
    val agent = getAgent
    val registration = try {
      parameter("registration").option.map(UUID.fromString)
    }
    catch {
      case exception: Exception => halt(400, exception.getMessage)
    }

    try {
      parameter("stateId").option match {
        case Some(stateId) => stateLRS.deleteStateDocument(activityId, stateId, agent, registration)
        case None => stateLRS.deleteStateDocuments(activityId, agent, registration)
      }
    }
    catch {
      case exception: Exception => halt(400, exception.getMessage)
    }

    halt(204, reason = "No Content")
  }

  get("/") {
    val activityId = parameter("activityId").required
    val agent = getAgent

    val registration = try {
      parameter("registration").option.map(UUID.fromString)
    }
    catch {
      case exception: Exception => halt(400, exception.getMessage)
    }


    try {
      if (parameter("stateId").contains()) {
        stateLRS.getStateDocument(activityId, parameter("stateId").required, agent, registration) match {
          case Some(state) => {
            halt(200, new String(state.contents), reason = "OK")
          }
          case _ => halt(204, reason = "No Content")
        }
      }
      else {
        val since = parameter("since").option.map(new DateTime(_).toDate)
        halt(200
          , serializeIds(stateLRS.getStateDocumentIds(activityId, agent, registration, since))
          , reason = "OK")
      }
    }
    catch {
      case e: JSONSerializerException => halt(404, e.message, reason = "Not Found")
      case exception: Exception => halt(400, exception.getMessage)

    }
  }
}