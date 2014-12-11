package com.arcusys.learn.scorm.manifest.storage

import com.arcusys.learn.scorm.manifest.model.PeriodType._
import com.arcusys.learn.scorm.manifest.model.{ Manifest, ScopeType }

trait ScormPackagesStorage {
  def getAll: Seq[Manifest]
  def getByRefID(refID: Long): Option[Manifest]
  // for Player show only visible in current scope
  def getOnlyVisible(scope: ScopeType.Value, scopeID: String): Seq[Manifest]
  def getInstanceScopeOnlyVisible(courseIDs: List[Int]): Seq[Manifest]
  // get all in course with visibility
  def getByCourseID(courseID: Option[Int]): Seq[Manifest]
  // get all in instance with visibility
  def getAllForInstance(courseIDs: List[Int]): Seq[Manifest]
  // get all in current course (liferay site) by scope with visibility
  def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String): Seq[Manifest]
  def getByExactScope(courseIDs: List[Int], scope: ScopeType.Value, scopeID: String): Seq[Manifest]

  def getByID(id: Int): Option[Manifest]
  def getByID(id: Int, courseID: Int, scope: ScopeType.Value, scopeID: String): Option[Manifest]
  def createAndGetID(entity: Manifest, courseID: Option[Int]): Int
  def delete(id: Int)
  def setAssetRefID(id: Int, refID: Long)
  def setDescriptions(id: Int, title: String, summary: String)
  def setLogo(id: Int, logo: Option[String])
  def setLimits(id: Int, passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType)

  // These 2 methods is only for SCORM packages
  def getPackagesWithAttempts: Seq[Manifest]
  def getPackagesWithUserAttempts(userID: Int): Seq[Manifest]
  def renew()
}
