package com.arcusys.learn.notifications

import com.arcusys.learn.facades.{ CertificateFacadeContract, CourseFacadeContract, UserFacadeContract }
import com.arcusys.learn.models.CourseResponse
import com.arcusys.learn.models.response.certificates.CertificateResponse
import com.arcusys.learn.notifications.MessageTemplateLoader.MessageTemplate
import com.arcusys.valamis.gradebook.service.PackageGradeService
import com.arcusys.valamis.lesson.model.BaseManifest
import com.arcusys.valamis.lesson.service.ValamisPackageService
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.arcusys.valamis.lrs.tincan.Statement
import com.arcusys.valamis.settings.service.SettingService
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.{ DateTime, Days }

trait CourseMessageService extends Injectable with MessageSender {
  import com.arcusys.learn.notifications.CourseMessageService._

  implicit def bindingModule: BindingModule

  private val templates = inject[MessageTemplateLoader]
  private val packages = inject[ValamisPackageService]
  private val grades = new PackageGradeService()
  private val users = inject[UserFacadeContract]
  private val courses = inject[CourseFacadeContract]
  private val certificates = inject[CertificateFacadeContract]
  private val settingsManager = inject[SettingService]
  private val lrsReader = inject[LrsClientManager]

  private lazy val students = users.allCanView(viewAll = false)
  private lazy val teachers = users.allCanView(viewAll = true)

  def sendCourseMessages(statementApi: StatementApi) {
    val enrollmentTemplate = templates.getFor(MessageType.EnrolledStudent)
    val learningTemplate = templates.getFor(MessageType.FinishedLearningModule)

    val coursesWithPackages = (courses.all map { course =>
      (course, packages.getPackagesByCourse(course.id.toInt).filter(_.visibility == Some(true)))
    }).toMap.view

    val startedCourses = (coursesWithPackages map {
      case (course, pkgs) => (course.id, pkgs.flatMap(pkg => getEnrolledStudents(statementApi, pkg)).toSet)
    }).toMap

    val finishedPackages = (students flatMap { student =>
      coursesWithPackages map {
        case (course, pkgs) =>
          (course.id, student.name,
            pkgs.collect { case pkg if isFinishedPackage(student.id.toInt, pkg.id) => pkg.title }
          )
      }
    }) filter (p => p._3.nonEmpty)

    teachers foreach { teacher =>

      val data = getTeacherCourses(teacher.id).foldLeft(Seq[StudentRenderView](), Seq[PackagesRenderView]()) {
        (views, course) =>
          (
            if (startedCourses.get(course.id).isDefined && startedCourses.get(course.id).get.nonEmpty)
              views._1 :+ StudentRenderView(course.title, startedCourses.get(course.id).get.map(_.name).toSeq)
            else
              views._1,
            if (finishedPackages.filter(p => p._1 == course.id).nonEmpty)
              views._2 ++ finishedPackages.filter(p => p._1 == course.id).map(p => PackagesRenderView(p._2, p._3.toList))
            else
              views._2
          )
      }

      sendMessage(teacher.email, enrollmentTemplate, data._1)
      sendMessage(teacher.email, learningTemplate, data._2)
    }
  }

  def sendCertificateMessages() {
    val expirationTemplate = templates.getFor(MessageType.CourseCertificateExpiration)
    val deadlineTemplate = templates.getFor(MessageType.CourseCertificateDeadline)
    val companies = courses.getCompanyIds

    students foreach { student =>
      val cs = (companies flatMap { companyId =>
        certificates.getForUser(companyId.toInt, student.id.toInt, isShortResult = false)
          .collect { case cr: CertificateResponse => cr }
      }).view

      val expirationData = cs collect {
        case certificate if isExpiringSoon(certificate.expirationDate) =>
          ExpirationRenderView(
            title = certificate.title,
            days = difference(today, certificate.expirationDate).toString,
            date = certificate.expirationDate.toString("EEEE, MMMM d")
          )
      }

      val deadlineData = cs map { certificate =>
        val goals = certificates.getGoalsDeadlines(certificate.id, student.id.toInt)

        val tobeDeadlined = (
          goals.activities.filter(a => isDeadlineComing(a.deadline)).view,
          goals.courses.filter(c => isDeadlineComing(c.deadline)).view,
          goals.statements.filter(s => isDeadlineComing(s.deadline)).view
        )

        DeadlineRenderView(
          title = certificate.title,
          activities = tobeDeadlined._1.map(r => Deadline(r.name, difference(today, r.deadline.get), r.deadline.get)).toList,
          courses = tobeDeadlined._2.map(c => Deadline(courses.getCourse(c.id).title, difference(today, c.deadline.get), c.deadline.get)).toList,
          statements = tobeDeadlined._3.map(s => Deadline(s"${s.obj} ${s.verb}", difference(today, s.deadline.get), s.deadline.get)).toList
        )
      } filter (cv => cv.activities.nonEmpty && cv.courses.nonEmpty && cv.statements.nonEmpty)

      sendMessage(student.email, deadlineTemplate, deadlineData.toList)
      sendMessage(student.email, expirationTemplate, expirationData.toList)
    }
  }

  private def sendMessage[T](emailAddress: Option[String], tpl: Option[MessageTemplate], data: Seq[T]) {
    for {
      email <- emailAddress
      tpl <- tpl
      if data.nonEmpty && isSendable
    } yield {
      val body = templates.render(tpl, Map("data" -> data, "date" -> todayFormatted))
      send Message (tpl.subject, body, email)
    }
  }

  private def isSendable = settingsManager.getSendMessages()

  private def getEnrolledStudents(statementApi: StatementApi, pkg: BaseManifest) = {
    (students filter { student =>
      val statement = packages.getStatements(pkg.id, student.id.toInt, statementApi).headOption
      statement collect { case s => isNewlyStarted(s) } getOrElse false
    }).toList
  }

  private def getTeacherCourses(userId: Long): Seq[CourseResponse] = courses.getByUserId(userId)

  private def isDeadlineComing(date: Option[DateTime]) = date.fold(false)(isExpiringSoon)

  private def isNewlyStarted(s: Statement) = s.stored.fold(false) { date => isValid(new DateTime(date)) }

  private def isFinishedPackage(userId: Int, packageId: Long) = {
    val grade = grades.getPackageGrade(userId, packageId)
    grade.fold(false) { g => g.date exists isValid }
  }

  private def isValid(date: DateTime) = (date.getMillis > yesterday.getMillis) && (date.getMillis < today.getMillis)

  private def isExpiringSoon(expirationDate: DateTime) = {
    if (expirationDate.getMillis < today.getMillis) false
    else {
      val days = difference(today, expirationDate)
      days == 0 || days == 7 || days == 14
    }
  }

  private def difference(start: DateTime, end: DateTime) = Days.daysBetween(start, end).getDays

  private def today = new DateTime
  private def todayFormatted = today.toString("EEEE, MMMM d")
  private def yesterday = today minusDays 1
}

object CourseMessageService {
  case class StudentRenderView(courseName: String, enrolledStudents: Seq[String])
  case class PackagesRenderView(studentName: String, finishedPackages: Seq[String])
  case class ExpirationRenderView(title: String, days: String, date: String)

  case class DeadlineRenderView(title: String, activities: Seq[Deadline], courses: Seq[Deadline], statements: Seq[Deadline])
  case class Deadline(name: String, days: Int, date: DateTime)
}