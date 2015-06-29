package com.arcusys.valamis.social.service

import com.arcusys.valamis.social.model.{Like, LikeFilter}
import com.arcusys.valamis.social.storage.LikeRepository
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}

class LikeServiceImpl(implicit val bindingModule: BindingModule) extends LikeService with Injectable {
  val likeRepository = inject[LikeRepository]

  override def create(like: Like): Like = likeRepository.create(like)

  override def delete(userId: Long, activityId: Long) =
    likeRepository.delete(userId, activityId)

  override def getBy(likeRequest: LikeFilter): Seq[Like] = likeRepository.getBy(likeRequest)

  override def getCountBy(likeRequest: LikeFilter): Long = likeRepository.getCountBy(likeRequest)
}