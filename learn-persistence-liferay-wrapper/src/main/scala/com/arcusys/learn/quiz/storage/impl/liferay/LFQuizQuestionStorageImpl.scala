package com.arcusys.learn.quiz.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.quiz.model.QuizQuestion
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestion
import scala.collection.JavaConverters._
import com.arcusys.learn.questionbank.storage.QuestionStorage
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
import com.arcusys.learn.quiz.storage.impl.QuizQuestionFieldsMapper

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait LFQuizQuestionStorageImpl extends KeyedEntityStorage[QuizQuestion] {
  protected def doRenew() { LFQuizQuestionLocalServiceUtil.removeAll() }

  def questionStorage: QuestionStorage

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(parameters: (String, Any)*) = {
    val lfResult = parameters match {
      case Seq(("quizID", quizID: Int)) =>
        LFQuizQuestionLocalServiceUtil.findByQuizID(quizID)
      case Seq(("quizID", quizID: Int), ("categoryID", categoryID: Int)) =>
        LFQuizQuestionLocalServiceUtil.findByQuizAndCategory(quizID, if (categoryID == -1) null else categoryID)
      case _ => LFQuizQuestionLocalServiceUtil.getLFQuizQuestions(-1, -1)
    }
    lfResult.asScala.map { extract }.sortBy(_.arrangementIndex)
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException }

  def delete(parameters: (String, Any)*) {
    idParam(parameters: _*) foreach { LFQuizQuestionLocalServiceUtil.deleteLFQuizQuestion(_) }
  }

  def modify(parameters: (String, Any)*) {
    idParam(parameters: _*).flatMap(getLFEntityById(_)).foreach {
      lfEntity =>
        doUpdateEntity(null, lfEntity, LFQuizQuestionLocalServiceUtil.updateLFQuizQuestion(_), parameters: _*)
    }
  }

  def createAndGetID(entity: QuizQuestion, parameters: (String, Any)*) = doCreate(entity, parameters: _*).getId.toInt

  def createAndGetID(parameters: (String, Any)*): Int = doCreate(null, parameters: _*).getId.toInt

  def getByID(id: Int, parameters: (String, Any)*) = getLFEntityById(id) map { extract }

  private def getLFEntityById(id: Int) = Option(LFQuizQuestionLocalServiceUtil.getLFQuizQuestion(id))

  def create(entity: QuizQuestion, parameters: (String, Any)*) {
    doCreate(entity, parameters: _*)
  }

  private def doCreate(entity: QuizQuestion, parameters: (String, Any)*): LFQuizQuestion = {
    doUpdateEntity(entity, LFQuizQuestionLocalServiceUtil.createLFQuizQuestion(), LFQuizQuestionLocalServiceUtil.addLFQuizQuestion(_), parameters: _*)
  }

  private def doUpdateEntity(entity: QuizQuestion, lfEntity: LFQuizQuestion, update: (LFQuizQuestion) => LFQuizQuestion, parameters: (String, Any)*): LFQuizQuestion = {
    // entity is not used - check QuizQuestion_insert.sql and QuizQuestionEntityStorage
    (entity, parameters) match {
      case (null, _: Seq[(String, Any)]) => {
        parameters.foreach {
          param =>
            param match {
              case ("id", id: Int)                             => lfEntity.setId(id)
              // quizID: Int, categoryID: Option[Int], questionID: Int
              case ("quizID", quizID: Int)                     => lfEntity.setQuizId(quizID)
              case ("categoryID", categoryID: Option[Int])     => lfEntity.setCategoryId(categoryID)
              case ("questionID", questionID: Int)             => lfEntity.setQuestionId(questionID)
              case ("title", title: String)                    => lfEntity.setTitle(title)
              case ("url", url: String)                        => lfEntity.setUrl(url)
              case ("questionType", questionType: String)      => lfEntity.setQuestionType(questionType)
              case ("text", text: String)                      => lfEntity.setPlainText(text)
              case ("autoShowAnswer", flag: Boolean)           => lfEntity.setAutoShowAnswer(flag)
              case ("arrangementIndex", arrangementIndex: Int) => lfEntity.setArrangementIndex(arrangementIndex)
              case ("groupId", groupId: Int)                   => lfEntity.setGroupId(groupId)
            }
        }
        update(lfEntity)
      }
    }
  }

  def extract(entity: LFQuizQuestion) = {
    createQuizQuestion(new QuizQuestionFieldsMapper {
      def questionTypeName = entity.getQuestionType

      def id = entity.getId.toInt
      def quizId = entity.getQuizId
      def categoryId = Option(entity.getCategoryId).map(_.toInt)
      def title = Option(entity.getTitle)
      def url = entity.getUrl
      def text = entity.getPlainText
      def questionId = entity.getQuestionId
      def autoShowAnswer = Option(entity.getAutoShowAnswer).map(_.asInstanceOf[Boolean]).getOrElse(false)
      def arrangementIndex = entity.getArrangementIndex
      def groupId = Option(entity.getGroupId)
    })
  }

  def createQuizQuestion(mapper: QuizQuestionFieldsMapper): QuizQuestion

  def modify(entity: QuizQuestion, parameters: (String, Any)*) {
    parameters match {
      case Seq(("parentID", parentID: Option[Int])) => {
        val lfEntity = LFQuizQuestionLocalServiceUtil.getLFQuizQuestion(entity.id)
        if (parentID.isDefined)
          lfEntity.setCategoryId(parentID.get)
        else
          lfEntity.setCategoryId(null)
        LFQuizQuestionLocalServiceUtil.updateLFQuizQuestion(lfEntity)
      }
      case _ => None
    }
  }

  def idParam(parameters: (String, Any)*): Option[Int] = {
    parameters find {
      _._1 == "id"
    } map { _._2.asInstanceOf[Int] }
  }
}
