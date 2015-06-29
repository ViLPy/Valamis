package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.sequencing.{ SequencingRequestType, SequencingResponseEmpty, SequencingResponseEndSession, SequencingResponseInvalid }

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ExitSequencingRequestTest extends SequencingRequestServiceTestBase(SequencingRequestType.Exit) {
  "Exit sequencing request" should "fail for non-defined current activity (1.1)" in {
    expectResult(SequencingResponseInvalid,
      twoLevelTree(),
      twoLevelTree(suspendedLevel = Some(1))
    )
  }

  it should "fail if current activity is active (2.1)" in {
    expectResult(SequencingResponseInvalid,
      twoLevelTree(currentLevel = Some(1), currentActive = true),
      twoLevelTree(currentLevel = Some(1), currentActive = true, suspendedLevel = Some(1))
    )
  }

  it should "succeed with session end response if current activity is root (3.1)" in {
    expectResult(SequencingResponseEndSession,
      twoLevelTree(currentLevel = Some(0), currentActive = false),
      twoLevelTree(currentLevel = Some(0), currentActive = false, suspendedLevel = Some(1)),
      threeLevelTree(currentLevel = Some(0), currentActive = false, suspendedLevel = Some(2))
    )
  }

  it should "succeed with empty response if current activity is not root (4)" in {
    expectResult(SequencingResponseEmpty,
      twoLevelTree(currentLevel = Some(1), currentActive = false),
      twoLevelTree(currentLevel = Some(1), currentActive = false, suspendedLevel = Some(1)),
      threeLevelTree(currentLevel = Some(2), currentActive = false)
    )
  }
}