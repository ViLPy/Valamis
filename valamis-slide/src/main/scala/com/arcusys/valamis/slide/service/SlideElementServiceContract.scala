package com.arcusys.valamis.slide.service

import com.arcusys.valamis.slide.model.SlideElementModel

trait SlideElementServiceContract {
  def create(slideElementModel: SlideElementModel): SlideElementModel
  def getAll: List[SlideElementModel]
  def getBySlideId(slideId: Long): List[SlideElementModel]
  def update(slideElementModel: SlideElementModel): SlideElementModel
  def delete(id: Long)
}
