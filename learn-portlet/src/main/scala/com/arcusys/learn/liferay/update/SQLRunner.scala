package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.util.DBFactoryUtilHelper

trait SQLRunner {
  def runSQLScript(sql: String) {
    try {
      DBFactoryUtilHelper.getDB.runSQL(sql)
    } catch {
      case _: Throwable =>
    }
  }
}
