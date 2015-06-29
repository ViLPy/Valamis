package com.arcusys.valamis.gradebook.service

import com.arcusys.valamis.gradebook.model.PackageGrade
import com.arcusys.valamis.gradebook.storage.PackageGradesStorage
import com.arcusys.valamis.lesson.service.ValamisPackageService
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

/**
 * Created by mminin on 13.04.15.
 */
class PackageGradeService(implicit val bindingModule: BindingModule) extends Injectable {

  val packageGradeStorage = inject[PackageGradesStorage]
  val packageService = inject[ValamisPackageService]

  private val SuccessAfter = 0.7

  def getPackageGrade(valamisUserId: Int, packageId: Long): Option[PackageGrade] = {
    packageGradeStorage.get(valamisUserId, packageId)
  }

  def isCompleted(userId: Long, packageId: Long): Boolean =
    packageGradeStorage.get(userId, packageId)
      .map (_.grade.toFloat / 100 > SuccessAfter)
      .getOrElse(false)

  def updatePackageGrade(valamisUserId: Int, packageId: Long, grade: String, comment: String) {
    getPackageGrade(valamisUserId, packageId) match {
      case Some(value) =>
        val changedPackageGrade = value.copy(comment = comment, grade = grade)
        packageGradeStorage.modify(changedPackageGrade)

      case None =>
        val packageGrade = PackageGrade(valamisUserId, packageId, grade, comment)
        packageGradeStorage.create(packageGrade)
    }
  }

  def getCompletedPackagesCount(courseId: Int, userId: Int): Int =
    packageService.getPackagesByCourse(courseId)
      .map(m => getPackageGrade(userId, m.id))
      .count(g => g.isDefined)
}
