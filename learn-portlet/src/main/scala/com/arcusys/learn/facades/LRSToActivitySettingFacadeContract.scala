package com.arcusys.learn.facades

import com.arcusys.learn.settings.model.LRSToActivitySetting

trait LRSToActivitySettingFacadeContract {
  def getByCourseID(courseID: Int): Seq[LRSToActivitySetting]
  def create(courseID: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting
  def modify(id: Int, courseID: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting
  def delete(id: Int)
}
