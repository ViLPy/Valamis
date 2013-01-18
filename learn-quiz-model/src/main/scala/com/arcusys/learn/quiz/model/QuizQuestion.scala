package com.arcusys.learn.quiz.model

import com.arcusys.learn.questionbank.model._

/**
 * A question binding from question bank to quiz
 * @param id            Unique internal ID of question binding
 * @param quizID        ID of quiz this question belongs to
 * @param categoryID    ID of a category this quiz question belongs to, or None if question is in root of quiz
 * @param question      Question bank question
 * @param url           External resource url
 */
class QuizQuestion(val id: Int,
                   val quizID: Int,
                   val categoryID: Option[Int],
                   val question: Option[Question[Answer]],
                   val title: Option[String],
                   val url: Option[String]
                   )