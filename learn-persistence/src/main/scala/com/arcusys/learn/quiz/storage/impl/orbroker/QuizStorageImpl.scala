package com.arcusys.learn.quiz.storage.impl.orbroker

import com.arcusys.learn.quiz.model._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.quiz.storage.impl.QuizEntityStorage

class QuizStorageImpl extends KeyedEntityStorageBaseImpl[Quiz]("Quiz", "id") with QuizEntityStorage with QuizExtractor

trait QuizExtractor extends RowExtractor[Quiz] {
  def extract(row: Row) = new Quiz(
    row.integer("id").get,
    row.string("title").get,
    row.string("description").get,
    row.string("welcomePageContent").get,
    row.string("finalPageContent").get,
    row.integer("courseID")
  )
}
