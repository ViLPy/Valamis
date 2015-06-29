package com.arcusys.valamis.lesson.service

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.learn.liferay.services.{SocialActivityLocalServiceHelper, UserLocalServiceHelper}
import com.arcusys.valamis.exception.EntityNotFoundException
import com.arcusys.valamis.file.storage.FileStorage
import com.arcusys.valamis.lesson.exception.PassingLimitExceededException
import com.arcusys.valamis.lesson.model.LessonType
import com.arcusys.valamis.lesson.model.LessonType._
import com.arcusys.valamis.lesson.scorm.model.ScormPackage
import com.arcusys.valamis.lesson.model._
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import com.arcusys.valamis.lesson.scorm.storage.tracking.{ActivityStateTreeStorage, AttemptStorage}
import com.arcusys.valamis.lesson.storage.{LessonLimitStorage, PackageScopeRuleStorage, PlayerScopeRuleStorage}
import com.arcusys.valamis.lesson.tincan.model.{TincanPackage, ManifestActivity}
import com.arcusys.valamis.lesson.tincan.storage.{PackageCategoryGoalStorage, TincanManifestActivityStorage, TincanPackageStorage}
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.model.StatementFilter
import com.arcusys.valamis.lrs.tincan.Statement
import com.arcusys.valamis.lrs.util.StatementApiHelpers._
import com.arcusys.valamis.lrs.util.{TinCanVerbs, TinCanActivityType, TincanHelper}
import com.arcusys.valamis.model.PeriodTypes._
import com.arcusys.valamis.model.ScopeType.ScopeType
import com.arcusys.valamis.model.{PeriodTypes, ScopeType}
import com.arcusys.valamis.uri.model.ValamisURIType
import com.arcusys.valamis.uri.service.URIServiceContract
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime
import com.arcusys.valamis.util.Joda._

// TODO refactor, split on parts, tincan statement part, scores, impoport/export ...
class ValamisPackageServiceImpl(implicit val bindingModule: BindingModule) extends ValamisPackageService with Injectable with PackageSelect {

  val packageRepository = inject[ScormPackagesStorage]
  val tcpackageRepository = inject[TincanPackageStorage]
  val tincanManifestActivityStorage = inject[TincanManifestActivityStorage]
  val uriService = inject[URIServiceContract]
  val attemptStorage = inject[AttemptStorage]
  val activityStateTreeStorage = inject[ActivityStateTreeStorage]
  val passingLimitChecker = inject[LessonLimitChecker]
  val fileStorage = inject[FileStorage]
  val tagService = inject[TagServiceContract]
  val packageScopeRuleStorage = inject[PackageScopeRuleStorage]
  val playerScopeRuleRepository = inject[PlayerScopeRuleStorage]
  val lessonLimitStorage = inject[LessonLimitStorage]
  val packageGoalStorage = inject[PackageCategoryGoalStorage]

  private val assetHelper = new AssetHelper()
  protected val packageService = new PackageService()

  def getPackageType(packageId: Long): LessonType = {
    val packageService = new PackageService
    packageService.getPackageType(packageId)
  }

  def getManifestActivities(packageId: Long): Seq[ManifestActivity] = tincanManifestActivityStorage.getByPackageId(packageId)

  def getRootManifestActivities(packageId: Long): Seq[ManifestActivity] = getManifestActivities(packageId).filter(act => act.activityType.equalsIgnoreCase(TinCanActivityType.getURI(TinCanActivityType.course)))

  def getRootActivityIds(packageId: Long): Seq[String] = {
    getPackageType(packageId) match {
      case LessonType.Scorm =>
        Seq(uriService.getById(packageId.toString, ValamisURIType.Package).map(_.uri).getOrElse(packageId.toString))
      case LessonType.Tincan =>
        val oldPackageUri = uriService.getById(packageId.toString, ValamisURIType.Package).map(_.uri)
        getRootManifestActivities(packageId)
          .map(_.tincanId) ++ oldPackageUri.toSeq
    }
  }

  def getPackagesCount(courseId: Int): Int = getPackagesByCourse(courseId).length

  def getPackagesByCourse(courseId: Int): Seq[BaseManifest] = packageRepository.getByCourseId(Some(courseId)) ++ tcpackageRepository.getByCourseId(Some(courseId))

  def getTincanPackagesByCourse(courseId: Int, onlyVisible: Boolean): Seq[BaseManifest] = tcpackageRepository.getByCourseId(Some(courseId), onlyVisible)

  def getPackage(packageId: Long): BaseManifest =
    tcpackageRepository.getById(packageId).map(toTincanManifest).getOrElse(
      packageRepository.getById(packageId).map(toScormManifest).getOrElse(
        throw new EntityNotFoundException("Package not found"))
    )

  def getStatements(packageId: Long, valamisUserId: Int, statementApi: StatementApi): Seq[Statement] = {
    val activityIds = getRootActivityIds(packageId)
    activityIds.flatMap(actId => {
      val filter = StatementFilter(
        agent = Option(TincanHelper.getAgentByEmail(getEmail(valamisUserId))),
        activity = Option(actId),
        relatedActivities = Option(true)
      )
      statementApi.getByFilter(filter)
    })
  }

  def getLastStatement(packageId: Long, valamisUserId: Long, statementApi: StatementApi, verbs: String, count: Int): Seq[Statement] = {
  val activityIds = getRootActivityIds(packageId)
    activityIds.flatMap(actId => {
      val filter = StatementFilter(
        agent = Option(TincanHelper.getAgentByEmail(getEmail(valamisUserId))),
        activity = Option(actId),
        relatedActivities = Option(true) ,
        verb=Option(verbs),
        limit = Option(count)
      )
      statementApi.getByFilter(filter)

    })
  }


 def getLastPaskages(valamisUserId: Long, statementApi: StatementApi, count:Int, companyId:Long): Seq[RecentLesson] = {
    var recentLesson = Seq[RecentLesson]()
      getAllPackages(None, None, ScopeType.Instance, "", None, true, 0, 0, 0, companyId, valamisUserId).items.foreach(s=> {
      val course = GroupLocalServiceHelper.getGroup(s.courseId.get.toLong)
      getLastStatement(s.id, valamisUserId, statementApi, TinCanVerbs.getVerbURI(TinCanVerbs.Attempted), 1).map(st => {
        recentLesson = recentLesson :+ RecentLesson(s.title, st.timestamp.get, course.getDescriptiveName, course.getFriendlyURL)
      })
    })
    recentLesson.sortBy(_.throughDate).reverse.take(count)
  }

  private def getEmail(valamisUserId: Long) =
    UserLocalServiceHelper().getUser(valamisUserId).getEmailAddress

  private def updatePackageSettings(id: Long, visibility: Boolean, isDefault: Boolean, scope: ScopeType, courseId: Int, pageId: Option[String], playerId: Option[String]): PackageScopeRule = {

    //TODO check places with scope = instanceScope, siteScope, pageScope, playerScope
    scope match {
      case ScopeType.Instance => packageService.setInstanceScopeSettings(id, visibility, isDefault)
      case ScopeType.Site     => packageService.setSiteScopeSettings(id, courseId, visibility, isDefault)
      case ScopeType.Page     => packageService.setPageScopeSettings(id, pageId.get, visibility, isDefault)
      case ScopeType.Player   => packageService.setPlayerScopeSettings(id, playerId.get, visibility, isDefault)
    }
  }

  def updatePackage(tags: Seq[Long], passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, beginDate: Option[DateTime], endDate: Option[DateTime], scope: ScopeType, packageId: Long, visibility: Boolean, isDefault: Boolean, courseId: Int, title: String, description: String, packageType: LessonType, pageId: Option[String], playerId: Option[String], userId: Int): BaseManifest = {
    val scopeSettings = updatePackageSettings(packageId, visibility, isDefault, scope, courseId, pageId, playerId)

    packageType match {
      case LessonType.Scorm =>
        val (scormPackage, lessonLimit) = updateScormPackage(passingLimit, rerunInterval, rerunIntervalType, packageId, title, description, beginDate, endDate)

        val assetRefId = scormPackage.assetRefId.getOrElse(
          new AssetHelper().addScormPackageAssetEntry(userId, courseId, scormPackage.id, scormPackage.title, scormPackage.summary)
        )
        tagService.assignTags(assetRefId, tags)
        toScormManifest(scormPackage.copy(assetRefId = Some(assetRefId)), Some(scopeSettings), lessonLimit)
      case LessonType.Tincan =>
        val (tincanPackage, lessonLimit) = updateTincanPackage(passingLimit, rerunInterval, rerunIntervalType, packageId, title, description, beginDate, endDate)

        val assetRefId = tincanPackage.assetRefId.getOrElse(
          new AssetHelper().addTincanPackageAssetEntry(userId, courseId, tincanPackage.id, tincanPackage.title, tincanPackage.summary)
        )
        tagService.assignTags(assetRefId, tags)
        toTincanManifest(tincanPackage.copy(assetRefId = Some(assetRefId)), Some(scopeSettings), lessonLimit)
    }
  }

  def updatePackageLogo(packageId: Long, packageType: LessonType, packageLogo: Option[String]) {
    packageType match {
      case LessonType.Scorm =>
        updateScormPackageLogo(packageId, packageLogo)
      case LessonType.Tincan =>
        updateTincanPackageLogo(packageId, packageLogo)
    }
  }

  def uploadPackages(packages: Seq[PackageUploadModel], scope: ScopeType, courseId: Int, pageId: Option[String], playerId: Option[String]) {

    packages.foreach(pack => {

      val packageId = pack.id
      val visibility = true
      val isDefault = false
      val title = pack.title
      val description = pack.description
      val packageType = pack.packageType match {
        case "scorm"  => LessonType.Scorm
        case "tincan" => LessonType.Tincan
      }
      val packageLogo = Option(pack.logo)
      val limit = 0
      val rerunInterval = 0
      val period = PeriodTypes.UNLIMITED

      updatePackageSettings(packageId, visibility, isDefault, scope, courseId, pageId, playerId)

      packageType match {
        case LessonType.Scorm =>
          updateScormPackage(limit, rerunInterval, period, packageId, title, description, None, None)
          updateScormPackageLogo(packageId, packageLogo)
        case LessonType.Tincan =>
          updateTincanPackage(limit, rerunInterval, period, packageId, title, description, None, None)
          updateTincanPackageLogo(packageId, packageLogo)
      }
    })
  }

  private def updateTincanPackage(passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, packageId: Long, title: String, description: String, beginDate: Option[DateTime], endDate: Option[DateTime]) = {
    val tincanPackage = tcpackageRepository.modify(packageId, title, description, beginDate, endDate)
    val lessonLimit = lessonLimitStorage.setLimit(packageId, LessonType.Tincan, passingLimit, rerunInterval, rerunIntervalType)
    (tincanPackage, lessonLimit)
  }

  private def updateTincanPackageLogo(packageId: Long, packageLogo: Option[String]): Unit = {
    tcpackageRepository.setLogo(packageId, packageLogo)
  }

  private def updateScormPackage(passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType, packageId: Long, title: String, description: String, beginDate: Option[DateTime], endDate: Option[DateTime]) = {
    val scormPackage = packageRepository.modify(packageId, title, description, beginDate, endDate)
    val lessonLimit = lessonLimitStorage.setLimit(packageId, LessonType.Scorm, passingLimit, rerunInterval, rerunIntervalType)

    (scormPackage, lessonLimit)
  }

  private def updateScormPackageLogo(packageId: Long, packageLogo: Option[String]): Unit = {
    packageRepository.setLogo(packageId, packageLogo)
  }

  def updatePackageScopeVisibility(id: Long, scope: ScopeType, courseId: Int, visibility: Boolean, isDefault: Boolean, pageId: Option[String], playerId: Option[String], userId: Int) {
    updatePackageSettings(id, visibility, isDefault, scope, courseId, pageId, playerId)
  }

  def removePackage(packageId: Long, packageType: LessonType) {
    packageType match {
      case LessonType.Scorm =>
        val pkg = packageRepository.getById(packageId)
        if (pkg.isDefined && pkg.get.assetRefId.isDefined) {
          assetHelper.deletePackageAssetEntry(pkg.get.assetRefId.get, pkg.map(toScormManifest).get)
        }
        packageRepository.delete(packageId)
        fileStorage.delete("data/" + packageId + "/", asDirectory = true)
        SocialActivityLocalServiceHelper.deleteActivities(classOf[ScormPackage].getName, packageId)
      case LessonType.Tincan =>
        val pkg = tcpackageRepository.getById(packageId).map(toTincanManifest)
        if (pkg.isDefined && pkg.get.assetRefId.isDefined) {
          assetHelper.deletePackageAssetEntry(pkg.get.assetRefId.get, pkg.get)
        }
        tcpackageRepository.delete(packageId)
        tincanManifestActivityStorage.deleteByPackageId(packageId)
        fileStorage.delete("data/" + packageId + "/", asDirectory = true)
        SocialActivityLocalServiceHelper.deleteActivities(classOf[TincanPackage].getName, packageId)
    }

    packageGoalStorage.delete(packageId)
  }

  def removePackages(packageIds: Seq[Long]) = {
    packageIds.foreach(id => {
      //TODO replace that - return packageType from packageService.getPackageType
      val packageType = packageService.getPackageType(id)
      removePackage(id, packageType)
    })
  }

  def addPackageToPlayer(playerId: String, packageId: Long) = {
    val isDefault = false
    val visibility = true
    packageService.setPlayerScopeSettings(packageId, playerId, visibility, isDefault)
  }

  def updatePlayerScope(scope: ScopeType, playerId: String) {
    packageService.setPlayerScope(playerId, scope)
  }

  override def getScormManifest(packageId: Int) = {
    packageRepository.getById(packageId).map(toScormManifest).get
  }

  override def getTincanLaunchWithLimitTest(packageId: Int, user: LUser, statementApi: StatementApi): String = {

    val tincanPackage = tcpackageRepository.getById(packageId)
    if (!tincanPackage.isDefined)
      throw new UnsupportedOperationException()

    if (!passingLimitChecker.checkTincanPackage(user, packageId, statementApi))
      throw new PassingLimitExceededException

    val activities = tincanManifestActivityStorage.getByPackageId(packageId)
    val firstActivity = activities.find(a => a.launch != null && !a.launch.isEmpty).getOrElse(throw new UnsupportedOperationException("tincan package without launch not supported"))

    val mainFileName = "data/" + tincanPackage.get.id + "/" + firstActivity.launch.get
    mainFileName
  }
}
