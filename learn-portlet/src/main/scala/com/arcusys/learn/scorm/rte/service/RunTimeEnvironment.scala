package com.arcusys.learn.scorm.rte.service

import com.arcusys.learn.bl.services.lesson.ActivityServiceContract
import com.arcusys.learn.controllers.api.BaseApiController
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.scorm.tracking.model.{ ActivityState, ActivityStateNode, ObjectiveState }
import com.arcusys.learn.service.util.AntiSamyHelper
import com.arcusys.learn.web.ServletBase
import com.arcusys.scorm.lms.DataModelService
import com.escalatesoft.subcut.inject.BindingModule
import org.scalatra.{ CookieSupport, SinatraRouteMatcher }

class RunTimeEnvironment(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase with CookieSupport {
  def this() = this(Configuration)
  //next line fixes 404
  implicit override def string2RouteMatcher(path: String) = new SinatraRouteMatcher(path)

  private val activityManager = inject[ActivityServiceContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  post("/rte/Initialize") {
    val userID = getUserId.toInt
    val packageID = parameter("packageID").intRequired
    val organizationID = parameter("organizationID").required
    val currentAttempt = activityManager.getActiveAttempt(userID, packageID, organizationID)

    val stateTree = activityManager.getActivityStateTreeForAttemptOption(currentAttempt)
    if (stateTree.isEmpty) {
      activityManager.createActivityStateTreeForAttempt(currentAttempt)
      json("status" -> false).get
    } else {
      json("status" -> true).get
    }
  }

  get("/rte/GetValue/:key") {
    val userID = getUserId.toInt
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("activityID").required
    val currentAttempt = activityManager.getLastAttempltOption(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))

    val dataModel = new DataModelService(currentAttempt, activityID)
    json(dataModel.getValue(parameter("key").required)).get
  }

  get("/rte/GetValues") {
    val userID = getUserId.toInt
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("activityID").required
    val currentAttempt = activityManager.getLastAttempltOption(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))

    val dataModel = new DataModelService(currentAttempt, activityID)
    json(dataModel.getValues).get
  }

  post("/rte/SetValue") {
    val userID = getUserId.toInt
    val value = AntiSamyHelper.sanitize(parameter("value").required)
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("activityID").required
    val currentAttempt = activityManager.getLastAttempltOption(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))

    val dataModel = new DataModelService(currentAttempt, activityID)
    dataModel.setValue(parameter("key").required, value)
  }

  post("/rte/SetValues") {
    val userID = getUserId.toInt
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("activityID").required
    val currentAttempt = activityManager.getLastAttempltOption(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))

    val amount = parameter("amount").intRequired
    val dataModel = new DataModelService(currentAttempt, activityID)
    (0 until amount).foreach(index => {
      dataModel.setValue(parameter("dataKey" + index).required, parameter("dataValue" + index).required)
    })
  }

  get("/rte/ActivityInformation/:activityID") {
    def serializeObjective(id: Option[String], state: ObjectiveState) = {
      Some(
        Map("identifier" -> id,
          "objectiveProgressStatus" -> state.getSatisfiedStatus.isDefined,
          "objectiveSatisfiedStatus" -> state.getSatisfiedStatus,
          "objectiveMeasureStatus" -> state.getNormalizedMeasure.isDefined,
          "objectiveNormalizedMeasure" -> state.getNormalizedMeasure
        )
      )
    }

    def serializePrimaryObjective(activityState: ActivityState) = {
      val primaryObjective = activityState.activity.sequencing.primaryObjective
      if (primaryObjective.isDefined) {
        val primaryObjectiveState = activityState.objectiveStates(None)
        serializeObjective(primaryObjective.get.id, primaryObjectiveState)
      } else {
        None
      }
    }

    val userID = getUserId.toInt
    val packageID = parameter("packageID").intRequired
    val attempt = activityManager.getLastAttempltOption(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))
    val tree = activityManager.getActivityStateTreeForAttemptOption(attempt).get //OrElse(throw new Exception("Activity tree should exist!"))
    val activity = tree(parameter("activityID").required)
    json(Map("attemptProgressStatus" -> activity.get.item.getCompletionStatus().isEmpty,
      "attemptCompletionStatus" -> activity.get.item.getCompletionStatus(),
      "attemptCompletionAmount" -> activity.get.item.attemptCompletionAmount,
      "isActivitySuspended" -> activity.get.item.suspended,
      "primaryObjective" -> serializePrimaryObjective(activity.get.item),
      "activityObjectives" -> activity.get.item.activity.sequencing.nonPrimaryObjectives.map(objective =>
        serializeObjective(objective.id, activity.get.item.objectiveStates(objective.id)))
    )).get
  }

  post("/rte/ActivityInformation/:activityID") {
    def deserializeObjective(base: String, state: ObjectiveState) {
      state.setSatisfiedStatus(parameter(base + "[objectiveProgressStatus]").booleanOption("null"))
      state.setNormalizedMeasure(parameter(base + "[objectiveNormalizedMeasure]").bigDecimalOption("null"))
    }

    def deserializePrimaryObjective(activity: ActivityStateNode) {
      val activityState = activity.item
      val primaryObjective = activityState.activity.sequencing.primaryObjective
      if (primaryObjective.isDefined) {
        val primaryObjectiveState = activityState.objectiveStates(None)
        deserializeObjective("primaryObjective", primaryObjectiveState)
      }
    }

    def deserializeNonPrimaryObjective(activity: ActivityStateNode, index: String) {
      val activityState = activity.item
      val id = parameter("activityObjectives[" + index + "][identifier]").required
      val objectiveState = activityState.objectiveStates(Some(id))
      deserializeObjective("activityObjectives[" + index + "]", objectiveState)
    }

    val userID = getUserId.toInt
    val packageID = parameter("packageID").intRequired
    val attempt = activityManager.getLastAttempltOption(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))
    val tree = activityManager.getActivityStateTreeForAttemptOption(attempt).getOrElse(throw new Exception("Activity tree should exist!"))
    val activity = tree(parameter("activityID").required)

    activity.get.item.setCompletionStatus(parameter("attemptCompletionStatus").booleanOption("null"))
    activity.get.item.attemptCompletionAmount = parameter("attemptCompletionAmount").bigDecimalOption("null")
    activity.get.item.suspended = parameter("isActivitySuspended").booleanRequired
    val activityObjectivesCount = parameter("activityObjectivesCount").intRequired
    deserializePrimaryObjective(activity.get)
    (0 until activityObjectivesCount).foreach(index => deserializeNonPrimaryObjective(activity.get, index.toString))
    activityManager.updateActivityStateTree(attempt.id, tree)
  }

  post("/rte/Commit") {

  }
}
