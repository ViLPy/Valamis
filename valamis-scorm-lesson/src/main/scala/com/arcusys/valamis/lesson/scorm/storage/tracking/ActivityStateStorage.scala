package com.arcusys.valamis.lesson.scorm.storage.tracking

import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityState

trait ActivityStateStorage {
  def getCurrentActivityStateForAttempt(attemptID: Int): Option[ActivityState]

  //TODO: do we really need this?
  //def createOrganization(treeID: Int, state: ActivityState)
  //def getOrganization(treeID: Int): Option[ActivityState]

  def createNodeItem(nodeID: Int, state: ActivityState)

  def getNodeItem(nodeID: Int): Option[ActivityState]

  def modify(attemptID: Int, state: ActivityState)
  def renew()
}
