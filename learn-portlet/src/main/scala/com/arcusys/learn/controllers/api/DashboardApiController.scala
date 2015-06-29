package com.arcusys.learn.controllers.api

import com.arcusys.learn.facades.{CertificateFacadeContract, GradebookFacadeContract}
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.PermissionUtil
import com.arcusys.learn.models.request.DashboardRequest
import com.arcusys.learn.models.response.UserSummaryResponse
import com.arcusys.valamis.certificate.model.CertificateStatus
import com.arcusys.valamis.certificate.model.goal.GoalStatuses
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.arcusys.valamis.lrsEndpoint.service.LrsEndpointService
import com.arcusys.valamis.settings.service.SettingService
import com.escalatesoft.subcut.inject.BindingModule

class DashboardApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  lazy val endpointService = inject[LrsEndpointService]
  lazy val settingsManager = inject[SettingService]
  val lrsClientManager = inject[LrsClientManager]
  val certificateFacade = inject[CertificateFacadeContract]
  val gradebookFacade = inject[GradebookFacadeContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/dashboard/summary(/)") {
    jsonAction {
      val dashboardRequest = DashboardRequest(this)
      val userId = PermissionUtil.getUserId

      val certificatesReceived = certificateFacade.getStatesBy(
        userId,
        Set(CertificateStatus.Success)
      ).size

      val certificatesInProgress = certificateFacade.getStatesBy(
        userId,
        Set(CertificateStatus.InProgress)
      ).size

      val lessonsCompleted = lrsClientManager.statementApi(statementApi =>
        gradebookFacade.getCompletedPackagesCount(statementApi, userId), dashboardRequest.lrsAuth)

      val pieData = lrsClientManager.statementApi(statementApi =>
        gradebookFacade.getCompletedPackages(statementApi, userId), dashboardRequest.lrsAuth)

      val certificates = certificateFacade.getStatesBy(userId, Set(CertificateStatus.InProgress, CertificateStatus.Success))

      val goals = lrsClientManager.statementApi(statementApi =>
        for (
          certificate <- certificates;
          certificateId = certificate.id;
          goalStatus = certificateFacade.getGoalsStatuses(statementApi, certificateId, userId.toInt)
        ) yield goalStatus,
        dashboardRequest.lrsAuth
      )

      val learningGoalsAchived = goals.map(c => {
        val sp = c.packages.count(_.status == GoalStatuses.Success.toString)
        val sa = c.activities.count(_.status == GoalStatuses.Success.toString)
        val sc = c.courses.count(_.status == GoalStatuses.Success.toString)
        val ss = c.statements.count(_.status == GoalStatuses.Success.toString)
        sp + sa + sc + ss
      }).sum


      UserSummaryResponse(
        certificatesReceived = certificatesReceived,
        lessonsCompleted = lessonsCompleted,
        learningGoalsAchived = learningGoalsAchived,
        certificatesInProgress = certificatesInProgress,
        piedata = pieData
      )
    }
  }
}
