package com.arcusys.learn.questionbank.storage.impl

import com.arcusys.learn.questionbank.model._

import com.arcusys.learn.questionbank.storage.AnswerStorage
import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import math.BigDecimal

/**
 * User: dkudinov
 * Date: 19.3.2013
 */
trait AnswerFieldsMapper {
  def id: Int
  def description: String
  def isCorrect: Boolean
  def rangeFrom: BigDecimal
  def rangeTo: BigDecimal
  def matchingText: Option[String]
}

trait AnswerCreator {
  def createAnswer(answerType: Int, mapper: AnswerFieldsMapper): Answer = {
    import mapper._
    answerType match {
      case 0 => ChoiceAnswer(id,
        description,
        isCorrect)
      case 1 => TextAnswer(id,
        description)
      case 2 => NumericAnswer(id, rangeFrom, rangeTo)
      case 3 => PositioningAnswer(id,
        description,
        isCorrect)
      case 4 => MatchingAnswer(id,
        description,
        matchingText)
      case 7 => CategorizationAnswer(id,
        description,
        matchingText)
      case _ => throw new Exception("Oops! Can't create answer " + id)
    }
  }
}

trait AnswerEntityStorage extends AnswerStorage with KeyedEntityStorageExt[Answer] with EntityStorageExt[Answer] {
  def getByQuestion(questionID: Int) = getAll("questionID" -> questionID)

  def deleteByQuestion(questionID: Int) {
    delete("questionID" -> questionID)
  }

  def createForQuestion(questionID: Int, answers: Seq[Answer]) {
    var position = 0
    for (answer <- answers) {
      position += 1
      createAndGetID(answer,
        "questionID" -> questionID,
        "answerPosition" -> position,
        "answerType" -> (answer match {
          case e: ChoiceAnswer         => 0
          case e: TextAnswer           => 1
          case e: NumericAnswer        => 2
          case e: PositioningAnswer    => 3
          case e: MatchingAnswer       => 4
          case e: CategorizationAnswer => 7
        }),
        "description" -> (answer match {
          case e: ChoiceAnswer         => Some(e.text)
          case e: TextAnswer           => Some(e.text)
          case e: PositioningAnswer    => Some(e.text)
          case e: MatchingAnswer       => Some(e.text)
          case e: CategorizationAnswer => Some(e.text)
          case _                       => None
        }),
        "isCorrect" -> (answer match {
          case e: ChoiceAnswer      => Some(e.isCorrect)
          case e: PositioningAnswer => Some(e.isCorrect)
          case _                    => None
        }),
        "rangeFrom" -> (answer match {
          case e: NumericAnswer => Some(e.notLessThan.bigDecimal)
          case _                => None
        }),
        "rangeTo" -> (answer match {
          case e: NumericAnswer => Some(e.notGreaterThan.bigDecimal)
          case _                => None
        }),
        "matchingText" -> (answer match {
          case e: MatchingAnswer       => Some(e.keyText)
          case e: CategorizationAnswer => Some(e.answerCategoryText)
          case _                       => None
        })
      )
    }
  }
}

