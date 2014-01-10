package com.arcusys.learn.tincan.storage

import java.util.Date

import com.arcusys.learn.tincan.model.ActivityProfile


trait ActivityProfileStorage {
  def get(activityId: String, profileId: String): Option[ActivityProfile]
  def getIds(activityId: String, since: Date): Seq[String]
  def create(entity: ActivityProfile)
  def modify(entity: ActivityProfile)
  def delete(activityId: String, profileId: String)
  def renew()
}
