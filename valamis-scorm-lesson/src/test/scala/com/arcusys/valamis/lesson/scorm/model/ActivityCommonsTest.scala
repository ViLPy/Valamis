package com.arcusys.valamis.lesson.scorm.model

import com.arcusys.valamis.lesson.scorm.model.manifest._
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class ActivityCommonsTest extends FlatSpec with ShouldMatchers {
  val mainObjective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("1"), globalObjectiveMap = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1")))
  def someSequencing(tracking: Option[SequencingTracking]) = new Sequencing(sharedId = None, sharedSequencingIdReference = Some("SID"),
    permissions = SequencingPermissions.Default,
    onlyCurrentAttemptObjectiveProgressForChildren = false, onlyCurrentAttemptAttemptProgressForChildren = false,
    attemptLimit = None, durationLimitInMilliseconds = None,
    rollupContribution = RollupContribution.Default,
    primaryObjective = Some(mainObjective), nonPrimaryObjectives = Nil,
    childrenSelection = new ChildrenSelection(),
    tracking = tracking,
    preventChildrenActivation = false, constrainChoice = true,
    preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil
  )

  "Activity" should "have shorthand methods for tracking info" in {
    val organization1 = new Organization("O1", "Organization 1", sequencing = someSequencing(Some(new SequencingTracking(completionSetByContent = true, objectiveSetByContent = true))))
    organization1.isTracked should equal(true)
    organization1.isCompletionSetByContent should equal(true)
    organization1.isObjectiveSetByContent should equal(true)

    val organization2 = new Organization("O1", "Organization 1", sequencing = someSequencing(Some(new SequencingTracking(completionSetByContent = false, objectiveSetByContent = false))))
    organization2.isTracked should equal(true)
    organization2.isCompletionSetByContent should equal(false)
    organization2.isObjectiveSetByContent should equal(false)

    val organization3 = new Organization("O1", "Organization 1", sequencing = someSequencing(None))
    organization3.isTracked should equal(false)
    organization3.isCompletionSetByContent should equal(false)
    organization3.isObjectiveSetByContent should equal(false)
  }

}
