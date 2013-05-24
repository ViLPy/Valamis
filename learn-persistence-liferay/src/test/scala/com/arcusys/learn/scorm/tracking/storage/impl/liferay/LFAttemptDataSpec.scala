package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalServiceUtil
import org.specs2.specification.Scope
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.tracking.model.AttemptData

class LFAttemptDataSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {
  "Mockito" should {
    "mock service method" in new Context {
      LFAttemptDataLocalServiceUtil.createLFAttemptData() must not(throwA[Exception])

      there was atLeastOne(attemptDataService).createLFAttemptData()
    }
  }

  "LFFileRecordStorageImpl" should {

    "execute 'create and get' without errors" in new Context {
      attemptDataStorage.create("attemptID" -> 1, "activityID" -> "act1", "dataKey" -> "piu", "dataValue" -> "sm") must not(throwA[Exception])
      val fetched = attemptDataStorage.getOne("attemptID" -> 1, "activityID" -> "act1", "dataKey" -> "piu")
      fetched must beSome
      fetched.get.activityID must be("act1")
      fetched.get.dataKey must be("piu")
      fetched.get.dataValue must beSome("sm")
    }

    "execute 'create and getAll with attempt, activity and key' without errors" in new Context {
      attemptDataStorage.create("attemptID" -> 2, "activityID" -> "act1", "dataKey" -> "piu.1", "dataValue" -> "sm1") must not(throwA[Exception])
      attemptDataStorage.create("attemptID" -> 2, "activityID" -> "act1", "dataKey" -> "piu.2", "dataValue" -> "sm2") must not(throwA[Exception])
      val fetched = attemptDataStorage.getAll("attemptID" -> 2, "activityID" -> "act1", "dataKey" -> "piu.")
      fetched.size must beEqualTo(2)
    }

    "execute 'create and getAll with attempt and activity' without errors" in new Context {
      attemptDataStorage.create("attemptID" -> 3, "activityID" -> "act1", "dataKey" -> "piu1", "dataValue" -> "sm1") must not(throwA[Exception])
      attemptDataStorage.create("attemptID" -> 3, "activityID" -> "act1", "dataKey" -> "piu2", "dataValue" -> "sm2") must not(throwA[Exception])
      val fetched = attemptDataStorage.getAll("attemptID" -> 3, "activityID" -> "act1")
      fetched.size must beEqualTo(2)
      fetched.find(_.dataValue == Some("sm1")) must beSome
      fetched.find(_.dataValue == Some("sm2")) must beSome
      fetched.find(_.dataKey == "piu1") must beSome
      fetched.find(_.dataKey == "piu2") must beSome
    }

    "execute 'create and getAll with attempt and key' without errors" in new Context {
      attemptDataStorage.create("attemptID" -> 4, "activityID" -> "act1", "dataKey" -> "piu", "dataValue" -> "sm1") must not(throwA[Exception])
      attemptDataStorage.create("attemptID" -> 4, "activityID" -> "act2", "dataKey" -> "piu", "dataValue" -> "sm2") must not(throwA[Exception])
      val fetched = attemptDataStorage.getAll("attemptID" -> 4, "dataKey" -> "piu")
      fetched.size must beEqualTo(2)
      fetched.find(_.dataValue == Some("sm1")) must beSome
      fetched.find(_.dataValue == Some("sm2")) must beSome
      fetched.find(_.activityID == "act1") must beSome
      fetched.find(_.activityID == "act2") must beSome
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val attemptDataService = AttemptDataEntityContainer.mockLocalService

    val attemptDataStorage: EntityStorage[AttemptData] = new LFAttemptDataStorageImpl() {}

  }

}
