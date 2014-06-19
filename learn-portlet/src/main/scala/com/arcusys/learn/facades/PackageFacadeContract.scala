package com.arcusys.learn.facades

import com.arcusys.learn.scorm.manifest.model.PackageType.PackageType
import com.arcusys.learn.scorm.manifest.model.{ BaseManifest, PackageGrade }
import com.arcusys.learn.tincan.manifest.model.ManifestActivity
import com.arcusys.learn.tincan.model.Statement

/**
 * Created by Iliya Tryapitsin on 16.04.2014.
 */
abstract trait PackageFacadeContract {
  //private[facades] def getPackages(valamisUserId: Int): Seq[Manifest]
  private[facades] def getPackageGrade(valamisUserId: Int, packageId: Int): Option[PackageGrade]

  private[facades] def updatePackageGrade(valamisUserId: Int, packageId: Int, grade: String, comment: String)

  private[facades] def getPackageType(packageId: Int): PackageType

  def getManifestActivities(packageId: Int): Seq[ManifestActivity]

  def getPackagesCount(courseId: Int): Int

  def getCompletedPackagesCount(courseId: Int, userId: Int): Int

  def getPackagesByCourse(courseId: Int): Seq[BaseManifest]

  def getCompletedPackagesCount(valamisUserId: Int): Int

  def getStatementGrades(packageId: Int, valamisUserId: Int): Seq[Statement]

  def getStatements(packageId: Int, valamisUserId: Int): Seq[Statement]
}
