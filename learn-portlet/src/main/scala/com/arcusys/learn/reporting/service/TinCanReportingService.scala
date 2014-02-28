package com.arcusys.learn.reporting.service

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.lrs.statement.{StatementFilter, StatementLRS}
import java.util.{Calendar, Date}
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer

class TinCanReportingService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  object ReportingPeriods extends Enumeration {
    type ReportingPeriods = Value
    val Hour, Day, Week, Month = Value
  }

  val statementLRS = new StatementLRS() {
    val statementStorage = storageFactory.tincanLrsStatementStorage
  }

  get("/tincan/statementVerbs") {
    val statements = statementLRS.getStatements().statements
    val statementVerbs = statements
      .map(_.verb.id.split("/").last) // http://adlnet.gov/expapi/verbs/answered -> answered
      .groupBy(verb => verb)
      .mapValues(_.size)

    json(Map("data" -> statementVerbs))
  }

  get("/tincan/mostActiveUsers") {
    halt(501)
    /*val statements = statementLRS.getStatements().statements
    val resultedData = statements
      .filter(s => s.actor.isInstanceOf[Agent] || s.actor.isInstanceOf[Group])
      .map(s => {
      val email = s.actor match {
        case a: Agent => a.mbox
        case g: Group => g.mbox
        case _ => None
      }
      val companies = CompanyLocalServiceUtil.getCompanies(-1, -1)
      val hasUserWithEmail = email.isDefined && companies.asScala.exists(company => {
        try {
          UserLocalServiceUtil.getUserByEmailAddress(company.getCompanyId, email.get.replace("mailto:", "")) != null
        } catch {
          case _ => false
        }
      })
    })
      .groupBy(_.actor match {
      case a: Agent => a.mbox
      case g: Group => g.mbox
      case _ => None
    })
      .mapValues(_.size)
      .toSeq
      .filter(s => {
      val companies = CompanyLocalServiceUtil.getCompanies(-1, -1)
      val hasUserWithEmail = companies.asScala.fin
      true
    })
      .sortWith(_._2 < _._2) //sort by amount of statements, desc
      .take(5)

    json(Map("data" -> resultedData))*/
  }

  get("/tincan/getUserLatestStatements") {
    val email = try {
      UserLocalServiceHelper.getUser(getSessionUserID).getEmailAddress
    } catch {
      case _ => halt(500, "Cannot find user for current session")
    }

    val offset = try {
      parameter("offset").withDefault("0").toInt
    } catch {
      case n: NumberFormatException => halt(400, "Invalid number format for amount")
    }

    val amount = try {
      parameter("amount").withDefault("5").toInt
    } catch {
      case n: NumberFormatException => halt(400, "Invalid number format for amount")
    }

    if (amount <= 0) halt(400, "Amount should be greater than zero")
    if (offset < 0) halt(400, "Offset cannot be less than zero")

    val statements = statementLRS.getStatements().statements.filter(_.actor match {
      case a: Agent => a.mbox == Some("mailto:" + email)
      case _ => false
    }).reverse

    JsonDeserializer.serializeListAsObject(
      Map("statementData" -> statements.slice(offset, offset + amount),
        "totalStatements" -> statements.length,
        "currentPage" -> math.ceil((offset + 0.1) / amount.toFloat).toInt))
  }

  get("/tincan/completionInformation/overallByTime") {
    val startedData = statementLRS.getStatements(StatementFilter(verb = Some("http://adlnet.gov/expapi/verbs/attempted")))
      .statements.map(s => getStartOf(s.timestamp.getOrElse(new Date(0)), ReportingPeriods.Day))
      .groupBy(date => date)
      .map(k => Map("date" -> k._1.getTime, "amount" -> k._2.size))

    val completedData = statementLRS.getStatements(StatementFilter(verb = Some("http://adlnet.gov/expapi/verbs/completed")))
      .statements.map(s => getStartOf(s.timestamp.getOrElse(new Date(0)), ReportingPeriods.Day))
      .groupBy(date => date)
      .map(k => Map("date" -> k._1.getTime, "amount" -> k._2.size))

    val passed = statementLRS.getStatements(StatementFilter(verb = Some("http://adlnet.gov/expapi/verbs/completed")))

    val passedScores = passed.statements
      .filter(s => s.result.isDefined && s.result.get.success.getOrElse(false) && s.result.get.score.isDefined)
      .map(_.result.get.score.get.scaled)

    val average = if (passedScores.nonEmpty) (passedScores.sum / passedScores.size).toDouble else 0

    val passedData =
      passed.statements.filter(s => s.result.isDefined && s.result.get.success.isDefined)
        .map(s => getStartOf(s.timestamp.getOrElse(new Date(0)), ReportingPeriods.Day))
        .groupBy(date => date)
        .map(k => Map("date" -> k._1.getTime, "amount" -> k._2.size))

    json(Map("averageScore" -> average,
      "startedData" -> startedData,
      "completedData" -> completedData,
      "passedData" -> passedData))
  }

  get("/tincan/statementInformation/overallBy/:period/from/:from/to/:to") {
    try {
      val period = ReportingPeriods.withName(parameter("period").required)
      val from = getStartOf(new Date(parameter("from").longRequired), period)
      val to = getEndOf(new Date(parameter("to").longRequired), period)
      val data = statementLRS.getStatements().statements
        .filter(d => d.timestamp.isDefined && d.timestamp.get.compareTo(from) >= 0 && d.timestamp.get.compareTo(to) <= 0)
        .map(s => getStartOf(s.timestamp.get, period))
        .sortBy(d => d.getTime)
        .groupBy(date => date)
        .map(k => Map("date" -> k._1.getTime, "amount" -> k._2.size))
      json(Map("statements" -> data, "period" -> period.toString))
    } catch {
      case _ => halt(400)
    }
  }

  private def getStartOf(date: Date, period: ReportingPeriods.Value) = {
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    if (period == ReportingPeriods.Day) {
      calendar.set(Calendar.HOUR_OF_DAY, 0)
    }
    if (period == ReportingPeriods.Week) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
      calendar.set(Calendar.HOUR_OF_DAY, 0)
    }
    if (period == ReportingPeriods.Month) {
      calendar.set(Calendar.DAY_OF_MONTH, 1)
      calendar.set(Calendar.HOUR_OF_DAY, 0)
    }
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    calendar.getTime
  }

  private def getEndOf(date: Date, period: ReportingPeriods.Value) = {
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    if (period == ReportingPeriods.Day) {
      calendar.set(Calendar.HOUR_OF_DAY, 23)
    }
    if (period == ReportingPeriods.Week) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
      calendar.add(Calendar.DATE, 7)
      calendar.set(Calendar.HOUR_OF_DAY, 23)
    }
    if (period == ReportingPeriods.Month) {
      calendar.add(Calendar.MONTH, 1)
      calendar.set(Calendar.DAY_OF_MONTH, 1)
      calendar.add(Calendar.DATE, -1)
      calendar.set(Calendar.HOUR_OF_DAY, 23)
    }
    calendar.set(Calendar.MINUTE, 59)
    calendar.set(Calendar.SECOND, 59)
    calendar.set(Calendar.MILLISECOND, 999)
    calendar.getTime
  }
}
