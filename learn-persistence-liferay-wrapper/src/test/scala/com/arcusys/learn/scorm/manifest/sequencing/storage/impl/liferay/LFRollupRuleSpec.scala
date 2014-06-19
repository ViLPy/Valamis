package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope
import com.arcusys.learn.storage.impl.{ EntityStorage, KeyedEntityStorage }
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalServiceUtil
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay.{ LFRuleConditionStorageImpl, LFRollupRuleStorageImpl }
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.RollupRuleCreator
import com.arcusys.learn.storage.impl.liferay.LFStorages
import scala.Some

/**
 * User: Yulia.Glushonkova
 * Date: 08.04.13
 */
class LFRollupRuleSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFRollupRuleLocalServiceUtil.createLFRollupRule() must not(throwA[Exception])
      there was atLeastOne(ruleService).createLFRollupRule()
    }
  }
  "LFRollupRuleStorageImpl" should {

    "execute 'create' without errors" in new Context {
      val conditionSet = new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.Any)
      val rule = new RollupRule(ChildActivitySet.parse("all", None, None), conditionSet, RollupAction.Satisfied)

      ruleStorage.createAndGetID(rule, "sequencingID" -> 500, "childActivitySet" -> "all", "minimumCount" -> None,
        "minimumPercent" -> None, "combination" -> rule.conditions.combination) must not(throwA[Exception])
    }

    "execute 'get' without errors" in new Context {
      val conditionSet = new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.Any)
      val ruleAll = new RollupRule(ChildActivitySet.parse("all", None, None), conditionSet, RollupAction.Satisfied)
      val idAll = ruleStorage.createAndGetID(ruleAll, "sequencingID" -> 520, "childActivitySet" -> "all", "minimumCount" -> None,
        "minimumPercent" -> None, "combination" -> ruleAll.conditions.combination)

      ruleAll.conditions.conditions.foreach((e) => ruleConditionStorage.create(e, "rollupRuleID" -> idAll))

      val result1 = ruleStorage.getAll("sequencingID" -> 520)
      result1.length must beEqualTo(1)

      val ruleAny = new RollupRule(ChildActivitySet.parse("any", None, None), conditionSet, RollupAction.Completed)
      val idAny = ruleStorage.createAndGetID(ruleAny, "sequencingID" -> 520, "childActivitySet" -> "any", "minimumCount" -> None,
        "minimumPercent" -> None, "combination" -> ruleAny.conditions.combination)

      ruleAny.conditions.conditions.foreach((e) => ruleConditionStorage.create(e, "rollupRuleID" -> idAny))

      val result2 = ruleStorage.getAll("sequencingID" -> 520)
      result2.length must beEqualTo(2)

      val ruleNone = new RollupRule(ChildActivitySet.parse("none", None, None), conditionSet, RollupAction.Incomplete)
      val idNone = ruleStorage.createAndGetID(ruleNone, "sequencingID" -> 520, "childActivitySet" -> "none", "minimumCount" -> None,
        "minimumPercent" -> None, "combination" -> ruleNone.conditions.combination)

      ruleNone.conditions.conditions.foreach((e) => ruleConditionStorage.create(e, "rollupRuleID" -> idNone))

      val result3 = ruleStorage.getAll("sequencingID" -> 520)
      result3.length must beEqualTo(3)

      val ruleAtLeastCount = new RollupRule(ChildActivitySet.parse("atLeastCount", Some(2), None), conditionSet, RollupAction.Satisfied)
      val idCount = ruleStorage.createAndGetID(ruleAtLeastCount, "sequencingID" -> 520, "childActivitySet" -> "atLeastCount", "minimumCount" -> 2,
        "minimumPercent" -> None, "combination" -> ruleAtLeastCount.conditions.combination)

      ruleAtLeastCount.conditions.conditions.foreach((e) => ruleConditionStorage.create(e, "rollupRuleID" -> idCount))

      val result4 = ruleStorage.getAll("sequencingID" -> 520)
      result4.length must beEqualTo(4)

      val ruleAtLeastPercent = new RollupRule(ChildActivitySet.parse("atLeastPercent", None, Some(0)), conditionSet, RollupAction.NotSatisfied)
      val idPercent = ruleStorage.createAndGetID(ruleAtLeastPercent, "sequencingID" -> 520, "childActivitySet" -> "atLeastPercent", "minimumCount" -> None,
        "minimumPercent" -> new java.math.BigDecimal(0.23), "combination" -> ruleAtLeastPercent.conditions.combination)

      ruleAtLeastPercent.conditions.conditions.foreach((e) => ruleConditionStorage.create(e, "rollupRuleID" -> idPercent))

      val result = ruleStorage.getAll("sequencingID" -> 520)
      result.length must beEqualTo(5)
    }

    "execute 'delete' without errors" in new Context {
      val conditionSet = new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All)
      val rule = new RollupRule(ChildActivitySet.parse("all", None, None), conditionSet, RollupAction.Satisfied)
      val id = ruleStorage.createAndGetID(rule, "sequencingID" -> 580, "childActivitySet" -> "all", "minimumCount" -> None,
        "minimumPercent" -> None, "combination" -> rule.conditions.combination)
      rule.conditions.conditions.foreach((e) => ruleConditionStorage.create(e, "rollupRuleID" -> id))

      ruleStorage.delete("sequencingID" -> 580) must not(throwA[Exception])
      val result = ruleStorage.getAll("sequencingID" -> 580)
      result.length must beEqualTo(0)
    }

    "execute 'get' and verify result without errors" in new Context {
      val conditionSet = new RuleConditionSet(Seq(new RuleCondition(ConditionType.TimeLimitExceeded)), ConditionCombination.All)
      val ruleAll = new RollupRule(ChildActivitySet.parse("all", None, None), conditionSet, RollupAction.Completed)
      val idAll = ruleStorage.createAndGetID(ruleAll, "sequencingID" -> 590, "childActivitySet" -> "all", "minimumCount" -> None,
        "minimumPercent" -> None, "combination" -> ruleAll.conditions.combination)

      ruleAll.conditions.conditions.foreach((e) => ruleConditionStorage.create(e, "rollupRuleID" -> idAll))

      val result = ruleStorage.getAll("sequencingID" -> 590)
      result.length must beEqualTo(1)
      result.head.action must beEqualTo(RollupAction.Completed)
      result.head.childActivitySet must beEqualTo(ChildActivitySetAll)
      result.head.conditions.conditions.length must beEqualTo(1)
      result.head.conditions.conditions.head.conditionType must beEqualTo(ConditionType.TimeLimitExceeded)

    }

  }

  trait Context extends Scope {
    val ruleService = RollupRuleEntityContainer.mockLocalService
    val ruleStorage: KeyedEntityStorage[RollupRule] = new LFRollupRuleStorageImpl with RollupRuleCreator {
      def ruleConditionStorage = LFStorages.ruleConditionStorage
    }

    val ruleConditionService = RuleConditionEntityContainer.mockLocalService
    val ruleConditionStorage: EntityStorage[RuleCondition] = new LFRuleConditionStorageImpl() {}
  }

}
