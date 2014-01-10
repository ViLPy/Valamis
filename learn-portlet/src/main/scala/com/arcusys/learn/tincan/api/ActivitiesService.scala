package com.arcusys.learn.tincan.api

import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import com.arcusys.learn.tincan.model.{OtherContent, JSONContent, Document}
import org.joda.time.DateTime
import com.arcusys.learn.tincan.lrs.activityprofile._
import com.arcusys.learn.tincan.storage.{TincanActivityStorage, ActivityProfileStorage}
import com.arcusys.learn.tincan.lrs.{ActivityProfileLRSAlreadyExistsException, ActivityProfileLRSContentModificationException, ActivityProfileLRSNotExistsException}
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.escalatesoft.subcut.inject.BindingModule

class ActivitiesService(configuration: BindingModule) extends ServletBase(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  val activityProfileLRS = new ActivityProfileLRS() {
    val activityStorage: TincanActivityStorage = storageFactory.tincanLrsActivityStorage
    val activityProfileStorage: ActivityProfileStorage = storageFactory.tincanLrsActivityProfileStorage
  }

  def isJsonContent = request.getContentType.startsWith( """application/json""")

  after() {
    response.addHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.addHeader("Expires", "-1")
  }

  get("/") {
    val activityId = parameter("activityId").required

    activityProfileLRS.getCompleteActivity(activityId)

    halt(200)
  }

  //    put("/") {}
  //    post("/") {}
  //    delete("/") {}

  get("/profile") {
    val activityId = parameter("activityId").required

    parameter("since").option.map(new DateTime(_).toDate) match {
      case None => {
        activityProfileLRS.getActivityDocument(activityId, parameter("profileId").required) match {
          case Some(document) => halt(200, new String(document.contents), reason = "OK")
          case None => halt(404, reason = "No Content")
        }
      }
      case Some(since) => halt(200, serializeIds(activityProfileLRS.getActivityDocumentIds(activityId, since)), reason = "No Content")
    }
  }

  post("/profile") {
    val activityId = parameter("activityId").required
    val profileId = parameter("profileId").required

    val document = Document(request.body, if (isJsonContent) JSONContent else OtherContent)

    try {
      activityProfileLRS.modifyActivityDocument(activityId, profileId, document)
    }
    catch {
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
    }
    catch {
      case exception: ActivityProfileLRSAlreadyExistsException => {
        activityProfileLRS.deleteActivityDocument(activityId, profileId)
        activityProfileLRS.addActivityDocument(activityId, profileId, document)
      }
    }
    halt(200, reason = "No Content")
  }

  delete("/profile") {
    val activityId = parameter("activityId").required
    val profileId = parameter("profileId").required

    activityProfileLRS.deleteActivityDocument(activityId, profileId)
  }
}