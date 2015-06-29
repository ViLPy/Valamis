package com.arcusys.valamis.slide.service

import com.arcusys.valamis.slide.model._

object SlideModelConverters {
  implicit def slideSetModelConversion(entity: SlideSetEntity, slides: List[SlideModel]) =
    SlideSetModel(Some(entity.id), entity.title, entity.description, entity.courseId, entity.logo, slides)

  def slideModelConversion(entity: SlideEntity, slideElements: List[SlideElementModel]) =
    SlideModel(
      Some(entity.id),
      entity.title,
      entity.bgColor,
      entity.bgImage,
      entity.leftSlideId,
      entity.topSlideId,
      slideElements,
      entity.slideSetId,
      entity.statementVerb,
      entity.statementObject,
      entity.statementCategoryId
    )

  implicit def slideElementModelConversion(entity: SlideElementEntity) =
    SlideElementModel(
      Some(entity.id),
      entity.top,
      entity.left,
      entity.width,
      entity.height,
      entity.zIndex,
      entity.content,
      entity.slideEntityType,
      entity.slideId,
      entity.correctLinkedSlideId,
      entity.incorrectLinkedSlideId,
      entity.notifyCorrectAnswer)
  implicit def slideElementListModelConversion(list: List[SlideElementEntity]) = list.map(slideElementModelConversion)
  implicit def slideElementOptionModelConversion(list: Option[SlideElementEntity]) = list.map(slideElementModelConversion)
}