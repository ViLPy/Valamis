package com.arcusys.learn.bl.services.tincan

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.tincan.lrs.activityprofile.ActivityProfileLRS
import com.arcusys.learn.tincan.lrs.{ ActivityProfileLRSAlreadyExistsException, ActivityProfileLRSNotExistsException }
import com.arcusys.learn.tincan.model.{ Activity, Document }
import com.arcusys.learn.tincan.storage.{ ActivityProfileStorage, TincanActivityStorage }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime

/*
 * TinCan ActivityProfile facade
 */
class ActivityProfileService(configuration: BindingModule) extends ActivityProfileServiceContract with Injectable {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration
  private val activityProfileLRS = new ActivityProfileLRS() {
    val activityStorage: TincanActivityStorage = inject[TincanActivityStorage]
    val activityProfileStorage: ActivityProfileStorage = inject[ActivityProfileStorage]
  }

  def getActivities(activityName: String): Seq[Activity] = {
    activityProfileLRS.getActivitiesByName(activityName)
  }

  def getActivity(activityId: String): Option[Activity] = {
    activityProfileLRS.getCompleteActivity(activityId)
  }

  def getProfile(activityId: String, profileId: String): Option[Document] = {
    activityProfileLRS.getActivityDocument(activityId, profileId)
  }

  def getProfiles(activityId: String, since: Option[DateTime]): Seq[String] = {
    activityProfileLRS.getActivityDocumentIds(activityId, since)
  }

  def updateProfile(activityId: String, profileId: String, document: Document) {

    try {
      activityProfileLRS.modifyActivityDocument(activityId, profileId, document)
    } catch {
      case exception: ActivityProfileLRSNotExistsException => activityProfileLRS.addActivityDocument(activityId, profileId, document)
      //case exception: ActivityProfileLRSContentModificationException =>
    }
  }

  def saveProfile(activityId: String, profileId: String, document: Document) {

    try {
      activityProfileLRS.addActivityDocument(activityId, profileId, document)
    } catch {
      case exception: ActivityProfileLRSAlreadyExistsException => {
        activityProfileLRS.deleteActivityDocument(activityId, profileId)
        activityProfileLRS.addActivityDocument(activityId, profileId, document)
      }
    }
  }

  def deleteProfile(activityId: String, profileId: String) {
    activityProfileLRS.deleteActivityDocument(activityId, profileId)
  }
}
