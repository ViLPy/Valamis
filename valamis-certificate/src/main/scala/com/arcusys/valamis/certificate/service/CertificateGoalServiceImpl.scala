package com.arcusys.valamis.certificate.service

import com.arcusys.valamis.certificate.model.goal.{ActivityGoal, StatementGoal}
import com.arcusys.valamis.certificate.storage.{PackageGoalStorage, StatementGoalStorage, ActivityGoalStorage, CourseGoalStorage}
import com.arcusys.valamis.exception.EntityDuplicateException
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.model.PeriodTypes.PeriodType
import com.escalatesoft.subcut.inject.Injectable

trait CertificateGoalServiceImpl extends Injectable with CertificateService {

  private lazy val courseGoalStorage = inject[CourseGoalStorage]
  private lazy val activityGoalStorage = inject[ActivityGoalStorage]
  private lazy val statementGoalStorage = inject[StatementGoalStorage]
  private lazy val packageGoalStorage = inject[PackageGoalStorage]
  private lazy val lrsReader = inject[LrsClientManager]
  private lazy val checker = inject[CertificateStatusChecker]

  def defaultPeriodValue = 0
  def defaultPeriodType = PeriodTypes.UNLIMITED

  def addCourseGoal(certificateId: Int, courseId: Int) = {
    val coursesAmount = courseGoalStorage.getByCertificateIdCount(certificateId)

    if (courseGoalStorage.get(certificateId, courseId).isEmpty)
      courseGoalStorage.create(
        certificateId,
        courseId,
        coursesAmount + 1,
        defaultPeriodValue,
        defaultPeriodType)
  }

  def deleteCourseGoal(certificateId: Int, courseId: Int) = {
    courseGoalStorage.delete(certificateId, courseId)
  }

  def changeCourseGoalPeriod(certificateId: Int, courseId: Int, value: Int, period: PeriodType) = {
    courseGoalStorage.modifyPeriod(certificateId, courseId, value, normalizePeriod(value, period))
  }

  def moveCourseGoals(certificateId: Int, courseIds: Seq[Int]) {
    var index = 1
    courseIds.foreach(id => {
      courseGoalStorage.modifyArrangementIndex(certificateId, id, index)
      index = index + 1
    })
  }

  def addActivityGoal(certificateId: Int, activityName: String, count: Int = 1) = {
    if (!activityGoalStorage.getByCertificateId(certificateId).exists(_.activityName == activityName))
      activityGoalStorage.create(certificateId, activityName, count, defaultPeriodValue, defaultPeriodType)
  }

  def getActivityGoals(certificateId: Int): Seq[ActivityGoal] =
    activityGoalStorage.getByCertificateId(certificateId)

  def getActivityGoalsCount(certificateId: Int) =
    activityGoalStorage.getByCertificateIdCount(certificateId)

  def deleteActivityGoal(certificateId: Int, activityName: String) = {
    activityGoalStorage.delete(certificateId, activityName)
  }

  def changeActivityGoalPeriod(certificateId: Int, activityName: String, count: Int, value: Int, period: PeriodType) = {
    val pT1 = normalizePeriod(value, period)

    activityGoalStorage.modify(certificateId, activityName, count, value, pT1)
  }

  def getPackageGoals(certificateId: Int) =
    packageGoalStorage.getByCertificateId(certificateId)

  def getPackageGoalsCount(certificateId: Int) =
    packageGoalStorage.getByCertificateIdCount(certificateId)

  def addPackageGoal(certificateId: Long, packageId: Long) = {
    try {
      Some(packageGoalStorage.create(certificateId, packageId, defaultPeriodValue, defaultPeriodType))
    } catch {
      case _: EntityDuplicateException => None
    }
  }

  def deletePackageGoal(certificateId: Long, packageId: Long) =
    packageGoalStorage.delete(certificateId, packageId)

  def changePackageGoal(certificateId: Long, packageId: Long, periodValue: Int, periodType: PeriodType) =
    packageGoalStorage.modify(certificateId, packageId, periodValue, periodType)

  def getStatementGoals(certificateId: Int): List[StatementGoal] =
    statementGoalStorage.getByCertificateId(certificateId).toList

  def getStatementGoalsCount(certificateId: Int): Int =
    statementGoalStorage.getByCertificateIdCount(certificateId)

  def addStatementGoal(certificateId: Int, verb: String, obj: String): Unit = {
    val exists = statementGoalStorage.get(certificateId, verb, obj)
    if (exists.isEmpty) {
      statementGoalStorage.create(certificateId, verb, obj, defaultPeriodValue, defaultPeriodType)
    }
  }

  def deleteStatementGoal(certificateId: Int, verb: String, obj: String): Unit = {
    statementGoalStorage.delete(certificateId, verb, obj)
  }

  def changeStatementGoalPeriod(certificateId: Int, verb: String, obj: String, value: Int, period: PeriodType) = {
    statementGoalStorage.modify(certificateId, verb, obj, value, normalizePeriod(value, period))
  }

  def getCourseGoalsStatus(certificateId: Int, userId: Int) =
    checker.getCourseGoalsStatus(certificateId, userId)

  def getActivityGoalsStatus(certificateId: Int, userId: Int) =
    checker.getActivityGoalsStatus(certificateId, userId)

  def getStatementGoalsStatus(statementApi: StatementApi, certificateId: Int, userId: Int) =
    checker.getStatementGoalsStatus(statementApi, certificateId, userId)

  def getPackageGoalsStatus(statementApi: StatementApi, certificateId: Int, userId: Int) =
    checker.getPackageGoalsStatus(statementApi, certificateId, userId)

  def getActivityGoalsDeadline(certificateId: Int, userId: Int) =
    checker.getActivityGoalsDeadline(certificateId, userId)

  def getCourseGoalsDeadline(certificateId: Int, userId: Int) =
    checker.getCourseGoalsDeadline(certificateId, userId)

  def getStatementGoalsDeadline(certificateId: Int, userId: Int) =
    checker.getStatementGoalsDeadline(certificateId, userId)

  def getPackageGoalsDeadline(certificateId: Int, userId: Int) =
    checker.getPackageGoalsDeadline(certificateId, userId)

  def getCourseGoals(certificateId: Int) =
    courseGoalStorage.getByCertificateId(certificateId).sortBy(_.arrangementIndex)

  def getCourseGoalsCount(certificateId: Int) =
    courseGoalStorage.getByCertificateIdCount(certificateId)

  def normalizePeriod(value: Int, period: PeriodType): PeriodType = {
    if (value < 1)
      PeriodTypes.UNLIMITED
    else
      period
  }
}
