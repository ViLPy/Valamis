package com.arcusys.learn.models.request

import org.scalatra.ScalatraServlet
import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }

/**
 * Created by Iliya Tryapitsin on 10.04.2014.
 */
object CategoryRequest extends BaseRequest {
  val ID = "id"
  val PARENT_ID = "parentId"
  val CATEGORY_ID = "categoryId"
  val CATEGORIES = "categories"
  val QUESTIONS = "questions"
  val COURSE_ID = "courseId"
  val TITLE = "title"
  val DESCRIPTION = "description"
  val DND_MODE = "dndMode"
  val TARGET_ID = "targetId"
  val ITEM_TYPE = "itemType"

  def apply(controller: ScalatraServlet) = new Model(controller)

  class Model(controller: ScalatraServlet) {
    implicit val _controller = controller

    def action = {
      Parameter(ACTION).option match {
        case Some(value) => CategoryActionType.withName(value.toUpperCase)
        case None        => None
      }
    }

    def itemType = Parameter(ITEM_TYPE).required

    def categoryId = Parameter(CATEGORY_ID).intOption

    def courseId = Parameter(COURSE_ID).intOption

    def parentId = Parameter(PARENT_ID).intOption

    def id = Parameter(ID).intRequired

    def categoryIDSet = Parameter(CATEGORIES).multiRequired.map(x => x.toInt)

    def questionsIDSet = Parameter(QUESTIONS).multiRequired.map(x => x.toInt)

    def title = AntiSamyHelper.sanitize(Parameter(TITLE).required)

    def description = Parameter(DESCRIPTION).option match {
      case Some(value) => AntiSamyHelper.sanitize(value)
      case None        => ""
    }

    def targetId = Parameter(TARGET_ID).intRequired

    def dndMode = DndModeType.withName(Parameter(DND_MODE).required.toUpperCase)
  }

}
