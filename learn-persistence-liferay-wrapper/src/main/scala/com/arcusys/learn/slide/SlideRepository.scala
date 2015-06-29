package com.arcusys.learn.slide

import SlideEntityConverters._
import com.arcusys.learn.persistence.liferay.service.LFSlideLocalServiceUtil
import com.arcusys.valamis.slide.model.SlideModel
import com.arcusys.valamis.slide.storage.SlideRepositoryContract
import scala.collection.JavaConversions._
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

class SlideRepository extends SlideRepositoryContract {
  override def getCount = LFSlideLocalServiceUtil.getLFSlidesCount

  override def getAll = LFSlideLocalServiceUtil.getLFSlides(0, getCount).toList

  override def getBySlideSetId(slideSetId: Long) = getAll.filter(_.slideSetId == slideSetId)

  override def delete(id: Long) = LFSlideLocalServiceUtil.deleteLFSlide(id)

  override def create(slideModel: SlideModel) = {
    val slide = LFSlideLocalServiceUtil.createLFSlide()
    slide.setTitle(slideModel.title)
    slide.setBgcolor(slideModel.bgColor)
    slide.setBgimage(slideModel.bgImage)
    slide.setLeftSlideId(slideModel.leftSlideId)
    slide.setTopSlideId(slideModel.topSlideId)
    slide.setSlideSetId(slideModel.slideSetId)
    slide.setStatementVerb(slideModel.statementVerb)
    slide.setStatementObject(slideModel.statementObject)
    slide.setStatementCategoryId(slideModel.statementCategoryId)
    LFSlideLocalServiceUtil.updateLFSlide(slide)
  }

  override def update(slideModel: SlideModel) = {
    val slide = LFSlideLocalServiceUtil.getLFSlide(slideModel.id.get)
    slide.setTitle(slideModel.title)
    slide.setBgcolor(slideModel.bgColor)
    slide.setBgimage(slideModel.bgImage)
    slide.setLeftSlideId(slideModel.leftSlideId)
    slide.setTopSlideId(slideModel.topSlideId)
    slide.setSlideSetId(slideModel.slideSetId)
    slide.setStatementVerb(slideModel.statementVerb)
    slide.setStatementObject(slideModel.statementObject)
    slide.setStatementCategoryId(slideModel.statementCategoryId)
    LFSlideLocalServiceUtil.updateLFSlide(slide)
  }
}