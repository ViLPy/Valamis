package com.arcusys.valamis.certificate.service

import com.arcusys.learn.liferay.services.{PermissionHelper, SocialActivityLocalServiceHelper}
import com.arcusys.valamis.certificate.model.{Certificate, CertificateStatus}
import com.arcusys.valamis.certificate.model.CertificateStatus._
import com.arcusys.valamis.certificate.model.goal._
import com.arcusys.valamis.certificate.storage._
import com.arcusys.valamis.gradebook.storage.CourseGradeStorage
import com.arcusys.valamis.lesson.tincan.storage.TincanManifestActivityStorage
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.model.PeriodTypes
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import org.joda.time.DateTime

class CertificateStatusCheckerImpl(
    implicit val bindingModule: BindingModule)
  extends CertificateStatusChecker
  with CourseGoalStatusCheckerComponent
  with StatementGoalStatusCheckerComponent
  with PackageGoalStatusCheckerComponent
  with ActivityGoalStatusCheckerComponent
  with Injectable {

  protected lazy val certificateStorage = inject[CertificateRepository]
  protected lazy val courseGoalStorage = inject[CourseGoalStorage]
  protected lazy val activityGoalStorage = inject[ActivityGoalStorage]
  protected lazy val statementGoalStorage = inject[StatementGoalStorage]
  protected lazy val packageGoalStorage = inject[PackageGoalStorage]
  protected lazy val courseGradeStorage = inject[CourseGradeStorage]
  protected lazy val tincanManifestStorage = inject[TincanManifestActivityStorage]
  protected lazy val certificateStateService = inject[CertificateStateService]

  override def getStatus(statementApi: StatementApi, certificateId: Int, userId: Int): CertificateStatus.Value = {
    PermissionHelper.preparePermissionChecker(userId)

    val certificate = certificateStorage.getById(certificateId)

    val certificateState = certificateStateService.getBy(userId, certificateId).get

    val courseGoals = courseGoalStorage.getByCertificateId(certificateId)
    val activityGoals = activityGoalStorage.getByCertificateId(certificateId)
    val statementGoals = statementGoalStorage.getByCertificateId(certificateId)
    val packageGoals = packageGoalStorage.getByCertificateId(certificateId)

    if(!certificate.isPublished) CertificateStatus.InProgress
    else
      certificateState.status match {
        case CertificateStatus.InProgress =>
          val socialActivities = SocialActivityLocalServiceHelper.getActivities(userId, certificateState.userJoinedDate)

          val goalsStatus =
            statementGoals.map(checkStatementGoal(userId, statementApi, certificateState.userJoinedDate)) ++
              activityGoals.map(checkActivityGoal(userId, socialActivities, certificateState.userJoinedDate)) ++
              packageGoals.map(checkPackageGoal(userId, certificateState.userJoinedDate, statementApi)) ++
              courseGoals.map(checkCourseGoal(userId, certificateState.userJoinedDate))

          if (goalsStatus.contains(GoalStatuses.Failed)) {
            certificateStateService.update(certificateState.copy(status = Failed, statusAcquiredDate = DateTime.now))
            SocialActivityLocalServiceHelper.addWithSet(
              certificate.companyId,
              certificateState.userId,
              classOf[Certificate].getName,
              classPK = Some(certificateState.certificateId),
              `type` = Some(Failed.id))
            CertificateStatus.Failed
          }
          else if (goalsStatus.contains(GoalStatuses.InProgress)) CertificateStatus.InProgress
          else {
            certificateStateService.update(certificateState.copy(status = Success, statusAcquiredDate = DateTime.now))
            SocialActivityLocalServiceHelper.addWithSet(
              certificate.companyId,
              certificateState.userId,
              classOf[Certificate].getName,
              classPK = Some(certificateState.certificateId),
              `type` = Some(Success.id))
            CertificateStatus.Success
          }
        case CertificateStatus.Failed => CertificateStatus.Failed
        case CertificateStatus.Success =>
          val certificateExpirationDate =
            PeriodTypes.getEndDate(
              certificate.validPeriodType,
              certificate.validPeriod,
              certificateState.statusAcquiredDate)

          if (certificateExpirationDate.isAfterNow) CertificateStatus.Success
          else {
            certificateStateService.update(certificateState.copy(status = Overdue, statusAcquiredDate = DateTime.now))
            SocialActivityLocalServiceHelper.addWithSet(
              certificate.companyId,
              certificateState.userId,
              classOf[Certificate].getName,
              classPK = Some(certificateState.certificateId),
              `type` = Some(Overdue.id))

            CertificateStatus.Overdue
          }
        case CertificateStatus.Overdue => CertificateStatus.Overdue
      }
  }
}
