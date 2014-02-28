package com.arcusys.learn.liferay.services

import com.liferay.portlet.polls.model.{PollsChoice, PollsQuestion}
import java.util.Locale
import com.liferay.portal.service.ServiceContext
import com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil

object PollsQuestionLocalServiceHelper {
  def addQuestion(userId: Long,
                  titleMap: java.util.Map[Locale, String],
                  descriptionMap: java.util.Map[Locale, String],
                  expirationDateMonth: Int,
                  expirationDateDay: Int,
                  expirationDateYear: Int,
                  expirationDateHour: Int,
                  expirationDateMinute: Int,
                  neverExpire: Boolean,
                  choices: java.util.List[PollsChoice],
                  serviceContext: ServiceContext): PollsQuestion =
    PollsQuestionLocalServiceUtil.addQuestion(userId, titleMap, descriptionMap,
      expirationDateMonth, expirationDateDay, expirationDateYear, expirationDateHour, expirationDateMinute, neverExpire,
      choices, serviceContext)
}
