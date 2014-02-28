package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.util.ParamUtil
import javax.servlet.http.HttpServletRequest

object ParamUtilHelper {
  def getLong(request: HttpServletRequest, param: String): Long = ParamUtil.getLong(request, param)
  def getBoolean(request: HttpServletRequest, param: String): Boolean = ParamUtil.getBoolean(request, param)
}
