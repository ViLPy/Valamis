package com.arcusys.learn.scorm.manifest.model

/**
 * A rule used mostly from keeping a learner from having access to an activity.
 * Such rules are continuously evaluated.
 * @param conditions  Set of conditions that define whether the action will be applied or not
 * @param action      An action to perform if conditions hit true
 */
class PreConditionRule(val conditions: RuleConditionSet, val action: PreConditionAction.Value)