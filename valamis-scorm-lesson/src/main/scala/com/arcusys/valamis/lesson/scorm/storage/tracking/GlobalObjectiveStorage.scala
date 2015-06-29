package com.arcusys.valamis.lesson.scorm.storage.tracking

import com.arcusys.valamis.lesson.scorm.model.tracking.GlobalObjectiveState

trait GlobalObjectiveStorage {
  def create(treeID: Int, key: String, state: GlobalObjectiveState)

  def getAllObjectives(treeID: Int): scala.collection.mutable.Map[String, GlobalObjectiveState]

  def modify(attemptID: Int, key: String, state: GlobalObjectiveState)
  def renew()
}
