package com.arcusys.learn.questionbank.model

/**
 * An option for a Choice question
 * @param id        Unique internal ID of option
 * @param text      Option text
 * @param isCorrect True if this is a correct answer
 */
class ChoiceAnswer(id: Int, val text: String, val isCorrect: Boolean) extends Answer(id)
