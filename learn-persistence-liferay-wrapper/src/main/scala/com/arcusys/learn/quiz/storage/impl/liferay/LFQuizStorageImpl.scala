package com.arcusys.learn.quiz.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.quiz.model.Quiz
import com.arcusys.learn.persistence.liferay.service.{ LFQuizQuestionCategoryLocalServiceUtil, LFQuizLocalServiceUtil }
import com.arcusys.learn.persistence.liferay.model.LFQuiz
import scala.collection.JavaConverters._
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
import com.arcusys.learn.quiz.storage.QuizQuestionCategoryStorage

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait LFQuizStorageImpl extends KeyedEntityStorage[Quiz] {
  protected def doRenew() {
    LFQuizLocalServiceUtil.removeAll()
  }

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(parameters: (String, Any)*) = parameters match {
    case Seq(("courseID", courseId: Int)) => {
      // Liferay ServiceBuilder doesn't support nullable primitives and instead it converts null to 0
      val courseIdsForSearch: Array[java.lang.Integer] = getArrayForIsNullSearch(courseId)
      LFQuizLocalServiceUtil.findByCourseId(courseIdsForSearch).asScala.map(extract)
    }
    case _ => LFQuizLocalServiceUtil.getLFQuizs(-1, -1).asScala.map(extract)
  }

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    parameters.find(_._1 == "id").map(_._2.asInstanceOf[Int]) foreach {
      id =>
        {
          LFQuizQuestionCategoryLocalServiceUtil.findByQuizId(id).asScala.foreach(cat => LFQuizQuestionCategoryLocalServiceUtil.deleteLFQuizQuestionCategory(cat.getId))
          LFQuizLocalServiceUtil.deleteLFQuiz(id)
        }
    }
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getByID(id: Int, parameters: (String, Any)*) = Option(LFQuizLocalServiceUtil.getLFQuiz(id)) map extract

  def createAndGetID(entity: Quiz, parameters: (String, Any)*) = doCreate(entity, parameters: _*).getId.toInt

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException("Entity expected, use create(entity)")

  def create(entity: Quiz, parameters: (String, Any)*) {
    doCreate(entity, parameters: _*)
  }

  private def doCreate(entity: Quiz, parameters: (String, Any)*) = {
    val lfEntity: LFQuiz = LFQuizLocalServiceUtil.createLFQuiz()
    lfEntity.setCourseID(entity.courseID)
    lfEntity.setLogo(entity.logo)
    doUpdateEntity(entity, lfEntity, LFQuizLocalServiceUtil.addLFQuiz(_), parameters: _*)
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  private def doUpdateEntity(entity: Quiz, lfEntity: LFQuiz, update: (LFQuiz) => LFQuiz, parameters: (String, Any)*): LFQuiz = {
    // only empty parameters list is supported for Quiz entity creation - check ORBroker's sql template: Quiz_insert.sql
    (entity, parameters) match {
      case (entity: Quiz, Seq()) => {
        lfEntity.setTitle(entity.title)
        lfEntity.setDescription(entity.description)
        lfEntity.setWelcomePageContent(entity.welcomePageContent)
        lfEntity.setFinalPageContent(entity.finalPageContent)
        lfEntity.setLogo(entity.logo)
        update(lfEntity)
      }
    }
  }

  def modify(entity: Quiz, parameters: (String, Any)*) {
    Option(LFQuizLocalServiceUtil.getLFQuiz(entity.id)).foreach {
      lfEntity => doUpdateEntity(entity, lfEntity, LFQuizLocalServiceUtil.updateLFQuiz(_), parameters: _*)
    }
  }

  def extract(entity: LFQuiz) = new Quiz(
    entity.getId.toInt,
    entity.getTitle,
    entity.getDescription,
    entity.getWelcomePageContent,
    entity.getFinalPageContent,
    Option(entity.getCourseID).map(_.toInt),
    entity.getLogo)
}
