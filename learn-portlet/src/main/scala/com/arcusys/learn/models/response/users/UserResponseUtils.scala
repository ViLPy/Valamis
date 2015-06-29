package com.arcusys.learn.models.response.users

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import scala.util.Try

/**
 * Created by Iliya Tryapitsin on 03.06.2014.
 */
object UserResponseUtils {
  def getPortraitUrl(user: LUser): String = {
    "/image/user_male_portrait?img_id=" + user.getPortraitId +
      "&img_id_token=" + UserLocalServiceHelper().getPortraitToken(user) +
      "&t=" + UserLocalServiceHelper().getPortraitTime(user.getPortraitId)
  }

  def getPublicUrl(user: LUser) = {
    Try(if (user.getGroup().getPublicLayoutsPageCount() > 0) "/web/" + user.getScreenName else "").getOrElse("")
  }
}
