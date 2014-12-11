package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.util.PrefsPropsUtil

import scala.util.Try

object PrefsPropsUtilHelper {

  def getContent(companyId: Long, name: String) =
    Try(PrefsPropsUtil.getContent(companyId, name)).toOption

  def getDefaultContent(name: String) =
    Try(PrefsPropsUtil.getContent(PortalUtilHelper.getDefaultCompanyId, name)).toOption
}
