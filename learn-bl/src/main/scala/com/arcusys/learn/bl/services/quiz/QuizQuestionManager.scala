package com.arcusys.learn.bl.services.quiz

import com.arcusys.learn.bl.services.QuizServiceContract
import com.arcusys.learn.quiz.model.{ QuizQuestion, QuizTreeElement }
import com.arcusys.learn.quiz.storage.{ QuizQuestionStorage, QuizTreeStorage }

trait QuizQuestionManager extends QuizServiceContract {

  protected def questionStorage: QuizQuestionStorage

  protected def quizTreeStorage: QuizTreeStorage

  def getQuestionOption(questionId: Int): Option[QuizQuestion] = {
    questionStorage.getByID(questionId)
  }

  def getQuestion(questionId: Int): QuizQuestion = {
    questionStorage.getByID(questionId).getOrElse(throw new Exception("quiz question not found, questionId: " + questionId))
  }

  def getQuestionsByCategory(quizId: Int, categoryId: Option[Int]): Seq[QuizQuestion] = {
    questionStorage.getByCategory(quizId, categoryId)
  }

  def getQuestionsCount(quizId: Int): Int = {
    questionStorage.getCount(quizId)
  }

  def createQuestionRevealJS(quizId: Int, categoryId: Option[Int], title: String, text: String): QuizQuestion = {
    val questionId = questionStorage.createRevealAndGetID(quizId, categoryId, title, text)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizId, "q_" + questionId, false, categoryId.map("c_" + _)))
    getQuestion(questionId)
  }

  def createQuestionPDF(quizId: Int, categoryId: Option[Int], title: String, filename: String): QuizQuestion = {
    val questionId = questionStorage.createPDFAndGetID(quizId, categoryId, title, filename)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizId, "q_" + questionId, false, categoryId.map("c_" + _)))

    getQuestion(questionId)
  }

  def createQuestionPPTX(quizId: Int, categoryId: Option[Int], title: String, fileName: String): QuizQuestion = {
    val questionId = questionStorage.createPPTXAndGetID(quizId, categoryId, title, fileName)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizId, "q_" + questionId, false, categoryId.map("c_" + _)))

    getQuestion(questionId)
  }

  def createQuestionPlainText(quizId: Int, categoryId: Option[Int], title: String, text: String): QuizQuestion = {
    val questionId = questionStorage.createPlainAndGetID(quizId, categoryId, title, text)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizId, "q_" + questionId, false, categoryId.map("c_" + _)))
    getQuestion(questionId)
  }

  def createQuestionDocumentLibrary(quizId: Int, categoryId: Option[Int], title: String, uuid: String, groupId: Int): QuizQuestion = {
    val questionId = questionStorage.createDLAndGetID(quizId, categoryId, title, uuid, groupId)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizId, "q_" + questionId, false, categoryId.map("c_" + _)))
    getQuestion(questionId)
  }

  def createQuestionExternal(quizId: Int, categoryId: Option[Int], title: String, url: String): QuizQuestion = {
    val iframeURL = if (url.startsWith("//")) "http:" + url else url
    val questionId = questionStorage.createExternalAndGetID(quizId, categoryId, title, iframeURL)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizId, "q_" + questionId, false, categoryId.map("c_" + _)))
    getQuestion(questionId)
  }

  def createQuestionFromQuestionBank(quizId: Int, categoryId: Option[Int], bankQuestionId: Int): QuizQuestion = {
    val questionId = questionStorage.createFromQuestionBankAndGetID(quizId, categoryId, bankQuestionId)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizId, "q_" + questionId, false, categoryId.map("c_" + _)))
    getQuestion(questionId)
  }

  def updateQuestionPlainText(questionId: Int, title: String): Unit = {
    questionStorage.modify(questionId, title, autoShowAnswer = false)
  }

  def updateQuestionRevealJS(questionId: Int, title: String): Unit = {
    questionStorage.modifyRevealJS(questionId, title)
  }

  def updateQuestionPDF(questionId: Int, title: String): Unit = {
    questionStorage.modify(questionId, title, false)
  }

  def updateQuestionPPTX(questionId: Int, title: String): Unit = {
    questionStorage.modifyTitle(questionId, title)
  }

  def updateQuestionExternal(questionId: Int, title: String, url: String): Unit = {
    questionStorage.modifyExternal(questionId, title, url)
  }

  def updateQuestionFromQuestionBank(questionId: Int, title: String, autoShowAnswer: Boolean): Unit = {
    questionStorage.modify(questionId, title, autoShowAnswer)
  }

  def deleteQuestion(quizId: Int, questionId: Int): Unit = {
    quizTreeStorage.getByQuizAndElementID(quizId, "q_" + questionId).map(e => quizTreeStorage.delete(e.id))
    questionStorage.delete(questionId)
  }

  def getQuestionIndex(quizId: Int, questionId: Int): Int = {
    val quizTreeElement = quizTreeStorage.getByQuizAndElementID(quizId, "q_" + questionId)
    quizTreeElement.map(_.arrangementIndex).getOrElse(1)
  }

  def moveQuestion(quizId: Int, questionId: Int, parentId: Option[Int], index: Int) = {
    for (parentIdValue <- parentId)
      if (quizTreeStorage.getByQuizAndElementID(quizId, "c_" + parentIdValue).isEmpty)
        throw new Exception("can`t move quiz question, not parent " + parentIdValue)

    for (quizTree <- quizTreeStorage.getByQuizAndElementID(quizId, "q_" + questionId)) {
      questionStorage.updateParent(questionId, parentId)
      quizTreeStorage.move(quizTree.copy(parentID = parentId.map("c_" + _), arrangementIndex = index), quizTree.arrangementIndex)
    }
  }
}
