package com.arcusys.learn.questionbank.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import com.arcusys.learn.persistence.liferay.service.{LFAnswerLocalServiceUtil, LFAnswerLocalService}
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.questionbank.model.{CategorizationAnswer, NumericAnswer, Answer}
import java.math.{BigDecimal => JavaBigDecimal}
import com.arcusys.learn.questionbank.storage.impl.AnswerCreator
import org.specs2.matcher.Matchers
import com.arcusys.learn.persistence.liferay.model.LFAnswer
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer
import org.specs2.specification.Step
import com.arcusys.learn.liferay.LiferayClasses._

/**
 * User: dkudinov
 * Date: 19.3.2013
 */
class LFAnswerStorageSpec extends SpecificationWithJUnit with CrudVerifier[LFAnswerLocalService, LFAnswer] {
  override val checkUpdate = false
  override val checkDelete = false

  val mockEntityContainer: MockEntityContainer[LFAnswerLocalService, LFAnswer] = AnswerMockEntityContainer
  val storage: KeyedEntityStorage[Answer] = new LFAnswerStorageImpl with AnswerCreator {}

  "Mockito" should {
    "mock service method" in {
      LFAnswerLocalServiceUtil.createLFAnswer() must not (throwAn[Exception]) and {
        there was atLeastOne(mockEntityContainer.mockLocalService).createLFAnswer()
      }

    }
  }

  "LFAnswerStorage" should {
    "storeAndGet same entity" in {
      val answerType: Int = 2
      val rangeFrom: Option[java.math.BigDecimal] = Some(new java.math.BigDecimal(123))
      val questionId: Int = 123
      val id = createAnswer(questionId, answerType = answerType, rangeFrom = rangeFrom)

      val answer: Option[Answer] = storage.getByID(id)
      answer must beSome

      answer.get.asInstanceOf[NumericAnswer].notLessThan must beEqualTo(BigDecimal(rangeFrom.get))
    }

    "extract different types by different answer types" in {
      val type1: Option[Answer] = storage.getByID(createAnswer(1234, answerType = 2 /* NumericAnswer */))
      val type2: Option[Answer] = storage.getByID(createAnswer(1234, answerType = 7 /* CategorizationAnswer */))

      (type1 must beSome ) and (type2 must beSome)

      (type1.get.isInstanceOf[NumericAnswer] must beTrue) and (type2.get.isInstanceOf[CategorizationAnswer] must beTrue)
    }

    "return all and delete all by QuestionId" in {
      val questionId: Int = 123456
      val ids = Seq(createAnswer(questionId), createAnswer(questionId, answerPosition = 2))

      storage.getAll("questionID" -> questionId).map(_.id) must containTheSameElementsAs(ids)

      storage.delete("questionID" -> questionId)

      storage.getAll("questionID" -> questionId) must beEqualTo(Seq())
    }
  }



  private def createAnswer(questionId: Int,
                   answerPosition: Int = 1,
                   answerType: Int = 1,
                   description: Option[String] = Some("description"),
                   isCorrect: Option[Boolean] = Some(true),
                   rangeFrom: Option[JavaBigDecimal] = None,
                   rangeTo: Option[JavaBigDecimal] = None,
                   matchingText: Option[String] = Some("text")): Int = {
    storage.createAndGetID(null.asInstanceOf[Answer],
      "questionID" -> questionId,
      "answerPosition" -> answerPosition,
      "answerType" -> answerType,
      "description" -> description,
      "isCorrect" -> isCorrect,
      "rangeFrom" -> rangeFrom,
      "rangeTo" -> rangeTo,
      "matchingText" -> Some(matchingText)
    )
  }

}

trait CrudVerifier[A <: LBaseLocalService, B <: LBaseModel[B]] extends DelayedInit with Mockito with Matchers {
  val checkCreate = true
  val checkUpdate = true
  val checkDelete = true

  def mockEntityContainer: MockEntityContainer[A, B]

  def step(a: =>Any): Step

  def delayedInit(body: => Unit) {
    body
    if (checkCreate) step(verifyCreateFunction())
    if (checkUpdate) step(verifyUpdateFunction())
    if (checkDelete) step(verifyDeleteFunction())
  }

    /**
   * Check function to be used called from tests for checking, that creates performed right
   * @return
   */
  def verifyCreateFunction() = {
      there was mockEntityContainer.createFunction(atLeastOne(mockEntityContainer.mockLocalService)) and {
        there was mockEntityContainer.addFunction(atLeastOne(mockEntityContainer.mockLocalService), any)
      }
  }

  def verifyUpdateFunction() = {
    there was mockEntityContainer.updateFunction(atLeastOne(mockEntityContainer.mockLocalService), any)
  }

  def verifyDeleteFunction() = {
    there was mockEntityContainer.deleteFunction(atLeastOne(mockEntityContainer.mockLocalService), anyInt)
  }
}
