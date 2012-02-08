package com.arcusys.scorm.model.quiz

/*
 * Essay - intended for short answers of a paragraph or two, that one often finds on exams
 */

case class EssayQuestion(id: Int,
                         categoryID: Option[Int],
                         title: String,
                         text: String,
                         explanationText: String,
                         answers: Seq[EssayAnswer]) extends Question[EssayAnswer]

// probably we doesn't need this class, 'cause in these cases we can use only question class
case class EssayAnswer(id: Int) extends Answer