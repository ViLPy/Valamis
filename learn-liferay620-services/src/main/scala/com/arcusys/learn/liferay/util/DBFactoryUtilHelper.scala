package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.dao.db.DBFactoryUtil

object DBFactoryUtilHelper {
  def getDB = DBFactoryUtil.getDB
}
