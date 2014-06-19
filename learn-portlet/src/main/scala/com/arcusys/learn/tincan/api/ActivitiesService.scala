package com.arcusys.learn.tincan.api

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import com.arcusys.learn.tincan.model.{ OtherContent, JSONContent, Document }
import org.joda.time.DateTime
import com.arcusys.learn.tincan.lrs.activityprofile._
import com.arcusys.learn.tincan.storage.{ TincanActivityStorage, ActivityProfileStorage }
import com.arcusys.learn.tincan.lrs.{ ActivityProfileLRSArgumentException, ActivityProfileLRSAlreadyExistsException, ActivityProfileLRSContentModificationException, ActivityProfileLRSNotExistsException }
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.controllers.oauth.BaseLrsClientApiApiController

class ActivitiesService(configuration: BindingModule) extends BaseLrsClientApiApiController(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  val activityProfileLRS = new ActivityProfileLRS() {
    val activityStorage: TincanActivityStorage = storageFactory.tincanLrsActivityStorage
    val activityProfileStorage: ActivityProfileStorage = storageFactory.tincanLrsActivityProfileStorage
  }

  def isJsonContent = request.getContentType.startsWith("""application/json""")

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

  get("/") {
    val activityId = parameter("activityId").required

    val activity = activityProfileLRS.getCompleteActivity(activityId)

    if (activity.isDefined)
      try {
        halt(200, serializeActivity(activity.get), reason = "OK")
      } catch {
        case e: JSONSerializerException => halt(404, e.message, reason = "Not Found")
      }
    else
      halt(404, "", reason = "Activity with activityId =" + activityId + " is not found")
  }

  //    put("/") {}
  //    post("/") {}
  //    delete("/") {}

  get("/profile") {
    val activityId = parameter("activityId").required

    try {
      if (parameter("profileId").contains) {
        activityProfileLRS.getActivityDocument(activityId, parameter("profileId").required) match {
          case Some(document) => halt(200, new String(document.contents), reason = "OK")
          case None           => halt(404, reason = "No Content")
        }
      } else {
        val since = parameter("since").option.map(new DateTime(_))
        halt(200, serializeIds(activityProfileLRS.getActivityDocumentIds(activityId, since)), reason = "OK")
      }
    } catch {
      case e: JSONSerializerException => halt(404, e.message, reason = "Not Found")

      case exception: Exception => {
        halt(400, exception.getMessage)
      }
    }

  }

  post("/profile") {
    val activityId = parameter("activityId").required
    val profileId = parameter("profileId").required

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)

    try {
      activityProfileLRS.modifyActivityDocument(activityId, profileId, document)
    } catch {
      case exception: ActivityProfileLRSNotExistsException => activityProfileLRS.addActivityDocument(activityId, profileId, document)
      case exception: ActivityProfileLRSContentModificationException => {
        exception.printStackTrace()
        halt(400, exception.message, reason = "Bad Request")
      }
    }

    halt(204, reason = "No Content")
  }

  put("/profile") {
    val activityId = parameter("activityId").required
    val profileId = parameter("profileId").required

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)

    try {
      activityProfileLRS.addActivityDocument(activityId, profileId, document)
    } catch {
      case exception: ActivityProfileLRSAlreadyExistsException => {
        activityProfileLRS.deleteActivityDocument(activityId, profileId)
        activityProfileLRS.addActivityDocument(activityId, profileId, document)
      }
    }
    halt(204, reason = "No Content")
  }

  delete("/profile") {
    val activityId = parameter("activityId").required
    val profileId = parameter("profileId").required

    try {
      activityProfileLRS.deleteActivityDocument(activityId, profileId)
      halt(204, reason = "No Content")
    } catch {
      case exception: ActivityProfileLRSArgumentException => {
        halt(400, exception.message, reason = "Bad Request")
      }
    }
  }
}