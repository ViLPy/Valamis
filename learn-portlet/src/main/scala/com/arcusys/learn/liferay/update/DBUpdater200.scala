package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class DBUpdater200 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 200

  override def doUpgrade() {
    System.out.println("Updating to 2.0.0")

    // --- Creating new tables/dropping old ones
    runSQLScript(
      """
        |create table Learn_LFQuizTreeElement (
        |	id_ LONG not null primary key,
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
        |
        |create table Learn_LFPackageGradeStorage (
        |	userId LONG not null,
        |	packageId LONG not null,
        |	grade VARCHAR(75) null,
        |	comment_ VARCHAR(75) null,
        |	primary key (userId, packageId)
        |);
      """.stripMargin)

    // --- Altering Learn_LFCertificate table
    runSQLScript(
      """
        |alter table Learn_LFCertificate add column state_ VARCHAR(300) null;
        |alter table Learn_LFCertificate add column emails VARCHAR(300) null;
        |alter table Learn_LFCertificate add column createdDate DATE null;
        |alter table Learn_LFCertificate add column validPeriodType VARCHAR(500) null;
        |alter table Learn_LFCertificate add column validPeriod INTEGER null;
        |alter table Learn_LFCertificate add column isPublished BOOLEAN null;
        |alter table Learn_LFCertificate add column scope LONG null;
      """.stripMargin)

    // --- Set default values for new columns in Learn_LFCertificate table
    // --- Set validPeriodType=UNLIMITED
    // --- Set validPeriod=0
    // --- Set isPublished=FALSE
    runSQLScript(
      """
        |update Learn_LFCertificate set validPeriodType = 'UNLIMITED';
        |update Learn_LFCertificate set validPeriod = 0;
        |update Learn_LFCertificate set isPublished = FALSE;
      """.stripMargin)

    // --- Adding logo column into Learn_LFQuiz, Learn_LFTincanPackage, Learn_LFPackage tables
    runSQLScript(
      """
        |alter table Learn_LFQuiz add column logo TEXT null;
        |alter table Learn_LFTincanPackage add column logo TEXT null;
        |alter table Learn_LFPackage add column logo TEXT null;
      """.stripMargin)

    // --- Resetting category's and quiz's parentid to null
    runSQLScript("update Learn_LFQuestionCategory set parentid= null;")
    runSQLScript("update Learn_LFQuizQuestionCategory set parentid = null;")

    // --- Updating "duration" type in the Learn_LFTincanLrsResult table
    runSQLScript(
      """
        |alter table Learn_LFTincanLrsResult add column duration_tmp VARCHAR(3000) null;
        |update Learn_LFTincanLrsResult set duration_tmp = duration;
        |alter table Learn_LFTincanLrsResult drop column duration;
        |alter table Learn_LFTincanLrsResult rename column duration_tmp to duration;
      """.stripMargin)

    // --- Updating activityId type and dropping profileId column in the Learn_LFTincanLrsState table
    runSQLScript(
      """
        |alter table Learn_LFTincanLrsState drop column profileId;
        |alter table Learn_LFTincanLrsState add column activityId_tmp VARCHAR(3000) null;
        |update Learn_LFTincanLrsState set activityId_tmp = activityId;
        |alter table Learn_LFTincanLrsState drop column activityId;
        |alter table Learn_LFTincanLrsState rename column activityId_tmp to activityId;
      """.stripMargin)

    // --- Updating activityId type in the Learn_LFTincanActProfile table
    runSQLScript(
      """
        |alter table Learn_LFTincanActProfile add column activityId_tmp VARCHAR(3000) null;
        |update Learn_LFTincanActProfile set activityId_tmp = activityId;
        |alter table Learn_LFTincanActProfile drop column activityId;
        |alter table Learn_LFTincanActProfile rename column activityId_tmp to activityId;
      """.stripMargin)

    // --- Updating parent type in the Learn_LFTincanCtxActivities table
    runSQLScript(
      """
        |alter table Learn_LFTincanCtxActivities add column parent_tmp VARCHAR(3000) null;
        |update Learn_LFTincanCtxActivities set parent_tmp = parent;
        |alter table Learn_LFTincanCtxActivities drop column parent;
        |alter table Learn_LFTincanCtxActivities rename column parent_tmp to parent;
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

    runSQLScript(
      """
        |insert into Learn_LFCertificateCourse (certificateID, siteID, arrangementIndex, 'UNLIMITED', 0) select certificateID, siteID, arrangementIndex from Learn_LFCertificateSite;
        |drop table Learn_LFCertificateSite;
      """.stripMargin
    )
  }
}
