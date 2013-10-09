package com.arcusys.learn.tincan.manifest.storage.impl

import com.arcusys.learn.tincan.manifest.model.Activity
import com.arcusys.learn.tincan.manifest.storage.TincanActivityStorage
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}

trait TincanActivityEntityStorage extends TincanActivityStorage with KeyedEntityStorageExt[Activity] with EntityStorageExt[Activity] {

  def getByPackageID(packageID: Int): Seq[Activity] = {
    getAll("packageID" -> packageID)
  }

  def deleteByPackageID(packageID: Int) = {
    delete("packageID" -> packageID)
  }
}
