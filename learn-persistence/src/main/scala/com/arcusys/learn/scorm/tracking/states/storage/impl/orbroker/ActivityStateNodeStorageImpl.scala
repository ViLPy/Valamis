package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageImpl
import com.arcusys.learn.scorm.tracking.states.storage.ActivityStateNodeStorage
import org.orbroker.Row
import com.arcusys.learn.scorm.tracking.model.ActivityStateNode

class ActivityStateNodeStorageImpl extends KeyedEntityStorageImpl[ActivityStateNode]("ActivityStateNode", "id") with ActivityStateNodeStorage {
  private val activityStateStorage = new ActivityStateStorageImpl

  def createAndGetID(treeID: Int, parentID: Option[Int], node: ActivityStateNode) = {
    val childrenIDs = node.availableChildren.map(_.item.activity.id).mkString("/")
    val nodeID = createAndGetID(node, "treeID" -> treeID, "parentID" -> parentID, "availableChildrenIDs"->childrenIDs)
    activityStateStorage.createNodeItem(nodeID, node.item)
    nodeID
  }

  def getAllNodes(treeID: Int): Seq[ActivityStateNode] = {
    getAll("treeID" -> treeID)
  }

  private def getChildren(treeID: Int, parentID:Int): Seq[ActivityStateNode] = {
    getAll("treeID" -> treeID, "parentID"->parentID)
  }

  def extract(row: Row) = {
    val id = row.integer("id").get
    val treeID = row.integer("treeID").get
    val childrenIDs = row.string("availableChildrenIDs").get
    val activityState = activityStateStorage.getNodeItem(id).getOrElse(throw new Exception("Activity state should exist. Verify your DB integrity."))
    val node = new ActivityStateNode(activityState, getChildren(treeID, id))
    node.availableChildrenCollection.clear()
    if (childrenIDs.nonEmpty)
      childrenIDs.split('/').foreach(id => node.availableChildrenCollection += node.children.find(_.item.activity.id == id).getOrElse(throw new Exception("Activity ID not found! Check DB integrity.")))
    node
  }
}
