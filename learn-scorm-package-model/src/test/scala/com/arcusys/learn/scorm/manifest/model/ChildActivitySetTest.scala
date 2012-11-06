package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ChildActivitySetTest extends FlatSpec with ShouldMatchers {

  "Children activity set" can "be all" in {
    val set = ChildActivitySet.all
    set should equal(ChildActivitySetAll)
  }

  it can "be any" in {
    val set = ChildActivitySet.any
    set should equal(ChildActivitySetAny)
  }

  it can "be none" in {
    val set = ChildActivitySet.none
    set should equal(ChildActivitySetNone)
  }

  it can "be at least count" in {
    val set = ChildActivitySet.atLeastCount(5)
    set should equal(ChildActivitySetAtLeastCount(5))
    ChildActivitySetAtLeastCount.unapply(set) should equal(Some(5))
  }

  it can "not be at least count with negative count" in {
    intercept[IllegalArgumentException] {
      ChildActivitySet.atLeastCount(-1)
    }
  }

  it can "be at least percent" in {
    val set = ChildActivitySet.atLeastPercent(0.3)
    set should equal(ChildActivitySetAtLeastPercent(0.3))
    ChildActivitySetAtLeastPercent.unapply(set) should equal(Some(0.3))
  }

  it can "not be at least percent with negative percent" in {
    intercept[IllegalArgumentException] {
      ChildActivitySet.atLeastPercent(-0.1)
    }
  }

  it can "not be at least percent with percent > 1" in {
    intercept[IllegalArgumentException] {
      ChildActivitySet.atLeastPercent(1.1)
    }
  }

  it can "parse all" in {
    val set = ChildActivitySet.parse("all")
    set should equal(ChildActivitySetAll)
  }

  it can "parse any" in {
    val set = ChildActivitySet.parse("any")
    set should equal(ChildActivitySetAny)
  }

  it can "parse none" in {
    val set = ChildActivitySet.parse("none")
    set should equal(ChildActivitySetNone)
  }

  it can "parse at least count" in {
    val set = ChildActivitySet.parse("atLeastCount", count = Some(5))
    set should equal(ChildActivitySetAtLeastCount(5))
  }

  it can "parse at least percent" in {
    val set = ChildActivitySet.parse("atLeastPercent", percent = Some(0.3))
    set should equal(ChildActivitySetAtLeastPercent(0.3))
  }
}
