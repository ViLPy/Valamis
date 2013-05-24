package com.arcusys.learn.scorm.tracking.states.storage.impl

import com.arcusys.learn.scorm.tracking.states.storage.ObjectiveStateStorage
import com.arcusys.learn.scorm.manifest.sequencing.storage.ObjectiveMapStorage
import com.arcusys.learn.scorm.tracking.model.ObjectiveState
import com.arcusys.learn.scorm.manifest.model.ObjectiveMap
import com.arcusys.learn.storage.impl.{EntityStorageExt, EntityStorage}

trait ObjectiveStateFieldsMapper {
  def mapKey: Option[String]

  def objectiveID: Option[Int]

  def satisfied: Option[Boolean]

  def normalizedMeasure: Option[BigDecimal]
}

trait ObjectiveStateCreator {
  def objectiveMapStorage: ObjectiveMapStorage

  def createObjectiveState(mapper: ObjectiveStateFieldsMapper): (Option[String], ObjectiveState) = {
    val objectiveID = mapper.objectiveID
    (mapper.mapKey, new ObjectiveState(
      mapper.satisfied,
      mapper.normalizedMeasure,
      objectiveID match {
        case Some(id) => objectiveMapStorage.get(id).getOrElse(ObjectiveMap.Empty)
        case _ => ObjectiveMap.Empty
      }
    ))
  }
}

trait ObjectiveStateEntityStorage extends ObjectiveStateStorage with EntityStorageExt[(Option[String], ObjectiveState)] {
  def objectiveMapStorage: ObjectiveMapStorage

  def create(stateID: Int, key: Option[String], state: ObjectiveState) {
    if (key.isDefined) create("activityStateID" -> stateID, "mapKey" -> key, "satisfied" -> state.getSatisfiedStatus, "normalizedMeasure" -> state.getNormalizedMeasure)
    else create("activityStateID" -> stateID, "satisfied" -> state.getSatisfiedStatus, "normalizedMeasure" -> state.getNormalizedMeasure)
  }

  def modify(attemptID: Int, activityID: String, key: Option[String], state: ObjectiveState) {
    if (key.isDefined) modify("attemptID" -> attemptID, "activityID" -> activityID, "mapKey" -> key, "satisfied" -> state.getSatisfiedStatus, "normalizedMeasure" -> state.getNormalizedMeasure)
    else modify("attemptID" -> attemptID, "activityID" -> activityID, "satisfied" -> state.getSatisfiedStatus, "normalizedMeasure" -> state.getNormalizedMeasure)
  }

  def getAll(stateID: Int): Map[Option[String], ObjectiveState] = {
    getAll("activityStateID" -> stateID).toMap
  }

}
