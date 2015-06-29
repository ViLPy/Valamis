package com.arcusys.valamis.slide.service

import com.arcusys.valamis.lrs.util.TinCanVerb
import com.arcusys.valamis.slide.model.SlideModel

trait SlideServiceContract {
  def create(slideModel: SlideModel): SlideModel
  def getAll: List[SlideModel]
  def getBySlideSetId(slideSetId: Long): List[SlideModel]
  def getTinCanVerbs(): List[TinCanVerb]
  def update(slideModel: SlideModel): SlideModel
  def delete(id: Long)
}
