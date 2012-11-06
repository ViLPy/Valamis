package com.arcusys.learn.scorm.tracking.model

import com.arcusys.learn.scorm.manifest.model._
import scala.collection.mutable

class GlobalObjectiveState
(
  var satisfied: Option[Boolean],
  var normalizedMeasure: Option[BigDecimal],
  var attemptCompleted: Option[Boolean])

/**
 * Information regarding satisfaction and measure (score).
 * These metrics are always associated with objectives. This data is associated with one attempt on the activity.
 * @param satisfied         Indicates the objective is satisfied (if known)
 * @param normalizedMeasure The measure (e.g., standardized score) for the objective (if any), normalized between -1..1 (inclusive)
 */
class ObjectiveState
(
  var satisfied: Option[Boolean],
  var normalizedMeasure: Option[BigDecimal],
  val objectiveMapInfo: ObjectiveMap = ObjectiveMap.Empty
  ) {
  var globalObjectiveData: mutable.Map[String, GlobalObjectiveState] = mutable.Map()
  setSatisfiedStatus(satisfied)
  setNormalizedMeasure(normalizedMeasure)

  // global objective data getter and setter
  def getSatisfiedStatus = {
    val readStatusFrom = objectiveMapInfo.readSatisfiedStatusFrom
    if (readStatusFrom.isDefined) {
      globalObjectiveData.get(readStatusFrom.get).getOrElse({
        globalObjectiveData(readStatusFrom.get) = new GlobalObjectiveState(None, None, None)
        globalObjectiveData(readStatusFrom.get)
      }).satisfied
    } else {
      satisfied
    }
  }

  def setSatisfiedStatus(status: Option[Boolean]) {
    satisfied = status
    val writeStatusTo = objectiveMapInfo.writeSatisfiedStatusTo
    if (writeStatusTo.isDefined) {
      globalObjectiveData.get(writeStatusTo.get).getOrElse({
        globalObjectiveData(writeStatusTo.get) = new GlobalObjectiveState(status, None, None)
        globalObjectiveData(writeStatusTo.get)
      }).satisfied = status
    }
  }

  def getNormalizedMeasure = {
    val readMeasureFrom = objectiveMapInfo.readNormalizedMeasureFrom
    if (readMeasureFrom.isDefined) {
      globalObjectiveData.get(readMeasureFrom.get).getOrElse({
        globalObjectiveData(readMeasureFrom.get) = new GlobalObjectiveState(None, None, None)
        globalObjectiveData(readMeasureFrom.get)
      }).normalizedMeasure
    } else {
      normalizedMeasure
    }
  }

  def setNormalizedMeasure(measure: Option[BigDecimal]) {
    normalizedMeasure = measure
    val writeMeasureTo = objectiveMapInfo.writeNormalizedMeasureTo
    if (writeMeasureTo.isDefined) {
      globalObjectiveData.get(writeMeasureTo.get).getOrElse({
        globalObjectiveData(writeMeasureTo.get) = new GlobalObjectiveState(None, measure, None)
        globalObjectiveData(writeMeasureTo.get)
      }).normalizedMeasure = measure
    }
  }
}

/**
 * Describes an activity with its current state within the sequencing process
 * The state may not correspond to what is in the storage at the moment
 * @param activity  The activity
 */
class ActivityState
(
  val activity: Activity,
  var active: Boolean,
  var suspended: Boolean,
  var attemptCompleted: Option[Boolean],
  var attemptCompletionAmount: Option[BigDecimal],
  val attemptAbsoluteDuration: BigDecimal,
  val attemptExperiencedDuration: BigDecimal,
  val activityAbsoluteDuration: BigDecimal,
  val activityExperiencedDuration: BigDecimal,
  var attemptCount: Int,
  val objectiveStates: Map[Option[String], ObjectiveState]
  ) {
  val sequencingPermissions = activity.sequencing.permissions

  def weightedProgress: Option[BigDecimal] = attemptCompletionAmount.map(_ * activity.completionThreshold.progressWeight)

  def primaryObjectiveWeightedMeasure: Option[BigDecimal] = objectiveStates.get(None) match {
    case Some(primaryObjectiveState) => primaryObjectiveState.getNormalizedMeasure.map(_ * activity.sequencing.rollupContribution.objectiveMeasureWeight)
    case None => None
  }

  setCompletionStatus(attemptCompleted)

  def getCompletionStatus(objectiveID:Option[String] = None) = {
    if (objectiveStates.contains(objectiveID)) {
      val readStatusFrom = objectiveStates(objectiveID).objectiveMapInfo.readCompletionStatusFrom
      if (readStatusFrom.isDefined) {
        objectiveStates(objectiveID).globalObjectiveData.get(readStatusFrom.get).getOrElse({
          objectiveStates(objectiveID).globalObjectiveData(readStatusFrom.get) = new GlobalObjectiveState(None, None, None)
          objectiveStates(objectiveID).globalObjectiveData(readStatusFrom.get)
        }).attemptCompleted
      } else {
        attemptCompleted
      }
    } else {
      attemptCompleted
    }
  }

  def setCompletionStatus(status: Option[Boolean], objectiveID:Option[String] = None) {
    attemptCompleted = status
    if (objectiveStates.contains(objectiveID)) {
      val writeStatusFrom = objectiveStates(objectiveID).objectiveMapInfo.writeCompletionStatusTo
      if (writeStatusFrom.isDefined) {
        objectiveStates(objectiveID).globalObjectiveData.get(writeStatusFrom.get).getOrElse({
          objectiveStates(objectiveID).globalObjectiveData(writeStatusFrom.get) = new GlobalObjectiveState(None, None, status)
          objectiveStates(objectiveID).globalObjectiveData(writeStatusFrom.get)
        }).attemptCompleted = status
      }
    }
  }

  /**
   * Sequencing Rules Check Process [UP.2] for Exit Condition Rules
   * @return True if exit condition rule applies
   */
  def exitConditionRuleApplies: Boolean =
  //If at least one exit condition rule applies, return true
    activity.sequencing.exitConditionRules.exists(rule => conditionSetApplies(rule.conditions))

  /**
   * Sequencing Rules Check Process [UP.2] for Post Condition Rules
   * @return Post Condition Rule action to be applied
   */
  def postConditionRuleAction: Option[PostConditionAction.Value] =
  //Evaluate each rule, one at a time, stop at the first rule that applies, return the associated action
    activity.sequencing.postConditionRules.find(rule => conditionSetApplies(rule.conditions)).map(_.action)


  /**
   * Sequencing Rules Check Process [UP.2] for Pre Condition Rules
   * @param action Rule action to check for
   * @return True if the action applies
   */
  def preConditionRuleApplies(action: PreConditionAction.Value): Boolean =
  //Evaluate each rule, one at a time, stop at the first rule that applies, return the associated action
    activity.sequencing.preConditionRules.filter(_.action == action).exists(rule => conditionSetApplies(rule.conditions))


  /**
   * Sequencing Rule Check Subprocess [UP.2.1]
   * @param conditions Rule condition set
   * @return True if the rule applies, False if the rule does not apply, and Unknown if the condition(s) cannot be evaluated
   */
  private[model] def conditionSetApplies(conditions: RuleConditionSet): Boolean = {
    val conditionEvaluationResults = conditions.conditions map conditionApplies
    conditions.combination match {
      case ConditionCombination.All => conditionEvaluationResults.forall(_ == true)
      case ConditionCombination.Any => conditionEvaluationResults.exists(_ == true)
    }
  }

  /**
   * Evaluates condition from activity condition set.
   * @param condition Condition of activity
   */
  private[model] def conditionApplies(condition: RuleCondition): Boolean = {
    lazy val objectiveState = if (objectiveStates.contains(condition.objectiveId)) {
      objectiveStates(condition.objectiveId)
    } else {
      if (objectiveStates.contains(None)
        && activity.sequencing.primaryObjective.isDefined
        && condition.objectiveId == activity.sequencing.primaryObjective.get.id) {
        objectiveStates(None)
      } else {
        throw new Exception("Error occured while trying to resolve objective with id '" +condition.objectiveId+ "' Check package manifest.")
      }
    }
    lazy val attemptLimit = activity.sequencing.attemptLimit
    val result = condition.conditionType match {
      case ConditionType.ObjectiveSatisfied => objectiveState.getSatisfiedStatus == Some(true)
      case ConditionType.ObjectiveStatusKnown => objectiveState.getSatisfiedStatus.isDefined
      case ConditionType.ObjectiveMeasureKnown => objectiveState.getNormalizedMeasure.isDefined
      case ConditionType.ObjectiveMeasureGreaterThan => objectiveState.getNormalizedMeasure.isDefined && (condition.measureThreshold.get < objectiveState.getNormalizedMeasure.get)
      case ConditionType.ObjectiveMeasureLessThan => objectiveState.getNormalizedMeasure.isDefined && (condition.measureThreshold.get > objectiveState.getNormalizedMeasure.get)
      case ConditionType.ActivityCompleted => getCompletionStatus(condition.objectiveId) == Some(true)
      case ConditionType.ActivityProgressKnown => getCompletionStatus(condition.objectiveId).isDefined
      case ConditionType.ActivityAttempted => attemptCount > 0
      case ConditionType.ActivityAttemptLimitExceeded => getCompletionStatus(condition.objectiveId).isDefined && attemptLimit.isDefined && (attemptCount >= attemptLimit.get)
      // Seems to be optional SCORM 2004 4th Edition Sequencing and Navigation
      case ConditionType.TimeLimitExceeded => false
      // Seems to be optional SCORM 2004 4th Edition Sequencing and Navigation
      case ConditionType.OutsideAvailableTimeRange => false
      case ConditionType.Always => true
    }
    if (condition.inverse) !result else result
  }

  /**
   * Limit conditions check process [UP.1]
   */
  def limitConditionsViolated: Boolean =
    activity.sequencing.tracking match {
      case None => false //If the activity is not tracked, its limit conditions cannot be violated
      case Some(tracking) => {
        // Only need to check activities that will begin a new attempt
        if (active || suspended) false
        else activity.sequencing.attemptLimit match {
          case Some(limit) => attemptCount > 0 && attemptCount >= limit
          case None => false
        }
      }
    }

  /**
   * Check Activity Process [UP.5] (inverse result!)
   * @return True if the activity is not disabled and does not violate any of its limit conditions
   */
  def deliveryEnabled: Boolean =
    !preConditionRuleApplies(PreConditionAction.Disabled) && !limitConditionsViolated

  /**
   * True if activity is inactive and its activation is disabled via preventChildrenActivation
   */
  def cannotActivate = !active && activity.sequencing.preventChildrenActivation
}