package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ChoiceSequencingRequestTest extends SequencingRequestServiceTestBase(SequencingRequestType.Choice) {
  "Choice sequencing request" should "fail if target cannot be reached via available children (3.1.1.1)" in {
    pending
  }

  it should "fail if target or one of its ancestors is hidden from choice via precondition rules (3.3.1)" in {
    val hidingRuleSet = Seq(new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.Always)), PreConditionAction.HiddenFromChoice))
    expectResultWithTarget(SequencingResponseInvalid,
      (threeLevelTree(rightRightPreConditionRules = hidingRuleSet), _.children(1).children(1).item.activity.id),
      (threeLevelTree(rightPreConditionRules = hidingRuleSet), _.children(1).children(1).item.activity.id),
      (threeLevelTree(rootPreConditionRules = hidingRuleSet), _.children(1).children(1).item.activity.id)
    )
  }

  it should "fail if sequencing control choice is disabled for parent of target (4.1.1)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    expectResultWithTarget(SequencingResponseInvalid,
      (threeLevelTree(rightPermissions = parentPermissions), _.children(1).children(1).item.activity.id),
      (threeLevelTree(rootPermissions = parentPermissions), _.children(1).item.activity.id)
    )
  }

  it should "succeed with target activity delivery if target activity is leaf and equals to current activity (7.1, 12.1, case #1)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = false, flowForChildren = false, forwardOnlyForChildren = true)
    val tree = threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions)
    expectResultWithTarget(SequencingResponseDelivery(tree.children(0).children(0)),
      (tree, _.children(0).children(0).item.activity.id)
    )
  }

  it should "fail if target activity is sibling ahead and current activity has stop forward traversal precondition rule (8.5.2.1, case #2)" in {
    val stoppingRuleSet = Seq(new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.Always)), PreConditionAction.StopForwardTraversal))
    val tree = twoLevelWideTree(currentLevel = Some(1), leftPreConditionRules = stoppingRuleSet)
    expectResultWithTarget(SequencingResponseInvalid,
      (tree, _.children(2).item.activity.id)
    )
  }

  it should "fail if target activity is sibling ahead and one of activites between current and targer has stop forward traversal precondition rule (8.5.2.1, case #2)" in {
    val stoppingRuleSet = Seq(new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.Always)), PreConditionAction.StopForwardTraversal))
    val tree = twoLevelWideTree(currentLevel = Some(1), midPreConditionRules = stoppingRuleSet)
    expectResultWithTarget(SequencingResponseInvalid,
      (tree, _.children(2).item.activity.id)
    )
  }

  it should "succeed with target activity delivery if target activity is sibling ahead and nothing stops forward traversal (case #2)" in {
    val tree = twoLevelWideTree(currentLevel = Some(1))
    expectResultWithTarget(SequencingResponseDelivery(tree.children(2)),
      (tree, _.children(2).item.activity.id)
    )
  }

  it should "fail if target activity is sibling behind and parent has forward only for children set (8.5.2.1, case #2)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = true)
    val tree = twoLevelWideTree(rootPermissions = parentPermissions)
    tree.currentActivity = Some(tree.children(2))
    expectResultWithTarget(SequencingResponseInvalid,
      (tree, _.children(0).item.activity.id)
    )
  }

  it should "fail if target is below current and one of target's ancestors up to current has stop forward traversal precondition rule (9.3.2.1, case #3)" in {
    val stoppingRuleSet = Seq(new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.Always)), PreConditionAction.StopForwardTraversal))
    expectResultWithTarget(SequencingResponseInvalid,
      (threeLevelTree(currentLevel = Some(0), rootPreConditionRules = stoppingRuleSet), _.children(1).children(1).item.activity.id),
      (threeLevelTree(currentLevel = Some(0), rightPreConditionRules = stoppingRuleSet), _.children(1).children(1).item.activity.id),
      (threeLevelTree(currentLevel = Some(0), rootPreConditionRules = stoppingRuleSet), _.children(1).item.activity.id),
      (threeLevelTree(currentLevel = Some(1), leftPreConditionRules = stoppingRuleSet), _.children(0).children(1).item.activity.id)
    )
  }

  it should "fail if target is below current and one of target's ancestors up to but not including current is not active and has prevent children activation set (9.3.3.1, case #3)" in {
    expectResultWithTarget(SequencingResponseInvalid,
      (threeLevelTree(currentLevel = Some(0), rightPreventChildrenActivation = true), _.children(1).children(1).item.activity.id)
    )
  }

  it should "fail if current is not defined and one of target's ancestors has stop forward traversal precondition rule (9.3.2.1., case #3)" in {
    val stoppingRuleSet = Seq(new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.Always)), PreConditionAction.StopForwardTraversal))
    expectResultWithTarget(SequencingResponseInvalid,
      (threeLevelTree(rootPreConditionRules = stoppingRuleSet), _.children(1).children(1).item.activity.id),
      (threeLevelTree(rightPreConditionRules = stoppingRuleSet), _.children(1).children(1).item.activity.id),
      (threeLevelTree(rootPreConditionRules = stoppingRuleSet), _.children(1).item.activity.id)
    )
  }

  it should "fail if current is not defined and one of target's ancestors not including root is not active and has prevent children activation set (9.3.3.1, case #3)" in {
    expectResultWithTarget(SequencingResponseInvalid,
      (threeLevelTree(rightPreventChildrenActivation = true), _.children(1).children(1).item.activity.id)
    )
  }

  it should "fail if target is above current and current or one of its ancestors not including target has sequencing control choice exit = false (10.3.1.1.1, case #4)" in {
    val cannotExitPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)
    expectResultWithTarget(SequencingResponseInvalid,
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExitPermissions), _.item.activity.id),
      (threeLevelTree(currentLevel = Some(1), leftPermissions = cannotExitPermissions), _.item.activity.id),
      (threeLevelTree(currentLevel = Some(2), leftPermissions = cannotExitPermissions), _.item.activity.id),
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExitPermissions), _.children(0).item.activity.id)
    )
  }

  it should "deliver current if target is above current and target has sequencing control choice exit = false (10.3.1.1.1, case #4)" in {
    val cannotExitPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)
    val canExitAndFlowPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    val tree = threeLevelTree(currentLevel = Some(2), rootPermissions = cannotExitPermissions, leftPermissions = canExitAndFlowPermissions)

    expectResultWithTarget(SequencingResponseDelivery(tree.children(0).children(0)), (tree, _.item.activity.id))
  }

  it should "fail if target is in other branch with current and current or one of its ancestors not including common ancestor has sequencing control choice exit = false (11.4.1.1, case #5)" in {
    val cannotExitPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)
    expectResultWithTarget(SequencingResponseInvalid,
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExitPermissions), _.children(1).children(1).item.activity.id),
      (threeLevelTree(currentLevel = Some(1), leftPermissions = cannotExitPermissions), _.children(1).children(1).item.activity.id),
      (threeLevelTree(currentLevel = Some(2), leftPermissions = cannotExitPermissions), _.children(1).children(1).item.activity.id),
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExitPermissions), _.children(1).item.activity.id)
    )
  }

  it should "fail if target is in other branch with current, forward in tree, and one of target's ancestors has stop forward traversal precondition rule (11.8.1.2.1, case #5)" in {
    val stoppingRuleSet = Seq(new PreConditionRule(RuleConditionSet(new RuleCondition(ConditionType.Always)), PreConditionAction.StopForwardTraversal))
    expectResultWithTarget(SequencingResponseInvalid,
      (threeLevelTree(currentLevel = Some(1), rootPreConditionRules = stoppingRuleSet), _.children(1).children(1).item.activity.id),
      (threeLevelTree(currentLevel = Some(1), rightPreConditionRules = stoppingRuleSet), _.children(1).children(1).item.activity.id),
      (threeLevelTree(currentLevel = Some(2), rootPreConditionRules = stoppingRuleSet), _.children(1).item.activity.id)
    )
  }

  it should "fail if target is in other branch with current, forward in tree, and one of target's ancestors (excluding common) is not active and has prevent children activation set (11.8.1.3.1, case #5)" in {
    expectResultWithTarget(SequencingResponseInvalid,
      (threeLevelTree(currentLevel = Some(1), rightPreventChildrenActivation = true), _.children(1).children(1).item.activity.id),
      (threeLevelTree(currentLevel = Some(2), rightPreventChildrenActivation = true), _.children(1).children(1).item.activity.id)
    )
  }

  it should "fail if target is in other branch with current, backward in tree, and one of target's ancestors (excluding common) is not active and has prevent children activation set (11.8.1.3.1, case #5)" in {
    val tree = threeLevelTree(leftPreventChildrenActivation = true)
    tree.currentActivity = Some(tree.children(1).children(1))
    expectResultWithTarget(SequencingResponseInvalid, (tree, _.children(0).children(0).item.activity.id))
  }

  it should "fail if target is in other branch with current, backward in tree, and target is not active and has prevent children activation set (11.8.1.3.1, case #5)" in {
    val tree = threeLevelTree(leftLeftPreventChildrenActivation = true)
    tree.currentActivity = Some(tree.children(1).children(1))
    expectResultWithTarget(SequencingResponseInvalid, (tree, _.children(0).children(0).item.activity.id))
  }
}