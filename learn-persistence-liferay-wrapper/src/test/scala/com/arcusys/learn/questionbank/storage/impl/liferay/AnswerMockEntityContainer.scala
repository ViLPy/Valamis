package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFAnswerLocalService
import com.arcusys.learn.persistence.liferay.model.LFAnswer
import com.arcusys.learn.storage.impl.liferay.MockKeyedEntityContainer

import scala.collection.JavaConverters._

/**
 * User: dkudinov
 * Date: 19.3.2013
 */

object AnswerMockEntityContainer extends MockKeyedEntityContainer[LFAnswerLocalService, LFAnswer] {
  lazy val mockServiceBeanName = classOf[LFAnswerLocalService].getName
  lazy val mockLocalService = mock[LFAnswerLocalService]

  // keyed entity - service related mocks
  def getByIdFunction = _.getLFAnswer(_)

  // service related mocks
  def createFunction = _.createLFAnswer()

  def addFunction = _.addLFAnswer(_)

  def deleteFunction = _.deleteLFAnswer(_)

  def updateFunction = _.updateLFAnswer(_)

  def orNull = _.orNull

  def getAllFunction = _.getLFAnswers(_, _)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFAnswer]

  def mockEntityProperties(mockEntity: LFAnswer) {
    //description, isCorrect, questionID, rangeFrom, rangeTo, matchingText, answerPosition, answerType
    mockStringProperty(mockEntity.setDescription(_), _.getDescription)
    mockBooleanProperty(mockEntity.setCorrect(_), _.isCorrect)
    mockIntegerProperty(mockEntity.setQuestionId(_), _.getQuestionId)
    mockDecimalProperty(mockEntity.setRangeFrom(_), _.getRangeFrom)
    mockDecimalProperty(mockEntity.setRangeTo(_), _.getRangeTo)
    mockStringProperty(mockEntity.setMatchingText(_), _.getMatchingText)
    mockIntegerProperty(mockEntity.setAnswerPosition(_), _.getAnswerPosition)
    mockIntegerProperty(mockEntity.setAnswerType(_), _.getAnswerType)
  }

  def getIdFunction = _.getId

  mockLocalService.findByQuestionId(anyInt) answers { questionIdRaw =>
    findByQuestionId(questionIdRaw).toList.asJava
  }

  def findByQuestionId(questionIdRaw: Any): Iterable[LFAnswer] = {
    internalStorage.values.filter(_.getQuestionId == unwrapNullableInteger(questionIdRaw))
  }

  mockLocalService.removeByQuestionId(anyInt) answers { questionIdRaw =>
    internalStorage --= findByQuestionId(questionIdRaw).map(_.getId)
    ()
  }
}
