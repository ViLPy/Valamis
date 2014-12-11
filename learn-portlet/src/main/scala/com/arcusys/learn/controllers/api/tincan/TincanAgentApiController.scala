package com.arcusys.learn.controllers.api.tincan

import javax.servlet.http.HttpServletResponse

import com.arcusys.learn.bl.exceptions.EntityNotFoundException
import com.arcusys.learn.controllers.oauth.BaseLrsClientApiApiController
import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.bl.services.tincan.AgentServiceContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.tincan.AgentRequest
import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.arcusys.learn.tincan.lrs.agentprofile.{ AgentProfileLRSModificationException, AgentProfileLRSNotExistsException }
import com.arcusys.learn.tincan.model.{ OtherContent, JSONContent, Document }
import com.escalatesoft.subcut.inject.BindingModule
import org.joda.time.DateTime

// http://example.com/xAPI/agents
class TincanAgentApiController(configuration: BindingModule) extends BaseLrsClientApiApiController(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  private lazy val agentFacade = inject[AgentServiceContract]

  private def isJsonContent = request.getContentType.startsWith("""application/json""")

  private def getAgent = try {
    deserializeAgent(Parameter(AgentRequest.AGENT).required)
  } catch {
    case exception: JSONDeserializerException => {
      halt(HttpServletResponse.SC_BAD_REQUEST, "Required parameter 'agent' has not valid JSON data")
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

  get("/agents(/)")(action {
    val agent = getAgent
    try {
      OkJson(serializePerson(agentFacade.getPerson(agent)))
    } catch {
      case e: JSONSerializerException => throw new EntityNotFoundException(e.message)
      case exception: Exception       => throw new BadRequestException(exception.getMessage)

    }
  })

  get("/agents/profile(/)")(action {
    val agent = getAgent

    try {
      if (Parameter(AgentRequest.PROFILEID).contains) {
        agentFacade.getProfile(agent, Parameter(AgentRequest.PROFILEID).required) match {
          case Some(document) => Ok(new String(document.contents))
          case None           => throw new EntityNotFoundException("Agent profile is not found")
        }
      } else {
        OkJson(serializeIds(agentFacade.getProfiles(agent, Parameter(AgentRequest.SINCE).option.map(new DateTime(_)))))

      }
    } catch {
      case e: JSONSerializerException => throw new EntityNotFoundException(e.message)
    }
  })

  post("/agents/profile(/)")(action {
    val agent = getAgent
    val profileId = Parameter(AgentRequest.PROFILEID).required
    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)
    try {
      agentFacade.saveProfile(agent, profileId, document)
    } catch {
      case exception: AgentProfileLRSModificationException => {
        exception.printStackTrace()
        throw new BadRequestException(exception.message)
      }
    }
    NoContent
  })

  put("/agents/profile(/)")(action {
    val agent = getAgent
    val profileId = Parameter(AgentRequest.PROFILEID).required
    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)
    agentFacade.updateProfile(agent, profileId, document)
    NoContent
  })

  delete("/agents/profile(/)")(action {
    val agent = getAgent
    val profileId = Parameter(AgentRequest.PROFILEID).required

    agentFacade.deleteProfile(agent, profileId)
    NoContent
  })
}

