package com.arcusys.learn.bl.services

import java.io.InputStream
import java.util.Date
import com.arcusys.learn.scorm.manifest.model.PackageType.PackageType
import com.arcusys.learn.scorm.manifest.model.PeriodType._
import com.arcusys.learn.scorm.manifest.model.ScopeType.ScopeType

import scala.collection.JavaConverters._

import com.arcusys.learn.bl.models.RangeResult
import com.arcusys.learn.bl.exceptions.EntityNotFoundException
import com.arcusys.learn.bl.export.packages.{ PackageMobileExportProcessor, PackageImportProcessor, PackageExportProcessor }
import com.arcusys.learn.bl.models.valamispackage.{ PackageSortBy, PackageUploadModel, ValamisPackage }

import com.arcusys.learn.bl.liferay.service.asset.AssetHelper
import com.arcusys.learn.bl.ioc.DomainConfiguration

import com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException
import com.arcusys.learn.repositories.MutableEntityRepository
import com.arcusys.learn.filestorage.storage.FileStorage

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage.ScormPackagesStorage
import com.arcusys.learn.scorm.tracking.states.storage.ActivityStateTreeStorage
import com.arcusys.learn.scorm.tracking.storage.AttemptStorage
import com.arcusys.learn.tincan.lrs.statement.{ StatementFilter, StatementLRS }
import com.arcusys.learn.tincan.manifest.model.{ TincanManifest, ManifestActivity }
import com.arcusys.learn.tincan.manifest.storage.{ TincanManifestActivityStorage, TincanPackageStorage }
import com.arcusys.learn.tincan.model.{ Agent, Statement, TincanURIType }
import com.arcusys.learn.tincan.storage.StatementStorage
import com.arcusys.scorm.lms.PackageService
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.model.User
import com.arcusys.learn.liferay.services.{ LayoutLocalServiceHelper, UserLocalServiceHelper }

// TODO refactor, split on parts, tincan statement part, scores, impoport/export ...
class ValamisPackageService(configuration: BindingModule) extends ValamisPackageServiceContract with Injectable {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration

  val packageRepository = inject[ScormPackagesStorage]
  val tcpackageRepository = inject[TincanPackageStorage]
  val packageGradeStorage = inject[MutableEntityRepository[PackageGrade]]
  val tincanManifestActivityStorage = inject[TincanManifestActivityStorage]
  val uriService = inject[URIServiceContract]
  val attemptStorage = inject[AttemptStorage]
  val activityStateTreeStorage = inject[ActivityStateTreeStorage]
  val passingLimitChecker = inject[LessonLimitChecker]
  val fileStorage = inject[FileStorage]

  private val assetHelper = new AssetHelper()
  private val packageService = new PackageService()

  val statementLRS = new StatementLRS() {
    val statementStorage = inject[StatementStorage]
  }

  def getPackageGrade(valamisUserId: Int, packageId: Int) = {
    try {
      Option(packageGradeStorage.get(
        "userId" -> valamisUserId,
        "packageId" -> packageId))
    } catch {
      case e: NoSuchLFPackageGradeStorageException => None
    }
  }

  def getPackageType(packageId: Int): PackageType = {
    val packageService = new PackageService
    PackageType.withName(packageService.getPackageType(packageId))
  }

  def getManifestActivities(packageId: Int): Seq[ManifestActivity] = tincanManifestActivityStorage.getByPackageID(packageId)

  def getPackagesCount(courseId: Int): Int = getPackagesByCourse(courseId).length

  def getCompletedPackagesCount(courseId: Int, userId: Int): Int =
    getPackagesByCourse(courseId)
      .map(m => getPackageGrade(userId, m.getId))
      .count(g => g.isDefined)

  def getPackagesByCourse(courseId: Int): Seq[BaseManifest] = packageRepository.getByCourseID(Some(courseId)) ++ tcpackageRepository.getByCourseID(Some(courseId))

  def getTincanPackagesByCourse(courseId: Int): Seq[BaseManifest] = tcpackageRepository.getByCourseID(Some(courseId))

  def getPackage(packageId: Int): BaseManifest = packageRepository.getByID(packageId).getOrElse(
    tcpackageRepository.getByID(packageId).getOrElse(throw new EntityNotFoundException("Package not found"))
  )

  def getStatementGrades(packageId: Int, valamisUserId: Int): Seq[Statement] = {
    val email = getEmail(valamisUserId)

    getPackageType(packageId) match {
      case PackageType.SCORM  => getSCORMStatements(packageId, email)
      case PackageType.TINCAN => getTINCANStatements(packageId, email)
    }
  }

  def getStatements(packageObj: BaseManifest, valamisUserId: Int, dateSince: Option[Date] = None): Seq[Statement] = {
    val email = getEmail(valamisUserId)

    packageObj.getType match {
      case PackageType.SCORM  => getSCORMStatements(packageObj.getId, email, dateSince)
      case PackageType.TINCAN => getTINCANStatements(packageObj.getId, email, dateSince)
    }
  }

  def getStatements(packageId: Int, valamisUserId: Int): Seq[Statement] = getStatementGrades(packageId, valamisUserId)

  override def exportAllPackages(courseID: Int): InputStream = {
    val exportProcessor = new PackageExportProcessor()

    exportProcessor.exportItems(getPackagesByCourse(courseID).toSeq)
  }

  override def exportPackages(packagesIds: Seq[Int]): InputStream = {
    val exportProcessor = new PackageExportProcessor()

    exportProcessor.exportItems(packagesIds.map(getPackage(_)))
  }

  override def exportPackagesForMobile(packagesIds: Seq[Int]): InputStream = {
    val exportProcessor = new PackageMobileExportProcessor()

    exportProcessor.exportItems(packagesIds.map(getPackage(_)))
  }

  override def importPackages(raw: String, courseID: Int): Unit = {
    val exportProcessor = new PackageImportProcessor()

    exportProcessor.importItems(raw, courseID)
  }

  private def getSCORMStatements(packageId: Int, email: String, dateSince: Option[Date] = None) = {
    val packageUri = uriService.getURI(packageId.toString, TincanURIType.Package)
    val filter = StatementFilter(
      agent = Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
      activity = if (packageUri.isDefined) Option(packageUri.get.uri) else Option(packageId.toString),
      relatedActivities = Option(true),
      since = if (dateSince.isDefined) Option(dateSince.get) else None)
    statementLRS.getStatements(filter).statements
  }

  private def getTINCANStatements(packageId: Int, email: String, dateSince: Option[Date] = None) = {
    getManifestActivities(packageId).map(manifestActivity => {
      val filter = StatementFilter(
        agent = Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
        activity = Option(manifestActivity.tincanId.toString),
        relatedActivities = Option(true),
        since = if (dateSince.isDefined) Option(dateSince.get) else None)

      statementLRS.getStatements(filter).statements
    }).flatMap(seq => seq)
  }

  private def getEmail(valamisUserId: Int) =
    "mailto:" + UserLocalServiceHelper().getUser(valamisUserId).getEmailAddress

  def updatePackageGrade(valamisUserId: Int, packageId: Int, grade: String, comment: String) {
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

  def extract(manifest: Manifest, userId: Int) = {
    val attempt = attemptStorage.getActive(userId, manifest.id)
    val activityId = if (attempt.isDefined) {
      val activity = activityStateTreeStorage.get(attempt.get.id)
      if (activity.isDefined) Some(activity.get.item.activity.id)
      else None
    } else None
    ValamisPackage(manifest.id,
      manifest.title,
      manifest.summary.map(_.replaceAll("\n", "")),
      manifest.version,
      manifest.visibility.getOrElse(false),
      manifest.isDefault,
      "scorm",
      manifest.logo,
      activityId,
      manifest.passingLimit,
      manifest.rerunInterval,
      manifest.rerunIntervalType,
      passingLimitChecker.getScormAttemptsCount(userId, manifest.id)
    )
  }

  def extractTinCan(manifest: TincanManifest, attempts: Int) = ValamisPackage(manifest.id,
    manifest.title,
    manifest.summary.map(_.replaceAll("\n", "")),
    Some(""),
    manifest.visibility.getOrElse(false),
    manifest.isDefault,
    "tincan",
    manifest.logo,
    None,
    manifest.passingLimit,
    manifest.rerunInterval,
    manifest.rerunIntervalType,
    attempts
  )

  def extract(manifest: TincanManifest, user: User) = {
    extractTinCan(manifest, passingLimitChecker.getTincanAttemptsCount(user, manifest.id))
  }

  def extract(manifest: TincanManifest) = {
    extractTinCan(manifest, 0)
  }

  def getForPlayer(playerID: String, companyID: Long, groupId: Long, userId: Int): Seq[ValamisPackage] = {

    val courseIds = packageService.getAllCourseIDs(companyID)
    val layouts = LayoutLocalServiceHelper.getLayouts(groupId, true)

    val shown = packageRepository.getByExactScope(courseIds, ScopeType.Player, playerID).map(_.id)
    val personalPackages = packageRepository.getByCourseID(Some(layouts.asScala.last.getGroupId.toInt)).filter(p => !shown.contains(p.id))
    val shownTC = tcpackageRepository.getByExactScope(courseIds, ScopeType.Player, playerID).map(_.id)
    val personalTincanPackages = tcpackageRepository.getByCourseID(Some(layouts.asScala.last.getGroupId.toInt)).filter(p => !shownTC.contains(p.id))

    personalPackages.map(pack => extract(pack, userId)) ++ personalTincanPackages.map(extract)
  }

  def getAllPackages(packageType: PackageType, courseID: Option[Int], scope: ScopeType, filter: String, isSortDirectionAsc: Boolean, skip: Int, count: Int, page: Int, companyID: Long, userId: Int): RangeResult[ValamisPackage] = {

    val packages = scope match {
      case ScopeType.Instance => {
        val courseIds = packageService.getAllCourseIDs(companyID)
        packageType match {
          case PackageType.SCORM  => packageRepository.getAllForInstance(courseIds).map(pack => extract(pack, userId))
          case PackageType.TINCAN => tcpackageRepository.getAllForInstance(courseIds).map(extract)
          case PackageType.ALL    => packageRepository.getAllForInstance(courseIds).map(pack => extract(pack, userId)) ++ tcpackageRepository.getAllForInstance(courseIds).map(extract)
        }
      }
      case ScopeType.Site => {
        packageType match {
          case PackageType.SCORM  => packageRepository.getByCourseID(courseID).map(pack => extract(pack, userId))
          case PackageType.TINCAN => tcpackageRepository.getByCourseID(courseID).map(extract)
          case PackageType.ALL    => packageRepository.getByCourseID(courseID).map(pack => extract(pack, userId)) ++ tcpackageRepository.getByCourseID(courseID).map(extract)
        }
      }
    }

    val filtered = if (!filter.isEmpty) packages.filter(_.title.toLowerCase.contains(filter.toLowerCase))
    else packages

    val orderedPackages = if (isSortDirectionAsc) filtered.sortBy(_.title.toLowerCase)
    else filtered.sortBy(_.title.toLowerCase).reverse

    val total = orderedPackages.length
    val pagedPackages = orderedPackages.drop(skip).take(if (count == 0) total else count)

    RangeResult(
      total,
      pagedPackages
    )
  }

  def getVisiblePackages(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User, isSortDirectionAsc: Boolean, sortBy: PackageSortBy.PackageSortBy): Seq[ValamisPackage] = {
    val userId = user.getUserId.toInt

    val scormFiltered = packageService.getVisiblePackages(playerID, companyID, courseID.get, pageID)
      .filter(p => passingLimitChecker.checkScormPackage(user, p.id))

    val tincanFiltered = packageService.getVisibleTincanPackages(playerID, companyID, courseID.get, pageID)
      .filter(p => passingLimitChecker.checkTincanPackage(user, p.id))

    val bothFilterd = if (filter.isEmpty) scormFiltered.map(pack => extract(pack, userId)) ++ tincanFiltered.map(pack => extract(pack, user))
    else scormFiltered.filter(_.title.toLowerCase.contains(filter.toLowerCase)).map(pack => extract(pack, userId)) ++ tincanFiltered.filter(_.title.toLowerCase.contains(filter.toLowerCase)).map(pack => extract(pack, user))

    val bothSortedAZ = sortBy match {
      case PackageSortBy.Name => bothFilterd.sortBy(_.title)
      case PackageSortBy.Date => bothFilterd.sortBy(_.id)
    }

    if (isSortDirectionAsc) bothSortedAZ else bothSortedAZ.reverse
  }

  def getVisiblePackagesByPage(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User, isSortDirectionAsc: Boolean, sortBy: PackageSortBy.PackageSortBy, page: Int, count: Int): Seq[ValamisPackage] = {
    getVisiblePackages(companyID, courseID, pageID, filter, playerID, user, isSortDirectionAsc, sortBy)
      .drop((page - 1) * count).take(count) //Previously I put it into RepositoryImpl
  }

  override def getVisiblePackagesAmount(companyID: Long, courseID: Option[Int], pageID: String, filter: String, playerID: String, user: User): Int = {
    val userId = user.getUserId.toInt
    val scormFiltered = packageService.getVisiblePackages(playerID, companyID, courseID.get, pageID)
      .filter(p => passingLimitChecker.checkScormPackage(user, p.id))

    val tincanFiltered = packageService.getVisibleTincanPackages(playerID, companyID, courseID.get, pageID)
      .filter(p => passingLimitChecker.checkTincanPackage(user, p.id))

    val bothFilterd = if (filter.isEmpty) scormFiltered.map(pack => extract(pack, userId)) ++ tincanFiltered.map(extract)
    else scormFiltered.filter(_.title.toLowerCase.contains(filter.toLowerCase)).map(pack => extract(pack, userId)) ++ tincanFiltered.filter(_.title.toLowerCase.contains(filter.toLowerCase)).map(extract)

    bothFilterd.length
  }

  def getByScopeType(courseID: Int, scope: ScopeType, pageID: Option[String], playerID: Option[String], companyID: Long, courseIds: List[Int], userId: Int): Seq[ValamisPackage] = {
    scope match {
      case ScopeType.Page => {
        val pagePackages = packageRepository.getByScope(courseID, scope, pageID.get).map(pack => extract(pack, userId))
        val tincanPackages = tcpackageRepository.getByScope(courseID, scope, pageID.get).map(extract)
        pagePackages ++ tincanPackages
      }
      case ScopeType.Player => {
        val playerPackages = packageRepository.getByScope(courseID, scope, playerID.get).map(pack => extract(pack, userId))
        val tincanPackages = tcpackageRepository.getByScope(courseID, scope, playerID.get).map(extract)
        val personalPackages = packageRepository.getByExactScope(courseIds, scope, playerID.get).map(pack => extract(pack, userId))
        val personalTincanPackages = tcpackageRepository.getByExactScope(courseIds, scope, playerID.get).map(extract)
        playerPackages ++ tincanPackages ++ personalPackages ++ personalTincanPackages
      }
      case ScopeType.Site => {
        val sitePackages = packageRepository.getByCourseID(Option(courseID)).map(pack => extract(pack, userId))
        val tincanPackages = tcpackageRepository.getByCourseID(Option(courseID)).map(extract)
        sitePackages ++ tincanPackages
      }
      case ScopeType.Instance => {
        val courseIds = packageService.getAllCourseIDs(companyID)
        val scormPackages = packageRepository.getAllForInstance(courseIds).map(pack => extract(pack, userId))
        val tincanPackages = tcpackageRepository.getAllForInstance(courseIds).map(extract)
        scormPackages ++ tincanPackages
      }
    }
  }

  private def updatePackageSettings(id: Int, visibility: Boolean, isDefault: Boolean, scope: ScopeType, courseID: Int, pageId: Option[String], playerID: Option[String]) {

    //TODO check places with scope = instanceScope, siteScope, pageScope, playerScope
    scope match {
      case ScopeType.Instance => packageService.setInstanceScopeSettings(id, visibility, isDefault)
      case ScopeType.Site     => packageService.setSiteScopeSettings(id, courseID, visibility, isDefault)
      case ScopeType.Page     => packageService.setPageScopeSettings(id, pageId.get, visibility, isDefault)
      case ScopeType.Player   => packageService.setPlayerScopeSettings(id, playerID.get, visibility, isDefault)
    }
  }
  def updatePackage(passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, scope: ScopeType, packageId: Int, visibility: Boolean, isDefault: Boolean, courseId: Int, title: String, description: String, packageType: PackageType, pageID: Option[String], playerID: Option[String], userId: Int): ValamisPackage = {
    updatePackageSettings(packageId, visibility, isDefault, scope, courseId, pageID, playerID)

    packageType match {
      case PackageType.SCORM => {
        updateScormPackage(passingLimit, rerunInterval, rerunIntervalType, packageId, title, description)
        extract(packageRepository.getByID(packageId).get, userId)
      }
      case PackageType.TINCAN => {
        updateTincanPackage(passingLimit, rerunInterval, rerunIntervalType, packageId, title, description)
        extract(tcpackageRepository.getByID(packageId).get)
      }
    }
  }
  def updatePackageLogo(packageId: Int, packageType: PackageType, packageLogo: Option[String]) {
    packageType match {
      case PackageType.SCORM => {
        updateScormPackageLogo(packageId, packageLogo)
      }
      case PackageType.TINCAN => {
        updateTincanPackageLogo(packageId, packageLogo)
      }
    }
  }

  def uploadPackages(packages: Seq[PackageUploadModel], scope: ScopeType, courseId: Int, pageID: Option[String], playerID: Option[String]) {

    packages.foreach(pack => {

      val packageId = pack.id
      val visibility = true
      val isDefault = false
      val title = pack.title
      val description = pack.description
      val packageType = PackageType.withName(pack.packageType)
      val packageLogo = Option(pack.logo)
      val limit = 0
      val period = PeriodType.UNLIMITED

      updatePackageSettings(packageId, visibility, isDefault, scope, courseId, pageID, playerID)

      packageType match {
        case PackageType.SCORM => {
          updateScormPackage(limit, limit, period, packageId, title, description)
          updateScormPackageLogo(packageId, packageLogo)
        }
        case PackageType.TINCAN => {
          updateTincanPackage(limit, limit, period, packageId, title, description)
          updateTincanPackageLogo(packageId, packageLogo)
        }
      }
    })
  }

  private def updateTincanPackage(passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, packageId: Int, title: String, description: String) {
    tcpackageRepository.setDescriptions(packageId, title, description)
    tcpackageRepository.setLimits(packageId, passingLimit, rerunInterval, rerunIntervalType)
  }
  private def updateTincanPackageLogo(packageId: Int, packageLogo: Option[String]): Unit = {
    tcpackageRepository.setLogo(packageId, packageLogo)
  }

  private def updateScormPackage(passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, packageId: Int, title: String, description: String) {
    packageRepository.setDescriptions(packageId, title, description)
    packageRepository.setLimits(packageId, passingLimit, rerunInterval, rerunIntervalType)
  }
  private def updateScormPackageLogo(packageId: Int, packageLogo: Option[String]): Unit = {
    packageRepository.setLogo(packageId, packageLogo)
  }

  def updatePackageScopeVisibility(id: Int, scope: ScopeType, courseID: Int, visibility: Boolean, isDefault: Boolean, pageID: Option[String], playerID: Option[String], userId: Int): ValamisPackage = {
    updatePackageSettings(id, visibility, isDefault, scope, courseID, pageID, playerID)

    scope match {
      case ScopeType.Site     => extract(packageRepository.getByID(id, courseID, scope, courseID.toString).get, userId)
      case ScopeType.Instance => extract(packageRepository.getByID(id, courseID, scope, "").get, userId)
      case ScopeType.Page     => extract(packageRepository.getByID(id, courseID, scope, pageID.get).get, userId)
      case ScopeType.Player   => extract(packageRepository.getByID(id).get, userId)
    }
  }

  def removePackage(packageId: Int, packageType: PackageType) {
    packageType match {
      case PackageType.SCORM => {
        val pkg = packageRepository.getByID(packageId)
        if (pkg.isDefined) {
          if (pkg.get.assetRefID.isDefined) assetHelper.deletePackage(pkg.get.assetRefID.get)
        }
        packageRepository.delete(packageId)
      }
      case PackageType.TINCAN => {
        tcpackageRepository.delete(packageId)
        tincanManifestActivityStorage.deleteByPackageID(packageId)
        fileStorage.delete("data/" + packageId + "/", asDirectory = true)
      }
    }
  }

  def removePackages(packageIds: Seq[Int]) = {
    packageIds.foreach((id: Int) => {
      //TODO replace that - return packageType from packageService.getPackageType
      val packageType = packageService.getPackageType(id)
      removePackage(id, PackageType.withName(packageType))
    })
  }

  def addPackageToPlayer(playerID: String, packageID: Int) = {
    val isDefault = false
    val visibility = true
    packageService.setPlayerScopeSettings(packageID, playerID, visibility, isDefault)
  }

  def updatePlayerScope(scope: ScopeType, playerID: String) {
    packageService.setPlayerScope(playerID, scope)
  }

}
