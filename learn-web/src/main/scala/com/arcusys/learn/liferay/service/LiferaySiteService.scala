package com.arcusys.learn.liferay.service

import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.liferay.portal.service.GroupLocalServiceUtil
import com.liferay.portal.kernel.dao.orm.QueryUtil

class LiferaySiteService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  val jsonModel = new JsonModelBuilder[com.liferay.portal.model.Group](site =>
    Map(
      "siteID" -> site.getGroupId,
      "title" -> site.getName,
      "url" -> site.getFriendlyURL,
      "description" -> site.getDescription.replace("\n", " ")
  ))

  get("/") {
    val companyId = parameter("companyID").longRequired
    jsonModel(getSites(companyId))
  }

  private def getSites(companyId: Long) = {
    GroupLocalServiceUtil.getCompanyGroups(companyId, QueryUtil.ALL_POS,  QueryUtil.ALL_POS).toArray.filter(x => {
      val site = x.asInstanceOf[com.liferay.portal.model.Group]
      val url = site.getFriendlyURL
      site.isSite && site.isActive &&
      //remove control panel
        url != "/control_panel"
    }).map(i => i.asInstanceOf[com.liferay.portal.model.Group])
  }
}
