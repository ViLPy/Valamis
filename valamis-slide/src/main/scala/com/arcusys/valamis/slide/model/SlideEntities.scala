package com.arcusys.valamis.slide.model

case class SlideSetEntity(
  id: Long,
  title: String,
  description: String,
  courseId: Option[Long],
  logo: Option[String])
case class SlideEntity(
  id: Long,
  title: String,
  bgColor: Option[String],
  bgImage: Option[String],
  leftSlideId: Option[Long],
  topSlideId: Option[Long],
  slideSetId: Long,
  statementVerb: Option[String],
  statementObject: Option[String],
  statementCategoryId: Option[String])

// We don't construct Slide*Model into hierarchy, because all rendering is done on client-side
// We add extra field slideEntityType, because our serialization erases type information
case class SlideElementEntity(
  id: Long,
  top: String,
  left: String,
  width: String,
  height: String,
  zIndex: String,
  content: String,
  slideEntityType: String,
  slideId: Long,
  correctLinkedSlideId: Option[Long],
  incorrectLinkedSlideId: Option[Long],
  notifyCorrectAnswer: Option[Boolean])