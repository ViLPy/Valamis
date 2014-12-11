package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFActivityState
import com.arcusys.learn.persistence.liferay.service.{ LFAttemptLocalServiceUtil, LFActivityStateNodeLocalServiceUtil, LFActivityStateTreeLocalServiceUtil, LFActivityStateLocalServiceUtil }
import com.arcusys.learn.scorm.manifest.storage.ActivityStorage
import com.arcusys.learn.scorm.tracking.model.{ ObjectiveState, ActivityState }
import com.arcusys.learn.scorm.tracking.states.storage.{ ObjectiveStateStorage, ActivityStateStorage }
import scala.collection.JavaConverters._

/**
 * Created by mminin on 16.10.14.
 */
trait ActivityStateStorageImpl extends ActivityStateStorage {

  def activitiesStorage: ActivityStorage
  def objectiveStateStorage: ObjectiveStateStorage

  override def renew(): Unit = {
    LFActivityStateLocalServiceUtil.removeAll()
    objectiveStateStorage.renew()
  }

  override def getCurrentActivityStateForAttempt(attemptID: Int): Option[ActivityState] = {
    val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
    require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + attemptID))
    val stateNodes = LFActivityStateNodeLocalServiceUtil.findByTreeID(stateTree.getId.toInt).asScala
    val activityStateNodeIDs = stateNodes.map(_.getId.toInt).toArray.map(i => i: java.lang.Integer)
    val activityID = stateTree.getCurrentActivityID
    LFActivityStateLocalServiceUtil.findByActivityStateNodeIDAndActivityID(activityStateNodeIDs, activityID).asScala.map(extract).headOption
  }

  override def modify(attemptID: Int, state: ActivityState): Unit = {
    val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
    require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + attemptID))
    val stateNodes = LFActivityStateNodeLocalServiceUtil.findByTreeID(stateTree.getId.toInt).asScala
    val activityStateNodeIDs = stateNodes.map(_.getId.toInt).toArray.map(i => i: java.lang.Integer)

    val entities = LFActivityStateLocalServiceUtil.findByActivityStateNodeIDAndActivityID(activityStateNodeIDs, state.activity.id).asScala
    entities.foreach(e => {
      import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
      e.setActive(state.active)
      e.setSuspended(state.suspended)
      e.setAttemptCount(state.attemptCount)
      e.setAttemptCompleted(state.attemptCompleted.getOrElse(null).asInstanceOf[java.lang.Boolean])
      e.setAttemptCompletionAmount(state.attemptCompletionAmount.getOrElse(null))
      LFActivityStateLocalServiceUtil.updateLFActivityState(e)
    })

    for ((id, entity) <- state.objectiveStates) {
      objectiveStateStorage.modify(attemptID, state.activity.id, id, entity)
    }
  }

  override def createNodeItem(nodeID: Int, state: ActivityState): Unit = {

    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    val newEntity = LFActivityStateLocalServiceUtil.createLFActivityState()

    newEntity.setActivityStateNodeID(nodeID)
    newEntity.setActivityID(state.activity.id)
    newEntity.setActive(state.active)
    newEntity.setSuspended(state.suspended)
    newEntity.setAttemptCompleted(state.attemptCompleted.getOrElse(null).asInstanceOf[java.lang.Boolean])
    newEntity.setAttemptCompletionAmount(state.attemptCompletionAmount.getOrElse(null))
    newEntity.setAttemptAbsoluteDuration(state.attemptAbsoluteDuration)
    newEntity.setAttemptExperiencedDuration(state.attemptExperiencedDuration)
    newEntity.setActivityAbsoluteDuration(state.activityAbsoluteDuration)
    newEntity.setActivityExperiencedDuration(state.activityExperiencedDuration)
    newEntity.setAttemptCount(state.attemptCount)
    newEntity.setActivityStateTreeID(null)
    val activityState = LFActivityStateNodeLocalServiceUtil.getLFActivityStateNode(nodeID)
    require(activityState != null, throw new UnsupportedOperationException("Activity state node should exists"))
    val stateTree = LFActivityStateTreeLocalServiceUtil.getLFActivityStateTree(activityState.getTreeID.toLong)
    require(stateTree != null, throw new UnsupportedOperationException("Activity state tree should exists"))
    val attempt = LFAttemptLocalServiceUtil.getLFAttempt(stateTree.getAttemptID.toLong)
    require(attempt != null, throw new UnsupportedOperationException("Attempt should exists"))
    newEntity.setPackageID(attempt.getPackageID)

    val id = LFActivityStateLocalServiceUtil.addLFActivityState(newEntity).getId.toInt
    createObjectives(id, state.objectiveStates)
  }

  override def getNodeItem(nodeID: Int): Option[ActivityState] = {
    val activityStateNodeID = Array(nodeID)
    LFActivityStateLocalServiceUtil.findByActivityStateNodeID(activityStateNodeID.map(i => i: java.lang.Integer)).asScala
      .headOption.map(extract)
  }

  private def createObjectives(stateID: Int, objectives: Map[Option[String], ObjectiveState]) {
    for ((id, entity) <- objectives) {
      objectiveStateStorage.create(stateID, id, entity)
    }
  }

  private def extract(entity: LFActivityState) = {
    val activity = activitiesStorage.get(entity.getPackageID, entity.getActivityID)
    require(activity.isDefined, "Activity should exist!")

    new ActivityState(
      activity.get,
      entity.getActive,
      entity.getSuspended,
      Option(Boolean.unbox(entity.getAttemptCompleted)),
      Option(entity.getAttemptCompletionAmount).map(BigDecimal(_)),
      BigDecimal(entity.getAttemptAbsoluteDuration),
      BigDecimal(entity.getAttemptExperiencedDuration),
      BigDecimal(entity.getActivityAbsoluteDuration),
      BigDecimal(entity.getActivityExperiencedDuration),
      entity.getAttemptCount,
      objectiveStateStorage.getAll(entity.getId.toInt)
    )
  }
}
