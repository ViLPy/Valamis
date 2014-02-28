package com.arcusys.learn.liferay.services

import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil
import com.liferay.portlet.social.model.SocialActivity

object SocialActivityLocalServiceHelper {
  def deleteActivities(className: String, classPK: Long) {
    SocialActivityLocalServiceUtil.deleteActivities(className, classPK)
  }

  def deleteActivity(activityId: Long) {
    SocialActivityLocalServiceUtil.deleteActivity(activityId)
  }

  def getActivities(className: String,
                    start: Int,
                    end: Int): java.util.List[SocialActivity] =
    SocialActivityLocalServiceUtil.getActivities(className, start, end)

  def addActivity(userId: Long,
                  groupId: Long,
                  className: String,
                  classPK: Long,
                  activityType: Int,
                  extraData: String,
                  receiverUserId: Long) {
    SocialActivityLocalServiceUtil.addActivity(userId, groupId, className, classPK, activityType, extraData, receiverUserId)
  }

  def getUserActivities(userId: Long,
                        start: Int,
                        end: Int): java.util.List[SocialActivity] =
    SocialActivityLocalServiceUtil.getUserActivities(userId, start, end)

  def getSocialActivities(start: Int, end: Int): java.util.List[SocialActivity] =
    SocialActivityLocalServiceUtil.getSocialActivities(start, end)
}
