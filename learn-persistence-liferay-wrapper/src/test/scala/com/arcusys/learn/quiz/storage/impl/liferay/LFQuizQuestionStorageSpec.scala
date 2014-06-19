package com.arcusys.learn.quiz.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import com.arcusys.learn.persistence.liferay.service.{ LFQuizQuestionLocalService, LFQuizQuestionLocalServiceUtil }
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.quiz.model.{ QuizQuestionType, QuizQuestion }
import com.arcusys.learn.questionbank.storage.QuestionStorage
import com.arcusys.learn.storage.impl.liferay.LFStorages
import com.arcusys.learn.questionbank.storage.impl.liferay.{ LFQuestionStorageSpec, QuestionMockEntityContainer }
import com.arcusys.learn.quiz.storage.impl.QuizQuestionCreator
import util.Random
import org.specs2.specification.Scope

/**
 * User: dkudinov
 * Date: 18.3.2013
 */
class LFQuizQuestionStorageSpec extends SpecificationWithJUnit with Mockito {
  // init Question container as well
  QuestionMockEntityContainer.mockLocalService
  val questionStorage = LFStorages.questionStorage
  val storageService: LFQuizQuestionLocalService = QuizQuestionMockEntityContainer.mockLocalService
  val storage: KeyedEntityStorage[QuizQuestion] = new LFQuizQuestionStorageImpl with QuizQuestionCreator {
    val questionStorage: QuestionStorage = LFQuizQuestionStorageSpec.this.questionStorage
  }

  "Mockito" should {
    "mock service method" in {
      LFQuizQuestionLocalServiceUtil.createLFQuizQuestion() must not(throwA[Exception])

      there was atLeastOne(storageService).createLFQuizQuestion()
    }
  }

  "LFQuizQuestionStorage" should {
    "storeAndGet same entity" in {
      val arrangementIndex = 3
      val categoryID: Option[Int] = Some(2)
      val quizId: Int = 1
      val id = createNew(quizId, categoryID, arrangementIndex)

      val byId: Option[QuizQuestion] = storage.getByID(id)
      byId must beSome
      byId.get.quizID must beEqualTo(quizId)
      byId.get.arrangementIndex must beEqualTo(arrangementIndex)
    }

    "update entity successfully" in {
      val title: String = "title1"
      // create
      val id = storage.createAndGetID("quizID" -> 1, "categoryID" -> Some(2), "questionID" -> LFQuestionStorageSpec.createQuestion(), "title" -> title, "questionType" -> QuizQuestionType.QuestionBank.toString)

      // modify
      val newTitle: String = title + "0"
      storage.modify("id" -> id, "title" -> newTitle)
      // get and compare
      storage.getByID(id) must beSome

      storage.getByID(id).get.title must beEqualTo(Some(newTitle))
    }

    "delete entity successfully" in {
      val id = storage.createAndGetID("quizID" -> 1, "categoryID" -> Some(2), "questionID" -> LFQuestionStorageSpec.createQuestion(), "title" -> "someTitle", "questionType" -> QuizQuestionType.PlainText.toString)
      storage.getByID(id) must beSome

      storage.delete("id" -> id)

      storage.getByID(id) must beNone
    }

    "return all just created entities" in {

      val quizId1 = randomCategory.get
      val quizId2 = randomCategory.get
      val id1: Int = storage.createAndGetID("quizID" -> quizId1, "categoryID" -> Some(2), "questionID" -> LFQuestionStorageSpec.createQuestion(), "questionType" -> QuizQuestionType.QuestionBank.toString)
      val id2: Int = storage.createAndGetID("quizID" -> quizId2, "categoryID" -> Some(5), "questionID" -> LFQuestionStorageSpec.createQuestion(), "questionType" -> QuizQuestionType.QuestionBank.toString)

      storage.getAll("quizID" -> quizId1).map(_.id) must beEqualTo(Seq(id1))
      storage.getAll("quizID" -> quizId2, "categoryID" -> 5).map(_.id) must beEqualTo(Seq(id2))
    }
  }

  def randomCategory: Some[Int] = {
    Some(Random.nextInt())
  }

  "QuizQuestionEntityStorage" should {
    val entityStorage = LFStorages.quizQuestionStorage

    "create new QuizQuestion with arrangementIndex = 1" in {
      randomCategory must not(beEqualTo(randomCategory))

      val quizId = randomCategory.get
      val categoryId = randomCategory
      val id = entityStorage.createPlainAndGetID(quizId, categoryId, "title1", "text")
      val id2 = entityStorage.createPlainAndGetID(quizId, categoryId, "title2", "text")

      entityStorage.getByID(id).get.arrangementIndex must beEqualTo(1) and {
        entityStorage.getByID(id2).get.arrangementIndex must beEqualTo(2)
      }
    }

    "move to top" in new QuizQuestionContext {
      val moveAfterTarget = false
      entityStorage.move(questionId4.id, categoryId, None, moveAfterTarget)

      storage.getByID(questionId4.id).get.categoryID must beEqualTo(categoryId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 1),
        ExpectedIndex(questionId1, 2),
        ExpectedIndex(questionId2, 3),
        ExpectedIndex(questionId3, 4)
      )
    }

    "move to bottom" in new QuizQuestionContext {
      val moveAfterTarget = true
      entityStorage.move(questionId4.id, categoryId, None, moveAfterTarget)

      storage.getByID(questionId4.id).get.categoryID must beEqualTo(categoryId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 4),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 2),
        ExpectedIndex(questionId3, 3)
      )
    }

    "move before" in new QuizQuestionContext {
      val moveAfterTarget = false
      entityStorage.move(questionId4.id, categoryId, Some(questionId2.id), moveAfterTarget)

      storage.getByID(questionId4.id).get.categoryID must beEqualTo(categoryId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 2),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 3),
        ExpectedIndex(questionId3, 4)
      )
    }

    "move after" in new QuizQuestionContext {
      val moveAfterTarget = true
      entityStorage.move(questionId4.id, categoryId, Some(questionId2.id), moveAfterTarget)

      storage.getByID(questionId4.id).get.categoryID must beEqualTo(categoryId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 3),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 2),
        ExpectedIndex(questionId3, 4)
      )
    }

    trait QuizQuestionContext extends Scope {
      val categoryId = randomCategory
      val quizId = randomCategory.get
      val questionId1 = QuizQuestionId("questionId1", createNew(quizId, categoryId, arrangementIndex = 1))
      val questionId2 = QuizQuestionId("questionId2", createNew(quizId, categoryId, arrangementIndex = 2))
      val questionId3 = QuizQuestionId("questionId3", createNew(quizId, categoryId, arrangementIndex = 3))

      val questionId4 = QuizQuestionId("questionId4", createNew(quizId, categoryID = None))

      case class QuizQuestionId(name: String, id: Int)
      case class ExpectedIndex(question: QuizQuestionId, arrangementIndex: Int)

      def checkArrangementIndex(expected: ExpectedIndex*) {
        expected.foreach(expectedIndex =>
          (expectedIndex.question.name -> storage.getByID(expectedIndex.question.id).get.arrangementIndex) must beEqualTo(expectedIndex.question.name -> expectedIndex.arrangementIndex)
        )
      }

    }
  }

  def createNew(quizId: Int = 0, categoryID: Option[Int], arrangementIndex: Int = 1): Int = {
    storage.createAndGetID("quizID" -> quizId, "categoryID" -> categoryID, "questionID" -> LFQuestionStorageSpec.createQuestion(),
      "questionType" -> QuizQuestionType.QuestionBank.toString, "title" -> "someNewTitle", "url" -> "www.exampl.com", "text" -> "some long long text",
      "arrangementIndex" -> arrangementIndex)
  }
}
