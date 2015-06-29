package com.arcusys.valamis.lesson.service

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.valamis.lesson.model.LessonType.LessonType
import com.arcusys.valamis.lesson.model.{ LessonLimit, LessonType }
import com.arcusys.valamis.lesson.scorm.storage.tracking.AttemptStorage
import com.arcusys.valamis.lesson.storage.LessonLimitStorage
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.model.StatementFilter
import com.arcusys.valamis.lrs.util.StatementApiHelpers._
import com.arcusys.valamis.lrs.util.{ TinCanVerbs, TincanHelper }
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.uri.service.URIServiceContract
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime
import com.arcusys.valamis.util.Joda._

class LessonLimitChecker(implicit val bindingModule: BindingModule) extends Injectable {

  private val lessonLimitStorage = inject[LessonLimitStorage]
  private val uriService = inject[URIServiceContract]
  private val attemptStorage = inject[AttemptStorage]
  private lazy val packageService = inject[ValamisPackageService]

  private def getLessonLimit(packageId: Long, lessonType: LessonType) = {
    lessonLimitStorage.getByID(packageId, lessonType)
  }

  /*
  Return true if checker failed
 */
  def checkScormPackage(user: LUser, packageId: Long, statementApi: StatementApi): Boolean = {
    getLessonLimit(packageId, LessonType.Scorm) match {
      case Some(limit) =>
        val attemptsCount = getScormAttemptsCount(user.getUserId.toInt, packageId)
        checkPackage(user, packageId, attemptsCount, limit, statementApi)
      case _ => true
    }
  }

  def checkTincanPackage(user: LUser, packageId: Long, statementApi: StatementApi): Boolean = {
    getLessonLimit(packageId, LessonType.Tincan) match {
      case Some(limit) =>
        val attemptsCount = getTincanAttemptsCount(user, packageId, statementApi)
        checkPackage(user, packageId, attemptsCount, limit, statementApi)
      case _ => true
    }
  }

  def checkPackage(user: LUser, packageId: Long, attemptsCount: Int, limit: LessonLimit, statementApi: StatementApi): Boolean = {

    val passingLimitCheck = if (limit.passingLimit <= 0) true
    else attemptsCount < limit.passingLimit

    val intervalCheck = if (limit.rerunIntervalType == PeriodTypes.UNLIMITED) true
    else {
      val lastTimestamps = getPackageTincanAttemptedStatements(user, packageId, statementApi).sortBy(i => i.timestamp).reverseMap(i => i.timestamp)
      if (lastTimestamps.isEmpty) true
      else {
        val lastTimestamp = lastTimestamps.head.get
        val nextAttemptDate = limit.rerunIntervalType match {
          case PeriodTypes.DAYS  => new DateTime(lastTimestamp).plusDays(limit.rerunInterval)
          case PeriodTypes.MONTH => new DateTime(lastTimestamp).plusMonths(limit.rerunInterval)
          case PeriodTypes.WEEKS => new DateTime(lastTimestamp).plusWeeks(limit.rerunInterval)
          case PeriodTypes.YEAR  => new DateTime(lastTimestamp).plusYears(limit.rerunInterval)
        }
        DateTime.now.isAfter(nextAttemptDate)
      }
    }
    passingLimitCheck && intervalCheck
  }

  //  tincan
  def getTincanAttemptsCount(user: LUser, packageId: Long, statementApi: StatementApi): Int = {
    getPackageTincanAttemptedStatements(user, packageId, statementApi).size
  }

  def isTincanPackageFinished(user: LUser, packageId: Long, statementApi: StatementApi): Boolean = {
    val activityIds = packageService.getRootActivityIds(packageId)
    val finishedStatements = activityIds.flatMap(actId => {
      val filterCompleted = StatementFilter(
        agent = Option(TincanHelper.getAgentByEmail(user.getEmailAddress)),
        activity = Option(actId),
        verb = Option(TinCanVerbs.getVerbURI(TinCanVerbs.Completed))
      )
      statementApi.getByFilter(filterCompleted)

    })
    finishedStatements.exists(s => s.result.isDefined && s.result.get.success.getOrElse(false))
  }

  private def getPackageTincanAttemptedStatements(user: LUser, packageId: Long, statementApi: StatementApi) = {
    val activityIds = packageService.getRootActivityIds(packageId)
    activityIds.flatMap(actId => {
      val filter = StatementFilter(
        agent = Option(TincanHelper.getAgentByEmail(user.getEmailAddress)),
        activity = Option(actId),
        relatedActivities = Option(false),
        verb = Option(TinCanVerbs.getVerbURI(TinCanVerbs.Attempted))
      )
      statementApi.getByFilter(filter)
    })
  }

  // scorm
  def getScormAttemptsCount(userId: Int, packageId: Long): Int =
    attemptStorage.getAllComplete(userId, packageId.toInt).size
}
