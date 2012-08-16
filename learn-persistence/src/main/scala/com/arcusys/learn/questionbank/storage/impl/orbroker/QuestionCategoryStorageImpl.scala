package com.arcusys.learn.questionbank.storage.impl.orbroker

import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.questionbank.storage._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.Row

class QuestionCategoryStorageImpl extends KeyedEntityStorageImpl[QuestionCategory]("QuestionCategory", "id") with QuestionCategoryStorage {
  def getChildren(parentID: Option[Int]) = getAll("parentID" -> parentID.getOrElse(-1))

  override def createAndGetID(entity: QuestionCategory): Int = createAndGetID(entity, "parentID" -> entity.parentID)

  def modify(id: Int, title: String, description: String) {
    modify("id" -> id, "title" -> title, "description" -> description)
  }

  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterSibling: Boolean) {
    execute("_move", "id" -> id, "moveAfter" -> moveAfterSibling, "siblingID" -> siblingID, "parentID" -> parentID)
  }

  def extract(row: Row) = new QuestionCategory(
    row.integer("id").get,
    row.string("title").get,
    row.string("description").get,
    row.integer("parentID")
  )
}