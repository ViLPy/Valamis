package com.arcusys.learn.view

import java.net.URLEncoder
import javax.portlet._

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.WebKeysHelper
import com.arcusys.learn.liferay.services.JournalArticleLocalServiceHelper
import com.arcusys.learn.view.extensions.BaseView
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.valamis.settings.service.SettingService
import com.arcusys.valamis.utils.JsonSupport
import com.arcusys.valamis.utils.serialization.JsonHelper

class ValamisSlidesEditorView extends GenericPortlet with BaseView with JsonSupport {
  private lazy val settingManager = inject[SettingService]

  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) {
    val scope = getSecurityData(request)
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val translations = getTranslation("valamisSlidesEditor", language)
    val googleClientId = settingManager.getGoogleClientId()
    val googleAppId = settingManager.getGoogleAppId()
    val googleApiKey = settingManager.getGoogleApiKey()

    val data = Map(
      "language" -> language,
      "translations" -> JsonHelper.toJson(translations),
      "actionURL" -> response.createResourceURL(),
      "googleClientId" -> googleClientId,
      "googleAppId" -> googleAppId,
      "googleApiKey" -> googleApiKey
    ) ++ translations ++ scope.data

    out.println(mustache(data, "/js2.0/lesson-designer/globalVariables.html") +
      getTemplate("/templates/2.0/paginator.html") +
      getTemplate("/templates/2.0/file_uploader.html") +
      getTemplate("/templates/2.0/image_gallery_templates.html") +
      getTemplate("/templates/2.0/valamis_slides_editor_main_templates.html") +
      mustache(data, "valamis_slides_editor.html"))

  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    val scope = getSecurityData(request)
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val translations = getTranslation("valamisSlidesEditor", language)

    val data = Map(
      "language" -> language,
      "translations" -> JsonHelper.toJson(translations)
    ) ++ translations ++ scope.data

    out.println(getTemplate("/templates/2.0/file_uploader.html") +
      mustache(data, "valamis_slides_editor_settings.html"))

  }

  override def serveResource(request: ResourceRequest, response: ResourceResponse) {
    val groupID = request.getParameter("groupID").toLong
    val articleID = request.getParameter("articleID")
    val articleLanguage = request.getParameter("language")
    val td = request.getAttribute(WebKeysHelper.THEME_DISPLAY).asInstanceOf[LThemeDisplay]
    val text = JournalArticleLocalServiceHelper.getArticleContent(groupID, articleID, "view", articleLanguage, td)

    response.getWriter.println(json(Map("text" -> URLEncoder.encode(text, "UTF-8"))).get)
  }
}
