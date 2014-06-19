package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.tracking.model.ActivityStateTree
import com.arcusys.learn.persistence.liferay.model.LFActivityStateTree
import com.arcusys.learn.scorm.tracking.states.storage.impl.ActivityStateTreeFieldsMapper
import com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalServiceUtil
import com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException

trait LFActivityStateTreeStorageImpl extends KeyedEntityStorage[ActivityStateTree] {
  protected def doRenew() { LFActivityStateTreeLocalServiceUtil.removeAll() }

  def extract(entity: LFActivityStateTree) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    val mapper = new ActivityStateTreeFieldsMapper {
      def id: Int = entity.getId.toInt
      def currentActivityID: Option[String] = entity.getCurrentActivityID.toOption
      def suspendedActivityID: Option[String] = entity.getSuspendedActivityID.toOption
    }
    createActivityStateTree(mapper)
  }

  def createActivityStateTree(mapper: ActivityStateTreeFieldsMapper): ActivityStateTree

  def createAndGetID(entity: ActivityStateTree, parameters: (String, Any)*): Int = {
    val newEntity = LFActivityStateTreeLocalServiceUtil.createLFActivityStateTree()
    parameters.foreach {
      param =>
        param match {
          case ("attemptID", value: Int)                      => newEntity.setAttemptID(value)
          case ("currentActivityID", value: Option[String])   => newEntity.setCurrentActivityID(value.getOrElse(null))
          case ("suspendedActivityID", value: Option[String]) => newEntity.setSuspendedActivityID(value.getOrElse(null))
        }
    }
    LFActivityStateTreeLocalServiceUtil.addLFActivityStateTree(newEntity).getId.toInt
  }

  def modify(parameters: (String, Any)*) {
    parameters match {
      case Seq(("attemptID", attemptID: Int), ("currentActivityID", currentActivityID: Option[String]), ("suspendedActivityID", suspendedActivityID: Option[String])) => {
        val entity = LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)
        if (entity != null) {
          entity.setCurrentActivityID(currentActivityID.getOrElse(null))
          entity.setSuspendedActivityID(suspendedActivityID.getOrElse(null))
          LFActivityStateTreeLocalServiceUtil.updateLFActivityStateTree(entity)
        }
      }
    }
  }

  def getOne(parameters: (String, Any)*): Option[ActivityStateTree] = parameters match {
    case Seq(("attemptID", attemptID: Int)) =>
      try {
        Option(LFActivityStateTreeLocalServiceUtil.findByAttemptID(attemptID)).map(extract)
      } catch {
        case ex: NoSuchLFActivityStateTreeException => None
      }
  }

  def delete(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Must be implemented")
  }

  // unsupported

  def getAll(parameters: (String, Any)*): Seq[ActivityStateTree] = throw new UnsupportedOperationException("Not implemented")

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def create(entity: ActivityStateTree, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(entity: ActivityStateTree, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[ActivityStateTree] = throw new UnsupportedOperationException("Not implemented")

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException("Not implemented")

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[ActivityStateTree] = throw new UnsupportedOperationException("Not implemented")

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[ActivityStateTree] = throw new UnsupportedOperationException("Not implemented")

  def modify(sqlKey: String, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
}
