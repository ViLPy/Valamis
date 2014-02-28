package com.arcusys.learn.liferay.services

import com.liferay.portal.model.{Group, Layout}
import com.liferay.portal.service.{ServiceContext, LayoutLocalServiceUtil}
import java.io.{InputStream, File}
import scala.collection.JavaConverters._

object LayoutLocalServiceHelper {
  def getLayouts(groupId: Long, privateLayout: Boolean): java.util.List[Layout] =
    LayoutLocalServiceUtil.getLayouts(groupId, privateLayout)

  def getLayouts(groupId: Long, privateLayout: Boolean, layoutType: String): java.util.List[Layout] =
    LayoutLocalServiceUtil.getLayouts(groupId, privateLayout, layoutType)

  def getLayout(plid: Long): Layout = LayoutLocalServiceUtil.getLayout(plid)

  def getFriendlyURLLayout(groupId: Long,
                           privateLayout: Boolean,
                           friendlyURL: String): Layout =
    LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, privateLayout, friendlyURL)

  def getLayoutsCount(group: Group, privateLayout: Boolean): Int =
    LayoutLocalServiceUtil.getLayoutsCount(group, privateLayout)

  def deleteLayouts(groupId: Long,
                    privateLayout: Boolean,
                    serviceContext: ServiceContext) {
    LayoutLocalServiceUtil.deleteLayouts(groupId, privateLayout, serviceContext)
  }

  def importLayouts(userId: Long,
                    groupId: Long,
                    privateLayout: Boolean,
                    parameterMap: java.util.Map[String, Array[String]],
                    file: File) {
    LayoutLocalServiceUtil.importLayouts(userId, groupId, privateLayout, parameterMap, file)
  }

  def addLayout(userId: Long,
                groupId: Long,
                privateLayout: Boolean,
                parentLayoutId: Long,
                name: String,
                title: String,
                description: String,
                layoutType: String,
                hidden: Boolean,
                friendlyURL: String,
                serviceContext: ServiceContext): Layout = {
    LayoutLocalServiceUtil.addLayout(userId, groupId, privateLayout, parentLayoutId, name, title, description, layoutType,
      hidden, friendlyURL, serviceContext)
  }

  def updateLayout(groupId: Long,
                   privateLayout: Boolean,
                   layoutId: Long,
                   typeSettings: String): Layout =
    LayoutLocalServiceUtil.updateLayout(groupId, privateLayout, layoutId, typeSettings)

  def importPortletInfo(userId: Long,
                        plid: Long,
                        groupId: Long,
                        portletId: String,
                        parameterMap: java.util.Map[String, Array[String]],
                        is: InputStream) {
    LayoutLocalServiceUtil.importPortletInfo(userId, plid, groupId, portletId, parameterMap, is)
  }
}
