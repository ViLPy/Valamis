package com.arcusys.valamis.settings.service

import com.arcusys.valamis.settings.model.LRSToActivitySetting

trait LRSToActivitySettingService {
  def getAll: Seq[LRSToActivitySetting]
  def getByCourseId(courseId: Int): Seq[LRSToActivitySetting]
  def create(courseId: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting
  def modify(id: Int, courseID: Int, title: String, mappedActivity: Option[String], mappedVerb: Option[String]): LRSToActivitySetting
  def delete(id: Int)
}
