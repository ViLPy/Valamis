package com.arcusys.learn.bl.services.tincan

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.tincan.lrs.agentprofile.{ AgentProfileLRS, AgentProfileLRSAlreadyExistsException, AgentProfileLRSNotExistsException }
import com.arcusys.learn.tincan.model.{ Agent, Document }
import com.arcusys.learn.tincan.storage.{ ActorStorage, AgentProfileStorage }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime

/*
 * TinCan AgentProfile facade
 */
class AgentService(configuration: BindingModule) extends AgentServiceContract with Injectable {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration
  private val storageFactory = inject[StorageFactoryContract]
  private val agentProfileLrs = new AgentProfileLRS {
    val agentProfileStorage: AgentProfileStorage = storageFactory.tincanLrsAgentProfileStorage
    val actorStorage: ActorStorage = storageFactory.tincanLrsActorStorage

  }

  def getPerson(agent: Agent) = {
    agentProfileLrs.getPerson(agent)
  }

  def getProfile(agent: Agent, profileId: String) = {
    agentProfileLrs.getAgentDocument(profileId, agent)
  }

  def getProfiles(agent: Agent, since: Option[DateTime]) = {
    agentProfileLrs.getAgentDocumentIds(agent, since)
  }

  def saveProfile(agent: Agent, profileId: String, document: Document) {
    try {
      agentProfileLrs.modifyAgentDocument(profileId, agent, document)
    } catch {
      case exception: AgentProfileLRSNotExistsException => agentProfileLrs.addAgentDocument(profileId, agent, document)
      //case exception: AgentProfileLRSModificationException => {
    }
  }

  def updateProfile(agent: Agent, profileId: String, document: Document) {
    try {
      agentProfileLrs.addAgentDocument(profileId, agent, document)
    } catch {
      case exception: AgentProfileLRSAlreadyExistsException => {
        agentProfileLrs.deleteAgentDocument(profileId, agent)
        agentProfileLrs.addAgentDocument(profileId, agent, document)
      }
    }
  }

  def deleteProfile(agent: Agent, profileId: String) {
    agentProfileLrs.deleteAgentDocument(profileId, agent)
  }
}
