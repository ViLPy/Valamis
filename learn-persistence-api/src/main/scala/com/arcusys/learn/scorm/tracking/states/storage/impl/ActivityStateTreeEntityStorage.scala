package com.arcusys.learn.scorm.tracking.states.storage.impl

import com.arcusys.valamis.lesson.scorm.model.manifest.Organization
import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateTree
import com.arcusys.valamis.lesson.scorm.storage.tracking.{ GlobalObjectiveStorage, ActivityStateNodeStorage }

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
