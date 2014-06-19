package com.arcusys.learn.liferay.services

import com.liferay.portal.model.LayoutSet
import com.liferay.portal.service.LayoutSetLocalServiceUtil

object LayoutSetLocalServiceHelper {
  def updateLookAndFeel(groupId: Long,
    privateLayout: Boolean,
    themeId: String,
    colorSchemeId: String,
    css: String,
    wapTheme: Boolean): LayoutSet =
    LayoutSetLocalServiceUtil.updateLookAndFeel(groupId, privateLayout, themeId, colorSchemeId, css, wapTheme)
}
