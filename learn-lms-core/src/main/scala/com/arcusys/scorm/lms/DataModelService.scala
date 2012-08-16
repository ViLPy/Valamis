package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.tracking.model._
import com.arcusys.learn.storage.StorageFactoryContract
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import org.joda.time._
import org.joda.time.format.DateTimeFormat

class DataModelService(attempt: Attempt, activityID:String)(implicit val bindingModule: BindingModule) extends Injectable {
  private val storageFactory = inject[StorageFactoryContract]
  private val dataModelStorage = storageFactory.dataModelStorage
  private val treeStateStorage = storageFactory.activityStateTreeStorage

  private val tree = treeStateStorage.get(attempt.id)
  require(tree.isDefined, "Activity State Tree storage should exist")
  //private val currentActivityID = //tree.get.currentActivity.getOrElse(throw new Exception("Trying to use null activity")).item.activity.id
  private val lmsBehavior = new DataModelLMSBehavior(attempt, tree.get, activityID)

  def getValues = {
    dataModelStorage.getKeyedValues(attempt.id, activityID) ++ getLMSValues
  }

  private def getLMSValues = {
    Map("cmi.completion_threshold" -> lmsBehavior.getCompletionThreshold,
      "cmi.launch_data" -> lmsBehavior.getLaunchData,
      "cmi.max_time_allowed" -> lmsBehavior.getMaxTimeAllowed,
      "time_limit_action" -> lmsBehavior.getTimeLimitAction,
      "cmi.scaled_passing_score" -> lmsBehavior.getScaledPassingScore,
      "cmi.completion_status" -> {
        val progressMeasure = getSingle("cmi.progress_measure")
        val currentCompletionStatus = dataModelStorage.getValue(attempt.id, activityID, "cmi.completion_status")
        lmsBehavior.evaluateCompletionStatus(progressMeasure, currentCompletionStatus)
      },
      "cmi.success_status" -> {
        val scaledPassingScore = lmsBehavior.getScaledPassingScore
        val scaledScore = getSingle("cmi.score.scaled")
        val currentSuccessStatus = dataModelStorage.getValue(attempt.id, activityID, "cmi.success_status")
        lmsBehavior.getSuccessStatus(scaledPassingScore, scaledScore, currentSuccessStatus)
      }
    )
  }

  def getValue(key: String) = {
    val preParsedKey = """\.\d+\.""".r replaceAllIn(key, ".n.")
    val parsedKey = if (preParsedKey.indexOf(".n.") > 0) preParsedKey.substring(0, preParsedKey.indexOf(".n.")) else preParsedKey

    if (key.startsWith("cmi.interactions")
      || key.startsWith("cmi.objectives")
      || key.startsWith("cmi.comments_from_learner")
      || key.startsWith("cmi.comments_from_lms")
      || key.startsWith("adl.data")) {
      getCollection(parsedKey)
    } else {
      getSingle(parsedKey)
    }
  }

  def setValue(key: String, value: String) {
    val normalizedKey = """(?<=.)\d(?=.)""".r replaceFirstIn(key, "n")
    normalizedKey match {
      /*read-only*/
      case "cmi.comments_from_learner._children" |
           "cmi.comments_from_learner._count" |
           "cmi.comments_from_lms._children" |
           "cmi.comments_from_lms._count" |
           "cmi.comments_from_lms.n.comment" |
           "cmi.comments_from_lms.n.location" |
           "cmi.comments_from_lms.n.timestamp" |
           "cmi.interactions._children" |
           "cmi.interactions._count" |
           "cmi.interactions.n.objectives._count" |
           "cmi.interactions.n.correct_responses._count" |
           "cmi.objectives._children" |
           "cmi.objectives._count" |
           "cmi.objectives.n.score._children" |
           "cmi.score._children" |
           "adl.data._children" |
           "adl.data._count" |
           "adl.data.n.id" |
           "cmi._version" |
           "cmi.completion_threshold" |
           "cmi.credit" |
           "cmi.entry" |
           "cmi.launch_data" |
           "cmi.learner_id" |
           "cmi.learner_name" |
           "cmi.learner_preference._children" |
           "cmi.max_time_allowed" |
           "cmi.mode" |
           "cmi.scaled_passing_score" |
           "cmi.time_limit_action" | "cmi.total_time" => {
        /*read-only*/
      }
      case "cmi.exit" => {
        // TODO: don't forget about next cases:
        // cmi.exit was set to "suspend" - cmi.entry -> Resume, the LMS shall set the "Activity is Suspended" value of
        //  the learning activity associated with the SCO to true

        // cmi.exit was set to "logout" - cmi.entry -> ab-initio, the LMS shall process a "Exit All" navigation request
        // cmi.exit was set to "time-out" - the LMS shall process an "Exit All" navigation request
        // If set to "suspend" then the SCOs current learner attempt does not end
        // If set to "normal", "logout", "time-out" or "" then the SCOs learner attempt ends
        dataModelStorage.setValue(attempt.id, activityID, key, value)
      }
      case "cmi.session_time" => {
        // TODO: finish this later
        //val totalTime = getSingle("cmi.total_time").getOrElse("P0s").toLong
        dataModelStorage.setValue(attempt.id, activityID, "cmi.total_time", value)
        dataModelStorage.setValue(attempt.id, activityID, key, value)
      }
      case _ => dataModelStorage.setValue(attempt.id, activityID, key, value)
    }
  }

  private def getCollection(key: String): Map[String, Option[String]] = {
    key match {
      // "LMS based" collections
      case "cmi.comments_from_lms" => lmsBehavior.getCommentsFromLMS
      case "cmi.objectives" => lmsBehavior.getObjectives
      case "adl.data" => lmsBehavior.getAdlData
      case _ => {
        dataModelStorage.getCollectionValues(attempt.id, activityID, key)
      }
    }
  }

  private def getSingle(key: String): Option[String] = {
    key match {
      case "cmi.exit" => None
      case "cmi.session_time" => None
      // this can be used as is,  support is not required for SCORM conformance
      case "cmi._version" => Some("1.0")
      case "cmi.credit" => Some("credit")
      case "cmi.mode" => Some("normal")
      // "LMS based" for single values
      case "cmi.completion_threshold" => lmsBehavior.getCompletionThreshold
      case "cmi.completion_status" => {
        val progressMeasure = getSingle("cmi.progress_measure")
        val currentCompletionStatus = dataModelStorage.getValue(attempt.id, activityID, "cmi.completion_status")
        lmsBehavior.evaluateCompletionStatus(progressMeasure, currentCompletionStatus)
      }
      case "cmi.entry" => lmsBehavior.getEntry
      case "cmi.launch_data" => lmsBehavior.getLaunchData
      case "cmi.max_time_allowed" => lmsBehavior.getMaxTimeAllowed
      case "cmi.scaled_passing_score" => lmsBehavior.getScaledPassingScore
      case "cmi.success_status" => {
        val scaledPassingScore = lmsBehavior.getScaledPassingScore
        val scaledScore = getSingle("cmi.score.scaled")
        val currentSuccessStatus = dataModelStorage.getValue(attempt.id, activityID, "cmi.success_status")
        lmsBehavior.getSuccessStatus(scaledPassingScore, scaledScore, currentSuccessStatus)
      }
      case "time_limit_action" => lmsBehavior.getTimeLimitAction
      // learner data can be taken from attempt
      case "cmi.learner_id" => Some(attempt.user.id.toString)
      case "cmi.learner_name" => Some(attempt.user.name)
      case "cmi.learner_preference.audio_level" => Some(attempt.user.preferredAudioLevel.toString)
      case "cmi.learner_preference.language" => Some(attempt.user.preferredLanguage.toString)
      case "cmi.learner_preference.delivery_speed" => Some(attempt.user.preferredDeliverySpeed.toString)
      case "cmi.learner_preference.audio_captioning" => Some(attempt.user.preferredAudioCaptioning.toString)
      // for other variables just fetch from DB
      case _ => {
        dataModelStorage.getValue(attempt.id, activityID, key)
      }
    }
  }

}
