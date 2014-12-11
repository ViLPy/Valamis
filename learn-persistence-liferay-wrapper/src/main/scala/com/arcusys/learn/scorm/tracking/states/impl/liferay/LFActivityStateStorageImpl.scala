package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorageExt
import com.arcusys.learn.scorm.tracking.model.ActivityState
import com.arcusys.learn.persistence.liferay.service.{ LFAttemptLocalServiceUtil, LFActivityStateNodeLocalServiceUtil, LFActivityStateTreeLocalServiceUtil, LFActivityStateLocalServiceUtil }
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.model.LFActivityState
import com.arcusys.learn.scorm.tracking.states.storage.impl.ActivityStateFieldsMapper
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

@deprecated
trait LFActivityStateStorageImpl extends KeyedEntityStorageExt[ActivityState] {
  protected def doRenew() { LFActivityStateLocalServiceUtil.removeAll() }

  def extract(entity: LFActivityState) = {
    val mapper = new ActivityStateFieldsMapper {
      def packageID: Int = entity.getPackageID

      def activityID: String = entity.getActivityID

      def id: Int = entity.getId.toInt

      def active: Boolean = entity.getActive

      def suspended: Boolean = entity.getSuspended

      def attemptCompleted: Option[Boolean] = Option(Boolean.unbox(entity.getAttemptCompleted)) //Option(entity.getAttemptCompleted)

      def attemptCompletionAmount: Option[BigDecimal] = Option(entity.getAttemptCompletionAmount).map(BigDecimal(_))

      def attemptAbsoluteDuration: BigDecimal = BigDecimal(entity.getAttemptAbsoluteDuration)

      def attemptExperiencedDuration: BigDecimal = BigDecimal(entity.getAttemptExperiencedDuration)

      def activityAbsoluteDuration: BigDecimal = BigDecimal(entity.getActivityAbsoluteDuration)

      def activityExperiencedDuration: BigDecimal = BigDecimal(entity.getActivityExperiencedDuration)

      def attemptCount: Int = entity.getAttemptCount
    }
    createActivityState(mapper)

  }

  def createActivityState(mapper: ActivityStateFieldsMapper): ActivityState

  def getOne(parameters: (String, Any)*): Option[ActivityState] = parameters match {
    case Seq(("attemptID", value: Int)) => {
      val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(value)
      require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + value))
      val stateNodes = LFActivityStateNodeLocalServiceUtil.findByTreeID(stateTree.getId.toInt).asScala
      val activityStateNodeIDs = stateNodes.map(_.getId.toInt).toArray.map(i => i: java.lang.Integer)
      val activityID = stateTree.getCurrentActivityID
      LFActivityStateLocalServiceUtil.findByActivityStateNodeIDAndActivityID(activityStateNodeIDs, activityID).asScala.map(extract).headOption
    }
    case Seq(("activityStateNodeID", value: Int)) => {
      val activityStateNodeID = Array(value)
      LFActivityStateLocalServiceUtil.findByActivityStateNodeID(activityStateNodeID.map(i => i: java.lang.Integer)).asScala.headOption.map(extract)
    }
    case _ => None
  }

  def createAndGetID(entity: ActivityState, parameters: (String, Any)*): Int = {
    val newEntity = LFActivityStateLocalServiceUtil.createLFActivityState()
    parameters.foreach {
      param =>
        param match {
          case ("activityStateNodeID", value: Int) => {
            newEntity.setActivityStateNodeID(value)
            newEntity.setActivityID(entity.activity.id)
            newEntity.setActive(entity.active)
            newEntity.setSuspended(entity.suspended)
            newEntity.setAttemptCompleted(entity.attemptCompleted.getOrElse(null).asInstanceOf[java.lang.Boolean])
            newEntity.setAttemptCompletionAmount(entity.attemptCompletionAmount.getOrElse(null))
            newEntity.setAttemptAbsoluteDuration(entity.attemptAbsoluteDuration)
            newEntity.setAttemptExperiencedDuration(entity.attemptExperiencedDuration)
            newEntity.setActivityAbsoluteDuration(entity.activityAbsoluteDuration)
            newEntity.setActivityExperiencedDuration(entity.activityExperiencedDuration)
            newEntity.setAttemptCount(entity.attemptCount)
            newEntity.setActivityStateTreeID(null)
            val activityState = LFActivityStateNodeLocalServiceUtil.getLFActivityStateNode(value)
            require(activityState != null, throw new UnsupportedOperationException("Activity state node should exists"))
            val stateTree = LFActivityStateTreeLocalServiceUtil.getLFActivityStateTree(activityState.getTreeID.toLong)
            require(stateTree != null, throw new UnsupportedOperationException("Activity state tree should exists"))
            val attempt = LFAttemptLocalServiceUtil.getLFAttempt(stateTree.getAttemptID.toLong)
            require(attempt != null, throw new UnsupportedOperationException("Attempt should exists"))
            newEntity.setPackageID(attempt.getPackageID)
          }
        }
    }
    LFActivityStateLocalServiceUtil.addLFActivityState(newEntity).getId.toInt
  }

  def modify(entity: ActivityState, parameters: (String, Any)*) {
    parameters match {
      case Seq(("attemptID", value: Int)) => {
        val stateTree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(value)
        require(stateTree != null, throw new UnsupportedOperationException("State tree should be defined for attempt " + value))
        val stateNodes = LFActivityStateNodeLocalServiceUtil.findByTreeID(stateTree.getId.toInt).asScala
        val activityStateNodeIDs = stateNodes.map(_.getId.toInt).toArray.map(i => i: java.lang.Integer)

        val entities = LFActivityStateLocalServiceUtil.findByActivityStateNodeIDAndActivityID(activityStateNodeIDs, entity.activity.id).asScala
        entities.foreach(e => {
          e.setActive(entity.active)
          e.setSuspended(entity.suspended)
          e.setAttemptCount(entity.attemptCount)
          e.setAttemptCompleted(entity.attemptCompleted.getOrElse(null).asInstanceOf[java.lang.Boolean])
          e.setAttemptCompletionAmount(entity.attemptCompletionAmount.getOrElse(null))
          LFActivityStateLocalServiceUtil.updateLFActivityState(e)
        })
      }
    }
  }

  def delete(parameters: (String, Any)*) {
    //TODO: implement me
    throw new UnsupportedOperationException("Must be implemented")
  }

  // Unsupported
  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def getAll(parameters: (String, Any)*): Seq[ActivityState] = throw new UnsupportedOperationException("Not implemented")

  def create(entity: ActivityState, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[ActivityState] = throw new UnsupportedOperationException("Not implemented")

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException("Not implemented")

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[ActivityState] = throw new UnsupportedOperationException("Not implemented")

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[ActivityState] = throw new UnsupportedOperationException("Not implemented")

  def modify(sqlKey: String, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
}
