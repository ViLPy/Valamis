package com.arcusys.learn.facades

import com.arcusys.valamis.settings.model.LRSToActivitySetting

trait LRSToActivitySettingFacadeContract {
  def getByCourseId(courseId: Int): Seq[LRSToActivitySetting]
  def create(courseId: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting
  def modify(id: Int, courseId: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting
  def delete(id: Int)
}
