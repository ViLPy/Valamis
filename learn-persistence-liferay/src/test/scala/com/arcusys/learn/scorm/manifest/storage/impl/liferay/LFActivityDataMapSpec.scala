package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import org.specs2.specification.Scope
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.manifest.model.ActivityDataMap
import com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalServiceUtil

class LFActivityDataMapSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {
  "Mockito" should {
    "mock service method" in new Context {
      LFActivityDataMapLocalServiceUtil.createLFAttemptData() must not(throwA[Exception])

      there was atLeastOne(activityDataMapService).createLFAttemptData()
    }
  }

  "LFActivityDataMapStorageImpl" should {
    "create and fetch without error" in new Context {
      val entity = new ActivityDataMap("target1", false, true)
      activityDataMapStorage.create(entity, "packageID" -> 1, "activityID" -> "act1") must not(throwA[Exception])

      val fetched = activityDataMapStorage.getAll("packageID" -> 1, "activityID" -> "act1")
      fetched.size should beEqualTo(1)
      fetched.head.targetId must beEqualTo("target1")
      fetched.head.readSharedData should beEqualTo(false)
      fetched.head.writeSharedData should beEqualTo(true)
    }

    "remove without error" in new Context {
      val entity = new ActivityDataMap("target1", false, true)
      activityDataMapStorage.create(entity, "packageID" -> 2, "activityID" -> "act1") must not(throwA[Exception])
      activityDataMapStorage.getAll("packageID" -> 2, "activityID" -> "act1").size should beEqualTo(1)

      activityDataMapStorage.delete("packageID" -> 2, "activityID" -> "act1") must not(throwA[Exception])
      activityDataMapStorage.getAll("packageID" -> 2, "activityID" -> "act1").size should beEqualTo(0)
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val activityDataMapService = ActivityDataMapEntityContainer.mockLocalService

    val activityDataMapStorage: EntityStorage[ActivityDataMap] = new LFActivityDataMapStorageImpl() {}

  }

}
