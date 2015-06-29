package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.sequencing.{ NavigationRequestType, NavigationResponseInvalid, NavigationResponseWithoutTermination }

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ResumeAllNavigationRequestTest extends NavigationRequestServiceTestBase(NavigationRequestType.ResumeAll) {
  "Resume All navigation request" should "succeed for no current activity and defined suspended activity (2.1.1.1)" in {
    expectResult(NavigationResponseWithoutTermination, rootOnlyTree(hasSuspended = true))
  }

  it should "fail for no current activity and no suspended activity (2.1.2.1)" in {
    expectResult(NavigationResponseInvalid, rootOnlyTree())
  }

  it should "fail for defined current activity (2.2.1)" in {
    expectResult(NavigationResponseInvalid, rootOnlyTree(hasCurrent = true))
  }
}