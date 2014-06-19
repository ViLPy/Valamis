package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope
import com.arcusys.learn.storage.impl.{ EntityStorage, KeyedEntityStorage }
import com.arcusys.learn.persistence.liferay.service.{ LFRuleConditionLocalServiceUtil, LFConditionRuleLocalServiceUtil }
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay.{ LFPostConditionRuleStorageImpl, LFPreConditionRuleStorageImpl, LFRuleConditionStorageImpl, LFExitConditionRuleStorageImpl }
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.{ PostConditionRuleCreator, PreConditionRuleCreator, ExitConditionRuleCreator }
import com.arcusys.learn.storage.impl.liferay.LFStorages

/**
 * User: Yulia.Glushonkova
 * Date: 03.04.13
 */
class LFConditionRuleSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFConditionRuleLocalServiceUtil.createLFConditionRule() must not(throwA[Exception])
      there was atLeastOne(exitRuleService).createLFConditionRule()
    }
  }
  "LFExitConditionRuleStorageImpl" should {

    "execute 'create' without errors" in new Context {
      val rule = new ExitConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All))
      exitRuleStorage.createAndGetID(rule, "sequencingID" -> 100, "combination" -> rule.conditions.combination, "ruleType" -> "exit") must not(throwA[Exception])
    }
    "execute 'get' without errors" in new Context {
      val rule1 = new ExitConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.Always)), ConditionCombination.Any))
      val rule2 = new ExitConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.TimeLimitExceeded), new RuleCondition(ConditionType.Always)), ConditionCombination.All))
      val id1 = exitRuleStorage.createAndGetID(rule1, "sequencingID" -> 200, "combination" -> rule1.conditions.combination, "ruleType" -> "exit")
      val id2 = exitRuleStorage.createAndGetID(rule2, "sequencingID" -> 200, "combination" -> rule2.conditions.combination, "ruleType" -> "exit")

      LFRuleConditionLocalServiceUtil.createLFRuleCondition()
      rule1.conditions.conditions.foreach((e) => ruleStorage.create(e, "conditionRuleID" -> id1))
      rule2.conditions.conditions.foreach((e) => ruleStorage.create(e, "conditionRuleID" -> id2))

      val items = exitRuleStorage.getAll("sequencingID" -> 200, "ruleType" -> "exit")
      items.length must beEqualTo(2)
    }
    "execute 'get not existed' without errors" in new Context {
      val items = exitRuleStorage.getAll("sequencingID" -> 1200, "ruleType" -> "exit")
      items.length must beEqualTo(0)
    }
  }
  "LFPreConditionRuleStorageImpl" should {

    "execute 'create' without errors" in new Context {
      val rule = new PreConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All), PreConditionAction.Disabled)
      preRuleStorage.createAndGetID(rule, "sequencingID" -> 140, "combination" -> rule.conditions.combination, "ruleType" -> "pre") must not(throwA[Exception])
    }
    "execute 'get' without errors" in new Context {
      val rule1 = new PreConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.Always)), ConditionCombination.Any), PreConditionAction.Skip)
      val rule2 = new PreConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.TimeLimitExceeded), new RuleCondition(ConditionType.Always)), ConditionCombination.All), PreConditionAction.HiddenFromChoice)
      val id1 = preRuleStorage.createAndGetID(rule1, "sequencingID" -> 240, "combination" -> rule1.conditions.combination, "ruleType" -> "pre")
      val id2 = preRuleStorage.createAndGetID(rule2, "sequencingID" -> 240, "combination" -> rule2.conditions.combination, "ruleType" -> "pre")

      LFRuleConditionLocalServiceUtil.createLFRuleCondition()
      rule1.conditions.conditions.foreach((e) => ruleStorage.create(e, "conditionRuleID" -> id1))
      rule2.conditions.conditions.foreach((e) => ruleStorage.create(e, "conditionRuleID" -> id2))

      val items = preRuleStorage.getAll("sequencingID" -> 240, "ruleType" -> "pre")
      items.length must beEqualTo(2)

      val fetched1 = items.filter(p => p.action == PreConditionAction.Skip).head
      val fetched2 = items.filter(p => p.action == PreConditionAction.HiddenFromChoice).head

      fetched1.conditions.conditions.length must beEqualTo(1)
      fetched2.conditions.conditions.length must beEqualTo(2)

    }
    "execute 'get not existed' without errors" in new Context {
      val items = preRuleStorage.getAll("sequencingID" -> 2200, "ruleType" -> "pre")
      items.length must beEqualTo(0)
    }
  }

  "LFPostConditionRuleStorageImpl" should {

    "execute 'create' without errors" in new Context {
      val rule = new PostConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.ActivityAttempted)), ConditionCombination.All), PostConditionAction.Previous)
      postRuleStorage.createAndGetID(rule, "sequencingID" -> 340, "combination" -> rule.conditions.combination, "ruleType" -> "post") must not(throwA[Exception])
    }

    "execute 'get' without errors" in new Context {
      val rule1 = new PostConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.Always), new RuleCondition(ConditionType.ObjectiveMeasureKnown)), ConditionCombination.Any), PostConditionAction.ExitAll)
      val rule2 = new PostConditionRule(new RuleConditionSet(Seq(new RuleCondition(ConditionType.TimeLimitExceeded), new RuleCondition(ConditionType.Always)), ConditionCombination.All), PostConditionAction.ExitParent)
      val id1 = postRuleStorage.createAndGetID(rule1, "sequencingID" -> 380, "combination" -> rule1.conditions.combination, "ruleType" -> "post")
      val id2 = postRuleStorage.createAndGetID(rule2, "sequencingID" -> 380, "combination" -> rule2.conditions.combination, "ruleType" -> "post")

      LFRuleConditionLocalServiceUtil.createLFRuleCondition()
      rule1.conditions.conditions.foreach((e) => ruleStorage.create(e, "conditionRuleID" -> id1))
      rule2.conditions.conditions.foreach((e) => ruleStorage.create(e, "conditionRuleID" -> id2))

      val items = postRuleStorage.getAll("sequencingID" -> 380, "ruleType" -> "post")
      items.length must beEqualTo(2)

      val fetched1 = items.filter(p => p.action == PostConditionAction.ExitAll).head
      val fetched2 = items.filter(p => p.action == PostConditionAction.ExitParent).head
      fetched1.conditions.conditions.length must beEqualTo(2)
      fetched2.conditions.conditions.length must beEqualTo(2)

    }
  }

  trait Context extends Scope {
    val exitRuleService = ConditionRuleEntityContainer.mockLocalService
    val exitRuleStorage: KeyedEntityStorage[ExitConditionRule] = new LFExitConditionRuleStorageImpl with ExitConditionRuleCreator {
      def ruleConditionStorage = LFStorages.ruleConditionStorage
    }

    val preRuleService = ConditionRuleEntityContainer.mockLocalService
    val preRuleStorage: KeyedEntityStorage[PreConditionRule] = new LFPreConditionRuleStorageImpl with PreConditionRuleCreator {
      def ruleConditionStorage = LFStorages.ruleConditionStorage
    }

    val postRuleService = ConditionRuleEntityContainer.mockLocalService
    val postRuleStorage: KeyedEntityStorage[PostConditionRule] = new LFPostConditionRuleStorageImpl with PostConditionRuleCreator {
      def ruleConditionStorage = LFStorages.ruleConditionStorage
    }

    val ruleService = RuleConditionEntityContainer.mockLocalService
    val ruleStorage: EntityStorage[RuleCondition] = new LFRuleConditionStorageImpl() {}
  }
}
