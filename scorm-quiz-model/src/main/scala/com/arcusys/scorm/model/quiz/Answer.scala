package com.arcusys.scorm.model.quiz

/*
 * Answer types:
 * Numerical - a numerical question looks just like a short-answer question. The difference is that numerical answers are allowed to have an accepted fixed range error
 * Choice - single/multiple choice question
 * BoundedChoice - multiple choice question which limits number of answers, which user can check (used ChoiceAnswer)
 * EmbeddedAnswers - consist of a passage of text (in specific format) that has various answers embedded within it, including multiple choice, short answers and numerical answers.
 * Essay - intended for short answers of a paragraph or two, that one often finds on exams
 * Matching - have a content area and a list of names or statements which must be correctly matched against another list of names or statements
 * Positioning - user should place answers in the correct order
 * ShortAnswer - the student types in a word or phrase in response to a question. The answer could be a word or a phrase, but it must match one of your acceptable answers exactly
 */

trait Answer {
  val id: Int
}
