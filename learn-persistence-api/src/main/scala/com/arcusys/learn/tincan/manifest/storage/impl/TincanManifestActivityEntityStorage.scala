package com.arcusys.learn.tincan.manifest.storage.impl

import com.arcusys.learn.tincan.manifest.model.ManifestActivity
import com.arcusys.learn.tincan.manifest.storage.TincanManifestActivityStorage
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}

trait TincanManifestActivityEntityStorage extends TincanManifestActivityStorage with KeyedEntityStorageExt[ManifestActivity] with EntityStorageExt[ManifestActivity] {

  def getByPackageID(packageID: Int): Seq[ManifestActivity] = {
    getAll("packageID" -> packageID)
  }

  def deleteByPackageID(packageID: Int) = {
    delete("packageID" -> packageID)
  }
}
