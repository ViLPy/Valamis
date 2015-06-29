package com.arcusys.valamis.lesson.storage

import com.arcusys.valamis.lesson.model.PlayerScopeRule
import com.arcusys.valamis.model.ScopeType

trait PlayerScopeRuleStorage {
  def get(playerID: String): Option[PlayerScopeRule]
  def create(playerID: String, scope: ScopeType.Value)
  def update(playerID: String, scope: ScopeType.Value)
  def delete(playerID: String)
  def renew()
}
