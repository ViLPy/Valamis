package com.arcusys.learn.bl.services.tincan

import java.util.UUID

import com.arcusys.learn.tincan.model._
import org.joda.time.DateTime

trait StateServiceContract {
  def getProfile(agent: Agent,
    activityId: String,
    stateId: String,
    registration: Option[UUID]): Option[Document]

  def getProfiles(agent: Agent,
    activityId: String,
    registration: Option[UUID],
    since: Option[DateTime]): Seq[String]

  def updateProfile(agent: Agent,
    activityId: String,
    stateId: String,
    registration: Option[UUID],
    document: Document)

  def saveProfile(agent: Agent,
    activityId: String,
    stateId: String,
    registration: Option[UUID],
    document: Document)

  def deleteProfile(agent: Agent,
    activityId: String,
    stateId: Option[String],
    registration: Option[UUID])
}
