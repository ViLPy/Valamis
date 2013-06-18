package com.arcusys.learn.questionbank.storage.impl

import com.arcusys.learn.questionbank.storage.QuestionCategoryStorage
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.questionbank.model.QuestionCategory

/**
 * User: dkudinov
 * Date: 20.3.2013
 */
trait QuestionCategoryEntityStorage extends QuestionCategoryStorage with KeyedEntityStorageExt[QuestionCategory] with EntityStorageExt[QuestionCategory] {
  def getChildren(parentID: Option[Int], courseID:Option[Int]) = getAll("parentID" -> parentID.getOrElse(-1), "courseID" -> courseID.getOrElse(-1))

  def getAllByCourseID(courseID: Option[Int]) = getAll("courseID" -> courseID.getOrElse(-1))

  override def createAndGetID(entity: QuestionCategory): Int = {
    val arrangementIndex: Int = maxArrangementIndex(getChildren(entity.parentID, entity.courseID)) + 1
    createAndGetID(entity, "parentID" -> entity.parentID, "arrangementIndex" -> arrangementIndex)
  }

  def modify(id: Int, title: String, description: String) {
    modify("id" -> id, "title" -> title, "description" -> description)
  }

  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterTarget: Boolean) {
    val questionCategoryForUpdate = getByID(id).get
    val oldChildren: Seq[QuestionCategory] = getChildren(parentID, questionCategoryForUpdate.courseID)

    def doMove(forUpdate: Seq[QuestionCategory], forIndex: Seq[QuestionCategory]) {
      forUpdate.foreach {
        questionCategory =>
          modify("id" -> questionCategory.id, "arrangementIndex" -> (questionCategory.arrangementIndex + 1))
      }
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
          val forUpdate = if (spannedChildren._2.isEmpty)  Nil else spannedChildren._2.tail
          doMove(forUpdate, forIndex)
        }
      }
    }
  }

  def maxArrangementIndex(oldChildren: Seq[QuestionCategory]): Int = {
    oldChildren.foldLeft(0)(_ max _.arrangementIndex)
  }
}
