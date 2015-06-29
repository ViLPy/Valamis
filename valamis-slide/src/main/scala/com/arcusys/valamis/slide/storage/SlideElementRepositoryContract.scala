package com.arcusys.valamis.slide.storage

import com.arcusys.valamis.slide.model.{SlideElementModel, SlideElementEntity}

trait SlideElementRepositoryContract {
  def getCount: Int
  def create(slideElementModel: SlideElementModel): SlideElementEntity
  def getAll: List[SlideElementEntity]
  def getBySlideId(id: Long): List[SlideElementEntity]
  def update(slideElementModel: SlideElementModel): SlideElementEntity
  def delete(id: Long)
}