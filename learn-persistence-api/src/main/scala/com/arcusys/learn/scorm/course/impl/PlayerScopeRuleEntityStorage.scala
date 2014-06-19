package com.arcusys.learn.scorm.course.impl

import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.learn.scorm.manifest.model.{ ScopeType, PlayerScopeRule }
import com.arcusys.learn.scorm.course.PlayerScopeRuleStorage

/**
 * User: Yulia.Glushonkova
 * Date: 26.03.13
 */
trait PlayerScopeRuleEntityStorage extends PlayerScopeRuleStorage with EntityStorageExt[PlayerScopeRule] {
  def get(playerID: String) = {
    getOne("playerID" -> playerID)
  }

  def create(playerID: String, scope: ScopeType.Value) {
    create(new PlayerScopeRule(playerID, scope))
  }

  def update(playerID: String, scope: ScopeType.Value) {
    modify("playerID" -> playerID, "scope" -> scope.toString)
  }

  def delete(playerID: String) {
    delete("playerID" -> playerID)
  }
}
