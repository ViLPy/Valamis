package com.arcusys.learn.liferay.services

import com.liferay.portal.model.Group
import com.liferay.portal.service.GroupLocalServiceUtil
import java.util

object GroupLocalServiceHelper {
  def getGroup(groupId: Long): Group = GroupLocalServiceUtil.getGroup(groupId)

  def updateGroup(group: Group): Group = GroupLocalServiceUtil.updateGroup(group)

  def getCompanyGroups(companyId: Long, start: Int, end: Int): java.util.List[Group] =
    GroupLocalServiceUtil.getCompanyGroups(companyId, start, end)

  def search(companyId: Long,
             classNameIds: Array[Long],
             keywords: String,
             params: util.LinkedHashMap[String, AnyRef],
             start: Int,
             end: Int): java.util.List[Group] =
    GroupLocalServiceUtil.search(companyId, classNameIds, keywords: String, params, start, end)

  def updateFriendlyURL(groupId: Long, friendlyURL: String): Group =
    GroupLocalServiceUtil.updateFriendlyURL(groupId, friendlyURL)
}
