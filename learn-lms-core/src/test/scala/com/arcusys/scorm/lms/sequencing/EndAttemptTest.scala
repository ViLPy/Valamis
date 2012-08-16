package com.arcusys.scorm.lms.sequencing

import org.junit.runner.RunWith
import org.scala_tools.subcut.inject.NewBindingModule
import com.arcusys.learn.scorm.manifest.model._

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class EndAttemptTest extends ActivityStateTreeTestBase {
  val rollupService = mock[RollupServiceContract]
  val configuration = new NewBindingModule({
    implicit module =>
      import module._
      bind[RollupServiceContract] toSingle rollupService
  })

  def endAttemptService = new EndAttemptService()(configuration)

  "End attempt service" can "process a non-leaf activity with suspended children, suspending it, setting it to inactive and rolling up" in {
    val tree = threeLevelTree(suspendedLevel = Some(2), currentLevel = Some(2))
    rollupService expects 'apply withArgs(tree.children(0)) onCall {
      node:ActivityStateNode => {
        node.item.active should equal(false)
        node.item.suspended should equal(true)
        //Does not clear current activity
        tree.currentActivity should equal(Some(tree.children(0).children(0)))
        //Parent activity is not touched
        node.parent.get.item.active should equal(true)
        ()
      }
    } once()
    endAttemptService(tree.children(0))
  }

  it can "process a non-leaf activity without suspended children, unsuspending it, setting it to inactive and rolling up" in {
    val tree = threeLevelTree(suspendedLevel = Some(2), currentLevel = Some(2))
    tree.suspendedActivity.get.item.suspended = false
    tree.suspendedActivity.get.parent.get.item.suspended should equal(true)
    rollupService expects 'apply withArgs(tree.children(0)) onCall {
      node:ActivityStateNode => {
        node.item.active should equal(false)
        node.item.suspended should equal(false)
        //Does not clear current activity
        tree.currentActivity should equal(Some(tree.children(0).children(0)))
        //Parent activity is not touched
        node.parent.get.item.active should equal(true)
        ()
      }
    } once()
    endAttemptService(tree.children(0))
  }

  it can "process a non-tracked leaf activity just setting it to inactive and rolling up" in {
    val tree = threeLevelTree(tracking = None, currentLevel = Some(2))
    rollupService expects 'apply withArgs(tree.children(0).children(0)) onCall {
      node:ActivityStateNode => {
        node.item.active should equal(false)
        //Does not clear current activity
        tree.currentActivity should equal(Some(tree.children(0).children(0)))
        //Parent activity is not touched
        node.parent.get.item.active should equal(true)
        ()
      }
    } once()
    endAttemptService(tree.children(0).children(0))
  }

  it can "process a suspended leaf activity just setting it to inactive and rolling up" in {
    val tree = threeLevelTree(suspendedLevel = Some(2), currentLevel = Some(2), tracking = Some(SequencingTracking.Default))
    rollupService expects 'apply withArgs(tree.children(0).children(0)) onCall {
      node:ActivityStateNode => {
        node.item.active should equal(false)
        //Does not clear current activity
        tree.currentActivity should equal(Some(tree.children(0).children(0)))
        //Parent activity is not touched
        node.parent.get.item.active should equal(true)
        ()
      }
    } once()
    endAttemptService(tree.children(0).children(0))
  }

  it can "process a set-by-content leaf activity just setting it to inactive and rolling up" in {
    val tree = threeLevelTree(currentLevel = Some(2), tracking = Some(new SequencingTracking(completionSetByContent = true, objectiveSetByContent = true)))
    rollupService expects 'apply withArgs(tree.children(0).children(0)) onCall {
      node:ActivityStateNode => {
        node.item.active should equal(false)
        //Does not clear current activity
        tree.currentActivity should equal(Some(tree.children(0).children(0)))
        //Parent activity is not touched
        node.parent.get.item.active should equal(true)
        ()
      }
    } once()
    endAttemptService(tree.children(0).children(0))
  }

  it can "process a not-set-by-content leaf activity setting it to inactive and rolling up, marking it completed and objective satisfied" in {
    val tree = threeLevelTree(currentLevel = Some(2), tracking = Some(SequencingTracking.Default), primaryObjectivesSet = true)
    tree.children(0).children(0).item.getCompletionStatus() should equal(None)
    tree.children(0).children(0).item.objectiveStates(None).getSatisfiedStatus should equal(None)
    rollupService expects 'apply withArgs(tree.children(0).children(0)) onCall {
      node:ActivityStateNode => {
        node.item.active should equal(false)
        node.item.getCompletionStatus() should equal(Some(true))
        node.item.objectiveStates(None).getSatisfiedStatus should equal(Some(true))
        //Does not clear current activity
        tree.currentActivity should equal(Some(tree.children(0).children(0)))
        //Parent activity is not touched
        node.parent.get.item.active should equal(true)
        ()
      }
    } once()
    endAttemptService(tree.children(0).children(0))
  }

  it can "process a not-set-by-content leaf activity just setting it to inactive and rolling up if completion and objective satisfaction have already been set" in {
    val tree = threeLevelTree(currentLevel = Some(2), tracking = Some(SequencingTracking.Default), primaryObjectivesSet = true)
    tree.children(0).children(0).item.setCompletionStatus(Some(false))
    tree.children(0).children(0).item.objectiveStates(None).setSatisfiedStatus(Some(false))
    rollupService expects 'apply withArgs(tree.children(0).children(0)) onCall {
      node:ActivityStateNode => {
        node.item.active should equal(false)
        node.item.getCompletionStatus() should equal(Some(false))
        node.item.objectiveStates(None).getSatisfiedStatus should equal(Some(false))
        //Does not clear current activity
        tree.currentActivity should equal(Some(tree.children(0).children(0)))
        //Parent activity is not touched
        node.parent.get.item.active should equal(true)
        ()
      }
    } once()
    endAttemptService(tree.children(0).children(0))
  }

  it can "process a not-set-by-content leaf activity setting it to inactive and rolling up, marking it completed, but not objective satisfied if primary objective is not defined" in {
    val tree = threeLevelTree(currentLevel = Some(2), tracking = Some(SequencingTracking.Default), primaryObjectivesSet = false)
    tree.children(0).children(0).item.getCompletionStatus() should equal(None)
    tree.children(0).children(0).item.objectiveStates.get(None) should equal(None)
    rollupService expects 'apply withArgs(tree.children(0).children(0)) onCall {
      node:ActivityStateNode => {
        node.item.active should equal(false)
        node.item.getCompletionStatus() should equal(Some(true))
        node.item.objectiveStates.get(None) should equal(None)
        //Does not clear current activity
        tree.currentActivity should equal(Some(tree.children(0).children(0)))
        //Parent activity is not touched
        node.parent.get.item.active should equal(true)
        ()
      }
    } once()
    endAttemptService(tree.children(0).children(0))
  }
}
