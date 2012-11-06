package com.arcusys.learn.quiz.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.learn.questionbank.model.TextQuestion
import com.arcusys.learn.quiz.model._
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import com.arcusys.learn.questionbank.storage.impl.orbroker._
import runner.RunWith
import runners.Parameterized

@RunWith(value = classOf[Parameterized])
class QuizQuestionStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName){
  val quizStorage = new QuizStorageImpl
  val quizCategoryStorage = new QuizQuestionCategoryStorageImpl
  val quizQuestionStorage = new QuizQuestionStorageImpl
  val answerStorage = new AnswerStorageImpl
  val questionCategoryStorage = new QuestionCategoryStorageImpl
  val questionStorage = new QuestionStorageImpl

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
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final"))
    val categoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    val questionId = questionStorage.createAndGetID(new TextQuestion(0, None, "title", "text", "explanationText", Seq(), false))
    quizQuestionStorage.createAndGetID(quizId, Some(categoryId), questionId)
    quizQuestionStorage.createAndGetID(quizId, Some(categoryId), questionId)
    assertEquals(2, quizQuestionStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final"))
    val categoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    val questionId = questionStorage.createAndGetID(new TextQuestion(0, None, "title", "text", "explanationText", Seq(), false))
    val question = questionStorage.getByID(questionId).get
    val quizQuestionId = quizQuestionStorage.createAndGetID(quizId, Some(categoryId), questionId)

    val fetchedQuizQuestion = quizQuestionStorage.getByID(quizQuestionId).get
    val fetchedQuestion = fetchedQuizQuestion.question.get.asInstanceOf[TextQuestion]
    assertEquals(Some(categoryId), fetchedQuizQuestion.categoryID)
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
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final"))
    val categoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    val questionId = questionStorage.createAndGetID(new TextQuestion(0, None, "title", "text", "explanationText", Seq(), false))
    quizQuestionStorage.createAndGetID(quizId, Some(categoryId), questionId)
    quizQuestionStorage.createAndGetID(quizId, Some(categoryId), questionId)
    val quizQuestionId = quizQuestionStorage.createAndGetID(quizId, Some(categoryId), questionId)

    assertEquals(3, quizQuestionStorage.getAll.size)
    quizQuestionStorage.delete(quizQuestionId)
    assertEquals(2, quizQuestionStorage.getAll.size)
  }

  @Test
  def canCascadeDelete() {
    val quizId = quizStorage.createAndGetID(new Quiz(0, "title1", "description1", "welcome", "final"))
    val categoryId = quizCategoryStorage.createAndGetID(new QuizQuestionCategory(0, "title1", "description1", quizId, None))
    val questionId = questionStorage.createAndGetID(new TextQuestion(0, None, "title", "text", "explanationText", Seq(), false))
    quizQuestionStorage.createAndGetID(quizId, Some(categoryId), questionId)
    quizQuestionStorage.createAndGetID(quizId, Some(categoryId), questionId)
    quizQuestionStorage.createAndGetID(quizId, Some(categoryId), questionId)

    assertEquals(3, quizQuestionStorage.getAll.size)

    quizStorage.delete(quizId)
    assertEquals(0, quizStorage.getAll.size)
    assertEquals(0, quizCategoryStorage.getAll.size)

    assertEquals(0, quizCategoryStorage.getAll.size)
  }
}