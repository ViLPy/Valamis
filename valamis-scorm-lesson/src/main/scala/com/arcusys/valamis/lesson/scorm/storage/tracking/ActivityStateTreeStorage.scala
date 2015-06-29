package com.arcusys.valamis.lesson.scorm.storage.tracking

import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateTree

trait ActivityStateTreeStorage {
  def create(attemptID: Int, tree: ActivityStateTree)
  def get(attemptID: Int): Option[ActivityStateTree]
  def modify(attemptID: Int, tree: ActivityStateTree)
  def renew()
}
