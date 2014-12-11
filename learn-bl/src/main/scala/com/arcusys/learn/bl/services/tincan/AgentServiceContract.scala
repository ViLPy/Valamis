package com.arcusys.learn.bl.services.tincan

import com.arcusys.learn.tincan.model.{ Agent, Document, Person }
import org.joda.time.DateTime

trait AgentServiceContract {
  def getPerson(agent: Agent): Person

  def getProfile(agent: Agent, profileId: String): Option[Document]

  def getProfiles(agent: Agent, since: Option[DateTime]): Seq[String]

  def saveProfile(agent: Agent, profileId: String, document: Document): Unit

  def updateProfile(agent: Agent, profileId: String, document: Document): Unit

  def deleteProfile(agent: Agent, profileId: String): Unit
}
