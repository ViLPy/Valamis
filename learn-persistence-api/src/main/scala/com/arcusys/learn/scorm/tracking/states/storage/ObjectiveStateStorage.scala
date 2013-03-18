package com.arcusys.learn.scorm.tracking.states.storage

import com.arcusys.learn.scorm.tracking.model.ObjectiveState

trait ObjectiveStateStorage {
  def create(stateID: Int, key: Option[String], state: ObjectiveState)

  def getAll(stateID: Int): Map[Option[String], ObjectiveState]

  def modify(attemptID: Int, activityID: String, key: Option[String], state: ObjectiveState)
}
