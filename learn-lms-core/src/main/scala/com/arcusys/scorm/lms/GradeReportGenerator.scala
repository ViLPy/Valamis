package com.arcusys.scorm.lms

import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import com.arcusys.learn.scorm.tracking.model._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.util.TreeNode

class GradeReportGenerator {
  val activityStorage = StorageFactory.activityStorage
  val activityTreeStorage = StorageFactory.activityStateTreeStorage
  val attemptStorage = StorageFactory.attemptStorage
  val dataModelStorage = StorageFactory.dataModelStorage

  private def get(attempt: Attempt, organizationID: String) = {
    val grades = dataModelStorage.getValuesByKey(attempt.id, "cmi.success_status") ++ dataModelStorage.getValuesByKey(attempt.id, "cmi.core.lesson_status")
    val responseTypes = dataModelStorage.getValuesByKey(attempt.id, "cmi.interactions.0.type")
    val responses = dataModelStorage.getValuesByKey(attempt.id, "cmi.interactions.0.learner_response")
    val texts = dataModelStorage.getValuesByKey(attempt.id, "cmi.interactions.0.description")
    val score = dataModelStorage.getValuesByKey(attempt.id, "cmi.score.scaled")
    val essayComment = dataModelStorage.getValuesByKey(attempt.id, "cmi.essay_comment")
    val tree = activityTreeStorage.get(attempt.id)

    def parseActivity(activity: TreeNode[Activity]): GradeReportNode = activity.item match {
      case organization: Organization => new GradeReportRoot(organization, activity.children.filter(_.item.sequencing.tracking.isDefined) map parseActivity,
        if(essayComment.get(organization.id)!=None) essayComment.get(organization.id).get.get else "", attempt.packageID)
      case container: ContainerActivity => new GradeReportBranch(container, activity.children.filter(_.item.sequencing.tracking.isDefined) map parseActivity,
        if(essayComment.get(container.id)!=None) essayComment.get(container.id).get.get else "", attempt.packageID)
      case leaf: LeafActivity => new GradeReportLeaf(leaf,
        if (grades.isEmpty || grades.get(leaf.id) == None || grades.get(leaf.id).get.get.equals("unknown")){
          None
        }
        else {
          Some(score.get(leaf.id).get.get.toDouble)
        },
        texts.get(leaf.id).getOrElse(None),
        responseTypes.get(leaf.id).getOrElse(None) match {
          case Some("long_fill_in") => responses.get(leaf.id).getOrElse(Some(""))
          case _ => None
        }, attemptCompleted = {
          tree match {
            case Some(e) => e.apply(leaf.id) match {
              case Some(n) => n.item.attemptCompleted.getOrElse(false)
              case _ => false
            }
            case _ => false
          }
        },
        if(essayComment.get(leaf.id)!=None) essayComment.get(leaf.id).get.get else "",
        attempt.packageID)
    }
    parseActivity(activityStorage.getOrganizationTree(attempt.packageID, organizationID))
  }

  def getForCurrentAttempt(userID: Int, packageID: Int) = {
    attemptStorage.getLast(userID, packageID, complete = true).map {
      activeAttempt =>
        val organizations = activityStorage.getAllOrganizations(activeAttempt.packageID)
        //TODO: doesn't work for multiple organizations yet
        if (organizations.size != 1) throw new IllegalStateException
        get(activeAttempt, organizations.head.id)
    }
  }
}
