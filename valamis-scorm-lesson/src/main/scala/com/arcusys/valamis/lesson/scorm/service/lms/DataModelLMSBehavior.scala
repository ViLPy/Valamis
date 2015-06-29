package com.arcusys.valamis.lesson.scorm.service.lms

import com.arcusys.valamis.lesson.scorm.model.manifest.{ LeafActivity, Objective }
import com.arcusys.valamis.lesson.scorm.model.tracking.{ ActivityState, Attempt }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class DataModelLMSBehavior(attempt: Attempt, currentActivity: Option[ActivityState])(implicit val bindingModule: BindingModule) extends Injectable {

  def getCompletionThreshold: Option[String] = {
    currentActivity match {
      case Some(activity) =>
        if (activity.activity.completionThreshold.completedByMeasure) Some(activity.activity.completionThreshold.minProgressMeasure.toString())
        else None
      case None => None
    }
  }

  // SCORM 1.2
  def getMasteryScore: Option[String] = {
    currentActivity match {
      case Some(activity) if activity.activity.isInstanceOf[LeafActivity] =>
        activity.activity.asInstanceOf[LeafActivity].masteryScore
      case None => None
    }
  }

  // SCORM 1.2
  def getMaxTimeAllowed12: Option[String] = {
    currentActivity match {
      case Some(activity) if activity.activity.isInstanceOf[LeafActivity] =>
        activity.activity.asInstanceOf[LeafActivity].maxTimeAllowed
      case None => None
    }
  }

  /**
   * Refers to "Completion Status Evaluation" from SCORM RTE book
   */
  def evaluateCompletionStatus(progressMeasure: Option[String], currentCompletionStatus: Option[String]): Option[String] = {
    val completionThreshold = getCompletionThreshold
    if (completionThreshold == None) currentCompletionStatus
    else {
      if (progressMeasure == None) None
      else {
        if (progressMeasure.get.toDouble >= completionThreshold.get.toDouble) Some("completed")
        else Some("incomplete")
      }
    }
  }

  def getEntry: Option[String] = {
    require(currentActivity.isDefined, "Current activity should exist")

    if (currentActivity.get.getCompletionStatus().isEmpty) Some("ab-initio")
    else if (currentActivity.get.suspended) Some("resume")
    else None
  }

  def getLaunchData: Option[String] =
    currentActivity.get.activity match {
      case leaf: LeafActivity => leaf.dataFromLMS
      case _                  => None
    }

  def getMaxTimeAllowed: Option[String] =
    currentActivity match {
      case Some(activity) => {
        if (activity.activity.sequencing.durationLimitInMilliseconds.isDefined) Some(activity.activity.sequencing.durationLimitInMilliseconds.get.toString)
        else None
      }
      case _ => None
    }

  def getSuccessStatus(scaledPassingScore: Option[String], scaledScore: Option[String], successStatus: Option[String]): Option[String] = {
    if (scaledPassingScore.isEmpty) {
      successStatus
    } else {
      if (scaledScore.isEmpty) {
        None
      } else {
        if (scaledPassingScore.get >= scaledScore.get) Some("failed")
        else Some("passed")
      }
    }
  }

  def getTimeLimitAction: Option[String] =
    currentActivity.get.activity match {
      case activity: LeafActivity =>
        if (activity.timeLimitAction.isDefined) Some(activity.timeLimitAction.get.toString)
        else None
      case _ => None
    }

  def getScaledPassingScore: Option[String] = {
    currentActivity match {
      case Some(activity) =>
        if (activity.activity.sequencing.primaryObjective.isDefined && activity.activity.sequencing.primaryObjective.get.satisfiedByMeasure)
          Some(activity.activity.sequencing.primaryObjective.get.minNormalizedMeasure.toString)
        else None
      case None => None
    }
  }

  def getCommentsFromLMS = {
    // This support is not required for SCORM conformance
    Map[String, Option[String]]("cmi.comments_from_lms._count" -> Some("0"))
  }

  def getAdlData = {
    def nameGen(key: String, id: Int) = """(?<=.)n(?=.)""".r replaceFirstIn (key, id.toString)

    currentActivity.get.activity match {
      case activity: LeafActivity => {
        activity.data.zipWithIndex.map(e => nameGen("adl.data.n.id", e._2) -> Some(e._1.targetId)).toMap ++
          Map("adl.data._count" -> Some(activity.data.size.toString))
      }
      case _ => Map[String, Option[String]]("adl.data._count" -> Some("0"))
    }
  }

  def getObjectives = {
    currentActivity match {
      case Some(activity) => {
        val objectives = activity.activity.sequencing.primaryObjective match {
          case Some(obj) if obj.id.isDefined => Seq(obj) ++ activity.activity.sequencing.nonPrimaryObjectives
          case _                             => activity.activity.sequencing.nonPrimaryObjectives
        }
        objectives.zipWithIndex.foldLeft(Map[String, Option[String]]())((result, item) => result ++ objectiveSerializer(item._1, item._2)) ++
          Map("cmi.objectives._count" -> Some(objectives.size.toString))
      }
      case _ => Map[String, Option[String]]("cmi.objectives._count" -> Some("0"))
    }
  }

  private def objectiveSerializer(objective: Objective, id: Int): Map[String, Option[String]] = {
    def nameGen(key: String) = """(?<=.)n(?=.)""".r replaceFirstIn (key, id.toString)

    Map(nameGen("cmi.objectives.n.id") -> objective.id,
      nameGen("cmi.objectives.n.score._children") -> Some("scaled,raw,min,max"),
      nameGen("cmi.objectives.n.score.scaled") -> Some(""),
      nameGen("cmi.objectives.n.score.raw") -> Some(""),
      nameGen("cmi.objectives.n.score.min") -> Some(""),
      nameGen("cmi.objectives.n.score.max") -> Some(""),
      nameGen("cmi.objectives.n.success_status") -> None,
      nameGen("cmi.objectives.n.completion_status") -> None,
      nameGen("cmi.objectives.n.progress_measure") -> Some(""),
      nameGen("cmi.objectives.n.description") -> Some("")
    )
  }
}
