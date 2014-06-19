package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.ActivityProfile
import org.joda.time.DateTime

trait ActivityProfileStorage {
  def get(activityId: String, profileId: String): Option[ActivityProfile]
  def getIds(activityId: String, since: Option[DateTime]): Seq[String]
  def create(entity: ActivityProfile)
  def modify(entity: ActivityProfile)
  def delete(activityId: String, profileId: String)
  def renew()
}
