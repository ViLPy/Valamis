package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.util.PropsUtil

object PropsUtilHelper {
  def get(key: String): String = PropsUtil.get(key)
}
