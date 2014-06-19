package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class DBUpdater200 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 200

  override def doUpgrade() {
    System.out.println("Updating to 2.0.0")

    // --- Creating new tables/dropping old ones
    runSQLScript(
      """
        |drop table learn_LFCertificateSite;
        |
        |create table Learn_LFQuizTreeElement (
        |	id LONG not null primary key,
        |	quizID INTEGER null,
        |	elementID VARCHAR(3000) null,
        |	isCategory BOOLEAN null,
        |	parentID VARCHAR(3000) null,
        |	arrangementIndex INTEGER null
        |);
        |
        |create table Learn_LFCertificateCourse (
        |	certificateID LONG not null,
        |	courseID LONG not null,
        |	arrangementIndex INTEGER null,
        |	periodType VARCHAR(3000) null,
        |	period INTEGER null,
        |	primary key (certificateID, courseID)
        |);
        |
        |create table Learn_LFCertificateActivity (
        |	certificateID LONG not null,
        |	activityName VARCHAR(3000) not null,
        |	datacount INTEGER null,
        |	periodType VARCHAR(3000) null,
        |	period INTEGER null,
        |	primary key (certificateID, activityName)
        |);
        |
        |create table Learn_LFCertificateTincanStatement (
        |	certificateID LONG not null,
        |	verb VARCHAR(3000) not null,
        |	object VARCHAR(3000) not null,
        |	periodType VARCHAR(3000) null,
        |	period INTEGER null,
        |	primary key (certificateID, verb, object)
        |);
      """.stripMargin)

    // --- Altering learn_LFCertificate table
    runSQLScript(
      """
        |alter table learn_LFCertificate add column state VARCHAR(300) null;
        |alter table learn_LFCertificate add column emails VARCHAR(300) null;
        |alter table learn_LFCertificate add column createdDate DATE null;
        |alter table learn_LFCertificate add column validPeriodType VARCHAR(500) null;
        |alter table learn_LFCertificate add column validPeriod INTEGER null;
        |alter table learn_LFCertificate add column isPublished BOOLEAN null;
        |alter table learn_LFCertificate add column scope LONG null;
      """.stripMargin)

    // --- Adding logo column into learn_LFQuiz, learn_LFTincanPackage, learn_LFPackage tables
    runSQLScript(
      """
        |alter table learn_LFQuiz add column logo TEXT null;
        |alter table learn_LFTincanPackage add column logo TEXT null;
        |alter table learn_LFPackage add column logo TEXT null;
      """.stripMargin)

    // --- Resetting category's and quiz's parentid to null
    runSQLScript(
      """
        | update learn_lfquestioncategory set parentid= null;
        | update learn_lfquizquestioncategory set parentid = null;
      """.stripMargin)

    // --- Updating "duration" type in the learn_LFTincanLrsResult table
    runSQLScript(
      """
        |alter table learn_LFTincanLrsResult add column duration_tmp VARCHAR(3000) null;
        |update learn_LFTincanLrsResult set duration_tmp = duration;
        |alter table learn_LFTincanLrsResult drop column duration;
        |alter table learn_LFTincanLrsResult rename column duration_tmp to duration;
      """.stripMargin)

    // --- Updating activityId type and dropping profileId column in the learn_LFTincanLrsState table
    runSQLScript(
      """
        |alter table learn_LFTincanLrsState drop column profileId;
        |alter table learn_LFTincanLrsState add column activityId_tmp VARCHAR(3000) null;
        |update learn_LFTincanLrsState set activityId_tmp = activityId;
        |alter table learn_LFTincanLrsState drop column activityId;
        |alter table learn_LFTincanLrsState rename column activityId_tmp to activityId;
      """.stripMargin)

    // --- Updating activityId type in the learn_LFTincanActProfile table
    runSQLScript(
      """
        |alter table learn_LFTincanActProfile add column activityId_tmp VARCHAR(3000) null;
        |update learn_LFTincanActProfile set activityId_tmp = activityId;
        |alter table learn_LFTincanActProfile drop column activityId;
        |alter table learn_LFTincanActProfile rename column activityId_tmp to activityId;
      """.stripMargin)

    // --- Updating parent type in the learn_LFTincanCtxActivities table
    runSQLScript(
      """
        |alter table learn_LFTincanCtxActivities add column parent_tmp VARCHAR(3000) null;
        |update learn_LFTincanCtxActivities set parent_tmp = parent;
        |alter table learn_LFTincanCtxActivities drop column parent;
        |alter table learn_LFTincanCtxActivities rename column parent_tmp to parent;
      """.stripMargin)

    // --- Altering Learn_LFCertificateUser table
    runSQLScript(
      """
        |create table Learn_LFCertificateUser_tmp (
        |	certificateID LONG not null,
        |	userID LONG not null,
        |	attachedDate DATE null,
        |	primary key (certificateID, userID)
        |);
        |insert into Learn_LFCertificateUser_tmp (certificateID, userID) select certificateID, userID from Learn_LFCertificateUser;
        |drop table Learn_LFCertificateUser;
        |alter table Learn_LFCertificateUser_tmp rename to Learn_LFCertificateUser;
      """.stripMargin)

    // --- Indexing altered tables
    runSQLScript(
      """
        |create index IX_AFAFFDFC on Learn_LFTincanLrsState (activityId, agentId);
        |create index IX_88077015 on Learn_LFTincanLrsState (activityId, stateId, agentId, registration);
        |create index IX_6B35B606 on Learn_LFCertificateTincanStatement (certificateID);
        |create index IX_9ADBD0CC on Learn_LFCertificateTincanStatement (certificateID, verb, object);
        |create index IX_59F13A8F on Learn_LFCertificateTincanStatement (object);
        |create index IX_64A8ABEF on Learn_LFCertificateTincanStatement (verb);
        |create index IX_9DBABFE2 on Learn_LFCertificateTincanStatement (verb, object);
        |create index IX_5328A41E on Learn_LFQuizTreeElement (quizID);
        |create index IX_7C8C5429 on Learn_LFQuizTreeElement (quizID, elementID);
      """.stripMargin)
  }
}
