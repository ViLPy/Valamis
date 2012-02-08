package com.arcusys.scorm.storage.quiz

import com.arcusys.scorm.model.quiz._

trait QuestionStorage
{
  def getAll: IndexedSeq[Question[Answer]]
  def getByID(id: Int): Option[Question[Answer]]
  def getByCategory(categoryID: Option[Int]): IndexedSeq[Question[Answer]]
  def createQuestion(entity: Question[Answer]): Question[Answer]
  def delete(id: Int): Unit
  def renew: Unit
  def modifyQuestion(entity: Question[Answer]): Question[Answer]
  def move(entity: Question[Answer], moveToCategory: Boolean, isMoveAfter: Boolean, targetID: Int, categoryID: Option[Int]): Question[Answer]
}
