package com.arcusys.learn.quiz.storage

import com.arcusys.learn.quiz.model._

trait QuizQuestionCategoryStorage {
  /**
   *Get quiz category by ID.
   *@param id ID of category to get
   *@return Category with given ID. None if not found
   */
  def getByID(id: Int): Option[QuizQuestionCategory]

  /**
   *Get list of subcategories for given parent category ID.
   *@param quizID ID of quiz to get subcategories for
   *@param parentID ID of parent category to get subcategories for. If None, return list of root categories
   *@return List of subcategories (for parentID = None - list of root categories)
   */
  def getChildren(quizID:Int, parentID: Option[Int]): Seq[QuizQuestionCategory]

  def getAll: Seq[QuizQuestionCategory]

  /**
   *Create a new category in storage
   *@param entity Category to create (ID field value ignored)
   *@return ID of created category
   */
  def createAndGetID(entity: QuizQuestionCategory): Int

  /**
   *Update property values for category with given ID in storage
   * @param id          ID of category to update
   * @param title       New title for category
   * @param description New description for category
   */
  def modify(id: Int, title: String, description: String)

  /**
   *Set new parent and relative position for category
   *@param id ID of category to move
   *@param parentID ID of category's new parent. None if category should be made root category
   *@param siblingID ID of category near which the moved category should be placed
   *@param moveAfterSibling True -> place category after the given sibling (after all siblings if siblingID = None), false -> place category before the given sibling (before all siblings if siblingID = None)
   *@return Updated category with storage-assigned fields (if any)
   */
  def move(id: Int, parentID:Option[Int], siblingID: Option[Int], moveAfterSibling: Boolean): QuizQuestionCategory
  
  /**
   *Delete a category by ID
   *@param id ID of category to delete
   */
  def delete(id: Int)
  def renew()
}
