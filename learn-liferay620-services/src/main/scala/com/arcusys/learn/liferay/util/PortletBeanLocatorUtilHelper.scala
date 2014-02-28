package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.bean.{PortletBeanLocatorUtil, BeanLocator}

object PortletBeanLocatorUtilHelper {
  def getBeanLocator(servletContextName: String): BeanLocator =
    PortletBeanLocatorUtil.getBeanLocator(servletContextName)

  def setBeanLocator(servletContextName: String, beanLocator: BeanLocator) {
    PortletBeanLocatorUtil.setBeanLocator(servletContextName, beanLocator)
  }
}
