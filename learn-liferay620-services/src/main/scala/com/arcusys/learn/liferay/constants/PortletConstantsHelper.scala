package com.arcusys.learn.liferay.constants

import com.liferay.portal.model.PortletConstants

object PortletConstantsHelper {
  val INSTANCE_SEPARATOR = PortletConstants.INSTANCE_SEPARATOR

  def getRootPortletId(portletId: String): String = PortletConstants.getRootPortletId(portletId)
}
