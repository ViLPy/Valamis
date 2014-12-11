package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree
import com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalServiceUtil
import com.arcusys.learn.scorm.tracking.model.{ ActivityStateNode, ActivityStateTree }
import com.arcusys.learn.scorm.tracking.states.storage.{ GlobalObjectiveStorage, ActivityStateNodeStorage, ActivityStateStorage, ActivityStateTreeStorage }
import com.arcusys.learn.scorm.tracking.states.storage.impl.ActivityStateTreeFieldsMapper

import scala.util.Try

/**
 * Created by mminin on 16.10.14.
 */
trait ActivityStateTreeStorageImpl extends ActivityStateTreeStorage {

  def activityStateStorage: ActivityStateStorage
  def activityStateNodeStorage: ActivityStateNodeStorage
  def globalObjectiveStorage: GlobalObjectiveStorage

  def createActivityStateTree(mapper: ActivityStateTreeFieldsMapper): ActivityStateTree

  override def renew(): Unit = {
    LFActivityStateTreeLocalServiceUtil.removeAll()
    globalObjectiveStorage.renew()
    activityStateNodeStorage.renew()
    activityStateStorage.renew()
  }

  override def get(attemptID: Int): Option[ActivityStateTree] = {
    Try(LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)).toOption.map(extract)
  }

  override def create(attemptID: Int, tree: ActivityStateTree): Unit = {
    val newEntity = LFActivityStateTreeLocalServiceUtil.createLFActivityStateTree()
    newEntity.setAttemptID(attemptID)
    newEntity.setCurrentActivityID(tree.currentActivity.map(_.item.activity.id).getOrElse(null))
    newEntity.setSuspendedActivityID(tree.suspendedActivity.map(_.item.activity.id).getOrElse(null))

    val treeID = LFActivityStateTreeLocalServiceUtil.addLFActivityStateTree(newEntity).getId.toInt

    val organizationID = activityStateNodeStorage.createAndGetID(treeID, None, tree)

    def createStates(parentID: Option[Int], nodes: Seq[ActivityStateNode]) {
      nodes.foreach(node => {
        val id = activityStateNodeStorage.createAndGetID(treeID, parentID, node)
        createStates(Some(id), node.children)
      })
    }
    tree.globalObjectiveData.foreach(objective => globalObjectiveStorage.create(treeID, objective._1, objective._2))
    createStates(Some(organizationID), tree.children)
  }

  override def modify(attemptID: Int, tree: ActivityStateTree): Unit = {
    def updateStates(nodes: Seq[ActivityStateNode]) {
      nodes.foreach(node => {
        activityStateStorage.modify(attemptID, node.item)
        updateStates(node.children)
      })
    }

    val entity = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
    if (entity != null) {
      entity.setCurrentActivityID(tree.currentActivity.map(_.item.activity.id).getOrElse(null))
      entity.setSuspendedActivityID(tree.suspendedActivity.map(_.item.activity.id).getOrElse(null))
      LFActivityStateTreeLocalServiceUtil.updateLFActivityStateTree(entity)
    }

    activityStateStorage.modify(attemptID, tree.item)
    updateStates(tree.children)
    tree.globalObjectiveData.foreach(objective => globalObjectiveStorage.modify(attemptID, objective._1, objective._2))
  }

  private def extract(entity: LFActivityStateTree) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    val mapper = new ActivityStateTreeFieldsMapper {
      def id: Int = entity.getId.toInt
      def currentActivityID: Option[String] = entity.getCurrentActivityID.toOption
      def suspendedActivityID: Option[String] = entity.getSuspendedActivityID.toOption
    }
    createActivityStateTree(mapper)
  }
}
