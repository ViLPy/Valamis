package com.arcusys.learn.quiz.storage.impl

import com.arcusys.learn.storage.impl.{ KeyedEntityStorageExt, EntityStorageExt }
import com.arcusys.valamis.quiz.model.QuizTreeElement
import com.arcusys.valamis.quiz.storage.QuizTreeStorage

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

  def move(element: QuizTreeElement, prevIndex: Int, prevParent: Option[String]) {
    val movingForwardCoeff =
      if (prevParent == element.parentID) if (prevIndex < element.arrangementIndex) 1 else 0
      else {
        val dir = getByQuizID(element.quizID).find(t => Some(t.elementID) == prevParent) //Checked only for folders inside root
        if (dir.isDefined && dir.get.arrangementIndex < element.arrangementIndex) 1 else 0
      }

    val (before, after) = getByQuizID(element.quizID).filter(el => el.parentID == element.parentID && el.id != element.id)
      .sortBy(_.arrangementIndex).partition(_.arrangementIndex < element.arrangementIndex + movingForwardCoeff)

    ((before :+ element) ++ after)
      .zipWithIndex.foreach {
        case (quizTreeElement, index) =>
          modify(quizTreeElement.copy(arrangementIndex = index + 1))
      }
  }

  private def maxArrangementIndex(oldChildren: Seq[QuizTreeElement]): Int = {
    oldChildren.foldLeft(0)(_ max _.arrangementIndex)
  }
}
