package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.tracking.model.ActivityStateNode

/**
 * Processes for rolling up attempts - implementation
 */
class RollupService extends RollupServiceContract {
  /**
   * Overall Rollup Process [RB.1.5] for an activity
   * May change the tracking information for the activity and its ancestors
   */
  def apply(activity: ActivityStateNode) {
    /**
     * Measure Rollup Process [RB.1.1 a], may change the Objective Information for the activity
     */
    def rollupMeasure(activity: ActivityStateNode) {
      if (activity.item.activity.sequencing.primaryObjective.isDefined) {
        activity.averageChildWeightedMeasure match {
          case Some(measure) => activity.item.objectiveStates(None).setNormalizedMeasure(measure)
          //One of the children does not have a primary objective. Don't roll up
          case None          => {}
        }
      }
    }

    /**
     * Completion Measure Rollup Process [RB.1.1 b]. May change the Objective Information for the activity
     */
    def rollupCompletionAmount(activity: ActivityStateNode) {
      activity.item.attemptCompletionAmount = activity.averageChildWeightedProgress
    }

    // Form the activity path as the ordered series of all activities from the current activity to the root of the activity tree, inclusive
    activity.pathToRoot.foreach(node => {
      if (!node.isLeaf) {
        rollupMeasure(node)
        rollupCompletionAmount(node)
      }

      def objectiveRollup(objective: Objective) {
        // If (the rolled-up objective is Defined) And (Objective Satisfied By Measure for the rolled-up objective is True)
        if (objective.satisfiedByMeasure) {
          // Apply the Objective Rollup Using Measure Process [RB.1.2 a] to the activity
          node.item.objectiveStates.get(None).foreach(primaryObjectiveState => {
            primaryObjectiveState.getNormalizedMeasure match {
              case Some(measure) => {
                if (!node.item.active || (node.item.active && node.item.activity.sequencing.rollupContribution.measureSatisfactionIfActive)) {
                  primaryObjectiveState.setSatisfiedStatus(Some(measure >= objective.minNormalizedMeasure))
                } else {
                  primaryObjectiveState.setSatisfiedStatus(None)
                }
              }
              case _ => primaryObjectiveState.setSatisfiedStatus(None)
            }
          })
        } else {
          // Apply the Objective Rollup Using Rules Process [RB.1.2 b] to the activity
          node.item.objectiveStates.get(None).foreach(primaryObjectiveState => {
            val notSatisfiedCheck = rollupRuleCheck(node, RollupAction.NotSatisfied)
            if (notSatisfiedCheck) {
              primaryObjectiveState.setSatisfiedStatus(Some(false))
            }
            val satisfiedCheck = rollupRuleCheck(node, RollupAction.Satisfied)
            if (satisfiedCheck) {
              primaryObjectiveState.setSatisfiedStatus(Some(true))
            }
          })
        }
      }
      // only objectives contributed to rollup
      node.item.activity.sequencing.primaryObjective.foreach(objectiveRollup(_))
    })
  }

  // Check Child for Rollup Subprocess [RB.1.4.2]
  private def checkChildForRollup(node: ActivityStateNode, action: RollupAction.Value): Boolean = {
    if (action == RollupAction.Satisfied || action == RollupAction.NotSatisfied) {
      if (node.item.activity.sequencing.rollupContribution.satisfaction.isDefined) {
        if ((action == RollupAction.Satisfied && node.item.activity.sequencing.rollupContribution.satisfaction.get.contributeToSatisfied == RollupConsiderationType.IfNotSuspended)
          || (action == RollupAction.NotSatisfied && node.item.activity.sequencing.rollupContribution.satisfaction.get.contributeToNotSatisfied == RollupConsiderationType.IfNotSuspended)) {
          if (node.item.getCompletionStatus().isEmpty || (node.item.attemptCount > 0 && node.item.suspended)) {
            return false
          }
        } else if ((action == RollupAction.Satisfied && node.item.activity.sequencing.rollupContribution.satisfaction.get.contributeToSatisfied == RollupConsiderationType.IfAttempted)
          || (action == RollupAction.NotSatisfied && node.item.activity.sequencing.rollupContribution.satisfaction.get.contributeToNotSatisfied == RollupConsiderationType.IfAttempted)) {
          if (node.item.getCompletionStatus().isEmpty || node.item.attemptCount == 0) {
            return false
          }
        } else if ((action == RollupAction.Satisfied && node.item.activity.sequencing.rollupContribution.satisfaction.get.contributeToSatisfied == RollupConsiderationType.IfNotSuspended)
          || (action == RollupAction.NotSatisfied && node.item.activity.sequencing.rollupContribution.satisfaction.get.contributeToNotSatisfied == RollupConsiderationType.IfNotSuspended)) {
          if (node.item.activity.sequencing.preConditionRules.filter(_.action == PreConditionAction.Skip).exists(rule => node.item.conditionSetApplies(rule.conditions))) {
            return false
          }
        }
        return true
      }
    } else if (action == RollupAction.Completed || action == RollupAction.Incomplete) {
      if (node.item.activity.sequencing.rollupContribution.completion.isDefined) {
        if ((action == RollupAction.Completed && node.item.activity.sequencing.rollupContribution.completion.get.contributeToCompleted == RollupConsiderationType.IfNotSuspended)
          || (action == RollupAction.Incomplete && node.item.activity.sequencing.rollupContribution.completion.get.contributeToIncomplete == RollupConsiderationType.IfNotSuspended)) {
          if (node.item.getCompletionStatus().isEmpty || (node.item.attemptCount > 0 && node.item.suspended)) {
            return false
          }
        } else if ((action == RollupAction.Completed && node.item.activity.sequencing.rollupContribution.completion.get.contributeToCompleted == RollupConsiderationType.IfAttempted)
          || (action == RollupAction.Incomplete && node.item.activity.sequencing.rollupContribution.completion.get.contributeToIncomplete == RollupConsiderationType.IfAttempted)) {
          if (node.item.getCompletionStatus().isEmpty || node.item.attemptCount == 0) {
            return false
          }
        } else if ((action == RollupAction.Completed && node.item.activity.sequencing.rollupContribution.completion.get.contributeToCompleted == RollupConsiderationType.IfNotSuspended)
          || (action == RollupAction.Incomplete && node.item.activity.sequencing.rollupContribution.completion.get.contributeToIncomplete == RollupConsiderationType.IfNotSuspended)) {
          if (node.item.activity.sequencing.preConditionRules.filter(_.action == PreConditionAction.Skip).exists(rule => node.item.conditionSetApplies(rule.conditions))) {
            return false
          }
        }
        return true
      }
    }
    false
  }

  // Rollup Rule Check Subprocess [RB.1.4]
  private def rollupRuleCheck(node: ActivityStateNode, action: RollupAction.Value): Boolean = {
    val ruleSet = node.item.activity.sequencing.rollupRules.filter(_.action == action)
    val filteredChildren = node.children.filter(child => child.item.activity.isTracked && checkChildForRollup(child, action))
    ruleSet.foreach(rule => {
      val contributingChildrenBag = filteredChildren.map(child => {
        child.item.conditionSetApplies(rule.conditions)
      })
      if (contributingChildrenBag.isEmpty) {
        return false
      } else {
        rule.childActivitySet match {
          case ChildActivitySetAll  => return contributingChildrenBag.find(item => !item).isEmpty
          case ChildActivitySetAny  => return contributingChildrenBag.find(item => item).isDefined
          case ChildActivitySetNone => return contributingChildrenBag.find(item => item).isEmpty
          case ChildActivitySetAtLeastCount(count) => {
            return contributingChildrenBag.filter(item => item).size >= count
          }
          case ChildActivitySetAtLeastPercent(percent) => {
            // the percentage - normalized between 0..1
            return (contributingChildrenBag.filter(item => item).size / contributingChildrenBag.size) >= percent
          }
          case _ => throw new Exception(rule.childActivitySet.toString + " is unknown Child Activity Set rule!")
        }
      }
    })
    false
  }
}