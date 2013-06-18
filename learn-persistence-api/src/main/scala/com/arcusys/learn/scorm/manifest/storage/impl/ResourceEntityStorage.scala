package com.arcusys.learn.scorm.manifest.storage.impl

import com.arcusys.learn.scorm.manifest.storage.ResourcesStorage
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.scorm.manifest.model.{AssetResource, ScoResource, Resource}

trait ResourceEntityStorage extends ResourcesStorage with KeyedEntityStorageExt[Resource] with EntityStorageExt[Resource]{
//  def getAll = getAll()

  def getByPackageID(packageID: Int) = getAll("packageID" -> packageID)

  override def getByID(packageID: Int, resourceID: String) = getOne("packageID" -> packageID, "identifierRef" -> resourceID)

  def createForPackageAndGetID(packageID: Int, entity: Resource) =
    createAndGetID(entity, "packageID" -> packageID, "scormType" -> (entity match {
      case _: ScoResource => "sco"
      case _: AssetResource => "asset"
    }))
}