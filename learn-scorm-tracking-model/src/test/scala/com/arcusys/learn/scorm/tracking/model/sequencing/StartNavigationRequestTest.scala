package com.arcusys.learn.scorm.tracking.model.sequencing

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class StartNavigationRequestTest extends NavigationRequestServiceTestBase(NavigationRequestType.Start) {
  "Start navigation request" should "succeed for no current activity (1.1.1)" in {
    expectResult(NavigationResponseWithoutTermination, rootOnlyTree())
  }

  it should "fail for defined current activity (1.2.1)" in {
    expectResult(NavigationResponseInvalid, rootOnlyTree(hasCurrent = true))
  }
}