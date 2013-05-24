package com.arcusys.learn.scorm.course

import com.arcusys.learn.scorm.manifest.model._

trait PlayerScopeRuleStorage
{
  def get(playerID: String): Option[PlayerScopeRule]
  def create(playerID: String, scope: ScopeType.Value)
  def update(playerID: String, scope: ScopeType.Value)
  def delete(playerID: String)
  def renew()
}
