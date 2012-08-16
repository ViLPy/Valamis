package com.arcusys.learn.scorm.tracking.states.storage

import com.arcusys.scorm.lms.sequencing.ActivityStateNode

trait ActivityStateNodeStorage {
  def createAndGetID(treeID: Int, parentID: Option[Int], node: ActivityStateNode):Int

  def getAllNodes(treeID: Int): Seq[ActivityStateNode]
}
