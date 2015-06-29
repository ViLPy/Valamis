package com.arcusys.valamis.slide.storage

import com.arcusys.valamis.slide.model.{SlideSetModel, SlideSetEntity}

trait SlideSetRepositoryContract {
  def getCount: Int
  def getById(id: Long): Option[SlideSetEntity]
  def getSlideSets(titleFilter: String, sortTitleAsc: Boolean, page: Int, itemsOnPage: Int, courseId: Option[Long]): List[SlideSetEntity]
  def getSlideSetsCount(titleFilter: String, courseId: Option[Long]): Int
  def delete(id: Long)
  def update(slideSetModel: SlideSetModel): SlideSetEntity
  def create(slideSetModel: SlideSetModel): SlideSetEntity
}