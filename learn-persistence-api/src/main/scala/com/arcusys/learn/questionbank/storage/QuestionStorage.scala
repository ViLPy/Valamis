package com.arcusys.learn.questionbank.storage

import com.arcusys.learn.questionbank.model.{ Question, Answer }

/** Question bank question repository */

trait QuestionStorage {
  /** Get question by ID, or None if not found */
  def getByID(id: Int): Option[Question[Answer]]

  /**
   * Get list of questions for given category in user-defined order
   * @param categoryID ID of category to get questions for, or None to get list of questions in root of bank
   * @param courseID ID of liferay site to get questions for, or None to get list of questions in root of bank
   */
  def getByCategory(categoryID: Option[Int], courseID: Option[Int]): Seq[Question[Answer]]

  /**
   * Create a new question in storage
   * @param entity Question to create (ID field value ignored)
   * @return ID of created question
   */
  def createAndGetID(entity: Question[Answer]): Int

  /** Delete a question by ID */
  def delete(id: Int)
  def modify(entity: Question[Answer])

  /**
   * Set new parent and relative position for question
   * @param id               ID of question to move
   * @param index            Index of question in new category
   * @param parentID         ID of question's new category. None if question should be moved to bank root
   */
  def move(id: Int, index: Int, parentID: Option[Int])
  def moveToCourse(id: Int, courseID: Option[Int], moveInRoot: Boolean)
  def renew()
}
