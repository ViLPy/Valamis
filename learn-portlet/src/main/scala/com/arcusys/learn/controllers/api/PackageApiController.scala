package com.arcusys.learn.controllers.api

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ PackageRequest, PackageActionType }
import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.scorm.manifest.model.Manifest
import com.arcusys.learn.tincan
import com.arcusys.scorm.lms.PackageService

/**
 * Created by igorborisov on 31.05.14.
 */
class PackageApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  case class PackageInfo(id: Int, title: String, description: Option[String],
    version: Option[String], isVisible: Boolean,
    isDefault: Boolean, packageType: String, logo: Option[String])

  def serialize(manifest: Manifest) = PackageInfo(manifest.id,
    manifest.title,
    manifest.summary.map(_.replaceAll("\n", "")),
    manifest.version,
    manifest.visibility.getOrElse(false),
    manifest.isDefault,
    "scorm",
    manifest.logo)

  def serialize(manifest: tincan.manifest.model.Manifest) = PackageInfo(manifest.id,
    manifest.title,
    manifest.summary.map(_.replaceAll("\n", "")),
    Some(""),
    manifest.visibility.getOrElse(false),
    manifest.isDefault,
    "tincan",
    manifest.logo)

  import storageFactory._

  private val packageService = new PackageService()

  get("/")(jsonAction {
    requireTeacherPermissions()

    val packageRequest = PackageRequest(this)

    packageRequest.action match {
      case "ALL" => {
        val courseID = packageRequest.courseID

        val packages = packageRequest.scope match {
          case "instance" => {
            val companyID = PortalUtilHelper.getCompanyId(request)
            val courseIds = packageService.getAllCourseIDs(companyID)
            val scormPackages = packageStorage.getAllForInstance(courseIds).map(serialize)
            val tincanPackages = tincanPackageStorage.getAllForInstance(courseIds).map(serialize)
            scormPackages ++ tincanPackages
          }
          case "site" => {
            packageStorage.getByCourseID(courseID).map(serialize) ++ tincanPackageStorage.getByCourseID(courseID).map(serialize)
          }
        }

        val filtered = if (!packageRequest.filter.isEmpty) packages.filter(_.title.toLowerCase.contains(packageRequest.filter.toLowerCase))
        else packages

        val orderedPackages = if (packageRequest.isSortDirectionAsc) filtered.sortBy(_.title)
        else filtered.sortBy(_.title).reverse

        val total = orderedPackages.length
        val pagedPackages = orderedPackages.drop(packageRequest.skip).take(packageRequest.count)

        CollectionResponse(
          packageRequest.page,
          pagedPackages,
          total
        )
      }
      case _ => {
        // println("BadRequestException")
        throw new BadRequestException
      }
    }
  })

  post("/")(jsonAction {
    requireTeacherPermissions()

    val packageRequest = PackageRequest(this)

    packageRequest.action match {
      case "UPDATE" => {
        val scope = packageRequest.scope
        val packageId = packageRequest.packageId
        val visibility = packageRequest.visibility
        val isDefault = packageRequest.isDefault
        val courseId = packageRequest.courseID.get
        val title = packageRequest.title.get
        val description = packageRequest.description.getOrElse("")
        val packageType = packageRequest.packageType
        val packageLogo = packageRequest.packageLogo

        updatePackageSettings(packageId, visibility, isDefault, scope, courseId)

        packageType match {
          case "scorm" => {
            packageStorage.setDescriptions(packageId, title, description)
            packageStorage.setLogo(packageId, packageLogo)
            serialize(packageStorage.getByID(packageId).get)
          }
          case "tincan" => {
            tincanPackageStorage.setDescriptions(packageId, title, description)
            tincanPackageStorage.setLogo(packageId, packageLogo)
            serialize(tincanPackageStorage.getByID(packageId).get)
          }
        }

      }
      case "DELETE" => {
        val scope = packageRequest.scope
        val packageId = packageRequest.packageId
        val packageType = packageRequest.packageType

        packageType match {
          case "scorm" => {
            packageStorage.delete(packageId)
            "ok"
          }
          case "tincan" => {
            tincanPackageStorage.delete(packageId)
            "ok"
          }
        }

      }
      case _ => {
        throw new BadRequestException
      }
    }
  })

  private def updatePackageSettings(id: Int, visibility: Boolean, isDefault: Boolean, scope: String, courseID: Int) {
    scope match {
      case "instance" => {
        packageService.setInstanceScopeSettings(id, visibility, isDefault)
      }
      case "site" => {
        packageService.setSiteScopeSettings(id, courseID, visibility, isDefault)
      }
      case "page" => {
        packageService.setPageScopeSettings(id, parameter("pageID").required, visibility, isDefault)
      }
      case "player" => {
        packageService.setPlayerScopeSettings(id, parameter("playerID").required, visibility, isDefault)
      }
    }
  }
}
