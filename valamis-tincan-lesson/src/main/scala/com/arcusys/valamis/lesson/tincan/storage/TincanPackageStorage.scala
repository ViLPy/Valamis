package com.arcusys.valamis.lesson.tincan.storage

import com.arcusys.valamis.lesson.tincan.model.{ TincanManifest, TincanPackage }
import com.arcusys.valamis.model.ScopeType
import org.joda.time.DateTime

trait TincanPackageStorage {
  def createAndGetID(title: String, summary: String, courseID: Option[Int]): Long

  def getByRefID(refID: Long): Option[TincanManifest]

  def getAll: Seq[TincanManifest]

  def getByCourseId(courseID: Option[Int], onlyVisible: Boolean = false): Seq[TincanManifest]

  def getAllForInstance(courseIDs: List[Int]): Seq[TincanManifest]

  def getInstanceScopeOnlyVisible(courseIDs: List[Int], titlePattern: Option[String], date: DateTime): Seq[TincanPackage]

  def getOnlyVisible(scope: ScopeType.Value, scopeID: String, titlePattern: Option[String], date: DateTime): Seq[TincanPackage]

  def getById(id: Long): Option[TincanPackage]

  def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String): Seq[TincanManifest]

  def getByExactScope(courseIDs: List[Int], scope: ScopeType.Value, scopeID: String): Seq[TincanManifest]

  def getByTitleAndCourseId(titlePattern: String, courseIds: Seq[Int]): Seq[TincanPackage]

  def getCountByTitleAndCourseId(titlePattern: String, courseIds: Seq[Int]): Int

  def delete(id: Long)

  def modify(id: Long, title: String, summary: String, beginDate: Option[DateTime], endDate: Option[DateTime]): TincanPackage
  def setLogo(id: Long, logo: Option[String])

  def setAssetRefID(id: Long, refID: Long): TincanPackage
}
