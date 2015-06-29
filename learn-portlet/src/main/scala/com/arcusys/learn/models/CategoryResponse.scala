package com.arcusys.learn.models

/**
 * Created by Iliya Tryapitsin on 10.04.2014.
 */
case class CategoryResponse(id: Int,
  title: String,
  description: String,
  parentId: Option[Int],
  categoryType: String = "folder",
  childrenAmount: Int = 0,
  arrangementIndex: Int = 0,
  contentType: String = "category",
  uniqueId: String,
  children: Seq[ContentResponse] = Seq(),
  courseId : Int) extends ContentResponse

trait ContentResponse {
  def contentType: String
  def uniqueId: String
}