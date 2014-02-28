package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.util.Base64

object Base64Helper {
  def decode(data: String): Array[Byte] = Base64.decode(data)
  def stringToObject(data: String): Any = Base64.stringToObject(data)
  def objectToString(data: Any): String = Base64.objectToString(data)
}
