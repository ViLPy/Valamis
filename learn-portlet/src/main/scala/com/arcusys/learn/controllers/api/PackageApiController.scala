package com.arcusys.learn.controllers.api

import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.facades.PackageFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.models.request.PackageRequest
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.valamispackage.{ PackageSerializer, PackageUploadModel }
import com.arcusys.learn.web.ServletBase
import com.escalatesoft.subcut.inject.BindingModule
import org.json4s.{ Formats, DefaultFormats }

/**
 * Created by igorborisov on 31.05.14.
 */

class PackageApiController(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase {
  def this() = this(Configuration)

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  private val packageFacade = inject[PackageFacadeContract]

  get("/packages(/)") {
    val packageRequest = PackageRequest(this)

    packageRequest.action match {
      case "VISIBLE" => jsonAction {
        val companyID = PortalUtilHelper.getCompanyId(request)
        val courseID = packageRequest.courseID
        val pageID = packageRequest.pageIDRequired
        val playerID = packageRequest.playerIDRequired
        val user = getLiferayUser

        val filter = packageRequest.filter

        val packages = packageFacade.getVisiblePackagesByPage(companyID, courseID, pageID, filter, playerID, user, packageRequest.isSortDirectionAsc, packageRequest.sortBy, packageRequest.page, packageRequest.count)

        val totalAmount = packageFacade.getVisiblePackagesAmount(companyID, courseID, pageID, filter, playerID, user)
        CollectionResponse(
          packageRequest.page,
          packages,
          totalAmount
        )
      }
      case "ALL" => jsonAction {
        val courseID = packageRequest.courseID
        val companyID = PortalUtilHelper.getCompanyId(request)
        val user = getLiferayUser
        val scope = packageRequest.scope

        val filter = packageRequest.filter
        val isSortDirectionAsc = packageRequest.isSortDirectionAsc
        val skip = packageRequest.skip
        val count = packageRequest.count
        val packageType = packageRequest.packageType
        val page = packageRequest.page

        packageFacade.getAllPackages(packageType, courseID, scope, filter, isSortDirectionAsc, skip, count, page, companyID, user)
      }
      case _ => {
        throw new BadRequestException
      }
    }
  }

  get("/packages/getPersonalForPlayer") {
    val packageRequest = PackageRequest(this)
    jsonAction {

      val playerID = packageRequest.playerIDRequired
      val companyID = PortalUtilHelper.getCompanyId(request)
      val groupId = getLiferayUser.getGroupId
      val user = getLiferayUser

      packageFacade.getForPlayer(playerID, companyID, groupId, user)
    }
  }

  get("/packages/getByScope") {
    val packageRequest = PackageRequest(this)
    jsonAction {

      val courseID = packageRequest.courseID.get
      val pageID = packageRequest.pageID
      val playerID = packageRequest.playerID
      val companyID = PortalUtilHelper.getCompanyId(request)
      val user = getLiferayUser

      val scope = packageRequest.scope
      val courseIds = List(getLiferayUser.getGroupId.toInt)

      packageFacade.getByScopeType(courseID, scope, pageID, playerID, companyID, courseIds, user)
    }
  }

  post("/packages(/)")(jsonAction {
    requireTeacherPermissions()

    val packageRequest = PackageRequest(this)

    packageRequest.action match {
      case "UPDATE" => {
        val courseId = packageRequest.courseID.get
        val pageID = packageRequest.pageID
        val playerID = packageRequest.playerID
        val user = getLiferayUser

        val scope = packageRequest.scope
        val packageId = packageRequest.packageId
        val visibility = packageRequest.visibility
        val isDefault = packageRequest.isDefault

        val title = packageRequest.title.get
        val description = packageRequest.description.getOrElse("")
        val packageType = packageRequest.packageType

        val passingLimit = packageRequest.passingLimit
        val rerunInterval = packageRequest.rerunInterval
        val rerunIntervalType = packageRequest.rerunIntervalType

        packageFacade.updatePackage(passingLimit, rerunInterval, rerunIntervalType, scope, packageId, visibility, isDefault, courseId, title, description, packageType, pageID, playerID, user)

      }
      case "UPDATELOGO" => {
        val packageId = packageRequest.packageId
        val packageLogo = packageRequest.packageLogo
        val packageType = packageRequest.packageType
        packageFacade.updatePackageLogo(packageId, packageType, packageLogo)
      }
      case "UPDATEPACKAGES" => {
        implicit val fs: Formats = DefaultFormats + new PackageSerializer
        val packages = parseJson[Seq[PackageUploadModel]](packageRequest.packages).get

        val scope = packageRequest.scope
        val courseId = packageRequest.courseID.get
        val pageID = packageRequest.pageID
        val playerID = packageRequest.playerID

        packageFacade.uploadPackages(packages, scope, courseId, pageID, playerID)
      }
      case "DELETE" => {
        val packageId = packageRequest.packageId
        val packageType = packageRequest.packageType

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
    requireTeacherPermissions()
    val packageRequest = PackageRequest(this)

    val courseID = packageRequest.courseID.get
    val pageID = packageRequest.pageID
    val playerID = packageRequest.playerID
    val user = getLiferayUser
    val scope = packageRequest.scope

    val id = packageRequest.packageId
    val visibility = packageRequest.visibility
    val isDefault = packageRequest.isDefault

    packageFacade.updatePackageScopeVisibility(id, scope, courseID, visibility, isDefault, pageID, playerID, user)
  }

  post("/packages/addPackageToPlayer/:playerID") {
    requireTeacherPermissions()
    val packageRequest = PackageRequest(this)

    val playerID = packageRequest.playerIDRequired
    val packageID = packageRequest.packageId

    packageFacade.addPackageToPlayer(playerID, packageID)
  }

  post("/packages/updatePlayerScope") {
    requireTeacherPermissions()
    val packageRequest = PackageRequest(this)
    val scope = packageRequest.scope
    val playerID = packageRequest.playerIDRequired

    packageFacade.updatePlayerScope(scope, playerID)
  }
}
