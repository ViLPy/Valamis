package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import org.specs2.specification.Scope
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay.LFSequencingPermissionsStorageImpl
import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.learn.persistence.liferay.service.LFSeqPermissionsLocalServiceUtil

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */
class LFSequencingPermissionsSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFSeqPermissionsLocalServiceUtil.createLFSequencingPermissions() must not(throwA[Exception])
      there was atLeastOne(trackingService).createLFSequencingPermissions()
    }
  }
  "LFSequencingPermissionsStorageImpl" should {

    "execute 'create' without errors" in new Context {
      trackingStorage.create(new SequencingPermissions(true, true, true, true)) must not(throwA[Exception])
    }
    "execute 'create with sequencingID' without errors" in new Context {
      trackingStorage.create(new SequencingPermissions(true, true, true, true), "sequencingID" -> 3) must not(throwA[Exception])
    }
    "execute 'get' without errors" in new Context {
      trackingStorage.create(new SequencingPermissions(true, false, true, false), "sequencingID" -> 5) must not(throwA[Exception])
      val permissions = trackingStorage.getOne("sequencingID" -> 5)
      permissions must beSome
      permissions.get.choiceForChildren must beTrue
      permissions.get.choiceForNonDescendants must beFalse
      permissions.get.flowForChildren must beTrue
      permissions.get.forwardOnlyForChildren must beFalse
    }
    "execute 'get not existed' without errors" in new Context {
      val permissions = trackingStorage.getOne("sequencingID" -> 10)
      permissions must beNone
    }
    "execute 'delete' without errors" in new Context {
      trackingStorage.create(new SequencingPermissions(true, false, true, false), "sequencingID" -> 15) must not(throwA[Exception])
      trackingStorage.delete("sequencingID" -> 15)
      val permissions = trackingStorage.getOne("sequencingID" -> 15)
      permissions must beNone
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val trackingService = SequencingPermissionsEntityContainer.mockLocalService
    val trackingStorage: EntityStorage[SequencingPermissions] = new LFSequencingPermissionsStorageImpl() {}
  }

}
