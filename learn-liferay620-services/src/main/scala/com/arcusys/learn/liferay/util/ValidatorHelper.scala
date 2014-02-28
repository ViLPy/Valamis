package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.util.Validator

object ValidatorHelper {
  def isNull(obj: AnyRef) = Validator.isNull(obj)
}
