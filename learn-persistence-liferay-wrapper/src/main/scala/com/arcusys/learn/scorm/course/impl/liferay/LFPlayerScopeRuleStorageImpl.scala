package com.arcusys.learn.scorm.course.impl.liferay

import com.arcusys.learn.scorm.manifest.model.{ ScopeType, PlayerScopeRule }
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalServiceUtil
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule

/**
 * User: Yulia.Glushonkova
 * Date: 26.03.13
 */
@deprecated
trait LFPlayerScopeRuleStorageImpl extends EntityStorage[PlayerScopeRule] {
  protected def doRenew() { LFPlayerScopeRuleLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = {
    val searchResult = parameters match {
      case Seq(("playerID", value: String)) => LFPlayerScopeRuleLocalServiceUtil.findByPlayerID(value, 0, 1)
    }
    searchResult.asScala.headOption map { extract }
  }

  def extract(entity: LFPlayerScopeRule) = new PlayerScopeRule(entity.getPlayerID, ScopeType.withName(entity.getScope))

  def getAll(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }

  def create(entity: PlayerScopeRule, parameters: (String, Any)*) {
    doCreate(entity, parameters: _*)
  }

  def delete(parameters: (String, Any)*) {
    idParam(parameters: _*) foreach {
      lfEntityID => LFPlayerScopeRuleLocalServiceUtil.removeByPlayerID(lfEntityID)
    }
  }

  def modify(parameters: (String, Any)*) {
    idParam(parameters: _*).flatMap(getLFEntityById(_)).foreach {
      lfEntity =>
        doUpdateEntity(null, lfEntity, LFPlayerScopeRuleLocalServiceUtil.updateLFPlayerScopeRule(_), parameters: _*)
    }
  }

  def modify(entity: PlayerScopeRule, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  private def getLFEntityById(id: String) = {
    val entities = LFPlayerScopeRuleLocalServiceUtil.findByPlayerID(id, 0, 1)
    if (entities.isEmpty) None
    else Some(entities.get(0))
  }

  def idParam(parameters: (String, Any)*): Option[String] = {
    parameters find {
      _._1 equalsIgnoreCase "playerID"
    } map { _._2.asInstanceOf[String] }
  }

  private def doCreate(entity: PlayerScopeRule, parameters: (String, Any)*) = {
    doUpdateEntity(entity, LFPlayerScopeRuleLocalServiceUtil.createLFPlayerScopeRule(), LFPlayerScopeRuleLocalServiceUtil.addLFPlayerScopeRule(_), parameters: _*)
  }

  private def doUpdateEntity(entity: PlayerScopeRule, lfEntity: LFPlayerScopeRule, update: (LFPlayerScopeRule) => LFPlayerScopeRule, parameters: (String, Any)*): LFPlayerScopeRule = {
    // only empty parameters list is supported for Quiz entity creation - check ORBroker's sql template: Quiz_insert.sql
    (entity, parameters) match {
      case (entity: PlayerScopeRule, Seq()) => {
        lfEntity.setPlayerID(entity.playerID)
        lfEntity.setScope(entity.scope.toString)

        update(lfEntity)
      }
      case (null, s) => {
        lfEntity.setPlayerID(s.find(_._1.equalsIgnoreCase("playerID")).map(_._2.toString).getOrElse(lfEntity.getPlayerID()))
        lfEntity.setScope(s.find(_._1.equalsIgnoreCase("scope")).map(_._2.toString).getOrElse(lfEntity.getScope()))

        update(lfEntity)
      }
    }
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
