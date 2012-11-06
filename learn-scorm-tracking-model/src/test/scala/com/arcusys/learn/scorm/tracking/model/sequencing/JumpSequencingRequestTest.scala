package com.arcusys.learn.scorm.tracking.model.sequencing

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class JumpSequencingRequestTest extends SequencingRequestServiceTestBase(SequencingRequestType.Jump) {
  "Jump sequencing request" should "fail for non-defined current activity (1.1)" in {
    expectResultWithTarget(SequencingResponseInvalid,
      (twoLevelTree(), _.children(1).item.activity.id),
      (twoLevelTree(suspendedLevel = Some(1)), _.children(1).item.activity.id)
    )
  }

  it should "succeed with delivery of target activity for any defined current activity" in {
    val tree = twoLevelTree(currentLevel = Some(1))
    expectResultWithTarget(SequencingResponseDelivery(tree.children(1)), (tree, _.children(1).item.activity.id)
    )
  }
}