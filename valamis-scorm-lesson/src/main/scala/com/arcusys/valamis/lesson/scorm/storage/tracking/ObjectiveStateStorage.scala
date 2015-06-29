package com.arcusys.valamis.lesson.scorm.storage.tracking

import com.arcusys.valamis.lesson.scorm.model.tracking.ObjectiveState

trait ObjectiveStateStorage {
  def create(stateID: Int, key: Option[String], state: ObjectiveState)

  def getAll(stateID: Int): Map[Option[String], ObjectiveState]

  def modify(attemptID: Int, activityID: String, key: Option[String], state: ObjectiveState)

  // TODO: add delete
  def renew()
}
