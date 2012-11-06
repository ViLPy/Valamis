package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class RollupContributionTest extends FlatSpec with ShouldMatchers {

  "Rollup contribution" can "be constructed" in {
    val contribution = new RollupContribution(
      satisfaction = Some(new SatisfactionRollupContribution(contributeToSatisfied = RollupConsiderationType.IfAttempted, contributeToNotSatisfied = RollupConsiderationType.IfNotSkipped)),
      completion = Some(new CompletionRollupContribution(contributeToCompleted = RollupConsiderationType.IfNotSuspended, contributeToIncomplete = RollupConsiderationType.Always)),
      objectiveMeasureWeight = BigDecimal("0.5"),
      measureSatisfactionIfActive = false
    )
    contribution.satisfaction.get.contributeToSatisfied should equal(RollupConsiderationType.IfAttempted)
    contribution.satisfaction.get.contributeToNotSatisfied should equal(RollupConsiderationType.IfNotSkipped)
    contribution.completion.get.contributeToCompleted should equal(RollupConsiderationType.IfNotSuspended)
    contribution.completion.get.contributeToIncomplete should equal(RollupConsiderationType.Always)
    contribution.objectiveMeasureWeight should equal(BigDecimal("0.5"))
    contribution.measureSatisfactionIfActive should equal(false)
  }

  it can "be constructed without satisfaction contribution" in {
    val contribution = new RollupContribution(
      satisfaction = None,
      completion = Some(new CompletionRollupContribution(contributeToCompleted = RollupConsiderationType.IfNotSuspended, contributeToIncomplete = RollupConsiderationType.Always)),
      objectiveMeasureWeight = BigDecimal("0.5"),
      measureSatisfactionIfActive = false
    )
    contribution.satisfaction should equal(None)
    contribution.completion.get.contributeToCompleted should equal(RollupConsiderationType.IfNotSuspended)
    contribution.completion.get.contributeToIncomplete should equal(RollupConsiderationType.Always)
    contribution.objectiveMeasureWeight should equal(BigDecimal("0.5"))
    contribution.measureSatisfactionIfActive should equal(false)
  }

  it can "be constructed without completion contribution" in {
    val contribution = new RollupContribution(
      satisfaction = Some(new SatisfactionRollupContribution(contributeToSatisfied = RollupConsiderationType.IfAttempted, contributeToNotSatisfied = RollupConsiderationType.IfNotSkipped)),
      completion = None,
      objectiveMeasureWeight = BigDecimal("0.5"),
      measureSatisfactionIfActive = false
    )
    contribution.satisfaction.get.contributeToSatisfied should equal(RollupConsiderationType.IfAttempted)
    contribution.satisfaction.get.contributeToNotSatisfied should equal(RollupConsiderationType.IfNotSkipped)
    contribution.completion should equal(None)
    contribution.objectiveMeasureWeight should equal(BigDecimal("0.5"))
    contribution.measureSatisfactionIfActive should equal(false)
  }

  it can "be constructed without completion and completion contribution" in {
    val contribution = new RollupContribution(
      satisfaction = None,
      completion = None,
      objectiveMeasureWeight = BigDecimal("0.5"),
      measureSatisfactionIfActive = false
    )
    contribution.satisfaction should equal(None)
    contribution.completion should equal(None)
    contribution.objectiveMeasureWeight should equal(BigDecimal("0.5"))
    contribution.measureSatisfactionIfActive should equal(false)
  }

  it can "be constructed with objective measure weight 0" in {
    val contribution = new RollupContribution(
      satisfaction = Some(new SatisfactionRollupContribution(contributeToSatisfied = RollupConsiderationType.IfAttempted, contributeToNotSatisfied = RollupConsiderationType.IfNotSkipped)),
      completion = Some(new CompletionRollupContribution(contributeToCompleted = RollupConsiderationType.IfNotSuspended, contributeToIncomplete = RollupConsiderationType.Always)),
      objectiveMeasureWeight = 0,
      measureSatisfactionIfActive = false
    )
    contribution.satisfaction.get.contributeToSatisfied should equal(RollupConsiderationType.IfAttempted)
    contribution.satisfaction.get.contributeToNotSatisfied should equal(RollupConsiderationType.IfNotSkipped)
    contribution.completion.get.contributeToCompleted should equal(RollupConsiderationType.IfNotSuspended)
    contribution.completion.get.contributeToIncomplete should equal(RollupConsiderationType.Always)
    contribution.objectiveMeasureWeight should equal(BigDecimal(0))
    contribution.measureSatisfactionIfActive should equal(false)
  }

  it can "be constructed with objective measure weight 1" in {
    val contribution = new RollupContribution(
      satisfaction = Some(new SatisfactionRollupContribution(contributeToSatisfied = RollupConsiderationType.IfAttempted, contributeToNotSatisfied = RollupConsiderationType.IfNotSkipped)),
      completion = Some(new CompletionRollupContribution(contributeToCompleted = RollupConsiderationType.IfNotSuspended, contributeToIncomplete = RollupConsiderationType.Always)),
      objectiveMeasureWeight = 1,
      measureSatisfactionIfActive = false
    )
    contribution.satisfaction.get.contributeToSatisfied should equal(RollupConsiderationType.IfAttempted)
    contribution.satisfaction.get.contributeToNotSatisfied should equal(RollupConsiderationType.IfNotSkipped)
    contribution.completion.get.contributeToCompleted should equal(RollupConsiderationType.IfNotSuspended)
    contribution.completion.get.contributeToIncomplete should equal(RollupConsiderationType.Always)
    contribution.objectiveMeasureWeight should equal(BigDecimal(1))
    contribution.measureSatisfactionIfActive should equal(false)
  }

  it can "not be constructed with objective measure weight >1" in {
    intercept[IllegalArgumentException] {
      new RollupContribution(
        satisfaction = Some(new SatisfactionRollupContribution(contributeToSatisfied = RollupConsiderationType.IfAttempted, contributeToNotSatisfied = RollupConsiderationType.IfNotSkipped)),
        completion = Some(new CompletionRollupContribution(contributeToCompleted = RollupConsiderationType.IfNotSuspended, contributeToIncomplete = RollupConsiderationType.Always)),
        objectiveMeasureWeight = 1.1,
        measureSatisfactionIfActive = false
      )
    }
  }

  it can "not be constructed with objective measure weight <-1" in {
    intercept[IllegalArgumentException] {
      new RollupContribution(
        satisfaction = Some(new SatisfactionRollupContribution(contributeToSatisfied = RollupConsiderationType.IfAttempted, contributeToNotSatisfied = RollupConsiderationType.IfNotSkipped)),
        completion = Some(new CompletionRollupContribution(contributeToCompleted = RollupConsiderationType.IfNotSuspended, contributeToIncomplete = RollupConsiderationType.Always)),
        objectiveMeasureWeight = -0.05,
        measureSatisfactionIfActive = false
      )
    }
  }

  it should "have a default value" in {
    val contribution = RollupContribution.Default
    contribution.satisfaction.get.contributeToSatisfied should equal(RollupConsiderationType.Always)
    contribution.satisfaction.get.contributeToNotSatisfied should equal(RollupConsiderationType.Always)
    contribution.completion.get.contributeToCompleted should equal(RollupConsiderationType.Always)
    contribution.completion.get.contributeToIncomplete should equal(RollupConsiderationType.Always)
    contribution.objectiveMeasureWeight should equal(BigDecimal("1"))
    contribution.measureSatisfactionIfActive should equal(true)
  }

}
