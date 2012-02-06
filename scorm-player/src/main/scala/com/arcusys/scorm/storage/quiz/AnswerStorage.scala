
package com.arcusys.scorm.storage.quiz

import com.arcusys.scorm.model.quiz._

trait AnswerStorage
{
  def getAll: IndexedSeq[Answer]
  def getByID(id: Int): Option[Answer]
  def getByQuestion(questionID: Int): IndexedSeq[Answer]
  def create(questionID: Int, position: Int, entity: Answer): Answer
  def delete(id: Int): Unit
  def renew: Unit
  def modify(entity: Answer): Answer
}
