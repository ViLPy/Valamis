package com.arcusys.learn.quiz.storage

import com.arcusys.learn.quiz.model.QuizTreeElement

trait QuizTreeStorage {
  def getByQuizID(quizID: Int): Seq[QuizTreeElement]
  def getByQuizAndElementID(quizID: Int, elementID: String): Option[QuizTreeElement]
  def getByQuizAndParentID(quizID: Int, parentID: Option[String]): Seq[QuizTreeElement]
  def createAndGetID(entity: QuizTreeElement): Int
  def delete(id: Int)
  def move(entity: QuizTreeElement, prevIndex: Int)
  def renew()

  def getRealElementID(entity: QuizTreeElement): Int
}
