package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class CompletionThresholdTest extends FlatSpec with ShouldMatchers {

  "Completion threshold" can "be constructed" in {
    val threshold = new CompletionThreshold(completedByMeasure = true, minProgressMeasure = 0.7, progressWeight = 0.8)
    threshold.completedByMeasure should equal(true)
    threshold.minProgressMeasure should equal(BigDecimal(0.7))
    threshold.progressWeight should equal(BigDecimal(0.8))
  }

  it can "not be constructed with min progress measure greater than 1" in {
    intercept[IllegalArgumentException] {
      new CompletionThreshold(completedByMeasure = true, minProgressMeasure = 1.7, progressWeight = 0.8)
    }
  }

  it can "not be constructed with min progress measure less than 0" in {
    intercept[IllegalArgumentException] {
      new CompletionThreshold(completedByMeasure = true, minProgressMeasure = -0.1, progressWeight = 0.8)
    }
  }

  it can "not be constructed with progress weight greater than 1" in {
    intercept[IllegalArgumentException] {
      new CompletionThreshold(completedByMeasure = true, minProgressMeasure = 0.7, progressWeight = 1.1)
    }
  }

  it can "not be constructed with progress weight less than 0" in {
    intercept[IllegalArgumentException] {
      new CompletionThreshold(completedByMeasure = true, minProgressMeasure = 0.1, progressWeight = -0.8)
    }
  }

  it should "have a default value" in {
    val threshold = CompletionThreshold.Default
    threshold.completedByMeasure should equal(false)
    threshold.minProgressMeasure should equal(BigDecimal(1))
    threshold.progressWeight should equal(BigDecimal(1))
  }
}
