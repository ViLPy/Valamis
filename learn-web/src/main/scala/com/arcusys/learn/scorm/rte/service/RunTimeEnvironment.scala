package com.arcusys.learn.scorm.rte.service

import org.scalatra.CookieSupport
import com.arcusys.scorm.lms.DataModelService

import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, ActivityStateNode, ObjectiveState, ActivityState}

class RunTimeEnvironment(configuration: BindingModule) extends ServletBase(configuration) with CookieSupport {
  def this() = this(Configuration)

  import storageFactory._

  //private val API = new APIImpl()

  post("/Initialize") {
    val userID = try {
      request.getHeader("scormUserID").toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("packageID").intRequired
    val organizationID = parameter("organizationID").required
    val currentAttempt = attemptStorage.getActive(userID, packageID) match {
      case Some(attempt) => attempt
      case None => {
        attemptStorage.createAndGetID(userID, packageID, organizationID)
        attemptStorage.getLast(userID, packageID).getOrElse(halt(404, "Okay. Check DB connection."))
      }
    }
    val stateTree = activityStateTreeStorage.get(currentAttempt.id)
    if (stateTree.isEmpty) {
      val stateTree = ActivityStateTree(activityStorage.getOrganizationTree(currentAttempt.packageID, currentAttempt.organizationID), None, true, None)
      activityStateTreeStorage.create(currentAttempt.id, stateTree)
      json("status" -> false)
    } else {
      json("status" -> true)
    }
  }

  get("/GetValue/:key") {
    val userID = try {
      request.getHeader("scormUserID").toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("activityID").required
    val currentAttempt = attemptStorage.getLast(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))

    val dataModel = new DataModelService(currentAttempt, activityID)
    json(dataModel.getValue(parameter("key").required))
  }

  get("/GetValues") {
    val userID = try {
      request.getHeader("scormUserID").toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("activityID").required
    val currentAttempt = attemptStorage.getLast(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))

    val dataModel = new DataModelService(currentAttempt, activityID)
    json(dataModel.getValues)
  }

  post("/SetValue") {
    val value = parameter("value").required
    val userID = try {
      request.getHeader("scormUserID").toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("activityID").required
    val currentAttempt = attemptStorage.getLast(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))

    val dataModel = new DataModelService(currentAttempt, activityID)
    dataModel.setValue(parameter("key").required, value)
  }

  post("/SetValues") {
    val userID = try {
      request.getHeader("scormUserID").toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("activityID").required
    val currentAttempt = attemptStorage.getLast(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))

    val amount = parameter("amount").intRequired
    val dataModel = new DataModelService(currentAttempt, activityID)
    (0 until amount).foreach(index => {
      dataModel.setValue(parameter("dataKey" + index).required, parameter("dataValue" + index).required)
    })
  }

  get("/ActivityInformation/:activityID") {
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

    val userID = try {
      request.getHeader("scormUserID").toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("packageID").intRequired
    val attempt = attemptStorage.getLast(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))
    val tree = activityStateTreeStorage.get(attempt.id).getOrElse(throw new Exception("Activity tree should exist!"))
    //val tree = ActivityStateTree(activityStorage.getOrganizationTree(attempt.packageID, attempt.organizationID), attempt.currentActivityID, currentActive = false, suspendedActivityID = attempt.suspendedActivityID)
    val activity = tree(parameter("activityID").required)
    json(Map("attemptProgressStatus" -> activity.get.item.getCompletionStatus().isEmpty,
      "attemptCompletionStatus" -> activity.get.item.getCompletionStatus(),
      "attemptCompletionAmount" -> activity.get.item.attemptCompletionAmount,
      "isActivitySuspended" -> activity.get.item.suspended,
      "primaryObjective" -> serializePrimaryObjective(activity.get.item),
      "activityObjectives" -> activity.get.item.activity.sequencing.nonPrimaryObjectives.map(objective =>
        serializeObjective(objective.id, activity.get.item.objectiveStates(objective.id)))
    ))
  }

  post("/ActivityInformation/:activityID") {
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

    val userID = try {
      request.getHeader("scormUserID").toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("packageID").intRequired
    val attempt = attemptStorage.getLast(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))
    val tree = activityStateTreeStorage.get(attempt.id).getOrElse(throw new Exception("Activity tree should exist!"))
    //ActivityStateTree(activityStorage.getOrganizationTree(attempt.packageID, attempt.organizationID), attempt.currentActivityID, currentActive = false, suspendedActivityID = attempt.suspendedActivityID)
    val activity = tree(parameter("activityID").required)

    activity.get.item.setCompletionStatus(parameter("attemptCompletionStatus").booleanOption("null"))
    activity.get.item.attemptCompletionAmount = parameter("attemptCompletionAmount").bigDecimalOption("null")
    activity.get.item.suspended = parameter("isActivitySuspended").booleanRequired
    val activityObjectivesCount = parameter("activityObjectivesCount").intRequired
    deserializePrimaryObjective(activity.get)
    (0 until activityObjectivesCount).foreach(index => deserializeNonPrimaryObjective(activity.get, index.toString))
    activityStateTreeStorage.modify(attempt.id, tree)
  }

  post("/Commit") {

  }
}
