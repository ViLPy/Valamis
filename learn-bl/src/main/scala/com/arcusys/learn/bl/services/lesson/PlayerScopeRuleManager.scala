package com.arcusys.learn.bl.services.lesson

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.scorm.course.PlayerScopeRuleStorage
import com.arcusys.learn.scorm.manifest.model.{ PlayerScopeRule, ScopeType }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class PlayerScopeRuleManager(configuration: BindingModule) extends Injectable {

  implicit val bindingModule = configuration
  def this() = this(DomainConfiguration)

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
