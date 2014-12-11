package com.arcusys.learn.bl.services.tincan

import com.arcusys.learn.tincan.model.{ Activity, Document }
import org.joda.time.DateTime

trait ActivityProfileServiceContract {
  def getActivities(activityName: String): Seq[Activity]

  def getActivity(activityId: String): Option[Activity]

  def getProfile(activityId: String, profileId: String): Option[Document]

  def getProfiles(activityId: String, since: Option[DateTime]): Seq[String]

  def updateProfile(activityId: String, profileId: String, document: Document)

  def saveProfile(activityId: String, profileId: String, document: Document)

  def deleteProfile(activityId: String, profileId: String)
}
