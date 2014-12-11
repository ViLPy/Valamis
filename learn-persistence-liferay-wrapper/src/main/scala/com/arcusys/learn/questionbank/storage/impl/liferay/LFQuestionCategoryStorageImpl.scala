package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.questionbank.model.QuestionCategory
import com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFQuestionCategory
import scala.collection.JavaConverters._
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
@deprecated
trait LFQuestionCategoryStorageImpl extends KeyedEntityStorage[QuestionCategory] {
  protected def doRenew() { LFQuestionCategoryLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(parameters: (String, Any)*) = parameters match {
    case Seq(("courseID", courseId: Int)) => {
      // Liferay ServiceBuilder doesn't support nullable primitives and instead it converts null to 0
      val courseIdsForSearch: Array[java.lang.Integer] = getArrayForIsNullSearch(courseId)
      LFQuestionCategoryLocalServiceUtil.findByCourseId(courseIdsForSearch).asScala.map { extract }.sortBy(_.arrangementIndex)
    }
    case Seq(a: (String, Int), b: (String, Int)) if Set(a._1, b._1) == Set("courseID", "categoryID") => {
      val courseId: Int = parameters.find(_._1 == "courseID").map { _._2.asInstanceOf[Int] }.get
      val parentId: Int = parameters.find(_._1 == "categoryID").map { _._2.asInstanceOf[Int] }.get

      val courseIdsForSearch: Array[java.lang.Integer] = getArrayForIsNullSearch(courseId)
      val parentIdsForSearch: Array[java.lang.Integer] = if (parentId == -1) Array(nullInteger) else Array(new Integer(parentId))

      LFQuestionCategoryLocalServiceUtil.findByCourseIdAndParentId(courseIdsForSearch, parentIdsForSearch).asScala.map { extract }.sortBy(_.arrangementIndex)
    }
  }

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    idParam(parameters: _*).foreach(LFQuestionCategoryLocalServiceUtil.deleteLFQuestionCategory(_))
  }

  def modify(parameters: (String, Any)*) {
    idParam(parameters: _*).flatMap {
      getLFEntityById(_)
    }.foreach {
      lfEntity =>
        parameters foreach {
          param =>
            param match {
              case ("title", title: String)                    => lfEntity.setTitle(title)
              case ("description", description: String)        => lfEntity.setDescription(description)
              case ("id", _)                                   => // do nothing
              case ("arrangementIndex", arrangementIndex: Int) => lfEntity.setArrangementIndex(arrangementIndex)
              case ("parentID", parentID: Option[Int])         => lfEntity.setParentId(parentID)
            }
        }
        LFQuestionCategoryLocalServiceUtil.updateLFQuestionCategory(lfEntity)
    }
  }

  def create(entity: QuestionCategory, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: QuestionCategory, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getByID(id: Int, parameters: (String, Any)*) = Option(LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(id)) map extract

  def createAndGetID(entity: QuestionCategory, parameters: (String, Any)*) = {
    doCreate(entity, parameters: _*).getId.toInt
  }

  def doCreate(entity: QuestionCategory, parameters: (String, Any)*): LFQuestionCategory = {
    (entity, parameters) match {
      case (entity: QuestionCategory, params: Seq[(String, Any)]) => {
        val newEntity = LFQuestionCategoryLocalServiceUtil.createLFQuestionCategory()
        // title, description, parentID, courseID,arrangementIndex
        newEntity.setTitle(entity.title)
        newEntity.setDescription(entity.description)
        newEntity.setCourseId(entity.courseID)
        newEntity.setArrangementIndex(entity.arrangementIndex)
        params.foreach {
          param =>
            param match {
              case ("parentID", parentID: Option[Int])         => newEntity.setParentId(parentID)
              case ("arrangementIndex", arrangementIndex: Int) => newEntity.setArrangementIndex(arrangementIndex)
            }
        }

        LFQuestionCategoryLocalServiceUtil.addLFQuestionCategory(newEntity)
      }
    }
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def extract(lfEntity: LFQuestionCategory) = {
    val qc = QuestionCategory(
      lfEntity.getId.toInt,
      lfEntity.getTitle,
      lfEntity.getDescription,
      Option(lfEntity.getParentId).map(_.toInt),
      Option(lfEntity.getCourseId).map(_.toInt),
      lfEntity.getArrangementIndex
    )
    qc
  }

  private def getLFEntityById(id: Int) = Option(LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(id))
}
