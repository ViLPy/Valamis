package com.arcusys.valamis.social.model

case class LikeFilter(
  companyId: Long,
  userId: Option[Long] = None,
  activityId: Option[Long] = None,
  sortBy: Option[LikeSortBy] = None)
