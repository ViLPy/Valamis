package com.arcusys.learn.liferay.service

import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.liferay.portal.service.{ImageLocalServiceUtil, UserLocalServiceUtil, GroupLocalServiceUtil}
import com.liferay.portal.kernel.dao.orm.QueryUtil

/**
 * User: Yulia.Glushonkova
 * Date: 20.06.13
 */
class LiferayUserService (configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  val jsonModel = new JsonModelBuilder[com.liferay.portal.model.User](user =>{
    val portrait = "/image/user_male_portrait?img_id=" + user.getPortraitId
    val displayUrl = if (user.getGroup().getPublicLayoutsPageCount() > 0) "/web/" + user.getScreenName else ""

  Map(
      "userID" -> user.getUserId,
      "name" -> user.getFullName,
      "email" -> user.getEmailAddress,
      "portrait" -> portrait,
      "userPublicPageUrl" -> displayUrl
  )})

  get("/") {
    jsonModel(getUsers())
  }

  private def getUsers() = {
    // only students?
    UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS,  QueryUtil.ALL_POS).toArray
      .map(x => x.asInstanceOf[com.liferay.portal.model.User])
      .sortBy(x=>x.getFullName).filter(x=>x.getFullName != "")
  }
}


