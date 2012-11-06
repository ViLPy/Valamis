package com.arcusys.learn.scorm.tracking.states.storage

import com.arcusys.learn.scorm.tracking.model.ActivityStateTree

trait ActivityStateTreeStorage {
  def create(attemptID:Int, tree:ActivityStateTree)
  def get(attemptID:Int):Option[ActivityStateTree]
  def modify(attemptID:Int, tree:ActivityStateTree)
}
