package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.questionbank.model.{Answer, Question}
import com.arcusys.learn.persistence.liferay.service.{LFQuizQuestionLocalServiceUtil, LFQuestionLocalServiceUtil}
import com.arcusys.learn.persistence.liferay.model.LFQuestion
import com.arcusys.learn.questionbank.storage.impl.QuestionFieldsMapper
import scala.collection.JavaConverters._
import java.lang.{Integer => JavaInteger}
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait LFQuestionStorageImpl extends KeyedEntityStorage[Question[Answer]] {
  protected def doRenew() { LFQuestionLocalServiceUtil.removeAll()}

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(parameters: (String, Any)*) = parameters match {
    case Seq(a: (String, Int), b: (String, Int)) if Set(a._1, b._1) == Set("courseID", "categoryID") => {
      val courseId: Int = parameters.find(_._1 == "courseID").map { _._2.asInstanceOf[Int] }.get
      val categoryID: Int = parameters.find(_._1 == "categoryID").map { _._2.asInstanceOf[Int] }.get

      val courseIdsForSearch: Array[java.lang.Integer] = getArrayForIsNullSearch(courseId)
      val categoryIdsForSearch: Array[java.lang.Integer] = if (categoryID == -1) Array(nullInteger) else Array(new Integer(categoryID))

      LFQuestionLocalServiceUtil.findByCourseIdAndCategoryId(courseIdsForSearch, categoryIdsForSearch).asScala.sortBy(_.getArrangementIndex).map { extract }
    }
  }

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: Question[Answer], parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    idParam(parameters: _*) foreach {id => {
      LFQuizQuestionLocalServiceUtil.getLFQuizQuestions(-1, -1).asScala.filter(_.getQuestionId == id).foreach(LFQuizQuestionLocalServiceUtil.deleteLFQuizQuestion(_))
      LFQuestionLocalServiceUtil.deleteLFQuestion(id)
    }}
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: Question[Answer], parameters: (String, Any)*) {
    getLFEntityById(entity.id).foreach { lfEntity => doUpdate(entity, lfEntity , LFQuestionLocalServiceUtil.updateLFQuestion(_), parameters: _*) }
  }

  private def getLFEntityById(id: Int) = Option(LFQuestionLocalServiceUtil.getLFQuestion(id))

  def getByID(id: Int, parameters: (String, Any)*) = getLFEntityById(id) map { extract }

  def createAndGetID(entity: Question[Answer], parameters: (String, Any)*) = {
    doCreate(entity, parameters: _*).getId.toInt
  }


  private def doCreate(entity: Question[Answer], parameters: (String, Any)*): LFQuestion = {
    doUpdate(entity, LFQuestionLocalServiceUtil.createLFQuestion(), LFQuestionLocalServiceUtil.addLFQuestion(_), parameters: _*)
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def doUpdate(entity: Question[Answer], newEntity: LFQuestion, updateFunction: (LFQuestion) => LFQuestion, parameters: (String, Any)*): LFQuestion = {
    //:e.categoryID, :e.title, :e.text, :e.explanationText, :forceCorrectCount, :isCaseSensitive, :e.questionTypeCode, :e.courseID

    newEntity.setCategoryId(entity.categoryID)
    newEntity.setTitle(entity.title)
    newEntity.setDescription(entity.text)
    newEntity.setExplanationText(entity.explanationText)
    newEntity.setQuestionType(entity.questionTypeCode)
    newEntity.setCourseId(entity.courseID)

    parameters.foreach {
      param => param match {
        case ("categoryID", categoryId: Option[Int]) => newEntity.setCategoryId(categoryId)
        case ("forceCorrectCount", forceCorrectCount: Option[Boolean]) => forceCorrectCount.foreach(newEntity.setForceCorrectCount(_))
        case ("isCaseSensitive", isCaseSensitive: Option[Boolean]) => isCaseSensitive.foreach(newEntity.setCaseSensitive(_))
        case ("arrangementIndex", arrangementIndex: Int) => newEntity.setArrangementIndex(arrangementIndex)
      }
    }

    updateFunction(newEntity)
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException

  private def extract(lfEntity: LFQuestion): Question[Answer] = {
    createQuestion(lfEntity.getQuestionType, new QuestionFieldsMapper {
      def questionID = lfEntity.getId.toInt

      def categoryId = Option(lfEntity.getCategoryId).map(_.toInt)

      def title = lfEntity.getTitle

      def description = lfEntity.getDescription

      def explanationText = lfEntity.getExplanationText

      def forceCorrectCount = lfEntity.isForceCorrectCount

      def courseID = Option(lfEntity.getCourseId).map(_.toInt)

      def isCaseSensitive = lfEntity.isCaseSensitive

      def arrangementIndex = lfEntity.getArrangementIndex
    })
  }

  def createQuestion(answerType: Int, fieldMapper: QuestionFieldsMapper): Question[Answer]
}
