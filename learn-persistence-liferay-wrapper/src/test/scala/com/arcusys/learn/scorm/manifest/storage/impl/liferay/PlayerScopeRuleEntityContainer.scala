package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalService
import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import org.mockito.Matchers.{ eq => eqMatcher }

import java.util.{ List => JavaList }
import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: Yulia.Glushonkova
 * Date: 26.03.13
 */

object PlayerScopeRuleEntityContainer extends MockEntityContainer[LFPlayerScopeRuleLocalService, LFPlayerScopeRule] {
  lazy val mockServiceBeanName = classOf[LFPlayerScopeRuleLocalService].getName
  lazy val mockLocalService = mock[LFPlayerScopeRuleLocalService]

  // service related mocks
  def createFunction = _.createLFPlayerScopeRule
  def addFunction = _.addLFPlayerScopeRule(_)
  def deleteFunction = _.deleteLFPlayerScopeRule(_)
  def updateFunction = _.updateLFPlayerScopeRule(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFPlayerScopeRules(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFPlayerScopeRule]

  def mockEntityProperties(mockEntity: LFPlayerScopeRule) {
    mockStringProperty(mockEntity.setPlayerID(_), _.getPlayerID)
    mockStringProperty(mockEntity.setScope(_), _.getScope)
  }

  def getIdFunction = _.getId

  mockLocalService.findByPlayerID(anyString) answers {
    filterByPlayerIDAsList(_)
  }

  mockLocalService.findByPlayerID(anyString, eqMatcher(0), eqMatcher(1)) answers {
    filterByPlayerIDAsList(_)
  }

  mockLocalService.removeByPlayerID(anyString) answers { playerIDRaw =>
    internalStorage --= filterByPlayerID(playerIDRaw).map(_.getId)
    ()
  }

  private def unwrapPlayerID(playerIDRaw: Any) = playerIDRaw match {
    case x: String                  => x
    case Array(x: String, Int, Int) => x
  }

  def playerIDMatch(playerID: String)(playerScope: LFPlayerScopeRule): Boolean = playerScope.getPlayerID == playerID
  private def filterByPlayerIDAsList(playerIDRaw: Any): JavaList[LFPlayerScopeRule] = filterByPlayerID(playerIDRaw).asJava
  private def filterByPlayerID(filenameRaw: Any): Seq[LFPlayerScopeRule] = filterStorage(playerIDMatch(unwrapPlayerID(filenameRaw)))

  private def filterStorage(check: (LFPlayerScopeRule) => Boolean): Seq[LFPlayerScopeRule] = {
    internalStorage.values.filter(check).toSeq
  }
}
