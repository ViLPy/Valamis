package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState
import com.arcusys.learn.persistence.liferay.service.{ LFActivityStateTreeLocalServiceUtil, LFGlobalObjectiveStateLocalServiceUtil }
import com.arcusys.learn.scorm.tracking.model.GlobalObjectiveState
import com.arcusys.learn.scorm.tracking.states.storage.GlobalObjectiveStorage
import com.arcusys.learn.storage.impl.liferay.LiferayCommon

import scala.collection.mutable
import scala.collection.JavaConverters._

/**
 * Created by mminin on 16.10.14.
 */
class GlobalObjectiveStorageImpl extends GlobalObjectiveStorage {
  override def renew(): Unit = {
    LFGlobalObjectiveStateLocalServiceUtil.removeAll()
  }

  override def create(treeID: Int, key: String, state: GlobalObjectiveState): Unit = {
    val newEntity: LFGlobalObjectiveState = LFGlobalObjectiveStateLocalServiceUtil.createLFGlobalObjectiveState()

    newEntity.setTreeID(treeID)
    newEntity.setMapKey(key)
    newEntity.setSatisfied(state.satisfied.getOrElse(null).asInstanceOf[Boolean])
    newEntity.setNormalizedMeasure(state.normalizedMeasure.getOrElse(null).asInstanceOf[java.math.BigDecimal])
    newEntity.setAttemptCompleted(state.attemptCompleted.getOrElse(null).asInstanceOf[Boolean])

    LFGlobalObjectiveStateLocalServiceUtil.addLFGlobalObjectiveState(newEntity)
  }

  override def modify(attemptID: Int, key: String, state: GlobalObjectiveState): Unit = {
    val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
    require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + attemptID))
    val treeID = stateTree.getId
    val old = Option(LFGlobalObjectiveStateLocalServiceUtil.findByTreeIDAndMapKey(treeID.toInt, key)).map(extract)

    if (old.isDefined) {
      val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
      require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + attemptID))

      val entity = LFGlobalObjectiveStateLocalServiceUtil.findByTreeIDAndMapKey(stateTree.getId.toInt, key)
      entity.setSatisfied(state.satisfied.getOrElse(null).asInstanceOf[Boolean])
      entity.setNormalizedMeasure(state.normalizedMeasure.getOrElse(null).asInstanceOf[java.math.BigDecimal])
      entity.setAttemptCompleted(state.attemptCompleted.getOrElse(null).asInstanceOf[Boolean])

      LFGlobalObjectiveStateLocalServiceUtil.updateLFGlobalObjectiveState(entity)
    } else {
      val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
      require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + attemptID))

      val newEntity: LFGlobalObjectiveState = LFGlobalObjectiveStateLocalServiceUtil.createLFGlobalObjectiveState()
      newEntity.setTreeID(stateTree.getId.toInt)
      newEntity.setMapKey(key)
      newEntity.setSatisfied(state.satisfied.getOrElse(null).asInstanceOf[Boolean])
      newEntity.setNormalizedMeasure(state.normalizedMeasure.getOrElse(null).asInstanceOf[java.math.BigDecimal])
      newEntity.setAttemptCompleted(state.attemptCompleted.getOrElse(null).asInstanceOf[Boolean])

      LFGlobalObjectiveStateLocalServiceUtil.addLFGlobalObjectiveState(newEntity)
    }
  }

  override def getAllObjectives(treeID: Int): mutable.Map[String, GlobalObjectiveState] = {
    val result = scala.collection.mutable.Map[String, GlobalObjectiveState]()

    LFGlobalObjectiveStateLocalServiceUtil.findByTreeID(treeID, -1, -1).asScala
      .map(extract)
      .foreach(e => result(e._1) = e._2)
    result
  }

  private def extract(entity: LFGlobalObjectiveState) = {
    (entity.getMapKey, new GlobalObjectiveState(
      Option(entity.getSatisfied),
      Option(entity.getNormalizedMeasure).map(BigDecimal(_)),
      Option(entity.getAttemptCompleted)
    ))
  }

}
