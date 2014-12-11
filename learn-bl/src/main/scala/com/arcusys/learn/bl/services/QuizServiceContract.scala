package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.models.RangeResult
import com.arcusys.learn.quiz.model.{ QuizQuestion, QuizQuestionCategory, Quiz }

/**
 * Created by mminin on 13.10.14.
 */
trait QuizServiceContract {

  def getQuiz(quizId: Int): Quiz

  def getQuizOption(quizId: Int): Option[Quiz]

  def createQuiz(title: String, description: String, logo: String, courseId: Int, maxDuration: Option[Int]): Quiz

  def createQuiz(title: String, description: String, logo: String, courseId: Int, welcomePageContent: String, finalPageContent: String, maxDuration: Option[Int]): Quiz

  def deleteQuiz(quizId: Int): Unit

  def updateQuiz(quizId: Int, newTitle: String, newDescription: String, maxDuration: Option[Int]): Quiz
  def updateQuizLogo(quizId: Int, newLogo: String): Quiz

  def getQuizes(courseId: Int): Seq[Quiz]

  def getQuizes(courseId: Int, titlePattern: Option[String], sortBy: String, sortAsc: Boolean, skip: Int, count: Int): RangeResult[Quiz]

  def getCategory(categoryId: Int): QuizQuestionCategory

  def createCategory(quizId: Int, title: String, description: String): QuizQuestionCategory

  def deleteCategory(quizId: Int, categoryId: Int)

  def updateCategory(categoryId: Int, title: String, description: String): QuizQuestionCategory

  def getCategories(quizId: Int, parentCategoryId: Option[Int]): Seq[QuizQuestionCategory]

  def getQuestionOption(questionId: Int): Option[QuizQuestion]

  def getQuestion(questionId: Int): QuizQuestion

  def getQuestionsByCategory(quizId: Int, categoryId: Option[Int]): Seq[QuizQuestion]

  def getQuestionsCount(quizId: Int): Int

  def createQuestionRevealJS(quizId: Int, categoryId: Option[Int], title: String, text: String): QuizQuestion
  def createQuestionPDF(quizId: Int, categoryId: Option[Int], title: String, filename: String): QuizQuestion
  def createQuestionPPTX(quizId: Int, categoryId: Option[Int], title: String, filename: String): QuizQuestion

  def createQuestionPlainText(quizId: Int, categoryId: Option[Int], title: String, text: String): QuizQuestion

  def createQuestionExternal(quizId: Int, categoryId: Option[Int], title: String, url: String): QuizQuestion

  def createQuestionFromQuestionBank(quizId: Int, categoryId: Option[Int], bankQuestionId: Int): QuizQuestion

  def createQuestionDocumentLibrary(quizId: Int, categoryId: Option[Int], title: String, uuid: String, groupId: Int): QuizQuestion

  def updateQuestionPlainText(questionId: Int, title: String): Unit

  def updateQuestionRevealJS(questionId: Int, title: String): Unit

  def updateQuestionPDF(questionId: Int, title: String): Unit

  def updateQuestionPPTX(questionId: Int, title: String): Unit

  def updateQuestionExternal(questionId: Int, title: String, url: String): Unit

  def updateQuestionFromQuestionBank(questionId: Int, title: String, autoShowAnswer: Boolean): Unit

  def deleteQuestion(quizId: Int, questionId: Int): Unit

  def moveQuestion(quizId: Int, questionId: Int, parentId: Option[Int], index: Int)

  def moveCategory(quizId: Int, categoryId: Int, parentId: Option[Int], index: Int)

  def getQuestionIndex(quizId: Int, questionId: Int): Int

  def getCategoryIndex(quizId: Int, categoryId: Int): Int

  def cloneQuiz(quizId: Int, namePostfix: String): Quiz

  def publishQuizAsTincan(quizId: Int, theme: Option[String], randomOrdering: Boolean, questionsPerUser: Option[Int])

  def publishQuizAsScorm(quizId: Int, userId: Long, groupIdOption: Option[Long], randomOrdering: Boolean, questionsPerUser: Option[Int])
}
