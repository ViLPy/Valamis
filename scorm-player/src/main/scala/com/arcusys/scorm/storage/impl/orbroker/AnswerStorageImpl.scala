package com.arcusys.scorm.storage.impl.orbroker

import com.arcusys.scorm.model.quiz._
import com.arcusys.scorm.storage._
import org.orbroker.Row
import org.orbroker.RowExtractor

import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._
import org.orbroker.Token
import org.orbroker.conv._
import scala.math.BigDecimal

class AnswerStorageImpl extends AnswerStorage with GenericEntityStorageImpl[Answer]
{
  def tablePath = "Answer"
  def extractor = Extractor
  def idParam = "id"

  def getByQuestion(questionID: Int) = {
    broker.readOnly() { session => session.selectAll(Token(Symbol(tablePath), Extractor),
                                                     "questionID"->questionID) }
  }
  
  def create(questionID: Int, position: Int, entity: Answer): (Int,Answer) = {
    defParams.clear
    defParams += "questionID"->questionID
    defParams += "answerPosition"->position
    // match entity type and fill needed fields
    entity match {
      case e:ChoiceAnswer => {
          defParams += "description"->e.text
          defParams += "isCorrect"->e.isCorrect
          defParams += "answerType"->0
        }
      case e:ShortAnswer => {
          defParams += "description"->e.text
          defParams += "answerType"->1
        }
      case e:NumericAnswer => {
          defParams += "rangeFrom"->e.range._1.bigDecimal
          defParams += "rangeTo"->e.range._2.bigDecimal
          defParams += "answerType"->2
        }
      case e:PositioningAnswer => {
          defParams += "description"->e.text
          defParams += "isCorrect"->e.isCorrect
          defParams += "answerType"->3
        }
      case e:MatchingAnswer => {
          defParams += "description"->e.text
          defParams += "subquestionText"->e.subquestionText
          defParams += "answerType"->4
        }
      case e:EssayAnswer => defParams += "answerType"->5
      case e:EmbeddedAnswer => defParams += "answerType"->6
    }
    create(entity)
  }
  
  object Extractor extends RowExtractor[Answer]
  {
    def javaBigDecimalToScala(value: java.math.BigDecimal) = {
      new BigDecimal(value)
    }
    
    def extract(row: Row) = {
      val questionType = row.integer("answerType").getOrElse(
        throw new Exception("Oops! Can't recognize question type of " + row.integer("id").getOrElse(-1))
      )
      questionType match {
        case 0 => ChoiceAnswer(row.integer("id").get,
                               row.string("description").get,
                               row.bit("isCorrect").get)
        case 1 => ShortAnswer(row.integer("id").get,
                              row.string("description").get)
        case 2 => NumericAnswer(row.integer("id").get,
                                (javaBigDecimalToScala(row.decimal("rangeFrom").get),javaBigDecimalToScala(row.decimal("rangeTo").get)))
        case 3 => PositioningAnswer(row.integer("id").get,
                                    row.string("description").get,
                                    row.bit("isCorrect").get)
        case 4 => MatchingAnswer(row.integer("id").get,
                                 row.string("description").get,
                                 row.string("subquestionText"))
        case 5 => EssayAnswer(row.integer("id").get)
        case 6 => EmbeddedAnswer(row.integer("id").get)
        case _ => throw new Exception("Oops! Can't create answer " + row.integer("id").getOrElse(-1))
      }
    }
  }
}
