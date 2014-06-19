package com.arcusys.learn.quiz.storage

import com.arcusys.learn.questionbank.storage.{ QuestionStorage, QuestionCategoryStorage, AnswerStorage }
import org.junit.{ Before, Test }
import org.junit.Assert._
import com.arcusys.learn.quiz.model.{ QuestionBankQuizQuestion, QuizQuestionCategory, Quiz }
import com.arcusys.learn.questionbank.model.TextQuestion

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait QuizQuestionStorageJUnitMethods {
  def quizStorage: QuizStorage
  def quizCategoryStorage: QuizQuestionCategoryStorage
  def quizQuestionStorage: QuizQuestionStorage
  def answerStorage: AnswerStorage
  def questionCategoryStorage: QuestionCategoryStorage
  def questionStorage: QuestionStorage

  @Before
  def setUp() {
    questionCategoryStorage.renew()
    questionStorage.renew()
    answerStorage.renew()
    quizStorage.renew()
    quizCategoryStorage.renew()
    quizQuestionStorage.renew()
  }

  @Test
  def noDataInitially() {
    assertEquals(0, quizQuestionStorage.getAll.size)
  }

  @Test
  def canCreate() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None, ""))
    val categoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    val questionId = questionStorage.createAndGetID(new TextQuestion(0, None, "title", "text", "explanationText", Seq(), false, None))
    quizQuestionStorage.createFromQuestionBankAndGetID(quizId, Some(categoryId), questionId)
    quizQuestionStorage.createFromQuestionBankAndGetID(quizId, Some(categoryId), questionId)
    assertEquals(2, quizQuestionStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None, ""))
    val categoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    val questionId = questionStorage.createAndGetID(new TextQuestion(0, None, "title", "text", "explanationText", Seq(), false, None))
    val question = questionStorage.getByID(questionId).get
    val quizQuestionId = quizQuestionStorage.createFromQuestionBankAndGetID(quizId, Some(categoryId), questionId)

    val fetchedQuizQuestion = quizQuestionStorage.getByID(quizQuestionId).get
    assertTrue(fetchedQuizQuestion.isInstanceOf[QuestionBankQuizQuestion])
    val questionBankQuestion = fetchedQuizQuestion.asInstanceOf[QuestionBankQuizQuestion]
    val fetchedQuestion = questionBankQuestion.question.asInstanceOf[TextQuestion]
    assertEquals(Some(categoryId), questionBankQuestion.categoryID)
    assertEquals(question.questionTypeCode, fetchedQuestion.questionTypeCode)
    assertEquals(question.id, fetchedQuestion.id)
    assertEquals(question.categoryID, fetchedQuestion.categoryID)
    assertEquals(question.title, fetchedQuestion.title)
    assertEquals(question.text, fetchedQuestion.text)
    assertEquals(question.explanationText, fetchedQuestion.explanationText)
    assertEquals(question.asInstanceOf[TextQuestion].isCaseSensitive, fetchedQuestion.isCaseSensitive)
    assertEquals(question.answers, fetchedQuestion.answers)
  }

  @Test
  def canDelete() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None, ""))
    val categoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    val questionId = questionStorage.createAndGetID(new TextQuestion(0, None, "title", "text", "explanationText", Seq(), false, None))
    quizQuestionStorage.createFromQuestionBankAndGetID(quizId, Some(categoryId), questionId)
    quizQuestionStorage.createFromQuestionBankAndGetID(quizId, Some(categoryId), questionId)
    val quizQuestionId = quizQuestionStorage.createFromQuestionBankAndGetID(quizId, Some(categoryId), questionId)

    assertEquals(3, quizQuestionStorage.getAll.size)
    quizQuestionStorage.delete(quizQuestionId)
    assertEquals(2, quizQuestionStorage.getAll.size)
  }

  @Test
  def canCascadeDelete() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final", None, ""))
    val categoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    val questionId = questionStorage.createAndGetID(new TextQuestion(0, None, "title", "text", "explanationText", Seq(), false, None))
    quizQuestionStorage.createFromQuestionBankAndGetID(quizId, Some(categoryId), questionId)
    quizQuestionStorage.createFromQuestionBankAndGetID(quizId, Some(categoryId), questionId)
    quizQuestionStorage.createFromQuestionBankAndGetID(quizId, Some(categoryId), questionId)

    assertEquals(3, quizQuestionStorage.getAll.size)

    quizStorage.delete(quizId)
    assertEquals(0, quizStorage.getAll.size)
    assertEquals(0, quizCategoryStorage.getAll.size)

    assertEquals(0, quizCategoryStorage.getAll.size)
  }
}
