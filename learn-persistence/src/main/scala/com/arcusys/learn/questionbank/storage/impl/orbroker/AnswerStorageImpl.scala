package com.arcusys.learn.questionbank.storage.impl.orbroker

import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.Row

import scala.math.BigDecimal

class AnswerStorageImpl extends KeyedEntityStorageImpl[Answer]("Answer", "id") {
  def getByQuestion(questionID: Int) = getAll("questionID" -> questionID)

  def deleteByQuestion(questionID: Int) {
    execute("_delete", "questionID" -> questionID)
  }

  def createForQuestion(questionID: Int, answers: Seq[Answer]) {
    var position = 0
    for (answer <- answers) {
      position += 1
      createAndGetID(answer,
        "questionID" -> questionID,
        "answerPosition" -> position,
        "answerType" -> (answer match {
          case e: ChoiceAnswer => 0
          case e: TextAnswer => 1
          case e: NumericAnswer => 2
          case e: PositioningAnswer => 3
          case e: MatchingAnswer => 4
          case e: CategorizationAnswer => 7
        }),
        "description" -> (answer match {
          case e: ChoiceAnswer => Some(e.text)
          case e: TextAnswer => Some(e.text)
          case e: PositioningAnswer => Some(e.text)
          case e: MatchingAnswer => Some(e.text)
          case e: CategorizationAnswer => Some(e.text)
          case _ => None
        }),
        "isCorrect" -> (answer match {
          case e: ChoiceAnswer => Some(e.isCorrect)
          case e: PositioningAnswer => Some(e.isCorrect)
          case _ => None
        }),
        "rangeFrom" -> (answer match {
          case e: NumericAnswer => Some(e.notLessThan.bigDecimal)
          case _ => None
        }),
        "rangeTo" -> (answer match {
          case e: NumericAnswer => Some(e.notGreaterThan.bigDecimal)
          case _ => None
        }),
        "matchingText" -> (answer match {
          case e: MatchingAnswer => Some(e.keyText)
          case e: CategorizationAnswer => Some(e.answerCategoryText)
          case _ => None
        })
      )
    }
  }

  private def javaBigDecimalToScala(value: java.math.BigDecimal) = new BigDecimal(value)

  def extract(row: Row) = {
    val questionType = row.integer("answerType").getOrElse(
      throw new Exception("Oops! Can't recognize question type of " + row.integer("id").getOrElse(-1))
    )
    questionType match {
      case 0 => new ChoiceAnswer(row.integer("id").get,
        row.string("description").get,
        row.bit("isCorrect").get)
      case 1 => new TextAnswer(row.integer("id").get,
        row.string("description").get)
      case 2 => new NumericAnswer(row.integer("id").get, javaBigDecimalToScala(row.decimal("rangeFrom").get), javaBigDecimalToScala(row.decimal("rangeTo").get))
      case 3 => new PositioningAnswer(row.integer("id").get,
        row.string("description").get,
        row.bit("isCorrect").get)
      case 4 => new MatchingAnswer(row.integer("id").get,
        row.string("description").get,
        row.string("matchingText"))
      case 7 => new CategorizationAnswer(row.integer("id").get,
        row.string("description").get,
        row.string("matchingText"))
      case _ => throw new Exception("Oops! Can't create answer " + row.integer("id").getOrElse(-1))
    }
  }

}
