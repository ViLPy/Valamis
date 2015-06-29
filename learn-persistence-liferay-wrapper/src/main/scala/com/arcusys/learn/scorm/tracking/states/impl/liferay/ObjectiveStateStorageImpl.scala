package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFObjectiveState
import com.arcusys.learn.persistence.liferay.service._
import com.arcusys.valamis.lesson.scorm.model.tracking.ObjectiveState
import com.arcusys.valamis.lesson.scorm.storage.tracking.ObjectiveStateStorage
import scala.collection.JavaConverters._
import java.math

/**
 * Created by mminin on 16.10.14.
 */
class ObjectiveStateStorageImpl extends ObjectiveStateStorage {
  override def renew(): Unit = {
    LFObjectiveStateLocalServiceUtil.removeAll()
  }

  override def create(stateID: Int, key: Option[String], state: ObjectiveState): Unit = {

    val newEntity: LFObjectiveState = LFObjectiveStateLocalServiceUtil.createLFObjectiveState()

    newEntity.setActivityStateID(stateID)
    val activityState = LFActivityStateLocalServiceUtil.getLFActivityState(stateID)
    require(activityState != null, throw new UnsupportedOperationException("ActivityState with ID " + stateID + " cannot be null"))
    val sequencing = LFSequencingLocalServiceUtil.findByActivityIDAndPackageID(activityState.getPackageID, activityState.getActivityID)
    require(sequencing != null, throw new UnsupportedOperationException("Sequencing should be available for ActivityState with ID " + stateID))
    val sequencingID = sequencing.getId.toInt

    if (key.isDefined) {
      val objective = key match {
        case Some(mk) => LFObjectiveLocalServiceUtil.findBySequencingIDAndIsPrimaryAndIdentifier(sequencingID.toInt, false, mk.toString)
        case None     => LFObjectiveLocalServiceUtil.findBySequencingIDAndIsPrimary(sequencingID, true)
      }

      if (!objective.isEmpty) {
        newEntity.setObjectiveID(objective.asScala.head.getLfId.toInt)
      }
    }

    newEntity.setMapKey(key.orNull)
    newEntity.setSatisfied(state.getSatisfiedStatus.getOrElse(null).asInstanceOf[Boolean])
    newEntity.setNormalizedMeasure(state.getNormalizedMeasure.getOrElse(null).asInstanceOf[java.math.BigDecimal])

    LFObjectiveStateLocalServiceUtil.addLFObjectiveState(newEntity)
  }

  override def modify(attemptID: Int, activityID: String, key: Option[String], state: ObjectiveState): Unit = {

    val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
    require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + attemptID))
    val treeID = stateTree.getId
    val stateNodes = LFActivityStateNodeLocalServiceUtil.findByTreeID(treeID.toInt).asScala
    val activityStateNodeIDs = stateNodes.map(_.getId.toInt).toArray.map(i => i: java.lang.Integer)

    val a = LFActivityStateLocalServiceUtil.findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID, null, treeID.toInt).asScala
    val b = LFActivityStateLocalServiceUtil.findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID, activityStateNodeIDs, null).asScala
    if ((a.nonEmpty && b.nonEmpty) || (a.isEmpty && b.isEmpty)) throw new UnsupportedOperationException("Possible inconsistency in DB")
    val activityStateID = if (a.nonEmpty) a.head.getId else b.head.getId

    val entity = LFObjectiveStateLocalServiceUtil.findByMapKeyAndActivityStateID(key.orNull, activityStateID.toInt)

    entity.setSatisfied(state.getSatisfiedStatus.getOrElse(null).asInstanceOf[Boolean])
    entity.setNormalizedMeasure(state.getNormalizedMeasure.map(v => math.BigDecimal.valueOf(v.toDouble)).getOrElse(null))

    LFObjectiveStateLocalServiceUtil.updateLFObjectiveState(entity)
  }

  override def getAll(stateID: Int): Map[Option[String], ObjectiveState] = {
    LFObjectiveStateLocalServiceUtil.findByActivityStateID(stateID, -1, -1).asScala
      .map(extract)
      .toMap
  }

  private def extract(entity: LFObjectiveState) = {
    val mapKey = if (entity.getMapKey == "") None else Option(entity.getMapKey)
    (mapKey, new ObjectiveState(
      Option(entity.getSatisfied),
      Option(entity.getNormalizedMeasure).map(BigDecimal(_))
    ))
  }
}
