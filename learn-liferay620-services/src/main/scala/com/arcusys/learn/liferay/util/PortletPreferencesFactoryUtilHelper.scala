package com.arcusys.learn.liferay.util

import com.liferay.portal.model.Layout
import javax.portlet.{ PortletRequest, PortletPreferences }
import com.liferay.portlet.PortletPreferencesFactoryUtil

object PortletPreferencesFactoryUtilHelper {
  def getPortletSetup(layout: Layout,
    portletId: String,
    defaultPreferences: String): PortletPreferences =
    PortletPreferencesFactoryUtil.getPortletSetup(layout, portletId, defaultPreferences)

  def getLayoutPortletSetup(layout: Layout, portletId: String): PortletPreferences =
    PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, portletId)

  def getPortletSetup(request: PortletRequest) =
    PortletPreferencesFactoryUtil.getPortletSetup(request)

}
