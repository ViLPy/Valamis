package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import org.specs2.specification.Scope
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.manifest.model.{ ScopeType, PlayerScopeRule }
import com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalServiceUtil
import com.arcusys.learn.scorm.course.impl.liferay.LFPlayerScopeRuleStorageImpl

/**
 * Created with IntelliJ IDEA.
 * User: Yulia.Glushonkova
 * Date: 26.03.13
 */
class LFPlayerScopeRuleSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFPlayerScopeRuleLocalServiceUtil.createLFPlayerScopeRule() must not(throwA[Exception])
      there was atLeastOne(playerService).createLFPlayerScopeRule()
    }
  }

  "LFPlayerScopeRuleStorageImpl" should {

    "execute 'create' without errors" in new Context {
      playerStorage.create(new PlayerScopeRule("playerID1", ScopeType.Instance)) must not(throwA[Exception])
    }

    "execute 'getOne' without errors" in new Context {
      playerStorage.getOne("playerID" -> "playerID1") must not(throwA[Exception])
    }

    "execute 'modify' without errors" in new Context {
      playerStorage.create(new PlayerScopeRule("playerID3", ScopeType.Instance))
      playerStorage.modify("playerID" -> "playerID3", "scope" -> ScopeType.Site.toString) must not(throwA[Exception])
      val fetched = playerStorage.getOne("playerID" -> "playerID3")
      fetched must beSome
      fetched.get.scope must be(ScopeType.Site)
    }

    "execute 'delete' without errors" in new Context {
      playerStorage.create(new PlayerScopeRule("playerID1", ScopeType.Instance))
      playerStorage.delete("playerID" -> "playerID1") must not(throwA[Exception])
      val fetched = playerStorage.getOne("playerID" -> "playerID1")
      fetched must beNone
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val playerService = PlayerScopeRuleEntityContainer.mockLocalService
    val playerStorage: EntityStorage[PlayerScopeRule] = new LFPlayerScopeRuleStorageImpl() {}
  }

}
