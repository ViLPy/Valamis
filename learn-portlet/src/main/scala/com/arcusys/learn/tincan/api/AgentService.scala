package com.arcusys.learn.tincan.api

import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.lrs.agentprofile.{AgentProfileLRSAlreadyExistsException, AgentProfileLRSNotExistsException, AgentProfileLRSModificationException, AgentProfileLRS}
import com.arcusys.learn.tincan.storage.{ActorStorage, AgentProfileStorage}
import org.joda.time.DateTime
import com.arcusys.learn.tincan.model.{OtherContent, JSONContent, Document}
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.oauth.BaseLrsClientApiController

// http://example.com/xAPI/agents
class AgentService(configuration: BindingModule) extends BaseLrsClientApiController(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  val agentProfileLrs = new AgentProfileLRS {
    val agentProfileStorage: AgentProfileStorage = storageFactory.tincanLrsAgentProfileStorage
    val actorStorage: ActorStorage = storageFactory.tincanLrsActorStorage

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
    response.addHeader("Access-Control-Allow-Origin", "*")
    response.addHeader("Expires", "-1")
  }

  options() {
    response.setHeader("Access-Control-Allow-Methods", "HEAD,GET,POST,PUT,DELETE")
    response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length,Authorization,If-Match,If-None-Match,X-Experience-API-Version,X-Experience-API-Consistent-Through")
    response.setHeader("Access-Control-Expose-Headers", "ETag,Last-Modified,Cache-Control,Content-Type,Content-Length,WWW-Authenticate,X-Experience-API-Version,X-Experience-API-Consistent-Through")
  }

  get("/") {
    val agent = getAgent
    try {
      halt(200, serializePerson(agentProfileLrs.getPerson(agent)), reason = "OK")
    }
    catch {
      case e: JSONSerializerException => halt(404, e.message, reason = "Not Found")
      case exception: Exception => halt(400, exception.getMessage)

    }
  }

  get("/profile") {
    val agent = getAgent

    try {
      if (parameter("profileId").contains()) {
        agentProfileLrs.getAgentDocument(parameter("profileId").required, agent) match {
          case Some(document) => halt(200, new String(document.contents), reason = "OK")
          case None => halt(404)
        }
      }
      else {
        halt(200,
          serializeIds(agentProfileLrs.getAgentDocumentIds(agent, parameter("since").option.map(new DateTime(_).toDate))),
          reason = "OK")

      }
    }
    catch {
      case e: JSONSerializerException => halt(404, e.message, reason = "Not Found")
      case exception: Exception => halt(400, exception.getMessage)

    }
  }

  post("/profile") {
    val agent = getAgent
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

    val agent = getAgent
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
    val agent = getAgent
    val profileId = parameter("profileId").required

    agentProfileLrs.deleteAgentDocument(profileId, agent)
    halt(204, reason = "No Content")
  }
}

