package com.arcusys.learn.scorm.manifest.model

/**
 * Information about sequencing for an activity or organization
 * @param sharedId                                        ID of shared sequencing information. None for non-shared sequencing information
 * @param sharedSequencingIdReference                     Link to shared sequencing information by its ID
 * @param permissions                                     Sequencing permissions
 * @param onlyCurrentAttemptObjectiveProgressForChildren  When rolling up and evaluating rules against objective progress info on this activity's children's objectives use only current attempt data
 * @param onlyCurrentAttemptAttemptProgressForChildren    When rolling up and evaluating rules against attempt progress info on this activity's children's use only current attempt data
 * @param attemptLimit                                    Maximum number of attempts for an activity, or None if not limited
 * @param durationLimitInMilliseconds                     Maximum time in milliseconds permitted for an attempt
 * @param rollupContribution                              How this activity contributes to the container's rollup
 * @param primaryObjective                                Primary objective of the activity (which contributes to activity rollup)
 * @param nonPrimaryObjectives                            Objectives that do not contribute to activity rollup
 * @param childrenSelection                               How child activities are selected for this activity
 * @param tracking                                        How activity is tracked. If None, activity is not tracked (progress information not recorded, data does not contribute to rollup for parent)
 * @param preventChildrenActivation                       Prevent activation of children of this activity if this activity is not active/current
 * @param constrainChoice                                 Allow choice requests only for next/previous activities relative to this one (or for their children)
 * @param preConditionRules                               Rules that determine whether the activity will be delivered
 * @param postConditionRules                              Rules which are applied when the activity attempt terminates
 * @param exitConditionRules                              Rules which are applied when an attempt on a descendant activity terminates
 * @param rollupRules                                     Rules which are applied to the activity during its rollup
 */
class Sequencing
(
  val sharedId: Option[String],
  val sharedSequencingIdReference: Option[String],
  val permissions: SequencingPermissions,
  val onlyCurrentAttemptObjectiveProgressForChildren: Boolean,
  val onlyCurrentAttemptAttemptProgressForChildren: Boolean,
  val attemptLimit: Option[Int],
  val durationLimitInMilliseconds: Option[Long],
  val rollupContribution: RollupContribution,
  val primaryObjective: Option[Objective],
  val nonPrimaryObjectives: Seq[Objective],
  val childrenSelection: ChildrenSelection,
  val tracking: Option[SequencingTracking],
  val preventChildrenActivation: Boolean,
  val constrainChoice: Boolean,
  val preConditionRules: Seq[PreConditionRule],
  val postConditionRules: Seq[PostConditionRule],
  val exitConditionRules: Seq[ExitConditionRule],
  val rollupRules: Seq[RollupRule]
  ) {
  require(nonPrimaryObjectives.forall(_.id.isDefined), "All non-primary objectives must have IDs defined")
  private val nonPrimaryObjectiveMap = nonPrimaryObjectives.map(o => o.id.get -> o).toMap
  require(nonPrimaryObjectiveMap.size == nonPrimaryObjectives.size, "All non-primary objective IDs must be unique")
  require(primaryObjective.isEmpty || primaryObjective.get.id.isEmpty || !nonPrimaryObjectiveMap.contains(primaryObjective.get.id.get), "Primary objective can't have same ID as non-primary objective")
  private val allObjectives = primaryObjective.toSeq ++ nonPrimaryObjectives
  require (allObjectives.groupBy(_.globalObjectiveMap.writeNormalizedMeasureTo).forall(_._2.count(_.globalObjectiveMap.writeNormalizedMeasureTo.isDefined) <=1 ),
    "More than one <primaryObjective> or <objective> element per activity defines `writeNormalizedMeasure` attribute as true for activity")

  require (allObjectives.groupBy(_.globalObjectiveMap.writeSatisfiedStatusTo).forall(_._2.count(_.globalObjectiveMap.writeSatisfiedStatusTo.isDefined) <=1 ),
    "More than one <primaryObjective> or <objective> element per activity defines `writeSatisfiedStatus` attribute as true for activity")

  require (allObjectives.groupBy(_.globalObjectiveMap.writeRawScoreTo).forall(_._2.count(_.globalObjectiveMap.writeRawScoreTo.isDefined) <=1 ),
    "More than one <primaryObjective> or <objective> element per activity defines `writeRawScore` attribute as true for activity")

  require (allObjectives.groupBy(_.globalObjectiveMap.writeMinScoreTo).forall(_._2.count(_.globalObjectiveMap.writeMinScoreTo.isDefined) <=1 ),
    "More than one <primaryObjective> or <objective> element per activity defines `writeMinScore` attribute as true for activity")

  require (allObjectives.groupBy(_.globalObjectiveMap.writeMaxScoreTo).forall(_._2.count(_.globalObjectiveMap.writeMaxScoreTo.isDefined) <=1 ),
    "More than one <primaryObjective> or <objective> element per activity defines `writeMaxScore` attribute as true for activity")

  require (allObjectives.groupBy(_.globalObjectiveMap.writeCompletionStatusTo).forall(_._2.count(_.globalObjectiveMap.writeCompletionStatusTo.isDefined) <=1 ),
    "More than one <primaryObjective> or <objective> element per activity defines `writeCompletionStatus` attribute as true for activity")

  require (allObjectives.groupBy(_.globalObjectiveMap.writeProgressMeasureTo).forall(_._2.count(_.globalObjectiveMap.writeProgressMeasureTo.isDefined) <=1 ),
    "More than one <primaryObjective> or <objective> element per activity defines `writeProgressMeasure` attribute as true for activity")
}

/**
 * Factory methods for sequencing
 */
object Sequencing {
  val Default = new Sequencing(
    sharedId = None,
    sharedSequencingIdReference = None,
    permissions = SequencingPermissions.Default,
    onlyCurrentAttemptObjectiveProgressForChildren = true,
    onlyCurrentAttemptAttemptProgressForChildren = true,
    attemptLimit = None,
    durationLimitInMilliseconds = None,
    rollupContribution = RollupContribution.Default,
    primaryObjective = Some(new Objective(None, false, BigDecimal(1.0))),
    nonPrimaryObjectives = Nil,
    childrenSelection = new ChildrenSelection(),
    tracking = Some(SequencingTracking.Default),
    preventChildrenActivation = false,
    constrainChoice = false,
    preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil
  )
}