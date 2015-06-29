package com.arcusys.learn.models.request

import com.arcusys.learn.liferay.permission.PermissionUtil
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.models.response.social.Activities
import com.arcusys.learn.service.util.Parameter
import org.json4s.DefaultFormats
import org.json4s.ext.EnumNameSerializer
import org.scalatra.ScalatraServlet

object ActivityRequest extends BaseRequest {
  val CompanyId = "companyId"
  val Content = "content"
  val Comment = "comment"
  val PackageId = "packageId"

  implicit val serializationFormats = DefaultFormats + new EnumNameSerializer(Activities) ++ org.json4s.ext.JodaTimeSerializers.all

  def apply(controller: ScalatraServlet) = new Model(controller)

  class Model(val controller: ScalatraServlet) extends OAuthModel {
    implicit val scalatra = controller

    def action = Parameter(Action).required
    def companyIdServer = PortalUtilHelper.getCompanyId(controller.request)
    def content = Parameter(Content).required
    def comment = Parameter(Comment).option
    def packageId = Parameter(PackageId).longRequired
    def userIdServer = PermissionUtil.getUserId
  }
}
