package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class DBUpdater201 extends LUpgradeProcess with SQLRunner {
  override def getThreshold = 201

  override def doUpgrade() {
    System.out.println("Updating to 2.0.1")

    // --- Creating new tables/dropping old ones

    // --- Altering learn_LFCertificate table
    runSQLScript(
      """
        |alter table learn_LFPackageGradeStorage add column date_ DATE null;
      """.stripMargin)

  }
}
