package com.arcusys.scorm.storage

import com.arcusys.scorm.model.quiz._

trait QuestionCategoryStorage
{
  def getAll: IndexedSeq[QuestionCategory]
  def getByID(id: Int): Option[QuestionCategory]
  def getChildren(parentID: Option[Int]): IndexedSeq[QuestionCategory]
  def create(entity: QuestionCategory): (Int,QuestionCategory)
  def delete(id: Int): Unit
  def renew: Unit
  def modify(entity: QuestionCategory): (Int,QuestionCategory)
}
