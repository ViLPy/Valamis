package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ActivityDataMapTest extends FlatSpec with ShouldMatchers {

  "Activity data map" can "be constructed" in {
    val map = new ActivityDataMap(targetId = "TAR", readSharedData = false, writeSharedData = true)
    map.targetId should equal("TAR")
    map.readSharedData should equal(false)
    map.writeSharedData should equal(true)
  }
}
