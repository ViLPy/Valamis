package com.arcusys.learn.liferay.upgrade

import com.arcusys.learn.web.DemoService
import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess

class UpgradeProcess_1_4_0 extends LUpgradeProcess {
  override def getThreshold = 145

  override def doUpgrade() {
    val demo = new DemoService
    demo.update()
  }
}