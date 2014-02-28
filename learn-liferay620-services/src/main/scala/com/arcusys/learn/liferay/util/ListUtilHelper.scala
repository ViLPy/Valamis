package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.util.ListUtil

object ListUtilHelper {
  def copy[E](master: java.util.List[E]): java.util.List[E] = ListUtil.copy(master)
}
