package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.scorm.lms.sequencing.ObjectiveState
import com.arcusys.learn.scorm.tracking.states.storage.ObjectiveStateStorage
import org.orbroker.Row
import com.arcusys.learn.scorm.manifest.model.ObjectiveMap
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker.ObjectiveMapStorageImpl

class ObjectiveStateStorageImpl extends GenericEntityStorageImpl[(Option[String],ObjectiveState)]("ObjectiveState") with ObjectiveStateStorage {
  private val objectiveMapStorage = new ObjectiveMapStorageImpl()

  def create(stateID: Int, key: Option[String], state: ObjectiveState) {
    if (key.isDefined) create("activityStateID" -> stateID, "mapKey" -> key, "satisfied"->state.getSatisfiedStatus, "normalizedMeasure"->state.getNormalizedMeasure)
    else create("activityStateID" -> stateID, "satisfied"->state.getSatisfiedStatus, "normalizedMeasure"->state.getNormalizedMeasure)
  }

  def modify(attemptID: Int, activityID: String, key: Option[String], state: ObjectiveState) {
    if (key.isDefined) modify("attemptID"->attemptID, "activityID"->activityID, "mapKey"->key, "satisfied"->state.getSatisfiedStatus, "normalizedMeasure"->state.getNormalizedMeasure)
    else modify("attemptID"->attemptID, "activityID"->activityID, "satisfied"->state.getSatisfiedStatus, "normalizedMeasure"->state.getNormalizedMeasure)
  }

  def getAll(stateID: Int): Map[Option[String], ObjectiveState] = {
    getAll("activityStateID"->stateID).toMap
  }

  def extract(row: Row) = {
    val objectiveID = row.integer("objectiveID")
    (row.string("mapKey"), new ObjectiveState(
      row.bit("satisfied"),
      row.decimal("normalizedMeasure").map(BigDecimal(_)),
      objectiveID match {
        case Some(id) => objectiveMapStorage.get(id).getOrElse(ObjectiveMap.Empty)
        case _ => ObjectiveMap.Empty
      }
    ))
  }
}
