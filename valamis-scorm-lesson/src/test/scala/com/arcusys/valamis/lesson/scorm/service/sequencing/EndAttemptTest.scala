package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.SequencingTracking
import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateNode
import com.escalatesoft.subcut.inject.NewBindingModule

class EndAttemptTest extends ActivityStateTreeTestBase {

  def createService(dependency: RollupServiceContract): EndAttemptServiceContract = {
    new EndAttemptService()(new NewBindingModule({ implicit module =>
      import module._
      bind[RollupServiceContract] toSingle dependency
    }))
  }

  "End attempt service" can "process a non-leaf activity with suspended children, " +
    "suspending it, setting it to inactive and rolling up" in {
      val tree = threeLevelTree(suspendedLevel = Some(2), currentLevel = Some(2))

      val mockRollupService = mock[RollupServiceContract]
      (mockRollupService.apply _) expects (tree.children(0)) onCall {
        node: ActivityStateNode =>
          {
            node.item.active should equal(false)
            node.item.suspended should equal(true)
            //Does not clear current activity
            tree.currentActivity should equal(Some(tree.children(0).children(0)))
            //Parent activity is not touched
            node.parent.get.item.active should equal(true)
            ()
          }
      } once ()

      val service = createService(mockRollupService)
      service(tree.children(0))
    }

  it can "process a non-leaf activity without suspended children, unsuspending it, setting it to inactive and rolling up" in {
    val tree = threeLevelTree(suspendedLevel = Some(2), currentLevel = Some(2))
    tree.suspendedActivity.get.item.suspended = false
    tree.suspendedActivity.get.parent.get.item.suspended should equal(true)

    val mockRollingUp = mock[RollupServiceContract]
    (mockRollingUp.apply _) expects (tree.children(0)) onCall {
      node: ActivityStateNode =>
        {
          node.item.active should equal(false)
          node.item.suspended should equal(false)
          //Does not clear current activity
          tree.currentActivity should equal(Some(tree.children(0).children(0)))
          //Parent activity is not touched
          node.parent.get.item.active should equal(true)
          ()
        }
    } once ()

    val service = createService(mockRollingUp)
    service(tree.children(0))
  }

  it can "process a non-tracked leaf activity just setting it to inactive and rolling up" in {
    val tree = threeLevelTree(tracking = None, currentLevel = Some(2))
    val secondLeveledChild = tree.children(0).children(0)

    val mockRollingUp = mock[RollupServiceContract]
    (mockRollingUp.apply _) expects (secondLeveledChild) onCall {
      node: ActivityStateNode =>
        {
          node.item.active should equal(false)
          //Does not clear current activity
          tree.currentActivity should equal(Some(tree.children(0).children(0)))
          //Parent activity is not touched
          node.parent.get.item.active should equal(true)
          ()
        }
    } once ()

    val service = createService(mockRollingUp)
    service(secondLeveledChild)
  }

  it can "process a suspended leaf activity just setting it to inactive and rolling up" in {
    val tree = threeLevelTree(suspendedLevel = Some(2), currentLevel = Some(2), tracking = Some(SequencingTracking.Default))
    val secondLeveledChild = tree.children(0).children(0)

    val mockRollingUp = mock[RollupServiceContract]
    (mockRollingUp.apply _) expects (secondLeveledChild) onCall {
      node: ActivityStateNode =>
        {
          node.item.active should equal(false)
          //Does not clear current activity
          tree.currentActivity should equal(Some(tree.children(0).children(0)))
          //Parent activity is not touched
          node.parent.get.item.active should equal(true)
          ()
        }
    } once ()

    val service = createService(mockRollingUp)
    service(secondLeveledChild)
  }

  it can "process a set-by-content leaf activity just setting it to inactive and rolling up" in {
    val tree = threeLevelTree(currentLevel = Some(2), tracking = Some(new SequencingTracking(completionSetByContent = true, objectiveSetByContent = true)))
    val secondLeveledChild = tree.children(0).children(0)

    val mockRollingUp = mock[RollupServiceContract]
    (mockRollingUp.apply _) expects (secondLeveledChild) onCall {
      node: ActivityStateNode =>
        {
          node.item.active should equal(false)
          //Does not clear current activity
          tree.currentActivity should equal(Some(tree.children(0).children(0)))
          //Parent activity is not touched
          node.parent.get.item.active should equal(true)
          ()
        }
    } once ()

    val service = createService(mockRollingUp)
    service(secondLeveledChild)
  }

  it can "process a not-set-by-content leaf activity setting it to inactive and rolling up, marking it completed and objective satisfied" in {
    val tree = threeLevelTree(currentLevel = Some(2), tracking = Some(SequencingTracking.Default), primaryObjectivesSet = true)
    tree.children(0).children(0).item.getCompletionStatus() should equal(None)
    tree.children(0).children(0).item.objectiveStates(None).getSatisfiedStatus should equal(None)
    val secondLeveledChild = tree.children(0).children(0)

    val mockRollingUp = mock[RollupServiceContract]
    (mockRollingUp.apply _) expects (secondLeveledChild) onCall {
      node: ActivityStateNode =>
        {
          node.item.active should equal(false)
          node.item.getCompletionStatus() should equal(Some(true))
          node.item.objectiveStates(None).getSatisfiedStatus should equal(Some(true))
          //Does not clear current activity
          tree.currentActivity should equal(Some(tree.children(0).children(0)))
          //Parent activity is not touched
          node.parent.get.item.active should equal(true)
          ()
        }
    } once ()

    val service = createService(mockRollingUp)
    service(secondLeveledChild)
  }

  it can "process a not-set-by-content leaf activity just setting it to inactive and " +
    "rolling up if completion and objective satisfaction have already been set" in {
      val tree = threeLevelTree(currentLevel = Some(2), tracking = Some(SequencingTracking.Default), primaryObjectivesSet = true)
      tree.children(0).children(0).item.setCompletionStatus(Some(false))
      tree.children(0).children(0).item.objectiveStates(None).setSatisfiedStatus(Some(false))
      val secondLeveledChild = tree.children(0).children(0)

      val mockRollingUp = mock[RollupServiceContract]
      (mockRollingUp.apply _).expects(secondLeveledChild) onCall {
        node: ActivityStateNode =>
          {
            node.item.active should equal(false)
            node.item.getCompletionStatus() should equal(Some(false))
            node.item.objectiveStates(None).getSatisfiedStatus should equal(Some(false))
            //Does not clear current activity
            tree.currentActivity should equal(Some(tree.children(0).children(0)))
            //Parent activity is not touched
            node.parent.get.item.active should equal(true)
            ()
          }
      } once ()

      val service = createService(mockRollingUp)
      service(secondLeveledChild)
    }

  it can "process a not-set-by-content leaf activity setting it to inactive and rolling up," +
    " marking it completed, but not objective satisfied if primary objective is not defined" in {
      val tree = threeLevelTree(currentLevel = Some(2), tracking = Some(SequencingTracking.Default), primaryObjectivesSet = false)
      tree.children(0).children(0).item.getCompletionStatus() should equal(None)
      tree.children(0).children(0).item.objectiveStates.get(None) should equal(None)
      val secondLeveledChild = tree.children(0).children(0)

      val mockRollingUp = mock[RollupServiceContract]
      (mockRollingUp.apply _) expects (secondLeveledChild) onCall {
        node: ActivityStateNode =>
          {
            node.item.active should equal(false)
            node.item.getCompletionStatus() should equal(Some(true))
            node.item.objectiveStates.get(None) should equal(None)
            //Does not clear current activity
            tree.currentActivity should equal(Some(tree.children(0).children(0)))
            //Parent activity is not touched
            node.parent.get.item.active should equal(true)
            ()
          }
      } once ()

      val service = createService(mockRollingUp)
      service(secondLeveledChild)
    }
}
