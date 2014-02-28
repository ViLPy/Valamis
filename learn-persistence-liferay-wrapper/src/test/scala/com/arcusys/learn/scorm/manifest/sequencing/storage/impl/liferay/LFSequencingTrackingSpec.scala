package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.specification.Scope
import org.specs2.matcher.ThrownExpectations
import com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalServiceUtil
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.manifest.model.SequencingTracking
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay.LFSequencingTrackingStorageImpl

/**
 * User: Yulia.Glushonkova
 * Date: 28.03.13
 */
class LFSequencingTrackingSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFSequencingTrackingLocalServiceUtil.createLFSequencingTracking() must not(throwA[Exception])
      there was atLeastOne(trackingService).createLFSequencingTracking()
    }
  }

  "LFSequencingTrackingStorageImpl" should {

    "execute 'create' without errors" in new Context {
      trackingStorage.create(new SequencingTracking(true, true)) must not(throwA[Exception])
    }

    "execute 'create with sequencingID' without errors" in new Context {
      trackingStorage.create(new SequencingTracking(true, true), "sequencingID" -> 11) must not(throwA[Exception])
    }
    "execute 'get' without errors" in new Context {
      trackingStorage.create(new SequencingTracking(false, true), "sequencingID" -> 99) must not(throwA[Exception])
      val sequencing = trackingStorage.getOne("sequencingID" -> 99)
      sequencing must beSome
      sequencing.get.completionSetByContent must beFalse
      sequencing.get.objectiveSetByContent must beTrue
    }
    "execute 'get not existed' without errors" in new Context {
      val sequencing = trackingStorage.getOne("sequencingID" -> 222)
      sequencing must beNone
    }
    "execute 'delete' without errors" in new Context {
      trackingStorage.create(new SequencingTracking(false, false), "sequencingID" -> 100) must not(throwA[Exception])
      trackingStorage.delete("sequencingID" -> 100)
      val sequencing = trackingStorage.getOne("sequencingID" -> 100)
      sequencing must beNone
    }

  }

  trait Context extends Scope {
    // do initialize mock services
    val trackingService = SequencingTrackingEntityContainer.mockLocalService
    val trackingStorage: EntityStorage[SequencingTracking] = new LFSequencingTrackingStorageImpl() {}
  }
}
