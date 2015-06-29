package com.arcusys.learn.controllers.api

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.PermissionUtil
import com.arcusys.valamis.lrs.api.valamis.VerbApi
import com.arcusys.valamis.lrs.serializer.StatementSerializer
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.models.request.{ ReportRequest, ReportActionType }
import com.liferay.portal.kernel.poller.{ PollerRequest, PollerProcessor, PollerResponse }
import com.arcusys.learn.facades.ReportFacadeContract
import com.arcusys.learn.exceptions.BadRequestException
import com.liferay.portal.kernel.json.JSONFactoryUtil
import org.json4s.{ DefaultFormats, Formats }
import PermissionUtil._

class ReportApiController(configuration: BindingModule) extends BaseApiController(configuration) with PollerProcessor {
  def this() = this(Configuration)

  val reportFacade  = inject[ReportFacadeContract]
  val lrsReader     = inject[LrsClientManager]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/report(/)") {
    implicit val formats: Formats = DefaultFormats + new StatementSerializer

    jsonAction {
      val reportRequest = ReportRequest(this)
      if (reportRequest.actionType == ReportActionType.OverallByTime) {
        lrsReader.verbApi(verbApi =>
          reportFacade.getOverallByTime(verbApi),
          reportRequest.lrsAuth)
      } else {
        lrsReader.statementApi(statementApi => reportRequest.actionType match {
          case ReportActionType.MostActiveUsers =>
            reportFacade.getMostActive(
              statementApi,
              getUserId.toInt,
              reportRequest.offset,
              reportRequest.amount)

          case ReportActionType.StudentsLatestStatements => reportFacade.getStudentsLatestStatements(
            statementApi,
            getUserId.toInt,
            reportRequest.offset,
            reportRequest.amount)

          case ReportActionType.UserLatestStatements => reportFacade.getUserLatestStatements(
            statementApi,
            getUserId.toInt,
            reportRequest.offset,
            reportRequest.amount)

          case ReportActionType.StatementVerbs => reportFacade.getStatementVerbs(statementApi)

          case ReportActionType.OverallByPeriod => reportFacade.getOverallByPeriod(
            statementApi,
            reportRequest.period,
            reportRequest.from,
            reportRequest.to)

          case ReportActionType.Leaderboard => reportFacade.getStudentsLeaderboard(
            statementApi,
            reportRequest.period,
            reportRequest.offset,
            reportRequest.amount)

          case ReportActionType.Course => reportFacade.getCourseReport(
            statementApi,
            reportRequest.isInstanceScope,
            reportRequest.courseId)

          case ReportActionType.CourseEvent => reportFacade.getCourseEvent(
            reportRequest.groupBy,
            reportRequest.groupPeriod,
            reportRequest.period,
            reportRequest.from,
            reportRequest.to)

          case ReportActionType.Participants => reportFacade.getParticipantReport(
            reportRequest.groupBy)

          case _ => throw new BadRequestException()
        }, reportRequest. lrsAuth)
      }
    }
  }

  override def receive(pollerRequest: PollerRequest, pollerResponse: PollerResponse) {

    val responseJSON = JSONFactoryUtil.createJSONObject()
    responseJSON.put("update", "0")

    pollerResponse.setParameter("content", responseJSON)

  }

  override def send(pollerRequest: PollerRequest) {}
}
