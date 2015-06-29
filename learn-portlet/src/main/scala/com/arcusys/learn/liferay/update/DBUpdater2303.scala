package com.arcusys.learn.liferay.update

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess
import com.arcusys.learn.liferay.update.migration.{CertificateStorageMigration2303, FileStorageMigration2303}
import com.arcusys.learn.persistence.liferay.service._
import scala.collection.JavaConverters._
import java.net.URLDecoder

class DBUpdater2303 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 2303

  override def doUpgrade() {
    System.out.println("Updating to 2.4")

    new SlickMigration2303()(Configuration).migrate()

    // drop achievements
    dropTable("Learn_LFAchievement")
    dropTable("Learn_LFRequiredActivity")
    dropTable("Learn_LFAchievementActivity")
    dropTable("Learn_LFAchievementUser")

    // drop package social tables
    dropTable("Learn_LFPackageComment")
    dropTable("Learn_LFPackageVote")
    dropTable("Learn_LFSocialPackageTag")
    dropTable("Learn_LFSocialPackage")

    // drop tincan lrs tables
    dropTable("Learn_LFTincanLrsDocument")
    dropTable("Learn_LFTincanActProfile")
    dropTable("Learn_LFTCLrsAgentProfile")
    dropTable("Learn_LFTincanLrsStatement")
    dropTable("Learn_LFTCLrsSubStmnt")
    dropTable("Learn_LFTCLrsStmntRef")
    dropTable("Learn_LFTincanLrsAttachment")
    dropTable("Learn_LFTincanLrsResult")
    dropTable("Learn_LFTincanLrsContext")
    dropTable("Learn_LFTincanCtxActivities")
    dropTable("Learn_LFTincanLrsState")
    dropTable("Learn_LFTincanActivity")
    dropTable("Learn_LFTincanActor")
    dropTable("Learn_LFTincanLrsActivityProfile")
    dropTable("Learn_LFTincanLrsAgentProfile")
    dropTable("Learn_LFTincanLrsContextActivities")
    dropTable("Learn_LFTincanLrsStatementRef")
    dropTable("Learn_LFTincanLrsSubStatement")
    dropTable("Learn_LFTincanManifestActivity")

    // add zIndex and linkedSlideId columns
    runSQLScript("alter table Learn_LFSlideEntity add column zIndex VARCHAR(75);")
    runSQLScript("alter table Learn_LFSlideEntity add column correctLinkedSlideId LONG null;")
    runSQLScript("alter table Learn_LFSlideEntity add column incorrectLinkedSlideId LONG null;")
    runSQLScript("alter table Learn_LFSlide add column statementVerb VARCHAR(75) null;")
    runSQLScript("alter table Learn_LFSlide add column statementObject VARCHAR(75) null;")
    runSQLScript("alter table Learn_LFSlide add column statementCategoryId VARCHAR(75) null;")

  }

  def dropTable(tableName: String): Unit = {
    if (hasTable(tableName) || hasTable(tableName.toUpperCase) || hasTable(tableName.toLowerCase))
      runSQL(s"drop table $tableName ;")
  }
}
