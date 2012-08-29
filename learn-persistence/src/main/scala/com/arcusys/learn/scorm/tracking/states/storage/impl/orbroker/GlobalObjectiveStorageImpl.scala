package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import org.orbroker.Row
import com.arcusys.learn.scorm.tracking.model.GlobalObjectiveState

class GlobalObjectiveStorageImpl extends GenericEntityStorageImpl[(String, GlobalObjectiveState)]("GlobalObjective") {
  def create(treeID: Int, key: String, state: GlobalObjectiveState) {
    create("treeID" -> treeID, "mapKey" -> key, "satisfied"->state.satisfied, "normalizedMeasure"->state.normalizedMeasure, "attemptCompleted"->state.attemptCompleted)
  }

  def getAllObjectives(treeID: Int): scala.collection.mutable.Map[String, GlobalObjectiveState] = {
    val result = scala.collection.mutable.Map[String, GlobalObjectiveState]()
    getAll("treeID"->treeID).foreach(e=> result(e._1) = e._2)
    result
  }

  def modify(attemptID: Int, key: String, state: GlobalObjectiveState) {
    if (getOne("attemptID"->attemptID, "mapKey"->key).isDefined)
      modify("attemptID"->attemptID, "mapKey"->key, "satisfied"->state.satisfied, "normalizedMeasure"->state.normalizedMeasure, "attemptCompleted"->state.attemptCompleted)
    else
      create(Seq("attemptID" -> attemptID, "mapKey" -> key, "satisfied"->state.satisfied, "normalizedMeasure"->state.normalizedMeasure, "attemptCompleted"->state.attemptCompleted):_*)
  }

  def extract(row: Row) = {
      (row.string("mapKey").get, new GlobalObjectiveState(
        row.bit("satisfied"),
        row.decimal("normalizedMeasure").map(BigDecimal(_)),
        row.bit("attemptCompleted")
      ))
    }
}
