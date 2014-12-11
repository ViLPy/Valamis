package com.arcusys.learn.bl.services.tincan

import java.util.{ Date, UUID }

import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.setting.storage.LRSToActivitySettingStorage
import com.arcusys.learn.tincan.lrs.statement._
import com.arcusys.learn.tincan.model.{ Activity, Actor, Statement, StatementResult }
import com.arcusys.learn.tincan.storage.StatementStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.microblogs.service.MicroblogsEntryLocalServiceUtil
import com.liferay.portal.service.{ ServiceContext, UserLocalServiceUtil }

import scala.util.Try

/*
 * TinCan statements facade
 */
class StatementService(configuration: BindingModule) extends StatementServiceContract with Injectable {
  def this() = this(DomainConfiguration)
  implicit val bindingModule = configuration

  private lazy val statementLRS = new StatementLRS() {
    val statementStorage = inject[StatementStorage]
  }
  private lazy val fileStorage = inject[FileStorage]
  private lazy val lrsToActivitySettingStorage = inject[LRSToActivitySettingStorage]

  // gets statement object from body in JSON and adds it in storage with id
  def saveStatement(statement: Statement, id: Option[UUID], companyID: Long): UUID = {
    val statementCopy = if (id.isDefined)
      statement.copy(id = id.get)
    else
      statement
    val uuid = statementLRS.addStatement(statementCopy)

    // <Integration with Activities portlet
    val hasFilter = lrsToActivitySettingStorage.getAll.exists(setting => {
      val hasVerbFilter = setting.mappedVerb.exists(_ == statementCopy.verb.id) || !setting.mappedVerb.isDefined
      val hasActivityFilter = if (setting.mappedActivity.isDefined && statementCopy.obj.isInstanceOf[Activity]) {
        val activity = statementCopy.obj.asInstanceOf[Activity]
        setting.mappedActivity.exists(_ == activity.id)
      } else !setting.mappedActivity.isDefined

      hasVerbFilter && hasActivityFilter && (setting.mappedActivity.isDefined || setting.mappedVerb.isDefined)
    })
    val userEmail = statementCopy.actor.getMbox
    if (userEmail.isDefined && hasFilter) {
      val user = Try(UserLocalServiceUtil.getUserByEmailAddress(companyID, userEmail.get.replaceFirst("mailto:", ""))).toOption
      if (user.isDefined) {
        try {
          val activityName = statementCopy.obj match {
            case activity: Activity =>
              // receive activity name from lang map for user locale, or get first
              activity.name.map(name => name.get(user.get.getLanguageId).getOrElse(name.head._2)).getOrElse("some activity")
            case _ => ""
          }
          val verbName = statementCopy.verb.display.get(user.get.getLanguageId).getOrElse(statementCopy.verb.display.head._2)

          val serviceContext = new ServiceContext()
          MicroblogsEntryLocalServiceUtil.addMicroblogsEntry(user.get.getPrimaryKey, verbName + " " + activityName, 0, user.get.getPrimaryKey, 0, 0, serviceContext)
        } catch {
          case _: Throwable => /* Microblogs not installed, skipping */
        }
      }
    }
    // Integration with Activities portlet>

    uuid
  }

  def getStatements(statementId: Option[String],
    voidedStatementId: Option[String],
    agent: Option[Actor],
    verb: Option[String],
    activity: Option[String],
    registration: Option[UUID],
    since: Option[Date],
    until: Option[Date],
    related_activities: Option[Boolean],
    related_agents: Option[Boolean],
    limit: Option[Int],
    format: Option[FormatType.Value],
    attachments: Option[Boolean],
    ascending: Option[Boolean]): StatementResult = {
    val statementFilter = StatementFilter(
      statementId,
      voidedStatementId,
      agent,
      verb,
      activity,
      registration,
      since,
      until,
      related_activities,
      related_agents,
      limit,
      format,
      attachments,
      ascending
    )

    if (statementFilter.limit.isDefined && statementFilter.limit.get < 0)
      throw new IllegalArgumentException("Parameter 'limit' must have nonnegative integer value")

    statementLRS.getStatements(statementFilter)
  }

  def saveStatements(statements: Seq[Statement]): Seq[UUID] = {
    statementLRS.addStatements(statements)
  }

  def saveAttachment(hashOfContent: String, content: Array[Byte]): Unit = {
    fileStorage.store(hashOfContent, content)
  }

  def getAttachment(hashOfContent: String): Option[String] = {
    fileStorage.getFile(hashOfContent).map(fr => new String(fr.content.get))
  }
}
