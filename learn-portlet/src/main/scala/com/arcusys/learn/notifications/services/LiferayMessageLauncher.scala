package com.arcusys.learn.notifications.services

import javax.servlet.{ ServletContextEvent, ServletContextListener }

import com.liferay.portal.kernel.log.{ Log, LogFactoryUtil }

class LiferayMessageLauncher extends ServletContextListener {
  private val log: Log = LogFactoryUtil.getLog(classOf[LiferayMessageLauncher])

  override def contextInitialized(sce: ServletContextEvent): Unit = {
    NotificationScheduler.start()
    log.info("Message Notification Sender is started")
  }

  override def contextDestroyed(sce: ServletContextEvent): Unit = {
    NotificationScheduler.shutdown()
    log.info("Message Notification Sender is stopped")
  }
}
