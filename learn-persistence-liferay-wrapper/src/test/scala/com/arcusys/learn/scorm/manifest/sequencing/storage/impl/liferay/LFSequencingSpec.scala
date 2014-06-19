package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFSequencingLocalServiceUtil
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.manifest.model.Sequencing
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay.LFSequencingStorageImpl
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.SequencingCreator
import com.arcusys.learn.storage.impl.liferay.LFStorages

/**
 * User: Yulia.Glushonkova
 * Date: 09.04.13
 */
class LFSequencingSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFSequencingLocalServiceUtil.createLFSequencing() must not(throwA[Exception])
      there was atLeastOne(sequencingService).createLFSequencing()
    }
  }

  "LFSequencingStorageImpl" should {
    "execute 'create' without errors" in new Context {
      sequencingStorage.createAndGetID(Sequencing.Default, "packageID" -> 123, "activityID" -> "456") must not(throwA[Exception])
    }
    "execute 'get' without errors" in new Context {
      sequencingStorage.createAndGetID(Sequencing.Default, "packageID" -> 789, "activityID" -> "qwe") must not(throwA[Exception])
      // it will throw an exception because needed to create all sub-entities
      // val fetched = sequencingStorage.getOne("packageID"->789, "activityID"->"qwe")
      // fetched must beSome

    }
    "execute 'get not existed' without errors" in new Context {
      val fetched = sequencingStorage.getOne("packageID" -> 1, "activityID" -> "x")
      fetched must beNone
    }
    // need to implement delete
    // objective need to rewrite extract!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //"execute 'delete' without errors" in new Context {
    //  sequencingStorage.createAndGetID(Sequencing.Default, "packageID"->11, "activityID"->"xx") must not(throwA[Exception])
    //  sequencingStorage.delete("packageID"->11, "activityID"->"xx") must not(throwA[Exception])
    //  val fetched = sequencingStorage.getOne("packageID"->11, "activityID"->"xx")
    //  fetched must beNone
    // }

  }

  trait Context extends Scope {
    val sequencingService = SequencingEntityContainer.mockLocalService
    val sequencingStorage: KeyedEntityStorage[Sequencing] = new LFSequencingStorageImpl with SequencingCreator {

      val sequencingPermissionsStorage = LFStorages.sequencingPermissionsStorage
      val rollupContributionStorage = LFStorages.rollupContributionStorage
      val objectiveStorageStorage = LFStorages.objectiveStorage
      val childrenSelectionStorage = LFStorages.childrenSelectionStorage
      val sequencingTrackingStorage = LFStorages.sequencingTrackingStorage
      val rollupRuleStorage = LFStorages.rollupRuleStorage
      val exitConditionRuleStorageImpl = LFStorages.exitConditionRuleStorage
      val preConditionRuleStorageImpl = LFStorages.preConditionRuleStorage
      val postConditionRuleStorageImpl = LFStorages.postConditionRuleStorage
    }
  }

}
