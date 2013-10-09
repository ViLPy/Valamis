package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.tracking.model._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.util.TreeNode
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.questionbank.model.{ChoiceAnswer, ChoiceQuestion}
import com.arcusys.learn.quiz.model.QuestionBankQuizQuestion

class GradeReportGenerator(implicit val bindingModule: BindingModule) extends Injectable {
  val storageFactory = inject[StorageFactoryContract]
  val activityStorage = storageFactory.activityStorage
  val activityTreeStorage = storageFactory.activityStateTreeStorage
  val attemptStorage = storageFactory.attemptStorage
  val dataModelStorage = storageFactory.dataModelStorage
  val questionStorage = storageFactory.questionStorage
  val quizQuestionStorage = storageFactory.quizQuestionStorage

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
        if (essayComment.get(organization.id) != None) essayComment.get(organization.id).get.get else "", attempt.packageID)
      case container: ContainerActivity => new GradeReportBranch(container, activity.children.filter(_.item.sequencing.tracking.isDefined) map parseActivity,
        if (essayComment.get(container.id) != None) essayComment.get(container.id).get.get else "", attempt.packageID)
      case leaf: LeafActivity => new GradeReportLeaf(leaf,
        if (grades.isEmpty || grades.get(leaf.id) == None || grades.get(leaf.id).get.get.equals("unknown")) {
          None
        } else {
          Some(score.get(leaf.id).get.get.toDouble)
        },
        texts.get(leaf.id).getOrElse(None),
        responseTypes.get(leaf.id).getOrElse(None) match {
          case Some("long_fill_in") => responses.get(leaf.id).getOrElse(Some(""))
          case Some("numeric") => responses.get(leaf.id).getOrElse(Some(""))
          case Some("choice") => {
            val responses_splitted = responses.get(leaf.id).getOrElse(Some("")).getOrElse("").split("\\[,\\]").filter(_!="").map(response =>  response.toInt)
            val question_num = leaf.id.drop("question".length).toInt
            val avail_answers = quizQuestionStorage.getByID(question_num).get match {
              case questionBankQuizQuestion: QuestionBankQuizQuestion =>
                questionBankQuizQuestion.question.answers
              case _ => throw new IllegalArgumentException
            }
            val userAnswers = avail_answers.filter(ans => responses_splitted.contains(ans.id))
            val stringBuilder = new StringBuilder()
            userAnswers.foreach(answer => answer match {
              case choiceAnswer: ChoiceAnswer => stringBuilder.append(choiceAnswer.text)
              case _ => throw new IllegalArgumentException
            })
            Option(stringBuilder.toString())
          }
          case Some("matching") => {
            if (responses.get(leaf.id).getOrElse(Some("")).getOrElse("").length > 0) {
              val twoArrays = responses.get(leaf.id).getOrElse(Some("")).get.replaceAll("</*p>", "").split("\\[,\\]").map(x => x.split("\\[.\\]"))
              val grouped = twoArrays.groupBy(_(0))
              val convertedHtmlString = grouped.map(g => "<p>" + g._1 + ": " + g._2.map(g => if (g.length > 1) g(1) else "").mkString(", ") + "</p>").mkString("")
              Option(convertedHtmlString)
            }
            else Option("")
          }
          case Some("fill_in") => responses.get(leaf.id).getOrElse(Some(""))
          case Some("sequencing") => Option(responses.get(leaf.id).getOrElse(Some("")).getOrElse("").replace("[,]", ""))

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
        essayCommentText = if (essayComment.get(leaf.id).isDefined && essayComment.get(leaf.id).get.isDefined) essayComment.get(leaf.id).get.get else "",
        packID = attempt.packageID,
        responseTypes.get(leaf.id).getOrElse(Some("")))
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
