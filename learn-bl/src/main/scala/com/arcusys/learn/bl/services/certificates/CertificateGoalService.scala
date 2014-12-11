package com.arcusys.learn.bl.services.certificates

import com.arcusys.learn.bl.services.CertificateServiceContract
import com.arcusys.learn.scorm.manifest.model.PeriodType
import com.arcusys.learn.scorm.manifest.model.PeriodType.PeriodType
import com.arcusys.learn.scorm.tracking.model.certificating.models.{ CertificateActivitySettings, CertificateCourseSettings, CertificateStatementObjSettings }
import com.arcusys.learn.scorm.certificating.{ CertificateActivitySettingsRepositoryContract, CertificateCourseSettingsRepositoryContract, CertificateStatementObjSettingsRepositoryContract }
import com.escalatesoft.subcut.inject.Injectable

trait CertificateGoalService extends Injectable with CertificateServiceContract {

  private lazy val certificateCourseRepository = inject[CertificateCourseSettingsRepositoryContract]
  private lazy val certificateActivityRepository = inject[CertificateActivitySettingsRepositoryContract]
  private lazy val certificateTincanStatementRepository = inject[CertificateStatementObjSettingsRepositoryContract]

  private lazy val checker = inject[CertificateStatusCheckerContract]
  //new CertificateStatusChecker(bindingModule)

  def addCourse(certificateId: Int, courseId: Int) = {
    val coursesAmount = certificateCourseRepository.getByCertificateIdCount(certificateId)
    //I actually don't like this try/catch, but If there is no entity in BaseEntityRepository it just don't give None as Option[E]
    //but instead raises ${whatever_entity} not found exception.
    try {
      certificateCourseRepository.get("certificateId" -> certificateId, "courseId" -> courseId) //LFSCORM-1012. Curriculum admin: add course again -> exception
    } catch {
      case notFound: com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException =>
        certificateCourseRepository.create(CertificateCourseSettings(certificateId, courseId, arrangementIndex = coursesAmount + 1))
    }
  }

  def deleteCourse(certificateId: Int, courseId: Int) = {
    certificateCourseRepository.delete("certificateId" -> certificateId, "courseId" -> courseId)
  }

  def changeCourse(certificateId: Int, courseId: Int, value: Int, period: PeriodType) = {
    val c = certificateCourseRepository.get("certificateId" -> certificateId, "courseId" -> courseId)

    val pT1 = normalizePeriod(value, period)

    certificateCourseRepository.modify(c.copy(value = Some(value), periodType = Some(pT1)))
  }

  def moveCourse(certificateId: Int, courseIDs: Seq[Int]) {
    var index = 1
    courseIDs.foreach(id => {
      val c = certificateCourseRepository.get("certificateId" -> certificateId, "courseId" -> id)
      certificateCourseRepository.modify(c.copy(arrangementIndex = index))
      index = index + 1
    })
  }

  def addActivity(certificateId: Int, activityName: String, count: Int = 1) = {
    if (!certificateActivityRepository.getByCertificateId(certificateId).exists(_.activityName == activityName))
      certificateActivityRepository.create(CertificateActivitySettings(certificateId, activityName, count, None, PeriodType.UNLIMITED))
  }

  def getActivities(certificateId: Int): Seq[CertificateActivitySettings] =
    certificateActivityRepository.getByCertificateId(certificateId)
  def getActivitiesCount(certificateId: Int) =
    certificateActivityRepository.getByCertificateIdCount(certificateId)

  def deleteActivity(certificateId: Int, activityName: String) = {
    certificateActivityRepository.delete("certificateId" -> certificateId, "activityName" -> activityName)
  }

  def changeActivity(certificateId: Int, activityName: String, count: Int, value: Int, period: PeriodType) = {
    val c = certificateActivityRepository.get("certificateId" -> certificateId, "activityName" -> activityName)

    val pT1 = normalizePeriod(value, period)

    certificateActivityRepository.modify(c.copy(value = Some(value), periodType = pT1, count = count))
  }

  def getStatements(certificateId: Int): List[CertificateStatementObjSettings] =
    certificateTincanStatementRepository.getByCertificateId(certificateId).toList
  def getStatementsCount(certificateId: Int): Int =
    certificateTincanStatementRepository.getByCertificateIdCount(certificateId)

  def addStatementObj(certificateId: Int, verb: String, obj: String): Unit = {
    try {
      certificateTincanStatementRepository.get("certificateId" -> certificateId, "verb" -> verb, "obj" -> obj)
    } catch {
      case notFound: com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException =>
        certificateTincanStatementRepository.create(CertificateStatementObjSettings(certificateId, verb, obj))
    }
  }

  def deleteStatementObj(certificateId: Int, verb: String, obj: String): Unit = {
    certificateTincanStatementRepository.delete("certificateId" -> certificateId, "verb" -> verb, "obj" -> obj)
  }

  def changeStatementObjPeriod(certificateId: Int, verb: String, obj: String, value: Int, period: PeriodType) = {
    val settings = certificateTincanStatementRepository.get("certificateId" -> certificateId, "verb" -> verb, "obj" -> obj)

    val pT1 = normalizePeriod(value, period)

    certificateTincanStatementRepository.modify(settings.copy(value = Some(value), period = Some(pT1)))
  }

  def getCoursesStatuses(certificateId: Int, userId: Int) =
    checker.getCoursesStatuses(certificateId, userId)
  def getActivitiesStatuses(certificateId: Int, userId: Int) =
    checker.getActivitiesStatuses(certificateId, userId)
  def getStatementsStatuses(certificateId: Int, userId: Int) =
    checker.getStatementsStatuses(certificateId, userId)

  def getActivitiesDeadlines(certificateId: Int, userId: Int) =
    checker.getActivitiesDeadlines(certificateId, userId)
  def getCoursesDeadlines(certificateId: Int, userId: Int) =
    checker.getCoursesDeadlines(certificateId, userId)
  def getStatementsDeadlines(certificateId: Int, userId: Int) =
    checker.getStatementsDeadlines(certificateId, userId)

  def getCourses(certificateId: Int) =
    certificateCourseRepository.getByCertificateId(certificateId)
  def getCoursesCount(certificateId: Int) =
    certificateCourseRepository.getByCertificateIdCount(certificateId)

  def normalizePeriod(value: Int, period: PeriodType): PeriodType = {
    if (value < 1)
      PeriodType.UNLIMITED
    else
      period
  }
}
