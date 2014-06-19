package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.manifest.model.{ AssetResource, ScoResource, Resource }
import com.arcusys.learn.persistence.liferay.service.LFResourceLocalServiceUtil
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.model.LFResource

trait LFResourceStorageImpl extends KeyedEntityStorage[Resource] {
  protected def doRenew() { LFResourceLocalServiceUtil.removeAll() }

  def extract(entity: LFResource) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val id = entity.getResourceID
    val href = entity.getHref.toOption
    val base = entity.getBase.toOption
    if (entity.getScormType.equalsIgnoreCase("sco")) new ScoResource(id, href.get, base, Nil, Nil)
    else new AssetResource(id, href, base, Nil, Nil)
  }

  def getOne(parameters: (String, Any)*) = parameters match {
    case Seq(("packageID", packageID: Int), ("identifierRef", resourceID: String)) =>
      LFResourceLocalServiceUtil.findByPackageIDAndResourceID(packageID, resourceID, 0, 1).asScala.headOption map {
        extract
      }
  }

  def getAll(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("packageID", packageID: Int)) =>
        LFResourceLocalServiceUtil.findByPackageID(packageID).asScala map {
          extract
        }
      case _ =>
        LFResourceLocalServiceUtil.getLFResources(-1, -1).asScala map {
          extract
        }
    }
  }

  def createAndGetID(entity: Resource, parameters: (String, Any)*) = {
    val newEntity = LFResourceLocalServiceUtil.createLFResource()
    newEntity.setResourceID(entity.id)
    newEntity.setBase(entity.base.getOrElse(null))
    newEntity.setHref(entity.href.getOrElse(null))
    newEntity.setScormType(entity match {
      case s: ScoResource   => "sco"
      case a: AssetResource => "asset"
      case _                => throw new UnsupportedOperationException("Unknown resource type")
    })
    val packageID = parameters.find(_._1.equalsIgnoreCase("packageID")).map(e => e._2.asInstanceOf[Int]).getOrElse(throw new UnsupportedOperationException("PackageID should be specified"))
    newEntity.setPackageID(packageID)
    LFResourceLocalServiceUtil.addLFResource(newEntity).getPrimaryKey.toInt
  }

  // Unsupported
  def getByID(id: Int, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: Resource, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: Resource, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[Resource] = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Resource] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
