package com.arcusys.valamis.lesson.scorm.model

import com.arcusys.valamis.lesson.scorm.model.manifest.ActivityDataMap
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class ActivityDataMapTest extends FlatSpec with ShouldMatchers {

  "Activity data map" can "be constructed" in {
    val map = new ActivityDataMap(targetId = "TAR", readSharedData = false, writeSharedData = true)
    map.targetId should equal("TAR")
    map.readSharedData should equal(false)
    map.writeSharedData should equal(true)
  }
}
