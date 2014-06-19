package com.arcusys.learn.tincan.lrs

package state {

  import java.util.{ UUID }

  import com.arcusys.learn.tincan.model._
  import com.arcusys.learn.tincan.storage.StateStorage
  import com.arcusys.learn.tincan.model.{ State, Agent }
  import com.arcusys.learn.tincan.lrs.utils.JsonCombiner
  import org.joda.time.DateTime

  trait StateLRS {
    val stateStorage: StateStorage

    def addStateDocument(state: State) {
      checkState(state, "Incorrect arguments were passed in the 'StateLRS.addStateDocument' method")

      val stored = stateStorage.get(state.activityId, state.stateId, state.agent, state.registration)
      stored match {
        case None =>
          stateStorage.create(state)
        case Some(_) =>
          throw StateLRSDocumentAlreadyExistsException(
            "The document for activity {%s},state {%s}, agent {%s} already exists".
              format(state.activityId, state.stateId, state.agent))
      }
    }

    def modifyStateDocument(state: State) {
      checkState(state, "Incorrect arguments were passed in the 'StateLRS.modifyStateDocument' method")

      val stored = stateStorage.get(state.activityId, state.stateId, state.agent, state.registration)
      stored match {
        case None => throw StateLRSNotExistsException("There is no document for activity {%s}, state {%s}, agent {%s} that can be modified".format(state.activityId, state.stateId, state.agent))
        case Some(s: State) if s.content.cType == JSONContent && state.content.cType == JSONContent =>
          val newContent =
            try {
              JsonCombiner.combine(s.content.contents, state.content.contents)
            } catch {
              case exception: Throwable => throw new StateLRSDocumentModificationException("Json Content type of given document can`t be merged with content type of existing document", exception)
            }
          stateStorage.modify(state.copy(content = state.content.copy(contents = newContent)))
        case Some(s) if s.content.cType == OtherContent && state.content.cType == OtherContent =>
          stateStorage.modify(state)
        case _ =>
          throw new StateLRSDocumentModificationException("Content type of given document doesn't match with content type of existing document")
      }
    }

    def getStateDocument(activityId: String, stateId: String, agent: Agent, registration: Option[UUID]): Option[Document] = {
      checkArguments(activityId, stateId, agent)("Incorrect arguments were passed in the 'StateLRS.getStateDocument' method")
      val stored = stateStorage.get(activityId, stateId, agent, registration)
      stored.map(_.content)
    }

    def getStateDocumentIds(activityId: String, agent: Agent, registration: Option[UUID], since: Option[DateTime]): Seq[String] = {
      require(
        activityId != null && !activityId.isEmpty && agent != null,
        "Incorrect arguments were passed in the 'StateLRS.getStateDocumentIds' method")
      stateStorage.getIds(activityId, agent, registration, since)
    }

    def deleteStateDocument(activityId: String, stateId: String, agent: Agent, registration: Option[UUID]) {
      checkArguments(activityId, stateId, agent)("Incorrect arguments were passed in the 'StateLRS.deleteStateDocument' method")
      stateStorage.delete(activityId, stateId, agent, registration)
    }

    def deleteStateDocuments(activityId: String, agent: Agent, registration: Option[UUID]) {
      require(
        activityId != null && !activityId.isEmpty && agent != null,
        "Incorrect arguments were passed in the 'StateLRS.deleteStateDocuments' method")
      stateStorage.delete(activityId, agent, registration)
    }

    private def checkState(state: State, message: String = "") = {
      require(
        state != null &&
          state.activityId != null &&
          !state.activityId.isEmpty &&
          state.stateId != null &&
          !state.stateId.isEmpty &&
          state.agent != null &&
          state.content != null,
        message)
    }

    private def checkArguments(activityId: String, stateId: String, agent: Agent)(message: String = "") = {
      require(
        activityId != null && !activityId.isEmpty && stateId != null && !stateId.isEmpty && agent != null)
      (message)
    }

    private def require(predicate: Boolean, message: String = "") {
      if (!predicate) throw StateLRSArgumentException(message)
    }
  }

  case class StateLRSArgumentException(message: String) extends Exception(message)

  case class StateLRSDocumentAlreadyExistsException(message: String) extends Exception(message)

  case class StateLRSDocumentException(message: String) extends Exception(message)

  case class StateLRSNotExistsException(message: String) extends Exception(message)

  case class StateLRSDocumentModificationException(message: String, cause: Throwable) extends Exception(message, cause) {
    def this(message: String) = this(message, null)
  }

}