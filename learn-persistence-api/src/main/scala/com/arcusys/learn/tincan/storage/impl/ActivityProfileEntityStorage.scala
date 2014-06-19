package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.model.ActivityProfile
import com.arcusys.learn.tincan.storage.ActivityProfileStorage
import com.arcusys.learn.storage.impl.EntityStorage
import org.joda.time.DateTime

trait ActivityProfileEntityStorage extends ActivityProfileStorage with EntityStorage[ActivityProfile] {

  def get(activityId: String, profileId: String): Option[ActivityProfile] =
    getOne("activityId" -> activityId, "profileId" -> profileId)

  def getIds(activityId: String, since: Option[DateTime]): Seq[String] =
    getAll("activityId" -> activityId, "since" -> since).map(_.profileId)

  def create(entity: ActivityProfile): Unit =
    create("activityId" -> entity.activityId, "profileId" -> entity.profileId, "document" -> entity.document)

  def delete(activityId: String, profileId: String): Unit =
    delete("activityId" -> activityId, "profileId" -> profileId)

  def modify(entity: ActivityProfile): Unit = {
    modify("activityId" -> entity.activityId, "profileId" -> entity.profileId, "documentContent" -> new String(entity.document.contents))
  }
}
