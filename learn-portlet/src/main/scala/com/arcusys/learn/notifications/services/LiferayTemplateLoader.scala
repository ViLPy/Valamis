package com.arcusys.learn.notifications.services

import com.arcusys.learn.liferay.util.PrefsPropsUtilHelper
import com.arcusys.learn.notifications.{ CourseMessageService, MessageTemplateLoader, MessageType }
import com.arcusys.learn.util.mustache.Mustache
import org.joda.time.DateTime

import scala.util.matching.Regex

object LiferayTemplateLoader extends MessageTemplateLoader {
  import com.arcusys.learn.notifications.MessageTemplateLoader._
  import com.arcusys.learn.notifications.MessageType._

  private val keys = Map[MessageType.Value, Key](
    EnrolledStudent -> Key("VALAMIS_EMAIL_STUDENT_ENROLLED_SUBJECT", "VALAMIS_EMAIL_STUDENT_ENROLLED_BODY"),
    FinishedLearningModule -> Key("VALAMIS_EMAIL_COMPLETE_MODULE_SUBJECT", "VALAMIS_EMAIL_COMPLETE_MODULE_BODY"),
    CourseCertificateDeadline -> Key("VALAMIS_EMAIL_CERTIFICATE_DEADLINE_SUBJECT", "VALAMIS_EMAIL_CERTIFICATE_DEADLINE_BODY"),
    CourseCertificateExpiration -> Key("VALAMIS_EMAIL_CERTIFICATE_EXPIRE_SUBJECT", "VALAMIS_EMAIL_CERTIFICATE_EXPIRE_BODY")
  )

  def getFor(mtype: MessageType.Value): Option[MessageTemplate] = {
    for {
      key <- keys.get(mtype)
      subject <- PrefsPropsUtilHelper.getDefaultContent(key.subject)
      body <- PrefsPropsUtilHelper.getDefaultContent(key.body)
    } yield MessageTemplate(subject, mtype, body)
  }

  def render(tpl: MessageTemplate, data: Map[String, _]): String = tpl.typ match {
    case EnrolledStudent             => renderTemplate(tpl.body, data, Tags.enrolledStudents)
    case FinishedLearningModule      => renderTemplate(tpl.body, data, Tags.completedModules)
    case CourseCertificateExpiration => renderTemplate(tpl.body, data, Tags.expiredCertificates)
    case CourseCertificateDeadline   => renderDeadlineTemplate(tpl.body, data)
    case _                           => ""
  }

  private def renderTemplate(tpl: String, data: Map[String, _], tags: Map[String, String]): String = {
    val general = Tags.translate(tpl, Tags.general)
    val translated = Tags.translate(general, tags)
    val mustached = new Mustache(translated)
    mustached.render(data)
  }

  private case class Key(subject: String, body: String)

  object renderDeadlineTemplate {
    private val coursesRegex = """(?<=\[\$REPEAT_COURSE\$\]).*?(?=\[\$\/REPEAT_COURSE\$\])""".r
    private val activitiesRegex = """(?<=\[\$REPEAT_ACTIVITY\$\]).*?(?=\[\$\/REPEAT_ACTIVITY\$\])""".r
    private val statementsRegex = """(?<=\[\$REPEAT_STATEMENT\$\]).*?(?=\[\$\/REPEAT_STATEMENT\$\])""".r

    def apply(tpl: String, data: Map[String, _]): String = {
      val quotes = getQuotes(tpl)
      val body = shapeBody(tpl, quotes)
      val d = getData(data("data").asInstanceOf[Seq[CourseMessageService.DeadlineRenderView]], quotes)
      val rendered = renderTemplate(body, Map("data" -> d, "date" -> data.get("date").getOrElse("")), Tags.deadlinedCertificates)
      rendered
    }

    private def getQuotes(tpl: String): GoalQuotes = {
      val extract: Regex => Option[String] = r => r.findFirstIn(tpl)
      GoalQuotes(extract(coursesRegex), extract(activitiesRegex), extract(statementsRegex))
    }

    private def shapeBody(tpl: String, qs: GoalQuotes): String = {
      var output = tpl
      val replace: String => Unit = s => output = output.replace(s, """{{.}}""")
      qs.course foreach replace
      qs.activity foreach replace
      qs.statement foreach replace
      output
    }

    private def getData(data: Seq[CourseMessageService.DeadlineRenderView], qs: GoalQuotes): Seq[Deadline] = {
      val replace: (CourseMessageService.Deadline, String) => String = {
        (dl, s) =>
          s.replace("""[$TITLE$]""", dl.name)
            .replace("""[$DAYS$]""", dl.days.toString)
            .replace("""[$DATE$]""", dl.date.toString("EEEE, MMMM d"))
      }
      data map { dl =>
        Deadline(dl.title,
          qs.activity.map(a => dl.activities.map(as => replace(as, a))).getOrElse(Seq()),
          qs.course.map(c => dl.courses.map(cs => replace(cs, c))).getOrElse(Seq()),
          qs.statement.map(s => dl.statements.map(ss => replace(ss, s))).getOrElse(Seq()))
      }
    }

    case class Deadline(title: String, activities: Seq[String], courses: Seq[String], statements: Seq[String])
    case class GoalQuotes(course: Option[String], activity: Option[String], statement: Option[String])
  }

  object Tags {
    val general = Map(
      """[$DATE$]""" -> """{{date}}""",
      """[$REPEAT$]""" -> """{{#data}}""",
      """[$/REPEAT$]""" -> """{{/data}}"""
    )
    val enrolledStudents = Map(
      """[$COURSE_NAME$]""" -> """{{courseName}}""",
      """[$ENROLLED_STUDENTS$]""" ->
        """<br/><table>{{#enrolledStudents}}<tr><td valign="top">{{.}}</td></tr>{{/enrolledStudents}}</table>"""
    )
    val completedModules = Map(
      """[$STUDENT_NAME$]""" -> """{{studentName}}""",
      """[$FINISHED_PACKAGES$]""" ->
        """<br/><table>{{#finishedPackages}}<tr><td valign="top">{{.}}</td></tr>{{/finishedPackages}}</table>"""
    )
    val expiredCertificates = Map(
      """[$CERTIFICATE_NAME$]""" -> """{{title}}""",
      """[$DAYS$]""" -> """{{days}}""",
      """[$EXPIRATION_DATE$]""" -> """{{date}}"""
    )
    val deadlinedCertificates = Map(
      """[$CERTIFICATE_NAME$]""" -> """{{title}}""",
      """[$REPEAT_COURSE$]""" -> """<table>{{#courses}}<tr><td valign="top">""",
      """[$/REPEAT_COURSE$]""" -> """</td></tr>{{/courses}}</table>""",
      """[$REPEAT_STATEMENT$]""" -> """<table>{{#statements}}<tr><td valign="top">""",
      """[$/REPEAT_STATEMENT$]""" -> """</td></tr>{{/statements}}</table>""",
      """[$REPEAT_ACTIVITY$]""" -> """<table>{{#activities}}<tr><td valign="top">""",
      """[$/REPEAT_ACTIVITY$]""" -> """</td></tr>{{/activities}}</table>"""
    )

    def translate(target: String, tags: Map[String, String]): String = {
      (target.lines map (line => translateLine(line, tags))).mkString
    }

    def translateLine(target: String, tags: Map[String, String]): String = {
      var output: String = target
      tags.keys foreach { key =>
        val regex = key.r
        regex.findFirstIn(output).foreach(o => output = output.replace(key, tags(key)))
      }
      output
    }
  }
}
