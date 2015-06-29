package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.learn.storage.impl.{ EntityStorage, KeyedEntityStorage }
import com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalServiceUtil
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay.{ LFObjectiveMapStorageImpl, LFObjectiveStorageImpl }
import org.specs2.specification.Scope
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.ObjectiveEntityCreator
import com.arcusys.learn.storage.impl.liferay.LFStorages

/**
 * User: Yulia.Glushonkova
 * Date: 01.04.13
 */
class LFObjectiveSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFObjectiveLocalServiceUtil.createLFObjective() must not(throwA[Exception])
      there was atLeastOne(objectiveService).createLFObjective()
    }
  }

  "LFObjectiveStorageImpl" should {
    "execute 'createAndGetID with params' without errors" in new Context {
      objectiveStorage.createAndGetID(new Objective(Some("id2"), false, 1), "sequencingID" -> 100, "isPrimary" -> true) must not(throwA[Exception])
    }
    "execute 'getPrimary' without errors" in new Context {
      objectiveStorage.createAndGetID(new Objective(Some("id3"), false, 1), "sequencingID" -> 200, "isPrimary" -> false) must not(throwA[Exception])
      objectiveStorage.createAndGetID(new Objective(Some("id4"), false, 1), "sequencingID" -> 200, "isPrimary" -> false) must not(throwA[Exception])
      val objectiveMap = new ObjectiveMap(Some("1"), Some("2"))
      val id = objectiveStorage.createAndGetID(new Objective(Some("id5"), false, 1, objectiveMap), "sequencingID" -> 200, "isPrimary" -> true)
      mapStorage.create(objectiveMap, "objectiveID" -> id)

      val primary = objectiveStorage.getOne("sequencingID" -> 200, "isPrimary" -> true)
      primary must beSome
      primary.get.id must beEqualTo(Some("id5"))
      primary.get.satisfiedByMeasure must beFalse
      primary.get.minNormalizedMeasure must beEqualTo(1)
    }
    "execute 'getNonPrimary' without errors" in new Context {
      val objectiveMap = new ObjectiveMap(Some("1"), Some("2"))
      val id1 = objectiveStorage.createAndGetID(new Objective(Some("id5"), false, 1), "sequencingID" -> 200, "isPrimary" -> false)
      objectiveStorage.createAndGetID(new Objective(Some("id6"), false, 1), "sequencingID" -> 200, "isPrimary" -> true) must not(throwA[Exception])
      val id2 = objectiveStorage.createAndGetID(new Objective(Some("id7"), false, 1), "sequencingID" -> 200, "isPrimary" -> false)
      val id3 = objectiveStorage.createAndGetID(new Objective(Some("id8"), false, 1), "sequencingID" -> 200, "isPrimary" -> false)

      mapStorage.create(objectiveMap, "objectiveID" -> id1)
      mapStorage.create(objectiveMap, "objectiveID" -> id2)
      mapStorage.create(objectiveMap, "objectiveID" -> id3)

      val nonPrimary = objectiveStorage.getAll("sequencingID" -> 200, "isPrimary" -> false)
      nonPrimary.length must beEqualTo(3)
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val objectiveService = ObjectiveEntityContainer.mockLocalService
    val objectiveStorage: KeyedEntityStorage[Objective] = new LFObjectiveStorageImpl with ObjectiveEntityCreator {
      val mapStorage = LFStorages.objectiveMapStorage
    }

    val mapService = ObjectiveMapEntityContainer.mockLocalService
    val mapStorage: EntityStorage[ObjectiveMap] = new LFObjectiveMapStorageImpl() {}
  }

}
