package com.arcusys.valamis.lesson.service

import com.arcusys.valamis.lesson.model.PlayerScopeRule
import com.arcusys.valamis.lesson.storage.PlayerScopeRuleStorage
import com.arcusys.valamis.model.ScopeType
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class PlayerScopeRuleManager(implicit val bindingModule: BindingModule) extends Injectable {

  private val playerScopeRuleRepository = inject[PlayerScopeRuleStorage]

  def get(playerId: String): Option[PlayerScopeRule] = {
    playerScopeRuleRepository.get(playerId)
  }

  def create(playerId: String, scope: ScopeType.Value): Unit = {
    playerScopeRuleRepository.create(playerId, scope)
  }

  def update(playerId: String, scope: ScopeType.Value): Unit = {
    playerScopeRuleRepository.update(playerId, scope)
  }

  def delete(playerId: String): Unit = {
    playerScopeRuleRepository.delete(playerId)
  }
}
