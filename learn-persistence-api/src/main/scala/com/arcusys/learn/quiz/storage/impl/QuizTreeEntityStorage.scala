package com.arcusys.learn.quiz.storage.impl

import com.arcusys.learn.quiz.storage.QuizTreeStorage
import com.arcusys.learn.quiz.model.QuizTreeElement
import com.arcusys.learn.storage.impl.{ KeyedEntityStorageExt, EntityStorageExt }

trait QuizTreeEntityStorage
    extends QuizTreeStorage with KeyedEntityStorageExt[QuizTreeElement] with EntityStorageExt[QuizTreeElement] {
  override def createAndGetID(entity: QuizTreeElement): Int = {
    val index = maxArrangementIndex(getByQuizID(entity.quizID).filter(_.parentID == entity.parentID)) + 1
    createAndGetID(entity, "arrangementIndex" -> index)
  }

  def getByQuizID(quizID: Int) =
    getAll("quizID" -> quizID)

  def getByQuizAndElementID(quizID: Int, elementID: String) =
    getOne("quizID" -> quizID, "elementID" -> elementID)

  def move(element: QuizTreeElement) {
    val sameRootElements = getByQuizID(element.quizID).filter(_.parentID == element.parentID)
    // recalculate all arrangement indices which are higher or equal to element new index
    sameRootElements.filter(_.arrangementIndex >= element.arrangementIndex).map(e => {
      e.copy(arrangementIndex = e.arrangementIndex + 1)
    }).foreach(modify)

    modify(element)
  }

  private def maxArrangementIndex(oldChildren: Seq[QuizTreeElement]): Int = {
    oldChildren.foldLeft(0)(_ max _.arrangementIndex)
  }
}
