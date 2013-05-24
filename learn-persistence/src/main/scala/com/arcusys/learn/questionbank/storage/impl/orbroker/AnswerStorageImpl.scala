package com.arcusys.learn.questionbank.storage.impl.orbroker

import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.{RowExtractor, Row}

import scala.math.BigDecimal
import com.arcusys.learn.questionbank.storage.impl.{AnswerCreator, AnswerFieldsMapper, AnswerEntityStorage}

class AnswerStorageImpl extends KeyedEntityStorageBaseImpl[Answer]("Answer", "id") with AnswerEntityStorage with AnswerExtractor with AnswerCreator

trait AnswerExtractor extends RowExtractor[Answer] {
  private def javaBigDecimalToScala(value: java.math.BigDecimal) = new BigDecimal(value)

  def createAnswer(answerType: Int, fieldMapper: AnswerFieldsMapper): Answer

  def extract(row: Row) = {
    val answerType = row.integer("answerType").getOrElse(
      throw new Exception("Oops! Can't recognize question type of " + row.integer("id").getOrElse(-1))
    )

    createAnswer(answerType, new AnswerFieldsMapper {
      def id: Int = row.integer("id").get
      def description: String = row.string("description").get
      def isCorrect: Boolean = row.bit("isCorrect").get
      def rangeFrom: BigDecimal = javaBigDecimalToScala(row.decimal("rangeFrom").get)
      def rangeTo: BigDecimal = javaBigDecimalToScala(row.decimal("rangeTo").get)
      def matchingText: Option[String] = row.string("matchingText")
    })
  }
}
