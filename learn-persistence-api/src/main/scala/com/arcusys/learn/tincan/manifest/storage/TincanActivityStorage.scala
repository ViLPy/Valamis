package com.arcusys.learn.tincan.manifest.storage

import com.arcusys.learn.tincan.manifest.model.Activity

trait TincanActivityStorage {
  def renew()

  def createAndGetID(entity: Activity): Int

  def getByPackageID(packageID: Int): Seq[Activity]

  def deleteByPackageID(packageID: Int)
}
