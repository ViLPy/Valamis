package com.arcusys.learn.slide

import com.arcusys.learn.persistence.liferay.service.LFSlideEntityLocalServiceUtil
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
import com.arcusys.valamis.slide.model.SlideElementModel
import com.arcusys.valamis.slide.storage.SlideElementRepositoryContract
import scala.collection.JavaConversions._
import SlideEntityConverters._

class SlideElementRepository extends SlideElementRepositoryContract {
  override def getCount = LFSlideEntityLocalServiceUtil.getLFSlideEntitiesCount

  override def create(slideElementModel: SlideElementModel) = {
    val entity = LFSlideEntityLocalServiceUtil.createLFSlideEntity()
    entity.setTop(slideElementModel.top)
    entity.setLeft(slideElementModel.left)
    entity.setWidth(slideElementModel.width)
    entity.setHeight(slideElementModel.height)
    entity.setZIndex(slideElementModel.zIndex)
    entity.setContent(slideElementModel.content)
    entity.setEntityType(slideElementModel.slideEntityType)
    entity.setSlideId(slideElementModel.slideId)
    entity.setCorrectLinkedSlideId(slideElementModel.correctLinkedSlideId)
    entity.setIncorrectLinkedSlideId(slideElementModel.incorrectLinkedSlideId)
    entity.setNotifyCorrectAnswer(slideElementModel.notifyCorrectAnswer)
    LFSlideEntityLocalServiceUtil.updateLFSlideEntity(entity)
  }

  override def getAll = LFSlideEntityLocalServiceUtil.getLFSlideEntities(0, getCount).toList

  override def getBySlideId(slideId: Long) = getAll.filter(_.slideId == slideId)

  override def update(slideElementModel: SlideElementModel) = {
    val entity = LFSlideEntityLocalServiceUtil.getLFSlideEntity(slideElementModel.id.get)
    entity.setTop(slideElementModel.top)
    entity.setLeft(slideElementModel.left)
    entity.setWidth(slideElementModel.width)
    entity.setHeight(slideElementModel.height)
    entity.setZIndex(slideElementModel.zIndex)
    entity.setContent(slideElementModel.content)
    entity.setEntityType(slideElementModel.slideEntityType)
    entity.setSlideId(slideElementModel.slideId)
    entity.setCorrectLinkedSlideId(slideElementModel.correctLinkedSlideId)
    entity.setIncorrectLinkedSlideId(slideElementModel.incorrectLinkedSlideId)
    entity.setNotifyCorrectAnswer(slideElementModel.notifyCorrectAnswer)
    LFSlideEntityLocalServiceUtil.updateLFSlideEntity(entity)
  }

  override def delete(id: Long) = LFSlideEntityLocalServiceUtil.deleteLFSlideEntity(id)
}