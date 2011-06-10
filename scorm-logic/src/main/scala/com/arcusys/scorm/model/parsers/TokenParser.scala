package com.arcusys.scorm.model.parsers
import com.arcusys.scorm.model._

object TokenParser {
  def parseChildActivitySet(value: String) = {
    import ChildActivitySet._
    Map("all" -> All, "any" -> Any, "none" -> None, "atLeastCount" -> AtLeastCount, "atLeastPercent" -> AtLeastPercent).
      getOrElse(value, throw new SCORMParserException("Invalid value of `childActivitySet` attribute for rollup rule: " + value));
  }

  def parseConditionCombination(value: String) = {
    import ConditionCombination._
    Map("all" -> All, "any" -> Any).
      getOrElse(value, throw new SCORMParserException("Invalid value of `conditionCombination` attribute: " + value))
  }
  def parseRuleConditionType(value: String) = {
    import ConditionType._
    Map("satisfied" -> ObjectiveSatisfied,
      "objectiveStatusKnown" -> ObjectiveStatusKnown,
      "objectiveMeasureKnown" -> ObjectiveMeasureKnown,
      "objectiveMeasureGreaterThan" -> ObjectiveMeasureGreaterThan,
      "objectiveMeasureLessThan" -> ObjectiveMeasureLessThan,
      "completed" -> ActivityCompleted,
      "activityProgressKnown" -> ActivityProgressKnown,
      "attempted" -> ActivityAttempted,
      "attemptLimitExceeded" -> ActivityAttemptLimitExceeded,
      "timeLimitExceeded" -> TimeLimitExceeded,
      "outsideAvailableTimeRange" -> OutsideAvailableTimeRange,
      "always" -> Always).
      getOrElse(value, throw new SCORMParserException("Invalid `condition` attribute value"))
  }

  def parsePreConditionAction(value: String) = {
    import PreConditionAction._
    Map("skip" -> Skip, "disabled" -> Disabled, "hiddenFromChoice" -> HiddenFromChoice, "stopForwardTraversal" -> StopForwardTraversal).
      getOrElse(value, throw new SCORMParserException("Invalid value of `action` attribute for pre-condition: " + value))
  }

  def parsePostConditionAction(value: String) = {
    import PostConditionAction._
    Map("exitParent" -> ExitParent, "exitAll" -> ExitAll, "retry" -> Retry, "retryAll" -> RetryAll,
      "continue" -> Continue, "previous" -> Previous).
      getOrElse(value, throw new SCORMParserException("Invalid value of `action` attribute for post-condition: " + value))
  }

  def parseExitConditionAction(value: String) = {
    if (!value.equals("exit")) {
      throw new SCORMParserException("Invalid value of `action` attribute for exit condition: " + value);
    }
  }

  def parseRollupAction(value: String) = {
    import RollupAction._
    Map("satisfied" -> Satisfied, "notSatisfied" -> NotSatisfied, "completed" -> Completed, "incomplete" -> Incomplete).
      getOrElse(value, throw new SCORMParserException("Invalid value of `action` attribute for rollup: " + value))
  }

  def parseIsInverseRuleOperator(value: String) = {
    Map("noOp" -> false, "not" -> true).getOrElse(value, throw new SCORMParserException("Invalid `operator` attribute value"));
  }

  def parseRandomizationTimingType(value: String) = {
    import RandomizationTimingType._
    Map("never" -> Never, "once" -> Once, "onEachNewAttempt" -> OnEachNewAttempt).
      getOrElse(value, throw new SCORMParserException("Invalid `condition` attribute value"))
  }

  def parseRollupConsiderationType(value: String) = {
    import RollupConsiderationType._
    Map("always" -> Always, "ifAttempted" -> IfAttempted, "ifNotSkipped" -> IfNotSkipped, "ifNotSuspended" -> IfNotSuspended).
      getOrElse(value, throw new SCORMParserException("Invalid <rollupConsiderations> element attribute value"))
  }

  def parseNavigationControlType(value: String) = {
    import NavigationControlType._
    Map("previous" -> Previous, "continue" -> Continue, "exit" -> Exit, "exitAll" -> ExitAll,
      "abandon" -> Abandon, "abandonAll" -> AbandonAll, "suspendAll" -> SuspendAll).
      getOrElse(value, throw new SCORMParserException("Invalid <hideLMSUI> element value"))
  }
}