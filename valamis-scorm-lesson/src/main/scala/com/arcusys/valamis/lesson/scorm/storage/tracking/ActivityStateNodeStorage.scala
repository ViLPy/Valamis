package com.arcusys.valamis.lesson.scorm.storage.tracking

import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateNode

trait ActivityStateNodeStorage {
  def createAndGetID(treeID: Int, parentID: Option[Int], node: ActivityStateNode): Int

  def getAllNodes(treeID: Int): Seq[ActivityStateNode]
  def renew()
}
