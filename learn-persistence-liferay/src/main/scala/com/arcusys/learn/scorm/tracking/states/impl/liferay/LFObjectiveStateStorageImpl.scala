package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.tracking.model.ObjectiveState
import com.arcusys.learn.persistence.liferay.model.LFObjectiveState
import com.arcusys.learn.persistence.liferay.service._
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
import scala.collection.JavaConverters._
import scala.Some

trait LFObjectiveStateStorageImpl extends EntityStorage[(Option[String], ObjectiveState)] {
  protected def doRenew() {
    LFObjectiveStateLocalServiceUtil.removeAll()
  }

  def extract(entity: LFObjectiveState) = {
    val mapKey = if (entity.getMapKey == "") None else Option(entity.getMapKey)
    (mapKey, new ObjectiveState(
      Option(entity.getSatisfied),
      Option(entity.getNormalizedMeasure).map(BigDecimal(_))
    ))
  }

  def getAll(parameters: (String, Any)*) = parameters match {
    case Seq(("activityStateID", value: Int)) => {
      LFObjectiveStateLocalServiceUtil.findByActivityStateID(value, -1, -1).asScala map {
        extract
      }
    }
    case _ => Nil
  }

  def create(parameters: (String, Any)*) {
    val newEntity: LFObjectiveState = LFObjectiveStateLocalServiceUtil.createLFObjectiveState()
    parameters.foreach {
      param => param match {
        case ("activityStateID", value: Int) => {
          newEntity.setActivityStateID(value)
          val activityState = LFActivityStateLocalServiceUtil.getLFActivityState(value)
          require(activityState != null, throw new UnsupportedOperationException("ActivityState with ID " + value + " cannot be null"))
          val packageID = activityState.getPackageID
          val activityID = activityState.getActivityID
          val sequencing = LFSequencingLocalServiceUtil.findByActivityIDAndPackageID(packageID, activityID)
          require(sequencing != null, throw new UnsupportedOperationException("Sequencing should be available for ActivityState with ID " + value))
          val sequencingID = sequencing.getId.toInt
          val mapKey = LiferayCommon.getParameter("mapKey", parameters: _*).getOrElse(Option(null))
          val objective = mapKey match {
            case Some(mk) => LFObjectiveLocalServiceUtil.findBySequencingIDAndIsPrimaryAndIdentifier(sequencingID.toInt, false, mk.toString)
            case None => LFObjectiveLocalServiceUtil.findBySequencingIDAndIsPrimary(sequencingID, true)
          }
          //require(!objective.isEmpty, throw new UnsupportedOperationException("Objective must be defined"))
          if (!objective.isEmpty) {
            newEntity.setObjectiveID(objective.asScala.head.getLfId.toInt)
          }
        }
        case ("mapKey", value: Option[String]) => newEntity.setMapKey(value.getOrElse(null))
        case ("satisfied", value: Option[Boolean]) => newEntity.setSatisfied(value.getOrElse(null).asInstanceOf[Boolean])
        case ("normalizedMeasure", value: Option[BigDecimal]) => {
          newEntity.setNormalizedMeasure(value.map(BigDecimal(_)).getOrElse(null))
        }
      }
    }
    LFObjectiveStateLocalServiceUtil.addLFObjectiveState(newEntity)
  }

  def modify(parameters: (String, Any)*) {
    val attemptID = LiferayCommon.getParameter[Int]("attemptID", parameters: _*).getOrElse(throw new UnsupportedOperationException("Cannot modify without attemptID"))
    val activityID = LiferayCommon.getParameter[String]("activityID", parameters: _*).getOrElse(throw new UnsupportedOperationException("Cannot modify without activityID"))

    val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
    require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + attemptID))
    val treeID = stateTree.getId
    val stateNodes = LFActivityStateNodeLocalServiceUtil.findByTreeID(treeID.toInt).asScala
    val activityStateNodeIDs = stateNodes.map(_.getId.toInt).toArray.map(i => i: java.lang.Integer)

    val a = LFActivityStateLocalServiceUtil.findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID, null, treeID.toInt).asScala
    val b = LFActivityStateLocalServiceUtil.findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID, activityStateNodeIDs, null).asScala
    if ((a.nonEmpty && b.nonEmpty) || (a.isEmpty && b.isEmpty)) throw new UnsupportedOperationException("Possible inconsistency in DB")
    val activityStateID = if (a.nonEmpty) a.head.getId else b.head.getId

    val mapKey = LiferayCommon.getParameter("mapKey", parameters: _*).getOrElse(Option(null))
    val key = mapKey match {
      case Some(mk) => mk.toString
      case _ => null
    }
    val entity = LFObjectiveStateLocalServiceUtil.findByMapKeyAndActivityStateID(key, activityStateID.toInt)
    parameters.foreach {
      param => param match {
        case ("satisfied", value: Option[Boolean]) => entity.setSatisfied(value.getOrElse(null).asInstanceOf[Boolean])
        case ("normalizedMeasure", value: Option[BigDecimal]) => {
          //val dblVal = value match {
          //  case Some(e) => e.toDouble
          //  case _ => null
          // }
          //entity.setNormalizedMeasure(dblVal.asInstanceOf[BigDecimal])
          entity.setNormalizedMeasure(value.getOrElse(null))
        }
        case _ => {}
      }
    }
    LFObjectiveStateLocalServiceUtil.updateLFObjectiveState(entity)
  }

  // unsupported

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def create(entity: (Option[String], ObjectiveState), parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def delete(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(entity: (Option[String], ObjectiveState), parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
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
