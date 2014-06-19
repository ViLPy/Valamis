package com.arcusys.learn.facades

import com.arcusys.learn.MutableEntityRepository
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException
import com.arcusys.learn.scorm.manifest.model.PackageType.PackageType
import com.arcusys.learn.scorm.manifest.model.{ BaseManifest, PackageGrade, PackageType }
import com.arcusys.learn.scorm.manifest.storage.PackagesStorage
import com.arcusys.learn.tincan.lrs.statement.{ StatementFilter, StatementLRS }
import com.arcusys.learn.tincan.manifest.model.ManifestActivity
import com.arcusys.learn.tincan.manifest.storage.{ TincanManifestActivityStorage, TincanPackageStorage }
import com.arcusys.learn.tincan.model.{ Agent, Statement }
import com.arcusys.learn.tincan.storage.StatementStorage
import com.arcusys.scorm.lms.PackageService
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

/**
 * Created by Iliya Tryapitsin on 16.04.2014.
 */
class PackageFacade(configuration: BindingModule) extends PackageFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  val packageStorage = inject[PackagesStorage]
  val tcpackageStorage = inject[TincanPackageStorage]
  val packageGradeStorage = inject[MutableEntityRepository[PackageGrade]]
  val tincanManifestActivityStorage = inject[TincanManifestActivityStorage]

  val statementLRS = new StatementLRS() {
    val statementStorage = inject[StatementStorage]
  }

  //private[facades] def getPackages(valamisUserId: Int): Seq[BaseManifest] = packageStorage.getPackagesWithUserAttempts(valamisUserId)
  private[facades] def getPackageGrade(valamisUserId: Int, packageId: Int) = {
    try {
      Option(packageGradeStorage.get(
        "userId" -> valamisUserId,
        "packageId" -> packageId))
    } catch {
      case e: NoSuchLFPackageGradeStorageException => None
    }
  }

  private[facades] def getPackageType(packageId: Int): PackageType = {
    val packageService = new PackageService
    PackageType.withName(packageService.getPackageType(packageId))
  }

  def getManifestActivities(packageId: Int): Seq[ManifestActivity] = tincanManifestActivityStorage.getByPackageID(packageId)

  def getPackagesCount(courseId: Int): Int = getPackagesByCourse(courseId).length

  def getCompletedPackagesCount(courseId: Int, userId: Int): Int =
    getPackagesByCourse(courseId)
      .map(m => getPackageGrade(userId, m.getId))
      .count(g => g.isDefined)

  def getPackagesByCourse(courseId: Int): Seq[BaseManifest] = packageStorage.getByCourseID(Some(courseId)) ++ tcpackageStorage.getByCourseID(Some(courseId))

  def getCompletedPackagesCount(valamisUserId: Int): Int = ???

  def getStatementGrades(packageId: Int, valamisUserId: Int): Seq[Statement] = {
    val email = getEmail(valamisUserId)

    getPackageType(packageId) match {
      case PackageType.SCORM  => getSCORMStatements(packageId, email)
      case PackageType.TINCAN => getTINCANStatements(packageId, email)
    }
  }

  def getStatements(packageId: Int, valamisUserId: Int): Seq[Statement] = getStatementGrades(packageId, valamisUserId)

  private def getSCORMStatements(packageId: Int, email: String) = {
    val filter = StatementFilter(
      agent = Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
      activity = Option(packageId.toString),
      relatedActivities = Option(true))
    statementLRS.getStatements(filter).statements
  }

  private def getTINCANStatements(packageId: Int, email: String) = {
    getManifestActivities(packageId).map(manifestActivity => {
      val filter = StatementFilter(
        agent = Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
        activity = Option(manifestActivity.tincanId.toString),
        relatedActivities = Option(true))

      statementLRS.getStatements(filter).statements
    }).flatMap(seq => seq)
  }

  private def getEmail(valamisUserId: Int) =
    "mailto:" + UserLocalServiceHelper().getUser(valamisUserId).getEmailAddress

  override private[facades] def updatePackageGrade(valamisUserId: Int,
    packageId: Int,
    grade: String,
    comment: String): Unit = {
    getPackageGrade(valamisUserId, packageId) match {
      case Some(value) => {
        val changedPackageGrade = value.copy(comment = comment, grade = grade)
        packageGradeStorage.modify(changedPackageGrade)
      }

      case None => {
        val packageGrade = PackageGrade(valamisUserId, packageId, grade, comment)
        packageGradeStorage.create(packageGrade)
      }
    }

  }

}
