package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalServiceUtil
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.manifest.model.{ ConditionType, RuleCondition }
import org.specs2.specification.Scope
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay.LFRuleConditionStorageImpl

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */
class LFRuleConditionSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFRuleConditionLocalServiceUtil.createLFRuleCondition() must not(throwA[Exception])
      there was atLeastOne(ruleService).createLFRuleCondition()
    }
  }
  "LFRuleConditionStorageImpl" should {

    "execute 'create' without errors" in new Context {
      ruleStorage.create(new RuleCondition(ConditionType.ActivityAttempted, Some("objID"), None, true)) must not(throwA[Exception])
      ruleStorage.create(new RuleCondition(ConditionType.ActivityAttempted, Some("objID1"), None, true), "rollupRuleID" -> 100) must not(throwA[Exception])
      ruleStorage.create(new RuleCondition(ConditionType.ActivityAttempted, Some("objID2"), None, true), "conditionRuleID" -> 200) must not(throwA[Exception])
    }
    "execute 'getRollup' without errors" in new Context {
      ruleStorage.create(new RuleCondition(ConditionType.Always, Some("objID2"), None, true), "rollupRuleID" -> 300) must not(throwA[Exception])
      ruleStorage.create(new RuleCondition(ConditionType.TimeLimitExceeded, Some("objID3"), None, true), "rollupRuleID" -> 300) must not(throwA[Exception])
      val rules = ruleStorage.getAll("rollupRuleID" -> 300)
      rules.length must beEqualTo(2)
    }
    "execute 'getCondition' without errors" in new Context {
      ruleStorage.create(new RuleCondition(ConditionType.Always, Some("objID2"), None, true), "conditionRuleID" -> 123) must not(throwA[Exception])
      ruleStorage.create(new RuleCondition(ConditionType.TimeLimitExceeded, Some("objID3"), None, true), "conditionRuleID" -> 123) must not(throwA[Exception])
      ruleStorage.create(new RuleCondition(ConditionType.TimeLimitExceeded, Some("objID3"), None, true), "conditionRuleID" -> 7) must not(throwA[Exception])
      val rules = ruleStorage.getAll("conditionRuleID" -> 123)
      rules.length must beEqualTo(2)
    }
    "execute 'deleteRollup' without errors" in new Context {
      ruleStorage.create(new RuleCondition(ConditionType.Always, Some("objID2"), None, true), "rollupRuleID" -> 400) must not(throwA[Exception])
      ruleStorage.create(new RuleCondition(ConditionType.TimeLimitExceeded, Some("objID3"), None, true), "rollupRuleID" -> 400) must not(throwA[Exception])
      ruleStorage.delete("rollupRuleID" -> 400)
      val rules = ruleStorage.getAll("rollupRuleID" -> 400)
      rules.length must beEqualTo(0)
    }
    "execute 'deleteByCondition' without errors" in new Context {
      ruleStorage.create(new RuleCondition(ConditionType.Always, Some("objID2"), None, true), "conditionRuleID" -> 400) must not(throwA[Exception])
      ruleStorage.create(new RuleCondition(ConditionType.TimeLimitExceeded, Some("objID3"), None, true), "conditionRuleID" -> 400) must not(throwA[Exception])
      val rules = ruleStorage.getAll("conditionRuleID" -> 400)
      rules.length must beEqualTo(2)
      ruleStorage.delete("conditionRuleID" -> 400)
      val rules2 = ruleStorage.getAll("conditionRuleID" -> 400)
      rules2.length must beEqualTo(0)
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val ruleService = RuleConditionEntityContainer.mockLocalService
    val ruleStorage: EntityStorage[RuleCondition] = new LFRuleConditionStorageImpl() {}
  }
}
