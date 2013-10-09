package com.arcusys.learn.tincan.manifest.storage

import com.arcusys.learn.tincan.manifest.model.Manifest

trait TincanPackageStorage {
  def renew()

  def createAndGetID(entity: Manifest, courseID:Option[Int]): Int

  def getByRefID(refID:Long): Option[Manifest]

  def getAll: Seq[Manifest]

//  def getByCourseID(courseID: Option[Int]): Seq[Manifest]
//
//  def getAllForInstance(courseIDs: List[Int]): Seq[Manifest]

  def getByID(id: Int): Option[Manifest]

  def delete(id: Int)

  def setDescriptions(id: Int, title: String, summary: String)

  def setAssetRefID(id: Int, refID:Long)
}
