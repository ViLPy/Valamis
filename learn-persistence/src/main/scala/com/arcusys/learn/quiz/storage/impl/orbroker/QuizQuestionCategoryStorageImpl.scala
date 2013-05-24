package com.arcusys.learn.quiz.storage.impl.orbroker

import com.arcusys.learn.quiz.model._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.quiz.storage.impl.QuizQuestionCategoryEntityStorage

class QuizQuestionCategoryStorageImpl extends KeyedEntityStorageBaseImpl[QuizQuestionCategory]("QuizCategory", "id")
  with QuizQuestionCategoryEntityStorage with QuizQuestionCategoryEntityExtractor {

/*
  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterSibling: Boolean) = {
    execute("_move", "id" -> id, "moveAfter" -> moveAfterSibling, "siblingID" -> siblingID, "parentID" -> parentID)
    getByID(id).getOrElse(throw new Exception("Some errors occured while move"))
  }
*/
}

trait QuizQuestionCategoryEntityExtractor extends RowExtractor[QuizQuestionCategory] {
  def extract(row: Row) = new QuizQuestionCategory(
    row.integer("id").get,
    row.string("title").get,
    row.string("description").get,
    row.integer("quizID").get,
    row.integer("parentID")
  )
}