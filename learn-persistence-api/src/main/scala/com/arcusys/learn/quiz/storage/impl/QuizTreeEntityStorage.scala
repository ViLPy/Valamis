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

  def getRealElementID(entity: QuizTreeElement): Int = {
    if (entity.isCategory) {
      entity.elementID.replace("c_", "").toInt
    } else {
      entity.elementID.replace("q_", "").toInt
    }
  }

  def getByQuizID(quizID: Int) =
    getAll("quizID" -> quizID)

  def getByQuizAndElementID(quizID: Int, elementID: String) =
    getOne("quizID" -> quizID, "elementID" -> elementID)

  def getByQuizAndParentID(quizID: Int, parentID: Option[String]) =
    getAll("quizID" -> quizID, "parentID" -> parentID)

  def move(element: QuizTreeElement, prevIndex: Int) {
    val sameRootElements = getByQuizID(element.quizID).filter(_.parentID == element.parentID)
    // recalculate all arrangement indices which are higher or equal to element new index
    if (element.arrangementIndex < prevIndex) {
      sameRootElements.filter(_.arrangementIndex >= element.arrangementIndex).map(e => {
        e.copy(arrangementIndex = e.arrangementIndex + 1)
      }).foreach(modify)
    }

    if (element.arrangementIndex > prevIndex) {
      sameRootElements.filter(se => se.arrangementIndex > prevIndex && se.arrangementIndex <= element.arrangementIndex).map(e => {
        e.copy(arrangementIndex = e.arrangementIndex - 1)
      }).foreach(modify)
    }

    modify(element)

    val indexSet = (1 to sameRootElements.length).toSet
    val newSameRoot = getByQuizID(element.quizID).filter(_.parentID == element.parentID)
    val newSameRootIdx = newSameRoot.map(_.arrangementIndex).toSet
    val diff = indexSet.diff(newSameRootIdx).toSeq.sorted.headOption
    if (diff.isDefined) {
      newSameRoot.filter(_.arrangementIndex > diff.get).map(e => {
        e.copy(arrangementIndex = e.arrangementIndex - 1)
      }).foreach(modify)
    }
  }

  private def maxArrangementIndex(oldChildren: Seq[QuizTreeElement]): Int = {
    oldChildren.foldLeft(0)(_ max _.arrangementIndex)
  }
}
