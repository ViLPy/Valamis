package com.arcusys.learn.quiz.storage.impl.orbroker

import com.arcusys.learn.quiz.model._
import com.arcusys.learn.quiz.storage._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.Row

class QuizStorageImpl extends KeyedEntityStorageImpl[Quiz]("Quiz", "id") with QuizStorage {

  def getByCourseID(courseID: Option[Int]) =
    getAll("courseID" -> courseID.getOrElse(-1))

  def extract(row: Row) = new Quiz(
    row.integer("id").get,
    row.string("title").get,
    row.string("description").get,
    row.string("welcomePageContent").get,
    row.string("finalPageContent").get,
    row.integer("courseID")
  )
}
