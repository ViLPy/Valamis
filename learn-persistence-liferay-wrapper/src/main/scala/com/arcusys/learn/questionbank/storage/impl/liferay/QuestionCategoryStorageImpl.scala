package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFQuestionCategory
import com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalServiceUtil
import com.arcusys.learn.questionbank.model.QuestionCategory
import com.arcusys.learn.questionbank.storage.QuestionCategoryStorage
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

import scala.collection.JavaConverters._
/**
 * Created by mminin on 15.10.14.
 */
class QuestionCategoryStorageImpl extends QuestionCategoryStorage {

  override def renew(): Unit = {
    LFQuestionCategoryLocalServiceUtil.removeAll()
  }

  override def getByID(id: Int): Option[QuestionCategory] = {
    Option(LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(id)) map extract
  }

  override def getAllByCourseID(courseID: Option[Int]): Seq[QuestionCategory] = {
    val courseIdsForSearch: Array[java.lang.Integer] = getArrayForIsNullSearch(courseID.getOrElse(-1))
    LFQuestionCategoryLocalServiceUtil.findByCourseId(courseIdsForSearch).asScala.map { extract }.sortBy(_.arrangementIndex)
  }

  override def delete(id: Int): Unit = {
    LFQuestionCategoryLocalServiceUtil.deleteLFQuestionCategory(id)
  }

  override def createAndGetID(entity: QuestionCategory): Int = {
    val arrangementIndex: Int = maxArrangementIndex(getChildren(entity.parentID, entity.courseID)) + 1

    val newEntity = LFQuestionCategoryLocalServiceUtil.createLFQuestionCategory()
    // title, description, parentID, courseID,arrangementIndex
    newEntity.setTitle(entity.title)
    newEntity.setDescription(entity.description)
    newEntity.setCourseId(entity.courseID)
    //newEntity.setArrangementIndex(entity.arrangementIndex)

    newEntity.setParentId(entity.parentID)
    newEntity.setArrangementIndex(arrangementIndex)

    val createdEntity = LFQuestionCategoryLocalServiceUtil.addLFQuestionCategory(newEntity)
    createdEntity.getId.toInt
  }

  def modifyArrangementIndex(id: Int, arrangementIndex: Int): Unit = {
    for (lfEntity <- Option(LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(id))) {
      lfEntity.setArrangementIndex(arrangementIndex)
      LFQuestionCategoryLocalServiceUtil.updateLFQuestionCategory(lfEntity)
    }
  }

  def modifyArrangementIndexAndParent(id: Int, arrangementIndex: Int, parentID: Option[Int]): Unit = {
    for (lfEntity <- Option(LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(id))) {
      lfEntity.setArrangementIndex(arrangementIndex)
      lfEntity.setParentId(parentID)
      LFQuestionCategoryLocalServiceUtil.updateLFQuestionCategory(lfEntity)
    }
  }

  override def modify(id: Int, title: String, description: String): Unit = {
    for (lfEntity <- Option(LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(id))) {
      lfEntity.setTitle(title)
      lfEntity.setDescription(description)
      LFQuestionCategoryLocalServiceUtil.updateLFQuestionCategory(lfEntity)
    }
  }

  override def getChildren(parentID: Option[Int], courseID: Option[Int]): Seq[QuestionCategory] = {
    val parentIdsForSearch: Array[java.lang.Integer] = parentID match {
      case Some(id: Int) => getArrayForIsNullSearch(parentID.getOrElse(-1))
      case None          => Array(nullInteger)
    }
    val courseIdsForSearch: Array[java.lang.Integer] = courseID match {
      case Some(id: Int) => getArrayForIsNullSearch(courseID.getOrElse(-1))
      case None          => Array(nullInteger)
    }

    LFQuestionCategoryLocalServiceUtil.findByCourseIdAndParentId(courseIdsForSearch, parentIdsForSearch).asScala
      .map { extract }.sortBy(_.arrangementIndex)
  }

  override def moveToCourse(id: Int, courseID: Option[Int]): Unit = {
    for (lfEntity <- Option(LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(id))) {
      lfEntity.setCourseId(courseID)
      LFQuestionCategoryLocalServiceUtil.updateLFQuestionCategory(lfEntity)
    }
  }

  override def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterTarget: Boolean): Unit = {
    val questionCategoryForUpdate = getByID(id).get

    val oldChildren: Seq[QuestionCategory] = getChildren(parentID, questionCategoryForUpdate.courseID)

    def doMove(forUpdate: Seq[QuestionCategory], forIndex: Seq[QuestionCategory]) {
      forUpdate.foreach {
        questionCategory =>
          modifyArrangementIndex(questionCategory.id, questionCategory.arrangementIndex + 1)
      }
      if (moveAfterTarget)
        modifyArrangementIndexAndParent(questionCategoryForUpdate.id, maxArrangementIndex(forUpdate) + 1, parentID)
      else
        modifyArrangementIndexAndParent(questionCategoryForUpdate.id, maxArrangementIndex(forIndex) + 1, parentID)
    }

    siblingID match {
      case None =>
        if (!moveAfterTarget) {
          doMove(oldChildren, Seq())
        } else {
          doMove(Seq(), oldChildren)
        }
      case Some(a: Int) => {
        val spannedChildren = oldChildren.span(_.id != siblingID.get)
        if (!moveAfterTarget) {
          val forIndex = spannedChildren._1
          val forUpdate = spannedChildren._2
          doMove(forUpdate, forIndex)
        } else {
          val forIndex = spannedChildren._1 ++ spannedChildren._2.headOption
          val forUpdate = if (spannedChildren._2.isEmpty) Nil else spannedChildren._2.tail
          doMove(forUpdate, forIndex)
        }
      }
    }
  }

  private def extract(lfEntity: LFQuestionCategory) = {
    QuestionCategory(
      lfEntity.getId.toInt,
      lfEntity.getTitle,
      lfEntity.getDescription,
      Option(lfEntity.getParentId).map(_.toInt),
      Option(lfEntity.getCourseId).map(_.toInt),
      lfEntity.getArrangementIndex
    )
  }

  private def maxArrangementIndex(oldChildren: Seq[QuestionCategory]): Int = {
    oldChildren.foldLeft(0)(_ max _.arrangementIndex)
  }
}
