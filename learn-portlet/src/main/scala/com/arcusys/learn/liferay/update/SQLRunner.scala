package com.arcusys.learn.liferay.update

import com.liferay.portal.kernel.dao.db.DBFactoryUtil

trait SQLRunner {
  def runSQLScript(sql: String) {
    try {
      DBFactoryUtil.getDB.runSQL(sql)
    } catch {
      case _ => {}
    }
  }
}
