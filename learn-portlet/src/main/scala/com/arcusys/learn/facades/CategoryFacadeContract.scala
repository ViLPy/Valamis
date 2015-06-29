package com.arcusys.learn.facades

import com.arcusys.learn.models.request.DndModeType._
import com.arcusys.learn.models.{ContentResponse, CategoryResponse}

/**
 * Created by Iliya Tryapitsin on 10.04.2014.
 */
trait CategoryFacadeContract {
  def getChild(parentId: Option[Int], courseId: Option[Int]): Seq[CategoryResponse]

  def getAllContent(parentId: Option[Int], courseId: Option[Int]):Seq[ContentResponse]

  def getContentAmount(parentId: Option[Int], courseId: Option[Int]):Int

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

  @deprecated
  def move(id: Int,
    dndMode: DndModeType,
    targetId: Int,
    itemType: String): CategoryResponse

  def move(id: Int,
    index: Int,
    parentId: Option[Int] /*,
    newCourseId: Option[Int]*/ ): CategoryResponse

  def moveToCourse(id: Int, courseID: Option[Int], newCourseID: Option[Int])
}
