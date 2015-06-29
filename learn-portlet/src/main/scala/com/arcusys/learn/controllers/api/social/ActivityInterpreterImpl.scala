package com.arcusys.learn.controllers.api.social

import com.arcusys.learn.models.CourseResponse
import com.arcusys.learn.models.response.social._
import com.arcusys.valamis.certificate.model.{CertificateStatus, Certificate}
import com.arcusys.valamis.certificate.service.CertificateService
import com.arcusys.valamis.gradebook.model.CourseGrade
import com.arcusys.valamis.gradebook.service.CourseGradeService
import com.arcusys.valamis.lesson.model.{LessonType, PackageActivityType}
import com.arcusys.valamis.lesson.scorm.model.ScormPackage
import com.arcusys.valamis.lesson.service.PackageService
import com.arcusys.valamis.lesson.tincan.model.TincanPackage
import com.arcusys.valamis.social.model.UserStatus
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}

trait ActivityInterpreter{
  def getVerb(className: String, activityType: Int): String
  def getObj(className: String, classPK: Option[Long], extraData: Option[String]): ActivityObjectResponse
}

class ActivityInterpreterImpl(
    implicit val bindingModule: BindingModule)
  extends Injectable
  with ActivityInterpreter {

  val ScormPackageClassName = classOf[ScormPackage].getName
  val TincanPackageClassName = classOf[TincanPackage].getName
  val CertificateClassName = classOf[Certificate].getName
  val CourseGradeClassName = classOf[CourseGrade].getName
  val UserStatusClassName = classOf[UserStatus].getName

  val packageService = inject[PackageService]
  val courseService = inject[CourseGradeService]
  val certificateService = inject[CertificateService]

  override def getVerb(className: String, activityType: Int): String = className match {
    case ScormPackageClassName | TincanPackageClassName => PackageActivityType(activityType).toString
    case CertificateClassName => CertificateStatus(activityType).toString
    case CourseGradeClassName => "Completed"
    case UserStatusClassName => "Wrote"
  }

  override def getObj(className: String, classPK: Option[Long], extraData: Option[String]) = className match {
    case ScormPackageClassName | TincanPackageClassName => getPackageActivityObj(classPK.get, extraData)
    case CertificateClassName => getCertificateActivityObj(classPK.get, extraData)
    case CourseGradeClassName => getCourseActivityObj(classPK.get, extraData)
    case UserStatusClassName => getUserStatusActivityObj(extraData.get)
  }

  private def getUserStatusActivityObj(content: String) = ActivityUserStatusResponse(content)

  private def getCourseActivityObj(courseId: Long, extraData: Option[String]) = {
    val course = courseService.getById(courseId.toInt).get

    ActivityCourseResponse(courseId, course.getDescriptiveName)
  }

  private def getCertificateActivityObj(certificateId: Long, extraData: Option[String]) = {
    val certificate = certificateService.getById(certificateId.toInt)
    val logo = if(certificate.logo == "") None else Some(certificate.logo)

    ActivityCertificateResponse(certificateId, certificate.title, logo)
  }

  private def getPackageActivityObj(packageId: Long, extraData: Option[String]) = {
    val pack =
      packageService.getPackageType(packageId) match {
        case LessonType.Scorm => packageService.getScormPackageById(packageId).get
        case LessonType.Tincan => packageService.getTincanPackageById(packageId).get
      }

    val course =
      pack
        .courseID
        .flatMap(courseService.getById)
        .map { lGroup =>
        CourseResponse(
          lGroup.getGroupId,
          lGroup.getDescriptiveName,
          lGroup.getFriendlyURL,
          lGroup.getDescription
        )}
        .getOrElse(throw new IllegalStateException(s"Package with id:$packageId doesn't have a corresponding course"))

    ActivityPackageResponse(
      packageId,
      pack.title,
      pack.logo,
      course,
      extraData
    )
  }
}