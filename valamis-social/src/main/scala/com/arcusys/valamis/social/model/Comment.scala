package com.arcusys.valamis.social.model

import org.joda.time.DateTime

case class Comment(
  companyId: Long,
  userId: Long,
  content: String,
  activityId: Long,
  id: Option[Long] = None,
  creationDate: DateTime = DateTime.now,
  lastUpdateDate: Option[DateTime] = None
)

