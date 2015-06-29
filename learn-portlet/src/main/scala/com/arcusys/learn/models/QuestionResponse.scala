package com.arcusys.learn.models

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
case class QuestionResponse(id: Int,
  entityType: String,
  title: String,
  text: String,
  explanationText: String,
  rightAnswerText: String,
  wrongAnswerText: String,
  forceCorrectCount: Boolean,
  isCaseSensitive: Boolean,
  answers: Seq[AnswerResponse],
  questionType: Int,
  categoryID: Option[Int],
  arrangementIndex: Int = 0,
  contentType:String = "question",
  uniqueId: String,
  courseId: Int) extends ContentResponse

