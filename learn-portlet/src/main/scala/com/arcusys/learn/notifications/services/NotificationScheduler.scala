package com.arcusys.learn.notifications.services

import org.quartz.impl.StdSchedulerFactory
import org.quartz.{ Trigger, JobDetail }
import org.quartz.CronScheduleBuilder.cronSchedule
import org.quartz.JobBuilder.newJob
import org.quartz.TriggerKey._
import org.quartz.TriggerBuilder.newTrigger

object NotificationScheduler {
  private val sf = new StdSchedulerFactory()
  private val scheduler = sf.getScheduler
  private val courseTriggerIdentity = triggerKey("trigger1", "valamisMailerGroup")

  private val courseNotificationJob = newJob(classOf[CourseNotificationSender])
    .withIdentity("job1", "valamisCourseMailerGroup")
    .build()

  def scheduleJob(job: JobDetail, trigger: Trigger) {
    scheduler.scheduleJob(job, trigger)
  }

  def start() {
    scheduler.start()
  }

  def shutdown() {
    scheduler.shutdown(true)
  }

  def scheduleMailer(hour: Int) {
    assert(hour >= -1 && hour <= 23)

    scheduler.unscheduleJob(courseTriggerIdentity)
    if (hour > -1) {
      this.scheduleJob(courseNotificationJob, newTrigger()
        .withIdentity(courseTriggerIdentity)
        .withSchedule(cronSchedule("0 0 " + hour + " * * ?"))
        .build())
      this.start()
    }
  }
}
