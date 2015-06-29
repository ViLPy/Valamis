package com.arcusys.valamis.lesson.tincan.storage

import com.arcusys.valamis.lesson.tincan.model.ManifestActivity

trait TincanManifestActivityStorage {
  def renew()

  def createAndGetId(entity: ManifestActivity): Int

  def getByPackageId(packageId: Long): Seq[ManifestActivity]

  def deleteByPackageId(packageId: Long)
}
