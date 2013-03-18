package com.arcusys.learn.scorm.manifest.storage

import com.arcusys.learn.scorm.manifest.model._

trait PackagesStorage
{
  def getAll: Seq[Manifest]
  def getByRefID(refID:Long): Option[Manifest]
  // for Player show only visible in current scope
  def getOnlyVisbile(scope: ScopeType.Value, scopeID: String): Seq[Manifest]
  def getInstanceScopeOnlyVisbile(courseIDs: List[Int]): Seq[Manifest]
  // get all in course with visibility
  def getByCourseID(courseID: Option[Int]): Seq[Manifest]
  // get all in instance with visibility
  def getAllForInstance(courseIDs: List[Int]): Seq[Manifest]
  // get all in current course (liferay site) by scope with visibility
  def getByScope(courseID: Int, scope: ScopeType.Value, scopeID: String): Seq[Manifest]

  def getByID(id: Int): Option[Manifest]
  def getByID(id: Int, courseID: Int, scope: ScopeType.Value, scopeID: String): Option[Manifest]
  def createAndGetID(entity: Manifest, courseID:Option[Int]): Int
  def delete(id: Int)
  def setAssetRefID(id: Int, refID:Long)
  def setDescriptions(id: Int, title: String, summary: String)
}
