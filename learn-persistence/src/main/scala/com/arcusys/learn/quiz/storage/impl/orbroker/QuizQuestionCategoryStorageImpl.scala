package com.arcusys.learn.quiz.storage.impl.orbroker

import com.arcusys.learn.quiz.model._
import com.arcusys.learn.quiz.storage._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.Row

class QuizQuestionCategoryStorageImpl extends KeyedEntityStorageImpl[QuizQuestionCategory]("QuizCategory", "id") with QuizQuestionCategoryStorage {
  def getChildren(quizID: Int, parentID: Option[Int]) = getAll("quizID" -> quizID, "parentID" -> parentID.getOrElse(-1))

  override def createAndGetID(entity: QuizQuestionCategory): Int = createAndGetID(entity, "parentID" -> entity.parentID)

  def modify(id: Int, title: String, description: String) {
    modify("id" -> id, "title" -> title, "description" -> description)
  }

  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterSibling: Boolean) = {
    execute("_move", "id" -> id, "moveAfter" -> moveAfterSibling, "siblingID" -> siblingID, "parentID" -> parentID)
    getByID(id).getOrElse(throw new Exception("Some errors occured while move"))
  }

  def extract(row: Row) = new QuizQuestionCategory(
    row.integer("id").get,
    row.string("title").get,
    row.string("description").get,
    row.integer("quizID").get,
    row.integer("parentID")
  )
}