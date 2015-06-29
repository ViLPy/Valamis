package com.arcusys.learn.liferay.update

import java.net.URLDecoder

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess
import com.arcusys.learn.persistence.liferay.service.{LFAttemptDataLocalServiceUtil, LFAnswerLocalServiceUtil, LFQuestionLocalServiceUtil}
import scala.collection.JavaConverters._

class DBUpdater2326 extends LUpgradeProcess with SQLRunner {
  implicit lazy val bindingModule = Configuration

  override def getThreshold = 2326

  override def doUpgrade(): Unit = {
    encodeAnswer()
    encodeQuestions()
    encodeAttemptData()
  }


  private def encodeQuestions(): Unit = {
    LFQuestionLocalServiceUtil.getLFQuestions(-1,-1).asScala.foreach { question =>
      question.setExplanationText(URLDecoder.decode(question .getExplanationText, "UTF-8"))
      question.setDescription(URLDecoder.decode(question.getDescription, "UTF-8"))
      LFQuestionLocalServiceUtil.updateLFQuestion(question)
    }
  }

  private def encodeAnswer(): Unit = {
    LFAnswerLocalServiceUtil.getLFAnswers(-1, -1).asScala.foreach { answer =>
      answer.setDescription(URLDecoder.decode(answer.getDescription, "UTF-8"))
      if(answer.getMatchingText != null)
        answer.setMatchingText(URLDecoder.decode(answer.getMatchingText, "UTF-8"))
      LFAnswerLocalServiceUtil.updateLFAnswer(answer)
    }
  }

  private def encodeAttemptData(): Unit = {
    LFAttemptDataLocalServiceUtil.getLFAttemptDatas(-1, -1).asScala.foreach { attemptData =>
      attemptData.setDataValue(URLDecoder.decode(attemptData.getDataValue, "UTF-8"))
      LFAttemptDataLocalServiceUtil.updateLFAttemptData(attemptData)
    }
  }
}
