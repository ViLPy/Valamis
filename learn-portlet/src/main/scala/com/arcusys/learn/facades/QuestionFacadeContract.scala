package com.arcusys.learn.facades

import com.arcusys.learn.models.{ AnswerResponse, QuestionResponse }

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
trait QuestionFacadeContract {
  def getByID(id: Int): QuestionResponse

  def getChildren(id: Option[Int], courseID: Option[Int]): Seq[QuestionResponse]

  def create(categoryId: Option[Int],
    questionType: Int,
    title: String,
    text: String,
    explanationText: String,
    forceCorrectCount: Boolean,
    isCaseSensitive: Boolean,
    courseID: Option[Int]): QuestionResponse

  def update(id: Int,
    categoryId: Option[Int],
    questionType: Int,
    title: String,
    text: String,
    explanationText: String,
    forceCorrectCount: Boolean,
    isCaseSensitive: Boolean,
    courseID: Option[Int],
    answers: List[AnswerResponse]): QuestionResponse

  def delete(id: Int)

  def move(id: Int,
    dndMode: String,
    targetID: Option[Int],
    itemType: String)
}
