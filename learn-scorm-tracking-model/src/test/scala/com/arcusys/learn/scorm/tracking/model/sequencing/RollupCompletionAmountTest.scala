package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._
import scala.collection.mutable
import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, ActivityStateNode, ObjectiveState, ActivityState}

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class RollupCompletionAmountTest extends ActivityStateTreeTestBase {
  private val rollupService = new RollupService

  private def activityState(activity: Activity, attemptCompletionAmount: Option[BigDecimal]) = new ActivityState(
    activity = activity, active = false, suspended = false,
    attemptCompleted = None, attemptCompletionAmount = attemptCompletionAmount,
    attemptAbsoluteDuration = 0, attemptExperiencedDuration = 0,
    activityAbsoluteDuration = 0, activityExperiencedDuration = 0,
    attemptCount = 0, objectiveStates = Map[Option[String], ObjectiveState]()
  )

  "Rollup engine" can "rollup completion amount" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), progressWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), progressWeight = BigDecimal("0.5")), Some(BigDecimal("0.1")))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), progressWeight = BigDecimal("0.6")), Some(BigDecimal("0.2")))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), progressWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.weightedProgress.get should equal(BigDecimal("0.05"))
    leaf12.weightedProgress.get should equal(BigDecimal("0.12"))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.attemptCompletionAmount.get should equal(BigDecimal("0.1"))
    leaf11.weightedProgress.get should equal(BigDecimal("0.05"))
    leaf12.attemptCompletionAmount.get should equal(BigDecimal("0.2"))
    leaf12.weightedProgress.get should equal(BigDecimal("0.12"))
    leaf2.attemptCompletionAmount.get should equal(BigDecimal("0.3"))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    container1.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.15454"))
    container1.weightedProgress.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.06181"))
    root.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.24710"))
  }

  it can "rollup completion amount skipping non-tracked child activities" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), progressWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), progressWeight = BigDecimal("0.5"), tracking = None), Some(BigDecimal("0.1")))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), progressWeight = BigDecimal("0.6")), Some(BigDecimal("0.2")))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), progressWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.weightedProgress.get should equal(BigDecimal("0.05"))
    leaf12.weightedProgress.get should equal(BigDecimal("0.12"))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.attemptCompletionAmount.get should equal(BigDecimal("0.1"))
    leaf11.weightedProgress.get should equal(BigDecimal("0.05"))
    leaf12.attemptCompletionAmount.get should equal(BigDecimal("0.2"))
    leaf12.weightedProgress.get should equal(BigDecimal("0.12"))
    leaf2.attemptCompletionAmount.get should equal(BigDecimal("0.3"))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    container1.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.2"))
    container1.weightedProgress.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.08"))
    root.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.26363"))
  }

  it can "rollup completion amount if first child activity has progress undefined treating it as 0" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), progressWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), progressWeight = BigDecimal("0.5")), None)
    val leaf12 = activityState(leafActivity("L12", Some("C1"), progressWeight = BigDecimal("0.6")), Some(BigDecimal("0.2")))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), progressWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.weightedProgress should equal(None)
    leaf12.weightedProgress.get should equal(BigDecimal("0.12"))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.attemptCompletionAmount should equal(None)
    leaf11.weightedProgress should equal(None)
    leaf12.attemptCompletionAmount.get should equal(BigDecimal("0.2"))
    leaf12.weightedProgress.get should equal(BigDecimal("0.12"))
    leaf2.attemptCompletionAmount.get should equal(BigDecimal("0.3"))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    container1.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.10909"))
    container1.weightedProgress.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.04363"))
    root.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.23057"))
  }

  it can "rollup completion amount if second child activity has progress undefined treating it as 0" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), progressWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), progressWeight = BigDecimal("0.5")), Some(BigDecimal("0.1")))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), progressWeight = BigDecimal("0.6")), None)
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), progressWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.weightedProgress.get should equal(BigDecimal("0.05"))
    leaf12.weightedProgress should equal(None)
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.attemptCompletionAmount.get should equal(BigDecimal("0.1"))
    leaf11.weightedProgress.get should equal(BigDecimal("0.05"))
    leaf12.attemptCompletionAmount should equal(None)
    leaf12.weightedProgress should equal(None)
    leaf2.attemptCompletionAmount.get should equal(BigDecimal("0.3"))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    container1.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.04545"))
    container1.weightedProgress.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.01818"))
    root.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.20743"))
  }

  it should "rollup completion amount to undefined if all child activities have progress undefined" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), progressWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), progressWeight = BigDecimal("0.5")), None)
    val leaf12 = activityState(leafActivity("L12", Some("C1"), progressWeight = BigDecimal("0.6")), None)
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), progressWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.weightedProgress should equal(None)
    leaf12.weightedProgress should equal(None)
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.attemptCompletionAmount should equal(None)
    leaf11.weightedProgress should equal(None)
    leaf12.attemptCompletionAmount should equal(None)
    leaf12.weightedProgress should equal(None)
    leaf2.attemptCompletionAmount.get should equal(BigDecimal("0.3"))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    container1.attemptCompletionAmount should equal(None)
    container1.weightedProgress should equal(None)
    root.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.19090"))
  }

  it should "rollup completion amount to zero if all child activities have zero progress and non-zero weight" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), progressWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), progressWeight = BigDecimal("0.5")), Some(0))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), progressWeight = BigDecimal("0.6")), Some(0))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), progressWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.weightedProgress.get should equal(0)
    leaf12.weightedProgress.get should equal(0)
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.attemptCompletionAmount.get should equal(0)
    leaf11.weightedProgress.get should equal(0)
    leaf12.attemptCompletionAmount.get should equal(0)
    leaf12.weightedProgress.get should equal(0)
    leaf2.attemptCompletionAmount.get should equal(BigDecimal("0.3"))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    container1.attemptCompletionAmount.get should equal(BigDecimal(0))
    container1.weightedProgress.get should equal(BigDecimal(0))
    root.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.19090"))
  }

  it can "rollup completion amount to undefined if all child weights are 0" in {
    val container1 = activityState(containerActivity("C1", Some(organizationId), progressWeight = BigDecimal("0.4")), None)
    val leaf11 = activityState(leafActivity("L11", Some("C1"), progressWeight = BigDecimal(0)), Some(BigDecimal("0.1")))
    val leaf12 = activityState(leafActivity("L12", Some("C1"), progressWeight = BigDecimal(0)), Some(BigDecimal("0.2")))
    val leaf2 = activityState(leafActivity("L2", Some(organizationId), progressWeight = BigDecimal("0.7")), Some(BigDecimal("0.3")))
    val root = activityState(rootActivity(), None)
    val tree = new ActivityStateTree(root, Seq(
      new ActivityStateNode(container1, Seq(new ActivityStateNode(leaf11, Nil), new ActivityStateNode(leaf12, Nil))),
      new ActivityStateNode(leaf2, Nil)
    ), None, None, mutable.Map())
    leaf11.weightedProgress.get should equal(BigDecimal(0))
    leaf12.weightedProgress.get should equal(BigDecimal(0))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    rollupService(tree.children(0))
    leaf11.attemptCompletionAmount.get should equal(BigDecimal("0.1"))
    leaf11.weightedProgress.get should equal(BigDecimal(0))
    leaf12.attemptCompletionAmount.get should equal(BigDecimal("0.2"))
    leaf12.weightedProgress.get should equal(BigDecimal(0))
    leaf2.attemptCompletionAmount.get should equal(BigDecimal("0.3"))
    leaf2.weightedProgress.get should equal(BigDecimal("0.21"))
    container1.attemptCompletionAmount should equal(None)
    container1.weightedProgress should equal(None)
    root.attemptCompletionAmount.get.setScale(5, BigDecimal.RoundingMode.DOWN) should equal(BigDecimal("0.19090"))
  }
}
