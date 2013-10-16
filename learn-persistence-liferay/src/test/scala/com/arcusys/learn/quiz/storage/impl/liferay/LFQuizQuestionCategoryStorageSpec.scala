package com.arcusys.learn.quiz.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.quiz.model.QuizQuestionCategory
import com.arcusys.learn.persistence.liferay.service.{LFQuizQuestionCategoryLocalServiceUtil, LFQuizQuestionCategoryLocalService}
import util.Random
import com.arcusys.learn.storage.impl.liferay.LFStorages
import org.specs2.specification.Scope

/**
 * User: dkudinov
 * Date: 19.3.2013
 */
class LFQuizQuestionCategoryStorageSpec extends SpecificationWithJUnit with Mockito {
  val storageService: LFQuizQuestionCategoryLocalService = QuizQuestionCategoryMockEntityContainer.mockLocalService
  val storage: KeyedEntityStorage[QuizQuestionCategory] = new LFQuizQuestionCategoryStorageImpl {}

  "Mockito" should {
    "mock service method" in {
      LFQuizQuestionCategoryLocalServiceUtil.createLFQuizQuestionCategory() must not(throwA[Exception])

      there was atLeastOne(storageService).createLFQuizQuestionCategory()
    }
  }

  "LFQuizQuestionCagetoryStorage" should {
    "storeAndGet same entity" in {
      val parentID: Some[Int] = Some(1)
      val quizId: Int = 123
      val arrangementIndex: Int = 3
      val id = createNew(quizId, parentID = parentID, arrangementIndex = arrangementIndex)

      val byId = storage.getByID(id)
      byId must beSome
      byId.get.quizID must beEqualTo(quizId)
      byId.get.parentID must beEqualTo(parentID)
      byId.get.arrangementIndex must beEqualTo(arrangementIndex)
    }

    "update entity successfully" in {
      val title: String = "title"
      val id = createNew(title = title)

      val entity = storage.getByID(id).get
      val newTitle: String = title + "0"
      storage.modify("id" -> id, "title" -> newTitle, "description" -> entity.description)

      storage.getByID(id).get.title must beEqualTo(newTitle)
    }

    "delete entity successfully" in {
      val id = createNew()

      storage.getByID(id) must beSome

      storage.delete("id" -> id)

      storage.getByID(id) must beNone
    }

    "return all just created entities" in {
      val ids = Seq(
        createNew(),
        createNew()
      )

      storage.getAll().map(_.id) must containAllOf(ids)
    }

    "getAll by quizID and parentID" in {
      val quizId: Int = 12345
      val parentId: Some[Int] = randomCategory

      val idByQuiz = createNew(quizId = quizId, parentID = None)
      val idByQuizAndParent = createNew(quizId = quizId, parentID = parentId)

      storage.getAll("quizID" -> quizId, "parentID" -> -1).map(_.id) must beEqualTo(Seq(idByQuiz))
      storage.getAll("quizID" -> quizId, "parentID" -> parentId.get).map(_.id) must containAllOf(Seq(idByQuizAndParent))
    }

  }

  def randomCategory: Some[Int] = {
    Some(Random.nextInt())
  }

  "QuizQuestionCategoryEntityStorage" should {
    val entityStorage = LFStorages.quizCategoryStorage

    "create new quizQuestionCategory with arrangementIndex = 1" in {
      randomCategory must not (beEqualTo(randomCategory))

      val parentId = randomCategory
      val id = entityStorage.createAndGetID(createNewEntity(parentID = parentId))
      val id2 = entityStorage.createAndGetID(createNewEntity(parentID = parentId))

      entityStorage.getByID(id).get.arrangementIndex must beEqualTo(1) and {
        entityStorage.getByID(id2).get.arrangementIndex must beEqualTo(2)
      }
    }

    "move to top" in new QuizQuestionCategoryContext {
      val moveAfterTarget = false
      entityStorage.move(questionId4.id, parentId, None, moveAfterTarget)

      storage.getByID(questionId4.id).get.parentID must beEqualTo(parentId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 1),
        ExpectedIndex(questionId1, 2),
        ExpectedIndex(questionId2, 3),
        ExpectedIndex(questionId3, 4)
      )
    }

    "move to bottom" in new QuizQuestionCategoryContext {
      val moveAfterTarget = true
      entityStorage.move(questionId4.id, parentId, None, moveAfterTarget)

      storage.getByID(questionId4.id).get.parentID must  beEqualTo(parentId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 1),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 2),
        ExpectedIndex(questionId3, 3)
      )
    }

    "move before" in new QuizQuestionCategoryContext {
      val moveAfterTarget = false
      entityStorage.move(questionId4.id, parentId, Some(questionId2.id), moveAfterTarget)

      storage.getByID(questionId4.id).get.parentID must  beEqualTo(parentId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 2),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 3),
        ExpectedIndex(questionId3, 4)
      )
    }

    "move after" in new QuizQuestionCategoryContext {
      val moveAfterTarget = true
      entityStorage.move(questionId4.id, parentId, Some(questionId2.id), moveAfterTarget)

      storage.getByID(questionId4.id).get.parentID must  beEqualTo(parentId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 4),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 2),
        ExpectedIndex(questionId3, 4)
      )
    }

    trait QuizQuestionCategoryContext extends Scope {
      val parentId = randomCategory
      val questionId1 = QuizQuestionCategoryId("questionId1", createNew(parentID = parentId, arrangementIndex = 1))
      val questionId2 = QuizQuestionCategoryId("questionId2", createNew(parentID = parentId, arrangementIndex = 2))
      val questionId3 = QuizQuestionCategoryId("questionId3", createNew(parentID = parentId, arrangementIndex = 3))

      val questionId4 = QuizQuestionCategoryId("questionId4", createNew(parentID = None))

      case class QuizQuestionCategoryId(name: String, id: Int)
      case class ExpectedIndex(question: QuizQuestionCategoryId, arrangementIndex: Int)

      def checkArrangementIndex(expected: ExpectedIndex *) {
        expected.foreach(expectedIndex =>
          (expectedIndex.question.name -> storage.getByID(expectedIndex.question.id).get.arrangementIndex) must beEqualTo(expectedIndex.question.name -> expectedIndex.arrangementIndex)
        )
      }

    }
  }

  def createNew(quizId: Int = 123, title: String = "title", parentID: Option[Int] = Some(1), arrangementIndex: Int = 1): Int = {
    storage.createAndGetID(createNewEntity(quizId = quizId, title = title, parentID = None), "parentID" -> parentID, "arrangementIndex" -> arrangementIndex)
  }

  def createNewEntity(title: String = "title", quizId: Int = 123 , parentID: Option[Int] = None): QuizQuestionCategory = {
    QuizQuestionCategory(0, title, "description", quizId, parentID)
  }
}
