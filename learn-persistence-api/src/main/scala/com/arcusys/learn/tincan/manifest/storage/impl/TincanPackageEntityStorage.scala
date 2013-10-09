package com.arcusys.learn.tincan.manifest.storage.impl

import com.arcusys.learn.tincan.manifest.storage.TincanPackageStorage
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.tincan.manifest.model.Manifest

trait TincanPackageEntityStorage extends TincanPackageStorage with KeyedEntityStorageExt[Manifest] with EntityStorageExt[Manifest]{

  def createAndGetID(entity: Manifest, courseID:Option[Int]): Int = {
    createAndGetID(entity.copy(id = 0, courseID = courseID))
  }

  def getByRefID(refID: Long): Option[Manifest] = {
    getOne("refID" -> refID)
  }

//  def getByCourseID(courseID: Option[Int]) : Seq[Manifest] = {
//    courseID.map(courseID => getByScope(courseID, ScopeType.Site, courseID.toString)).getOrElse(Seq())
//  }
//
//  def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String) : Seq[Manifest] = {
//    getAll("courseID" -> courseID)
//  }

//  def getAllForInstance(courseIDs: List[Int]) : Seq[Manifest] = {
//    getAll("ids" -> courseIDs)
//  }

  def setDescriptions(id: Int, title: String, summary: String) {
    modify("id" -> id, "title" -> title, "summary" -> summary)
  }

  def setAssetRefID(id: Int, refID: Long) {
    modify("id" -> id, "assetRefID" -> refID)
  }
}
