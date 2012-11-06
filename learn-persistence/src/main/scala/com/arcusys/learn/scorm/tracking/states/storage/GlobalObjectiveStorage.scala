package com.arcusys.learn.scorm.tracking.states.storage

import com.arcusys.learn.scorm.tracking.model.ObjectiveState

trait GlobalObjectiveStorage {
  def create(treeID: Int, key: String, state: ObjectiveState)

  def getAllObjectives(treeID: Int): scala.collection.mutable.Map[String, ObjectiveState]

  def modify(attemptID: Int, key: String, state: ObjectiveState)
}
