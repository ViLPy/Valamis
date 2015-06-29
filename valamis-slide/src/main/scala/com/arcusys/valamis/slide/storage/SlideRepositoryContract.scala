package com.arcusys.valamis.slide.storage

import com.arcusys.valamis.slide.model.{SlideModel, SlideEntity}

trait SlideRepositoryContract {
  def getCount: Int
  def getAll: List[SlideEntity]
  def getBySlideSetId(slideSetId: Long): List[SlideEntity]
  def delete(id: Long)
  def create(slideModel: SlideModel): SlideEntity
  def update(slideModel: SlideModel): SlideEntity
}
