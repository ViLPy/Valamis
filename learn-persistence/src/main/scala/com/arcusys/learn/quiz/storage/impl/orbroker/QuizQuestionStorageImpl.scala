package com.arcusys.learn.quiz.storage.impl.orbroker

import com.arcusys.learn.quiz.model._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.questionbank.storage.impl.orbroker.QuestionStorageImpl
import com.arcusys.learn.questionbank.storage.QuestionStorage
import com.arcusys.learn.quiz.storage.impl.{QuizQuestionCreator, QuizQuestionFieldsMapper, QuizQuestionEntityStorage}

class QuizQuestionStorageImpl extends KeyedEntityStorageBaseImpl[QuizQuestion]("QuizQuestion", "id") with QuizQuestionEntityStorage
  with QuizQuestionExtractor with QuizQuestionCreator {
  val questionStorage: QuestionStorage = new QuestionStorageImpl
}

trait QuizQuestionExtractor extends RowExtractor[QuizQuestion] {
  def questionStorage: QuestionStorage

  def extract(row: Row) = {
    createQuizQuestion(new QuizQuestionFieldsMapper {
      def questionTypeName: String = row.string("questionType").get

      def id: Int = row.integer("id").get
      def quizId: Int = row.integer("quizID").get
      def categoryId: Option[Int] = row.integer("categoryID")
      def title: Option[String] = row.string("title")
      def url: String = row.string("url").get
      def text: String = row.string("plainText").get
      def questionId: Int = row.integer("questionID").get
      def arrangementIndex: Int = row.integer("arrangementIndex").get
    })
  }

  def createQuizQuestion(mapper: QuizQuestionFieldsMapper): QuizQuestion
}


