package com.arcusys.learn.tincan.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct
import com.arcusys.learn.persistence.liferay.service.{ LFTincanManifestActLocalServiceUtil, LFTincanActivityLocalServiceUtil }
import com.arcusys.learn.tincan.manifest.model.ManifestActivity
import com.arcusys.learn.tincan.manifest.storage.TincanManifestActivityStorage
import scala.collection.JavaConverters._

/**
 * Created by mminin on 15.10.14.
 */
class TincanManifestActivityRepositoryImpl extends TincanManifestActivityStorage {
  override def renew(): Unit = {
    LFTincanActivityLocalServiceUtil.removeAll()
  }

  override def getByPackageID(packageID: Int): Seq[ManifestActivity] = {
    LFTincanManifestActLocalServiceUtil.findByPackageID(getLong(packageID)).asScala.map(extract)
  }

  override def deleteByPackageID(packageID: Int) = {
    for (lfEntity <- LFTincanActivityLocalServiceUtil.findByPackageID(getLong(packageID)).asScala) {
      LFTincanActivityLocalServiceUtil.deleteLFTincanActivity(getLong(lfEntity.getId))
    }
  }

  override def createAndGetID(entity: ManifestActivity): Int = {
    val newEntity = LFTincanManifestActLocalServiceUtil.createLFTincanManifestActivity()

    newEntity.setActivityType(entity.activityType)
    newEntity.setDescription(entity.description)
    newEntity.setLaunch(entity.launch.getOrElse(""))
    newEntity.setName(entity.name)
    newEntity.setPackageID(getLong(entity.packageId))
    newEntity.setResourceID(entity.resource.getOrElse(""))
    newEntity.setTincanID(entity.tincanId)

    LFTincanManifestActLocalServiceUtil.addLFTincanManifestAct(newEntity).getId.toInt
  }

  private def extract(lfEntity: LFTincanManifestAct) = {
    new ManifestActivity(
      lfEntity.getId.toInt,
      lfEntity.getTincanID,
      lfEntity.getPackageID.toInt,
      lfEntity.getActivityType,
      lfEntity.getName, lfEntity.getDescription, Option(lfEntity.getLaunch), Option(lfEntity.getResourceID))
  }

  private def getLong(value: Any): Long = {
    value match {
      case i: Int  => i.toLong
      case l: Long => l
      case _       => 0
    }
  }
}
