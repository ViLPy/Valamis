package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.questionbank.model.QuestionCategory
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import org.specs2.mock.Mockito
import org.specs2.mutable.SpecificationWithJUnit
import com.arcusys.learn.persistence.liferay.service.{LFQuestionCategoryLocalService, LFQuestionCategoryLocalServiceUtil}
import com.arcusys.learn.storage.impl.liferay.LFStorages
import util.Random
import org.specs2.specification.Scope

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
class LFQuestionCategoryStorageSpec extends SpecificationWithJUnit with Mockito {
  val storageService: LFQuestionCategoryLocalService = QuestionCategoryMockEntityContainer.mockLocalService
  val storage: KeyedEntityStorage[QuestionCategory] = new LFQuestionCategoryStorageImpl {}

  "Mockito" should {
    "mock service method" in {
      LFQuestionCategoryLocalServiceUtil.createLFQuestionCategory()

      there was atLeastOne(storageService).createLFQuestionCategory()
    }
  }

  "LFQuestionCategoryStorage" should {
    "storeAndGet same entity" in {
      val parentID: Option[Int] = Some(123)
      val title: String = "someTitle"
      val courseId: Option[Int] = Some(1234)
      val arrangementIndex: Int = 3
      // createAndGetID
      val id = createNew(title, courseId, parentID, arrangementIndex)
      // getByID
      val entity = storage.getByID(id)

      // as Same and compare some
      entity must beSome
      entity.get.parentID must beEqualTo(parentID)
      entity.get.courseID must beEqualTo(courseId)
      entity.get.title must beEqualTo(title)
      entity.get.arrangementIndex must beEqualTo(arrangementIndex)
    }

    "update" in {
      val oldTitle = "oldTitle"
      val id = createNew(title = oldTitle)

      val entity = storage.getByID(id)
      entity.get.title must beEqualTo(oldTitle)

      val newTitle: String = oldTitle + "0"
      storage.modify("id" -> id, "title" -> newTitle, "description" -> entity.get.description)

      storage.getByID(id).get.title must beEqualTo(newTitle)
    }

    "delete" in {
      val id = createNew()

      storage.getByID(id) must beSome

      storage.delete("id" -> id)

      storage.getByID(id) must beNone
    }

    "getAll by optional courseID" in {
      val sameCourseId: Option[Int] = Some(567)
      val anotherCourseId: Option[Int] = Some(5678)

      val ids = Seq(createNew(courseId = sameCourseId),
      createNew(courseId = sameCourseId))

      val anotherId = createNew(courseId = anotherCourseId)
      val nullCourse = createNew(courseId = None)

      storage.getAll("courseID" -> sameCourseId.get).map(_.id) must containAllOf(nullCourse +: ids)
      storage.getAll("courseID" -> sameCourseId.get).map(_.id) must not(contain(anotherId))

      storage.getAll("courseID" -> -1).map(_.id) must contain(nullCourse)
    }

    "getAll by courseId and optional parentID" in {
      val courseId = Some(765)
      val sameParentId: Option[Int] = Some(567)
      val anotherParentId: Option[Int] = Some(5678)

      val ids = Seq(createNew(courseId = courseId, parentID = sameParentId),
        createNew(courseId = courseId, parentID = sameParentId))

      val anotherId = createNew(courseId = courseId, parentID = anotherParentId)
      val nullParent = createNew(courseId = courseId, parentID = None)

      storage.getAll("courseID" -> courseId.get, "parentID" -> sameParentId.get).map(_.id) must containTheSameElementsAs(ids)
      storage.getAll("courseID" -> courseId.get, "parentID" -> sameParentId.get).map(_.id) must not(containAnyOf(Seq(anotherId, nullParent)))

      storage.getAll("courseID" -> courseId.get, "parentID" -> -1).map(_.id) must contain(nullParent)
      storage.getAll("courseID" -> courseId.get, "parentID" -> -1).map(_.id) must not(containAnyOf(anotherId +: ids))

    }
  }

  def randomCategory: Some[Int] = {
    Some(Random.nextInt())
  }

  "QuestionCategoryEntityStorage" should {
    val entityStorage = LFStorages.questionCategoryStorage

    "create new questionCategory with arrangementIndex = 1" in {
      randomCategory must not (beEqualTo(randomCategory))

      val parentId = randomCategory
      val id = entityStorage.createAndGetID(createNewCategory(parentID = parentId))
      val id2 = entityStorage.createAndGetID(createNewCategory(parentID = parentId))

      entityStorage.getByID(id).get.arrangementIndex must beEqualTo(1) and {
        entityStorage.getByID(id2).get.arrangementIndex must beEqualTo(2)
      }
    }

    "move to top" in new QuestionCategoryContext {
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

    "move to bottom" in new QuestionCategoryContext {
      val moveAfterTarget = true
      entityStorage.move(questionId4.id, parentId, None, moveAfterTarget)

      storage.getByID(questionId4.id).get.parentID must  beEqualTo(parentId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 4),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 2),
        ExpectedIndex(questionId3, 3)
      )
    }

    "move before" in new QuestionCategoryContext {
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

    "move after" in new QuestionCategoryContext {
      val moveAfterTarget = true
      entityStorage.move(questionId4.id, parentId, Some(questionId2.id), moveAfterTarget)

      storage.getByID(questionId4.id).get.parentID must  beEqualTo(parentId)

      checkArrangementIndex(
        ExpectedIndex(questionId4, 3),
        ExpectedIndex(questionId1, 1),
        ExpectedIndex(questionId2, 2),
        ExpectedIndex(questionId3, 4)
      )
    }

    trait QuestionCategoryContext extends Scope {
      val parentId = randomCategory
      val questionId1 = QuestionCategoryId("questionId1", createNew(parentID = parentId, arrangementIndex = 1))
      val questionId2 = QuestionCategoryId("questionId2", createNew(parentID = parentId, arrangementIndex = 2))
      val questionId3 = QuestionCategoryId("questionId3", createNew(parentID = parentId, arrangementIndex = 3))

      val questionId4 = QuestionCategoryId("questionId4", createNew(parentID = None))

      case class QuestionCategoryId(name: String, id: Int)
      case class ExpectedIndex(question: QuestionCategoryId, arrangementIndex: Int)

      def checkArrangementIndex(expected: ExpectedIndex *) {
        expected.foreach(expectedIndex =>
          (expectedIndex.question.name -> storage.getByID(expectedIndex.question.id).get.arrangementIndex) must beEqualTo(expectedIndex.question.name -> expectedIndex.arrangementIndex)
        )
      }

    }
  }


  def createNew(title: String = "title", courseId: Option[Int] = None, parentID: Option[Int] = None, arrangementIndex: Int = 1): Int = {
    storage.createAndGetID(createNewCategory(title, courseId, None), "parentID" -> parentID, "arrangementIndex" -> arrangementIndex)
  }

  def createNewCategory(title: String = "title", courseId: Option[Int] = None, parentID: Option[Int]): QuestionCategory = {
    QuestionCategory(0, title, "description", parentID, courseId)
  }
}
