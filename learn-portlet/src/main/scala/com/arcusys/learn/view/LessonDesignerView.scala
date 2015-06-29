package com.arcusys.learn.view

import javax.portlet._

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.WebKeysHelper
import com.arcusys.learn.liferay.permission.{PermissionUtil, PublishPermission}
import com.arcusys.learn.liferay.services.JournalArticleLocalServiceHelper
import com.arcusys.learn.view.extensions.BaseView
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.valamis.util.JsonSupport

class LessonDesignerView extends GenericPortlet with BaseView with JsonSupport {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse) = {
    val language = LiferayHelpers.getLanguage(request)

    val out = response.getWriter
    val securityScope = getSecurityData(request)
    var map = securityScope.data
    map = map + ("language" -> language)

    val translations = getTranslation("lessonDesigner", language)

    val publishPermission = PermissionUtil.hasPermission(securityScope.courseId, securityScope.portletId, securityScope.primaryKey, PublishPermission)
    map = map ++ Map(
      "isAdmin" -> securityScope.permissionToModify,
      "actionURL" -> response.createResourceURL(),
      "permissionToPublish" -> publishPermission
    ) ++ translations ++ Map(
        "translations" -> JsonSupport.json(translations).get
      )
    out.println(mustache(map, "/js2.0/lesson-designer/globalVariables.html") +
      getTemplate("/templates/2.0/question_tree_templates.html") +
      getTemplate("/templates/2.0/lesson_designer_templates.html") +
      getTemplate("/templates/2.0/file_uploader.html") +
      getTemplate("/templates/2.0/paginator.html") +
      getTemplate("/templates/2.0/image_gallery_templates.html") +
      mustache(map, "lesson_designer.html")
    )
  }

  override def doEdit(request: RenderRequest, response: RenderResponse) {
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)

    val data = Map("contextPath" -> request.getContextPath,
      "pageID" -> themeDisplay.getLayout.getPrimaryKey,
      "language" -> language) ++ getTranslation("lessonDesigner", language)
    out.println(getTemplate("/templates/2.0/file_uploader.html") +
      mustache(data, "lesson_designer_settings.html"))

  }

  override def serveResource(request: ResourceRequest, response: ResourceResponse) {
    val groupID = request.getParameter("groupID").toLong
    val articleID = request.getParameter("articleID")
    val articleLanguage = request.getParameter("language")
    val td = request.getAttribute(WebKeysHelper.THEME_DISPLAY).asInstanceOf[LThemeDisplay]
    val text = JournalArticleLocalServiceHelper.getArticleContent(groupID, articleID, "view", articleLanguage, td)

    response.getWriter.println(json(Map("text" -> text)).get)
  }
}