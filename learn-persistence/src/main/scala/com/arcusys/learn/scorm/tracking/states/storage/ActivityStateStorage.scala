package com.arcusys.learn.scorm.tracking.states.storage

import com.arcusys.scorm.lms.sequencing.ActivityState

trait ActivityStateStorage {
  def createOrganization(treeID: Int, state: ActivityState)

  def createNodeItem(nodeID: Int, state: ActivityState)

  def getOrganization(treeID: Int): Option[ActivityState]

  def getNodeItem(nodeID: Int): Option[ActivityState]

  def modify(attemptID: Int, state: ActivityState)
}
