package com.arcusys.valamis.questionbank.service

import com.arcusys.valamis.questionbank.model.{ Answer, Question, QuestionCategory }

trait QuestionService {

  def getQuestion(questionId: Int): Question[Answer]

  def createQuestion(question: Question[Answer]): Question[Answer]

  def updateQuestion(question: Question[Answer]): Question[Answer]

  def deleteQuestion(questionId: Int)

  def decodeQuestion(question: Question[Answer]): Question[Answer]

  def getQuestionsByCategory(categoryId: Option[Int], courseId: Option[Int]): Seq[Question[Answer]]

  def getQuestionsCountByCategory(categoryId: Option[Int], courseId: Option[Int]): Int

  def getCategory(categoryId: Int): QuestionCategory

  def getCategoryOption(categoryId: Int): Option[QuestionCategory]

  def createCategory(title: String, description: String, parentCategoryId: Option[Int], courseId: Option[Int]): QuestionCategory

  def updateCategory(categoryId: Int, title: String, description: String): QuestionCategory

  def deleteCategory(categoryId: Int, courseId: Option[Int])

  def getCategories(parentCategoryId: Option[Int], courseId: Option[Int]): Seq[QuestionCategory]

  def getCategories(courseId: Option[Int]): Seq[QuestionCategory]

  def moveQuestion(questionId: Int, position: Int, categoryId: Option[Int]): Question[Answer]

  def moveQuestionToCourse(questionId: Int, courseId: Option[Int], moveInRoot: Boolean)

  def moveCategoryToCourse(questionId: Int, courseId: Option[Int], newCourseId: Option[Int], parentId: Option[Int])

  def moveCategoryToSibling(categoryId: Int, siblingId: Int, moveAfterSibling: Boolean): QuestionCategory

  def moveCategory(categoryId: Int, index: Int, parentId: Option[Int] /*, newCourseId: Option[Int]*/ ): QuestionCategory

  def moveCategoryToCategory(categoryId: Int, targetCategoryId: Option[Int], moveAfterSibling: Boolean): QuestionCategory

  def moveCategoryToQuestion(categoryId: Int, questionId: Int): QuestionCategory
}
