package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.Row

class ResourcesStorageImpl extends KeyedEntityStorageImpl[Resource]("Resource", "id") with ResourcesStorage {
  def getByPackageID(packageID: Int) = getAll("packageID" -> packageID)

  def getByID(packageID: Int, resourceID: String) = getOne("packageID" -> packageID, "identifierRef" -> resourceID)

  def createForPackageAndGetID(packageID: Int, entity: Resource) = createAndGetID(entity, "packageID" -> packageID, "scormType" -> (entity match {
    case _:ScoResource => "sco"
    case _:AssetResource => "asset"
  }))

  def extract(row: Row) = {
    val id = row.string("identifierRef").get
    val href = row.string("href")
    val base = row.string("base")
    if (row.string("scormType").getOrElse("").toLowerCase.equals("sco")) new ScoResource(id, href.get, base, Nil, Nil)
    else new AssetResource(id, href, base, Nil, Nil)
  }
}