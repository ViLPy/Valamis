package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import org.scalatra.ScalatraBase
import com.arcusys.learn.models.request.GradebookActionType._
import java.util.UUID
import com.arcusys.learn.models.request.PackageActionType._
import scala.Some

object PackageRequest extends BaseCollectionFilteredRequest with BaseRequest {
  val PACKAGE_ID = "id"
  val TITLE = "title"
  val DESCRIPTION = "description"
  val IMAGE_ID = "imageId"
  val SCORM_USER_ID = "scormUserID"
  val LIFERAY_GROUP_ID = "liferayGroupID"
  val COURSE_ID = "courseID"
  val SCOPE = "scope"
  val VISIBILITY = "visibility"
  val IS_DEFAULT = "isdefault"
  val PACKAGE_TYPE = "packageType"
  val PACKAGE_LOGO = "logo"

  val DEFAULT_PACKAGE_TITLE = "New package"
  val DEFAULT_PACKAGE_DESCRIPTION = ""
  val DEFAULT_INT = "0"
  val DEFAULT_LIFERAY_GROUP_ID = "-1"
  val DEFAULT_COURSE_ID = -1

  //  val SCOPE_INSTANSE = "instance"
  //  val SCOPE_SITE = "site"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {

    //def action: PackageActionType = PackageActionType.withName(Parameter(ACTION).required.toUpperCase)
    def action = Parameter(ACTION).required // PackageActionType.withName(Parameter(ACTION).required)
    def title = Parameter(TITLE).option

    def description: Option[String] = {
      Parameter(DESCRIPTION).option match {
        case Some(value) => Option(AntiSamyHelper.sanitize(value))
        case None        => None
      }
    }

    def userID = Parameter(SCORM_USER_ID)
      .withDefault(DEFAULT_INT)
      .toLong

    def groupID = Parameter(LIFERAY_GROUP_ID)
      .withDefault(DEFAULT_LIFERAY_GROUP_ID)
      .toLong

    def packageLogo = Parameter(PACKAGE_LOGO).option

    def courseID = Parameter(COURSE_ID).intOption(DEFAULT_COURSE_ID)

    def imageID = Parameter(IMAGE_ID).intRequired //.intOption(DEFAULT_INT)

    def scope = Parameter(SCOPE).required

    def packageId = Parameter(PACKAGE_ID).intRequired

    def visibility = Parameter(VISIBILITY).booleanRequired

    def isDefault = Parameter(IS_DEFAULT).booleanRequired

    def packageType = Parameter(PACKAGE_TYPE).required
  }
}

