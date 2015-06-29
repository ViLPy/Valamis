package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraServlet

object SlideRequest extends BaseRequest {
  val Id = "id"
  val Page = "page"
  val ItemsOnPage = "itemsOnPage"
  val TitleFilter = "titleFilter"
  val SortTitleAsc = "sortTitleAsc"
  val Title = "title"
  val Description = "description"
  val Logo = "logo"
  val SlideSetId = "slideSetId"
  val SlideId = "slideId"
  val CorrectLinkedSlideId = "correctLinkedSlideId"
  val IncorrectLinkedSlideId = "incorrectLinkedSlideId"
  val NotifyCorrectAnswer = "notifyCorrectAnswer"
  val BgColor = "bgColor"
  val BgImage = "bgImage"
  val LeftSlideId = "leftSlideId"
  val TopSlideId = "topSlideId"
  val SlideEntityType = "slideEntityType"
  val Top = "top"
  val Left = "left"
  val Width = "width"
  val Height = "height"
  val ZIndex = "zIndex"
  val Content = "content"
  val GroupId = "groupId"
  val StatementVerb = "statementVerb"
  val StatementObject = "statementObject"
  val StatementCategoryId = "statementCategoryId"

  def apply(controller: ScalatraServlet) = new Model(controller)

  class Model(controller: ScalatraServlet) {
    implicit val _controller = controller

    def action = Parameter(Action).required
    def id = Parameter(Id).longOption
    def page = Parameter(Page).intRequired
    def itemsOnPage = Parameter(ItemsOnPage).intRequired
    def titleFilter = Parameter(TitleFilter).required
    def sortTitleAsc = Parameter(SortTitleAsc).booleanRequired
    def title = Parameter(Title).option.getOrElse("title")
    def description = Parameter(Description).option.getOrElse("description")
    def logo = Parameter(Logo).option
    def slideSetId = Parameter(SlideSetId).longRequired
    def slideId = Parameter(SlideId).longRequired
    def correctLinkedSlideId = Parameter(CorrectLinkedSlideId).longOption
    def incorrectLinkedSlideId = Parameter(IncorrectLinkedSlideId).longOption
    def notifyCorrectAnswer = Parameter(NotifyCorrectAnswer).booleanOption
    def bgColor = Parameter(BgColor).option
    def bgImage = Parameter(BgImage).option
    def leftSlideId = Parameter(LeftSlideId).longOption
    def topSlideId = Parameter(TopSlideId).longOption
    def slideEntityType = Parameter(SlideEntityType).required
    def top = Parameter(Top).required
    def left = Parameter(Left).required
    def width = Parameter(Width).required
    def height = Parameter(Height).required
    def zIndex = Parameter(ZIndex).required
    def content = Parameter(Content).required
    def courseId = Parameter(CourseId).longRequired
    def courseIdOption = Parameter(CourseId).longOption
    def statementVerb = Parameter(StatementVerb).option
    def statementObject = Parameter(StatementObject).option
    def statementCategoryId = Parameter(StatementCategoryId).option
  }
}
