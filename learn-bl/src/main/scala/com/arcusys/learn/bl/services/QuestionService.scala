package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.questionbank.model.{ QuestionCategory, Answer, Question }
import com.arcusys.learn.questionbank.storage.{ QuestionStorage, QuestionCategoryStorage }
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }

class QuestionService(configuration: BindingModule) extends Injectable with QuestionServiceContract {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration

  val questionStorage = inject[QuestionStorage]
  val questionCategoryStorage = inject[QuestionCategoryStorage]

  def getQuestion(questionId: Int): Question[Answer] = {
    questionStorage.getByID(questionId).getOrElse(throw new Exception("question not found, id: " + questionId))
  }

  def createQuestion(question: Question[Answer]): Question[Answer] = {
    //TODO create methods for real question classes instead base
    val questionId = questionStorage.createAndGetID(question)
    //TODO create answers here
    getQuestion(questionId)
  }

  def updateQuestion(question: Question[Answer]): Question[Answer] = {
    //TODO create methods for real question classes instead base
    questionStorage.modify(question)
    //TODO update answers here
    getQuestion(question.id)
  }

  def deleteQuestion(questionId: Int) = {
    questionStorage.delete(questionId)
    //TODO delete answers here ???
  }

  def getQuestionsByCategory(categoryId: Option[Int], courseId: Option[Int]): Seq[Question[Answer]] = {
    questionStorage.getByCategory(categoryId, courseId)
  }

  def getQuestionsCountByCategory(categoryId: Option[Int], courseId: Option[Int]): Int = {
    questionStorage.getByCategory(categoryId, courseId).length
  }

  def getCategory(categoryId: Int): QuestionCategory = {
    questionCategoryStorage.getByID(categoryId).getOrElse(throw new Exception("question category not found, id: " + categoryId))
  }

  def getCategoryOption(categoryId: Int): Option[QuestionCategory] = {
    questionCategoryStorage.getByID(categoryId)
  }

  def createCategory(title: String, description: String, parentCategoryId: Option[Int], courseId: Option[Int]): QuestionCategory = {
    val categoryId = questionCategoryStorage.createAndGetID(
      new QuestionCategory(-1, title, description, parentCategoryId, courseId)
    )

    getCategory(categoryId)
  }

  def updateCategory(categoryId: Int, title: String, description: String): QuestionCategory = {
    questionCategoryStorage.modify(categoryId, title, description)
    getCategory(categoryId)
  }

  def deleteCategory(categoryId: Int, courseId: Option[Int]) = {
    // TODO: throw exception if category not found, need to check
    questionCategoryStorage.delete(categoryId)

    questionStorage.getByCategory(Some(categoryId), courseId).foreach(x => deleteQuestion(x.id))
  }

  def getCategories(parentCategoryId: Option[Int], courseId: Option[Int]): Seq[QuestionCategory] = {
    questionCategoryStorage.getChildren(parentCategoryId, courseId)
  }

  def getCategories(courseId: Option[Int]): Seq[QuestionCategory] = {
    questionCategoryStorage.getAllByCourseID(courseId)
  }

  def moveQuestion(questionId: Int, position: Int, categoryId: Option[Int]): Question[Answer] = {
    questionStorage.move(questionId, position, categoryId)
    getQuestion(questionId)
  }

  def moveQuestionToCourse(questionId: Int, courseId: Option[Int], moveInRoot: Boolean) = {
    questionStorage.moveToCourse(questionId, courseId, moveInRoot)
  }

  def moveCategoryToCourse(categoryId: Int, courseId: Option[Int], newCourseID: Option[Int]) = {
    questionStorage.getByCategory(Some(categoryId), courseId).foreach(x => moveQuestionToCourse(x.id, newCourseID, false))

    questionCategoryStorage.moveToCourse(categoryId, newCourseID)
  }

  def moveCategoryToSibling(categoryId: Int, siblingId: Int, moveAfterSibling: Boolean): QuestionCategory = {
    val siblingCategory = getCategory(siblingId)
    questionCategoryStorage.move(categoryId, siblingCategory.parentID, Some(siblingId), moveAfterSibling)
    getCategory(categoryId)
  }

  def moveCategoryToCategory(categoryId: Int, targetCategoryId: Option[Int], moveAfterSibling: Boolean): QuestionCategory = {
    questionCategoryStorage.move(categoryId, targetCategoryId, None, moveAfterSibling = true)
    getCategory(categoryId)
  }

  def moveCategoryToQuestion(categoryId: Int, questionId: Int): QuestionCategory = {
    val question = getQuestion(questionId)
    questionCategoryStorage.move(categoryId, question.categoryID, None, moveAfterSibling = true)
    getCategory(categoryId)
  }
}
