package com.arcusys.learn.quiz.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory
import org.specs2.mock.Mockito
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalService
import com.arcusys.learn.storage.impl.liferay.MockKeyedEntityContainer
import scala.collection.JavaConverters._

/**
 * User: dkudinov
 * Date: 19.3.2013
 */
trait QuizQuestionCategoryMockImpl extends Mockito {
  val mockServiceBeanName = classOf[LFQuizQuestionCategoryLocalService].getName
  val mockLocalService = mock[LFQuizQuestionCategoryLocalService]
}

object QuizQuestionCategoryMockEntityContainer extends QuizQuestionCategoryMockImpl with MockKeyedEntityContainer[LFQuizQuestionCategoryLocalService, LFQuizQuestionCategory] {
  def getByIdFunction = _.getLFQuizQuestionCategory(_)

  // service related mocks
  def createFunction = _.createLFQuizQuestionCategory()
  def addFunction = _.addLFQuizQuestionCategory(_)
  def deleteFunction = _.deleteLFQuizQuestionCategory(_)
  def updateFunction = _.updateLFQuizQuestionCategory(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFQuizQuestionCategories(_, _)
  def removeAllFunction = _.removeAll()


  // entity related mocks
  def createMockEntity() = mock[LFQuizQuestionCategory]
  def mockEntityProperties(mockEntity: LFQuizQuestionCategory) {
    // id: Int, title: String, description: String, quizID: Int, parentID: Option[Int]
    mockStringProperty(mockEntity.setTitle(_), _.getTitle)
    mockStringProperty(mockEntity.setDescription(_), _.getDescription)
    mockIntegerProperty(mockEntity.setQuizId(_), _.getQuizId)
    mockIntegerProperty(mockEntity.setParentId(_), _.getParentId)
    mockIntegerProperty(mockEntity.setArrangementIndex(_), _.getArrangementIndex)
  }
  def getIdFunction = _.getId

  mockLocalService.findByQuizIdAndParentId(any, any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any) = paramsRaw match {
      case Array(a, b)  => (a, b)
    }

    val quizId = unwrapNullableInteger(paramsTuple._1)
    val parentId = unwrapNullableInteger(paramsTuple._2)

    internalStorage.values.filter(entity =>
      (quizId == null || quizId == entity.getQuizId)
        && parentId == entity.getParentId
    ).toList.sortBy(_.getArrangementIndex).asJava
  }

  mockLocalService.findByQuizId(anyInt) answers { quizIdRaw =>
    val quizId = unwrapNullableInteger(quizIdRaw)

    internalStorage.values.filter(entity =>
      (quizId == null || quizId == entity.getQuizId)
    ).toList.sortBy(_.getArrangementIndex).asJava
  }

}
