package com.arcusys.learn.liferay.update

import com.liferay.portal.kernel.upgrade.UpgradeProcess

class DBUpdater155 extends UpgradeProcess with SQLRunner {
  override def getThreshold = 156

  override def doUpgrade() {
    runSQLScript("create table Learn_LFConfig23 (id_ LONG not null primary key,dataKey VARCHAR(75) null,dataValue VARCHAR(75) null);")
    System.out.println("Updating to 1.5.5")
    runSQLScript("alter table Learn_LFCertificate add column companyID INTEGER null;")
    runSQLScript("create table Learn_LFConfig (id_ LONG not null primary key,dataKey VARCHAR(75) null,dataValue VARCHAR(75) null);")
    runSQLScript("alter table Learn_LFPackageVote add column voteValue INTEGER null;")
    runSQLScript("create index IX_936CDEE0 on Learn_LFCertificate (companyID);")
    runSQLScript("create index IX_FF65B1C8 on Learn_LFConfig (dataKey);")
  }
}
