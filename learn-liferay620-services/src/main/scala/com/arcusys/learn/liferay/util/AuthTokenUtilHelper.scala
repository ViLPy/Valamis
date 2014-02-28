package com.arcusys.learn.liferay.util

import javax.servlet.http.HttpServletRequest
import com.liferay.portal.security.auth.AuthTokenUtil

object AuthTokenUtilHelper {
  def getToken(request: HttpServletRequest,
               plid: Long,
               portletId: String): String =
    AuthTokenUtil.getToken(request, plid, portletId)
}
