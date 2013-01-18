package com.arcusys.learn.questionbank.model

/**
 * A category of questions. Used for multilevel grouping of questions
 * @param id            Unique internal ID of category
 * @param title         Title of category (used mostly for admin purposes to quickly find category in list)
 * @param description   A more detailed description of the category used when the admin or tested user need an explanation
 * @param parentID      ID of the parent category, if this is a subcategory. None if category has no parent
 */
class QuestionCategory
(
  val id: Int,
  val title: String,
  val description: String,
  val parentID: Option[Int],
  val courseID: Option[Int]
  )
