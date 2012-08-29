package com.arcusys.scorm.lms

import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import com.arcusys.learn.scorm.tracking.model._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.util.TreeNode

class GradeReportGenerator {
  val activityStorage = StorageFactory.activityStorage
  val attemptStorage = StorageFactory.attemptStorage
  val dataModelStorage = StorageFactory.dataModelStorage

  private def get(attempt: Attempt, organizationID: String) = {
    val grades = dataModelStorage.getValuesByKey(attempt.id, "cmi.success_status")
    val responseTypes = dataModelStorage.getValuesByKey(attempt.id, "cmi.interactions.0.type")
    val responses = dataModelStorage.getValuesByKey(attempt.id, "cmi.interactions.0.learner_response")
    val texts = dataModelStorage.getValuesByKey(attempt.id, "cmi.interactions.0.description")

    def parseActivity(activity: TreeNode[Activity]): GradeReportNode = activity.item match {
      case organization: Organization => new GradeReportRoot(organization, activity.children.filter(_.item.sequencing.tracking.isDefined) map parseActivity)
      case container: ContainerActivity => new GradeReportBranch(container, activity.children.filter(_.item.sequencing.tracking.isDefined) map parseActivity)
      case leaf: LeafActivity => new GradeReportLeaf(leaf,
        grades.get(leaf.id).getOrElse(None) match {
          case Some("passed") => Some(true)
          case Some("failed") => Some(false)
          case _ => None
        },
        texts.get(leaf.id).getOrElse(None),
        responseTypes.get(leaf.id).getOrElse(None) match {
          case Some("long_fill_in") => responses.get(leaf.id).getOrElse(Some(""))
          case _ => None
        })
    }

    parseActivity(activityStorage.getOrganizationTree(attempt.packageID, organizationID))
  }

  def getForCurrentAttempt(userID: Int, packageID: Int) = {
    attemptStorage.getLast(userID, packageID, complete = true).map {
      activeAttempt =>
        val organizations = activityStorage.getAllOrganizations(activeAttempt.packageID)
        //TODO: doesn't work for multiple orgs yet
        if (organizations.size != 1) throw new IllegalStateException
        get(activeAttempt, organizations.head.id)
    }
  }
}
