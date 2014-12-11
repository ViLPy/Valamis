package com.arcusys.learn.controllers.api.tincan

import java.util.UUID
import javax.servlet.http.HttpServletResponse

import com.arcusys.learn.bl.exceptions.EntityNotFoundException
import com.arcusys.learn.controllers.oauth.BaseLrsClientApiApiController
import com.arcusys.learn.exceptions.{ BadRequestException }
import com.arcusys.learn.bl.services.tincan.{ ActivityProfileServiceContract, StateServiceContract }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.TincanActivityResponse
import com.arcusys.learn.models.request.tincan.ActivityRequest
import com.arcusys.learn.service.util.Parameter
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.arcusys.learn.tincan.lrs.{ ActivityProfileLRSArgumentException, ActivityProfileLRSContentModificationException, ActivityProfileLRSNotExistsException }
import com.arcusys.learn.tincan.model.{ Document, JSONContent, OtherContent }
import com.escalatesoft.subcut.inject.BindingModule
import org.joda.time.DateTime

class TincanActivityApiController(configuration: BindingModule) extends BaseLrsClientApiApiController(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  private lazy val stateFacade = inject[StateServiceContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }
  private lazy val activityFacade = inject[ActivityProfileServiceContract]

  private def getAgent = try {
    deserializeAgent(Parameter(ActivityRequest.AGENT).required)
  } catch {
    case exception: JSONDeserializerException => {
      halt(HttpServletResponse.SC_BAD_REQUEST, "Required parameter 'agent' has not valid JSON data. " + exception.getMessage)
    }
  }

  private def isJsonContent = request.getContentType.startsWith("""application/json""")

  private def getRegistrationUUID: Option[UUID] = {
    try {
      Parameter(ActivityRequest.REGISTRATION).option.map(UUID.fromString)
    } catch {
      case exception: Exception => throw new BadRequestException(exception.getMessage)
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

  // STATE API

  get("/activities/state(/)")(action {
    val activityId = Parameter(ActivityRequest.ACTIVITYID).required
    val agent = getAgent

    val registration = getRegistrationUUID

    try {
      if (Parameter("stateId").contains) {
        stateFacade.getProfile(agent, activityId, Parameter(ActivityRequest.STATEID).required, registration) match {
          case Some(state) => Ok(new String(state.contents))
          case _           => throw new EntityNotFoundException(s"State profile is not found")
        }
      } else {
        val since = Parameter(ActivityRequest.SINCE).option.map(new DateTime(_))
        OkJson(serializeIds(stateFacade.getProfiles(agent, activityId, registration, since)))
      }
    } catch {
      case e: JSONSerializerException => throw new EntityNotFoundException(e.message)

    }
  })

  post("/activities/state(/)")(action {
    val activityId = Parameter(ActivityRequest.ACTIVITYID).required
    val agent = getAgent
    val stateId = Parameter(ActivityRequest.STATEID).required
    val registration = getRegistrationUUID

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)
    try {
      stateFacade.updateProfile(agent, activityId, stateId, registration, document)
    } catch {
      case exception: Exception =>
        exception.printStackTrace()
        throw new BadRequestException
    }
    NoContent
  })

  put("/activities/state(/)")(action {
    val activityId = Parameter(ActivityRequest.ACTIVITYID).required
    val agent = getAgent
    val stateId = Parameter(ActivityRequest.STATEID).required
    val registration = getRegistrationUUID

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)
    stateFacade.saveProfile(agent, activityId, stateId, registration, document)

    NoContent
  })

  delete("/activities/state(/)")(action {
    val activityId = Parameter(ActivityRequest.ACTIVITYID).required
    val agent = getAgent
    val stateId = Parameter(ActivityRequest.STATEID).option
    val registration = getRegistrationUUID

    stateFacade.deleteProfile(agent, activityId, stateId, registration)

    NoContent
  })

  // STATE API --- end

  get("/activities(/)")(action {
    if (Parameter(ActivityRequest.ACTIVITY).contains) {

      jsonAction {
        val activityName = Parameter(ActivityRequest.ACTIVITY).required

        val activities = activityFacade.getActivities(activityName)

        activities.map(act => TincanActivityResponse(act.id,
          if (act.name.isDefined) act.name.get.head._2 else act.id))
      }
    } else {
      val activityId = Parameter(ActivityRequest.ACTIVITYID).required

      val activity = activityFacade.getActivity(activityId)

      if (activity.isDefined)
        try {
          OkJson(serializeActivity(activity.get))
        } catch {
          case e: JSONSerializerException => throw new EntityNotFoundException(e.message)
        }
      else
        throw new EntityNotFoundException("Activity with activityId =" + activityId + " is not found")
    }

  })

  get("/activities/profile(/)")(action {
    val activityId = Parameter(ActivityRequest.ACTIVITYID).required

    try {
      if (Parameter("profileId").contains) {
        val profileId = Parameter(ActivityRequest.PROFILEID).required
        activityFacade.getProfile(activityId, profileId) match {
          case Some(document) => Ok(new String(document.contents))
          case None           => throw new EntityNotFoundException(s"Activity profile with activityId =$activityId and profileId=$profileId is not found")
        }
      } else {
        val since = Parameter(ActivityRequest.SINCE).option.map(new DateTime(_))
        OkJson(serializeIds(activityFacade.getProfiles(activityId, since)))
      }
    } catch {
      case e: JSONSerializerException => throw new EntityNotFoundException(e.message)
    }

  })

  post("/activities/profile(/)")(action {
    val activityId = Parameter(ActivityRequest.ACTIVITYID).required
    val profileId = Parameter(ActivityRequest.PROFILEID).required
    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)
    try {
      activityFacade.updateProfile(activityId, profileId, document)
    } catch {
      case exception: ActivityProfileLRSContentModificationException =>
        exception.printStackTrace()
        throw new BadRequestException(exception.getMessage)
    }
    NoContent
  })

  put("/activities/profile(/)")(action {
    val activityId = Parameter(ActivityRequest.ACTIVITYID).required
    val profileId = Parameter(ActivityRequest.PROFILEID).required

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)

    activityFacade.saveProfile(activityId, profileId, document)
    NoContent
  })

  delete("/activities/profile(/)")(action {
    val activityId = Parameter(ActivityRequest.ACTIVITYID).required
    val profileId = Parameter(ActivityRequest.PROFILEID).required
    try {
      activityFacade.deleteProfile(activityId, profileId)
    } catch {
      case exception: ActivityProfileLRSArgumentException => {
        throw new BadRequestException(exception.getMessage)
      }
    }
    NoContent
  })
}