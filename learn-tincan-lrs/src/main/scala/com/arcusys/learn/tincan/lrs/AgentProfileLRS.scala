package com.arcusys.learn.tincan.lrs

package agentprofile {

  import com.arcusys.learn.tincan.model._
  import com.arcusys.learn.tincan.storage.AgentProfileStorage
  import com.arcusys.learn.tincan.model.{Agent, AgentProfile}
import java.util.Date
import com.arcusys.learn.tincan.lrs.utils.JsonCombiner

trait AgentProfileLRS {
    val agentProfileStorage: AgentProfileStorage

    // TODO: complete the method when it becomes clear about Person stuff...
    def getPerson(agent: Agent): Option[Person] = {
      require(agent != null, "Incorrect parameters were passed in AgentProfileLRS.getPerson")
      None
    }

    def getAgentDocument(profileId: String, agent: Agent): Option[Document] = {
      require(
        profileId != null && !profileId.isEmpty && agent != null,
        "Incorrect parameters were passed into 'AgentProfileLRS.getAgentDocument'")
      agentProfileStorage.get(profileId, agent).map(_.content)
    }

    def getAgentDocumentIds(agent: Agent, since: Date): Seq[String] = {
      require(agent != null, "Incorrect parameter was passed into 'AgentProfileLRS.getArgumentDocumentIds'")
      agentProfileStorage.getIds(agent, since)
    }

    def addAgentDocument(profileId: String, agent: Agent, content: Document) {
      require(profileId != null && !profileId.isEmpty && content != null && agent != null,
        "Incorrect parameters were passed into 'AgentProfileLRS.addAgentDocument'")

      val stored = agentProfileStorage.get(profileId, agent)
      stored match {
        case None =>
          agentProfileStorage.create(AgentProfile(profileId, agent, content))
        case Some(_) =>
          throw AgentProfileLRSAlreadyExistsException("The agent document for profile {%s} and agent {%s} already exist".
            format(profileId, agent))
      }
    }

    def modifyAgentDocument(profileId: String, agent: Agent, content: Document) {
      require(profileId != null && !profileId.isEmpty && content != null && agent != null,
        "Incorrect parameters were passed into 'AgentProfileLRS.modifyAgentDocument'")

      val stored = agentProfileStorage.get(profileId, agent)
      stored match {
        case Some(c) if c.content.cType == OtherContent && content.cType == OtherContent =>
          agentProfileStorage.modify(AgentProfile(profileId, agent, content))
        case Some(c) if c.content.cType == JSONContent && content.cType == JSONContent =>
          val newContent = try {
            JsonCombiner.combine(c.content.contents, content.contents)
          }
          catch {
            case exception : Exception => throw new AgentProfileLRSModificationException("Json Content type of given document can`t be merged with content type of existing document", exception)
          }
          agentProfileStorage.modify(AgentProfile(profileId, agent, content.copy(contents = newContent)))
        case None =>
          throw AgentProfileLRSNotExistsException("There is no agent document for profile {%s} and agent {%s} to be modified".
            format(profileId, agent))
        case _ =>
          throw new AgentProfileLRSModificationException("Content type of given document doesn't match with content type of existing document")
      }
    }

    def deleteAgentDocument(profileId: String, agent: Agent) {
      require(profileId != null && !profileId.isEmpty && agent != null,
        "Incorrect parameters were passed into 'AgentProfileLRS.deleteAgentDocument'")
      agentProfileStorage.delete(profileId, agent)
    }

    private def require(predicate: Boolean, message: String = "") {
      if (!predicate) throw  AgentProfileLRSArgumentException(message)
    }
  }

  case class AgentProfileLRSArgumentException(message: String) extends IllegalArgumentException(message)
  case class AgentProfileLRSException(message: String) extends Exception(message)
  case class AgentProfileLRSNotExistsException(message: String) extends Exception(message)
  case class AgentProfileLRSAlreadyExistsException(message: String) extends Exception(message)
  case class AgentProfileLRSModificationException(message: String, cause: Throwable) extends Exception(message, cause) {
    def this(message: String) = this(message, null)
  }
}
