package com.arcusys.learn.models.request

import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.models.valamispackage.PackageSortBy
import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import com.arcusys.valamis.model.PeriodTypes
import org.scalatra.ScalatraBase
import scala.util.Try

object PackageRequest extends BaseCollectionFilteredRequest with BaseRequest {
  val PackageId = "id"
  val Title = "title"
  val Description = "description"
  val ImageId = "imageId"
  val LiferayGroupId = "liferayGroupID"
  val Visibility = "visibility"
  val IsDefault = "isDefault"
  val PackageType = "packageType"
  val PackageLogo = "logo"

  val DefaultPackageTitle = "New package"
  val DefaultPackageDescription = ""
  val DefaultInt = "0"
  val DefaultLiferayGroupId = "-1"
  val DefaultCourseId = -1

  val PackageIds = "packageIds"
  val Packages = "packages"
  val PageId = "pageID"
  val PlayerId = "playerID"
  val Scope = "scope"
  val Comment = "comment"

  val PassingLimit = "passingLimit"
  val RerunInterval = "rerunInterval"
  val RerunIntervalType = "rerunIntervalType"

  val TagId = "tagID"
  val Tags = "tags"

  val BeginDate = "beginDate"
  val EndDate = "endDate"
  val CountPackage = "countPackage"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(val scalatra: ScalatraBase) extends BaseSortableCollectionFilteredRequestModel(scalatra, PackageSortBy.apply) with OAuthModel {
    def action = Parameter(Action).required

    def title = Parameter(Title).option

    def description = Parameter(Description).option

    def groupId = Parameter(LiferayGroupId)
      .withDefault(DefaultLiferayGroupId)
      .toLong

    def packageLogo = Parameter(PackageLogo).option

    def imageId = Parameter(ImageId).intRequired //.intOption(DEFAULT_INT)

    def packageId = Parameter(PackageId).longRequired

    def comment = Parameter(Comment).option

    def visibility = Parameter(Visibility).booleanOption("null").getOrElse(false)

    def isDefault = Parameter(IsDefault).booleanRequired

    def packageTypeRequired = Parameter(PackageType).required
    def packageType = Parameter(PackageType).option

    def packageIds = Parameter(PackageIds).multiWithEmpty.map(x => x.toLong)

    def packages = Parameter(Packages).required

    def courseId = Parameter(CourseId).intRequired
    def scope = Parameter(Scope).required
    def pageIdRequired = Parameter(PageId).required
    def pageId = Parameter(PageId).option
    def playerId = Parameter(PlayerId).option
    def playerIdRequired = Parameter(PlayerId).required

    def passingLimit = Parameter(PassingLimit).intRequired

    def rerunInterval = Parameter(RerunInterval).intRequired

    def rerunIntervalType = Try { PeriodTypes(Parameter(RerunIntervalType).required) }.getOrElse(PeriodTypes.UNLIMITED)

    def tagId = Parameter(TagId).longOption
    def tags = Parameter(Tags).multiWithEmpty.filter(!_.isEmpty)
    def beginDate = Parameter(BeginDate).dateTimeOption("")
    def endDate = Parameter(EndDate).dateTimeOption("")
    def companyId = PortalUtilHelper.getCompanyId(scalatra.request)

    def countPackage = Parameter(CountPackage).intRequired
  }

}

