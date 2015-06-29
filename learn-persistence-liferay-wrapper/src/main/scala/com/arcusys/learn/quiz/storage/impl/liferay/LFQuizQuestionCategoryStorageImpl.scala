package com.arcusys.learn.quiz.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.{ LFQuizQuestCatLocalServiceUtil, LFQuizQuestionLocalServiceUtil }
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat
import com.arcusys.valamis.quiz.model.QuizQuestionCategory
import scala.collection.JavaConverters._
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
import com.arcusys.learn.liferay.constants.QueryUtilHelper._

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait LFQuizQuestionCategoryStorageImpl extends KeyedEntityStorage[QuizQuestionCategory] {
  protected def doRenew() {
    LFQuizQuestCatLocalServiceUtil.removeAll()
  }

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("quizID", quizId: Int), ("parentID", parentId: Int)) =>
        val parentIdForSearch = if (parentId == -1) nullInteger else new Integer(parentId)
        LFQuizQuestCatLocalServiceUtil.findByQuizIdAndParentId(quizId, parentIdForSearch).asScala.map {
          extract
        }.sortBy(_.arrangementIndex)
      case Seq(("parentID", parentId: Int)) =>
        throw new UnsupportedOperationException("Quiz ID should be declared!")
      case _ => LFQuizQuestCatLocalServiceUtil.getLFQuizQuestCats(ALL_POS, ALL_POS).asScala.map(extract).sortBy(_.arrangementIndex)
    }
  }

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    idParam(parameters: _*).foreach(id => {
      val category = LFQuizQuestCatLocalServiceUtil.getLFQuizQuestCat(id)
      if (category != null) {
        val quizID = category.getQuizId
        val questions = LFQuizQuestionLocalServiceUtil.findByQuizAndCategory(quizID, category.getId.toInt).asScala
        questions.foreach(q => LFQuizQuestionLocalServiceUtil.deleteLFQuizQuestion(q.getId))
        val children = LFQuizQuestCatLocalServiceUtil.findByQuizIdAndParentId(quizID, id).asScala
        children.foreach(c => delete("id" -> c.getId.toInt))
      }
      LFQuizQuestCatLocalServiceUtil.deleteLFQuizQuestCat(id)
    })
  }

  def modify(parameters: (String, Any)*) {
    idParam(parameters: _*).flatMap {
      getLFEntityById
    }.foreach {
      lfEntity => doUpdateEntity(null, lfEntity, LFQuizQuestCatLocalServiceUtil.updateLFQuizQuestCat, parameters: _*)
    }
  }

  private def getLFEntityById(id: Int) = Option(LFQuizQuestCatLocalServiceUtil.getLFQuizQuestCat(id))

  def createAndGetID(entity: QuizQuestionCategory, parameters: (String, Any)*) = {
    doCreate(entity, parameters: _*).getId.toInt
  }

  private def doCreate(entity: QuizQuestionCategory, parameters: (String, Any)*) = {
    doUpdateEntity(entity, LFQuizQuestCatLocalServiceUtil.createLFQuizQuestionCategory(), LFQuizQuestCatLocalServiceUtil.addLFQuizQuestCat, parameters: _*)
  }

  private def doUpdateEntity(entity: QuizQuestionCategory, lfEntity: LFQuizQuestCat,
    update: (LFQuizQuestCat) => LFQuizQuestCat,
    parameters: (String, Any)*): LFQuizQuestCat = {
    (entity, parameters) match {
      case (entity: QuizQuestionCategory, params: Seq[(String, Any)]) =>
        //title: String, description: String, quizID: Int, parentID: Option[Int]
        lfEntity.setTitle(entity.title)
        lfEntity.setDescription(entity.description)
        lfEntity.setQuizId(entity.quizID)

        params.foreach {
          case ("parentID", parentId: Option[Int])         => lfEntity.setParentId(parentId)
          case ("arrangementIndex", arrangementIndex: Int) => lfEntity.setArrangementIndex(arrangementIndex)
        }
        update(lfEntity)

      case (null, params: Seq[(String, Any)]) =>
        params.foreach {
          case ("id", _)                            => () // skip
          case ("title", title: String)             => lfEntity.setTitle(title)
          case ("description", description: String) => lfEntity.setDescription(description)
          case ("parentID", parentId: Option[Int]) =>
            if (parentId.isDefined) {
              lfEntity.setParentId(parentId.get)
            } else {
              lfEntity.setParentId(nullInteger)
            }
          case ("arrangementIndex", arrangementIndex: Int) => lfEntity.setArrangementIndex(arrangementIndex)
        }
        update(lfEntity)
    }
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getByID(id: Int, parameters: (String, Any)*) = getLFEntityById(id) map {
    extract
  }

  def create(entity: QuizQuestionCategory, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: QuizQuestionCategory, parameters: (String, Any)*) {
    parameters match {
      case Seq(("parentID", parentID: Option[Int])) =>
        val lfEntity = LFQuizQuestCatLocalServiceUtil.getLFQuizQuestCat(entity.id)
        if (parentID.isDefined)
          lfEntity.setParentId(parentID.get)
        else
          lfEntity.setParentId(null)
        LFQuizQuestCatLocalServiceUtil.updateLFQuizQuestCat(lfEntity)
      case _ => None
    }
  }

  def extract(lfentity: LFQuizQuestCat) = QuizQuestionCategory(
    lfentity.getId.toInt,
    lfentity.getTitle,
    lfentity.getDescription,
    lfentity.getQuizId.toInt,
    Option(lfentity.getParentId).map(_.toInt),
    lfentity.getArrangementIndex
  )

  // for some reason, compiler gives an error in Maven build if this function is moved to package object
  def idParam(parameters: (String, Any)*): Option[Int] = {
    parameters find {
      _._1 == "id"
    } map {
      _._2.asInstanceOf[Int]
    }
  }

}
