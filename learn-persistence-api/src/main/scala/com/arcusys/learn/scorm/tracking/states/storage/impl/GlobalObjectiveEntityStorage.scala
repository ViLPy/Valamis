package com.arcusys.learn.scorm.tracking.states.storage.impl

import com.arcusys.learn.storage.impl.{EntityStorageExt, EntityStorage}
import com.arcusys.learn.scorm.tracking.states.storage.GlobalObjectiveStorage
import com.arcusys.learn.scorm.tracking.model.GlobalObjectiveState

trait GlobalObjectiveEntityStorage extends GlobalObjectiveStorage with EntityStorageExt[(String, GlobalObjectiveState)] {
  def create(treeID: Int, key: String, state: GlobalObjectiveState) {
    create("treeID" -> treeID, "mapKey" -> key, "satisfied" -> state.satisfied, "normalizedMeasure" -> state.normalizedMeasure, "attemptCompleted" -> state.attemptCompleted)
  }

  def getAllObjectives(treeID: Int): scala.collection.mutable.Map[String, GlobalObjectiveState] = {
    val result = scala.collection.mutable.Map[String, GlobalObjectiveState]()
    getAll("treeID" -> treeID).foreach(e => result(e._1) = e._2)
    result
  }

  def modify(attemptID: Int, key: String, state: GlobalObjectiveState) {
    if (getOne("attemptID" -> attemptID, "mapKey" -> key).isDefined)
      modify("attemptID" -> attemptID, "mapKey" -> key, "satisfied" -> state.satisfied, "normalizedMeasure" -> state.normalizedMeasure, "attemptCompleted" -> state.attemptCompleted)
    else
      create("attemptID" -> attemptID, "mapKey" -> key, "satisfied" -> state.satisfied, "normalizedMeasure" -> state.normalizedMeasure, "attemptCompleted" -> state.attemptCompleted)
  }
}
