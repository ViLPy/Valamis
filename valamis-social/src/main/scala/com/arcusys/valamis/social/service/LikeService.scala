package com.arcusys.valamis.social.service

import com.arcusys.valamis.social.model.{Like, LikeFilter}

trait LikeService {
  def create(like: Like): Like
  def delete(userId: Long, activityId: Long)
  def getBy(likeRequest: LikeFilter): Seq[Like]
  def getCountBy(likeRequest: LikeFilter): Long
}
