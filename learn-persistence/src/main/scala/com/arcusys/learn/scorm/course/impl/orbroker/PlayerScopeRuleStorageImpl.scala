package com.arcusys.learn.scorm.course.impl.orbroker

import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.storage.impl.orbroker._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.course.impl.PlayerScopeRuleEntityStorage

class PlayerScopeRuleStorageImpl extends GenericEntityStorageImpl[PlayerScopeRule]("PlayerScopeRule") with PlayerScopeRuleEntityStorage with PlayerScopeRuleExtractor

trait PlayerScopeRuleExtractor extends RowExtractor[PlayerScopeRule] {
  def extract(row: Row) = new PlayerScopeRule(
    row.string("playerID").get,
    ScopeType.withName(row.string("scope").get))
}
