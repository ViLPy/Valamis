package com.arcusys.learn.quiz.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.quiz.model.Quiz
import com.arcusys.learn.persistence.liferay.service.{ LFQuizQuestionCategoryLocalService, LFQuizLocalService, LFQuizLocalServiceUtil }

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
class LFQuizStorageSpec extends SpecificationWithJUnit with Mockito {
  val storageService: LFQuizLocalService = QuizMockEntityContainer.mockLocalService
  val storageService2: LFQuizQuestionCategoryLocalService = QuizQuestionCategoryMockEntityContainer.mockLocalService
  val storage: KeyedEntityStorage[Quiz] = new LFQuizStorageImpl {}

  "Mockito" should {
    "mock service method" in {
      LFQuizLocalServiceUtil.createLFQuiz() must not(throwA[Exception])

      there was atLeastOne(storageService).createLFQuiz()
    }
  }

  "LFQuizStorageImpl" should {
    "storeAndGet same entity" in {
      val quizPattern: Quiz = createQuizPattern()
      val quizId = storage.createAndGetID(quizPattern)

      storage.getByID(quizId) must beEqualTo(Some(quizPattern.copy(id = quizId)))
    }

    "update entity successfully" in {
      val oldTitle: String = "oldTitle"
      val newTitle: String = oldTitle + "0"

      val quizId = createQuiz(title = oldTitle, courseID = Some(2))
      val createdQuiz: Quiz = storage.getByID(quizId).get

      storage.modify(createdQuiz.copy(title = newTitle))

      storage.getByID(quizId).map(_.title) must beEqualTo(Some(newTitle))
    }

    "delete entity successfully" in {
      val quizId = createQuiz()

      storage.getByID(quizId) must beSome

      storage.delete("id" -> quizId)
      storage.getByID(quizId) must beNone
    }

    "getAll by courseId" in {
      //getAll("courseID" -> courseID.getOrElse(-1))
      val courseId = 234

      val idsNone = Seq(createQuiz(courseID = None), createQuiz(courseID = None))
      val idsCourse = Seq(createQuiz(courseID = Some(courseId)))

      val idsInTest = idsCourse ++: idsNone

      storage.getAll("courseID" -> courseId).map(_.id).filter(idsInTest.contains(_)) must containTheSameElementsAs(idsCourse ++: idsNone)
      storage.getAll("courseID" -> -1).map(_.id).filter(idsInTest.contains(_)) must containTheSameElementsAs(idsNone)
    }
  }

  def createQuiz(title: String = "title", courseID: Option[Int] = Some(2)) = {
    val quizPattern: Quiz = createQuizPattern(title = title, courseID = courseID)
    storage.createAndGetID(quizPattern)
  }

  def createQuizPattern(title: String = "title", courseID: Option[Int] = Some(1)): Quiz = {
    Quiz(0, title, "description", "welcome", "final", courseID, "")
  }
}
