package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.util.HtmlUtil

object HtmlUtilHelper {
  def stripHtml(html: String): String = HtmlUtil.stripHtml(html)
}
