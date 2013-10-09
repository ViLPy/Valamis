package com.arcusys.learn.tincan.manifest.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.manifest.model.Manifest
import com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFTincanPackage
import scala.collection.JavaConverters._


trait LFTincanPackageStorageImpl extends KeyedEntityStorage[Manifest] {

  protected def doRenew() { LFTincanPackageLocalServiceUtil.removeAll()}

  def getOne(parameters: (String, Any)*) = {
    val lfRule = parameters match {
      case Seq(("refID", refID: Any)) =>
        LFTincanPackageLocalServiceUtil.findByRefID(getLong(refID))
      case Seq(("packageId", packageId: Any)) =>
        LFTincanPackageLocalServiceUtil.getLFTincanPackage(getLong(packageId))
      case _ => throw  new UnsupportedOperationException()
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
    val packages : Seq[LFTincanPackage] = parameters match {
      case Seq(("ids", courseIDs: List[Int])) =>{
        LFTincanPackageLocalServiceUtil.findByInstance(courseIDs.toArray.map(i => i:java.lang.Integer)).asScala
      }
      case Seq(("courseID", courseID: Int)) =>
        LFTincanPackageLocalServiceUtil.findByCourseID(courseID).asScala
      case Seq() =>  LFTincanPackageLocalServiceUtil.findAll().asScala
      case _ => Seq(LFTincanPackageLocalServiceUtil.getLFTincanPackage(-1))
    }
    packages filter(_ != null) map { extract }
  }

  private def extract(lfEntity: LFTincanPackage)={
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    new Manifest(
      lfEntity.getId.toInt,
      lfEntity.getTitle,
      Option(lfEntity.getSummary),
      lfEntity.getCourseID.toOption,
      lfEntity.getAssetRefID.toOption,
      None, false)
  }

  def create(parameters: (String, Any)*) {throw new UnsupportedOperationException}
  def create(entity: Manifest, parameters: (String, Any)*) {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val newEntity = LFTincanPackageLocalServiceUtil.createLFTincanPackage()

    newEntity.setCourseID(entity.courseID)
    newEntity.setTitle(entity.title)
    newEntity.setSummary(entity.summary.getOrElse(null))
    newEntity.setAssetRefID(entity.assetRefID)

    LFTincanPackageLocalServiceUtil.addLFTincanPackage(newEntity).getId.toInt
  }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id: Any)) =>
        LFTincanPackageLocalServiceUtil.deleteLFTincanPackage(getLong(id))
    }
  }

  def modify(parameters: (String, Any)*) {
    val lfEntity = parameters match {
      case Seq(("id", id: Int), ("title", title: String), ("summary", summary: String)) => {
        val entity = LFTincanPackageLocalServiceUtil.findByPackageID(Array(id.toLong:java.lang.Long)).get(0)
        entity.setTitle(title)
        entity.setSummary(summary)
        entity
      }
      case Seq(("id", id: Any), ("assetRefID", assetRefID: Any)) =>{
        val entity = LFTincanPackageLocalServiceUtil.findByPackageID(Array(getLong(id).toLong:java.lang.Long)).get(0)
        entity.setAssetRefID(getLong(assetRefID))
        entity
      }
    }
    LFTincanPackageLocalServiceUtil.updateLFTincanPackage(lfEntity)
  }

  def modify(entity: Manifest, parameters: (String, Any)*) {throw new UnsupportedOperationException}
  def getByID(id: Int, parameters: (String, Any)*) = {
    Option(LFTincanPackageLocalServiceUtil.getLFTincanPackage(id)).map(extract)
  }

  def createAndGetID(entity: Manifest, parameters: (String, Any)*) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    val newEntity = LFTincanPackageLocalServiceUtil.createLFTincanPackage()

    newEntity.setCourseID(entity.courseID)
    newEntity.setSummary(entity.summary.getOrElse(null))
    newEntity.setTitle(entity.title)

    LFTincanPackageLocalServiceUtil.addLFTincanPackage(newEntity).getId.toInt
  }

  override def getAll(sql: String, parameters: (String, Any)*) = {
    throw new UnsupportedOperationException()
  }

  def createAndGetID(parameters: (String, Any)*) = { throw new UnsupportedOperationException }

  def execute(sqlKey: String, parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Manifest] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {throw new UnsupportedOperationException}
}
