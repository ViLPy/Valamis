package com.arcusys.learn.notifications

import com.arcusys.learn.facades.{ CertificateFacadeContract, CourseFacadeContract, PackageFacadeContract, UserFacadeContract }
import com.arcusys.learn.models.CourseResponse
import com.arcusys.learn.models.response.certificates.CertificateResponse
import com.arcusys.learn.scorm.manifest.model.BaseManifest
import com.arcusys.learn.scorm.tracking.model.PermissionType
import com.arcusys.learn.tincan.model.Statement
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.{ DateTime, Days }

trait CourseMessageService extends Injectable with MessageSender {
  import CourseMessageService._

  implicit def bindingModule: BindingModule

  private val templates = inject[MessageTemplateLoader]
  private val packages = inject[PackageFacadeContract]
  private val users = inject[UserFacadeContract]
  private val courses = inject[CourseFacadeContract]
  private val certificates = inject[CertificateFacadeContract]

  lazy val students = users.byPermission(PermissionType.STUDENT)
  lazy val teachers = users.byPermission(PermissionType.TEACHER)
  lazy val companyIds = courses.getCompanyIds

  def sendEnrolledStudentMessage() {
    val template = templates.getFor(MessageType.EnrolledStudent)

    val startedCourses = coursesWithPackages map {
      case (course, pkgs) => (course.id, pkgs.flatMap(pkg => getEnrolledStudents(pkg)).toSet)
    }

    teachers foreach { teacher =>
      val data = getTeacherCourses(teacher.id) collect {
        case course if startedCourses.get(course.id).isDefined
          && !startedCourses.get(course.id).get.isEmpty =>
          StudentRenderView(course.title, startedCourses.get(course.id).get.map(_.name).toSeq)
      }

      for {
        email <- teacher.email
        tpl <- template
        if data.nonEmpty
      } yield {
        val body = templates.render(tpl, Map("data" -> data, "date" -> todayFormatted))
        send Message ("New students enrolled in your course", body, email)
      }
    }
  }

  def sendCertificateExpirationMessage() {
    val template = templates.getFor(MessageType.CourseCertificateExpiration)

    students foreach { student =>
      val cs = companyIds flatMap { companyId =>
        certificates.getForUser(companyId.toInt, student.id.toInt, isShortResult = false) collect { case cr: CertificateResponse => cr }
      }

      val toBeExpired = cs filter (c => isExpiringSoon(c.expirationDate))

      val data = toBeExpired map { c =>
        CertificateRenderView(c.title, difference(today, c.expirationDate).toString, c.expirationDate.toString("EEEE, MMMM d"))
      }

      for {
        email <- student.email
        tpl <- template
        if data.nonEmpty
      } yield {
        val body = templates.render(tpl, Map("data" -> data, "date" -> todayFormatted))
        send Message ("Warning! Certificates are about to expire", body, email)
      }
    }

  }

  private def coursesWithPackages = (courses.all map { course =>
    (course, packages.getPackagesByCourse(course.id.toInt).filter(_.getVisibility == Some(true)))
  }).toMap

  private def getEnrolledStudents(pkg: BaseManifest) = students filter { student =>
    val statement = packages.getStatements(pkg.getId, student.id.toInt).headOption
    statement collect { case s => isNewlyStarted(s) } getOrElse false
  }

  private def isNewlyStarted(s: Statement) =
    s.stored.fold(false) { date =>
      (date.getTime > yesterday.getMillis) && (date.getTime < today.getMillis)
    }

  private def isExpiringSoon(expirationDate: DateTime) = {
    if (expirationDate.getMillis < today.getMillis) false
    else {
      val days = difference(today, expirationDate)
      days == 0 || days == 7 || days == 14
    }
  }

  private def difference(start: DateTime, end: DateTime) =
    Days.daysBetween(start, end).getDays

  private def getTeacherCourses(userId: Long): Seq[CourseResponse] = courses.getByUserId(userId)

  private def today = new DateTime
  private def todayFormatted = today.toString("EEEE, MMMM d")
  private def yesterday = today minusDays 1

}

object CourseMessageService {
  case class StudentRenderView(courseName: String, enrolledStudents: Seq[String])
  case class CertificateRenderView(title: String, days: String, date: String)
}