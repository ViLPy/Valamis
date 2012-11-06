package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, ActivityStateNode}
import com.arcusys.learn.scorm.tracking.states.storage.ActivityStateTreeStorage
import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageImpl
import org.orbroker.Row

class ActivityStateTreeStorageImpl extends KeyedEntityStorageImpl[ActivityStateTree]("ActivityStateTree", "id") with ActivityStateTreeStorage {
  private val activityStateStorage = new ActivityStateStorageImpl
  private val activityStateNodeStorage = new ActivityStateNodeStorageImpl
  private val globalObjectiveStorage = new GlobalObjectiveStorageImpl

  def create(attemptID: Int, tree: ActivityStateTree) {
    val treeID = createAndGetID(tree,
      "attemptID" -> attemptID,
      "currentActivityID" -> tree.currentActivity.map(_.item.activity.id),
      "suspendedActivityID" -> tree.suspendedActivity.map(_.item.activity.id))
    val organizationID = activityStateNodeStorage.createAndGetID(treeID, None, tree)
    //activityStateStorage.createOrganization(treeID, tree.item)

    def createStates(parentID: Option[Int], nodes: Seq[ActivityStateNode]) {
      nodes.foreach(node => {
        val id = activityStateNodeStorage.createAndGetID(treeID, parentID, node)
        createStates(Some(id), node.children)
      })
    }
    tree.globalObjectiveData.foreach(objective=>globalObjectiveStorage.create(treeID, objective._1, objective._2))
    createStates(Some(organizationID), tree.children)
  }

  override def renew() {
    super.renew()
    globalObjectiveStorage.renew()
    activityStateNodeStorage.renew()
    activityStateStorage.renew()
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
    tree.globalObjectiveData.foreach(objective=>globalObjectiveStorage.modify(attemptID, objective._1, objective._2))
  }

  def extract(row: Row) = {
    val treeID = row.integer("id").get
    val organization = activityStateNodeStorage.getAllNodes(treeID)//activityStateStorage.getOrganization(treeID)
    //require(organization.isDefined, "Tree should contain organization!")

    new ActivityStateTree(
      organization.head.item,
      organization.head.children,
      row.string("currentActivityID"),
      row.string("suspendedActivityID"),
      globalObjectiveStorage.getAllObjectives(treeID)
    )
  }
}
