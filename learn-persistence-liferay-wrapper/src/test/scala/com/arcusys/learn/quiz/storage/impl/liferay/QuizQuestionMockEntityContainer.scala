package com.arcusys.learn.quiz.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalService
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestion
import com.arcusys.learn.storage.impl.liferay.MockKeyedEntityContainer

import scala.collection.JavaConverters._

/**
 * User: dkudinov
 * Date: 18.3.2013
 */

object QuizQuestionMockEntityContainer extends MockKeyedEntityContainer[LFQuizQuestionLocalService, LFQuizQuestion] {
  lazy val mockServiceBeanName = classOf[LFQuizQuestionLocalService].getName
  lazy val mockLocalService = mock[LFQuizQuestionLocalService]

  // service related mocks
  def createFunction = _.createLFQuizQuestion()
  def addFunction = _.addLFQuizQuestion(_)
  def deleteFunction = _.deleteLFQuizQuestion(_)
  def updateFunction = _.updateLFQuizQuestion(_)
  def getByIdFunction = _.getLFQuizQuestion(_)
  def orNull = _.orNull
  def createMockEntity() = mock[LFQuizQuestion]
  def getAllFunction = _.getLFQuizQuestions(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def mockEntityProperties(mockEntity: LFQuizQuestion) {
    mockIntegerProperty(mockEntity.setQuizId(_), _.getQuizId)
    mockIntegerProperty(mockEntity.setCategoryId(_), _.getCategoryId)
    mockIntegerProperty(mockEntity.setQuestionId(_), _.getQuestionId)
    mockStringProperty(mockEntity.setTitle(_), _.getTitle)
    mockStringProperty(mockEntity.setUrl(_), _.getUrl)
    mockStringProperty(mockEntity.setQuestionType(_), _.getQuestionType)
    mockStringProperty(mockEntity.setPlainText(_), _.getPlainText)
    mockIntegerProperty(mockEntity.setArrangementIndex(_), _.getArrangementIndex)
  }
  def getIdFunction = _.getId

  mockLocalService.findByQuizID(anyInt) answers { quizIdRaw =>
    val quizId = unwrapNullableInteger(quizIdRaw)
    internalStorage.values.filter(_.getQuizId == quizId).toList.sortBy(_.getArrangementIndex).asJava
  }

  mockLocalService.findByQuizAndCategory(any, any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any) = paramsRaw match {
      case Array(a, b)  => (a, b)
    }

    val quizId = unwrapNullableInteger(paramsTuple._1)
    val categoryId = unwrapNullableInteger(paramsTuple._2)

    internalStorage.values.filter(entity =>
      (categoryId == null || categoryId == entity.getCategoryId)
        && quizId == entity.getQuizId
    ).toList.sortBy(_.getArrangementIndex).asJava
  }
}
