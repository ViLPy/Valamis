package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.util.DBFactoryUtilHelper

trait SQLRunner {
  def runSQLScript(sql: String) {
    try {
      sql.split(';').foreach(stmt => {
        if (sql.nonEmpty)
          DBFactoryUtilHelper.getDB.runSQL(
            stmt
              .replace("\n", "")
              .replace("\r", "")
              .replace("\t", "")
          )
      })
    } catch {
      //case e: SecurityException => throw e
      case _: Throwable =>
    }
  }
}
