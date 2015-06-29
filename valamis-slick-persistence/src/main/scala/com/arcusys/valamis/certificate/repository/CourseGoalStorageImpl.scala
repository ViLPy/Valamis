package com.arcusys.valamis.certificate.repository

import com.arcusys.valamis.certificate.model.goal.CourseGoal
import com.arcusys.valamis.certificate.schema.CourseGoalTableComponent
import com.arcusys.valamis.certificate.storage.CourseGoalStorage
import com.arcusys.valamis.core.{SlickProfile, SlickDBInfo}
import com.arcusys.valamis.model.PeriodTypes._
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}

import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class CourseGoalStorageImpl (val db: JdbcBackend#DatabaseDef,
                             val driver: JdbcProfile)
  extends CourseGoalStorage
  with CourseGoalTableComponent
  with SlickProfile {

  import driver.simple._

  override def get(certificateId: Long, courseId: Long) = db.withSession { implicit session =>
    courseGoals.filter(ag => ag.certificateId === certificateId && ag.courseId === courseId).firstOption
  }

  override def delete(certificateId: Long, courseId: Long) = db.withSession { implicit session =>
    courseGoals.filter(ag => ag.certificateId === certificateId && ag.courseId === courseId).delete
  }

  override def create(certificateId: Long,
                      courseId: Long,
                      arrangementIndex: Int,
                      periodValue: Int,
                      periodType: PeriodType): CourseGoal =
    create(CourseGoal(certificateId, courseId, periodValue, periodType, arrangementIndex))

  def create(courseGoal: CourseGoal) = db.withSession { implicit session =>
    courseGoals.insert(courseGoal)
    get(courseGoal.certificateId, courseGoal.courseId).get
  }

  def update(courseGoal: CourseGoal) = db.withSession{ implicit session =>
    courseGoals.filter(ag => ag.certificateId === courseGoal.certificateId && ag.courseId === courseGoal.courseId).update(courseGoal)
    get(courseGoal.certificateId, courseGoal.courseId).get
  }


  override def modifyPeriod(certificateId: Long,
                            courseId: Long,
                            periodValue: Int,
                            periodType: PeriodType): CourseGoal =
    db.withSession { implicit session =>
      courseGoals
        .filter(goal => goal.certificateId === certificateId && goal.courseId === courseId)
        .map(goal => (goal.periodValue, goal.periodType))
        .update((periodValue, periodType))

      courseGoals.filter(goal => goal.certificateId === certificateId && goal.courseId === courseId).first
    }

  override def modifyArrangementIndex(
                                       certificateId: Long,
                                       courseId: Long,
                                       arrangementIndex: Int): CourseGoal =
    db.withSession { implicit session =>
      courseGoals
        .filter(goal => goal.certificateId === certificateId && goal.courseId === courseId)
        .map(_.arrangementIndex)
        .update(arrangementIndex)

      courseGoals.filter(goal => goal.certificateId === certificateId && goal.courseId === courseId).first
    }


  override def getByCourseId(courseId: Long): Seq[CourseGoal] =
    getBy(courseId = Some(courseId))

  override def getByCertificateId(certificateId: Long): Seq[CourseGoal] =
    getBy(certificateId = Some(certificateId))

  override def getByCertificateIdCount(certificateId: Long): Int =
    getCountBy(certificateId = Some(certificateId))

  private def getBy(courseId: Option[Long] = None, certificateId: Option[Long] = None) = db.withSession(implicit session =>
    composeQuery(courseId, certificateId).run
  )

  private def getCountBy(courseId: Option[Long] = None, certificateId: Option[Long] = None) = db.withSession(implicit session =>
    composeQuery(courseId, certificateId).length.run
  )

  private def composeQuery(courseId: Option[Long] = None, certificateId: Option[Long] = None)
                          (implicit session: JdbcBackend#Session) = {
    val courseIdFiltered = if (courseId.isDefined) courseGoals.filter(_.courseId === courseId.get) else courseGoals
    val certificateIdFiltered = if (certificateId.isDefined) courseIdFiltered.filter(_.certificateId === certificateId.get) else courseIdFiltered
    certificateIdFiltered
  }
}
