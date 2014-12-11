package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class DBUpdater211 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 211

  override def doUpgrade() {
    System.out.println("Updating to 2.1.1")

    // --- Creating new table
    runSQLScript("""create table Learn_LFTincanURI
                   |(
                   |  uri VARCHAR(100) not null primary key,
                   |  objID VARCHAR(75),
                   |  objType VARCHAR(75),
                   |  content VARCHAR(2000) null
                   |);
                   |create index IX_B6F136A5 on Learn_LFTincanURI (objID, objType);""".stripMargin)

    // --- Creating new table
    runSQLScript("""create table Learn_LFPassingLimit (
                   |        itemID LONG not null,
                   |        itemType VARCHAR(75) not null,
                   |        itemValue INTEGER,
                   |	      primary key (itemID, itemType)
                   |);
                   |create index IX_B853C068 on Learn_LFPassingLimit (itemID, itemType);""".stripMargin)

    // --- Creating new table
    runSQLScript("""create table Learn_LFQuizAnswerScore (
                   |        answerID LONG not null primary key,
                   |        score DOUBLE null
                   |);
                   |create index IX_BEFA7D1D on Learn_LFQuizAnswerScore (answerID);""".stripMargin)

    // --- Creating new indexes
    runSQLScript("""create index IX_8CF8305E on Learn_LFLRSToActivitySetting (courseID);
                   |
                   |create index IX_CAD38397 on Learn_LFQuizTreeElement (quizID, parentID);
                   |
                   |create index IX_5B99B8FA on Learn_LFSiteDependentConfig (dataKey);
                   |
                   |create index IX_7E566724 on Learn_LFSiteDependentConfig (siteID, dataKey);
                   |
                   |create index IX_E1971E41 on Learn_LFSiteDependentConfig (siteID);""".stripMargin)
  }
}
