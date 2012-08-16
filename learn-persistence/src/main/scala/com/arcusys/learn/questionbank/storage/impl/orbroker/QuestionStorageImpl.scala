package com.arcusys.learn.questionbank.storage.impl.orbroker

import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.questionbank.storage._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.Row

class QuestionStorageImpl extends KeyedEntityStorageImpl[Question[Answer]]("Question", "id") with QuestionStorage {
  val answerStorage = new AnswerStorageImpl

  def getByCategory(categoryID: Option[Int]) = getAll("categoryID" -> categoryID.getOrElse(-1))

  override def createAndGetID(entity: Question[Answer]): Int = {
    val questionId =
      createAndGetID(entity,
        "categoryID" -> entity.categoryID,
        "forceCorrectCount" -> (entity match {
          case e: ChoiceQuestion => Some(e.forceCorrectCount)
          case e: PositioningQuestion => Some(e.forceCorrectCount)
          case _ => None
        }),
        "isCaseSensitive" -> (entity match {
          case e: TextQuestion => Some(e.isCaseSensitive)
          case _ => None
        })
      )
    answerStorage.createForQuestion(questionId, entity.answers)
    questionId
  }

  override def modify(entity: Question[Answer]) {
    modify(entity,
      "forceCorrectCount" -> (entity match {
        case e: ChoiceQuestion => Some(e.forceCorrectCount)
        case e: PositioningQuestion => Some(e.forceCorrectCount)
        case _ => None
      }),
      "isCaseSensitive" -> (entity match {
        case e: TextQuestion => Some(e.isCaseSensitive)
        case _ => None
      })
    )
    answerStorage.deleteByQuestion(entity.id)
    answerStorage.createForQuestion(entity.id, entity.answers)
  }

  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterTarget: Boolean) {
    execute("_move", "id" -> id, "moveAfter" -> moveAfterTarget, "siblingID" -> siblingID, "parentID" -> parentID)
  }

  override def renew() {
    super.renew()
    answerStorage.renew()
  }

  def extract(row: Row) = {
    val questionType = row.integer("questionType").getOrElse(
      throw new Exception("Oops! Can't recognize question type of " + row.integer("id").getOrElse(-1))
    )

    val questionID = row.integer("id").get

    questionType match {
      case 0 => new ChoiceQuestion(questionID,
        row.integer("categoryID"),
        row.string("title").get,
        row.string("description").get,
        row.string("explanationText").get,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[ChoiceAnswer]),
        row.bit("forceCorrectCount").get)
      case 1 => new TextQuestion(questionID,
        row.integer("categoryID"),
        row.string("title").get,
        row.string("description").get,
        row.string("explanationText").get,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[TextAnswer]),
        row.bit("isCaseSensitive").get)
      case 2 => new NumericQuestion(questionID,
        row.integer("categoryID"),
        row.string("title").get,
        row.string("description").get,
        row.string("explanationText").get,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[NumericAnswer]))
      case 3 => new PositioningQuestion(questionID,
        row.integer("categoryID"),
        row.string("title").get,
        row.string("description").get,
        row.string("explanationText").get,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[PositioningAnswer]),
        row.bit("forceCorrectCount").get)
      case 4 => new MatchingQuestion(questionID,
        row.integer("categoryID"),
        row.string("title").get,
        row.string("description").get,
        row.string("explanationText").get,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[MatchingAnswer]))
      case 5 => new EssayQuestion(questionID,
        row.integer("categoryID"),
        row.string("title").get,
        row.string("description").get,
        row.string("explanationText").get)
      case 6 => new EmbeddedAnswerQuestion(questionID,
        row.integer("categoryID"),
        row.string("title").get,
        row.string("description").get,
        row.string("explanationText").get)
      case 7 => new CategorizationQuestion(questionID,
        row.integer("categoryID"),
        row.string("title").get,
        row.string("description").get,
        row.string("explanationText").get,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[CategorizationAnswer]))
      case _ => throw new Exception("Oops! Can't create question " + row.integer("id").getOrElse(-1))
    }
  }

}
