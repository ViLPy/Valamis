package com.arcusys.learn.scorm.tracking.states.storage

import com.arcusys.learn.scorm.tracking.model.GlobalObjectiveState

trait GlobalObjectiveStorage {
  def create(treeID: Int, key: String, state: GlobalObjectiveState)

  def getAllObjectives(treeID: Int): scala.collection.mutable.Map[String, GlobalObjectiveState]

  def modify(attemptID: Int, key: String, state: GlobalObjectiveState)
  def renew()
}
