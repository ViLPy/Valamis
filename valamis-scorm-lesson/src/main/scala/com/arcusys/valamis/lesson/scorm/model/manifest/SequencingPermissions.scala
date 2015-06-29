package com.arcusys.valamis.lesson.scorm.model.manifest

/**
 * Sequencing permissions for an activity
 * @param choiceForChildren         Learner permitted to navigate to any child activity of this activity. Has no effect on leaf activities
 * @param choiceForNonDescendants   Learner permitted to navigate to an activity not being descendant of this activity while this activity is active
 * @param flowForChildren           Learner permitted to navigate forward and backward in the children of this activity. Has no effect on leaf activities
 * @param forwardOnlyForChildren    Learner not permitted to navigate backwards in the children of this activity using 'previous' or 'choice' requests. Has no effect on leaf activities
 */
class SequencingPermissions(
  val choiceForChildren: Boolean,
  val choiceForNonDescendants: Boolean,
  val flowForChildren: Boolean,
  val forwardOnlyForChildren: Boolean)

/**
 * Factory for sequencing permissions
 */
object SequencingPermissions {
  /**
   * Default sequencing permissions (everything allowed but choice)
   */
  val Default = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false)
}
