package com.arcusys.learn.scorm.manifest.model

/**
 * A rule executed each time an SCO activity terminates
 * @param conditions  Set of conditions that define whether the action will be applied or not
 * @param action      An action to perform if conditions hit true
 */
class PostConditionRule(val conditions: RuleConditionSet, val action: PostConditionAction.Value)