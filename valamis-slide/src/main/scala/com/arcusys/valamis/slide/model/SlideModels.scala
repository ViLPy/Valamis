package com.arcusys.valamis.slide.model

case class SlideSetModel(
  id: Option[Long] = None,
  title: String = "",
  description: String = "",
  courseId: Option[Long] = None,
  logo: Option[String] = None,
  slides: List[SlideModel] = List())

case class SlideModel(
  id: Option[Long] = None,
  title: String = "Page",
  bgColor: Option[String] = None,
  bgImage: Option[String] = None,
  leftSlideId: Option[Long] = None,
  topSlideId: Option[Long] = None,
  slideElements: List[SlideElementModel] = List(),
  slideSetId: Long,
  statementVerb: Option[String] = None,
  statementObject: Option[String] = None,
  statementCategoryId: Option[String] = None)

object SlideEntityType {
  val Text = "text"
  val Iframe = "iframe"
  val Question = "question"
  val Image = "image"
  val Video = "video"
  val Pdf = "pdf"
  val Math = "math"
  val AvailableTypes = Text :: Iframe :: Question :: Image :: Video :: Pdf :: Math :: Nil
  val AvailableExternalFileTypes = Image :: Pdf :: Nil
}

// We don't construct Slide*Model into hierarchy, because all rendering is done on client-side
// We add extra field slideEntityType, because our serialization erases type information
case class SlideElementModel(
  id: Option[Long] = None,
  top: String = "0",
  left: String = "0",
  width: String = "800",
  height: String = "auto",
  zIndex: String = "1",
  content: String = "",
  slideEntityType: String,
  slideId: Long,
  correctLinkedSlideId: Option[Long] = None,
  incorrectLinkedSlideId: Option[Long] = None,
  notifyCorrectAnswer: Option[Boolean] = None)
