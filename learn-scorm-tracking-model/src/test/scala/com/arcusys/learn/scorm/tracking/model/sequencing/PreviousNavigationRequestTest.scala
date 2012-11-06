package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class PreviousNavigationRequestTest extends NavigationRequestServiceTestBase(NavigationRequestType.Previous) {
  "Previous navigation request" should "fail for no current activity (4.1.1)" in {
    expectResult(NavigationResponseInvalid,
      rootOnlyTree(),
      rootOnlyTree(hasSuspended = true)
    )
  }

  it should "succeed (with termination = exit) for non-root current activity if it's active and on parent flow is enabled and forward-only is not set (4.2.1.1.1)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    expectResult(NavigationResponseWithTermination,
      twoLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions, currentActive = true),
      threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions, currentActive = true),
      threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions, currentActive = true)
    )
  }

  it should "succeed (with empty termination) for non-root current activity if it's not active and on parent flow is enabled and forward-only is not set (4.2.1.2.1)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    expectResult(NavigationResponseWithTermination,
      twoLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions, currentActive = true),
      threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions, currentActive = true),
      threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions, currentActive = true)
    )
  }

  it should "fail for non-root current activity if on parent activity flow is enabled, but forward-only is set (4.2.2.1)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = true)
    expectResult(NavigationResponseInvalid,
      twoLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions)
    )
  }

  it should "fail for non-root current activity if on parent activity flow is disabled (4.2.2.1)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false)
    expectResult(NavigationResponseInvalid,
      twoLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions)
    )
  }

  it should "fail for root current activity (4.3.1)" in {
    expectResult(NavigationResponseInvalid,
      rootOnlyTree(hasCurrent = true),
      twoLevelTree(currentLevel = Some(0)),
      threeLevelTree(currentLevel = Some(0))
    )
  }
}