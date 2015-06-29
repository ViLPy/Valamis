package com.arcusys.valamis.social.model

import com.arcusys.valamis.model.SkipTake

case class CommentFilter(
  companyId: Long,
  userId: Option[Long] = None,
  activityId: Option[Long] = None,
  sortBy: Option[CommentSortBy] = None,
  skipTake: Option[SkipTake] = None)
