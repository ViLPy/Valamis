package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalServiceUtil
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay.LFObjectiveMapStorageImpl
import org.specs2.specification.Scope

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */
class LFObjectiveMapSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFObjectiveMapLocalServiceUtil.createLFObjectiveMap() must not(throwA[Exception])
      there was atLeastOne(mapService).createLFObjectiveMap()
    }
  }
  "LFObjectiveMapStorageImpl" should {

    "execute 'create' without errors" in new Context {
      mapStorage.create(new ObjectiveMap()) must not(throwA[Exception])
    }
    "execute 'create with objectiveID' without errors" in new Context {
      mapStorage.create(new ObjectiveMap(Some("1"), Some("2"), Some("3"), Some("4"), Some("5"), Some("6"), Some("7"), Some("8"),
        Some("9"), Some("10"), Some("11"), Some("12"), Some("13"), Some("14")), "objectiveID" -> 333) must not(throwA[Exception])
    }
    "execute 'get' without errors" in new Context {
      mapStorage.create(new ObjectiveMap(Some("1"), Some("2"), Some("3"), Some("4"), Some("5"), Some("6"), Some("7"), Some("8"),
        Some("9"), Some("10"), Some("11"), Some("12"), Some("13"), Some("14")), "objectiveID" -> 666) must not(throwA[Exception])
      val map = mapStorage.getOne("objectiveID" -> 666)
      map must beSome
      map.get.readSatisfiedStatusFrom must beEqualTo(Some("1"))
      map.get.readNormalizedMeasureFrom must beEqualTo(Some("2"))
      map.get.writeSatisfiedStatusTo must beEqualTo(Some("3"))
      map.get.writeNormalizedMeasureTo must beEqualTo(Some("4"))
      map.get.readRawScoreFrom must beEqualTo(Some("5"))
      map.get.readMinScoreFrom must beEqualTo(Some("6"))
      map.get.readMaxScoreFrom must beEqualTo(Some("7"))
      map.get.readCompletionStatusFrom must beEqualTo(Some("8"))
      map.get.readProgressMeasureFrom must beEqualTo(Some("9"))
      map.get.writeRawScoreTo must beEqualTo(Some("10"))
      map.get.writeMinScoreTo must beEqualTo(Some("11"))
      map.get.writeMaxScoreTo must beEqualTo(Some("12"))
      map.get.writeCompletionStatusTo must beEqualTo(Some("13"))
      map.get.writeProgressMeasureTo must beEqualTo(Some("14"))
    }

    "execute 'delete' without errors" in new Context {
      mapStorage.create(new ObjectiveMap(), "objectiveID" -> 5) must not(throwA[Exception])
      mapStorage.delete("objectiveID" -> 5)
      val map = mapStorage.getOne("objectiveID" -> 5)
      map must beNone
    }
    "execute 'get not existed' without errors" in new Context {
      val map = mapStorage.getOne("objectiveID" -> 8)
      map must beNone
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val mapService = ObjectiveMapEntityContainer.mockLocalService
    val mapStorage: EntityStorage[ObjectiveMap] = new LFObjectiveMapStorageImpl() {}
  }

}
