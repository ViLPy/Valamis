package com.arcusys.scorm.storage.impl.orbroker

import com.arcusys.scorm.model.quiz._
import com.arcusys.scorm.storage._
import org.orbroker.Row
import org.orbroker.RowExtractor

import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._
import org.orbroker.Token
import org.orbroker.conv._
import com.arcusys.scorm.util.QuestionSerializer

class QuestionStorageImpl extends QuestionStorage with GenericEntityStorageImpl[Question[Answer]]
{
  val answerStorage = new AnswerStorageImpl
  def tablePath = "Question"
  def extractor = Extractor
  def idParam = "id"
  
  def getByCategory(categoryID: Option[Int]) = {
    broker.readOnly() { session => session.selectAll(Token(Symbol(tablePath), Extractor),
                                                     "categoryID"->categoryID.getOrElse(-1)) }
  }
  
  def createQuestion(entity: Question[Answer]): (Int,Question[Answer]) = {
    defParams.clear
    defParams += "questionType"->QuestionSerializer.getTypeIDByEntity(entity)
    // match entity type and fill needed fields
    entity match {
      case e:ChoiceQuestion => {
          defParams += "isBounded"->e.isBounded
        }
      case e:ShortAnswerQuestion => {
          defParams += "isCaseSensitive"->e.isCaseSensitive
        }
      case e:PositioningQuestion => {
          defParams += "isBounded"->e.isBounded
        }
      case _ => {/*do nothing*/}
    }
    
    create(entity)
  }
  
  def modifyQuestion(entity: Question[Answer]): (Int,Question[Answer]) = {
    defParams.clear
    // match entity type and fill needed fields
    defParams += "questionType"->QuestionSerializer.getTypeIDByEntity(entity)
    entity match {
      case e:ChoiceQuestion => {
          defParams += "isBounded"->e.isBounded
        }
      case e:ShortAnswerQuestion => {
          defParams += "isCaseSensitive"->e.isCaseSensitive
        }
      case e:PositioningQuestion => {
          defParams += "isBounded"->e.isBounded
        }
      case _ => {/*do nothing*/}
    }
    modify(entity)
  }
  
  object Extractor extends RowExtractor[Question[Answer]]
  {
    def extract(row: Row) = {
      val questionType = row.integer("questionType").getOrElse(
        throw new Exception("Oops! Can't recognize question type of " + row.integer("id").getOrElse(-1))
      )
      
      val questionID = row.integer("id").get
      
      questionType match {
        case 0 => ChoiceQuestion(questionID,
                                 row.integer("categoryID"),
                                 row.string("title").get,
                                 row.string("description").get,
                                 answerStorage.getByQuestion(questionID).map(e=>e.asInstanceOf[ChoiceAnswer]),
                                 row.bit("isBounded").get)
        case 1 => ShortAnswerQuestion(questionID,
                                      row.integer("categoryID"),
                                      row.string("title").get,
                                      row.string("description").get,
                                      answerStorage.getByQuestion(questionID).map(e=>e.asInstanceOf[ShortAnswer]),
                                      row.bit("isCaseSensitive").get)
        case 2 => NumericQuestion(questionID,
                                  row.integer("categoryID"),
                                  row.string("title").get,
                                  row.string("description").get,
                                  answerStorage.getByQuestion(questionID).map(e=>e.asInstanceOf[NumericAnswer]))
        case 3 => PositioningQuestion(questionID,
                                      row.integer("categoryID"),
                                      row.string("title").get,
                                      row.string("description").get,
                                      answerStorage.getByQuestion(questionID).map(e=>e.asInstanceOf[PositioningAnswer]),
                                      row.bit("isBounded").get)
        case 4 => MatchingQuestion(questionID,
                                   row.integer("categoryID"),
                                   row.string("title").get,
                                   row.string("description").get,
                                   answerStorage.getByQuestion(questionID).map(e=>e.asInstanceOf[MatchingAnswer]))
        case 5 => EssayQuestion(questionID,
                                row.integer("categoryID"),
                                row.string("title").get,
                                row.string("description").get,
                                answerStorage.getByQuestion(questionID).map(e=>e.asInstanceOf[EssayAnswer]))
        case 6 => EmbeddedAnswerQuestion(questionID,
                                         row.integer("categoryID"),
                                         row.string("title").get,
                                         row.string("description").get,
                                         answerStorage.getByQuestion(questionID).map(e=>e.asInstanceOf[EmbeddedAnswer]))
        case _ => throw new Exception("Oops! Can't create question " + row.integer("id").getOrElse(-1))
      }
    }
  }
}
