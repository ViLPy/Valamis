package com.arcusys.learn.questionbank.storage.impl.orbroker

import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.questionbank.storage._
import com.arcusys.learn.storage.impl.orbroker._
import impl.{QuestionCreator, QuestionFieldsMapper, QuestionEntityStorage}
import org.orbroker.{RowExtractor, Row}

class QuestionStorageImpl extends KeyedEntityStorageBaseImpl[Question[Answer]]("Question", "id") with QuestionEntityStorage with QuestionExtractor with QuestionCreator {
  val answerStorage = new AnswerStorageImpl

/*
Implementation moved to QuestionEntityStorage
  override def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterTarget: Boolean) {
    execute("_move", "id" -> id, "moveAfter" -> moveAfterTarget, "siblingID" -> siblingID, "parentID" -> parentID)
  }
*/
}

trait QuestionExtractor extends RowExtractor[Question[Answer]] {
  def extract(row: Row) = {
    val questionType = row.integer("questionType").getOrElse(
      throw new Exception("Oops! Can't recognize question type of " + row.integer("id").getOrElse(-1))
    )

    val mapper = new QuestionFieldsMapper {
      def questionID = row.integer("id").get

      def categoryId: Option[Int] = row.integer("categoryID")
      def title: String = row.string("title").get
      def description: String = row.string("description").get
      def explanationText: String = row.string("explanationText").get
      def forceCorrectCount: Boolean = row.bit("forceCorrectCount").get
      def courseID: Option[Int] = row.integer("courseID")
      def isCaseSensitive: Boolean = row.bit("isCaseSensitive").get
      def arrangementIndex: Int = row.integer("arrangementIndex").getOrElse(0)
    }

    createQuestion(questionType, mapper)
  }

  def createQuestion(questionType: Int, mapper: QuestionFieldsMapper): Question[Answer]
}
