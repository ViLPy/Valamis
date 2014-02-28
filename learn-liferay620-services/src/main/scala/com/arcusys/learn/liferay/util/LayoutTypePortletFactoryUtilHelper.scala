package com.arcusys.learn.liferay.util

import com.liferay.portal.model.{Layout, LayoutTypePortlet}
import com.liferay.portal.util.LayoutTypePortletFactoryUtil

object LayoutTypePortletFactoryUtilHelper {
  def create(layout: Layout): LayoutTypePortlet =  LayoutTypePortletFactoryUtil.create(layout)
}
