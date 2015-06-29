package com.arcusys.learn.slide

import com.arcusys.learn.persistence.liferay.model._
import com.arcusys.valamis.slide.model._
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

object SlideEntityConverters {
  implicit def slideSetConversion(entity: LFSlideSet) =
    SlideSetEntity(
      entity.getId,
      entity.getTitle,
      entity.getDescription,
      entity.getCourseId.toOption,
      entity.getLogo.toOption)
  implicit def slideConversion(entity: LFSlide) =
    SlideEntity(
      entity.getId,
      entity.getTitle,
      entity.getBgcolor.toOption,
      entity.getBgimage.toOption,
      entity.getLeftSlideId.toOption,
      entity.getTopSlideId.toOption,
      entity.getSlideSetId,
      entity.getStatementVerb.toOption,
      entity.getStatementObject.toOption,
      entity.getStatementCategoryId.toOption)
  implicit def slideEntityConversion(entity: LFSlideEntity) =
    SlideElementEntity(
      entity.getId,
      entity.getTop,
      entity.getLeft,
      entity.getWidth,
      entity.getHeight,
      entity.getZIndex,
      entity.getContent,
      entity.getEntityType,
      entity.getSlideId,
      entity.getCorrectLinkedSlideId.toOption,
      entity.getIncorrectLinkedSlideId.toOption,
      if(entity.getNotifyCorrectAnswer == null) None else Some(entity.getNotifyCorrectAnswer))

  implicit def slideSetListConversion(list: List[LFSlideSet]) = list.map(slideSetConversion)
  implicit def slideListConversion(list: List[LFSlide]) = list.map(slideConversion)
  implicit def slideEntityListConversion(list: List[LFSlideEntity]) = list.map(slideEntityConversion)
}