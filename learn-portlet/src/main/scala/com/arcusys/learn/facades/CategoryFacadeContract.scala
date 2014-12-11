package com.arcusys.learn.facades

import com.arcusys.learn.models.request.DndModeType._
import com.arcusys.learn.models.CategoryResponse
import com.arcusys.learn.models.Gradebook.PackageGradeResponse

/**
 * Created by Iliya Tryapitsin on 10.04.2014.
 */
trait CategoryFacadeContract {
  def getChild(parentId: Option[Int], courseId: Option[Int]): Seq[CategoryResponse]

  def getChildWithQuestion(parentId: Option[Int],
    courseId: Option[Int],
    questionsIds: Seq[Int],
    categoryIds: Seq[Int])

  def create(title: String,
    description: String,
    parentId: Option[Int],
    courseId: Option[Int]): CategoryResponse

  def delete(id: Int, courseId: Option[Int]): Boolean

  def update(id: Int,
    title: String,
    description: String): CategoryResponse

  def move(id: Int,
    dndMode: DndModeType,
    targetId: Int,
    itemType: String): CategoryResponse

  def moveToCourse(id: Int, courseID: Option[Int], newCourseID: Option[Int])
}
