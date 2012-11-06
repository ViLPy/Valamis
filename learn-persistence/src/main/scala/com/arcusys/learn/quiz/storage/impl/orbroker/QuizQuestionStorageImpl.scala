package com.arcusys.learn.quiz.storage.impl.orbroker

import com.arcusys.learn.quiz.model._
import com.arcusys.learn.quiz.storage._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.Row
import com.arcusys.learn.questionbank.storage.impl.orbroker.QuestionStorageImpl

class QuizQuestionStorageImpl extends KeyedEntityStorageImpl[QuizQuestion]("QuizQuestion", "id") with QuizQuestionStorage {
  val questionStorage = new QuestionStorageImpl

  def getCount(quizID: Int): Int = getAll("quizID" -> quizID).size

  def getByCategory(quizID: Int, categoryID: Option[Int]) = getAll("quizID" -> quizID, "categoryID" -> categoryID.getOrElse(-1))

  def modifyExternal(id: Int, title:String, url: String) {
    modify("id" -> id, "title" -> title, "url" -> url)
  }

  override def createAndGetID(quizID: Int, categoryID: Option[Int], questionID: Int): Int =
    createAndGetID("quizID" -> quizID, "categoryID" -> categoryID, "questionID" -> questionID)

  override def createAndGetID(quizID: Int, categoryID: Option[Int], title:String, url: String): Int =
    createAndGetID("quizID" -> quizID, "categoryID" -> categoryID, "title"->title, "url" -> url)

  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterSibling: Boolean) = {
    execute("_move", "id" -> id, "moveAfter" -> moveAfterSibling, "siblingID" -> siblingID, "parentID" -> parentID)
    getByID(id).getOrElse(throw new Exception("Some errors occured while move"))
  }

  def extract(row: Row) = new QuizQuestion(
    row.integer("id").get,
    row.integer("quizID").get,
    row.integer("categoryID"),
    if (row.integer("questionID").isDefined) questionStorage.getByID(row.integer("questionID").get) else None,
    row.string("title"),
    row.string("url")
  )

}
