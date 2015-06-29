package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class DBUpdater220 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 220

  override def doUpgrade() {
    System.out.println("Updating to 2.2")

    // update tincan table columns length
    runSQLScript("""alter table Learn_LFTincanManifestAct alter column "tincanid" TYPE VARCHAR(2000);""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanManifestAct alter column "description" TYPE VARCHAR(2000);""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanManifestAct alter column "resourceid" TYPE VARCHAR(2000);""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanManifestAct alter column "activitytype"  TYPE VARCHAR(2000);""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanManifestAct alter column "launch" TYPE VARCHAR(2000);""".stripMargin)
    runSQLScript("""alter table Learn_LFTincanManifestAct alter column "name" TYPE VARCHAR(2000);""".stripMargin)

    // rename table passinglimit -> lessonlimit
    runSQLScript("""ALTER TABLE Learn_LFPassingLimit RENAME TO Learn_LFLessonLimit;""".stripMargin)

    // rename table Learn_LFCertificateTincanStatement -> Learn_LFCertTCStmnt
    runSQLScript("""ALTER TABLE Learn_LFCertificateTincanStatement RENAME TO Learn_LFCertTCStmnt;""".stripMargin)

    // rename table Learn_LFGlobalObjectiveState -> Learn_LFGlblObjectiveState
    runSQLScript("""ALTER TABLE Learn_LFGlobalObjectiveState RENAME TO Learn_LFGlblObjectiveState;""".stripMargin)

    // rename table Learn_LFQuizQuestionCategory -> Learn_LFQuizQuestCat
    runSQLScript("""ALTER TABLE Learn_LFQuizQuestionCategory RENAME TO Learn_LFQuizQuestCat;""".stripMargin)

    // rename table Learn_LFSequencingPermissions -> Learn_LFSeqPermissions
    runSQLScript("""ALTER TABLE Learn_LFSequencingPermissions RENAME TO Learn_LFSeqPermissions;""".stripMargin)

    // rename table Learn_LFTincanClientApiStorage -> Learn_LFTCClntApiStorage
    runSQLScript("""ALTER TABLE Learn_LFTincanClientApiStorage RENAME TO Learn_LFTCClntApiStorage;""".stripMargin)

    // rename table Learn_LFTincanLrsAgentProfile -> Learn_LFTCLrsAgentProfile
    runSQLScript("""ALTER TABLE Learn_LFTincanLrsAgentProfile RENAME TO Learn_LFTCLrsAgentProfile;""".stripMargin)

    // rename table Learn_LFTincanLrsStatementRef -> Learn_LFTCLrsStmntRef
    runSQLScript("""ALTER TABLE Learn_LFTincanLrsStatementRef RENAME TO Learn_LFTCLrsStmntRef;""".stripMargin)

    // rename table Learn_LFTincanLrsSubStatement -> Learn_LFTCLrsSubStmnt
    runSQLScript("""ALTER TABLE Learn_LFTincanLrsSubStatement RENAME TO Learn_LFTCLrsSubStmnt;""".stripMargin)

    // add columns to lessonlimit
    runSQLScript("""ALTER TABLE Learn_lflessonlimit RENAME column itemValue TO passingLimit;""".stripMargin)
    runSQLScript("""ALTER TABLE Learn_lflessonlimit ADD COLUMN rerunInterval INTEGER null;""".stripMargin)
    runSQLScript("""ALTER TABLE Learn_lflessonlimit ADD COLUMN rerunIntervalType VARCHAR(75) null;""".stripMargin)

    // add columns to quiz
    runSQLScript("""alter table Learn_lfquiz add column maxDuration INTEGER null;""".stripMargin)
    runSQLScript("""alter table Learn_lfquizquestion add column groupId INTEGER null;""".stripMargin)

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
  }
}
