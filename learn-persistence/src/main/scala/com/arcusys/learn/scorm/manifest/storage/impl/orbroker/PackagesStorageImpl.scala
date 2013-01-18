package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.storage._
import org.orbroker.{Token, Row}
import com.arcusys.learn.storage.impl.orbroker._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.BrokerFactory._
import org.postgresql.ds.PGPoolingDataSource

class PackagesStorageImpl extends KeyedEntityStorageImpl[Manifest]("Package", "id") with PackagesStorage {

  def getByRefID(refID:Long): Option[Manifest] = getOne("refID" -> refID)

  def getByCourseID(courseID: Option[Int]) =
    getAll("_getbyscope", "scope" -> ScopeType.Site.toString, "scopeID" -> courseID.map(_.toString), "courseID" -> courseID)

  def getAllForInstance(courseIDs: List[Int]) =
    getAll("_getbyinstance", "ids" -> courseIDs)

  def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String)=
    getAll("_getbyscope", "scope" -> scope.toString, "scopeID" -> scopeID, "courseID" -> courseID)

  def getOnlyVisbile(scope: ScopeType.Value, scopeID: String) =
    getAll("_getonlyvisible", "scope" -> scope.toString, "scopeID" -> scopeID)

  def getInstanceScopeOnlyVisbile(courseIDs: List[Int]) =
    getAll("_getbyinstance", "ids" -> courseIDs, "onlyVisible" -> true)

  def createAndGetID(entity: Manifest, courseID:Option[Int]): Int ={
    val newEntity = new Manifest(0, entity.version, entity.base, entity.scormVersion, entity.defaultOrganizationID,
      entity.resourcesBase, entity.title,entity.summary, entity.metadata,entity.assetRefID, courseID)
    createAndGetID(newEntity)
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
    None,
    row.bigInt("assetRefID"),
    row.integer("courseID"),
    if (row.columns.contains("visibility")) row.bit("visibility") else None
  )
  //TODO: store SCORM version in DB
}
