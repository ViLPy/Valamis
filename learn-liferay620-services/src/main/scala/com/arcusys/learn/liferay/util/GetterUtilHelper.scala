package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.util.GetterUtil

object GetterUtilHelper {
  def getLong(value: String):Long = GetterUtil.getLong(value)
  def getBoolean(value: String):Boolean = GetterUtil.getBoolean(value)
  def getInteger(value: String):Int = GetterUtil.getInteger(value)
}
