package com.arcusys.learn.controllers.api

import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.facades.{ PackageFacadeContract, TagFacadeContract }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.{ PortletName, ModifyPermission, ViewPermission, PermissionUtil }
import com.arcusys.learn.liferay.services.PermissionHelper
import com.arcusys.learn.models.request.PackageRequest
import com.arcusys.learn.models.valamispackage.{ PackageSerializer, PackageUploadModel }
import com.arcusys.learn.web.ServletBase
import com.arcusys.valamis.lesson.service.ValamisPackageService
import com.arcusys.valamis.lrs.serializer.DateTimeSerializer
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.escalatesoft.subcut.inject.BindingModule
import org.json4s.{ DefaultFormats, Formats }
import PermissionUtil._

class PackageApiController(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase {
  private val packageFacade = inject[PackageFacadeContract]
  private val lrsReader = inject[LrsClientManager]
  private val packageService = inject[ValamisPackageService]


  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  options() {
    response.setHeader("Access-Control-Allow-Methods", "HEAD,GET,POST,PUT,DELETE")
    response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length,Authorization,If-Match,If-None-Match,X-Experience-API-Version,X-Experience-API-Consistent-Through")
    response.setHeader("Access-Control-Expose-Headers", "ETag,Last-Modified,Cache-Control,Content-Type,Content-Length,WWW-Authenticate,X-Experience-API-Version,X-Experience-API-Consistent-Through")
  }
  private val tagFacade = inject[TagFacadeContract]

  def this() = this(Configuration)

  get("/packages(/)") {
    val packageRequest = PackageRequest(this)

    packageRequest.action match {
      case "VISIBLE" => jsonAction {

        PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LessonViewer)

        val companyId = packageRequest.companyId
        val courseId = packageRequest.courseId
        val pageId = packageRequest.pageIdRequired
        val playerId = packageRequest.playerIdRequired
        val user = getLiferayUser
        val tagId = packageRequest.tagId

        val filter = packageRequest.filter
        lrsReader.statementApi(
          packageFacade.getForPlayer(_, companyId, courseId, pageId, filter, tagId, playerId, user,
            packageRequest.isSortDirectionAsc, packageRequest.sortBy, packageRequest.page, packageRequest.count),
          packageRequest.lrsAuth)
      }
      case "ALL" => jsonAction {

        PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LessonViewer, PortletName.LessonManager)

        val courseId = packageRequest.courseId
        val companyId = packageRequest.companyId
        val user = getLiferayUser
        val scope = packageRequest.scope

        val filter = packageRequest.filter
        val tagId = packageRequest.tagId
        val isSortDirectionAsc = packageRequest.isSortDirectionAsc
        val skip = packageRequest.skip
        val count = packageRequest.count
        val packageType = packageRequest.packageType
        val page = packageRequest.page

        packageFacade.getAllPackages(packageType, Some(courseId), scope, filter, tagId, isSortDirectionAsc, skip, count, page, companyId, user)
      }
      case _ => {
        throw new BadRequestException
      }
    }
  }

  get("/packages/getPersonalForPlayer") {
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LessonViewer)
    val packageRequest = PackageRequest(this)
    jsonAction {

      val playerId = packageRequest.playerIdRequired
      val companyId = packageRequest.companyId
      val groupId = getLiferayUser.getGroupId
      val user = getLiferayUser

      packageFacade.getForPlayerConfig(playerId, companyId, groupId, user)
    }
  }

  get("/packages/getByScope") {
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LessonManager, PortletName.LessonViewer)
    val packageRequest = PackageRequest(this)
    jsonAction {

      val courseId = packageRequest.courseId
      val pageId = packageRequest.pageId
      val playerId = packageRequest.playerId
      val companyId = packageRequest.companyId
      val user = getLiferayUser

      val scope = packageRequest.scope
      val courseIds = List(getLiferayUser.getGroupId.toInt)

      packageFacade.getByScopeType(courseId, scope, pageId, playerId, companyId, courseIds, user)
    }
  }

  get("/packages/getLastOpen") {
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.RecentLessons)
    val packageRequest = PackageRequest(this)
    implicit val formats: Formats = DefaultFormats + DateTimeSerializer
    jsonAction {
      lrsReader.statementApi(statementApi => {

        packageService.getLastPaskages( getUserId, statementApi,  packageRequest.countPackage, getCompanyId)

      }, packageRequest.lrsAuth)
    }
  }

  post("/packages(/)")(jsonAction {
    PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.LessonManager)
    val packageRequest = PackageRequest(this)
    packageRequest.action match {
      case "UPDATE" => {
        val packageId = packageRequest.packageId

        val courseId = packageRequest.courseId
        val companyId = packageRequest.companyId
        val pageId = packageRequest.pageId
        val playerId = packageRequest.playerId
        val user = getLiferayUser

        val scope = packageRequest.scope

        val visibility = packageRequest.visibility
        val isDefault = packageRequest.isDefault
        val title = packageRequest.title.get
        val description = packageRequest.description.getOrElse("")
        val packageType = packageRequest.packageTypeRequired

        val passingLimit = packageRequest.passingLimit
        val rerunInterval = packageRequest.rerunInterval
        val rerunIntervalType = packageRequest.rerunIntervalType

        val tags = packageRequest.tags

        val beginDate = packageRequest.beginDate
        val endDate = packageRequest.endDate

        packageFacade.updatePackage(packageId, tags, passingLimit, rerunInterval, rerunIntervalType, beginDate, endDate, scope, visibility, isDefault, companyId, courseId, title, description, packageType, pageId, playerId, user)

      }
      case "UPDATELOGO" => {
        val packageId = packageRequest.packageId
        val packageLogo = packageRequest.packageLogo
        val packageType = packageRequest.packageTypeRequired

        packageFacade.updatePackageLogo(packageId, packageType, packageLogo)
      }
      case "UPDATEPACKAGES" => {
        implicit val fs: Formats = DefaultFormats + new PackageSerializer
        val packages = parseJson[Seq[PackageUploadModel]](packageRequest.packages).get

        val scope = packageRequest.scope
        val courseId = packageRequest.courseId
        val pageId = packageRequest.pageId
        val playerId = packageRequest.playerId

        packageFacade.uploadPackages(packages, scope, courseId, pageId, playerId)
      }
      case "DELETE" => {
        val packageId = packageRequest.packageId
        val packageType = packageRequest.packageTypeRequired

        packageFacade.removePackage(packageId, packageType)
      }
      case "REMOVEPACKAGES" => {
        val packageIds = packageRequest.packageIds

        packageFacade.removePackages(packageIds)
      }
      case _ => {
        throw new BadRequestException
      }
    }
  })

  post("/packages/updatePackageScopeVisibility/:id") {
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LessonViewer)
    val packageRequest = PackageRequest(this)

    val courseId = packageRequest.courseId
    val pageId = packageRequest.pageId
    val playerId = packageRequest.playerId
    val user = getLiferayUser
    val scope = packageRequest.scope

    val id = packageRequest.packageId
    val visibility = packageRequest.visibility
    val isDefault = packageRequest.isDefault

    packageFacade.updatePackageScopeVisibility(id, scope, courseId, visibility, isDefault, pageId, playerId, user)
  }

  post("/packages/addPackageToPlayer/:playerID") {
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LessonViewer)
    val packageRequest = PackageRequest(this)

    val playerId = packageRequest.playerIdRequired
    val packageId = packageRequest.packageId

    packageFacade.addPackageToPlayer(playerId, packageId)
  }

  post("/packages/updatePlayerScope") {
    PermissionUtil.requirePermissionApi(ViewPermission, PortletName.LessonViewer)
    val packageRequest = PackageRequest(this)
    val scope = packageRequest.scope
    val playerId = packageRequest.playerIdRequired

    packageFacade.updatePlayerScope(scope, playerId)
  }
}
