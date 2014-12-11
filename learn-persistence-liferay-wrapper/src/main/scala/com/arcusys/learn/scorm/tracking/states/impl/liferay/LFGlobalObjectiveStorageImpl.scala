package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.tracking.model.GlobalObjectiveState
import com.arcusys.learn.persistence.liferay.service.{ LFActivityStateTreeLocalServiceUtil, LFGlobalObjectiveStateLocalServiceUtil }
import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState
import scala.collection.JavaConverters._
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

@deprecated
trait LFGlobalObjectiveStorageImpl extends EntityStorage[(String, GlobalObjectiveState)] {
  protected def doRenew() { LFGlobalObjectiveStateLocalServiceUtil.removeAll() }

  def create(parameters: (String, Any)*) {
    val newEntity: LFGlobalObjectiveState = LFGlobalObjectiveStateLocalServiceUtil.createLFGlobalObjectiveState()
    parameters.foreach {
      param =>
        param match {
          case ("treeID", value: Int) => newEntity.setTreeID(value)
          case ("attemptID", value: Int) => {
            val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(value)
            require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + value))
            newEntity.setTreeID(stateTree.getId.toInt)
          }
          case ("mapKey", value: String)             => newEntity.setMapKey(value)
          case ("satisfied", value: Option[Boolean]) => newEntity.setSatisfied(value.getOrElse(null).asInstanceOf[Boolean])
          case ("normalizedMeasure", value: Option[BigDecimal]) => {
            newEntity.setNormalizedMeasure(value.map(BigDecimal(_)).getOrElse(null))
          }
          case ("attemptCompleted", value: Option[Boolean]) => newEntity.setAttemptCompleted(value.getOrElse(null).asInstanceOf[Boolean])
        }
    }
    LFGlobalObjectiveStateLocalServiceUtil.addLFGlobalObjectiveState(newEntity)
  }

  def extract(entity: LFGlobalObjectiveState) =
    (entity.getMapKey, new GlobalObjectiveState(
      Option(entity.getSatisfied),
      Option(entity.getNormalizedMeasure).map(BigDecimal(_)),
      Option(entity.getAttemptCompleted)
    ))

  def getAll(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("treeID", treeID: Int)) =>
        LFGlobalObjectiveStateLocalServiceUtil.findByTreeID(treeID, -1, -1).asScala map {
          extract
        }
      case _ => Nil
    }
  }

  def getOne(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("attemptID", attemptID: Int), ("mapKey", mapKey: String)) => {
        val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
        require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + attemptID))
        val treeID = stateTree.getId
        Option(LFGlobalObjectiveStateLocalServiceUtil.findByTreeIDAndMapKey(treeID.toInt, mapKey)).map(extract)
      }
      case _ => None
    }
  }

  def modify(parameters: (String, Any)*) {
    val attemptID = LiferayCommon.getParameter[Int]("attemptID", parameters: _*).getOrElse(throw new UnsupportedOperationException("Cannot modify without attemptID"))
    val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
    require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + attemptID))
    val treeID = stateTree.getId
    val mapKey = LiferayCommon.getParameter[String]("mapKey", parameters: _*).getOrElse(throw new UnsupportedOperationException("Cannot modify without mapKey"))
    val entity = LFGlobalObjectiveStateLocalServiceUtil.findByTreeIDAndMapKey(treeID.toInt, mapKey)
    parameters.foreach {
      param =>
        param match {
          case ("satisfied", value: Option[Boolean]) => entity.setSatisfied(value.getOrElse(null).asInstanceOf[Boolean])
          case ("normalizedMeasure", value: Option[BigDecimal]) => {
            entity.setNormalizedMeasure(value.map(BigDecimal(_)).getOrElse(null))
          }
          case ("attemptCompleted", value: Option[Boolean]) => entity.setAttemptCompleted(value.getOrElse(null).asInstanceOf[Boolean])
          case _ => {}
        }
    }
    LFGlobalObjectiveStateLocalServiceUtil.updateLFGlobalObjectiveState(entity)
  }

  def delete(parameters: (String, Any)*) {
    //TODO: implement me
    throw new UnsupportedOperationException("Not implemented")
  }

  // Not implemented
  def create(entity: (String, GlobalObjectiveState), parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(entity: (String, GlobalObjectiveState), parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[(String, GlobalObjectiveState)] = throw new UnsupportedOperationException("Not implemented")

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[(String, GlobalObjectiveState)] = throw new UnsupportedOperationException("Not implemented")

  def modify(sqlKey: String, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
}
