package com.arcusys.learn.tincan.manifest.storage

import com.arcusys.learn.tincan.manifest.model.Manifest
import com.arcusys.learn.scorm.manifest.model.ScopeType

trait TincanPackageStorage {
  def renew()

  def createAndGetID(entity: Manifest, courseID: Option[Int]): Int

  def getByRefID(refID: Long): Option[Manifest]

  def getAll: Seq[Manifest]

  def getByCourseID(courseID: Option[Int]): Seq[Manifest]

  def getAllForInstance(courseIDs: List[Int]): Seq[Manifest]

  def getInstanceScopeOnlyVisible(courseIDs: List[Int]): Seq[Manifest]

  def getOnlyVisibile(scope: ScopeType.Value, scopeID: String): Seq[Manifest]

  def getByID(id: Int): Option[Manifest]

  def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String): Seq[Manifest]

  def getByExactScope(courseIDs: List[Int], scope: ScopeType.Value, scopeID: String): Seq[Manifest]

  def delete(id: Int)

  def setDescriptions(id: Int, title: String, summary: String)
  def setLogo(id: Int, logo: Option[String])

  def setAssetRefID(id: Int, refID: Long)
}
