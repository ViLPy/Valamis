package com.arcusys.learn.tincan.manifest.storage

import com.arcusys.learn.tincan.manifest.model.ManifestActivity

trait TincanManifestActivityStorage {
  def renew()

  def createAndGetID(entity: ManifestActivity): Int

  def getByPackageID(packageID: Int): Seq[ManifestActivity]

  def deleteByPackageID(packageID: Int)
}
