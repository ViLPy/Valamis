package com.arcusys.learn.bl.services.quiz

import com.arcusys.learn.bl.services.QuizServiceContract
import com.arcusys.learn.quiz.model.{ QuizQuestionCategory, QuizTreeElement }
import com.arcusys.learn.quiz.storage.{ QuizQuestionCategoryStorage, QuizQuestionStorage, QuizTreeStorage }

trait QuizCategoryManager extends QuizQuestionManager with QuizServiceContract {

  protected def categoryStorage: QuizQuestionCategoryStorage

  protected def questionStorage: QuizQuestionStorage

  protected def quizTreeStorage: QuizTreeStorage

  def getCategory(categoryId: Int): QuizQuestionCategory = {
    categoryStorage.getByID(categoryId).getOrElse(throw new Exception("quiz category not found, categoryId: " + categoryId))
  }

  def getCategories(quizId: Int, parentCategoryId: Option[Int]): Seq[QuizQuestionCategory] = {
    categoryStorage.getChildren(quizId, parentCategoryId)
  }

  def createCategory(quizId: Int, title: String, description: String): QuizQuestionCategory = {
    val categoryId = categoryStorage.createAndGetID(QuizQuestionCategory(0, title, description, quizId, None))
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizId, "c_" + categoryId, true, None))
    getCategory(categoryId)
  }

  def deleteCategory(quizId: Int, categoryId: Int) = {
    questionStorage.getByCategory(quizId, Some(categoryId)).foreach(q => deleteQuestion(quizId, q.id))
    quizTreeStorage.getByQuizAndElementID(quizId, "c_" + categoryId).map(e => quizTreeStorage.delete(e.id))
    categoryStorage.delete(categoryId)
  }

  def updateCategory(categoryId: Int, title: String, description: String): QuizQuestionCategory = {
    categoryStorage.modify(categoryId, title, description)
    getCategory(categoryId)
  }

  def getCategoryIndex(quizId: Int, categoryId: Int): Int = {
    val quizTreeElement = quizTreeStorage.getByQuizAndElementID(quizId, "c_" + categoryId)
    quizTreeElement.map(_.arrangementIndex).getOrElse(1)
  }

  def moveCategory(quizId: Int, categoryId: Int, parentId: Option[Int], index: Int) = {
    for (parentIdValue <- parentId)
      if (quizTreeStorage.getByQuizAndElementID(quizId, "q_" + parentIdValue).isEmpty)
        throw new Exception("can`t move quiz question, not parent " + parentIdValue)

    for (quizTree <- quizTreeStorage.getByQuizAndElementID(quizId, "c_" + categoryId)) {
      categoryStorage.updateParent(categoryId, parentId)
      quizTreeStorage.move(quizTree.copy(parentID = parentId.map("c_" + _), arrangementIndex = index), quizTree.arrangementIndex)
    }
  }
}
