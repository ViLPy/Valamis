package com.arcusys.learn.notifications.services

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.notifications.CourseMessageService
import com.arcusys.valamis.lrs.service.{IncorrectLrsSettingsException, LrsClientManager}
import com.arcusys.valamis.lrs.tincan.AuthorizationScope
import com.escalatesoft.subcut.inject.BindingModule
import org.quartz.{ Job, JobExecutionContext }

class CourseNotificationSender extends Job with CourseMessageService {
  override implicit def bindingModule: BindingModule = Configuration
  private val lrsReader = inject[LrsClientManager]

  override def execute(ctx: JobExecutionContext) {
    try{
      val lrsAuth = lrsReader.getLrsEndpointInfo(AuthorizationScope.All).auth
      lrsReader.statementApi(sendCourseMessages, lrsAuth)
      sendCertificateMessages()
    }
    catch {
      case e: IncorrectLrsSettingsException =>
    }
  }
}
