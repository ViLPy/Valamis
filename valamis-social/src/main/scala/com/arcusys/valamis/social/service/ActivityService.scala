package com.arcusys.valamis.social.service

import com.arcusys.learn.liferay.model.Activity

trait ActivityService {
  def create(companyId: Long, userId: Long, content: String): Activity
  def share(companyId: Long, userId: Long, packageId: Long, comment: Option[String]): Activity
  def getBy(companyId: Long): Seq[Activity]
}