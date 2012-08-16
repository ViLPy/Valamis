package com.arcusys.learn.scorm.manifest.storage

import com.arcusys.learn.scorm.manifest.model._

trait PackagesStorage
{
  def getOnlyVisible: Seq[Manifest]
  def getAll: Seq[Manifest]
  def getByID(id: Int): Option[Manifest]
  def createAndGetID(entity: Manifest): Int
  def delete(id: Int)
  def setVisibility(id: Int, visibility: Boolean)
  def setDescriptions(id: Int, title: String, summary: String)
}
