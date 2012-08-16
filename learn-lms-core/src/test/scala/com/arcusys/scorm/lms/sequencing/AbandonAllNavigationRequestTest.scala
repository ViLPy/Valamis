package com.arcusys.scorm.lms.sequencing

import model._

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class AbandonAllNavigationRequestTest extends NavigationRequestServiceTestBase(NavigationRequestType.AbandonAll) {
  "Abandon All navigation request" should "succeed if current activity is defined (11.1.1)" in {
    expectResult(NavigationResponseWithTermination, rootOnlyTree(hasCurrent = true))
  }

  it should "fail if current activity is not defined (11.2.1)" in {
    expectResult(NavigationResponseInvalid, rootOnlyTree())
  }
}