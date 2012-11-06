package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, ActivityStateNode}

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ExitPathTest extends ActivityStateTreeTestBase {
  "Exit path" should "return current activity only if activities are siblings" in {
    def forTree(tree: ActivityStateTree, targetActivity: ActivityStateTree => ActivityStateNode) {
      val path = tree.currentActivity.get pathToCommonAncestorWith targetActivity(tree)
      path.size should equal(1)
      path(0) should equal(tree.currentActivity.get)
    }
    forTree(twoLevelTree(currentLevel = Some(1)), _.children(1))
    forTree(threeLevelTree(currentLevel = Some(1)), _.children(1))
    forTree(threeLevelTree(currentLevel = Some(2)), _.children(0))
  }

  it should "return current activity only if target == current" in {
    def forTree(tree: ActivityStateTree, targetActivity: ActivityStateTree => ActivityStateNode) {
      val path = tree.currentActivity.get pathToCommonAncestorWith targetActivity(tree)
      path.size should equal(1)
      path(0) should equal(tree.currentActivity.get)
    }
    forTree(twoLevelTree(currentLevel = Some(1)), _.currentActivity.get)
    forTree(threeLevelTree(currentLevel = Some(1)), _.currentActivity.get)
    forTree(threeLevelTree(currentLevel = Some(2)), _.currentActivity.get)
  }

  it should "return path [current_activity, common_ancestor) if one activity is not descendant of other" in {
    def forTree(tree: ActivityStateTree, targetActivity: ActivityStateTree => ActivityStateNode, expectedPathEnd: ActivityStateTree => ActivityStateNode) {
      val path = tree.currentActivity.get pathToCommonAncestorWith targetActivity(tree)
      path.head should equal(tree.currentActivity.get)
      path.last should equal(expectedPathEnd(tree))
      for (i <- 0 until path.size - 1) path(i).parent.get should equal(path(i + 1))
    }

    forTree(threeLevelTree(currentLevel = Some(2)), _.children(1), _.children(0))
    forTree(threeLevelTree(currentLevel = Some(2)), _.children(1), _.children(0))
  }

  it should "return path [current_activity, root) if target activity is organization/root" in {
    def forTree(tree: ActivityStateTree) {
      val path = tree.currentActivity.get pathToCommonAncestorWith tree
      path.head should equal(tree.currentActivity.get)
      path.last.parent.get should equal(tree)
      for (i <- 0 until path.size - 1) path(i).item.activity.parentID.get should equal(path(i + 1).item.activity.id)
    }

    forTree(twoLevelTree(currentLevel = Some(1)))
    forTree(threeLevelTree(currentLevel = Some(1)))
    forTree(threeLevelTree(currentLevel = Some(2)))
  }

  it should "return empty path if target is descendant of current" in {
    def forTree(tree: ActivityStateTree, targetActivity: ActivityStateTree => ActivityStateNode) {
      val path = tree.currentActivity.get pathToCommonAncestorWith targetActivity(tree)
      path.size should equal(0)
    }
    forTree(twoLevelTree(currentLevel = Some(0)), _.children(0))
    forTree(threeLevelTree(currentLevel = Some(0)), _.children(0))
    forTree(threeLevelTree(currentLevel = Some(0)), _.children(0))
    forTree(threeLevelTree(currentLevel = Some(1)), _.children(0).children(0))
  }

  it should "return path[current_activity, target_activity) if current is descendant of target" in {
    def forTree(tree: ActivityStateTree, targetActivity: ActivityStateTree => ActivityStateNode) {
      val path = tree.currentActivity.get pathToCommonAncestorWith targetActivity(tree)
      path.head should equal(tree.currentActivity.get)
      path.last.parent.get should equal(targetActivity(tree))
      for (i <- 0 until path.size - 1) path(i).parent.get should equal(path(i + 1))
    }
    forTree(twoLevelTree(currentLevel = Some(1)), targetActivity = tree => tree)
    forTree(threeLevelTree(currentLevel = Some(1)), targetActivity = tree => tree)
    forTree(threeLevelTree(currentLevel = Some(2)), targetActivity = tree => tree)
    forTree(threeLevelTree(currentLevel = Some(2)), targetActivity = _.children(0))
  }
}