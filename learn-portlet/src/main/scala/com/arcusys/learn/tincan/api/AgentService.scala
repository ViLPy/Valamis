package com.arcusys.learn.tincan.api

import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.lrs.agentprofile.{AgentProfileLRSAlreadyExistsException, AgentProfileLRSNotExistsException, AgentProfileLRSModificationException, AgentProfileLRS}
import com.arcusys.learn.tincan.storage.AgentProfileStorage
import org.joda.time.DateTime
import com.arcusys.learn.tincan.model.{OtherContent, JSONContent, Document}
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.escalatesoft.subcut.inject.BindingModule

// http://example.com/xAPI/agents
class AgentService(configuration: BindingModule) extends ServletBase(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  val agentProfileLrs = new AgentProfileLRS {
    val agentProfileStorage: AgentProfileStorage = storageFactory.tincanLrsAgentProfileStorage
  }

  def isJsonContent = request.getContentType.startsWith( """application/json""")

  after() {
    response.addHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.addHeader("Expires", "-1")
  }

  get("/") {
    val agent = deserializeAgent(parameter("agent").required)
    //TODO: Return a special, Person Object for a specified Agent
    throw new UnsupportedOperationException()
  }

  get("/profile") {
    val agent = deserializeAgent(parameter("agent").required)
    parameter("since").option.map(new DateTime(_).toDate) match {
      case Some(since) => {
        halt(200, serializeIds(agentProfileLrs.getAgentDocumentIds(agent, since)), reason = "OK")
      }
      case None => {
        agentProfileLrs.getAgentDocument(parameter("profileId").required, agent) match {
          case Some(document) => halt(200, new String(document.contents), reason = "OK")
          case None => halt(404)
        }
      }
    }
  }

  post("/profile") {
    val agent = deserializeAgent(parameter("agent").required)
    val profileId = parameter("profileId").required

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)

    try {
      agentProfileLrs.modifyAgentDocument(profileId, agent, document)
    }
    catch {
      case exception: AgentProfileLRSNotExistsException => agentProfileLrs.addAgentDocument(profileId, agent, document)
      case exception: AgentProfileLRSModificationException => {
        exception.printStackTrace()
        halt(400, exception.message, reason = "Bad Request")
      }
    }

    halt(204, reason = "No Content")
  }

  put("/profile") {
    val agent = deserializeAgent(parameter("agent").required)
    val profileId = parameter("profileId").required

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)

    try {
      agentProfileLrs.addAgentDocument(profileId, agent, document)
    }
    catch {
      case exception: AgentProfileLRSAlreadyExistsException => {
        agentProfileLrs.deleteAgentDocument(profileId, agent)
        agentProfileLrs.addAgentDocument(profileId, agent, document)
      }
    }

    halt(204, reason = "No Content")
  }

  delete("/profile") {
    val agent = deserializeAgent(parameter("agent").required)
    val profileId = parameter("profileId").required

    agentProfileLrs.deleteAgentDocument(profileId, agent)
  }
}

