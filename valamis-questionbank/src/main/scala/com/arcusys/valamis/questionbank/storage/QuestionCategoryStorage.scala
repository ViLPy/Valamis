package com.arcusys.valamis.questionbank.storage

import com.arcusys.valamis.questionbank.model.QuestionCategory

/** Question bank question category repository */
trait QuestionCategoryStorage {
  /** Get all question categories in user-defined order */
  //def getAll: Seq[QuestionCategory]
  def getAllByCourseID(courseID: Option[Int]): Seq[QuestionCategory]

  /** Get question category by ID, or None if not found */
  def getByID(id: Int): Option[QuestionCategory]

  /**
   * Get list of subcategories for given parent category in user-defined order.
   * @param parentID ID of parent category to get subcategories for, or None to get list of root categories
   */
  def getChildren(parentID: Option[Int], courseID: Option[Int]): Seq[QuestionCategory]

  /**
   * Create a new category in storage
   * @param entity Category to create (ID field value ignored)
   * @return ID of created category
   */
  def createAndGetID(entity: QuestionCategory): Int

  /**
   * Update property values for category with given ID in storage
   * @param id          ID of category to update
   * @param title       New title for category
   * @param description New description for category
   */
  def modify(id: Int, title: String, description: String)

  /**
   * Set new parent and relative position for category
   * @param id               ID of category to move
   * @param parentID         ID of category's new parent. None if category should be made root category
   * @param siblingID        ID of category near which the moved category should be placed
   * @param moveAfterSibling True -> place category after the given sibling (after all siblings if siblingID = None), false -> place category before the given sibling (before all siblings if siblingID = None)
   */
  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterSibling: Boolean)
  def move(id: Int, index: Int, parentId: Option[Int] /*, newCourseId: Option[Int]*/ )
  def moveToCourse(id: Int, courseID: Option[Int], parentId: Option[Int])

  /** Delete a category by ID */
  def delete(id: Int)
  def renew()
}
