package com.arcusys.learn.quiz.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFQuizLocalService
import com.arcusys.learn.persistence.liferay.model.LFQuiz
import com.arcusys.learn.storage.impl.liferay.MockKeyedEntityContainer
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

import scala.collection.JavaConverters._

/**
 * User: dkudinov
 * Date: 18.3.2013
 */

object QuizMockEntityContainer extends MockKeyedEntityContainer[LFQuizLocalService, LFQuiz] {
  lazy val mockServiceBeanName = classOf[LFQuizLocalService].getName
  lazy val mockLocalService = mock[LFQuizLocalService]

  def createFunction = _.createLFQuiz()
  def addFunction = _.addLFQuiz(_)
  def deleteFunction = _.deleteLFQuiz(_)
  def updateFunction = _.updateLFQuiz(_)
  def getByIdFunction = _.getLFQuiz(_)
  def getAllFunction = _.getLFQuizs(_, _)
  def removeAllFunction = _.removeAll()
  def orNull = _.orNull

  def createMockEntity(): LFQuiz = mock[LFQuiz]

  def mockEntityProperties(mockEntity: LFQuiz) {
    mockStringProperty(mockEntity.setTitle(_), _.getTitle)
    mockStringProperty(mockEntity.setDescription(_), _.getDescription)
    mockStringProperty(mockEntity.setWelcomePageContent(_), _.getWelcomePageContent)
    mockStringProperty(mockEntity.setFinalPageContent(_), _.getFinalPageContent)
    mockIntegerProperty(mockEntity.setCourseID(_), _.getCourseID)
  }

  override def getIdFunction = {
    entity: LFQuiz => entity.getId
  }

  mockLocalService.findByCourseId(any) answers { courseIdsRaw =>
    internalStorage.values.filter(entity => unwrapArrayInteger(courseIdsRaw).contains(
      Option(entity.getCourseID).getOrElse(nullInteger)
    )).toList.asJava
  }
}
