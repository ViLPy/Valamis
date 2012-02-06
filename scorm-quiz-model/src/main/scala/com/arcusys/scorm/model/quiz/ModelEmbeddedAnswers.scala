package com.arcusys.scorm.model.quiz

/*
 * EmbeddedAnswers - consist of a passage of text (in specific format) that has 
 * various answers embedded within it, including multiple choice, short answers and numerical answers.
 */

case class EmbeddedAnswerQuestion(id: Int,
                                  categoryID: Option[Int],
                                  title: String,
                                  text: String,
                                  explanationText: String,
                                  answers: Seq[EmbeddedAnswer],
                                  position:Int) extends Question[EmbeddedAnswer]

// probably we doesn't need this answer class, 'cause in these cases we can use only question class
case class EmbeddedAnswer(id: Int) extends Answer