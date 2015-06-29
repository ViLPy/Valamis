package com.arcusys.learn.service.util

import javax.portlet.PortletRequest
import javax.servlet.ServletRequest

import com.liferay.portal.util.PortalUtil

object UrlHelper {
  def getURLFromRequest[T](prefix:String, request: T): String = request match {
    case r: PortletRequest => PortalUtil.getPortalURL(r.getServerName, r.getServerPort, r.isSecure) + // http://localhost:8080
      "/learn-portlet" + prefix
    case r: ServletRequest => PortalUtil.getPortalURL(r.getServerName, r.getServerPort, r.isSecure) + // http://localhost:8080
      "/learn-portlet" + prefix
    case _ => throw new RuntimeException("No request pointed")
  }
}
