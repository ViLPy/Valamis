package com.arcusys.learn.liferay.util

import com.liferay.portal.security.auth.PrincipalThreadLocal

object PrincipalThreadLocalHelper {
  def setName(name: Long) {
    PrincipalThreadLocal.setName(name)
  }
}
