package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.{LFAttemptLocalServiceUtil, LFPackageLocalServiceUtil}
import scala.collection.JavaConverters._
import com.arcusys.learn.scorm.manifest.model.Manifest
import com.arcusys.learn.persistence.liferay.model.LFPackage

/**
 * User: Yulia.Glushonkova
 * Date: 12.04.13
 */
trait LFPackageStorageImpl extends KeyedEntityStorage[Manifest] {
  protected def doRenew() { LFPackageLocalServiceUtil.removeAll()}

  def getOne(parameters: (String, Any)*) = {
    val lfRule = parameters match {
      case Seq(("refID", refID: Any)) =>
        LFPackageLocalServiceUtil.findByRefID(getLong(refID))
      case Seq(("packageId", packageId: Any)) =>
        LFPackageLocalServiceUtil.getLFPackage(getLong(packageId))
    }
    if (lfRule == null) None
    else Option(extract(lfRule))
  }

  private def getLong(value: Any): Long={
    value match {
      case i:Int => i.toLong
      case l: Long => l
      case _ => 0
    }
  }

  def getAll(parameters: (String, Any)*) = {
    val packages = parameters match {
      case Seq(("ids", courseIDs: List[Int])) =>{
        LFPackageLocalServiceUtil.findByInstance(courseIDs.toArray.map(i => i:java.lang.Integer))
      }
      case Seq(("courseID", courseID: Int)) =>
        LFPackageLocalServiceUtil.findByCourseID(courseID)

      case _ => LFPackageLocalServiceUtil.getLFPackages(-1,-1)
    }
    packages.asScala map { extract }
  }

  private def extract(lfEntity: LFPackage)={
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    new Manifest(lfEntity.getId.toInt, None,
      lfEntity.getBase.toOption, "",
      lfEntity.getDefaultOrganizationID.toOption,
      lfEntity.getResourcesBase.toOption,
      lfEntity.getTitle, Option(lfEntity.getSummary), None,
      lfEntity.getAssetRefID.toOption, lfEntity.getCourseID.toOption, None, false)
  }

  def create(parameters: (String, Any)*) {throw new UnsupportedOperationException}
  def create(entity: Manifest, parameters: (String, Any)*) {throw new UnsupportedOperationException}
  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id: Any)) =>
          LFPackageLocalServiceUtil.deleteLFPackage(getLong(id))
    }
  }

  def modify(parameters: (String, Any)*) {
    val lfEntity = parameters match {
      case Seq(("id", id: Int), ("title", title: String), ("summary", summary: String)) => {
        val entity = LFPackageLocalServiceUtil.findByPackageID(Array(id.toLong:java.lang.Long)).get(0)
        entity.setTitle(title)
        entity.setSummary(summary)
        entity
      }
      case Seq(("id", id: Any), ("assetRefID", assetRefID: Any)) =>{
        val entity = LFPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong:java.lang.Long)).get(0)
        entity.setAssetRefID(getLong(assetRefID))
        entity
      }
    }
    LFPackageLocalServiceUtil.updateLFPackage(lfEntity)
  }

  def modify(entity: Manifest, parameters: (String, Any)*) {throw new UnsupportedOperationException}
  def getByID(id: Int, parameters: (String, Any)*) = {
    Option(LFPackageLocalServiceUtil.getLFPackage(id)).map(extract)
  }

  def createAndGetID(entity: Manifest, parameters: (String, Any)*) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val newEntity = LFPackageLocalServiceUtil.createLFPackage()

    newEntity.setDefaultOrganizationID(entity.defaultOrganizationID.getOrElse(null))
    newEntity.setTitle(entity.title)
    newEntity.setBase(entity.base.getOrElse(null))
    newEntity.setResourcesBase(entity.resourcesBase.getOrElse(null))
    newEntity.setSummary(entity.summary.getOrElse(null))
    newEntity.setAssetRefID(entity.assetRefID)
    newEntity.setCourseID(entity.courseID)

    LFPackageLocalServiceUtil.addLFPackage(newEntity).getId.toInt
  }

  override def getAll(sql: String, parameters: (String, Any)*) = {
    if (sql.equalsIgnoreCase("_packages")) {
      parameters match {
        case Seq(("userID", userID: Int)) => {
          val packageIDs = LFAttemptLocalServiceUtil.findByUserID(userID).asScala.map(_.getPackageID.toLong.asInstanceOf[java.lang.Long]).toSet
          LFPackageLocalServiceUtil.findByPackageID(packageIDs.toArray).asScala.map(extract)
        }
        case _ => {
          val packageIDs = LFAttemptLocalServiceUtil.getLFAttempts(-1, -1).asScala.map(_.getPackageID.toLong.asInstanceOf[java.lang.Long]).toSet
          LFPackageLocalServiceUtil.findByPackageID(packageIDs.toArray).asScala.map(extract)
        }
      }
    } else {
      Nil
    }
  }

  def createAndGetID(parameters: (String, Any)*) = { throw new UnsupportedOperationException }

  def execute(sqlKey: String, parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Manifest] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {throw new UnsupportedOperationException}
}
