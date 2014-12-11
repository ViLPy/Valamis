package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFActivityStateNode
import com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalServiceUtil
import com.arcusys.learn.scorm.tracking.model.ActivityStateNode
import com.arcusys.learn.scorm.tracking.states.storage.{ ActivityStateStorage, ActivityStateNodeStorage }
import scala.collection.JavaConverters._

/**
 * Created by mminin on 16.10.14.
 */
trait ActivityStateNodeStorageImpl extends ActivityStateNodeStorage {
  def activityStateStorage: ActivityStateStorage

  override def renew(): Unit = {
    LFActivityStateNodeLocalServiceUtil.removeAll()
  }

  override def createAndGetID(treeID: Int, parentID: Option[Int], node: ActivityStateNode) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    val childrenIDs = node.availableChildren.map(_.item.activity.id).mkString("/")

    val newEntity = LFActivityStateNodeLocalServiceUtil.createLFActivityStateNode()
    newEntity.setTreeID(treeID)
    newEntity.setParentID(parentID)
    newEntity.setAvailableChildrenIDs(childrenIDs)

    val nodeID = LFActivityStateNodeLocalServiceUtil.addLFActivityStateNode(newEntity).getId.toInt

    activityStateStorage.createNodeItem(nodeID, node.item)
    nodeID
  }

  override def getAllNodes(treeID: Int): Seq[ActivityStateNode] = {
    LFActivityStateNodeLocalServiceUtil.findByTreeID(treeID).asScala.sortBy(_.getId).map(extract)
  }

  def getChildren(treeID: Int, parentID: Int): Seq[ActivityStateNode] = {
    LFActivityStateNodeLocalServiceUtil.findByTreeIDAndParentID(treeID, parentID).asScala
      .sortBy(_.getId).map(extract)
  }

  private def extract(entity: LFActivityStateNode) = {
    val id = entity.getId.toInt
    val treeID = entity.getTreeID
    val childrenIDs = entity.getAvailableChildrenIDs
    val activityState = activityStateStorage.getNodeItem(id).getOrElse(throw new Exception("Activity state should exist. Verify your DB integrity."))
    val node = new ActivityStateNode(activityState, getChildren(treeID, id))
    node.availableChildrenCollection.clear()
    if (childrenIDs.nonEmpty)
      childrenIDs.split('/').foreach(id => node.availableChildrenCollection += node.children.find(_.item.activity.id == id).getOrElse(throw new Exception("Activity ID not found! Check DB integrity.")))
    node
  }
}
