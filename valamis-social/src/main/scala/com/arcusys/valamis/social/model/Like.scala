package com.arcusys.valamis.social.model

import org.joda.time.DateTime

case class Like(
  companyId: Long,
  userId: Long,
  activityId: Long,
  id: Option[Long],
  createDate: DateTime = DateTime.now
)