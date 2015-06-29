package com.arcusys.valamis.lesson.scorm.storage

import com.arcusys.valamis.lesson.scorm.model.{ ScormPackage, manifest }
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.model.ScopeType
import org.joda.time.DateTime

trait ScormPackagesStorage {

  def getByTitleAndCourseId(titlePattern: String, courseIds: Seq[Int]): Seq[ScormPackage]
  def getCountByTitleAndCourseId(titlePattern: String, courseIds: Seq[Int]): Int

  def getAll: Seq[manifest.Manifest]
  def getByRefID(refID: Long): Option[manifest.Manifest]
  // for Player show only visible in current scope
  def getOnlyVisible(scope: ScopeType.Value, scopeID: String, titlePattern: Option[String], date: DateTime): Seq[ScormPackage]
  def getInstanceScopeOnlyVisible(courseIDs: List[Int], titlePattern: Option[String], date: DateTime): Seq[ScormPackage]
  // get all in course with visibility
  def getByCourseId(courseID: Option[Int]): Seq[manifest.Manifest]
  // get all in instance with visibility
  def getAllForInstance(courseIDs: List[Int]): Seq[manifest.Manifest]
  // get all in current course (liferay site) by scope with visibility
  def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String): Seq[manifest.Manifest]
  def getByExactScope(courseIDs: List[Int], scope: ScopeType.Value, scopeID: String): Seq[manifest.Manifest]

  def getById(id: Long): Option[ScormPackage]
  def getById(id: Long, courseID: Int, scope: ScopeType.Value, scopeID: String): Option[manifest.Manifest]
  def createAndGetID(entity: manifest.Manifest, courseID: Option[Int]): Long
  def delete(id: Long)
  def setAssetRefID(id: Long, refID: Long)
  def modify(id: Long, title: String, description: String, beginDate: Option[DateTime], endDate: Option[DateTime]): ScormPackage
  def setLogo(id: Long, logo: Option[String])

  // These 2 methods is only for SCORM packages
  def getPackagesWithAttempts: Seq[manifest.Manifest]
  def getPackagesWithUserAttempts(userID: Int): Seq[Manifest]
  def renew()
}
