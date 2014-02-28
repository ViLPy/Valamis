package com.arcusys.learn.view.achievement

import javax.portlet.{RenderResponse, RenderRequest}
import com.arcusys.learn.view.{BaseCurriculum}

/**
 * Created with IntelliJ IDEA.
 * User: iliya.tryapitsin
 * Date: 08.01.14
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 */
class AchievementAdmin extends BaseCurriculum {

    override def doView(
      request: RenderRequest,
      response: RenderResponse) {

        super.renderAdminView(
          request,
          response,
          "achievement_admin.html")
    }
}
