package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model.SequencingPermissions

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ContinueSequencingRequestTest extends SequencingRequestServiceTestBase(SequencingRequestType.Continue) {
  "Continue sequencing request" should "fail for non-defined current activity (1.1)" in {
    expectResult(SequencingResponseInvalid,
      twoLevelTree(),
      twoLevelTree(suspendedLevel = Some(1))
    )
  }

  it should "fail if parent of current activity has sequencing control flow disabled" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false)
    expectResult(SequencingResponseInvalid,
      twoLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions)
    )
  }

  it should "succeed with end session if current activity is last leaf (ending sessions on curret's ancestors except for root)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = true)
    val tree = twoLevelTree(rootPermissions = parentPermissions)
    tree.currentActivity = Some(tree.children(1))

    expectResult(SequencingResponseEndSession, tree)
    val anotherTree = threeLevelTree(rightPermissions = parentPermissions)

    anotherTree.currentActivity = Some(anotherTree.children(1).children(1))
    endAttemptService expects 'apply withArgs (anotherTree.children(1)) once()
    expectResult(SequencingResponseEndSession, anotherTree)
  }

  it should "succeed with end session if current activity is root" in {
    val tree = twoLevelTree(currentLevel = Some(0))
    expectResult(SequencingResponseEndSession, tree)
    val anotherTree = threeLevelTree(currentLevel = Some(0))
    expectResult(SequencingResponseEndSession, anotherTree)
  }

  it should "succeed with delivery of first leaf in second container if current activity is first container" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = true)
    val tree = threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions, rightPermissions = parentPermissions)
    expectResult(SequencingResponseDelivery(tree.children(1).children(0)), tree)
  }

  it should "succeed with delivery of next sibling leaf if current activity is first leaf in parent" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = true)
    val tree = threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions)
    expectResult(SequencingResponseDelivery(tree.children(0).children(1)), tree)
  }

  it should "succeed with delivery of first leaf in next container if current activity is last leaf in parent" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = true)
    val tree = threeLevelTree(leftPermissions = parentPermissions, rootPermissions = parentPermissions, rightPermissions = parentPermissions)
    tree.currentActivity = Some(tree.children(0).children(1))
    expectResult(SequencingResponseDelivery(tree.children(1).children(0)), tree)
  }
}