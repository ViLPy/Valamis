package com.arcusys.learn.tincan.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct
import com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalServiceUtil
import com.arcusys.valamis.lesson.tincan.model.ManifestActivity
import com.arcusys.valamis.lesson.tincan.storage.TincanManifestActivityStorage
import scala.collection.JavaConverters._

class TincanManifestActivityRepositoryImpl extends TincanManifestActivityStorage {
  override def renew(): Unit = {
    LFTincanManifestActLocalServiceUtil.removeAll()
  }

  override def getByPackageId(packageID: Long): Seq[ManifestActivity] = {
    LFTincanManifestActLocalServiceUtil.findByPackageID(packageID).asScala.map(extract)
  }

  override def deleteByPackageId(packageID: Long) = {
    for (lfEntity <- LFTincanManifestActLocalServiceUtil.findByPackageID(packageID).asScala) {
      LFTincanManifestActLocalServiceUtil.deleteLFTincanManifestAct(lfEntity.getId)
    }
  }

  override def createAndGetId(entity: ManifestActivity): Int = {
    val newEntity = LFTincanManifestActLocalServiceUtil.createLFTincanManifestActivity()

    newEntity.setActivityType(entity.activityType)
    newEntity.setDescription(entity.description)
    newEntity.setLaunch(entity.launch.getOrElse(""))
    newEntity.setName(entity.name)
    newEntity.setPackageID(entity.packageId)
    newEntity.setResourceID(entity.resource.getOrElse(""))
    newEntity.setTincanID(entity.tincanId)

    LFTincanManifestActLocalServiceUtil.addLFTincanManifestAct(newEntity).getId.toInt
  }

  private def extract(lfEntity: LFTincanManifestAct) = {
    new ManifestActivity(
      lfEntity.getId.toInt,
      lfEntity.getTincanID,
      lfEntity.getPackageID,
      lfEntity.getActivityType,
      lfEntity.getName, lfEntity.getDescription, Option(lfEntity.getLaunch), Option(lfEntity.getResourceID))
  }
}
