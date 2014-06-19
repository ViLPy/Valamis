package com.arcusys.learn.liferay.services

import com.liferay.portal.service.ServiceContext
import com.liferay.portlet.polls.service.PollsChoiceLocalServiceUtil

object PollsChoiceLocalServiceHelper {
  def addChoice(userId: Long,
    questionId: Long,
    name: String,
    description: String,
    serviceContext: ServiceContext) =
    PollsChoiceLocalServiceUtil.addChoice(userId, questionId, name, description, serviceContext)
}
