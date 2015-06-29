package com.arcusys.learn.view

import javax.portlet.{RenderRequest, RenderResponse}
import com.arcusys.learn.facades.UserFacadeContract
import com.arcusys.learn.view.extensions.{OAuthPortlet, BaseView}
import com.arcusys.learn.view.liferay.LiferayHelpers

class ValamisStudySummaryView extends OAuthPortlet with BaseView {
  override def destroy() {}

  override def doView(request: RenderRequest, response: RenderResponse): Unit = {
    val userFacade = inject[UserFacadeContract]

    val out = response.getWriter
    val language = LiferayHelpers.getLanguage(request)
    val securityScope = getSecurityData(request)
    val translations = getTranslation("dashboard", language)

    val userInfo = userFacade.getUserShortInfo(securityScope.userId)

    val data = translations ++ securityScope.data + ("language" -> language) ++
      Map(
        "userName" -> userInfo.name,
        "userPageUrl" -> userInfo.pageUrl,
        "userPicture" -> userInfo.picture
      )

    out.println( mustache( data, "valamis_study_summary.html" ) )

  }

}
