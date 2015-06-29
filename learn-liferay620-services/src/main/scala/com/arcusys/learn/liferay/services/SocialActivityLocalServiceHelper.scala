package com.arcusys.learn.liferay.services

import java.util.Date
import com.arcusys.learn.liferay.model.Activity
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil
import com.liferay.portlet.social.model.SocialActivity
import org.joda.time.DateTime
import scala.collection.JavaConversions._
import scala.util.Random

object SocialActivityLocalServiceHelper extends ActivityWithSetCreator {
  def deleteActivities(className: String, classPK: Long): Unit = {
    SocialActivityLocalServiceUtil.deleteActivities(className, classPK)
  }

  def deleteActivity(activityId: Long): Unit = {
    SocialActivityLocalServiceUtil.deleteActivity(activityId)
  }

  def getBy(companyId: Long): Seq[Activity] = {
    val dq = SocialActivityLocalServiceUtil.dynamicQuery()
    dq.add(RestrictionsFactoryUtil.eq("companyId", companyId))

    SocialActivityLocalServiceUtil
      .dynamicQuery(dq)
      .map(_.asInstanceOf[SocialActivity])
      .map(toModel)
  }

  def getActivities(className: String,
    start: Int,
    end: Int): Seq[SocialActivity] =
    SocialActivityLocalServiceUtil.getActivities(className, start, end)

  def addActivity(userId: Long,
    groupId: Long,
    className: String,
    classPK: Long,
    activityType: Int,
    extraData: String,
    receiverUserId: Long): Unit = {
    SocialActivityLocalServiceUtil.addActivity(userId, groupId, className, classPK, activityType, extraData, receiverUserId)
  }

  def getActivities(userId: Long, afterDate: DateTime): Seq[SocialActivity] =
    getUserActivities(userId, 0, SocialActivityLocalServiceUtil.getUserActivitiesCount(userId))
      .filter(sa => new DateTime(sa.getCreateDate).isAfter(afterDate))

  def getUserActivities(userId: Long,
    start: Int,
    end: Int): Seq[SocialActivity] =
    SocialActivityLocalServiceUtil.getUserActivities(userId, start, end)

  def getSocialActivities(start: Int, end: Int): Seq[SocialActivity] =
    SocialActivityLocalServiceUtil.getSocialActivities(start, end)

  def createSocialActivity(id: Long): SocialActivity = SocialActivityLocalServiceUtil.createSocialActivity(id)

  def addActivity(socialActivity: SocialActivity, mirrorSocialActivity: SocialActivity): Unit =
    SocialActivityLocalServiceUtil.addActivity(socialActivity, mirrorSocialActivity)
}

trait ActivityWithSetCreator extends ActivityConverter {
  private val random = new Random

  private def create(companyId: Long,
                     userId: Long,
                     className: String,
                     courseId: Option[Long],
                     receiverUserId: Option[Long],
                     `type`: Option[Int],
                     classPK: Option[Long],
                     extraData: Option[String]) = {
    val socialActivity = SocialActivityLocalServiceUtil.createSocialActivity(0)

    socialActivity.setCompanyId(companyId)
    socialActivity.setUserId(userId)
    socialActivity.setClassName(className)
    courseId.foreach(socialActivity.setGroupId)
    receiverUserId.foreach(socialActivity.setReceiverUserId)
    `type`.foreach(socialActivity.setType)

    if (classPK.isDefined) socialActivity.setClassPK(classPK.get)
    else socialActivity.setClassPK(random.nextLong) // Comments in activity portlet of social office are done toward classPK

    socialActivity.setCreateDate(new Date().getTime)

    extraData.foreach(socialActivity.setExtraData)

    socialActivity
  }

  //Creates activity with activitySet, because activity portlet of social office are retrieved for sets.
  def addWithSet(companyId: Long,
                 userId: Long,
                 className: String,
                 courseId: Option[Long] = None,
                 receiverUserId: Option[Long] = None,
                 `type`: Option[Int] = None,
                 classPK: Option[Long] = None,
                 extraData: Option[String] = None): Activity = {
    val socialActivity =
      create(companyId, userId, className, courseId, receiverUserId, `type`, classPK, extraData)

    SocialActivityLocalServiceHelper.addActivity(socialActivity, null)
    toModel(socialActivity)
  }
}

trait ActivityConverter {
  private def toOption(liferayOptionalValue: Long) = {
    if(liferayOptionalValue == 0) None
    else Some(liferayOptionalValue)
  }

  private def toOption(liferayOptionalValue: String) = {
    if(liferayOptionalValue == "") None
    else Some(liferayOptionalValue)
  }

  protected def toModel(from: SocialActivity): Activity = {
    Activity(
      id = from.getActivityId,
      userId = from.getUserId,
      className = from.getClassName,
      companyId = from.getCompanyId,
      createDate = new DateTime(from.getCreateDate),
      activityType = from.getType,
      classPK = toOption(from.getClassPK),
      groupId = toOption(from.getGroupId),
      extraData = toOption(from.getExtraData))
  }
}