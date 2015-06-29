package com.arcusys.learn.controllers.views

import javax.portlet.{ RenderRequest, GenericPortlet }
import org.scalatra.ScalatraFilter
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.service.util.MustacheSupport
import com.arcusys.learn.view.liferay.LiferayHelpers

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */
abstract class BaseController extends GenericPortlet with ScalatraFilter with MustacheSupport with i18nSupport with ConfigurableView with Injectable {

  implicit val formats = org.json4s.DefaultFormats

  override def destroy() {}

  protected def getUser(implicit req: RenderRequest) = LiferayHelpers.getUser(req)
  protected def getLanguage(implicit req: RenderRequest) = LiferayHelpers.getLanguage(req)
  protected def getThemeDisplay(implicit req: RenderRequest) = LiferayHelpers.getThemeDisplay(req)
  protected def getCourseId(implicit req: RenderRequest) = LiferayHelpers.getThemeDisplay(req).getLayout.getGroupId
  protected def getUserUID(implicit req: RenderRequest) =
    if (request.getRemoteUser != null) request.getRemoteUser.toInt
    else null.asInstanceOf[Int]

}
