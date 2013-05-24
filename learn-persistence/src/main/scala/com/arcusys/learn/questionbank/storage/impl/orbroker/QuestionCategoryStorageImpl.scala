package com.arcusys.learn.questionbank.storage.impl.orbroker

import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.questionbank.storage.impl.QuestionCategoryEntityStorage

class QuestionCategoryStorageImpl extends KeyedEntityStorageBaseImpl[QuestionCategory]("QuestionCategory", "id")
  with QuestionCategoryEntityStorage with QuestionCategoryExtractor {

/*
  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterSibling: Boolean) {
    execute("_move", "id" -> id, "moveAfter" -> moveAfterSibling, "siblingID" -> siblingID, "parentID" -> parentID)
  }
*/
}

trait QuestionCategoryExtractor extends RowExtractor[QuestionCategory] {
  def extract(row: Row) = QuestionCategory(
    row.integer("id").get,
    row.string("title").get,
    row.string("description").get,
    row.integer("parentID"),
    row.integer("courseID")
  )
}