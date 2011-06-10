package com.arcusys.scorm.storage

import com.arcusys.scorm.model._

trait PackagesStorage
{
  def getAll: IndexedSeq[Manifest]  
  def getByID(id: Int): Option[Manifest]
  def create(entity: Manifest): (Int,Manifest)
  def delete(id: Int): Unit
  def renew: Unit
  def modify(id: Int, entity: Manifest): (Int,Manifest)
  def renewTotally
}
