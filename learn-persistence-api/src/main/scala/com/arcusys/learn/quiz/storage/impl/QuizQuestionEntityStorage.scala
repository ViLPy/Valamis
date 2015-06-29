package com.arcusys.learn.quiz.storage.impl

import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.valamis.questionbank.storage.QuestionStorage
import com.arcusys.valamis.quiz.model._
import com.arcusys.valamis.quiz.storage.QuizQuestionStorage

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait QuizQuestionFieldsMapper {
  def questionTypeName: String
  def id: Int
  def quizId: Int
  def categoryId: Option[Int]
  def title: Option[String]
  def url: String
  def text: String
  def questionId: Int
  def autoShowAnswer: Boolean
  def arrangementIndex: Int
  def groupId: Option[Int]
}

trait QuizQuestionCreator {
  def questionStorage: QuestionStorage

  def createQuizQuestion(mapper: QuizQuestionFieldsMapper): QuizQuestion = {
    import mapper._
    val questionType = QuizQuestionType.withName(questionTypeName)
    questionType match {
      case QuizQuestionType.External =>
        new ExternalQuizQuestion(id,
          quizId,
          categoryId,
          title,
          url,
          arrangementIndex)
      case QuizQuestionType.PlainText =>
        new PlainTextQuizQuestion(id,
          quizId,
          categoryId,
          title,
          text,
          arrangementIndex)
      case QuizQuestionType.QuestionBank =>
        new QuestionBankQuizQuestion(
          id,
          quizId,
          categoryId,
          title,
          questionStorage.getByID(questionId).getOrElse(
            throw new IllegalArgumentException("Can't get real question from DB")),
          autoShowAnswer,
          arrangementIndex
        )
      case QuizQuestionType.RevealJS =>
        new RevealJSQuizQuestion(
          id,
          quizId,
          categoryId,
          title,
          text,
          arrangementIndex
        )
      case QuizQuestionType.PDF =>
        new PDFQuizQuestion(
          id,
          quizId,
          categoryId,
          title,
          text,
          arrangementIndex
        )
      case QuizQuestionType.PPTX =>
        new PPTXQuizQuestion(
          id,
          quizId,
          categoryId,
          title,
          text,
          arrangementIndex
        )
      case QuizQuestionType.DLVideo =>
        new DLVideoQuizQuestion(
          id,
          quizId,
          categoryId,
          title,
          text,
          groupId,
          arrangementIndex
        )
      case _ => throw new IllegalArgumentException("Illegal quiz question type in quiz question extractor")
    }
  }
}

trait QuizQuestionEntityStorage extends QuizQuestionStorage with KeyedEntityStorageExt[QuizQuestion] with EntityStorageExt[QuizQuestion] {
  def getCount(quizID: Int): Int = getAll("quizID" -> quizID).size

  def getByCategory(quizID: Int, categoryID: Option[Int]) =
    getAll("quizID" -> quizID, "categoryID" -> categoryID.getOrElse(-1)).sortBy(_.arrangementIndex)

  def modifyExternal(id: Int, title: String, url: String) {
    modify("id" -> id, "title" -> title, "url" -> url)
  }

  def modifyRevealJS(id: Int, title: String) {
    modify("id" -> id, "title" -> title)
  }

  def modifyTitle(id: Int, title: String) {
    modify("id" -> id, "title" -> title)
  }

  def modify(id: Int, title: String, autoShowAnswer: Boolean) {
    modify("id" -> id, "title" -> title, "autoShowAnswer" -> autoShowAnswer)
  }

  def createFromQuestionBankAndGetID(quizID: Int, categoryID: Option[Int], questionID: Int): Int =
    createAndGetID("quizID" -> quizID,
      "categoryID" -> categoryID,
      "questionID" -> questionID,
      "questionType" -> QuizQuestionType.QuestionBank.toString,
      "arrangementIndex" -> (maxArrangementIndex(getByCategory(quizID, categoryID)) + 1))

  def createExternalAndGetID(quizID: Int, categoryID: Option[Int], title: String, url: String): Int =
    createAndGetID("quizID" -> quizID,
      "categoryID" -> categoryID,
      "title" -> title,
      "url" -> url,
      "questionType" -> QuizQuestionType.External.toString,
      "arrangementIndex" -> (maxArrangementIndex(getByCategory(quizID, categoryID)) + 1))

  def createRevealAndGetID(quizID: Int, categoryID: Option[Int], title: String, content: String): Int =
    createAndGetID("quizID" -> quizID,
      "categoryID" -> categoryID,
      "title" -> title,
      "text" -> content,
      "questionType" -> QuizQuestionType.RevealJS.toString,
      "arrangementIndex" -> (maxArrangementIndex(getByCategory(quizID, categoryID)) + 1))

  def createPDFAndGetID(quizID: Int, categoryID: Option[Int], title: String, filename: String): Int =
    createAndGetID("quizID" -> quizID,
      "categoryID" -> categoryID,
      "title" -> title,
      "text" -> filename,
      "questionType" -> QuizQuestionType.PDF.toString,
      "arrangementIndex" -> (maxArrangementIndex(getByCategory(quizID, categoryID)) + 1))

  def createPPTXAndGetID(quizID: Int, categoryID: Option[Int], title: String, content: String): Int =
    createAndGetID("quizID" -> quizID,
      "categoryID" -> categoryID,
      "title" -> title,
      "text" -> content,
      "questionType" -> QuizQuestionType.PPTX.toString,
      "arrangementIndex" -> (maxArrangementIndex(getByCategory(quizID, categoryID)) + 1))

  def createPlainAndGetID(quizID: Int, categoryID: Option[Int], title: String, text: String): Int =
    createAndGetID("quizID" -> quizID,
      "categoryID" -> categoryID,
      "title" -> title,
      "text" -> text,
      "questionType" -> QuizQuestionType.PlainText.toString,
      "arrangementIndex" -> (maxArrangementIndex(getByCategory(quizID, categoryID)) + 1))

  def createDLAndGetID(quizID: Int, categoryID: Option[Int], title: String, uuid: String, groupId: Int): Int =
    createAndGetID("quizID" -> quizID,
      "categoryID" -> categoryID,
      "title" -> title,
      "text" -> uuid,
      "groupId" -> groupId,
      "questionType" -> QuizQuestionType.DLVideo.toString,
      "arrangementIndex" -> (maxArrangementIndex(getByCategory(quizID, categoryID)) + 1))

  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterTarget: Boolean): QuizQuestion = {
    val questionForUpdate = getByID(id).get
    val oldChildren: Seq[QuizQuestion] = getByCategory(questionForUpdate.quizID, parentID)

    def doMove(forUpdate: Seq[QuizQuestion], forIndex: Seq[QuizQuestion]) {
      forUpdate.foreach {
        question =>
          modify("id" -> question.id, "arrangementIndex" -> (question.arrangementIndex + 1))
      }
      modify("id" -> questionForUpdate.id, "arrangementIndex" -> (maxArrangementIndex(forIndex) + 1), "categoryID" -> parentID)
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
          val forUpdate = if (spannedChildren._2.isEmpty) Nil else spannedChildren._2.tail
          doMove(forUpdate, forIndex)
        }
      }
    }
    getByID(id).getOrElse(throw new Exception("Some errors occured while move"))
  }

  def updateParent(id: Int, parentID: Option[Int]) {
    getByID(id).foreach(e => modify(e, "parentID" -> parentID))
  }

  private def maxArrangementIndex(oldChildren: Seq[QuizQuestion]): Int = {
    oldChildren.foldLeft(0)(_ max _.arrangementIndex)
  }
}

