package com.arcusys.learn.liferay

import com.arcusys.learn.liferay.LiferayClasses._
import com.liferay.portal.service.UserLocalServiceUtil
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter

/**
 * Created by mminin on 26.06.15.
 */
trait LBaseSocialActivityInterpreter extends BaseSocialActivityInterpreter{

  type Context = LServiceContext

  def getUser(context: Context): LUser = {
    UserLocalServiceUtil.getUser(context.getUserId)
  }
}
