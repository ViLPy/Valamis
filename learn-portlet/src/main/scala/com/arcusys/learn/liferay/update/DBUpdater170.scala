package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class DBUpdater170 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 170

  override def doUpgrade() {
    System.out.println("Updating to 1.7.0")
    runSQLScript("alter table Learn_LFActivityState alter column activityID VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFAttemptData alter column dataKey VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFAttemptData alter column activityID VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFCertificate alter column title VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFConditionRule alter column ruleType VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFCourse alter column grade VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFFileStorage alter column filename VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFGlobalObjectiveState alter column mapKey VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFObjective alter column identifier VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFObjectiveState alter column mapKey VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFPackageScopeRule alter column scope VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFPackageScopeRule alter column scopeID VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFPlayerScopeRule alter column playerID VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFResource alter column resourceID VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFSequencing rename column onlyCurrentAttemptObjectiveProgressForChildren to cAttemptObjectiveProgressChild;")
    runSQLScript("alter table Learn_LFSequencing rename column onlyCurrentAttemptAttemptProgressForChildren to cAttemptAttemptProgressChild;")

    runSQLScript("alter table Learn_LFTincanLrsActivityProfile rename to Learn_LFTincanActProfile;")
    runSQLScript("alter table Learn_LFTincanLrsContextActivities rename to Learn_LFTincanCtxActivities;")
    runSQLScript("alter table Learn_LFTincanManifestActivity rename to Learn_LFTincanManifestAct;")

    runSQLScript("alter table Learn_LFTincanActor alter column name VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanActor alter column mbox VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanActor alter column mbox_sha1sum VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanActor alter column openid VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanActor alter column memberOf VARCHAR(3000) null;")
    runSQLScript("create table Learn_LFTincanClientApiStorage (id_ LONG not null primary key,name VARCHAR(75) null,description VARCHAR(75) null,secret VARCHAR(75) null,url VARCHAR(75) null,redirectUrl VARCHAR(75) null,scope VARCHAR(75) null,iconUrl VARCHAR(75) null,token VARCHAR(75) null,code_ VARCHAR(75) null,issuedAt DATE null,expiredIn LONG);")
    runSQLScript("alter table Learn_LFTincanCtxActivities alter column parent VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanCtxActivities alter column grouping VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanCtxActivities alter column category VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanCtxActivities alter column other VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanManifestAct alter column name VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanManifestAct alter column description VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanManifestAct alter column launch VARCHAR(3000) null;")
    runSQLScript("alter table Learn_LFTincanManifestAct rename column resource to resourceID;")

    runSQLScript("drop index IX_D2D0DBF7 on Learn_LFTincanLrsActivityProfile;")
    runSQLScript("drop index IX_5C883B21 on Learn_LFTincanManifestActivity;")
    runSQLScript("drop index IX_1CCBF496 on Learn_LFTincanManifestActivity;")
    runSQLScript("drop index IX_91905B9F on Learn_LFTincanManifestActivity;")
    runSQLScript("create index IX_573D80BD on Learn_LFTincanActor (objectType, mbox, mbox_sha1sum, openid, account);")
    runSQLScript("create index IX_B4AAC647 on Learn_LFTincanActProfile (activityId);")
    runSQLScript("create index IX_2BA132AD on Learn_LFTincanActProfile (activityId, profileId);")
    runSQLScript("create index IX_8EDF4704 on Learn_LFTincanClientApiStorage (code_);")
    runSQLScript("create index IX_128C132B on Learn_LFTincanClientApiStorage (token);")
    runSQLScript("create index IX_C8DCDCE5 on Learn_LFTincanLrsAgentProfile (agentId);")
    runSQLScript("create index IX_ACEF0F54 on Learn_LFTincanManifestAct (packageID);")
    runSQLScript("create index IX_50F04E03 on Learn_LFTincanManifestAct (tincanID);")
  }
}
