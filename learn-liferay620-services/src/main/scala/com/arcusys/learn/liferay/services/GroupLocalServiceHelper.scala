package com.arcusys.learn.liferay.services

import com.liferay.portal.model.Group
import com.liferay.portal.service.GroupLocalServiceUtil
import java.util
import scala.collection.JavaConverters._
import com.arcusys.learn.liferay.constants.QueryUtilHelper

object GroupLocalServiceHelper {
  def getGroup(groupId: Long): Group = GroupLocalServiceUtil.getGroup(groupId)

  def updateGroup(group: Group): Group = GroupLocalServiceUtil.updateGroup(group)

  def getCompanyGroups(companyId: Long, start: Int, end: Int): java.util.List[Group] =
    GroupLocalServiceUtil.getCompanyGroups(companyId, start, end)

  def getGroups: java.util.List[Group] = GroupLocalServiceUtil.getGroups(QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)

  def getGroupsByUserId(userId: Long): java.util.List[Group] = GroupLocalServiceUtil.getUserGroups(userId)

  def search(companyId: Long,
    classNameIds: Array[Long],
    keywords: String,
    params: util.LinkedHashMap[String, AnyRef],
    start: Int,
    end: Int): java.util.List[Group] =
    GroupLocalServiceUtil.search(companyId, classNameIds, keywords: String, params, start, end)

  def searchExceptPrivateSites(companyId: Long,
    start: Int,
    end: Int): Seq[Group] =
    GroupLocalServiceUtil.getCompanyGroups(companyId, start, end).
      asScala.
      filterNot(g => g.isUser || g.isUserGroup || g.isUserPersonalSite)

  def updateFriendlyURL(groupId: Long, friendlyURL: String): Group =
    GroupLocalServiceUtil.updateFriendlyURL(groupId, friendlyURL)
}
