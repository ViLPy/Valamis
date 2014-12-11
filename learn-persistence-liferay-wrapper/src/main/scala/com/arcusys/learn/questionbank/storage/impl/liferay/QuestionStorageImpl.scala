package com.arcusys.learn.questionbank.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFQuestion
import com.arcusys.learn.persistence.liferay.service.{ LFQuestionLocalServiceUtil, LFQuizQuestionLocalServiceUtil }
import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.questionbank.storage.{ QuestionAnswerStorage, QuestionStorage }
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

import scala.collection.JavaConverters._

/**
 * Created by mminin on 16.09.14.
 */
abstract class QuestionStorageImpl extends QuestionStorage {
  protected def answerStorage: QuestionAnswerStorage

  def renew(): Unit = {
    answerStorage.renew()
    // doRenew()
  }

  def getByID(id: Int): Option[Question[Answer]] = {
    Option(LFQuestionLocalServiceUtil.getLFQuestion(id)) map extract
  }

  def getByCategory(categoryIDOption: Option[Int], courseIDOption: Option[Int]): Seq[Question[Answer]] = {
    val courseId = courseIDOption.getOrElse(-1)
    val categoryId = categoryIDOption.getOrElse(-1)

    val courseIdsForSearch: Array[java.lang.Integer] = getArrayForIsNullSearch(courseId)
    val categoryIdsForSearch: Array[java.lang.Integer] = if (categoryId == -1) Array(nullInteger) else Array(new Integer(categoryId))

    LFQuestionLocalServiceUtil.findByCourseIdAndCategoryId(courseIdsForSearch, categoryIdsForSearch).asScala.sortBy(_.getArrangementIndex).map { extract }
  }

  def createAndGetID(entity: Question[Answer]): Int = {

    val newEntity = LFQuestionLocalServiceUtil.createLFQuestion()

    updateFields(newEntity, entity)

    newEntity.setArrangementIndex(maxArrangementIndex(getByCategory(entity.categoryID, entity.courseID)) + 1)

    val questionId = LFQuestionLocalServiceUtil.addLFQuestion(newEntity).getId.toInt
    answerStorage.createForQuestion(questionId, entity.answers)

    questionId
  }

  private def updateFields(entity: LFQuestion, source: Question[Answer]) {
    entity.setCategoryId(source.categoryID)
    entity.setTitle(source.title)
    entity.setDescription(source.text)
    entity.setExplanationText(source.explanationText)
    entity.setQuestionType(source.questionTypeCode)
    entity.setCourseId(source.courseID)

    source match {
      case e: ChoiceQuestion      => entity.setForceCorrectCount(e.forceCorrectCount)
      case e: PositioningQuestion => entity.setForceCorrectCount(e.forceCorrectCount)
      case _                      =>
    }

    source match {
      case e: TextQuestion => entity.setCaseSensitive(e.isCaseSensitive)
      case _               =>
    }

  }

  private def maxArrangementIndex(oldChildren: Seq[Question[Answer]]): Int = {
    oldChildren.foldLeft(-1)(_ max _.arrangementIndex)
  }

  def modify(entity: Question[Answer]): Unit = {
    val lfEntity = LFQuestionLocalServiceUtil.getLFQuestion(entity.id)

    if (lfEntity != null) {
      updateFields(lfEntity, entity)

      LFQuestionLocalServiceUtil.updateLFQuestion(lfEntity)

      answerStorage.deleteByQuestion(entity.id)
      answerStorage.createForQuestion(entity.id, entity.answers)
    }
  }

  def move(id: Int, index: Int, parentID: Option[Int]): Unit = {
    val questionForUpdate = getByID(id).get
    val forUpdateInNewCategory: Seq[Question[Answer]] = getByCategory(parentID, questionForUpdate.courseID)
    val forUpdateInOldCategory: Seq[Question[Answer]] = getByCategory(questionForUpdate.categoryID, questionForUpdate.courseID)

    val questionForUpdateIndex = questionForUpdate.arrangementIndex
    val minIndex = questionForUpdateIndex min index
    val maxIndex = questionForUpdateIndex max index

    forUpdateInNewCategory.foreach {
      question =>
        if (question.arrangementIndex >= minIndex && question.arrangementIndex <= maxIndex)
          modify(question.id,
            if (index > questionForUpdateIndex) question.arrangementIndex - 1 else question.arrangementIndex + 1,
            question.categoryID
          )
    }

    forUpdateInOldCategory.foreach {
      question =>
        if (question.arrangementIndex > questionForUpdateIndex)
          modify(question.id,
            question.arrangementIndex - 1,
            question.categoryID)
    }

    modify(questionForUpdate.id, index, parentID)
  }

  def moveToCourse(id: Int, courseID: Option[Int], moveInRoot: Boolean) = {
    val lfEntity = LFQuestionLocalServiceUtil.getLFQuestion(id)

    if (lfEntity != null) {
      lfEntity.setCourseId(courseID)

      if (moveInRoot)
        lfEntity.setCategoryId(None)

      LFQuestionLocalServiceUtil.updateLFQuestion(lfEntity)
    }
  }

  private def modify(entityId: Int, arrangementIndex: Int, categoryID: Option[Int]): Unit = {
    val lfEntity = LFQuestionLocalServiceUtil.getLFQuestion(entityId)

    if (lfEntity != null) {
      lfEntity.setArrangementIndex(arrangementIndex)
      lfEntity.setCategoryId(categoryID)

      LFQuestionLocalServiceUtil.updateLFQuestion(lfEntity)
    }
  }

  def delete(id: Int): Unit = {
    LFQuizQuestionLocalServiceUtil.getLFQuizQuestions(-1, -1).asScala.filter(_.getQuestionId == id).foreach(LFQuizQuestionLocalServiceUtil.deleteLFQuizQuestion(_))
    LFQuestionLocalServiceUtil.deleteLFQuestion(id)

    answerStorage.deleteByQuestion(id)
  }

  private def extract(lfEntity: LFQuestion): Question[Answer] = {
    val questionID = lfEntity.getId.toInt
    val categoryId = Option(lfEntity.getCategoryId).map(_.toInt)
    val title = lfEntity.getTitle
    val description = lfEntity.getDescription
    val explanationText = lfEntity.getExplanationText
    val forceCorrectCount = lfEntity.isForceCorrectCount
    val courseID = Option(lfEntity.getCourseId).map(_.toInt)
    val isCaseSensitive = lfEntity.isCaseSensitive
    val arrangementIndex = lfEntity.getArrangementIndex

    lfEntity.getQuestionType.toInt match {
      case 0 => new ChoiceQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[ChoiceAnswer]),
        forceCorrectCount,
        courseID,
        arrangementIndex)
      case 1 =>
        new TextQuestion(questionID,
          categoryId,
          title,
          description,
          explanationText,
          answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[TextAnswer]),
          isCaseSensitive,
          courseID,
          arrangementIndex)
      case 2 => new NumericQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[NumericAnswer]),
        courseID,
        arrangementIndex)
      case 3 => new PositioningQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[PositioningAnswer]),
        forceCorrectCount,
        courseID,
        arrangementIndex)
      case 4 => new MatchingQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[MatchingAnswer]),
        courseID,
        arrangementIndex)
      case 5 => new EssayQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        courseID,
        arrangementIndex)
      case 6 => new EmbeddedAnswerQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        courseID,
        arrangementIndex)
      case 7 => new CategorizationQuestion(questionID,
        categoryId,
        title,
        description,
        explanationText,
        answerStorage.getByQuestion(questionID).map(e => e.asInstanceOf[CategorizationAnswer]),
        courseID,
        arrangementIndex)
      case 8 => new PlainText(questionID,
        categoryId,
        title,
        description,
        courseID,
        arrangementIndex)
      case 9 => new PurePlainText(questionID,
        categoryId,
        title,
        description,
        courseID,
        arrangementIndex)
      case _ => throw new Exception("Oops! Can't create question " + questionID)
    }
  }
}
