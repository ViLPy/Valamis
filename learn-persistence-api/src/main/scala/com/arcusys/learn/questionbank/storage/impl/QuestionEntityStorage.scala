package com.arcusys.learn.questionbank.storage.impl

import com.arcusys.learn.questionbank.storage.{ QuestionAnswerStorage, QuestionStorage }
import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.learn.questionbank.model._

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait QuestionFieldsMapper {
  def questionID: Int

  def categoryId: Option[Int]

  def title: String

  def description: String

  def explanationText: String

  def forceCorrectCount: Boolean

  def courseID: Option[Int]

  def isCaseSensitive: Boolean

  def arrangementIndex: Int
}

trait QuestionCreator {
  def answerStorage: QuestionAnswerStorage

  def createQuestion(questionType: Int, mapper: QuestionFieldsMapper): Question[Answer] = {
    import mapper._
    questionType match {
      case 0 => new ChoiceQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[ChoiceAnswer]),
        forceCorrectCount,
        courseID,
        arrangementIndex)
      case 1 =>
        new TextQuestion(questionID,
          categoryId,
          title,
          description,
          explanationText,
          answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[TextAnswer]),
          isCaseSensitive,
          courseID,
          arrangementIndex)
      case 2 => new NumericQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[NumericAnswer]),
        courseID,
        arrangementIndex)
      case 3 => new PositioningQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[PositioningAnswer]),
        forceCorrectCount,
        courseID,
        arrangementIndex)
      case 4 => new MatchingQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[MatchingAnswer]),
        courseID,
        arrangementIndex)
      case 5 => new EssayQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        courseID,
        arrangementIndex)
      case 6 => new EmbeddedAnswerQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        courseID,
        arrangementIndex)
      case 7 => new CategorizationQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[CategorizationAnswer]),
        courseID,
        arrangementIndex)
      case 8 => new PlainText(questionID,
        categoryId,
        title,
        description,
        courseID,
        arrangementIndex)
      case 9 => new PurePlainText(questionID,
        categoryId,
        title,
        description,
        courseID,
        arrangementIndex)
      case _ => throw new Exception("Oops! Can't create question " + questionID)
    }
  }
}

@deprecated
trait QuestionEntityStorage extends QuestionStorage with KeyedEntityStorageExt[Question[Answer]] with EntityStorageExt[Question[Answer]] {
  def answerStorage: QuestionAnswerStorage

  override def renew() {
    doRenew()
    answerStorage.renew()
  }

  def getByCategory(categoryID: Option[Int], courseID: Option[Int]) = getAll("categoryID" -> categoryID.getOrElse(-1), "courseID" -> courseID.getOrElse(-1))

  override def createAndGetID(entity: Question[Answer]): Int = {
    val questionId =
      createAndGetID(entity,
        "categoryID" -> entity.categoryID,
        "forceCorrectCount" -> (entity match {
          case e: ChoiceQuestion      => Some(e.forceCorrectCount)
          case e: PositioningQuestion => Some(e.forceCorrectCount)
          case _                      => None
        }),
        "isCaseSensitive" -> (entity match {
          case e: TextQuestion => Some(e.isCaseSensitive)
          case _               => None
        }),
        "arrangementIndex" -> (maxArrangementIndex(getByCategory(entity.categoryID, entity.courseID)) + 1)
      )
    answerStorage.createForQuestion(questionId, entity.answers)
    questionId
  }

  override def modify(entity: Question[Answer]) {
    modify(entity,
      "categoryID" -> entity.categoryID,
      "forceCorrectCount" -> (entity match {
        case e: ChoiceQuestion      => Some(e.forceCorrectCount)
        case e: PositioningQuestion => Some(e.forceCorrectCount)
        case _                      => None
      }),
      "isCaseSensitive" -> (entity match {
        case e: TextQuestion => Some(e.isCaseSensitive)
        case _               => None
      })
    )
    answerStorage.deleteByQuestion(entity.id)
    answerStorage.createForQuestion(entity.id, entity.answers)
  }

  def move(id: Int, index: Int, parentID: Option[Int]) {
    val questionForUpdate = getByID(id).get
    val forUpdate: Seq[Question[Answer]] = getByCategory(parentID, questionForUpdate.courseID)

    forUpdate.foreach {
      question =>
        modify(question, "arrangementIndex" -> (
          question.arrangementIndex + (if (question.arrangementIndex >= index) 2 else 1)
        ))
    }

    modify(questionForUpdate, "arrangementIndex" -> index, "categoryID" -> parentID)
  }

  def maxArrangementIndex(oldChildren: Seq[Question[Answer]]): Int = {
    oldChildren.foldLeft(0)(_ max _.arrangementIndex)
  }
}
