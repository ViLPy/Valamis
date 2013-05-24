package com.arcusys.learn.questionbank.storage.impl

import com.arcusys.learn.questionbank.storage.{AnswerStorage, QuestionStorage}
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
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
  def answerStorage: AnswerStorage

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
      case _ => throw new Exception("Oops! Can't create question " + questionID)
    }
  }
}

trait QuestionEntityStorage extends QuestionStorage with KeyedEntityStorageExt[Question[Answer]] with EntityStorageExt[Question[Answer]] {
  def answerStorage: AnswerStorage

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
          case e: ChoiceQuestion => Some(e.forceCorrectCount)
          case e: PositioningQuestion => Some(e.forceCorrectCount)
          case _ => None
        }),
        "isCaseSensitive" -> (entity match {
          case e: TextQuestion => Some(e.isCaseSensitive)
          case _ => None
        })
        ,
        "arrangementIndex" -> (maxArrangementIndex(getByCategory(entity.categoryID, entity.courseID)) + 1)
      )
    answerStorage.createForQuestion(questionId, entity.answers)
    questionId
  }

  override def modify(entity: Question[Answer]) {
    modify(entity,
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
    answerStorage.deleteByQuestion(entity.id)
    answerStorage.createForQuestion(entity.id, entity.answers)
  }

  def move(id: Int, parentID:Option[Int], siblingID: Option[Int], moveAfterTarget: Boolean) {
    val questionForUpdate = getByID(id).get
    val oldChildren: Seq[Question[Answer]] = getByCategory(parentID, questionForUpdate.courseID)

    def doMove(forUpdate: Seq[Question[Answer]], forIndex: Seq[Question[Answer]]) {
      forUpdate.foreach {
        question =>
          modify(question, "arrangementIndex" -> (question.arrangementIndex + 1))
      }
      modify(questionForUpdate, "arrangementIndex" -> (maxArrangementIndex(forIndex) + 1), "categoryID" -> parentID)
    }

    siblingID match {
      case None =>
        if (!moveAfterTarget) {
          doMove(oldChildren, Seq())
        } else {
          doMove(Seq(), oldChildren)
        }
      case Some(a: Int) => {
        val spannedChildren = oldChildren.span(_.id != siblingID.get)
        if (!moveAfterTarget) {
          val forIndex = spannedChildren._1
          val forUpdate = spannedChildren._2
          doMove(forUpdate, forIndex)
        } else {
          val forIndex = spannedChildren._1 ++ spannedChildren._2.headOption
          val forUpdate = if (spannedChildren._2.isEmpty)  Nil else spannedChildren._2.tail
          doMove(forUpdate, forIndex)
        }
      }
    }
  }

  def maxArrangementIndex(oldChildren: Seq[Question[Answer]]): Int = {
    oldChildren.foldLeft(0)(_ max _.arrangementIndex)
  }
}
