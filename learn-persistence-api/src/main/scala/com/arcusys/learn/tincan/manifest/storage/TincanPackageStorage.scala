package com.arcusys.learn.tincan.manifest.storage

import com.arcusys.learn.tincan.manifest.model.TincanManifest
import com.arcusys.learn.scorm.manifest.model.PeriodType._
import com.arcusys.learn.scorm.manifest.model.ScopeType

trait TincanPackageStorage {
  def renew()

  def createAndGetID(entity: TincanManifest, courseID: Option[Int]): Int

  def getByRefID(refID: Long): Option[TincanManifest]

  def getAll: Seq[TincanManifest]

  def getByCourseID(courseID: Option[Int]): Seq[TincanManifest]

  def getAllForInstance(courseIDs: List[Int]): Seq[TincanManifest]

  def getInstanceScopeOnlyVisible(courseIDs: List[Int]): Seq[TincanManifest]

  def getOnlyVisibile(scope: ScopeType.Value, scopeID: String): Seq[TincanManifest]

  def getByID(id: Int): Option[TincanManifest]

  def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String): Seq[TincanManifest]

  def getByExactScope(courseIDs: List[Int], scope: ScopeType.Value, scopeID: String): Seq[TincanManifest]

  def delete(id: Int)

  def setDescriptions(id: Int, title: String, summary: String)
  def setLogo(id: Int, logo: Option[String])
  def setLimits(id: Int, passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType)

  def setAssetRefID(id: Int, refID: Long)
}
