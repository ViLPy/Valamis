package com.arcusys.learn.liferay.model

import org.joda.time.DateTime

case class Activity(
  id: Long,
  userId: Long,
  className: String,
  companyId: Long,
  createDate: DateTime,
  activityType: Int,
  classPK: Option[Long],
  groupId: Option[Long],
  extraData: Option[String])