package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class DBUpdater210 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 210

  override def doUpgrade() {
    System.out.println("Updating to 2.1.0")

    // --- Creating new table
    runSQLScript("""create table Learn_LFSiteDependentConfig (
                   |	id_ LONG not null primary key,
                   |	siteID INTEGER null,
                   |	dataKey VARCHAR(75) null,
                   |	dataValue VARCHAR(75) null
                   |);""".stripMargin)

    runSQLScript("""create table Learn_LFLRSToActivitySetting (
                   |	id_ LONG not null primary key,
                   |	courseID INTEGER null,
                   |	title VARCHAR(75) null,
                   |	activityFilter VARCHAR(1000) null,
                   |	verbFilter VARCHAR(1000) null
                   |);""".stripMargin)

    runSQLScript("alter table Learn_LFQuizQuestion add column autoShowAnswer BOOLEAN null;")
  }
}
