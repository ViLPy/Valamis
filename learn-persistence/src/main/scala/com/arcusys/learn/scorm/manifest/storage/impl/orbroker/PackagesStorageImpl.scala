package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.storage._
import org.orbroker.Row
import com.arcusys.learn.storage.impl.orbroker._
import com.arcusys.learn.scorm.manifest.model._

class PackagesStorageImpl extends KeyedEntityStorageImpl[Manifest]("Package", "id") with PackagesStorage {
  def getOnlyVisible: Seq[Manifest] = getAll("visibility" -> true)

  def getByRefID(refID:Long): Option[Manifest] = getOne("refID" -> refID)

  def setVisibility(id: Int, visibility: Boolean) {
    execute("_setvisibility", "id" -> id, "visibility" -> visibility)
  }

  def setDescriptions(id: Int, title: String, summary: String) {
    execute("_setdescriptions", "id" -> id, "title" -> title, "summary" -> summary)
  }

  def setAssetRefID(id: Int, refID:Long) {
    execute("_setrefid", "id" -> id, "assetRefID" -> refID)
  }

  def extract(row: Row) = new Manifest(
    row.integer("id").get,
    None, // version
    row.string("base"),
    "",
    row.string("defaultOrganizationID"),
    row.string("resourcesBase"),
    row.string("title").get,
    row.string("summary"),
    row.bit("visibility").get,
    None,
    row.bigInt("assetRefID")
  )
  //TODO: store SCORM version in DB
}
