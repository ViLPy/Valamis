package com.arcusys.learn.questionbank.storage

import com.arcusys.learn.questionbank.model.Answer

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait AnswerStorage {
  def getByQuestion(questionID: Int): Seq[Answer]

  def deleteByQuestion(questionID: Int)

  def createForQuestion(questionID: Int, answers: Seq[Answer])

  def renew()
}
