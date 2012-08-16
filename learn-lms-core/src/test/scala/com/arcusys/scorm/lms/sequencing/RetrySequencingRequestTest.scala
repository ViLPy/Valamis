package com.arcusys.scorm.lms.sequencing

import model._
import com.arcusys.learn.scorm.manifest.model.SequencingPermissions

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class RetrySequencingRequestTest extends SequencingRequestServiceTestBase(SequencingRequestType.Retry) {
  "Retry sequencing request" should "fail for non-defined current activity (1.1)" in {
    expectResult(SequencingResponseInvalid,
      twoLevelTree(),
      twoLevelTree(suspendedLevel = Some(1))
    )
  }

  it should "fail for active current activity (2.1)" in {
    expectResult(SequencingResponseInvalid, twoLevelTree(currentLevel = Some(1), currentActive = true))
  }

  it should "fail for suspended current activity (2.1)" in {
    expectResult(SequencingResponseInvalid, twoLevelTree(currentLevel = Some(1), currentActive = false, suspendedLevel = Some(1)))
  }

  it should "succeed with a delivery request for next leaf if current activity is not a leaf (3.3.1)" in {
    val permissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = true)
    val tree = twoLevelTree(currentLevel = Some(0), currentActive = false, rootPermissions = permissions)
    expectResult(SequencingResponseDelivery(tree.children(0)), tree)
  }

  it should "succeed with a delivery response for the current activity if it is a leaf (4.1)" in {
    val tree = twoLevelTree(currentLevel = Some(1), currentActive = false)
    val currentActivity = tree.currentActivity.get
    expectResult(SequencingResponseDelivery(currentActivity), tree)
  }
}