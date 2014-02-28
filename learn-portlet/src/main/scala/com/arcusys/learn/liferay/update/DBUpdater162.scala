package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class DBUpdater162 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 162

  override def doUpgrade() {
    System.out.println("Updating to 1.6.2")
    runSQLScript("alter table Learn_LFTincanActivity alter column tincanID VARCHAR(2000) null;")
    runSQLScript("alter table Learn_LFTincanActivity alter column name TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity alter column description TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity add column objectType VARCHAR(75) null;")
    runSQLScript("alter table Learn_LFTincanActivity add column theType TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity add column moreInfo TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity add column interactionType TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity add column correctResponsesPattern TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity add column choices TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity add column scale TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity add column source TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity add column target TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity add column steps TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity add column extensions TEXT null;")
    runSQLScript("alter table Learn_LFTincanActivity drop column activityType;")
    runSQLScript("alter table Learn_LFTincanActivity drop column launch;")
    runSQLScript("alter table Learn_LFTincanActivity drop column resource;")

    runSQLScript("create table Learn_LFTincanActor (id_ LONG not null primary key,tincanID VARCHAR(75) null,objectType VARCHAR(75) null,name TEXT null,mbox TEXT null,mbox_sha1sum TEXT null,openid TEXT null,account TEXT null,memberOf TEXT null);")
    runSQLScript("create table Learn_LFTincanLrsActivityProfile ( id_ LONG not null primary key, documentId INTEGER null, activityId VARCHAR(75) null, profileId VARCHAR(75) null);")
    runSQLScript("create table Learn_LFTincanLrsAgentProfile ( id_ LONG not null primary key, documentId INTEGER null, agentId INTEGER null, profileId VARCHAR(75) null);")
    runSQLScript("create table Learn_LFTincanLrsAttachment (id_ LONG not null primary key, parentID INTEGER null, usageType TEXT null, display TEXT null, description TEXT null, contentType TEXT null, length INTEGER null, sha2 TEXT null, fileUrl TEXT null);")
    runSQLScript("create table Learn_LFTincanLrsContext (id_ LONG not null primary key, registration VARCHAR(75) null, instructorID INTEGER null, teamID INTEGER null, contextActivitiesID INTEGER null, revision TEXT null, platform TEXT null, language TEXT null, statement TEXT null, extensions TEXT null);")
    runSQLScript("create table Learn_LFTincanLrsContextActivities (id_ LONG not null primary key, parent TEXT null, grouping TEXT null, category TEXT null, other TEXT null);")
    runSQLScript("create table Learn_LFTincanLrsDocument (id_ LONG not null primary key, documentId VARCHAR(75) null, update_ DATE null, content TEXT null, contentType VARCHAR(2000) null);")

    runSQLScript("alter table Learn_LFTincanLrsEndpoint alter column endpoint VARCHAR(2000) null;")
    runSQLScript("alter table Learn_LFTincanLrsEndpoint alter column authType VARCHAR(2000) null;")
    runSQLScript("alter table Learn_LFTincanLrsEndpoint alter column key_ VARCHAR(2000) null;")
    runSQLScript("alter table Learn_LFTincanLrsEndpoint alter column secret VARCHAR(2000) null;")

    runSQLScript("create table Learn_LFTincanLrsResult (id_ LONG not null primary key, score TEXT null, success BOOLEAN null, completion BOOLEAN null, response TEXT null, duration DOUBLE null, extension TEXT null);")
    runSQLScript("create table Learn_LFTincanLrsState (id_ LONG not null primary key, stateId VARCHAR(75) null, documentId VARCHAR(75) null, activityId VARCHAR(75) null, profileId VARCHAR(75) null, registration TEXT null, agentId INTEGER null);")
    runSQLScript("create table Learn_LFTincanLrsStatement (id_ LONG not null primary key, tincanID VARCHAR(75) null, actorID INTEGER null, verbID VARCHAR(2000) null, verbDisplay TEXT null, objType VARCHAR(2000) null, objID INTEGER null, resultID INTEGER null, contextID INTEGER null, timestamp DATE null, stored DATE null, authorityID INTEGER null, version VARCHAR(2000) null);")
    runSQLScript("create table Learn_LFTincanLrsStatementRef (id_ LONG not null primary key, uuid_ VARCHAR(75) null);")
    runSQLScript("create table Learn_LFTincanLrsSubStatement (id_ LONG not null primary key, actorID INTEGER null, verbID VARCHAR(2000) null, verbDisplay TEXT null, objType VARCHAR(2000) null, objID INTEGER null);")
    runSQLScript("create table Learn_LFTincanManifestActivity (id_ LONG not null primary key, tincanID VARCHAR(75) null, packageID LONG null, activityType VARCHAR(75) null, name VARCHAR(2000) null, description VARCHAR(2000) null, launch VARCHAR(2000) null, resource VARCHAR(2000) null);")

    runSQLScript("alter table Learn_LFTincanPackage alter column title VARCHAR(2000) null;")
    runSQLScript("alter table Learn_LFTincanPackage alter column summary VARCHAR(2000) null;")

    runSQLScript("create index IX_961ECBC7 on Learn_LFTincanActivity (tincanID);")

    runSQLScript("create index IX_38F9C274 on Learn_LFTincanActor (memberOf);")
    runSQLScript("create index IX_91905B9F on Learn_LFTincanActor (objectType, name, mbox, mbox_sha1sum, openid);")
    runSQLScript("create index IX_CDC60415 on Learn_LFTincanActor (tincanID);")

    runSQLScript("create index IX_D2D0DBF7 on Learn_LFTincanLrsActivityProfile (activityId, profileId);")

    runSQLScript("create index IX_E8096D4F on Learn_LFTincanLrsAgentProfile (agentId, profileId);")
    runSQLScript("create index IX_BF3CD0C9 on Learn_LFTincanLrsAgentProfile (profileId);")

    runSQLScript("create index IX_68D244E3 on Learn_LFTincanLrsAttachment (parentID);")

    runSQLScript("create index IX_2A760C2C on Learn_LFTincanLrsDocument (documentId);")

    runSQLScript("create index IX_538EDAB4 on Learn_LFTincanLrsState (activityId);")
    runSQLScript("create index IX_98BFD988 on Learn_LFTincanLrsState (activityId, stateId);")

    runSQLScript("create index IX_D28AE6C on Learn_LFTincanLrsStatement (actorID);")
    runSQLScript("create index IX_FE381CB5 on Learn_LFTincanLrsStatement (objType, objID);")
    runSQLScript("create index IX_2DF2F67A on Learn_LFTincanLrsStatement (tincanID);")
    runSQLScript("create index IX_B9F1D082 on Learn_LFTincanLrsStatement (verbID);")

    runSQLScript("create index IX_5C883B21 on Learn_LFTincanManifestActivity (packageID);")
    runSQLScript("create index IX_1CCBF496 on Learn_LFTincanManifestActivity (tincanID);")

  }
}
