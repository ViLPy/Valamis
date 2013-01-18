package com.arcusys.learn.view

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import com.arcusys.learn.scorm.tracking.model.User
import java.io.FileNotFoundException
import com.arcusys.scorm.lms.UserManagement
import com.liferay.portal.service.GroupLocalServiceUtil
import com.liferay.portal.util.PortalUtil
import com.liferay.portal.kernel.dao.orm.QueryUtil

class AdminView extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport {
  override def destroy() {}

  val userStorage = StorageFactory.userStorage

  override def doView(request: RenderRequest, response: RenderResponse) {
    val userUID = request.getRemoteUser
    val theme = LiferayHelpers.getThemeDisplay(request)
    val courseID = theme.getLayout.getGroupId
    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    if (UserManagement.isAdmin(userUID.toInt, courseID))
    {
      val groupID = theme.getScopeGroupId
      //val pagePlid = theme.getLayout.getPlid
     // ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
     // PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
     // String portletId = portletDisplay.getId();
     // val groups = GroupLocalServiceUtil.search(PortalUtil.getCompanyId(request), null, null,
     //   null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

      //val pageID = theme.getLayout.getPrimaryKey
      //val portletID = theme.getPortletDisplay.getId
      val translations = getTranslation("admin", language)
      val data = Map("contextPath" -> request.getContextPath, "userID" -> userUID, "groupID" -> groupID, "isAdmin" -> true,
        "language" -> language, "courseID" ->courseID, "isPortlet" -> true) ++ translations
      out.println(generateResponse(data, "scorm_admin.html"))
    }
    else{
      val translations = getTranslation("error", language)
      val data = Map("contextPath" -> request.getContextPath, "language" -> language) ++ translations
      out.println(generateResponse(data, "scorm_nopermissions.html"))
    }
  }

  def generateResponse(data: Map[String, Any], templateName: String) = {
    mustache(data, templateName)
  }

  private def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/"+ view +"_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/"+view+"_en")
      case _ => Map[String, String]()
    }
  }
}