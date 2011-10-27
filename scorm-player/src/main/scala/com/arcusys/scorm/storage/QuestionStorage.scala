package com.arcusys.scorm.storage

import com.arcusys.scorm.model.quiz._

trait QuestionStorage
{
  def getAll: IndexedSeq[Question[Answer]]
  def getByID(id: Int): Option[Question[Answer]]
  def getByCategory(categoryID: Option[Int]): IndexedSeq[Question[Answer]]
  def createQuestion(entity: Question[Answer]): (Int,Question[Answer])
  def delete(id: Int): Unit
  def renew: Unit
  def modifyQuestion(entity: Question[Answer]): (Int,Question[Answer])
}
