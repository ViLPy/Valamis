package com.arcusys.learn.models.request

import com.arcusys.learn.models.valamispackage.PackageSortBy
import com.arcusys.learn.scorm.manifest.model.PeriodType
import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import org.scalatra.ScalatraBase
import scala.util.Try

object PackageRequest extends BaseCollectionFilteredRequest with BaseRequest {
  val PACKAGE_ID = "id"
  val TITLE = "title"
  val DESCRIPTION = "description"
  val IMAGE_ID = "imageId"
  val LIFERAY_GROUP_ID = "liferayGroupID"
  val VISIBILITY = "visibility"
  val IS_DEFAULT = "isdefault"
  val PACKAGE_TYPE = "packageType"
  val PACKAGE_LOGO = "logo"

  val DEFAULT_PACKAGE_TITLE = "New package"
  val DEFAULT_PACKAGE_DESCRIPTION = ""
  val DEFAULT_INT = "0"
  val DEFAULT_LIFERAY_GROUP_ID = "-1"
  val DEFAULT_COURSE_ID = -1

  val PACKAGE_IDS = "packageIds"
  val PACKAGES = "packages"
  val PAGE_ID = "pageID"
  val PLAYER_ID = "playerID"
  val COURSE_ID = "courseID"
  val SCOPE = "scope"

  val PASSING_LIMIT = "passingLimit"
  val RERUN_INTERVAL = "rerunInterval"
  val RERUN_INTERVAL_TYPE = "rerunIntervalType"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseSortableCollectionFilteredRequestModel(scalatra, PackageSortBy.apply) {

    def action = Parameter(ACTION).required

    def title = Parameter(TITLE).option

    def description: Option[String] = {
      Parameter(DESCRIPTION).option match {
        case Some(value) => Option(AntiSamyHelper.sanitize(value))
        case None        => None
      }
    }

    def groupID = Parameter(LIFERAY_GROUP_ID)
      .withDefault(DEFAULT_LIFERAY_GROUP_ID)
      .toLong

    def packageLogo = Parameter(PACKAGE_LOGO).option

    def imageID = Parameter(IMAGE_ID).intRequired //.intOption(DEFAULT_INT)

    def packageId = Parameter(PACKAGE_ID).intRequired

    def visibility = Parameter(VISIBILITY).booleanOption("null").getOrElse(false)

    def isDefault = Parameter(IS_DEFAULT).booleanRequired

    def packageType = Parameter(PACKAGE_TYPE).required

    def packageIds = Parameter(PACKAGE_IDS).multiWithEmpty.map(x => x.toInt).toSeq

    def packages = Parameter(PACKAGES).required

    def courseIDRequired = Parameter(COURSE_ID).intRequired
    def courseID = Parameter(COURSE_ID).intOption(DEFAULT_COURSE_ID)
    def scope = Parameter(SCOPE).required
    def pageIDRequired = Parameter(PAGE_ID).required
    def pageID = Parameter(PAGE_ID).option
    def playerID = Parameter(PLAYER_ID).option
    def playerIDRequired = Parameter(PLAYER_ID).required

    def passingLimit = Parameter(PASSING_LIMIT).intRequired

    def rerunInterval = Parameter(RERUN_INTERVAL).intRequired

    def rerunIntervalType = Try { PeriodType(Parameter(RERUN_INTERVAL_TYPE).required) }.getOrElse(PeriodType.UNLIMITED)
  }

}

