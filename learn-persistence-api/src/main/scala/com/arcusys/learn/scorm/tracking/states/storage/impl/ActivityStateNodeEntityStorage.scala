package com.arcusys.learn.scorm.tracking.states.storage.impl

import com.arcusys.learn.scorm.tracking.model.ActivityStateNode
import com.arcusys.learn.scorm.tracking.states.storage.{ActivityStateNodeStorage, ActivityStateStorage}
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}

trait ActivityStateNodeFieldsMapper {
  def id: Int

  def treeID: Int

  def availableChildrenIDs: String
}

trait ActivityStateNodeCreator {
  def activityStateStorage: ActivityStateStorage

  def getChildren(treeID: Int, parentID: Int): Seq[ActivityStateNode]

  def createActivityStateNode(mapper: ActivityStateNodeFieldsMapper): ActivityStateNode = {
    val id = mapper.id
    val treeID = mapper.treeID
    val childrenIDs = mapper.availableChildrenIDs
    val activityState = activityStateStorage.getNodeItem(id).getOrElse(throw new Exception("Activity state should exist. Verify your DB integrity."))
    val node = new ActivityStateNode(activityState, getChildren(treeID, id))
    node.availableChildrenCollection.clear()
    if (childrenIDs.nonEmpty)
      childrenIDs.split('/').foreach(id => node.availableChildrenCollection += node.children.find(_.item.activity.id == id).getOrElse(throw new Exception("Activity ID not found! Check DB integrity.")))
    node
  }
}

trait ActivityStateNodeEntityStorage extends ActivityStateNodeStorage with KeyedEntityStorageExt[ActivityStateNode] with EntityStorageExt[ActivityStateNode] {
  def activityStateStorage: ActivityStateStorage

  def createAndGetID(treeID: Int, parentID: Option[Int], node: ActivityStateNode) = {
    val childrenIDs = node.availableChildren.map(_.item.activity.id).mkString("/")
    val nodeID = createAndGetID(node, "treeID" -> treeID, "parentID" -> parentID, "availableChildrenIDs" -> childrenIDs)
    activityStateStorage.createNodeItem(nodeID, node.item)
    nodeID
  }

  def getAllNodes(treeID: Int): Seq[ActivityStateNode] = {
    getAll("treeID" -> treeID)
  }

  def getChildren(treeID: Int, parentID: Int): Seq[ActivityStateNode] = {
    getAll("treeID" -> treeID, "parentID" -> parentID)
  }
}
