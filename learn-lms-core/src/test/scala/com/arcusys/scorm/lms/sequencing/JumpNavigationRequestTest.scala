package com.arcusys.scorm.lms.sequencing

import model._

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class JumpNavigationRequestTest extends NavigationRequestServiceTestBase(NavigationRequestType.Jump) {
  "Jump navigation request" should "succeed if target activity is selected as available child for its parent (13.1.1)" in {
    expectResultWithTarget(NavigationResponseWithTermination,
      (twoLevelTree(), _.children(1).item.activity.id),
      (threeLevelTree(), _.children(1).item.activity.id),
      (threeLevelTree(), _.children(1).children(1).item.activity.id)
    )
  }

  it should "fail if target activity is not selected as available child for its parent (13.2.1)" in {
    pending
    //TODO: we'll have to wait for our implementation of available children
  }

  it should "fail if target activity does not exist (13.2.1)" in {
    expectResultWithTarget(NavigationResponseInvalid, (twoLevelTree(), _=>"DUM"))
  }

  //That's just what we supposed. It's not in the standard and not confirmed
  it should "succeed if target activity is root" in {
    expectResultWithTarget(NavigationResponseWithTermination, (twoLevelTree(), _.item.activity.id))
  }
}