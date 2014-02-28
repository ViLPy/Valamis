package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope
import com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalServiceUtil
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.manifest.model.{CompletionRollupContribution, RollupConsiderationType, SatisfactionRollupContribution, RollupContribution}
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay.LFRollupContributionStorageImpl

/**
 * User: Yulia.Glushonkova
 * Date: 02.04.13
 */
class LFRollupContributionSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFRollupContributionLocalServiceUtil.createLFRollupContribution() must not(throwA[Exception])
      there was atLeastOne(rollupService).createLFRollupContribution()
    }
  }
  "LFRollupContributionStorageImpl" should {

    "execute 'create' without errors" in new Context {
      val satisfaction = new SatisfactionRollupContribution(RollupConsiderationType.Always, RollupConsiderationType.IfAttempted)
      val completion = new CompletionRollupContribution(RollupConsiderationType.IfNotSkipped, RollupConsiderationType.IfNotSuspended)
      rollupStorage.create(new RollupContribution(None, None, 1, true), "sequencingID"->100, "satisfaction"-> None, "completion"-> None) must not(throwA[Exception])
      rollupStorage.create(new RollupContribution(Some(satisfaction), None, 1, true), "sequencingID"->100, "satisfaction"-> Option(satisfaction), "completion"-> None) must not(throwA[Exception])
      rollupStorage.create(new RollupContribution(None, Some(completion), 1, true), "sequencingID"->100, "satisfaction"-> None, "completion"-> Option(completion)) must not(throwA[Exception])
      rollupStorage.create(new RollupContribution(Some(satisfaction), Some(completion), 1, true), "sequencingID"->100, "satisfaction"-> Option(satisfaction), "completion"-> Option(completion)) must not(throwA[Exception])
    }

    "execute 'get' without errors" in new Context {
      val satisfaction = new SatisfactionRollupContribution(RollupConsiderationType.Always, RollupConsiderationType.IfAttempted)
      val completion = new CompletionRollupContribution(RollupConsiderationType.IfNotSkipped, RollupConsiderationType.IfNotSuspended)
      rollupStorage.create(new RollupContribution(Some(satisfaction), Some(completion), 0, false), "sequencingID"->200, "satisfaction"-> Option(satisfaction), "completion"-> Option(completion)) must not(throwA[Exception])
      val rollup = rollupStorage.getOne("sequencingID"->200)
      rollup must beSome
      rollup.get.completion.get.contributeToCompleted must beEqualTo(RollupConsiderationType.IfNotSkipped)
      rollup.get.completion.get.contributeToIncomplete must beEqualTo(RollupConsiderationType.IfNotSuspended)
      rollup.get.satisfaction.get.contributeToSatisfied  must beEqualTo(RollupConsiderationType.Always)
      rollup.get.satisfaction.get.contributeToNotSatisfied  must beEqualTo(RollupConsiderationType.IfAttempted)
      rollup.get.measureSatisfactionIfActive must beFalse
      rollup.get.objectiveMeasureWeight must beEqualTo(0)
    }

    "execute 'delete' without errors" in new Context {
      rollupStorage.create(new RollupContribution(None, None, 1, true), "sequencingID"->300, "satisfaction"-> None, "completion"-> None) must not(throwA[Exception])
      rollupStorage.delete("sequencingID"->300)
      val rollup = rollupStorage.getOne("sequencingID"->300)
      rollup must beNone
    }
    "execute 'get not existed' without errors" in new Context {
      val rollup = rollupStorage.getOne("sequencingID"->400)
      rollup must beNone
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val rollupService = RollupContributionEntityContainer.mockLocalService
    val rollupStorage: EntityStorage[RollupContribution] = new LFRollupContributionStorageImpl() {}
  }

}
