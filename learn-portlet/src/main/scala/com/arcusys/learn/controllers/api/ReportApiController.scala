package com.arcusys.learn.controllers.api

import com.arcusys.learn.ioc.Configuration
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.models.request.{ ReportRequest, ReportActionType }
import com.liferay.portal.kernel.poller.{ PollerRequest, PollerProcessor, PollerResponse }
import com.arcusys.learn.facades.ReportFacadeContract
import com.arcusys.learn.exceptions.BadRequestException
import com.liferay.portal.kernel.json.JSONFactoryUtil
import org.json4s.{ DefaultFormats, Formats }
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer.StatementSerializer

class ReportApiController(configuration: BindingModule) extends BaseApiController(configuration) with PollerProcessor {
  def this() = this(Configuration)

  val reportFacade = inject[ReportFacadeContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/report(/)") {
    implicit val formats: Formats = DefaultFormats + new StatementSerializer

    jsonAction {
      val reportRequest = ReportRequest(this)
      reportRequest.actionType match {
        case ReportActionType.MOST_ACTIVE_USERS => {
          reportFacade.getMostActive(
            getUserId.toInt,
            reportRequest.offset,
            reportRequest.amount)
        }

        case ReportActionType.STUDENTS_LATEST_STATEMENTS => reportFacade.getStudentsLatestStatements(
          getUserId.toInt,
          reportRequest.offset,
          reportRequest.amount)

        case ReportActionType.USER_LATEST_STATEMENTS => reportFacade.getUserLatestStatements(
          getUserId.toInt,
          reportRequest.offset,
          reportRequest.amount)

        case ReportActionType.STATEMENT_VERBS => reportFacade.getStatementVerbs()

        case ReportActionType.OVERALL_BY_TIME => reportFacade.getOverallByTime()

        case ReportActionType.OVERALL_BY_PERIOD => reportFacade.getOverallByPeriod(
          reportRequest.period,
          reportRequest.from,
          reportRequest.to)

        case ReportActionType.LEADERBOARD => reportFacade.getStudentsLeaderboard(
          reportRequest.period,
          reportRequest.offset,
          reportRequest.amount)

        case ReportActionType.COURSE => reportFacade.getCourseReport(
          reportRequest.isInstanceScope,
          reportRequest.courseID)

        case ReportActionType.COURSE_EVENT => reportFacade.getCourseEvent(
          reportRequest.groupBy,
          reportRequest.groupPeriod,
          reportRequest.period,
          reportRequest.from,
          reportRequest.to)

        case ReportActionType.PARTICIPANTS => reportFacade.getParticipantReport(
          reportRequest.groupBy)

        case _ => throw new BadRequestException()
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
