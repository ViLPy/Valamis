package com.arcusys.learn.models.request

import com.arcusys.learn.liferay.permission.PermissionCredentials
import org.scalatra.ScalatraServlet
import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }

import scala.util.Try

object CategoryRequest extends BaseRequest {

  val NewCourseId = "newCourseID"
  val CategoryId = "categoryId"
  val CategoryIds = "categoryIDs"

  val Id = "id"
  val ParentId = "parentId"
  val Categories = "categories"
  val Questions = "questions"
  val Title = "title"
  val Description = "description"
  val Index = "index"
  val DndMode = "dndMode"
  val TargetId = "targetId"
  val ItemType = "itemType"

  def apply(controller: ScalatraServlet) = new Model(controller)

  class Model(controller: ScalatraServlet) {
    implicit val _controller = controller

    def action = {
      Parameter(Action).option match {
        case Some(value) => CategoryActionType.withName(value.toUpperCase)
        case None        => None
      }
    }

    def permissionCredentials = PermissionCredentials(Parameter(CourseId).longRequired, Parameter(PortletId).required, Parameter(PrimaryKey).required)

    def itemType = Parameter(ItemType).required

    def categoryId = Parameter(CategoryId).intOption

    def categoryIds = Parameter(CategoryIds).multiWithEmpty.map(x => Try(x.toInt).get)

    def courseId = Parameter(CourseId).intOption

    def newCourseId = Parameter(NewCourseId).intOption

    def parentId = Parameter(ParentId).intOption

    def id = Parameter(Id).intRequired

    def categoryIdSet = Parameter(Categories).multiRequired.map(x => x.toInt)

    def questionsIdSet = Parameter(Questions).multiRequired.map(x => x.toInt)

    def title = AntiSamyHelper.sanitize(Parameter(Title).required)

    def description = Parameter(Description).option match {
      case Some(value) => AntiSamyHelper.sanitize(value)
      case None        => ""
    }

    def index = Parameter(Index).intRequired

    def targetId = Parameter(TargetId).intRequired

    def dndMode = DndModeType.withName(Parameter(DndMode).required.toUpperCase)
  }

}
