package com.arcusys.learn.questionbank.model

/**
 * An option for a Positioning question
 * @param id            Unique internal ID of option/answer
 * @param text          Option text
 * @param isCorrect     True if this option is part of the correct sequence
 */
class PositioningAnswer(id: Int, val text: String, val isCorrect: Boolean) extends Answer(id)