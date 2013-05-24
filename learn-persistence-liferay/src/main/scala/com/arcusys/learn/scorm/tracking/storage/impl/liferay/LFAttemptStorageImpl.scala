package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.tracking.model.Attempt
import com.arcusys.learn.persistence.liferay.service.{LFActivityStateTreeLocalServiceUtil, LFAttemptLocalServiceUtil}
import com.arcusys.learn.scorm.tracking.storage.impl.AttemptFieldsMapper
import com.arcusys.learn.persistence.liferay.model.LFAttempt
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import scala.collection.JavaConverters._

trait LFAttemptStorageImpl extends KeyedEntityStorage[Attempt] {
  protected def doRenew() {
    LFAttemptLocalServiceUtil.removeAll()
  }

  def extract(entity: LFAttempt) = {
    val mapper = new AttemptFieldsMapper {
      def id: Int = entity.getId.toInt

      def userID: Int = entity.getUserID

      def packageID: Int = entity.getPackageID

      def organizationID: String = entity.getOrganizationID

      def isComplete: Boolean = entity.getIsComplete
    }
    createAttempt(mapper)
  }

  def createAttempt(mapper: AttemptFieldsMapper): Attempt

  def getOne(parameters: (String, Any)*): Option[Attempt] = parameters match {
    case Seq(("userID", userID: Int), ("packageID", packageID: Int), ("isComplete", isComplete: Boolean)) =>
      LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageID, isComplete).asScala.headOption.map(extract)
    case Seq(("userID", userID: Int), ("packageID", packageID: Int), ("getLast", true), ("isComplete", isComplete: Boolean)) =>
      LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageID, isComplete).asScala.sortWith(_.getId > _.getId).headOption.map(extract)
    case _ => None
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[Attempt] = Option(LFAttemptLocalServiceUtil.getLFAttempt(id)).map(extract)

  def createAndGetID(entity: Attempt, parameters: (String, Any)*): Int = {
    val newEntity = LFAttemptLocalServiceUtil.createLFAttempt()
    newEntity.setUserID(entity.user.id)
    newEntity.setPackageID(entity.packageID)
    newEntity.setOrganizationID(entity.organizationID)
    newEntity.setIsComplete(entity.isComplete)

    LFAttemptLocalServiceUtil.addLFAttempt(newEntity).getId.toInt
  }


  def getAll(parameters: (String, Any)*): Seq[Attempt] = parameters match {
    case Seq(("userID", userID: Int), ("packageID", packageID: Int), ("isComplete", isComplete: Boolean)) =>
      LFAttemptLocalServiceUtil.findByUserIDPackageIDIsComplete(userID, packageID, isComplete).asScala.map(extract)
    case _ => Nil
  }

  // unsupported

  override def execute(sql: String, parameters: (String, Any)*) {
    if (sql.equalsIgnoreCase("_setcomplete")) {
      val id = LiferayCommon.getParameter[Int]("id", parameters: _*)
      require(id.isDefined, throw new UnsupportedOperationException("id should be specified"))
      val isComplete = LiferayCommon.getParameter("isComplete", parameters: _*).getOrElse(false)
      val found = LFAttemptLocalServiceUtil.getLFAttempt(id.get)
      if (found != null) {
        found.setIsComplete(isComplete)
        LFAttemptLocalServiceUtil.updateLFAttempt(found)
      }
    }
  }

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: Attempt, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id: Int)) => {
        val tree = LFActivityStateTreeLocalServiceUtil.findByAttemptID(id)
        if (tree != null) LFActivityStateTreeLocalServiceUtil.deleteLFActivityStateTree(tree.getId)
        LFAttemptLocalServiceUtil.deleteLFAttempt(id)
      }
    }
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: Attempt, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[Attempt] = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Attempt] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
