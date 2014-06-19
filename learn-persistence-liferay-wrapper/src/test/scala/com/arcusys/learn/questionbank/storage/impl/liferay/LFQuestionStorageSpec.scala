package com.arcusys.learn.questionbank.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import com.arcusys.learn.persistence.liferay.service.{ LFQuestionLocalServiceUtil, LFQuestionLocalService }
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.questionbank.model.{ TextQuestion, Answer, Question }
import com.arcusys.learn.questionbank.storage.impl.QuestionCreator
import com.arcusys.learn.storage.impl.liferay.LFStorages
import util.Random
import org.specs2.specification.Scope

/**
 * User: dkudinov
 * Date: 20.3.2013
 */
class LFQuestionStorageSpec extends SpecificationWithJUnit with Mockito {
  val storageService: LFQuestionLocalService = QuestionMockEntityContainer.mockLocalService
  import LFQuestionStorageSpec._

  "Mockito" should {
    "mock service method" in {
      LFQuestionLocalServiceUtil.createLFQuestion()

      there was atLeastOne(storageService).createLFQuestion()
    }
  }

  "LFQuestionStorage" should {
    "storeAndGet same entity" in {
      val categoryId: Option[Int] = Some(123)

      val title: String = "someTitle"
      val id = createQuestion(categoryId, title)

      storage.getByID(id) must beSome
      storage.getByID(id).get.title must beEqualTo(title)
    }

    "update" in {
      val oldTitle: String = "someOldTitle"
      val id = createQuestion(title = oldTitle)

      val question: TextQuestion = storage.getByID(id).get.asInstanceOf[TextQuestion]

      val newTitle: String = oldTitle + "0"
      storage.modify(question.copy(title = newTitle), "forceCorrectCount" -> Some(true), "isCaseSensitive" -> None)

      storage.getByID(id).get.title must beEqualTo(newTitle)
    }

    "delete" in {
      val id = createQuestion()

      storage.getByID(id) must beSome

      storage.delete("id" -> id)

      storage.getByID(id) must beNone
    }

    "getAll by categoryId and courseId" in {
      //getAll("categoryID" -> categoryID.getOrElse(-1), "courseID" -> courseID.getOrElse(-1))

      val courseId = 765
      val categoryId = 567

      val idsBoth = Seq(createQuestion(courseId = Some(courseId), categoryId = Some(categoryId)),
        createQuestion(courseId = Some(courseId), categoryId = Some(categoryId)))

      val idsCategoryOnly = Seq(createQuestion(courseId = None, categoryId = Some(categoryId)))

      val idsCourseOnly = Seq(createQuestion(courseId = Some(courseId), categoryId = None))

      val idsNone = Seq(createQuestion(courseId = None, categoryId = None))

      val idsInTest = idsBoth ++: idsCategoryOnly ++: idsCourseOnly ++: idsNone

      storage.getAll("categoryID" -> categoryId, "courseID" -> courseId).map(_.id).filter(idsInTest.contains(_)) must containTheSameElementsAs(idsBoth ++: idsCategoryOnly)
      storage.getAll("categoryID" -> categoryId, "courseID" -> -1).map(_.id).filter(idsInTest.contains(_)) must containTheSameElementsAs(idsCategoryOnly)
      storage.getAll("categoryID" -> -1, "courseID" -> courseId).map(_.id).filter(idsInTest.contains(_)) must containTheSameElementsAs(idsCourseOnly ++: idsNone)
      storage.getAll("categoryID" -> -1, "courseID" -> -1).map(_.id).filter(idsInTest.contains(_)) must containTheSameElementsAs(idsNone)

    }
  }

  "QuestionEntityStorage.create" should {
    "has arrangementIndex == 1 for first entity" in {
      randomCategory must not(beEqualTo(randomCategory))

      val id = LFStorages.questionStorage.createAndGetID(createTextQuestion(randomCategory))
      LFStorages.questionStorage.getByID(id).get.arrangementIndex must beEqualTo(1)
    }
  }

  def randomCategory: Some[Int] = {
    Some(Random.nextInt())
  }

  "QuestionEntityStorage.move" should {
    "move to top" in new QuestionContext {
      val moveAfterTarget = false
      LFStorages.questionStorage.move(questionId4.id, categoryId, None, moveAfterTarget)

      storage.getByID(questionId4.id).get.categoryID must beEqualTo(categoryId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 1),
        ExpectedIndex(questionId1, 2),
        ExpectedIndex(questionId2, 3),
        ExpectedIndex(questionId3, 4)
      )
    }

    "move after sibling" in new QuestionContext {
      val moveAfterTarget = true
      LFStorages.questionStorage.move(questionId4.id, categoryId, Some(questionId2.id), moveAfterTarget)

      storage.getByID(questionId4.id).get.categoryID must beEqualTo(categoryId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 3),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 2),
        ExpectedIndex(questionId3, 4)
      )
    }

    "move before sibling" in new QuestionContext {
      val moveAfterTarget = false
      LFStorages.questionStorage.move(questionId4.id, categoryId, Some(questionId2.id), moveAfterTarget)

      storage.getByID(questionId4.id).get.categoryID must beEqualTo(categoryId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 2),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 3),
        ExpectedIndex(questionId3, 4)
      )
    }

    "move to botton" in new QuestionContext {
      val moveAfterTarget = true
      LFStorages.questionStorage.move(questionId4.id, categoryId, None, moveAfterTarget)

      storage.getByID(questionId4.id).get.categoryID must beEqualTo(categoryId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 4),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 2),
        ExpectedIndex(questionId3, 3)
      )
    }

    trait QuestionContext extends Scope {
      val categoryId = randomCategory
      val questionId1 = QuestionId("questionId1", createQuestion(categoryId, arrangementIndex = 1))
      val questionId2 = QuestionId("questionId2", createQuestion(categoryId, arrangementIndex = 2))
      val questionId3 = QuestionId("questionId3", createQuestion(categoryId, arrangementIndex = 3))

      val questionId4 = QuestionId("questionId4", createQuestion(None))

      case class QuestionId(name: String, id: Int)
      case class ExpectedIndex(question: QuestionId, arrangementIndex: Int)

      def checkArrangementIndex(expected: ExpectedIndex*) {
        expected.foreach(expectedIndex =>
          (expectedIndex.question.name -> storage.getByID(expectedIndex.question.id).get.arrangementIndex) must beEqualTo(expectedIndex.question.name -> expectedIndex.arrangementIndex)
        )
      }

    }

  }
}

object LFQuestionStorageSpec {
  val storage: KeyedEntityStorage[Question[Answer]] = new LFQuestionStorageImpl with QuestionCreator {
    def answerStorage = LFStorages.answerStorage
  }

  def createQuestion(categoryId: Option[Int] = None, title: String = "title", forceCorrectCount: Option[Boolean] = Some(true),
    isCaseSensitive: Option[Boolean] = Some(false), courseId: Option[Int] = None, arrangementIndex: Int = 1): Int = {
    storage.createAndGetID(createTextQuestion(categoryId, title, courseId),
      "categoryID" -> categoryId,
      "forceCorrectCount" -> forceCorrectCount,
      "isCaseSensitive" -> isCaseSensitive,
      "arrangementIndex" -> arrangementIndex)
  }

  def createTextQuestion(categoryId: Option[Int] = None, title: String = "title", courseID: Option[Int] = None): TextQuestion = {
    new TextQuestion(
      0,
      categoryId,
      title,
      "text",
      "explanationText",
      Seq(),
      false,
      courseID
    )
  }
}
