package com.arcusys.valamis.lesson.scorm.model

import com.arcusys.valamis.lesson.scorm.model.manifest.SequencingTracking
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

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
