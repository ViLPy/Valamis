package com.arcusys.learn.liferay.services

import com.liferay.portal.kernel.dao.orm.{ ProjectionFactoryUtil, RestrictionsFactoryUtil, PropertyFactoryUtil }
import com.liferay.portal.model.Group
import com.liferay.portal.service.{ ServiceContext, GroupLocalServiceUtil }
import java.util
import com.liferay.portlet.asset.model.AssetVocabulary
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil

import scala.collection.JavaConverters._
import com.arcusys.learn.liferay.constants.QueryUtilHelper

object GroupLocalServiceHelper {
  def getGroup(groupId: Long): Group = GroupLocalServiceUtil.getGroup(groupId)

  def updateGroup(group: Group): Group = GroupLocalServiceUtil.updateGroup(group)

  def getCompanyGroup(companyId: Long): Group = GroupLocalServiceUtil.getCompanyGroup(companyId)

  def getCompanyGroups(companyId: Long, start: Int, end: Int): java.util.List[Group] =
    GroupLocalServiceUtil.getCompanyGroups(companyId, start, end)

  def getCompanyGroupIdsActiveSites(companyId: Long, start: Int, end: Int): Seq[Long] = {
    val dq = GroupLocalServiceUtil.dynamicQuery()
    dq.add(RestrictionsFactoryUtil.eq("companyId", companyId))
      .add(RestrictionsFactoryUtil.eq("site", true))
      .add(RestrictionsFactoryUtil.eq("active", true))
      .add(RestrictionsFactoryUtil.ne("friendlyURL", "/control_panel"))

    dq.setProjection(ProjectionFactoryUtil.projectionList()
      .add(ProjectionFactoryUtil.property("groupId")))

    GroupLocalServiceUtil.dynamicQuery(dq, start, end).asScala.map(_.asInstanceOf[Long])
  }

  def getGroupIdsForAllActiveSites: Seq[Long] = {
    val dq = GroupLocalServiceUtil.dynamicQuery()
    dq.add(RestrictionsFactoryUtil.eq("site", true))
      .add(RestrictionsFactoryUtil.eq("active", true))
      .add(RestrictionsFactoryUtil.ne("friendlyURL", "/control_panel"))

    dq.setProjection(ProjectionFactoryUtil.projectionList()
      .add(ProjectionFactoryUtil.property("groupId")))

    GroupLocalServiceUtil.dynamicQuery(dq).asScala.map(_.asInstanceOf[Long])
  }

  def getGroups: java.util.List[Group] = GroupLocalServiceUtil.getGroups(QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)

  def getGroupsByUserId(userId: Long): java.util.List[Group] = GroupLocalServiceUtil.getUserGroups(userId)

  def getGroupVocabulary(globalGroupId: Long, vocabularyName: String): AssetVocabulary =
    AssetVocabularyLocalServiceUtil.getGroupVocabulary(globalGroupId, vocabularyName)

  def addGroupVocabulary(userId: Long, title: String, context: ServiceContext) = {
    AssetVocabularyLocalServiceUtil.addVocabulary(userId, title, context)
  }

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
