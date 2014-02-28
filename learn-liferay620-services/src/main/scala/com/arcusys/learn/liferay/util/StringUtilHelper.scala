package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.util.StringUtil

object StringUtilHelper {
  def shorten(text: String, size: Int) = StringUtil.shorten(text, size)

  def split(text: String) = StringUtil.split(text)
}
