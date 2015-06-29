package com.arcusys.valamis.lesson.scorm.model

import com.arcusys.valamis.lesson.scorm.model.manifest._
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class OrganizationTest extends FlatSpec with ShouldMatchers {
  val someMetadata = new Metadata(Seq("meta.xml"), Seq("<info>data</info>"))
  val mainObjective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("1"), globalObjectiveMap = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1")))
  val otherObjective = new Objective(Some("OBJ2"), satisfiedByMeasure = true, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = new ObjectiveMap(writeMaxScoreTo = Some("GO2")))
  val preConditionRule = new PreConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All), PreConditionAction.Disabled)
  val postConditionRule = new PostConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityProgressKnown)), ConditionCombination.All), PostConditionAction.Continue)
  val exitConditionRule = new ExitConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.Always)), ConditionCombination.All))
  val rollupRule = new RollupRule(ChildActivitySet.all, new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityCompleted)), ConditionCombination.All), RollupAction.Incomplete)
  val someSequencing = new Sequencing(sharedId = None, sharedSequencingIdReference = Some("SID"),
    permissions = SequencingPermissions.Default,
    onlyCurrentAttemptObjectiveProgressForChildren = false, onlyCurrentAttemptAttemptProgressForChildren = false,
    attemptLimit = Some(2), durationLimitInMilliseconds = Some(50000),
    rollupContribution = RollupContribution.Default,
    primaryObjective = Some(mainObjective), nonPrimaryObjectives = Seq(otherObjective),
    childrenSelection = new ChildrenSelection(Some(new ChildrenSelectionTake(10, RandomizationTimingType.Once)), Some(RandomizationTimingType.OnEachNewAttempt)),
    tracking = Some(new SequencingTracking(completionSetByContent = true, objectiveSetByContent = false)),
    preventChildrenActivation = false, constrainChoice = true,
    preConditionRules = Seq(preConditionRule),
    postConditionRules = Seq(postConditionRule),
    exitConditionRules = Seq(exitConditionRule),
    rollupRules = Seq(rollupRule)
  )
  val someThreshold = new CompletionThreshold(completedByMeasure = true, minProgressMeasure = 0.7, progressWeight = 0.8)

  "Organization" can "be constructed" in {
    val organization = new Organization("O1", "Organization 1", objectivesGlobalToSystem = false, sharedDataGlobalToSystem = false,
      sequencing = someSequencing, completionThreshold = someThreshold, metadata = Some(someMetadata))
    organization.id should equal("O1")
    organization.title should equal("Organization 1")
    organization.parentID should equal(None)
    organization.organizationID should equal(organization.id)
    organization.objectivesGlobalToSystem should equal(false)
    organization.sharedDataGlobalToSystem should equal(false)
    organization.sequencing should equal(someSequencing)
    organization.completionThreshold should equal(someThreshold)
    organization.metadata should equal(Some(someMetadata))
    organization.hiddenNavigationControls should equal(Set())
  }

  it can "be constructed with defaults" in {
    val organization = new Organization("O1", "Organization 1")
    organization.id should equal("O1")
    organization.title should equal("Organization 1")
    organization.parentID should equal(None)
    organization.organizationID should equal(organization.id)
    organization.objectivesGlobalToSystem should equal(true)
    organization.sharedDataGlobalToSystem should equal(true)
    organization.sequencing should equal(Sequencing.Default)
    organization.completionThreshold should equal(CompletionThreshold.Default)
    organization.metadata should equal(None)
    organization.hiddenNavigationControls should equal(Set())
  }
}
