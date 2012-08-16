package com.arcusys.scorm.lms.sequencing

import model._

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ResumeAllSequencingRequestTest extends SequencingRequestServiceTestBase(SequencingRequestType.ResumeAll) {
  "Resume All sequencing request" should "fail for defined current activity (1.1)" in {
    expectResult(SequencingResponseInvalid, twoLevelTree(currentLevel = Some(1), suspendedLevel = Some(1)))
  }

  it should "fail for non-defined suspended activity (2.1)" in {
    expectResult(SequencingResponseInvalid, twoLevelTree())
  }

  it should "succeed with delivery response for suspended activity (3)" in {
    val tree = twoLevelTree(suspendedLevel = Some(1))
    val suspendedActivity = tree.suspendedActivity.get
    expectResult(SequencingResponseDelivery(suspendedActivity), tree)
  }
}