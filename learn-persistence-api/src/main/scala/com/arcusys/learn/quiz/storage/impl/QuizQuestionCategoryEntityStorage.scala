package com.arcusys.learn.quiz.storage.impl

import com.arcusys.learn.quiz.model.QuizQuestionCategory
import com.arcusys.learn.quiz.storage.QuizQuestionCategoryStorage
import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait QuizQuestionCategoryEntityStorage extends QuizQuestionCategoryStorage with KeyedEntityStorageExt[QuizQuestionCategory] with EntityStorageExt[QuizQuestionCategory] {
  def getChildren(quizID: Int, parentID: Option[Int]) = getAll("quizID" -> quizID, "parentID" -> parentID.getOrElse(-1))

  override def createAndGetID(entity: QuizQuestionCategory): Int = {
    val arrangementIndex: Int = maxArrangementIndex(getChildren(entity.quizID, entity.parentID)) + 1
    createAndGetID(entity, "parentID" -> entity.parentID, "arrangementIndex" -> arrangementIndex)
  }

  def modify(id: Int, title: String, description: String) {
    modify("id" -> id, "title" -> title, "description" -> description)
  }

  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterTarget: Boolean): QuizQuestionCategory = {
    val questionCategoryForUpdate = getByID(id).get
    val oldChildren: Seq[QuizQuestionCategory] = getAll("quizID" -> questionCategoryForUpdate.quizID, "parentID" -> parentID.getOrElse(-1))

    def doMove(forUpdate: Seq[QuizQuestionCategory], forIndex: Seq[QuizQuestionCategory]) {
      forUpdate.foreach {
        questionCategory =>
          modify("id" -> questionCategory.id, "arrangementIndex" -> (questionCategory.arrangementIndex + 1))
      }

      if (moveAfterTarget)
        modify("id" -> questionCategoryForUpdate.id, "arrangementIndex" -> (maxArrangementIndex(forUpdate) + 1), "parentID" -> parentID)
      else
        modify("id" -> questionCategoryForUpdate.id, "arrangementIndex" -> (maxArrangementIndex(forIndex) + 1), "parentID" -> parentID)
    }

    siblingID match {
      case None =>
        if (!moveAfterTarget) {
          doMove(oldChildren, Seq())
        } else {
          doMove(Seq(), oldChildren)
        }
      case Some(a: Int) => {
        val spannedChildren = oldChildren.span(_.id != siblingID.get)
        if (!moveAfterTarget) {
          val forIndex = spannedChildren._1
          val forUpdate = spannedChildren._2
          doMove(forUpdate, forIndex)
        } else {
          val forIndex = spannedChildren._1 ++ spannedChildren._2.headOption
          val forUpdate = if (spannedChildren._2.isEmpty) Nil else spannedChildren._2.tail
          doMove(forUpdate, forIndex)
        }
      }
    }
    getByID(id).getOrElse(throw new Exception("Some errors occured while move"))
  }

  def maxArrangementIndex(oldChildren: Seq[QuizQuestionCategory]): Int = {
    oldChildren.foldLeft(0)(_ max _.arrangementIndex)
  }

  def updateParent(id: Int, parentID: Option[Int]) {
    getByID(id).foreach(e => modify(e, "parentID" -> parentID))
  }
}
