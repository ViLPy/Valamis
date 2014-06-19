package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model.SequencingPermissions

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class PreviousSequencingRequestTest extends SequencingRequestServiceTestBase(SequencingRequestType.Previous) {
  "Previous sequencing request" should "fail for non-defined current activity (1.1)" in {
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

  it should "fail if parent of current activity has forward only for children set" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = true)
    expectResult(SequencingResponseInvalid,
      twoLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions)
    )
  }

  it should "fail if current activity is first leaf" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)
    expectResult(SequencingResponseInvalid,
      twoLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions)
    )
  }

  it should "fail if current activity is root" in {
    expectResult(SequencingResponseInvalid,
      twoLevelTree(currentLevel = Some(0)),
      threeLevelTree(currentLevel = Some(0))
    )
  }

  it should "fail if current activity is container of first leaf" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)
    expectResult(SequencingResponseInvalid, threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions))
  }

  it should "succeed with delivery of previous sibling leaf if current activity is last leaf in parent" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)
    val tree = threeLevelTree(leftPermissions = parentPermissions)
    tree.currentActivity = Some(tree.children(0).children(1))
    expectResult(SequencingResponseDelivery(tree.children(0).children(0)), tree)
  }

  it should "succeed with delivery of last leaf in previous container if current activity is first leaf in parent" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)
    val tree = threeLevelTree(rightPermissions = parentPermissions, rootPermissions = parentPermissions, leftPermissions = parentPermissions)
    tree.currentActivity = Some(tree.children(1).children(0))
    expectResult(SequencingResponseDelivery(tree.children(0).children(1)), tree)
  }

  it should "succeed with delivery of last leaf in previous container if current activity is last container " in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)
    val tree = threeLevelTree(rootPermissions = parentPermissions, leftPermissions = parentPermissions)
    tree.currentActivity = Some(tree.children(1))
    expectResult(SequencingResponseDelivery(tree.children(0).children(1)), tree)
  }
}