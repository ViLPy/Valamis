package com.arcusys.learn.questionbank.model

/**
 * An option for a Categorization question
 * @param id                  Unique internal ID of option
 * @param text                Option text
 * @param answerCategoryText  Category text, or None if this value should not match any category
 */
class CategorizationAnswer(id: Int, val text: String, val answerCategoryText: Option[String]) extends Answer(id)