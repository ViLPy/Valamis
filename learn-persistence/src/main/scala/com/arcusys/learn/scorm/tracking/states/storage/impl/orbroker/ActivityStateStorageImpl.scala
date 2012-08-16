package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageImpl
import com.arcusys.learn.scorm.tracking.states.storage.ActivityStateStorage
import com.arcusys.scorm.lms.sequencing.{ObjectiveState, ActivityState}
import org.orbroker.Row
import com.arcusys.learn.scorm.manifest.model.Activity
import com.arcusys.learn.scorm.manifest.storage.impl.orbroker.ActivitiesStorageImpl

class ActivityStateStorageImpl extends KeyedEntityStorageImpl[ActivityState]("ActivityState", "id") with ActivityStateStorage {
  private val activitiesStorage = new ActivitiesStorageImpl
  private val objectiveStateStorage = new ObjectiveStateStorageImpl

  override def renew() {
    super.renew()
    objectiveStateStorage.renew()
  }

  def createOrganization(treeID: Int, state: ActivityState) {
    val id = createAndGetID(state, "activityStateTreeID" -> treeID)
    createObjectives(id, state.objectiveStates)
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

  def getOrganization(treeID: Int): Option[ActivityState] = {
    getOne("activityStateTreeID" -> treeID)
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

  def extract(row: Row) = {
    val activity = activitiesStorage.get(row.integer("packageID").get, row.string("activityID").get)
    require(activity.isDefined, "Activity should exist!")

    new ActivityState(
      activity.get,
      row.bit("active").get,
      row.bit("suspended").get,
      row.bit("attemptCompleted"),
      row.decimal("attemptCompletionAmount").map(BigDecimal(_)),
      BigDecimal(row.decimal("attemptAbsoluteDuration").get),
      BigDecimal(row.decimal("attemptExperiencedDuration").get),
      BigDecimal(row.decimal("activityAbsoluteDuration").get),
      BigDecimal(row.decimal("activityExperiencedDuration").get),
      row.integer("attemptCount").get,
      objectiveStateStorage.getAll(row.integer("id").get)
    )
  }
}
