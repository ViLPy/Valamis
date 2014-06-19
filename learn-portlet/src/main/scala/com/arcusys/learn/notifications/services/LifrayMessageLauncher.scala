package com.arcusys.learn.notifications.services

import com.liferay.portal.kernel.events.SimpleAction
import com.liferay.portal.kernel.log.{ Log, LogFactoryUtil }

class LifrayMessageLauncher extends SimpleAction {
  private val log: Log = LogFactoryUtil.getLog(classOf[LifrayMessageLauncher])

  def run(p1: Array[String]) {
    NotificationScheduler.start()
    log.info("Message Notification Sender is started")
  }

}
