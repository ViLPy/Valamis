package com.arcusys.learn.view

//import com.arcusys.learn.liferay.services.GroupLocalServiceHelper

import com.arcusys.learn.facades.UserFacadeContract
import com.arcusys.learn.models.response.users.UserShortResponse
import com.arcusys.learn.util.MustacheSupport
import com.arcusys.learn.view.extensions.{ ConfigurableView, i18nSupport, TemplateCoupler }
import com.arcusys.learn.liferay.util.PortalUtilHelper
import java.io.FileNotFoundException
import javax.portlet.{ RenderResponse, RenderRequest, GenericPortlet }
import liferay.LiferayHelpers
import org.scalatra.ScalatraFilter

class LearningTranscriptView
    extends GenericPortlet
    with ScalatraFilter
    with MustacheSupport
    with i18nSupport
    with ConfigurableView
    with TemplateCoupler {

  val userFacade = inject[UserFacadeContract]

  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val language = LiferayHelpers.getLanguage(request)
    val path = request.getContextPath

    val userID = if (request.getRemoteUser != null) request.getRemoteUser.toInt else null.asInstanceOf[Int]

    val courseID = LiferayHelpers.getThemeDisplay(request).getLayout.getGroupId

    if (userID > 0) {
      val user = userFacade.byId(userID, true, false) match {
        case userShortResponse: UserShortResponse =>
          userShortResponse
        case _ =>
          throw new Exception("User response was not short.")
      } //.asInstanceOf[UserShortResponse]

      val translations = getTranslation("curriculum", language)
      val companyId = PortalUtilHelper.getCompanyId(request)

      val hasTeacherPermissions = userRoleService.hasTeacherPermissions(userID, courseID)
      val data = Map("contextPath" -> path, "userID" -> userID, "userName" -> user.name, "userPicture" -> user.picture, "userPageUrl" -> user.pageUrl,
        "companyID" -> companyId, "courseID" -> courseID, "isTeacher" -> hasTeacherPermissions, "language" -> language) ++ translations

      response.getWriter.println(getTemplate("/templates/2.0/learning_transcript_template.html") + generateResponse(data, "learning_transcript.html"))
      //      response.getWriter.println(getTemplate("/templates/2.0/latest_statements_templates.html") + generateResponse(data, "latest_statements.html", language))

    } else {
      val translations = getTranslation("error", language)
      response.getWriter.println(mustache(translations, "scorm_nopermissions.html"))
    }
  }

  def generateResponse(data: Map[String, Any], templateName: String, language: String = "en", resURL: String = "") = {
    /*    val translations = try {
      getTranslation("/i18n/statementReport_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/statementReport_en")
      case _                        => Map[String, String]()
    }*/
    //    val data = Map("contextPath" -> contextPath, "language" -> language, "resourceURL" -> resURL) ++ translations
    mustache(data, templateName)
  }

  private def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _                        => Map[String, String]()
    }
  }

}
