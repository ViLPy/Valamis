
package com.arcusys.scorm.storage

import com.arcusys.scorm.model.quiz._

trait AnswerStorage
{
  def getAll: IndexedSeq[Answer]
  def getByID(id: Int): Option[Answer]
  def getByQuestion(questionID: Int): IndexedSeq[Answer]
  def create(questionID: Int, position: Int, entity: Answer): (Int,Answer)
  def delete(id: Int): Unit
  def renew: Unit
  def modify(entity: Answer): (Int,Answer)
}
