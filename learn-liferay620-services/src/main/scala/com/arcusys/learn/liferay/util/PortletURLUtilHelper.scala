package com.arcusys.learn.liferay.util

import javax.portlet.{PortletURL, MimeResponse, PortletRequest}
import com.liferay.portlet.PortletURLUtil

object PortletURLUtilHelper {
  def getCurrent(portletRequest: PortletRequest, mimeResponse: MimeResponse): PortletURL =
    PortletURLUtil.getCurrent(portletRequest, mimeResponse)
}
