package com.arcusys.learn.bl.services.tincan

import java.util.UUID

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.tincan.lrs.state.{ StateLRS, StateLRSDocumentAlreadyExistsException, StateLRSNotExistsException }
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.storage.StateStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime

/*
 * TinCan StateProfile facade
 */
class StateService(configuration: BindingModule) extends StateServiceContract with Injectable {
  def this() = this(DomainConfiguration)
  implicit val bindingModule = configuration
  private val stateLRS = new StateLRS() {
    val stateStorage = inject[StateStorage]

  }

  def getProfile(agent: Agent, activityId: String, stateId: String, registration: Option[UUID]): Option[Document] = {
    stateLRS.getStateDocument(activityId, stateId, agent, registration)
  }

  def getProfiles(agent: Agent, activityId: String, registration: Option[UUID], since: Option[DateTime]): Seq[String] = {
    stateLRS.getStateDocumentIds(activityId, agent, registration, since)
  }

  def updateProfile(agent: Agent, activityId: String, stateId: String, registration: Option[UUID], document: Document) {
    try {
      stateLRS.modifyStateDocument(State(activityId, stateId, agent, registration, document))
    } catch {
      case exception: StateLRSNotExistsException =>
        stateLRS.addStateDocument(State(activityId, stateId, agent, registration, document))
    }
  }

  def saveProfile(agent: Agent, activityId: String, stateId: String, registration: Option[UUID], document: Document) {
    val state = State(activityId, stateId, agent, registration, document)
    try {
      stateLRS.addStateDocument(state)
    } catch {
      case exception: StateLRSDocumentAlreadyExistsException => {
        stateLRS.deleteStateDocument(activityId, stateId, agent, registration)
        stateLRS.addStateDocument(state)
      }
    }
  }

  def deleteProfile(agent: Agent, activityId: String, stateId: Option[String], registration: Option[UUID]) {
    stateId match {
      case Some(stId) => stateLRS.deleteStateDocument(activityId, stId, agent, registration)
      case None       => stateLRS.deleteStateDocuments(activityId, agent, registration)
    }
  }
}
