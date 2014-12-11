package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFAnswer
import com.arcusys.learn.persistence.liferay.service.{ LFAnswerLocalServiceUtil, LFQuizAnswerScoreLocalServiceUtil }
import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.questionbank.storage.QuestionAnswerStorage

import scala.collection.JavaConverters._

/**
 * Created by mminin on 16.09.14.
 */
class QuestionAnswerStorageImpl extends QuestionAnswerStorage {
  def renew(): Unit = {}

  def createForQuestion(questionID: Int, answers: Seq[Answer]) = {
    var position = 0
    for (answer <- answers) {
      position += 1
      createAndGetID(answer, questionID, position)
    }
  }

  def createAndGetID(answer: Answer, questionID: Int, position: Int): Int = {
    val newEntity = LFAnswerLocalServiceUtil.createLFAnswer()

    newEntity.setQuestionId(questionID)

    newEntity.setAnswerPosition(position)

    answer match {
      case e: ChoiceAnswer         => updateFields(newEntity, e)
      case e: TextAnswer           => updateFields(newEntity, e)
      case e: NumericAnswer        => updateFields(newEntity, e)
      case e: PositioningAnswer    => updateFields(newEntity, e)
      case e: MatchingAnswer       => updateFields(newEntity, e)
      case e: CategorizationAnswer => updateFields(newEntity, e)
    }

    val answerID = LFAnswerLocalServiceUtil.addLFAnswer(newEntity).getId.toInt

    for (score <- answer.score) {
      val scoreContainer = LFQuizAnswerScoreLocalServiceUtil.createLFQuizAnswerScore(answerID)
      scoreContainer.setScore(score)
      LFQuizAnswerScoreLocalServiceUtil.updateLFQuizAnswerScore(scoreContainer)
    }

    answerID
  }

  private def updateFields(entry: LFAnswer, source: ChoiceAnswer) {
    entry.setAnswerType(0)
    entry.setDescription(source.text)
    entry.setCorrect(source.isCorrect)
  }

  private def updateFields(entry: LFAnswer, source: TextAnswer) {
    entry.setAnswerType(1)
    entry.setDescription(source.text)
  }

  private def updateFields(entry: LFAnswer, source: NumericAnswer) {
    entry.setAnswerType(2)
    entry.setRangeFrom(source.notLessThan.bigDecimal)
    entry.setRangeTo(source.notGreaterThan.bigDecimal)
  }

  private def updateFields(entry: LFAnswer, source: PositioningAnswer) {
    entry.setAnswerType(3)
    entry.setDescription(source.text)
    entry.setCorrect(source.isCorrect)
  }

  private def updateFields(entry: LFAnswer, source: MatchingAnswer) {
    entry.setAnswerType(4)
    entry.setDescription(source.text)
    for (text <- source.keyText) entry.setMatchingText(text)
  }

  private def updateFields(entry: LFAnswer, source: CategorizationAnswer) {
    entry.setAnswerType(7)
    entry.setDescription(source.text)
    for (text <- source.answerCategoryText) entry.setMatchingText(text)
  }

  def getByQuestion(questionID: Int): Seq[Answer] = {
    LFAnswerLocalServiceUtil.findByQuestionId(questionID).asScala map { extract }
  }

  def deleteByQuestion(questionID: Int) {
    //LFAnswerLocalServiceUtil.removeByQuestionId(questionID)

    LFAnswerLocalServiceUtil.findByQuestionId(questionID).asScala foreach delete
  }

  private def delete(lfAnswer: LFAnswer): Unit = {
    try {
      LFQuizAnswerScoreLocalServiceUtil.deleteLFQuizAnswerScore(lfAnswer.getId)
    } catch { case ignore: Throwable => }

    LFAnswerLocalServiceUtil.deleteLFAnswer(lfAnswer)
  }

  private def extract(lfAnswer: LFAnswer): Answer = {
    val id = lfAnswer.getId.toInt
    val description = lfAnswer.getDescription
    val isCorrect = lfAnswer.isCorrect
    val rangeTo = lfAnswer.getRangeTo
    val rangeFrom = lfAnswer.getRangeFrom
    val matchingText = Option(lfAnswer.getMatchingText)

    lazy val score = getScore(id)

    lfAnswer.getAnswerType.toInt match {
      case 0 => ChoiceAnswer(id,
        description,
        isCorrect,
        score = score)
      case 1 => TextAnswer(id,
        description,
        score = score)
      case 2 => NumericAnswer(id,
        rangeFrom,
        rangeTo,
        score = score)
      case 3 => PositioningAnswer(id,
        description,
        isCorrect,
        score = score)
      case 4 => MatchingAnswer(id,
        description,
        matchingText,
        score = score)
      case 7 => CategorizationAnswer(id,
        description,
        matchingText,
        score = score)
      case _ => throw new Exception("Oops! Can't create answer " + id)
    }
  }

  private def getScore(answerId: Int): Option[Double] = {
    try {
      Some(LFQuizAnswerScoreLocalServiceUtil.getLFQuizAnswerScore(answerId.toLong).getScore.toDouble)
    } catch {
      case ignore: Throwable => None
    }
  }
}
