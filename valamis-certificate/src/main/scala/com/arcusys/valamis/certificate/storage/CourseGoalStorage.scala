package com.arcusys.valamis.certificate.storage

import com.arcusys.valamis.certificate.model.goal.CourseGoal
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.model.PeriodTypes._

/**
 * Created by mminin on 04.03.15.
 */
trait CourseGoalStorage {
  def create(certificateId: Long, courseId: Long, arrangementIndex: Int, periodValue: Int, periodType: PeriodType): CourseGoal

  def delete(certificateId: Long, courseId: Long): Unit

  def modifyPeriod(certificateId: Long, courseId: Long, periodValue: Int, periodType: PeriodType): CourseGoal

  def modifyArrangementIndex(certificateId: Long, courseId: Long, arrangementIndex: Int): CourseGoal

  def get(certificateId: Long, courseId: Long): Option[CourseGoal]

  def getByCourseId(courseId: Long): Seq[CourseGoal]

  def getByCertificateId(certificateId: Long): Seq[CourseGoal]

  def getByCertificateIdCount(certificateId: Long): Int
}
