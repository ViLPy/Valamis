package com.arcusys.learn.models.request

import com.arcusys.learn.controllers.api.BaseApiController
import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.liferay.permission.{ PortletName, PermissionUtil, ModifyPermission }
import com.arcusys.learn.models.ValidPeriod
import com.arcusys.learn.models.request.CertificateActionType.CertificateActionType
import com.arcusys.learn.service.util.Parameter
import com.arcusys.valamis.certificate.model.{CertificateStatus, CertificateSortBy}
import com.arcusys.valamis.model.PeriodTypes
import org.json4s.ext.EnumNameSerializer
import org.json4s.DefaultFormats
import org.scalatra.ScalatraBase

object CertificateRequest extends BaseCollectionFilteredRequest with BaseRequest {
  val UserId = "userID"
  val UserIds = "userIDs"
  val CompanyId = "companyID"
  val Id = "id"
  val Title = "title"
  val Description = "description"
  val IsPermanent = "isPermanent"
  val PublishBadge = "publishBadge"
  val ShortDescription = "shortDescription"
  val Logo = "logo"
  val RootURL = "rootUrl"
  val ResultAs = "resultAs"
  val CourseGoalId = "courseGoalId"
  val CourseGoalIds = "courseGoalIds"
  val ImageId = "imageId"
  val CertificateValidPeriodType = "validPeriodType"
  val CertificateValidPeriod = "validPeriod"
  val OrgId = "orgId"
  val ActivityId = "activityId"
  val ActivityName = "activity"
  val ActivityCount = "activityCount"
  val ActivityNames = "activityIds"
  val Name = "name"
  val Names = "names"
  val TincanStmntVerb = "tincanStmntVerb"
  val TincanStmntObj = "tincanStmntObj"
  val TincanStmntValue = "tincanStmntValue"
  val TincanStmnts = "tincanStmnts"
  val PackageId = "packageId"
  val PackageIds = "packageIds"
  val CertificatePeriodValue = "periodValue"
  val CertificatePeriodType = "periodType"
  val Scope = "scope"

  val DefaultTitle = "New certificate"
  val DefaultDescription = "Description info"
  val DefaultLogo = ""
  val DefaultCompanyId = 0
  val ShortResultValue = "short"

  val Statuses = "statuses"
  val StatusesExcluded = "statusesExcluded"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  implicit val serializationFormats = DefaultFormats + new EnumNameSerializer(CertificateStatus) ++ org.json4s.ext.JodaTimeSerializers.all

  class Model(val scalatra: ScalatraBase) extends BaseSortableCollectionFilteredRequestModel(scalatra, CertificateSortBy.apply) with OAuthModel {
    implicit val httpRequest = scalatra.request

    def id = Parameter(Id).intRequired
    def title = Parameter(Title).required
    def description = Parameter(Description).required
    def isPermanent = Parameter(IsPermanent).booleanRequired
    def isPublishBadge = Parameter(PublishBadge).booleanOption match {
      case Some(value) => value
      case None        => false
    }
    def shortDescription = Parameter(ShortDescription).required
    def companyId = Parameter(CompanyId).intOption match {
      case Some(value) => value
      case None        => DefaultCompanyId
    }
    def courseId = Parameter(CourseId).intRequired
    def courseGoalId = Parameter(CourseGoalId).intRequired
    def courseGoalIds = Parameter(CourseGoalIds).multiRequired.map(_.toInt)

    def userId = Parameter(UserId).intRequired
    def userIds = Parameter(UserIds).multiWithEmpty.map(_.toInt)
    def imageId = Parameter(ImageId).intRequired
    def action(controller: BaseApiController): CertificateActionType = {
      val action = CertificateActionType(Parameter(Action).required)

      action match {
        case CertificateActionType.Add               => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.AddCourses        => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.AddUsers          => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.AddActivity       => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.AddActivities     => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.AddTincanStmnt    => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.Update            => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.UpdateLogo        => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.UpdateCourse      => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.UpdateActivity    => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.UpdateStmnt       => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.Delete            => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.DeleteCourse      => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.DeleteUsers       => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.DeleteActivity    => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.DeleteActivities  => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.DeleteTincanStmnt => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.Clone             => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.Publish           => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case CertificateActionType.Unpublish         => PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.CertificateManager)
        case _                                       => Unit
      }

      return action
    }
    def logo = Parameter(Logo).option match {
      case Some(value) => value
      case None        => DefaultLogo
    }
    def orgId = Parameter(OrgId).intRequired
    def activityId = Parameter(ActivityId).required
    def activityName = Parameter(ActivityName).required
    def activityCount = Parameter(ActivityCount).intRequired
    def activity = {
      val activityName = Parameter(ActivityId).required
      val activityCount = Parameter(ActivityCount).intRequired
      val value = Parameter(CertificatePeriodValue).intRequired
      val periodType = PeriodTypes(Parameter(CertificatePeriodType).option)

      (activityName, activityCount, value, periodType)
    }
    def activityNames = Parameter(ActivityNames).multiWithEmpty

    def name = Parameter(Name).required
    def names = Parameter(Names).multiWithEmpty

    def course = {
      val courseGoalId = Parameter(CourseGoalId).intRequired
      val value = Parameter(CertificatePeriodValue).intRequired
      val periodType = PeriodTypes(Parameter(CertificatePeriodType).option)

      (courseGoalId, value, periodType)
    }

    def packageId = Parameter(PackageId).longRequired
    def packageIds = Parameter(PackageIds).multiRequired.map(_.toInt)
    def periodValue = Parameter(CertificatePeriodValue).intOption.getOrElse(0)
    def periodType = PeriodTypes(Parameter(CertificatePeriodType).option)

    def tincanStatements = Parameter(TincanStmnts).required

    def tincanStatement = {
      val verbs = Parameter(TincanStmntVerb).required
      val objs = Parameter(TincanStmntObj).required
      val value = Parameter(CertificatePeriodValue).intOption
      val periodType = PeriodTypes(Parameter(CertificatePeriodType).option)

      (verbs, objs, value.getOrElse(0), periodType)
    }

    def isShortResult = Parameter(ResultAs).option match {
      case Some(value) => value == "short"
      case None        => false
    }

    def validPeriod: ValidPeriod = {
      val validPeriod = Parameter(CertificateValidPeriod).intOption
      ValidPeriod(validPeriod, Parameter(CertificateValidPeriodType).required)
    }

    def scope: Option[Long] = Parameter(Scope).longOption

    def rootUrl = if (Parameter(RootURL).required.contains("http://"))
      Parameter(RootURL).required
    else
      "http://" + Parameter(RootURL).required

    def userIdOpt = Parameter(UserId).longOption
    def userIdServer = PermissionUtil.getUserId

    def statuses = {
      val included = Parameter(Statuses).multiWithEmpty
      val excluded = Parameter(StatusesExcluded).multiWithEmpty
      if(included.nonEmpty && excluded.nonEmpty) throw new BadRequestException("Either statuses or statusesExcluded should be provided, not both")

      if(included.nonEmpty) included.map(CertificateStatus.parse).toSet
      else if(excluded.nonEmpty) excluded.map(CertificateStatus.parse).foldLeft(CertificateStatus.all){ case (acc, status) => acc - status }
      else CertificateStatus.all
    }
  }
}
