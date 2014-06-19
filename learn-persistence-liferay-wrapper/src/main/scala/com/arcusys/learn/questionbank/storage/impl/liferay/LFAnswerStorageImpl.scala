package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.questionbank.model.Answer
import com.arcusys.learn.persistence.liferay.service.LFAnswerLocalServiceUtil
import java.math.{ BigDecimal => JavaBigDecimal }
import com.arcusys.learn.persistence.liferay.model.LFAnswer
import scala.collection.JavaConverters._
import com.arcusys.learn.questionbank.storage.impl.AnswerFieldsMapper

/**
 * User: dkudinov
 * Date: 19.3.2013
 */
trait LFAnswerStorageImpl extends KeyedEntityStorage[Answer] {
  protected def doRenew() { LFAnswerLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(parameters: (String, Any)*) = parameters match {
    case Seq(("questionID", questionID: Int)) => LFAnswerLocalServiceUtil.findByQuestionId(questionID).asScala map { extract }
  }

  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException }

  def create(entity: Answer, parameters: (String, Any)*) { throw new UnsupportedOperationException }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("questionID", questionID: Int)) => LFAnswerLocalServiceUtil.removeByQuestionId(questionID)
    }
  }

  def modify(parameters: (String, Any)*) { throw new UnsupportedOperationException }

  def modify(entity: Answer, parameters: (String, Any)*) { throw new UnsupportedOperationException }

  def getByID(id: Int, parameters: (String, Any)*) = Option(LFAnswerLocalServiceUtil.getLFAnswer(id)) map { extract }

  def createAndGetID(entity: Answer, parameters: (String, Any)*) = {
    // Entity parameter is ignored - see Answer_insert.sql
    val newEntity = LFAnswerLocalServiceUtil.createLFAnswer()
    parameters.foreach { param =>
      param match {
        case ("questionID", questionId: Int)                  => newEntity.setQuestionId(questionId)
        case ("answerPosition", position: Int)                => newEntity.setAnswerPosition(position)
        case ("answerType", answerType: Int)                  => newEntity.setAnswerType(answerType)
        case ("description", description: Option[String])     => description.foreach(newEntity.setDescription(_))
        case ("isCorrect", isCorrect: Option[Boolean])        => isCorrect.foreach(newEntity.setCorrect(_))
        case ("rangeFrom", rangeFrom: Option[JavaBigDecimal]) => rangeFrom.foreach { newEntity.setRangeFrom(_) }
        case ("rangeTo", rangeTo: Option[JavaBigDecimal])     => rangeTo.foreach { newEntity.setRangeTo(_) }
        case ("matchingText", text: Option[Option[String]])   => if (text.isDefined) text.get.foreach { newEntity.setMatchingText(_) }
      }

    }
    LFAnswerLocalServiceUtil.addLFAnswer(newEntity).getId.toInt
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def extract(lfEntity: LFAnswer) = {
    createAnswer(lfEntity.getAnswerType, new AnswerFieldsMapper {

      def matchingText = Option(lfEntity.getMatchingText)
      def isCorrect = lfEntity.isCorrect
      def rangeTo = lfEntity.getRangeTo
      def rangeFrom = lfEntity.getRangeFrom
      def description = lfEntity.getDescription
      def id = lfEntity.getId.toInt
    })
  }

  def createAnswer(answerType: Int, fieldMapper: AnswerFieldsMapper): Answer

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException
}
