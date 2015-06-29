package com.arcusys.learn.scorm.course.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule
import com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalServiceUtil
import com.arcusys.valamis.lesson.model.PlayerScopeRule
import com.arcusys.valamis.lesson.storage.PlayerScopeRuleStorage
import com.arcusys.valamis.model.ScopeType
import scala.collection.JavaConverters._

/**
 * Created by mminin on 15.10.14.
 */
class PlayerScopeRuleRepositoryImpl extends PlayerScopeRuleStorage {

  override def renew(): Unit = {
    LFPlayerScopeRuleLocalServiceUtil.removeAll()
  }

  override def get(playerID: String): Option[PlayerScopeRule] = {
    getLFEntityById(playerID) map { extract }
  }

  override def delete(playerID: String): Unit = {
    LFPlayerScopeRuleLocalServiceUtil.removeByPlayerID(playerID)
  }

  override def create(playerID: String, scope: ScopeType.Value): Unit = {
    val lfEntity = LFPlayerScopeRuleLocalServiceUtil.createLFPlayerScopeRule()

    lfEntity.setPlayerID(playerID)
    lfEntity.setScope(scope.toString)

    LFPlayerScopeRuleLocalServiceUtil.addLFPlayerScopeRule(lfEntity)
  }

  override def update(playerID: String, scope: ScopeType.Value): Unit = {
    for (lfEntity <- getLFEntityById(playerID)) {

      lfEntity.setPlayerID(playerID)
      lfEntity.setScope(scope.toString)

      LFPlayerScopeRuleLocalServiceUtil.updateLFPlayerScopeRule(lfEntity)
    }
  }

  private def getLFEntityById(id: String) = {
    LFPlayerScopeRuleLocalServiceUtil.findByPlayerID(id, 0, 1).asScala.headOption
  }

  private def extract(entity: LFPlayerScopeRule) = {
    new PlayerScopeRule(entity.getPlayerID, ScopeType.withName(entity.getScope))
  }
}
