package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class DBUpdater220 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 220

  override def doUpgrade() {
    System.out.println("Updating to 2.2")

    // update tincan table columns length
    runSQLScript("""alter table learn_lftincanmanifestact alter column "tincanid" TYPE VARCHAR(2000);""".stripMargin)
    runSQLScript("""alter table learn_lftincanmanifestact alter column "description" TYPE VARCHAR(2000);""".stripMargin)
    runSQLScript("""alter table learn_lftincanmanifestact alter column "resourceid" TYPE VARCHAR(2000);""".stripMargin)
    runSQLScript("""alter table learn_lftincanmanifestact alter column "activitytype"  TYPE VARCHAR(2000);""".stripMargin)
    runSQLScript("""alter table learn_lftincanmanifestact alter column "launch" TYPE VARCHAR(2000);""".stripMargin)
    runSQLScript("""alter table learn_lftincanmanifestact alter column "name" TYPE VARCHAR(2000);""".stripMargin)

    // rename table passinglimit -> lessonlimit
    runSQLScript("""ALTER TABLE learn_lfpassinglimit RENAME TO learn_lflessonlimit;""".stripMargin)

    // add columns to lessonlimit
    runSQLScript("""ALTER TABLE learn_lflessonlimit RENAME column itemValue TO passingLimit;""".stripMargin)
    runSQLScript("""ALTER TABLE learn_lflessonlimit ADD COLUMN rerunInterval INTEGER null;""".stripMargin)
    runSQLScript("""ALTER TABLE learn_lflessonlimit ADD COLUMN rerunIntervalType VARCHAR(75) null;""".stripMargin)

    // add columns to quiz
    runSQLScript("""alter table learn_lfquiz add column maxDuration INTEGER null;""".stripMargin)
    runSQLScript("""alter table Learn_lfquizquestion add column groupId INTEGER null;""".stripMargin)
  }
}
