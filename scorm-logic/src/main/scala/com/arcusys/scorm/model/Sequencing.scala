package com.arcusys.scorm.model
import scala.collection.mutable.Buffer
import scala.collection.mutable.Map

class Sequencing(
  /**
   * ID of shared sequencing information. None for non-shared sequencing information
   */
  val sharedId: Option[String],
  /**
   * Link to shared sequencing information by its ID
   */
  val sharedSequencingIdReference: Option[String],
  /**
   * True if learner is permitted to navigate to any child activity of this activity. Has no effect on leaf activities
   */
  val choicePermittedForChildren: Boolean,
  /**
   * True if learner is permitted to navigate to an activity not being descendant of this activity while this activity is active
   */
  val choicePermittedForNonDescendants: Boolean,
  /**
   * True if learner is permitted to navigate forward and backward in the children of this activity. Has no effect on leaf activities
   */
  val continuePreviousFlowPermittedForChildren: Boolean,
  /**
   * True if learner is unable to navigate backwards in the children of this activity using `previous` or `choice` (direct) requests. Has no effect on leaf activities
   */
  val forwardOnlyForChildren: Boolean,
  /**
   * True if when rolling up objective progress info on this activity's children's objectives use only current attempt data
   */
  val rollupOnlyCurrentAttemptObjectiveProgressForChildren: Boolean,
  /**
   * True if when rolling up attempt progress info on this activity's children's objectives use only current attempt data
   */
  val rollupOnlyCurrentAttemptAttemptProgressForChildren: Boolean,
  /**
   * Maximum number of attempts for an activity
   */
  val attemptLimit: Option[Int],
  /**
   * Maximum time in milliseconds permitted for an attempt
   */
  val durationLimitInMilliseconds: Option[BigInt],
  /**
   * True if activity contributes to the evaluation of its parent's Satisfied and Not Satisfied rollup rules
   */
  val rollupObjectiveSatisfied: Boolean,
  /**
   * True if activity contributes to the evaluation of its parent's Completed and Incomplete rollup rules
   */
  val rollupProgressCompletion: Boolean,
  /**
   * Weighting factor applied to the objectives normalized measure used during rollup for the parent activity 
   */
  val objectiveMeasureWeight: BigDecimal,
  /**
   * Primary objective of the activity (which contributes to activity rollup)
   */
  val primaryObjective: Option[Objective],
  /**
   * A way of applying order randomization to children of activity
   */
  val childrenRandomizationTiming: RandomizationTimingType.Value,
  /**
   * Number of child elements to pick up
   */
  val childrenSelectCount: Option[Int],
  /**
   * True if order of child activities is randomized
   */
  val reorderChildren: Boolean,
  /**
   * A way of selecting a subset of children of activity
   */
  val childrenSelectionTiming: RandomizationTimingType.Value,
  /**
   * True if activity is tracked (progress information is recorded, data contributes to rollup for parent)
   */
  val tracked: Boolean,
  /**
   * Attempt completion status will be set by the SCO
   */
  val completionSetByContent: Boolean,
  /**
   * Objective satisfied status will be set by the SCO
   */
  val objectiveSetByContent: Boolean,
  /**
   * Prevent activation of children of this activity if this activity is not active/current
   */
  val preventChildrenActivation: Boolean,
  /**
   * Allow choice requests only for next/previous activities relative to this one (or for their children)
   */
  val constrainChoice: Boolean,
  /**
   * The way activity contributes to rolled up Satisfied status of parent
   */
  val contributeToSatisfiedRollup: RollupConsiderationType.Value,
  /**
   * The way activity contributes to rolled up Not Satisfied status of parent
   */
  val contributeToNotSatisfiedRollup: RollupConsiderationType.Value,
  /**
   * The way activity contributes to rolled up Completed status of parent
   */
  val contributeToCompletedRollup: RollupConsiderationType.Value,
  /**
   * The way activity contributes to rolled up Incomplete status of parent
   */
  val contributeToIncompleteRollup: RollupConsiderationType.Value,
  /**
   * Measure should be used to determine satisfaction during rollup when activity is active
   */
  val measureSatisfactionIfActive: Boolean
) {
  /**
   * Rules that determine whether the activity will be delivered
   */
  val preConditionRules = Buffer[PreConditionRule]()
  /**
   * Rules which are applied when the activity attempt terminates
   */
  val postConditionRules = Buffer[PostConditionRule]()
  /**
   * Rules which are applied when an attempt on a descendant activity terminates
   */
  val exitConditionRules = Buffer[ExitConditionRule]()
  /**
   * Rules which are applied to the activity during its rollup
   */
  val rollupRules = Buffer[RollupRule]()
  /**
   * Objectives that do not contribute to activity rollup
   */
  val nonPrimaryObjectives = Map[String,Objective]()
 }