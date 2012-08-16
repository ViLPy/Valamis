package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ObjectiveTest extends FlatSpec with ShouldMatchers {

  "Objective map" can "be constructed" in {
    val map = new ObjectiveMap(
      readSatisfiedStatusFrom = Some("O1"),
      readNormalizedMeasureFrom = Some("O2"),
      writeSatisfiedStatusTo = Some("O3"),
      writeNormalizedMeasureTo = Some("O4"),
      readRawScoreFrom = Some("O5"),
      readMinScoreFrom = Some("O6"),
      readMaxScoreFrom = Some("O7"),
      readCompletionStatusFrom = Some("O8"),
      readProgressMeasureFrom = Some("O9"),
      writeRawScoreTo = Some("OA"),
      writeMinScoreTo = Some("OB"),
      writeMaxScoreTo = Some("OC"),
      writeCompletionStatusTo = Some("OD"),
      writeProgressMeasureTo = Some("OE")
    )
    map.readSatisfiedStatusFrom should equal(Some("O1"))
    map.readNormalizedMeasureFrom should equal(Some("O2"))
    map.writeSatisfiedStatusTo should equal(Some("O3"))
    map.writeNormalizedMeasureTo should equal(Some("O4"))
    map.readRawScoreFrom should equal(Some("O5"))
    map.readMinScoreFrom should equal(Some("O6"))
    map.readMaxScoreFrom should equal(Some("O7"))
    map.readCompletionStatusFrom should equal(Some("O8"))
    map.readProgressMeasureFrom should equal(Some("O9"))
    map.writeRawScoreTo should equal(Some("OA"))
    map.writeMinScoreTo should equal(Some("OB"))
    map.writeMaxScoreTo should equal(Some("OC"))
    map.writeCompletionStatusTo should equal(Some("OD"))
    map.writeProgressMeasureTo should equal(Some("OE"))
  }

  it can "be constructed with defaults = None" in {
    val map = new ObjectiveMap()
    map.readSatisfiedStatusFrom should equal(None)
    map.readNormalizedMeasureFrom should equal(None)
    map.writeSatisfiedStatusTo should equal(None)
    map.writeNormalizedMeasureTo should equal(None)
    map.readRawScoreFrom should equal(None)
    map.readMinScoreFrom should equal(None)
    map.readMaxScoreFrom should equal(None)
    map.readCompletionStatusFrom should equal(None)
    map.readProgressMeasureFrom should equal(None)
    map.writeRawScoreTo should equal(None)
    map.writeMinScoreTo should equal(None)
    map.writeMaxScoreTo should equal(None)
    map.writeCompletionStatusTo should equal(None)
    map.writeProgressMeasureTo should equal(None)
  }

  it should "have a preconstructed empty instance" in {
    val map = ObjectiveMap.Empty
    map.readSatisfiedStatusFrom should equal(None)
    map.readNormalizedMeasureFrom should equal(None)
    map.writeSatisfiedStatusTo should equal(None)
    map.writeNormalizedMeasureTo should equal(None)
    map.readRawScoreFrom should equal(None)
    map.readMinScoreFrom should equal(None)
    map.readMaxScoreFrom should equal(None)
    map.readCompletionStatusFrom should equal(None)
    map.readProgressMeasureFrom should equal(None)
    map.writeRawScoreTo should equal(None)
    map.writeMinScoreTo should equal(None)
    map.writeMaxScoreTo should equal(None)
    map.writeCompletionStatusTo should equal(None)
    map.writeProgressMeasureTo should equal(None)
    map should equal(ObjectiveMap.Empty)
  }

  "Objective" can "be constructed" in {
    val map = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1"))
    val objective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("0.5"), globalObjectiveMap = map)
    objective.id.get should equal("OBJ1")
    objective.satisfiedByMeasure should equal(false)
    objective.minNormalizedMeasure should equal(BigDecimal("0.5"))
    objective.globalObjectiveMap should equal(map)
  }

  it can "be constructed without map" in {
    val objective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("0.5"))
    objective.id.get should equal("OBJ1")
    objective.satisfiedByMeasure should equal(false)
    objective.minNormalizedMeasure should equal(BigDecimal("0.5"))
    objective.globalObjectiveMap should equal(ObjectiveMap.Empty)
  }

  it can "be constructed with min normalized measure = -1" in {
    val map = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1"))
    val objective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("-1"), globalObjectiveMap = map)
    objective.id.get should equal("OBJ1")
    objective.satisfiedByMeasure should equal(false)
    objective.minNormalizedMeasure should equal(BigDecimal("-1"))
    objective.globalObjectiveMap should equal(map)
  }

  it can "be constructed with min normalized measure = 1" in {
    val map = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1"))
    val objective = new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("1"), globalObjectiveMap = map)
    objective.id.get should equal("OBJ1")
    objective.satisfiedByMeasure should equal(false)
    objective.minNormalizedMeasure should equal(BigDecimal("1"))
    objective.globalObjectiveMap should equal(map)
  }

  it can "not be constructed with min normalized measure < -1" in {
    val map = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1"))
    intercept[IllegalArgumentException] {
      new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("-2"), globalObjectiveMap = map)
    }
  }

  it can "not be constructed with min normalized measure > 1" in {
    val map = new ObjectiveMap(readSatisfiedStatusFrom = Some("GO1"))
    intercept[IllegalArgumentException] {
      new Objective(Some("OBJ1"), satisfiedByMeasure = false, minNormalizedMeasure = BigDecimal("1.1"), globalObjectiveMap = map)
    }
  }
}