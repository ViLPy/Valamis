package com.arcusys.learn.liferay.update

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class DBUpdater2325 extends LUpgradeProcess with SQLRunner {
  implicit lazy val bindingModule = Configuration

  override def getThreshold = 2325

  override def doUpgrade(): Unit = {
    runSQLScript("alter table Learn_LFSlideEntity add column notifyCorrectAnswer BOOLEAN null;")
  }
}
