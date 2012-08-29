package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._
import scala.collection.mutable
import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, ActivityStateNode, ObjectiveState, ActivityState}

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class RollupObjectiveMeasureTest extends ActivityStateTreeTestBase {
  private val rollupService = new RollupService

  private def primaryObjective = new Objective(None, false, 1, ObjectiveMap.Empty)

  private def activityState(activity: Activity, primaryObjectiveNormalizedMeasure: Option[BigDecimal]) = new ActivityState(
    activity = activity, active = false, suspended = false,
    attemptCompleted = None, attemptCompletionAmount = None,
    attemptAbsoluteDuration = 0, attemptExperiencedDuration = 0,
    activityAbsoluteDuration = 0, activityExperiencedDuration = 0,
    attemptCount = 0, objectiveStates = Map[Option[String], ObjectiveState](None -> new ObjectiveState(satisfied = None, normalizedMeasure = primaryObjectiveNormalizedMeasure, objectiveMapInfo = ObjectiveMap.Empty))
  )

  "Rollup engine" can "rollup primary objective normalized measure" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.5")), Some(BigDecimal("0.1")))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.6")), Some(BigDecimal("0.2")))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(primaryObjective = Some(primaryObjective)), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.05"))
    leaf12.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.12"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.1"))
    leaf11.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.05"))
    leaf12.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.2"))
    leaf12.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.12"))
    leaf2.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.3"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    container1.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.15454"))
    container1.primaryObjectiveWeightedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.06181"))
    root.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.24710"))
  }

  it can "rollup primary objective normalized measure skipping non-tracked child activities" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.5"), tracking = None), Some(BigDecimal("0.1")))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.6")), Some(BigDecimal("0.2")))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(primaryObjective = Some(primaryObjective)), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.05"))
    leaf12.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.12"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.1"))
    leaf11.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.05"))
    leaf12.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.2"))
    leaf12.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.12"))
    leaf2.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.3"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    container1.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.2"))
    container1.primaryObjectiveWeightedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.08"))
    root.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.26363"))
  }

  it can "rollup primary objective normalized measure if first child activity has measure undefined treating it as 0" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.5")), None)
    val leaf12 = activityState(leafActivity("L12", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.6")), Some(BigDecimal("0.2")))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(primaryObjective = Some(primaryObjective)), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.primaryObjectiveWeightedMeasure should equal(None)
    leaf12.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.12"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.objectiveStates(None).getNormalizedMeasure should equal(None)
    leaf11.primaryObjectiveWeightedMeasure should equal(None)
    leaf12.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.2"))
    leaf12.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.12"))
    leaf2.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.3"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    container1.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.10909"))
    container1.primaryObjectiveWeightedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.04363"))
    root.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.23057"))
  }

  it can "rollup primary objective normalized measure if second child activity has measure undefined treating it as 0" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.5")), Some(BigDecimal("0.1")))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.6")), None)
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(primaryObjective = Some(primaryObjective)), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.05"))
    leaf12.primaryObjectiveWeightedMeasure should equal(None)
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.1"))
    leaf11.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.05"))
    leaf12.objectiveStates(None).getNormalizedMeasure should equal(None)
    leaf12.primaryObjectiveWeightedMeasure should equal(None)
    leaf2.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.3"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    container1.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.04545"))
    container1.primaryObjectiveWeightedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.01818"))
    root.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.20743"))
  }

  it should "rollup completion amount to undefined if all child activities have progress undefined" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.5")), None)
    val leaf12 = activityState(leafActivity("L12", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.6")), None)
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(primaryObjective = Some(primaryObjective)), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.primaryObjectiveWeightedMeasure should equal(None)
    leaf12.primaryObjectiveWeightedMeasure should equal(None)
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.objectiveStates(None).getNormalizedMeasure should equal(None)
    leaf11.primaryObjectiveWeightedMeasure should equal(None)
    leaf12.objectiveStates(None).getNormalizedMeasure should equal(None)
    leaf12.primaryObjectiveWeightedMeasure should equal(None)
    leaf2.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.3"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    container1.objectiveStates(None).getNormalizedMeasure should equal(None)
    container1.primaryObjectiveWeightedMeasure should equal(None)
    root.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.19090"))
  }

  it should "rollup completion amount to zero if all child activities have zero progress and non-zero weight" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.5")), Some(0))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.6")), Some(0))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(primaryObjective = Some(primaryObjective)), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.primaryObjectiveWeightedMeasure.get should equal(0)
    leaf12.primaryObjectiveWeightedMeasure.get should equal(0)
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.objectiveStates(None).getNormalizedMeasure.get should equal(0)
    leaf11.primaryObjectiveWeightedMeasure.get should equal(0)
    leaf12.objectiveStates(None).getNormalizedMeasure.get should equal(0)
    leaf12.primaryObjectiveWeightedMeasure.get should equal(0)
    leaf2.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.3"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    container1.objectiveStates(None).getNormalizedMeasure.get should equal(0)
    container1.primaryObjectiveWeightedMeasure.get should equal(0)
    root.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.19090"))
  }

  it can "rollup completion amount to undefined if all child weights are 0" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal(0)), Some(BigDecimal("0.1")))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal(0)), Some(BigDecimal("0.2")))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(primaryObjective = Some(primaryObjective)), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.primaryObjectiveWeightedMeasure.get should equal(BigDecimal(0))
    leaf12.primaryObjectiveWeightedMeasure.get should equal(BigDecimal(0))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.1"))
    leaf11.primaryObjectiveWeightedMeasure.get should equal(BigDecimal(0))
    leaf12.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.2"))
    leaf12.primaryObjectiveWeightedMeasure.get should equal(BigDecimal(0))
    leaf2.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.3"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    container1.objectiveStates(None).getNormalizedMeasure should equal(None)
    container1.primaryObjectiveWeightedMeasure should equal(None)
    root.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.19090"))
  }

  it should "cancel rollup and retain current parent value if child has no primary objective" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.4")), Some(BigDecimal("1")))
    val leaf11 = activityState(leafActivity("L11", Some("C1"), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.5")), Some(BigDecimal("0.1")))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), primaryObjective = None, objectiveMeasureWeight = BigDecimal("0.6")), Some(BigDecimal("0.2")))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), primaryObjective = Some(primaryObjective), objectiveMeasureWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(primaryObjective = Some(primaryObjective)), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.05"))
    leaf12.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.12"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.1"))
    leaf11.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.05"))
    leaf12.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.2"))
    leaf12.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.12"))
    leaf2.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("0.3"))
    leaf2.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.21"))
    container1.objectiveStates(None).getNormalizedMeasure.get should equal(BigDecimal("1"))
    container1.primaryObjectiveWeightedMeasure.get should equal(BigDecimal("0.4"))
    root.objectiveStates(None).getNormalizedMeasure.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.55454"))
  }
}
