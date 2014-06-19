package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalService
import com.arcusys.learn.persistence.liferay.model.LFQuestionCategory
import com.arcusys.learn.storage.impl.liferay.MockKeyedEntityContainer
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

import scala.collection.JavaConverters._

/**
 * User: dkudinov
 * Date: 20.3.2013
 */

object QuestionCategoryMockEntityContainer extends MockKeyedEntityContainer[LFQuestionCategoryLocalService, LFQuestionCategory] {
  lazy val mockServiceBeanName = classOf[LFQuestionCategoryLocalService].getName
  lazy val mockLocalService = mock[LFQuestionCategoryLocalService]

  // keyed entity - service related mocks
  def getByIdFunction = _.getLFQuestionCategory(_)

  // service related mocks
  def createFunction = _.createLFQuestionCategory()

  def addFunction = _.addLFQuestionCategory(_)

  def deleteFunction = _.deleteLFQuestionCategory(_)

  def updateFunction = _.updateLFQuestionCategory(_)

  def orNull = _.orNull

  def getAllFunction = _.getLFQuestionCategories(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFQuestionCategory]

  def mockEntityProperties(mockEntity: LFQuestionCategory) {
    mockStringProperty(mockEntity.setTitle(_), _.getTitle)
    mockStringProperty(mockEntity.setDescription(_), _.getDescription)
    mockIntegerProperty(mockEntity.setParentId(_), _.getParentId)
    mockIntegerProperty(mockEntity.setCourseId(_), _.getCourseId)
    mockIntProperty(mockEntity.setArrangementIndex(_), _.getArrangementIndex)
  }

  def getIdFunction = _.getId

  mockLocalService.findByCourseId(any) answers { courseIdsRaw =>
    internalStorage.values.filter(entity => unwrapArrayInteger(courseIdsRaw).contains(
      Option(entity.getCourseId).getOrElse(nullInteger)
    )).toList.asJava
  }

  mockLocalService.findByCourseIdAndParentId(any, any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any) = paramsRaw match {
      case Array(a, b) if a.isInstanceOf[Array[_]] && b.isInstanceOf[Array[_]] => (a, b)
    }

    val courseIds = unwrapArrayInteger(paramsTuple._1)
    val parentIds = unwrapArrayInteger(paramsTuple._2)

    internalStorage.values.filter(entity => courseIds.contains(
      Option(entity.getCourseId).getOrElse(nullInteger)
    ) && parentIds.contains(
        Option(entity.getParentId).getOrElse(nullInteger)
      )).toList.sortBy(_.getArrangementIndex).asJava
  }
}
