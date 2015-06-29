package com.arcusys.learn.quiz.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement
import com.arcusys.valamis.quiz.model.QuizTreeElement
import scala.collection.JavaConverters._

trait LFQuizTreeStorageImpl extends KeyedEntityStorage[QuizTreeElement] {
  protected def doRenew() {
    LFQuizTreeElementLocalServiceUtil.removeAll()
  }

  def extract(lfEntity: LFQuizTreeElement): QuizTreeElement = {
    QuizTreeElement(
      lfEntity.getId.toInt,
      lfEntity.getQuizID,
      lfEntity.getElementID,
      lfEntity.getIsCategory,
      Option(lfEntity.getParentID),
      lfEntity.getArrangementIndex
    )
  }

  override def createAndGetID(entity: QuizTreeElement, parameters: (String, Any)*): Int = {
    val newEntity = LFQuizTreeElementLocalServiceUtil.createLFQuizTreeElement()

    newEntity.setQuizID(entity.quizID)
    newEntity.setElementID(entity.elementID)
    newEntity.setIsCategory(entity.isCategory)
    entity.parentID.foreach(e => newEntity.setParentID(e))
    parameters match {
      case Seq(("arrangementIndex", index: Int)) => newEntity.setArrangementIndex(index)
      case _                                     => newEntity.setArrangementIndex(entity.arrangementIndex)
    }

    LFQuizTreeElementLocalServiceUtil.addLFQuizTreeElement(newEntity).getId.toInt
  }

  override def getByID(id: Int, parameters: (String, Any)*): Option[QuizTreeElement] = {
    Option(LFQuizTreeElementLocalServiceUtil.getLFQuizTreeElement(id)).map(extract)
  }

  override def getOne(parameters: (String, Any)*): Option[QuizTreeElement] = parameters match {
    case Seq(("quizID", quizID: Int), ("elementID", elementID: String)) => {
      Option(LFQuizTreeElementLocalServiceUtil.findByQuizAndElementID(quizID, elementID)).map(extract)
    }
    case _ => None
  }

  override def modify(entity: QuizTreeElement, parameters: (String, Any)*): Unit = {
    val lfEntity = LFQuizTreeElementLocalServiceUtil.getLFQuizTreeElement(entity.id)

    if (entity.parentID.isDefined) lfEntity.setParentID(entity.parentID.get)
    else lfEntity.setParentID(null)
    lfEntity.setArrangementIndex(entity.arrangementIndex)

    LFQuizTreeElementLocalServiceUtil.updateLFQuizTreeElement(lfEntity)
  }

  override def delete(parameters: (String, Any)*): Unit = parameters match {
    case Seq(("id", id: Int)) => {
      LFQuizTreeElementLocalServiceUtil.deleteLFQuizTreeElement(id)
    }
  }

  override def getAll(parameters: (String, Any)*): Seq[QuizTreeElement] = parameters match {
    case Seq(("quizID", quizID: Int)) => {
      LFQuizTreeElementLocalServiceUtil.findByQuizID(quizID).asScala.map(extract)
    }
    case Seq(("quizID", quizID: Int), ("parentID", parentID: String)) => {
      LFQuizTreeElementLocalServiceUtil.findByQuizAndParentID(quizID, parentID).asScala.map(extract)
    }
    case _ => Nil
  }

  override def create(entity: QuizTreeElement, parameters: (String, Any)*): Unit = throw new NotImplementedError()

  override def create(parameters: (String, Any)*): Unit = throw new NotImplementedError()

  override def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new NotImplementedError()

  override def modify(parameters: (String, Any)*): Unit = throw new NotImplementedError()

  override def getAll(sqlKey: String, parameters: (String, Any)*): Seq[QuizTreeElement] = throw new NotImplementedError()

  override def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new NotImplementedError()

  override def getOne(sqlKey: String, parameters: (String, Any)*): Option[QuizTreeElement] = throw new NotImplementedError()

  override def createAndGetID(parameters: (String, Any)*): Int = throw new NotImplementedError()
}
