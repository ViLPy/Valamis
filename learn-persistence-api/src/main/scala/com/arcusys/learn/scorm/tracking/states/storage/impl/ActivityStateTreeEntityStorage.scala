package com.arcusys.learn.scorm.tracking.states.storage.impl

import com.arcusys.learn.scorm.tracking.model.{ ActivityStateNode, ActivityStateTree }
import com.arcusys.learn.scorm.tracking.states.storage.{ ActivityStateTreeStorage, GlobalObjectiveStorage, ActivityStateNodeStorage, ActivityStateStorage }
import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.learn.scorm.manifest.model.Organization

trait ActivityStateTreeFieldsMapper {
  def id: Int

  def currentActivityID: Option[String]

  def suspendedActivityID: Option[String]
}

trait ActivityStateTreeCreator {
  def activityStateNodeStorage: ActivityStateNodeStorage

  def globalObjectiveStorage: GlobalObjectiveStorage

  def createActivityStateTree(mapper: ActivityStateTreeFieldsMapper): ActivityStateTree = {
    val treeID = mapper.id
    val organization = activityStateNodeStorage.getAllNodes(treeID).find(_.item.activity.isInstanceOf[Organization]).getOrElse(throw new Exception("No organization found!"))

    new ActivityStateTree(
      organization.item,
      organization.children,
      mapper.currentActivityID,
      mapper.suspendedActivityID,
      globalObjectiveStorage.getAllObjectives(treeID)
    )
  }
}

@deprecated
trait ActivityStateTreeEntityStorage extends ActivityStateTreeStorage with KeyedEntityStorageExt[ActivityStateTree] with EntityStorageExt[ActivityStateTree] {
  def activityStateStorage: ActivityStateStorage

  def activityStateNodeStorage: ActivityStateNodeStorage

  def globalObjectiveStorage: GlobalObjectiveStorage

  override def renew() {
    doRenew()
    globalObjectiveStorage.renew()
    activityStateNodeStorage.renew()
    activityStateStorage.renew()
  }

  def create(attemptID: Int, tree: ActivityStateTree) {
    val treeID = createAndGetID(tree,
      "attemptID" -> attemptID,
      "currentActivityID" -> tree.currentActivity.map(_.item.activity.id),
      "suspendedActivityID" -> tree.suspendedActivity.map(_.item.activity.id))
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

  def get(attemptID: Int): Option[ActivityStateTree] = getOne("attemptID" -> attemptID)

  def modify(attemptID: Int, tree: ActivityStateTree) {
    def updateStates(nodes: Seq[ActivityStateNode]) {
      nodes.foreach(node => {
        activityStateStorage.modify(attemptID, node.item)
        updateStates(node.children)
      })
    }

    modify("attemptID" -> attemptID,
      "currentActivityID" -> tree.currentActivity.map(_.item.activity.id),
      "suspendedActivityID" -> tree.suspendedActivity.map(_.item.activity.id))
    activityStateStorage.modify(attemptID, tree.item)
    updateStates(tree.children)
    tree.globalObjectiveData.foreach(objective => globalObjectiveStorage.modify(attemptID, objective._1, objective._2))
  }
}
