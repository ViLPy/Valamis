package com.arcusys.learn.view

import javax.portlet._

import com.arcusys.learn.facades.PackageFacadeContract
import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.arcusys.learn.liferay.permission.{PermissionUtil, ViewAllPermission}
import com.arcusys.learn.liferay.util.EncryptorUtilHelper
import com.arcusys.learn.view.extensions._
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.valamis.lrs.serializer.AgentSerializer
import com.arcusys.valamis.lrs.tincan.Agent
import com.arcusys.valamis.lrs.util.TincanHelper
import com.arcusys.valamis.util.serialization.JsonHelper

class GradebookView extends OAuthPortlet with BaseView {

  lazy val packageFacade = inject[PackageFacadeContract]

  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {

    val scope = getSecurityData(request)

    val lang = LiferayHelpers.getLanguage(request)

    val user = LiferayHelpers.getUser(request)

    // for poller auth we encrypt company key + userID
    val encryptedUserId = EncryptorUtilHelper.encrypt(scope.company.getKeyObj, "" + scope.userId)

    response.getWriter.println(generateResponse(request, response, user, encryptedUserId,
      lang,
      isAdmin = PermissionUtil.hasPermission(scope.courseId, scope.portletId, scope.primaryKey, ViewAllPermission),
      scope)
    )
  }

  def generateResponse(request: RenderRequest, response: RenderResponse, user: LUser, encryptUserID: String, language: String, isAdmin: Boolean, scope: SecurityData) = {

    val translations = getTranslation("gradebook", language)
    val packages = packageFacade.getPackagesByCourse(scope.courseId.toInt)

    def StringToNone(str: String): Option[String] = {
      if (str == null || str.isEmpty)
        None
      else
        Some(str)
    }

    val tincanActor = if (user != null)
      JsonHelper.toJson(TincanHelper.getAgent(user.getFullName, user.getEmailAddress), new AgentSerializer)
    else
      JsonHelper.toJson(Agent(name = StringToNone("Anonymous"), mBox = StringToNone("mailto:anonymous@liferay.com")), new AgentSerializer)

      val endpoint = JsonHelper.toJson(getEndpointInfo(request))

      val data = Map(
        "encryptUserID" -> encryptUserID,
        "isAdmin" -> isAdmin,
        "packages" -> packages,
        "language" -> language,
        "tincanActor" -> tincanActor,
        "permissionToViewAll" -> isAdmin
      ) ++ translations ++ scope.data ++
        Map("endpointData" -> endpoint)

      getTemplate("/templates/2.0/gradebook_templates.html") +
        getTemplate("templates/2.0/paginator.html") +
        mustache(data, "gradebook.html")

  }

  def generateErrorResponse(contextPath: String, templateName: String, language: String) = {
    val translations = getTranslation("error", language)

    val data = Map("contextPath" -> contextPath, "language" -> language) ++ translations
    mustache(data, templateName)
  }
}