package com.arcusys.learn.bl.services

import com.arcusys.learn.scorm.manifest.model.LessonType.LessonType
import com.arcusys.learn.scorm.manifest.model.{ PeriodType, LessonLimit, LessonType }
import com.arcusys.learn.scorm.manifest.storage.LessonLimitStorage
import com.arcusys.learn.scorm.tracking.storage.AttemptStorage
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.tincan.lrs.statement.{ StatementFilter, StatementLRS }
import com.arcusys.learn.tincan.model.{ Agent, TincanURIType }
import com.arcusys.learn.tincan.storage.StatementStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.model.User
import org.joda.time.DateTime

/**
 * Created by iliyatryapitsin on 01/10/14.
 */
class LessonLimitChecker(configuration: BindingModule) extends Injectable {

  implicit val bindingModule = configuration

  val lessonLimitStorage = inject[LessonLimitStorage]
  val uriService = inject[URIServiceContract]
  val attemptStorage = inject[AttemptStorage]

  val statementLRS = new StatementLRS() {
    val statementStorage = inject[StatementStorage]
  }

  /*
  Return true if checker failed
 */
  def checkScormPackage(user: User, packageId: Int): Boolean = {
    val attemptsCount = getScormAttemptsCount(user.getUserId.toInt, packageId)
    val limit = getLessonLimit(packageId, LessonType.scormPackage)

    checkPackage(user, packageId, attemptsCount, limit)
  }

  def checkTincanPackage(user: User, packageId: Int): Boolean = {
    val attemptsCount = getTincanAttemptsCount(user, packageId)
    val limit = getLessonLimit(packageId, LessonType.tincanPackage)

    checkPackage(user, packageId, attemptsCount, limit)
  }

  def checkPackage(user: User, packageId: Int, attemptsCount: Int, limit: Option[LessonLimit]): Boolean = {
    if (!limit.isDefined) return true;

    val passingLimitCheck = if (limit.get.passingLimit <= 0) true
    else attemptsCount < limit.get.passingLimit

    val intervalCheck = if (limit.get.rerunIntervalType == PeriodType.UNLIMITED) true
    else {
      val lastTimestamps = getPackageTincanStatements(user, packageId).sortBy(i => i.timestamp).reverse.map(i => i.timestamp)
      if (lastTimestamps.isEmpty) true
      else {
        val lastTimestamp = lastTimestamps.head.get
        val nextAttemptDate = limit.get.rerunIntervalType match {
          case PeriodType.DAYS  => new DateTime(lastTimestamp).plusDays(limit.get.rerunInterval)
          case PeriodType.MONTH => new DateTime(lastTimestamp).plusMonths(limit.get.rerunInterval)
          case PeriodType.WEEKS => new DateTime(lastTimestamp).plusWeeks(limit.get.rerunInterval)
          case PeriodType.YEAR  => new DateTime(lastTimestamp).plusYears(limit.get.rerunInterval)
        }
        DateTime.now.isAfter(nextAttemptDate)
      }
    }
    passingLimitCheck && intervalCheck
  }

  def getLessonLimit(packageId: Int, lessonType: LessonType) = {
    lessonLimitStorage.getByID(packageId, lessonType)
  }

  //  tincan
  def getTincanAttemptsCount(user: User, packageId: Int): Int = {
    getPackageTincanStatements(user, packageId).size
  }

  private def getPackageTincanStatements(user: User, packageId: Int) = {
    val packageUri = uriService.getURI(packageId.toString, TincanURIType.Package)
    val filter = StatementFilter(
      agent = Option(Agent(objectType = "Agent", name = None, mbox = Option(user.getEmailAddress), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
      activity = if (packageUri.isDefined) Option(packageUri.get.uri) else Option(packageId.toString),
      relatedActivities = Option(false),
      verb = Option("http://adlnet.gov/expapi/verbs/attempted")
    )
    statementLRS
      .getStatements(filter)
      .statements
  }

  // scorm
  def getScormAttemptsCount(userId: Int, packageId: Int): Int =
    attemptStorage.getAllComplete(userId, packageId).size
}
