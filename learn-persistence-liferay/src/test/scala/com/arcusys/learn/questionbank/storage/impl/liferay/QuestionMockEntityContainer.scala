package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFQuestionLocalService
import com.arcusys.learn.persistence.liferay.model.LFQuestion
import com.arcusys.learn.storage.impl.liferay.MockKeyedEntityContainer
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

import scala.collection.JavaConverters._

/**
 * User: dkudinov
 * Date: 20.3.2013
 */

object QuestionMockEntityContainer extends MockKeyedEntityContainer[LFQuestionLocalService, LFQuestion]{
  lazy val mockServiceBeanName = classOf[LFQuestionLocalService].getName
  lazy val mockLocalService = mock[LFQuestionLocalService]

  // keyed entity - service related mocks
  def getByIdFunction = _.getLFQuestion(_)

  // service related mocks
  def createFunction = _.createLFQuestion()

  def addFunction = _.addLFQuestion(_)

  def deleteFunction = _.deleteLFQuestion(_)

  def updateFunction = _.updateLFQuestion(_)

  def orNull = _.orNull

  def getAllFunction = _.getLFQuestions(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFQuestion]

  def mockEntityProperties(mockEntity: LFQuestion) {
    //categoryID, title, description, explanationText, forceCorrectCount, isCaseSensitive, questionType, courseID, arrangementIndex
    mockIntegerProperty(mockEntity.setCategoryId(_), _.getCategoryId)
    mockStringProperty(mockEntity.setTitle(_), _.getTitle)
    mockStringProperty(mockEntity.setDescription(_), _.getDescription)
    mockBooleanProperty(mockEntity.setForceCorrectCount(_), _.isForceCorrectCount)
    mockBooleanProperty(mockEntity.setCaseSensitive(_), _.isCaseSensitive)
    mockIntegerProperty(mockEntity.setQuestionType(_), _.getQuestionType)
    mockIntegerProperty(mockEntity.setCourseId(_), _.getCourseId)
    mockIntegerProperty(mockEntity.setArrangementIndex(_), _.getArrangementIndex)
  }

  def getIdFunction = _.getId

  mockLocalService.findByCourseIdAndCategoryId(any, any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any) = paramsRaw match {
      case Array(a, b) if a.isInstanceOf[Array[_]] && b.isInstanceOf[Array[_]] => (a, b)
    }

    val courseIds = unwrapArrayInteger(paramsTuple._1)
    val categoryIds = unwrapArrayInteger(paramsTuple._2)

    internalStorage.values.filter(entity => courseIds.contains(
      Option(entity.getCourseId).getOrElse(nullInteger)
    ) && categoryIds.contains(
      Option(entity.getCategoryId).getOrElse(nullInteger)
    )).toList.sortBy(_.getArrangementIndex).asJava
  }

}
