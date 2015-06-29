package com.arcusys.learn.questionbank.storage.impl.liferay

import java.net.URLDecoder

import com.arcusys.learn.persistence.liferay.model.LFQuestion
import com.arcusys.learn.persistence.liferay.service.{ LFAnswerLocalServiceUtil, LFQuestionLocalServiceUtil, LFQuizQuestionLocalServiceUtil }
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
import com.arcusys.valamis.questionbank.model._
import com.arcusys.valamis.questionbank.storage.{ QuestionStorage, QuestionAnswerStorage }

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

  def getByCategory(categoryIdOption: Option[Int], courseIdOption: Option[Int]): Seq[Question[Answer]] = {
    val courseId = courseIdOption.getOrElse(-1)
    val categoryId = categoryIdOption.getOrElse(-1)

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

  def decodeQuestion(entity: Question[Answer]):Unit ={
    val lfEntity = LFQuestionLocalServiceUtil.getLFQuestion(entity.id)
    lfEntity.setExplanationText(URLDecoder.decode(lfEntity.getExplanationText, "UTF-8"))
    lfEntity.setDescription(URLDecoder.decode(lfEntity.getDescription, "UTF-8"))
    LFQuestionLocalServiceUtil.updateLFQuestion(lfEntity)
    entity.answers.map { answer =>
      decodeAnswer(answer)
    }
  }

  def decodeAnswer(entity: Answer): Unit = {
    val lfEntity = LFAnswerLocalServiceUtil.getLFAnswer(entity.id)
    lfEntity.setDescription(URLDecoder.decode(lfEntity.getDescription, "UTF-8"))
    if(entity.isInstanceOf[MatchingAnswer] || entity.isInstanceOf[CategorizationAnswer])
      lfEntity.setMatchingText(URLDecoder.decode(lfEntity.getMatchingText, "UTF-8"))
    LFAnswerLocalServiceUtil.updateLFAnswer(lfEntity)
  }

  private def updateFields(entity: LFQuestion, source: Question[Answer]) {
    entity.setCategoryId(source.categoryID)
    entity.setTitle(source.title)
    entity.setDescription(source.text)
    entity.setExplanationText(source.explanationText)
    entity.setRightAnswerText(source.rightAnswerText)
    entity.setWrongAnswerText(source.wrongAnswerText)
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

  def move(id: Int, index: Int, parentId: Option[Int]): Unit = {
    val questionForUpdate = getByID(id).get
    val forUpdateInNewCategory: Seq[Question[Answer]] = getByCategory(parentId, questionForUpdate.courseID)
    val forUpdateInOldCategory: Seq[Question[Answer]] = getByCategory(questionForUpdate.categoryID, questionForUpdate.courseID)

    val oldIndex = questionForUpdate.arrangementIndex
    val minIndex = oldIndex min index
    val maxIndex = oldIndex max index

    forUpdateInNewCategory.foreach {
      question =>
        if (question.arrangementIndex >= minIndex && question.arrangementIndex <= maxIndex)
          modify(question.id,
            if (index > oldIndex) question.arrangementIndex - 1 else question.arrangementIndex + 1,
            question.categoryID
          )
    }

    if(parentId != questionForUpdate.categoryID) {
      forUpdateInOldCategory.foreach {
        question =>
          if (question.arrangementIndex > oldIndex)
            modify(question.id,
              question.arrangementIndex - 1,
              question.categoryID)
      }
    }

    modify(questionForUpdate.id, index, parentId)
  }

  def moveToCourse(id: Int, courseId: Option[Int], moveInRoot: Boolean) = {
    val lfEntity = LFQuestionLocalServiceUtil.getLFQuestion(id)

    if (lfEntity != null) {
      lfEntity.setCourseId(courseId)

      if (moveInRoot)
        lfEntity.setCategoryId(None)

      LFQuestionLocalServiceUtil.updateLFQuestion(lfEntity)
    }
  }

  private def modify(entityId: Int, arrangementIndex: Int, categoryId: Option[Int]): Unit = {
    val lfEntity = LFQuestionLocalServiceUtil.getLFQuestion(entityId)

    if (lfEntity != null) {
      lfEntity.setArrangementIndex(arrangementIndex)
      lfEntity.setCategoryId(categoryId)

      LFQuestionLocalServiceUtil.updateLFQuestion(lfEntity)
    }
  }

  def delete(id: Int): Unit = {
    LFQuizQuestionLocalServiceUtil.getLFQuizQuestions(-1, -1).asScala.filter(_.getQuestionId == id).foreach(LFQuizQuestionLocalServiceUtil.deleteLFQuizQuestion(_))
    LFQuestionLocalServiceUtil.deleteLFQuestion(id)

    answerStorage.deleteByQuestion(id)
  }

  private def extract(lfEntity: LFQuestion): Question[Answer] = {
    val questionId = lfEntity.getId.toInt
    val categoryId = Option(lfEntity.getCategoryId).map(_.toInt)
    val title = lfEntity.getTitle
    val description = lfEntity.getDescription
    val explanationText = lfEntity.getExplanationText
    val rightAnswerText = lfEntity.getRightAnswerText
    val wrongAnswerText = lfEntity.getWrongAnswerText
    val forceCorrectCount = lfEntity.isForceCorrectCount
    val courseId = Option(lfEntity.getCourseId).map(_.toInt)
    val isCaseSensitive = lfEntity.isCaseSensitive
    val arrangementIndex = lfEntity.getArrangementIndex

    lfEntity.getQuestionType.toInt match {
      case 0 => new ChoiceQuestion(questionId,
        categoryId,
        title,
        description,
        explanationText,
        rightAnswerText,
        wrongAnswerText,
        answerStorage.getByQuestion(questionId).map(e => e.asInstanceOf[ChoiceAnswer]),
        forceCorrectCount,
        courseId,
        arrangementIndex)
      case 1 =>
        new TextQuestion(questionId,
          categoryId,
          title,
          description,
          explanationText,
          rightAnswerText,
          wrongAnswerText,
          answerStorage.getByQuestion(questionId).map(e => e.asInstanceOf[TextAnswer]),
          isCaseSensitive,
          courseId,
          arrangementIndex)
      case 2 => new NumericQuestion(questionId,
        categoryId,
        title,
        description,
        explanationText,
        rightAnswerText,
        wrongAnswerText,
        answerStorage.getByQuestion(questionId).map(e => e.asInstanceOf[NumericAnswer]),
        courseId,
        arrangementIndex)
      case 3 => new PositioningQuestion(questionId,
        categoryId,
        title,
        description,
        explanationText,
        rightAnswerText,
        wrongAnswerText,
        answerStorage.getByQuestion(questionId).map(e => e.asInstanceOf[PositioningAnswer]),
        forceCorrectCount,
        courseId,
        arrangementIndex)
      case 4 => new MatchingQuestion(questionId,
        categoryId,
        title,
        description,
        explanationText,
        rightAnswerText,
        wrongAnswerText,
        answerStorage.getByQuestion(questionId).map(e => e.asInstanceOf[MatchingAnswer]),
        courseId,
        arrangementIndex)
      case 5 => new EssayQuestion(questionId,
        categoryId,
        title,
        description,
        explanationText,
        courseId,
        arrangementIndex)
      case 6 => new EmbeddedAnswerQuestion(questionId,
        categoryId,
        title,
        description,
        explanationText,
        rightAnswerText,
        wrongAnswerText,
        courseId,
        arrangementIndex)
      case 7 => new CategorizationQuestion(questionId,
        categoryId,
        title,
        description,
        explanationText,
        rightAnswerText,
        wrongAnswerText,
        answerStorage.getByQuestion(questionId).map(e => e.asInstanceOf[CategorizationAnswer]),
        courseId,
        arrangementIndex)
      case 8 => new PlainText(questionId,
        categoryId,
        title,
        description,
        courseId,
        arrangementIndex)
      case 9 => new PurePlainText(questionId,
        categoryId,
        title,
        description,
        courseId,
        arrangementIndex)
      case _ => throw new Exception("Oops! Can't create question " + questionId)
    }
  }
}
