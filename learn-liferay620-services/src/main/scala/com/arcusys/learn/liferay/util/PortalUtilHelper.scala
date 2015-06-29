package com.arcusys.learn.liferay.util

import javax.portlet.PortletRequest
import com.liferay.portal.security.auth.CompanyThreadLocal
import com.liferay.portal.service.CompanyLocalServiceUtil
import com.liferay.portal.util.PortalUtil
import javax.servlet.http.HttpServletRequest

object PortalUtilHelper {
  def getCompanyId(portletRequest: PortletRequest): Long =
    PortalUtil.getCompanyId(portletRequest)

  def getCompanyId(portletRequest: HttpServletRequest): Long =
    PortalUtil.getCompanyId(portletRequest)

  def getPathMain: String = PortalUtil.getPathMain

  def getHttpServletRequest(portletRequest: PortletRequest): HttpServletRequest =
    PortalUtil.getHttpServletRequest(portletRequest)

  def getLayoutFullURL(groupId: Long, portletId: String): String = PortalUtil.getLayoutFullURL(groupId, portletId)

  def getDefaultCompanyId = PortalUtil.getDefaultCompanyId

  def getLocalHostUrl: String = {
    getLocalHostUrl(CompanyThreadLocal.getCompanyId)
  }

  def getLocalHostUrl(companyId: Long, isSecure : Boolean = false): String = {
    lazy val company = CompanyLocalServiceUtil.getCompany(companyId)

    val hostName = company.getVirtualHostname
    val port = PortalUtil.getPortalPort(isSecure)
    PortalUtil.getPortalURL(hostName, port, isSecure)
  }
}
