package com.arcusys.learn.bl.services

import com.arcusys.learn.settings.model.LRSToActivitySetting

trait LRSToActivitySettingServiceContract {
  def getByCourseID(courseID: Int): Seq[LRSToActivitySetting]
  def create(courseID: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting
  def modify(id: Int, courseID: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting
  def delete(id: Int)
}
