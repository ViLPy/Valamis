package com.arcusys.learn.view

import javax.portlet.{RenderRequest, RenderResponse}

import com.arcusys.learn.facades.UserFacadeContract
import com.arcusys.learn.liferay.permission.{PermissionUtil, ViewAllPermission}
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.learn.view.extensions._
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.valamis.lrs.service.LrsClientManager
import org.apache.http.client.RedirectException

class LearningTranscriptView extends OAuthPortlet with BaseView{

  val userFacade = inject[UserFacadeContract]
  val lrsReader = inject[LrsClientManager]

  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {

    try {
      val scope = getSecurityData(request)
      val language = LiferayHelpers.getLanguage(request)

      val endpointData = getEndpointInfo(request)

      val user =
        lrsReader.statementApi(
          userFacade.byId(_, scope.userId.toInt, isShortResult = true, withOpenBadges = false) match {
          case userShortResponse: UserShortResponse =>
            userShortResponse
          case _ =>
            throw new Exception("User response was not short.")
        },
          endpointData.auth)

      val translations = getTranslation("curriculum", language)
      val data = Map(
        "userName" -> user.name,
        "userPicture" -> user.picture,
        "userPageUrl" -> user.pageUrl,
        "viewAllPermission" -> PermissionUtil.hasPermission(scope.courseId, scope.portletId, scope.primaryKey, ViewAllPermission),
        "language" -> language) ++ translations ++ scope.data

      response.getWriter.println(
        getTemplate("/templates/2.0/learning_transcript_template.html") +
          getTemplate("/templates/2.0/user_select_templates.html") +
          getTemplate("/templates/2.0/paginator.html") +
          generateResponse(data, "learning_transcript.html"))
    }
    catch {
      case e: RedirectException =>
        response.getWriter.println(s"""<script type="text/javascript">
            window.location.replace("${e.getMessage}");
          </script>""")
    }
  }

  def generateResponse(data: Map[String, Any], templateName: String, language: String = "en", resURL: String = "") = {
    mustache(data, templateName)
  }
}
