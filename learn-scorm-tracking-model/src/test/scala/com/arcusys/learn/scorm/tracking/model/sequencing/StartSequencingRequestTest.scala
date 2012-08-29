package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model.SequencingPermissions

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class StartSequencingRequestTest extends SequencingRequestServiceTestBase(SequencingRequestType.Start) {
  "Start sequencing request" should "fail for defined current activity (1.1)" in {
    expectResult(SequencingResponseInvalid,
      twoLevelTree(currentLevel = Some(0)),
      twoLevelTree(currentLevel = Some(1), suspendedLevel = Some(1))
    )
  }

  it should "succeed with delivery of first leaf if current activity is not defined (3.3.1)" in {
    val permissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = true)
    val tree = twoLevelTree(rootPermissions = permissions)
    expectResult(SequencingResponseDelivery(tree.children(0)), tree)
    val anotherTree = threeLevelTree(rootPermissions = permissions, leftPermissions = permissions)
    expectResult(SequencingResponseDelivery(anotherTree.children(0).children(0)), anotherTree)
  }
}