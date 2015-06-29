package com.arcusys.valamis.social.storage

import com.arcusys.valamis.social.model.{Like, LikeFilter}

trait LikeRepository{
  def create(like: Like): Like
  def delete(userId: Long, activityId: Long)
  def getBy(likeRequest: LikeFilter): Seq[Like]
  def getCountBy(likeRequest: LikeFilter): Long
}
