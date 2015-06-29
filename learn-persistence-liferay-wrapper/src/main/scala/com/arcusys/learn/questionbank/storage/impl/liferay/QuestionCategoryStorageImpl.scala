package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFQuestionCategory
import com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalServiceUtil
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
import com.arcusys.valamis.questionbank.model.QuestionCategory
import com.arcusys.valamis.questionbank.storage.QuestionCategoryStorage

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

  override def getAllByCourseID(courseId: Option[Int]): Seq[QuestionCategory] = {
    val courseIdsForSearch: Array[java.lang.Integer] = getArrayForIsNullSearch(courseId.getOrElse(-1))
    LFQuestionCategoryLocalServiceUtil.findByCourseId(courseIdsForSearch).asScala.map { extract }.sortBy(_.arrangementIndex)
  }

  override def delete(id: Int): Unit = {
    LFQuestionCategoryLocalServiceUtil.deleteLFQuestionCategory(id)
  }

  override def createAndGetID(entity: QuestionCategory): Int = {
    val arrangementIndex: Int = maxArrangementIndex(getChildren(entity.parentId, entity.courseId)) + 1

    val newEntity = LFQuestionCategoryLocalServiceUtil.createLFQuestionCategory()
    // title, description, parentId, courseID,arrangementIndex
    newEntity.setTitle(entity.title)
    newEntity.setDescription(entity.description)
    newEntity.setCourseId(entity.courseId)
    //newEntity.setArrangementIndex(entity.arrangementIndex)

    newEntity.setParentId(entity.parentId)
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

  def modifyArrangementIndexAndParent(id: Int, arrangementIndex: Int, parentId: Option[Int]): Unit = {
    for (lfEntity <- Option(LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(id))) {
      lfEntity.setArrangementIndex(arrangementIndex)
      lfEntity.setParentId(parentId)
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

  override def getChildren(parentId: Option[Int], courseId: Option[Int]): Seq[QuestionCategory] = {
    val parentIdsForSearch: Array[java.lang.Integer] = parentId//Array(parentID.orNull)
    match {
      case Some(id: Int) => Array(id)
      case None          => Array(nullInteger)
    }
    val courseIdsForSearch: Array[java.lang.Integer] = courseId match {
      case Some(id: Int) => getArrayForIsNullSearch(courseId.getOrElse(-1))
      case None          => Array(nullInteger)
    }

    LFQuestionCategoryLocalServiceUtil.findByCourseIdAndParentId(courseIdsForSearch, parentIdsForSearch).asScala
      .map { extract }.sortBy(_.arrangementIndex)
  }

  override def moveToCourse(id: Int, courseId: Option[Int], parentId: Option[Int]): Unit = {
    for (lfEntity <- Option(LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(id))) {
      lfEntity.setCourseId(courseId)
      lfEntity.setParentId(parentId)

      LFQuestionCategoryLocalServiceUtil.updateLFQuestionCategory(lfEntity)
    }
  }

  override def move(id: Int, parentId: Option[Int], siblingId: Option[Int], moveAfterTarget: Boolean): Unit = {
    val questionCategoryForUpdate = getByID(id).get

    val oldChildren: Seq[QuestionCategory] = getChildren(parentId, questionCategoryForUpdate.courseId)

    def doMove(forUpdate: Seq[QuestionCategory], forIndex: Seq[QuestionCategory]) {
      forUpdate.foreach {
        questionCategory =>
          modifyArrangementIndex(questionCategory.id, questionCategory.arrangementIndex + 1)
      }
      if (moveAfterTarget)
        modifyArrangementIndexAndParent(questionCategoryForUpdate.id, maxArrangementIndex(forUpdate) + 1, parentId)
      else
        modifyArrangementIndexAndParent(questionCategoryForUpdate.id, maxArrangementIndex(forIndex) + 1, parentId)
    }

    siblingId match {
      case None =>
        if (!moveAfterTarget) {
          doMove(oldChildren, Seq())
        } else {
          doMove(Seq(), oldChildren)
        }
      case Some(a: Int) => {
        val spannedChildren = oldChildren.span(_.id != siblingId.get)
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

  override def move(id: Int, index: Int, parentId: Option[Int] /*, newCourseId: Option[Int]*/ ) = {
    val questionCategoryForUpdate = getByID(id).get

    val forUpdateInNewParent: Seq[QuestionCategory] = getChildren(parentId, questionCategoryForUpdate.courseId)
    val forUpdateInOldParent: Seq[QuestionCategory] = getChildren(questionCategoryForUpdate.parentId, questionCategoryForUpdate.courseId)

    val oldIndex = questionCategoryForUpdate.arrangementIndex
    val minIndex = oldIndex min index
    val maxIndex = oldIndex max index

    forUpdateInNewParent.foreach {
      questionCategory =>
        if (questionCategory.arrangementIndex >= minIndex && questionCategory.arrangementIndex <= maxIndex)
          modify(questionCategory.id,
            if (index > oldIndex) questionCategory.arrangementIndex - 1 else questionCategory.arrangementIndex + 1,
            questionCategory.courseId, questionCategory.parentId
          )
    }

    if(parentId != questionCategoryForUpdate.parentId) {
      forUpdateInOldParent.foreach {
        questionCategory =>
          if (questionCategory.arrangementIndex > oldIndex)
            modify(questionCategory.id,
              questionCategory.arrangementIndex - 1,
              questionCategory.courseId, questionCategory.parentId)
      }
    }

    modify(questionCategoryForUpdate.id, index, questionCategoryForUpdate.courseId, parentId)
  }

  def moveToCourse(id: Int, courseID: Option[Int], moveInRoot: Boolean) = {
    val lfEntity = LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(id)

    if (lfEntity != null) {
      lfEntity.setCourseId(courseID)

      if (moveInRoot)
        lfEntity.setCourseId(None)

      LFQuestionCategoryLocalServiceUtil.updateLFQuestionCategory(lfEntity)
    }
  }

  private def modify(entityId: Int, arrangementIndex: Int, courseId: Option[Int], parentId: Option[Int]): Unit = {
    val lfEntity = LFQuestionCategoryLocalServiceUtil.getLFQuestionCategory(entityId)

    if (lfEntity != null) {
      lfEntity.setArrangementIndex(arrangementIndex)
      lfEntity.setCourseId(courseId)
      lfEntity.setParentId(parentId)

      LFQuestionCategoryLocalServiceUtil.updateLFQuestionCategory(lfEntity)
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
