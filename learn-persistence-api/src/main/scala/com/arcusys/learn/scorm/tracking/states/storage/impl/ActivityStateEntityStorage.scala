package com.arcusys.learn.scorm.tracking.states.storage.impl

import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.learn.scorm.tracking.model.{ ObjectiveState, ActivityState }
import com.arcusys.learn.scorm.tracking.states.storage.{ ObjectiveStateStorage, ActivityStateStorage }
import com.arcusys.learn.scorm.manifest.storage.ActivitiesStorage

trait ActivityStateFieldsMapper {
  def packageID: Int

  def activityID: String

  def id: Int

  def active: Boolean

  def suspended: Boolean

  def attemptCompleted: Option[Boolean]

  def attemptCompletionAmount: Option[BigDecimal]

  def attemptAbsoluteDuration: BigDecimal

  def attemptExperiencedDuration: BigDecimal

  def activityAbsoluteDuration: BigDecimal

  def activityExperiencedDuration: BigDecimal

  def attemptCount: Int
}

trait ActivityStateCreator {
  def activitiesStorage: ActivitiesStorage

  def objectiveStateStorage: ObjectiveStateStorage

  def createActivityState(mapper: ActivityStateFieldsMapper): ActivityState = {
    val activity = activitiesStorage.get(mapper.packageID, mapper.activityID)
    require(activity.isDefined, "Activity should exist!")

    new ActivityState(
      activity.get,
      mapper.active,
      mapper.suspended,
      mapper.attemptCompleted,
      mapper.attemptCompletionAmount,
      mapper.attemptAbsoluteDuration,
      mapper.attemptExperiencedDuration,
      mapper.activityAbsoluteDuration,
      mapper.activityExperiencedDuration,
      mapper.attemptCount,
      objectiveStateStorage.getAll(mapper.id)
    )
  }
}

trait ActivityStateEntityStorage extends ActivityStateStorage with KeyedEntityStorageExt[ActivityState] with EntityStorageExt[ActivityState] {
  def activitiesStorage: ActivitiesStorage

  def objectiveStateStorage: ObjectiveStateStorage

  override def renew() {
    doRenew()
    objectiveStateStorage.renew()
  }

  def getCurrentActivityStateForAttempt(attemptID: Int) = {
    getOne("attemptID" -> attemptID)
  }

  def createNodeItem(nodeID: Int, state: ActivityState) {
    val id = createAndGetID(state, "activityStateNodeID" -> nodeID)
    createObjectives(id, state.objectiveStates)
  }

  private def createObjectives(stateID: Int, objectives: Map[Option[String], ObjectiveState]) {
    for ((id, entity) <- objectives) {
      objectiveStateStorage.create(stateID, id, entity)
    }
  }

  def getNodeItem(nodeID: Int): Option[ActivityState] = {
    getOne("activityStateNodeID" -> nodeID)
  }

  def modify(attemptID: Int, state: ActivityState) {
    modify(state, "attemptID" -> attemptID)
    for ((id, entity) <- state.objectiveStates) {
      objectiveStateStorage.modify(attemptID, state.activity.id, id, entity)
    }
  }
}