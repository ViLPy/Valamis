package com.arcusys.learn.scorm.course.impl.orbroker

import com.arcusys.learn.scorm.manifest.storage._
import org.orbroker.Row
import com.arcusys.learn.storage.impl.orbroker._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.course.PlayerScopeRuleStorage

class PlayerScopeRuleStorageImpl extends GenericEntityStorageImpl[PlayerScopeRule]("PlayerScopeRule") with PlayerScopeRuleStorage {
  def get(playerID: String) = {
    getOne("playerID"-> playerID)
  }

  def create(playerID: String, scope: ScopeType.Value) {
    create(new PlayerScopeRule(playerID, scope), "scope" -> scope.toString)
  }
  def update(playerID: String, scope: ScopeType.Value){
    modify(new PlayerScopeRule(playerID, scope), "scope" -> scope.toString)
  }
  def delete(playerID: String){
    delete("playerID" -> playerID)
  }

  def extract(row: Row) = new PlayerScopeRule(
    row.string("playerID").get,
    ScopeType.withName(row.string("scope").get)
  )
}
