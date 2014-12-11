package com.arcusys.learn.notifications.services

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.notifications.CourseMessageService
import com.escalatesoft.subcut.inject.BindingModule
import org.quartz.{ Job, JobExecutionContext }

class CourseNotificationSender extends Job with CourseMessageService {
  override implicit def bindingModule: BindingModule = Configuration

  override def execute(ctx: JobExecutionContext) {
    sendCourseMessages()
    sendCertificateMessages()
  }
}
