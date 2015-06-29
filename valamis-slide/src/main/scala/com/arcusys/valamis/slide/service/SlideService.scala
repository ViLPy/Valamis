package com.arcusys.valamis.slide.service

import com.arcusys.valamis.lrs.util.{TinCanVerb, TinCanVerbs}
import com.arcusys.valamis.slide.model.{SlideModel, SlideEntity}
import com.arcusys.valamis.slide.storage.SlideRepositoryContract
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import SlideModelConverters._

class SlideService(implicit val bindingModule: BindingModule) extends Injectable with SlideServiceContract {

  private val slideRepository = inject[SlideRepositoryContract]
  private val slideElementService = inject[SlideElementServiceContract]

  private implicit def convertToModel(from: SlideEntity) = slideModelConversion(from, slideElementService.getBySlideId(from.id))
  private implicit def convertToModelList(from: List[SlideEntity]) = from.map(convertToModel) //TODO: Option & List => Monad? One function instead of two?
  private implicit def convertToModelOption(from: Option[SlideEntity]) = from.map(convertToModel) //TODO: Option & List => Monad? One function instead of two?

  override def getAll = slideRepository.getAll

  override def getBySlideSetId(slideSetId: Long) = slideRepository.getBySlideSetId(slideSetId)

  override def getTinCanVerbs() = TinCanVerbs.all.map(x => TinCanVerb(TinCanVerbs.getVerbURI(x), x))

  override def delete(id: Long) = slideRepository.delete(id)

  override def create(slideModel: SlideModel) = slideRepository.create(slideModel)

  override def update(slideModel: SlideModel) = slideRepository.update(slideModel)
}
