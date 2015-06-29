package com.arcusys.valamis.social.service

import com.arcusys.learn.liferay.model.Activity
import com.arcusys.learn.liferay.services.SocialActivityLocalServiceHelper
import com.arcusys.valamis.certificate.model.Certificate
import com.arcusys.valamis.gradebook.model.CourseGrade
import com.arcusys.valamis.lesson.model.{PackageActivityType, LessonType}
import com.arcusys.valamis.lesson.scorm.model.ScormPackage
import com.arcusys.valamis.lesson.service.ValamisPackageService
import com.arcusys.valamis.lesson.tincan.model.TincanPackage
import com.arcusys.valamis.social.model.UserStatus
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import org.joda.time.DateTime

class ActivityServiceImpl(
    implicit val bindingModule: BindingModule)
  extends ActivityService
  with Injectable {

  val supportedActivities = Set(classOf[ScormPackage].getName,
                                classOf[TincanPackage].getName,
                                classOf[Certificate].getName,
                                classOf[CourseGrade].getName,
                                classOf[UserStatus].getName)

  val packageService = inject[ValamisPackageService]


  def create(companyId: Long, userId: Long, content: String): Activity = {
    SocialActivityLocalServiceHelper.addWithSet(
      companyId,
      userId,
      classOf[UserStatus].getName,
      extraData = Some(content)
    )
  }

  def share(companyId: Long, userId: Long, packageId: Long, comment: Option[String]) = {
    packageService.getPackageType(packageId) match {
      case LessonType.Scorm => SocialActivityLocalServiceHelper.addWithSet(
        companyId,
        userId,
        classOf[ScormPackage].getName,
        `type` = Some(PackageActivityType.Shared.id),
        classPK = Some(packageId),
        extraData = comment)
      case LessonType.Tincan => SocialActivityLocalServiceHelper.addWithSet(
        companyId,
        userId,
        classOf[TincanPackage].getName,
        `type` = Some(PackageActivityType.Shared.id),
        classPK = Some(packageId),
        extraData = comment)
    }
  }

  def getBy(companyId: Long): Seq[Activity] = {
    implicit val dateTimeOrdering: Ordering[DateTime] = Ordering.fromLessThan(_ isBefore _)
      SocialActivityLocalServiceHelper
        .getBy(companyId = companyId)
        .filter(sa => supportedActivities.contains(sa.className))
        .sorted(Ordering.by((_: Activity).createDate).reverse)
        .take(6)
    }
}