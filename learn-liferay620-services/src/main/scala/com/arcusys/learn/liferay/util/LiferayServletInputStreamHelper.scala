package com.arcusys.learn.liferay.util

import java.io.StringBufferInputStream

import com.liferay.portal.kernel.servlet.ServletInputStreamAdapter

/**
 * Created by igorborisov on 11.12.14.
 */
object LiferayServletInputStreamHelper {
  def getServletInputStream(s: String) = {
    new ServletInputStreamAdapter(new StringBufferInputStream(s))
  }
}
