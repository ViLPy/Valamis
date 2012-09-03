package com.arcusys.learn.scorm.tracking.model.sequencing

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ExitNavigationRequestTest extends NavigationRequestServiceTestBase(NavigationRequestType.Exit) {
  "Exit navigation request" should "succeed (with termination) for current activity active (8.1.1.1)" in {
    expectResult(NavigationResponseWithTermination,
      rootOnlyTree(hasCurrent = true, currentActive = true),
      twoLevelTree(currentLevel = Some(1), currentActive = true),
      twoLevelTree(currentLevel = Some(0), currentActive = true),
      threeLevelTree(currentLevel = Some(0), currentActive = true),
      threeLevelTree(currentLevel = Some(1), currentActive = true),
      threeLevelTree(currentLevel = Some(2), currentActive = true)
    )
  }

  it should "fail for current activity not active (8.1.2.1)" in {
    expectResult(NavigationResponseInvalid,
      rootOnlyTree(hasCurrent = true, currentActive = false),
      twoLevelTree(currentLevel = Some(1), currentActive = false),
      twoLevelTree(currentLevel = Some(0), currentActive = false),
      threeLevelTree(currentLevel = Some(0), currentActive = false),
      threeLevelTree(currentLevel = Some(1), currentActive = false),
      threeLevelTree(currentLevel = Some(2), currentActive = false)
    )
  }

  it should "fail for current activity not defined (8.2.1)" in {
    expectResult(NavigationResponseInvalid, rootOnlyTree())
  }
}