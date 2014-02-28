package com.arcusys.learn.liferay.helpers

import com.liferay.portal.kernel.util.FileUtil

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