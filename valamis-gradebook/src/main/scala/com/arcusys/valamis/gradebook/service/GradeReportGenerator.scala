package com.arcusys.valamis.gradebook.service

import com.arcusys.valamis.lesson.scorm.model.manifest.{ LeafActivity, ContainerActivity, Organization, Activity }
import com.arcusys.valamis.lesson.scorm.model.tracking.Attempt
import com.arcusys.valamis.lesson.scorm.storage.ActivityStorage
import com.arcusys.valamis.lesson.scorm.storage.tracking.{ ActivityStateTreeStorage, AttemptStorage, DataModelStorage }
import com.arcusys.valamis.questionbank.storage.QuestionStorage
import com.arcusys.valamis.quiz.storage.QuizQuestionStorage
import com.arcusys.valamis.util.TreeNode
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class GradeReportGenerator(implicit val bindingModule: BindingModule) extends Injectable {
  val activityRepository = inject[ActivityStorage]
  val activityTreeStorage = inject[ActivityStateTreeStorage]
  val attemptStorage = inject[AttemptStorage]
  val dataModelStorage = inject[DataModelStorage]
  val questionStorage = inject[QuestionStorage]
  val quizQuestionStorage = inject[QuizQuestionStorage]

  private def get(attempt: Attempt, organizationID: String) = {
    val grades = dataModelStorage.getValuesByKey(attempt.id, "cmi.success_status") ++ dataModelStorage.getValuesByKey(attempt.id, "cmi.core.lesson_status")
    val responseTypes = dataModelStorage.getValuesByKey(attempt.id, "cmi.interactions.0.type")
    val responses = dataModelStorage.getValuesByKey(attempt.id, "cmi.interactions.0.learner_response")
    val texts = dataModelStorage.getValuesByKey(attempt.id, "cmi.interactions.0.description")
    val score = dataModelStorage.getValuesByKey(attempt.id, "cmi.score.scaled")
    val scoreRaw = dataModelStorage.getValuesByKey(attempt.id, "cmi.core.score.raw")
    val scoreMin = dataModelStorage.getValuesByKey(attempt.id, "cmi.core.score.min")
    val scoreMax = dataModelStorage.getValuesByKey(attempt.id, "cmi.core.score.max")
    val essayComment = dataModelStorage.getValuesByKey(attempt.id, "cmi.essay_comment")
    val tree = activityTreeStorage.get(attempt.id)

    def parseActivity(activity: TreeNode[Activity]): GradeReportNode = activity.item match {
      case organization: Organization => new GradeReportRoot(organization, activity.children.filter(_.item.sequencing.tracking.isDefined) map parseActivity,
        if (essayComment.get(organization.id) != None) essayComment.get(organization.id).get.get else "", attempt.packageID)
      case container: ContainerActivity => new GradeReportBranch(container, activity.children.filter(_.item.sequencing.tracking.isDefined) map parseActivity,
        if (essayComment.get(container.id) != None) essayComment.get(container.id).get.get else "", attempt.packageID)
      case leaf: LeafActivity => new GradeReportLeaf(leaf,
        if (grades.isEmpty || grades.get(leaf.id) == None || grades.get(leaf.id).get.get.equals("unknown")) {
          None
        } else if (score.contains(leaf.id)) {
          Some(score.get(leaf.id).get.get.toDouble)
        } else if (scoreRaw.contains(leaf.id) && scoreMax.contains(leaf.id) && scoreMin.contains(leaf.id)) {
          val raw = scoreRaw.get(leaf.id).get.get.toDouble
          val min = scoreMin.get(leaf.id).get.get.toDouble
          val max = scoreMax.get(leaf.id).get.get.toDouble
          Some((raw - min) / (max - min))
        } else {
          None
        },
        texts.get(leaf.id).getOrElse(None),
        responseTypes.get(leaf.id).getOrElse(None) match {
          case Some("long_fill_in") => responses.get(leaf.id).getOrElse(Some(""))
          case Some("numeric")      => responses.get(leaf.id).getOrElse(Some(""))
          case Some("choice")       => responses.get(leaf.id).getOrElse(Some("")).map(_.replace("[,]", ""))
          case Some("matching") => {
            if (responses.get(leaf.id).getOrElse(Some("")).getOrElse("").length > 0) {
              val twoArrays = responses.get(leaf.id).getOrElse(Some("")).get.replaceAll("</*p>", "").split("\\[,\\]").map(x => x.split("\\[.\\]"))
              val grouped = twoArrays.groupBy(_(0))
              val convertedHtmlString = grouped.map(g => "<p>" + g._1 + ": " + g._2.map(g => if (g.length > 1) g(1) else "").mkString(", ") + "</p>").mkString("")
              Option(convertedHtmlString)
            } else Option("")
          }
          case Some("fill_in")    => responses.get(leaf.id).getOrElse(Some(""))
          case Some("sequencing") => Option(responses.get(leaf.id).getOrElse(Some("")).getOrElse("").replace("[,]", ""))

          case _                  => None
        }, attemptCompleted = {
          tree match {
            case Some(e) => e.apply(leaf.id) match {
              case Some(n) => n.item.attemptCompleted.getOrElse(false)
              case _       => false
            }
            case _ => false
          }
        },
        essayCommentText = if (essayComment.get(leaf.id).isDefined && essayComment.get(leaf.id).get.isDefined) essayComment.get(leaf.id).get.get else "",
        packID = attempt.packageID,
        responseTypes.get(leaf.id).getOrElse(Some("")))
    }
    parseActivity(activityRepository.getOrganizationTree(attempt.packageID, organizationID))
  }

  def getForCurrentAttempt(userID: Int, packageID: Int) = {
    attemptStorage.getLast(userID, packageID, complete = true).map {
      activeAttempt =>
        val organizations = activityRepository.getAllOrganizations(activeAttempt.packageID)
        //TODO: doesn't work for multiple organizations yet
        if (organizations.size != 1) throw new IllegalStateException
        get(activeAttempt, organizations.head.id)
    }
  }
}
