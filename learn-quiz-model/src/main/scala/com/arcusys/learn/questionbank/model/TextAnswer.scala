package com.arcusys.learn.questionbank.model

/**
 * A correct answer to a Text question
 * @param id    Unique internal ID of option/answer
 * @param text  Correct answer string
 */
class TextAnswer(id: Int, val text: String) extends Answer(id)