package com.arcusys.liferay.util

import com.liferay.portal.kernel.util._

object HookHelpers {
  def getString(path: String) = {
    new String(getBytes(path))
  }

  def getBytes(path: String) = {
    FileUtil.getBytes(getInputStream(path))
  }

  def getInputStream(path: String) = {
    Thread.currentThread().getContextClassLoader.getResourceAsStream(path)
  }
}