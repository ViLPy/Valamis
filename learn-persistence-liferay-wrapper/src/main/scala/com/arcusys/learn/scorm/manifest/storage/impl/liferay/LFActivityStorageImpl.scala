package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.manifest.model.Activity
import com.arcusys.learn.persistence.liferay.service.LFActivityLocalServiceUtil
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import com.arcusys.learn.persistence.liferay.model.LFActivity
import scala.collection.JavaConverters._
import javax.swing.plaf.OptionPaneUI

/**
 * User: Yulia.Glushonkova
 * Date: 10.04.13
 */
@deprecated
trait LFActivityStorageImpl extends EntityStorage[Activity] {
  protected def doRenew() { LFActivityLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = {
    val lfActivity = LFActivityLocalServiceUtil.findByPackageAndID(
      LiferayCommon.getParameter("packageID", parameters: _*).get,
      LiferayCommon.getParameter("id", parameters: _*).get)
    if (lfActivity == null) None
    else Option(extract(lfActivity))
  }

  private def extract(lfActivity: LFActivity) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    createActivity(lfActivity.getIdentifierRef, lfActivity.getId, lfActivity.getTitle, lfActivity.getPackageID, lfActivity.getOrganizationID,
      lfActivity.getParentID.toOption,
      lfActivity.getHideLMSUI, lfActivity.getVisible, Option(lfActivity.getResourceParameters),
      Option(lfActivity.getMasteryScore), Option(lfActivity.getMaxTimeAllowed))
  }
  def createActivity(identifierRef: String, id: String, title: String, packageID: Int, organizationId: String, parentId: Option[String],
    hideLMSUI: String, visible: Boolean, resourceParameters: Option[String], masteryScore: Option[String], maxTimeAllowed: Option[String]): Activity

  def getAll(parameters: (String, Any)*) = {

    val result = parameters match {
      case Seq(("packageID", packageID: Int)) =>
        LFActivityLocalServiceUtil.findByPackageID(packageID)

      case Seq(("packageID", packageID: Int), ("organizationID", organizationID: String)) =>
        LFActivityLocalServiceUtil.findByPackageIDAndOrganizationID(packageID, organizationID)

      case Seq(("packageID", packageID: Int), ("parentID", null)) =>
        LFActivityLocalServiceUtil.findByPackageIDAndParentID(packageID, null.asInstanceOf[String])
      case _ => LFActivityLocalServiceUtil.getLFActivities(-1, -1)
    }
    result.asScala.sortBy(i => (i.getIndexNumber, i.getId)) map { extract }
  }

  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }

  def create(entity: Activity, parameters: (String, Any)*) {
    val newEntity = LFActivityLocalServiceUtil.createLFActivity()

    newEntity.setId(entity.id)
    newEntity.setPackageID(LiferayCommon.getParameter("packageID", parameters: _*).get)
    newEntity.setOrganizationID(entity.organizationID)

    // TODO: error when parameter like Some(Some(xx))
    newEntity.setParentID(LiferayCommon.getNullableParameter("parentID", parameters: _*))

    newEntity.setTitle(entity.title)
    newEntity.setIdentifierRef(LiferayCommon.getParameter("identifierRef", parameters: _*).get)

    // TODO: error when parameter like Some(Some(xx))
    newEntity.setResourceParameters(LiferayCommon.getNullableParameter("resourceParameters", parameters: _*))

    newEntity.setHideLMSUI(LiferayCommon.getNullableParameter("hideLMSUI", parameters: _*))
    newEntity.setVisible(entity.visible)
    newEntity.setObjectivesGlobalToSystem(LiferayCommon.getParameter("objectivesGlobalToSystem", parameters: _*).get)
    newEntity.setSharedDataGlobalToSystem(LiferayCommon.getParameter("sharedDataGlobalToSystem", parameters: _*).get)
    newEntity.setMasteryScore(LiferayCommon.getNullableParameter("masteryScore", parameters: _*))
    newEntity.setMaxTimeAllowed(LiferayCommon.getNullableParameter("maxTimeAllowed", parameters: _*))

    LFActivityLocalServiceUtil.addLFActivity(newEntity)
  }

  def delete(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def modify(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def modify(entity: Activity, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
