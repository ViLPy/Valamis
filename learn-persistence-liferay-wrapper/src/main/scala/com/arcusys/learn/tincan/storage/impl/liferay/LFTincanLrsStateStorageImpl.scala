package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model.{ Agent, State }
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsState
import com.arcusys.learn.tincan.storage.{ DocumentStorage, ActorStorage }
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalServiceUtil
import java.util.{ Date, UUID }
import org.joda.time.DateTime

import scala.collection.JavaConverters._
import com.arcusys.util.JsonSerializer

trait LFTincanLrsStateStorageImpl extends EntityStorage[State] {
  def actorStorage: ActorStorage

  def documentStorage: DocumentStorage

  def doRenew() {
    LFTincanLrsStateLocalServiceUtil.removeAll()
  }

  def mapper(entity: LFTincanLrsState): State = {
    val agent = actorStorage.getByID(entity.getAgentId.toInt).getOrElse(throw new IllegalArgumentException("Cannot find agent actor with given id"))
    if (!agent.isInstanceOf[Agent]) throw new IllegalArgumentException("Actor is not an Agent")

    State(entity.getActivityId,
      entity.getStateId,
      agent.asInstanceOf[Agent],
      Option(entity.getRegistration).map(JsonSerializer.deserializeUUID),
      documentStorage.get(entity.getDocumentId).getOrElse(throw new IllegalArgumentException("Cannot find document with given id")),
      id = Some(entity.getId.toInt))
  }

  def getOne(parameters: (String, Any)*): Option[State] = parameters match {
    case Seq(("activityId", activityId: String), ("stateId", stateId: String), ("agent", agent: Agent), ("registration", registration: Option[UUID])) => {
      val agentId = actorStorage.getByIFI(agent.objectType, agent.mbox, agent.mbox_sha1sum, agent.openid, agent.account).map(_.getStoredId.getOrElse(-1))
      Option(LFTincanLrsStateLocalServiceUtil.findByStateDocument(activityId,
        stateId,
        if (agentId.isDefined) agentId.get else -1,
        if (registration.isDefined) JsonSerializer.serializeUUID(registration.get) else null))
        .map(mapper)
    }
    case _ => None
  }

  def getAll(parameters: (String, Any)*): Seq[State] = parameters match {
    case Seq(("activityId", activityId: String), ("agent", agent: Agent), ("registration", registration: Option[UUID]), ("since", since: Option[Date])) => {

      val agentId = actorStorage.getByIFI(agent.objectType, agent.mbox, agent.mbox_sha1sum, agent.openid, agent.account).map(_.getStoredId.getOrElse(-1))
      LFTincanLrsStateLocalServiceUtil.findByActivityIdAndAgentId(activityId, if (agentId.isDefined) agentId.get else -1).asScala
        .map(mapper)
        .filter(state => {
          (!since.isDefined || state.content.updated.compareTo(new DateTime(since.get)) >= 0)
        })
    }
    case _ => Nil
  }

  def delete(parameters: (String, Any)*): Unit = parameters match {
    case Seq(("activityId", activityId: String), ("stateId", stateId: String), ("agent", agent: Agent), ("registration", registration: Option[UUID])) => {
      val agentId = actorStorage.getByIFI(agent.objectType, agent.mbox, agent.mbox_sha1sum, agent.openid, agent.account).map(_.getStoredId.getOrElse(-1))
      Option(LFTincanLrsStateLocalServiceUtil.findByStateDocument(activityId,
        stateId,
        if (agentId.isDefined) agentId.get else -1,
        if (registration.isDefined) JsonSerializer.serializeUUID(registration.get) else null))
        .map(state => (mapper(state), state.getId))
        .foreach(p => LFTincanLrsStateLocalServiceUtil.deleteLFTincanLrsState(p._2))
    }
    case Seq(("activityId", activityId: String), ("agent", agent: Agent), ("registration", registration: Option[UUID])) => {
      val agentId = actorStorage.getByIFI(agent.objectType, agent.mbox, agent.mbox_sha1sum, agent.openid, agent.account).map(_.getStoredId.getOrElse(-1))
      LFTincanLrsStateLocalServiceUtil.findByActivityIdAndAgentId(activityId, if (agentId.isDefined) agentId.get else -1).asScala.map(state => (mapper(state), state.getId))
        .filter(state => registration.isDefined && state._1.registration == registration).foreach(p => LFTincanLrsStateLocalServiceUtil.deleteLFTincanLrsState(p._2))
    }
  }

  private def setFields(lfEntity: LFTincanLrsState, entity: State) {
    lfEntity.setActivityId(entity.activityId)
    lfEntity.setStateId(entity.stateId)
    lfEntity.setAgentId(actorStorage.createAndGetID(entity.agent))
    entity.registration.foreach(uuid => lfEntity.setRegistration(JsonSerializer.serializeUUID(uuid)))

    if (documentStorage.get(entity.content.id).isDefined) {
      documentStorage.modify(entity.content)
    } else {
      documentStorage.create(entity.content)
    }

    lfEntity.setDocumentId(entity.content.id)
  }

  def create(entity: State, parameters: (String, Any)*): Unit = {
    val lfEntity = LFTincanLrsStateLocalServiceUtil.createLFTincanLrsState()
    setFields(lfEntity, entity)
    LFTincanLrsStateLocalServiceUtil.addLFTincanLrsState(lfEntity)
  }

  def modify(entity: State, parameters: (String, Any)*): Unit = {
    val lfEntity = LFTincanLrsStateLocalServiceUtil.getLFTincanLrsState(entity.id.getOrElse(throw new IllegalArgumentException("Cannot retrieve state id")))

    setFields(lfEntity, entity)

    LFTincanLrsStateLocalServiceUtil.updateLFTincanLrsState(lfEntity)
  }

  def create(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[State] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[State] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()
}
