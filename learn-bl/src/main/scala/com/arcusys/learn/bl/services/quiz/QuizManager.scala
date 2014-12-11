package com.arcusys.learn.bl.services.quiz

import com.arcusys.learn.bl.services.{ QuizServiceContract, FileServiceContract }
import com.arcusys.learn.bl.models.RangeResult
import com.arcusys.learn.quiz.model._
import com.arcusys.learn.quiz.storage.QuizStorage

trait QuizManager extends QuizQuestionManager with QuizCategoryManager with QuizServiceContract {

  protected def quizStorage: QuizStorage

  protected def fileService: FileServiceContract

  def getQuiz(quizId: Int): Quiz = {
    quizStorage.getByID(quizId).getOrElse(throw new Exception("quiz not found, quizId: " + quizId))
  }

  def getQuizOption(quizId: Int): Option[Quiz] = {
    quizStorage.getByID(quizId)
  }

  def createQuiz(title: String, description: String, logo: String, courseId: Int, maxDuration: Option[Int]): Quiz = {
    val quizId = quizStorage.createAndGetID(Quiz(-1, title, description, "", "", Some(courseId), logo, maxDuration)) // TODO: store logo
    getQuiz(quizId)
  }

  def createQuiz(title: String, description: String, logo: String, courseId: Int, welcomePageContent: String, finalPageContent: String, maxDuration: Option[Int]): Quiz = {
    val quizInfo = Quiz(-1, title, description, welcomePageContent, finalPageContent, Some(courseId), logo, maxDuration)
    val quizId = quizStorage.createAndGetID(quizInfo) // TODO: store logo
    getQuiz(quizId)
  }

  def deleteQuiz(quizId: Int): Unit = {
    questionStorage.getByCategory(quizId, None).foreach(q => deleteQuestion(quizId, q.id))
    categoryStorage.getChildren(quizId, None).foreach(c => deleteCategory(quizId, c.id))
    quizTreeStorage.getByQuizID(quizId).foreach(e => quizTreeStorage.delete(e.id))
    quizStorage.delete(quizId)
  }

  def updateQuiz(quizId: Int, newTitle: String, newDescription: String, maxDuration: Option[Int]): Quiz = {
    val quiz = quizStorage.getByID(quizId).get
      .copy(title = newTitle, description = newDescription, maxDuration = maxDuration)

    quizStorage.modify(quiz)

    getQuiz(quizId)
  }
  def updateQuizLogo(quizId: Int, newLogo: String): Quiz = {
    val quiz = quizStorage.getByID(quizId).get.copy(logo = newLogo)
    quizStorage.modify(quiz)
    getQuiz(quizId)
  }

  def getQuizes(courseId: Int): Seq[Quiz] = {
    quizStorage.getByCourseID(Option(courseId))
  }

  def getQuizes(courseId: Int, titlePattern: Option[String], sortBy: String, sortAsc: Boolean, skip: Int, count: Int): RangeResult[Quiz] = {
    var quizzes = quizStorage.getByCourseID(Option(courseId))

    for (pattern <- titlePattern if pattern.nonEmpty) {
      quizzes = quizzes.filter(_.title.toLowerCase.contains(pattern.toLowerCase))
    }

    val totalCount = quizzes.length

    quizzes = sortBy match {
      case "TITLE"        => quizzes.sortBy(_.title.toLowerCase)
      case "CREATIONDATE" => quizzes.sortBy(_.id)
      case "DESCRIPTION"  => quizzes.sortBy(_.description.toLowerCase)
      case _              => quizzes.sortBy(_.title.toLowerCase)
    }

    if (!sortAsc) quizzes = quizzes.reverse

    new RangeResult(totalCount, quizzes drop skip take count)
  }

  def cloneQuiz(quizId: Int, namePostfix: String): Quiz = {
    val quiz = getQuiz(quizId)

    val newQuiz = createQuiz(quiz.title + namePostfix, quiz.description, quiz.logo, quiz.courseID.get, quiz.welcomePageContent, quiz.finalPageContent, quiz.maxDuration)

    if (quiz.logo.nonEmpty)
      fileService.copyFile("quiz_logo_" + quizId, quiz.logo, "quiz_logo_" + newQuiz.id, quiz.logo)

    def cloneQuestion(quizQuestion: QuizQuestion, categoryId: Option[Int]): Unit = {
      quizQuestion match {
        case q: RevealJSQuizQuestion =>
          createQuestionRevealJS(newQuiz.id, categoryId, q.title.getOrElse(""), q.content)
        case q: ExternalQuizQuestion =>
          createQuestionExternal(newQuiz.id, categoryId, q.title.getOrElse(""), q.url)
        case q: PlainTextQuizQuestion =>
          createQuestionPlainText(newQuiz.id, categoryId, q.title.getOrElse(""), q.text)
        case q: QuestionBankQuizQuestion =>
          createQuestionFromQuestionBank(newQuiz.id, categoryId, q.question.id)
        case q: DLVideoQuizQuestion =>
          createQuestionDocumentLibrary(newQuiz.id, categoryId, q.title.getOrElse(""), q.uuid, q.groupId.get)
        case q: PPTXQuizQuestion =>
          fileService.copyFile("quizData" + q.quizID.toString, q.file, "quizData" + newQuiz.id, q.file, false)
          createQuestionPPTX(newQuiz.id, categoryId, q.title.getOrElse(""), q.file)
        case q: PDFQuizQuestion =>
          fileService.copyFile("quizData" + q.quizID.toString, q.filename, "quizData" + newQuiz.id, q.filename, false)
          createQuestionPDF(newQuiz.id, categoryId, q.title.getOrElse(""), q.filename)
      }
    }

    def cloneCategory(oldCategory: QuizQuestionCategory): Unit = {
      val newCategory = createCategory(newQuiz.id, oldCategory.title, oldCategory.description)

      getQuestionsByCategory(quizId, Some(oldCategory.id)).foreach(cloneQuestion(_, Some(newCategory.id)))
    }

    getQuestionsByCategory(quizId, None).foreach(cloneQuestion(_, None))
    getCategories(quizId, None).foreach(cloneCategory)

    getQuiz(newQuiz.id)
  }

}
