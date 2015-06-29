package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.SequencingPermissions
import com.arcusys.valamis.lesson.scorm.model.sequencing.{ NavigationRequestType, NavigationResponseInvalid, NavigationResponseWithTermination, NavigationResponseWithoutTermination }

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ContinueNavigationRequestTest extends NavigationRequestServiceTestBase(NavigationRequestType.Continue) {
  "Continue navigation request" should "fail for no current activity (3.1.1)" in {
    expectResult(NavigationResponseInvalid,
      rootOnlyTree(),
      rootOnlyTree(hasSuspended = true)
    )
  }

  it should "succeed (with termination = exit) for non-root current activity if it's active and flow is enabled on parent (3.2.1.1)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    expectResult(NavigationResponseWithTermination,
      twoLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions, currentActive = true),
      threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions, currentActive = true),
      threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions, currentActive = true)
    )
  }

  it should "succeed (with empty termination) for non-root current activity if it's not active and flow is enabled on parent (3.2.2.1)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    expectResult(NavigationResponseWithoutTermination,
      twoLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions, currentActive = false),
      threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions, currentActive = false),
      threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions, currentActive = false)
    )
  }

  it should "fail for root current activity (3.3.1)" in {
    expectResult(NavigationResponseInvalid,
      rootOnlyTree(hasCurrent = true),
      twoLevelTree(currentLevel = Some(0)),
      threeLevelTree(currentLevel = Some(0))
    )
  }

  it should "fail for non-root current activity if flow is disabled on parent (3.3.1)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = false, forwardOnlyForChildren = false)
    expectResult(NavigationResponseInvalid,
      twoLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(1), rootPermissions = parentPermissions),
      threeLevelTree(currentLevel = Some(2), leftPermissions = parentPermissions)
    )
  }
}