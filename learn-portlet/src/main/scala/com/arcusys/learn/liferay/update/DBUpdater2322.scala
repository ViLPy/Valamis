package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

/**
 * Created by ashikov on 10.06.15.
 */
class DBUpdater2322 extends LUpgradeProcess with SQLRunner
{
  override def getThreshold = 2322

  override def doUpgrade(): Unit = {
    //Add correct/incorrect answer columns
    runSQLScript("alter table Learn_LFQuestion add column rightAnswerText TEXT default ''")
    runSQLScript("alter table Learn_LFQuestion add column wrongAnswerText TEXT default ''")
  }
}