package com.arcusys.learn.liferay.upgrade

import com.liferay.portal.kernel.upgrade.UpgradeProcess
import com.arcusys.learn.web.DemoService

class UpgradeProcess_1_4_0 extends UpgradeProcess {
  override def getThreshold = 145

  override def doUpgrade() {
    val demo = new DemoService
    demo.update()
  }
}