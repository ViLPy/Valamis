package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class SequencingTrackingTest extends FlatSpec with ShouldMatchers {

  "Sequencing tracking" can "be constructed" in {
    val tracking = new SequencingTracking(completionSetByContent = true, objectiveSetByContent = true)
    tracking.completionSetByContent should equal(true)
    tracking.objectiveSetByContent should equal(true)
  }

  it should "have a default value" in {
    val tracking = SequencingTracking.Default
    tracking.completionSetByContent should equal(false)
    tracking.objectiveSetByContent should equal(false)
  }

}
