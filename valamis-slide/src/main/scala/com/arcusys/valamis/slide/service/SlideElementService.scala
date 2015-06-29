package com.arcusys.valamis.slide.service

import com.arcusys.valamis.slide.model.SlideElementModel
import com.arcusys.valamis.slide.storage.SlideElementRepositoryContract
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import SlideModelConverters._

class SlideElementService(implicit val bindingModule: BindingModule) extends Injectable with SlideElementServiceContract {

  private val slideElementRepository = inject[SlideElementRepositoryContract]

  override def create(slideElementModel: SlideElementModel) = slideElementRepository.create(slideElementModel)
  override def getAll = slideElementRepository.getAll
  override def getBySlideId(slideId: Long) = slideElementRepository.getBySlideId(slideId)
  override def update(slideElementModel: SlideElementModel) = slideElementRepository.update(slideElementModel)
  override def delete(id: Long) = slideElementRepository.delete(id)
}
