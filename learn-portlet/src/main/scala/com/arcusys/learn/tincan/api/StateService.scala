package com.arcusys.learn.tincan.api

import com.arcusys.learn.tincan.lrs.state.StateLRS
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import java.util.UUID
import org.joda.time.DateTime
import com.arcusys.learn.tincan.model.{OtherContent, JSONContent, Document, State}
import scala.Predef._
import com.arcusys.learn.tincan.lrs.ActivityProfileLRSNotExistsException
import com.arcusys.learn.tincan.lrs.state.StateLRSDocumentAlreadyExistsException
import scala.Some
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.escalatesoft.subcut.inject.BindingModule

class StateService(configuration: BindingModule) extends ServletBase(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  val stateLRS = new StateLRS() {
    val stateStorage = storageFactory.tincanLrsStateStorage
  }

  def isJsonContent = request.getContentType.startsWith("""application/json""")

  after() {
    response.addHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.addHeader("Expires", "-1")
  }

  post("/") {
    val activityId = parameter("activityId").required
    val agent = deserializeAgent(parameter("agent").required)
    val stateId = parameter("stateId").required
    val registration = parameter("registration").option.map(UUID.fromString)

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)

    try {
      stateLRS.modifyStateDocument(State(activityId, stateId, agent, registration, document))
      halt(204, reason = "No Content")
    }
    catch {
      case exception: ActivityProfileLRSNotExistsException => {
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
    val agent = deserializeAgent(parameter("agent").required)
    val stateId = parameter("stateId").required
    val registration = parameter("registration").option.map(UUID.fromString)

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
    val agent = deserializeAgent(parameter("agent").required)
    val registration = parameter("registration").option.map(UUID.fromString)

    parameter("stateId").option match {
      case Some(stateId) => stateLRS.deleteStateDocument(activityId, stateId, agent, registration)
      case None => stateLRS.deleteStateDocuments(activityId, agent, registration)
    }

    halt(204, reason = "No Content")
  }

  get("/") {
    val activityId = parameter("activityId").required
    val agent = deserializeAgent(parameter("agent").required)
    val registration = parameter("registration").option.map(UUID.fromString)

    parameter("since").option.map(new DateTime(_).toDate) match {
      case Some(since) => halt(200, serializeIds(stateLRS.getStateDocumentIds(activityId, agent, registration, since)), reason = "OK")
      case None => {
        stateLRS.getStateDocument(activityId, parameter("stateId").required, agent, registration) match {
          case Some(state) => {
            halt(200, new String(state.contents), reason = "OK")
          }
          case _ => halt(204, reason = "No Content")
        }
      }
    }
  }
}