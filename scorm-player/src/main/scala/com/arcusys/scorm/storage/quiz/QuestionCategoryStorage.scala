package com.arcusys.scorm.storage.quiz

import com.arcusys.scorm.model.quiz._

trait QuestionCategoryStorage
{
  def getAll: IndexedSeq[QuestionCategory]

  /** Get question category by ID. Returns None if not found*/
  def getByID(id: Int): Option[QuestionCategory]

  /** Get list of subcategories for given parent category ID. For parent ID = None returns list of root categories*/
  def getChildren(parentID: Option[Int]): IndexedSeq[QuestionCategory]

  /** Persist a new category.
   *@return persisted category with DB-assigned fields
   */
  def createCategory(entity: QuestionCategory): QuestionCategory

  /**
   *Persist new property values for category with given ID.
   *@return persisted category with DB-assigned fields
   */
  def modify(entity: QuestionCategory): QuestionCategory

  /**
   *Move and persist category
   *@return persisted category with DB-assigned fields
   */
  def move(id: Int, parentID:Option[Int], siblingID: Option[Int], moveAfterTarget: Boolean): QuestionCategory
  
  /** Delete a category by ID*/
  def delete(id: Int): Unit

  def renew: Unit  
}
