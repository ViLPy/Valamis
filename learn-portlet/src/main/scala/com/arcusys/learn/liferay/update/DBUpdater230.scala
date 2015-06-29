package com.arcusys.learn.liferay.update

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess
import com.liferay.portal.service.CompanyLocalServiceUtil

import scala.collection.JavaConverters._
import scala.slick.driver.JdbcDriver
import scala.slick.jdbc.JdbcBackend

class DBUpdater230 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 230


  override def doUpgrade() {
    System.out.println("Updating to 2.3")

    // restore missing updates, ce 2.2
    // rename table Learn_LFCertificateTincanStatement -> Learn_LFCertTCStmnt
    runSQLScript("""ALTER TABLE Learn_LFCertificateTincanStatement RENAME TO Learn_LFCertTCStmnt;""".stripMargin)
    runSQLScript("""DELETE FROM counter WHERE name='com.arcusys.learn.persistence.liferay.model.LFCertTCStmnt';""".stripMargin)
    runSQLScript("""UPDATE counter SET name='com.arcusys.learn.persistence.liferay.model.LFCertTCStmnt' WHERE name='com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement';""".stripMargin)

    // rename table Learn_LFGlobalObjectiveState -> Learn_LFGlblObjectiveState
    runSQLScript("""ALTER TABLE Learn_LFGlobalObjectiveState RENAME TO Learn_LFGlblObjectiveState;""".stripMargin)
    runSQLScript("""DELETE FROM counter WHERE name='com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState';""".stripMargin)
    runSQLScript("""UPDATE counter SET name='com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState' WHERE name='com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState';""".stripMargin)

    // rename table Learn_LFQuizQuestionCategory -> Learn_LFQuizQuestCat
    runSQLScript("""ALTER TABLE Learn_LFQuizQuestionCategory RENAME TO Learn_LFQuizQuestCat;""".stripMargin)
    runSQLScript("""DELETE FROM counter WHERE name='com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat';""".stripMargin)
    runSQLScript("""UPDATE counter SET name='com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat' WHERE name='com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory';""".stripMargin)

    // rename table Learn_LFSequencingPermissions -> Learn_LFSeqPermissions
    runSQLScript("""ALTER TABLE Learn_LFSequencingPermissions RENAME TO Learn_LFSeqPermissions;""".stripMargin)
    runSQLScript("""DELETE FROM counter WHERE name='com.arcusys.learn.persistence.liferay.model.LFSeqPermissions';""".stripMargin)
    runSQLScript("""UPDATE counter SET name='com.arcusys.learn.persistence.liferay.model.LFSeqPermissions' WHERE name='com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions';""".stripMargin)

    // rename table Learn_LFTincanClientApiStorage -> Learn_LFTCClntApiStorage
    runSQLScript("""ALTER TABLE Learn_LFTincanClientApiStorage RENAME TO Learn_LFTCClntApiStorage;""".stripMargin)
    runSQLScript("""DELETE FROM counter WHERE name='com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage';""".stripMargin)
    runSQLScript("""UPDATE counter SET name='com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage' WHERE name='com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage';""".stripMargin)

    // rename table Learn_LFTincanLrsAgentProfile -> Learn_LFTCLrsAgentProfile
    runSQLScript("""ALTER TABLE Learn_LFTincanLrsAgentProfile RENAME TO Learn_LFTCLrsAgentProfile;""".stripMargin)

    // rename table Learn_LFTincanLrsStatementRef -> Learn_LFTCLrsStmntRef
    runSQLScript("""ALTER TABLE Learn_LFTincanLrsStatementRef RENAME TO Learn_LFTCLrsStmntRef;""".stripMargin)

    // rename table Learn_LFTincanLrsSubStatement -> Learn_LFTCLrsSubStmnt
    runSQLScript("""ALTER TABLE Learn_LFTincanLrsSubStatement RENAME TO Learn_LFTCLrsSubStmnt;""".stripMargin)

    //Learn_LFCertTCStmnt
    runSQLScript("""alter table Learn_LFCertTCStmnt alter column "verb" TYPE VARCHAR(1024);""".stripMargin)
    runSQLScript("""alter table Learn_LFCertTCStmnt alter column "object" TYPE VARCHAR(4096);""".stripMargin)
    runSQLScript("""alter table Learn_LFCertTCStmnt alter column "periodType" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFAchievement
    runSQLScript("""alter table Learn_LFAchievement alter column "title" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFBigDecimal
    runSQLScript("""alter table Learn_LFBigDecimal alter column "text_" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFCertificate
    runSQLScript("""alter table Learn_LFCertificate alter column "logo" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFCertificate alter column "shortDescription" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFCertificate alter column "state_" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFCertificate alter column "emails" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFCertificate alter column "validPeriodType" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFCertificateActivity
    runSQLScript("""alter table Learn_LFCertificateActivity alter column "activityName" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFCertificateActivity alter column "periodType" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFCertificateCourse
    runSQLScript("""alter table Learn_LFCertificateCourse alter column "periodType" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFConfig
    runSQLScript("""alter table Learn_LFConfig alter column "dataKey" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFConfig alter column "dataValue" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFLRSToActSettng
    runSQLScript("""alter table Learn_LFLRSToActivitySetting alter column "title" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFLessonLimit
    runSQLScript("""alter table Learn_LFLessonLimit alter column "itemType" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFLessonLimit alter column "rerunIntervalType" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFPackageComment
    runSQLScript("""alter table Learn_LFPackageComment alter column "comment_" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFPackageGradeStorage
    runSQLScript("""alter table Learn_LFPackageGradeStorage alter column "grade" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFPackageGradeStorage alter column "comment_" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFQuiz
    runSQLScript("""alter table Learn_LFQuiz alter column "logo" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFQuizTreeElement
    runSQLScript("""alter table Learn_LFQuizTreeElement alter column "elementID" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFQuizTreeElement alter column "parentID" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFRequiredActivity
    runSQLScript("""alter table Learn_LFRequiredActivity alter column "activityClassName" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFRole
    runSQLScript("""alter table Learn_LFRole alter column "permission" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFSiteDependentConfig
    runSQLScript("""alter table Learn_LFSiteDependentConfig alter column "dataKey" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFSiteDependentConfig alter column "dataValue" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFSocialPackageTag
    runSQLScript("""alter table Learn_LFSocialPackageTag alter column "name" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTincanActProfile
    runSQLScript("""alter table Learn_LFTincanActProfile alter column "activityId" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanActProfile alter column "profileId" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTincanActivity
    runSQLScript("""alter table Learn_LFTincanActivity alter column "objectType" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTincanActor
    runSQLScript("""alter table Learn_LFTincanActor alter column "tincanID" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanActor alter column "objectType" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTCClntApiStorage
    runSQLScript("""alter table Learn_LFTCClntApiStorage alter column "name" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTCClntApiStorage alter column "description" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTCClntApiStorage alter column "secret" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTCClntApiStorage alter column "url" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTCClntApiStorage alter column "redirectUrl" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTCClntApiStorage alter column "scope" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTCClntApiStorage alter column "iconUrl" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTCClntApiStorage alter column "token" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTCClntApiStorage alter column "code_" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTCLrsAgentProfile
    runSQLScript("""alter table Learn_LFTCLrsAgentProfile alter column "profileId" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTincanLrsContext
    runSQLScript("""alter table Learn_LFTincanLrsContext alter column "registration" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTincanLrsDocument
    runSQLScript("""alter table Learn_LFTincanLrsDocument alter column "documentId" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTincanLrsResult
    runSQLScript("""alter table Learn_LFTincanLrsResult alter column "duration" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTincanLrsState
    runSQLScript("""alter table Learn_LFTincanLrsState alter column "stateId" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanLrsState alter column "documentId" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanLrsState alter column "activityId" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTincanLrsStatement
    runSQLScript("""alter table Learn_LFTincanLrsStatement alter column "tincanID" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTCLrsStmntRef
    runSQLScript("""alter table Learn_LFTCLrsStmntRef alter column "uuid_" TYPE VARCHAR(512);""".stripMargin)

    //Learn_LFTincanURI
    runSQLScript("""alter table Learn_LFTincanURI alter column "objID" TYPE VARCHAR(512);""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanURI alter column "objType" TYPE VARCHAR(512);""".stripMargin)

    // restore missing updates end

    runSQLScript(
      """  create table Learn_LFSlide (
        |    id_ LONG not null primary key,
        |    bgcolor VARCHAR(75) null,
        |    bgimage VARCHAR(512) null,
        |    title VARCHAR(75) null,
        |    slideSetId LONG null,
        |    topSlideId LONG null,
        |    leftSlideId LONG null
        |  );""".stripMargin)

    runSQLScript("""  create table Learn_LFSlideEntity (
                 |    id_ LONG not null primary key,
                 |    top_ VARCHAR(75) null,
                 |    left_ VARCHAR(75) null,
                 |    width VARCHAR(75) null,
                 |    height VARCHAR(75) null,
                 |    content VARCHAR(2000000) null,
                 |    entityType VARCHAR(75) null,
                 |    slideId LONG null
                 |  );""".stripMargin)

    runSQLScript(
      """  create table Learn_LFSlideSet (
        |    id_ LONG not null primary key,
        |    title VARCHAR(75) null,
        |    description TEXT null,
        |    logo VARCHAR(75) null,
        |    courseId LONG null
        |  );""".stripMargin)

    runSQLScript("""create table Learn_LFCertificatePackageGoal (
                    |	certificateID LONG not null,
                    |	packageID LONG not null,
                    |	periodType VARCHAR(75) null,
                    |	period INTEGER null,
                    |	primary key (certificateID, packageID)
                    |);
                    |create index IX_49818745 on Learn_LFCertificatePackageGoal (certificateID);
                    |create index IX_5EEA22EC on Learn_LFCertificatePackageGoal (certificateID, packageID);
                    |create index IX_879682F4 on Learn_LFCertificatePackageGoal (packageID);
                    | """.stripMargin)

    runSQLScript("""alter table Learn_LFPackage add column beginDate DATE null;""".stripMargin)
    runSQLScript("""alter table Learn_LFPackage add column endDate DATE null;""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanPackage add column beginDate DATE null;""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanPackage add column endDate DATE null;""".stripMargin)

    runSQLScript("""alter table Learn_LFLessonLimit alter column "itemtype" TYPE VARCHAR(75);""".stripMargin)
    runSQLScript("""alter table Learn_LFCertificateActivity alter column "activityname" TYPE VARCHAR(75);""".stripMargin)

    // TODO: do not use persistence layer here
    implicit var bindingModule = Configuration
    new CreatePackageAssets().run(CompanyLocalServiceUtil.getCompanies.asScala.map(_.getCompanyId))
  }
}